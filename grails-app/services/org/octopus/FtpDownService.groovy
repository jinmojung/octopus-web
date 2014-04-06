package org.octopus

import grails.transaction.Transactional;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient
import org.apache.commons.net.ftp.FTPFile
import org.apache.commons.net.ftp.FTPReply;

class FtpDownService {
	static transactional = false
	def grailsApplication
	
	@Transactional
	def ftpDownFromProject(Project project){
		def fileList = project.supplementaryFiles
		project.browsingStatus = Const.BROWSING_STATUS_FTP_DOWNLOADING
		project.save(flush:true)
		fileList.each{
			if(it.fileTypeResource.indexOf("SRA") != -1){
				println it.fileTypeResource
				def ftpUrl = it.ftpDownload
				def pattern = ~/\S*:\/\/([^\/]*)(\S*)/
				def matcher = pattern.matcher(ftpUrl)
				def domain = ""
				def remoteDir = ""
				def currentDir = ""
				def reply = null
				while (matcher.find()) {
					domain = matcher.group(1)
					remoteDir = matcher.group(2)
					println "domain"+domain
					println "remoteDir"+remoteDir
					
				}
				
				FTPClient client = new FTPClient();
				FileInputStream fis = null
				try {
					client.connect(domain)
					reply = client.getReplyCode();
					if (!FTPReply.isPositiveCompletion(reply)){
						client.disconnect();
						println("FTP server refused connection.");
					}
					def login = client.login("anonymous", "")
					client.setFileType(FTP.BINARY_FILE_TYPE)
					client.enterLocalPassiveMode()
					if (login){
						currentDir = remoteDir.replaceAll('%2F', '/')
						client.changeWorkingDirectory(currentDir)
						dirAndDownFile(client,currentDir)
						client.logout()
					}else{
						println("FTP server refused login.");
					}
				} catch (Exception e) {
					e.printStackTrace()
				}finally {
					if (client != null && client.isConnected()) {
						try { client.disconnect(); } catch (Exception e) {}
					}
				}
			}
		}
		project.browsingStatus = Const.BROWSING_STATUS_FTP_DOWNLOAD_FINISH
		project.save(flush:true)
	}
	
	
	def dirAndDownFile(FTPClient client,rootDir){
	def currentDir = rootDir
	FTPFile[] fileList = client.listFiles()
	fileList.each {
		println "1111111111111"+currentDir
		if(it.isFile()){
			println "222222222222"+currentDir
			def moveToDir = grailsApplication.config.ftp.dir
			def tempDir = grailsApplication.config.ftp.temp.dir
			def moveCmd = grailsApplication.config.move.cmd
			println "rootDir"+rootDir
			println "tempDir"+tempDir
			File remoteDir = new File("${moveToDir}${currentDir}")
			remoteDir.mkdirs()
			String fileName = it.name
			File f = new File(tempDir, fileName);
			BufferedOutputStream bos = null;
			InputStream fin = null
			try {
				bos = new BufferedOutputStream(new FileOutputStream(f));
				boolean isSuccess = client.retrieveFile(it.getName(), bos);
				if(isSuccess){
					Runtime rt = Runtime.getRuntime()
					println "${moveCmd} ${tempDir}${fileName} ${remoteDir.absolutePath}"
					rt.exec("${moveCmd} ${tempDir}${fileName} ${remoteDir.absolutePath}")
				}
			} catch(Exception e) {
				e.printStackTrace()
			} finally {
				if (fin != null) try { fin.close(); } catch(Exception ex) {}
				if (bos != null) try { bos.close(); } catch(Exception ex) {}
			}
		}
		if(it.isDirectory()){
			def nextDir = "${rootDir}/${it.name}"
			println "3333333333333"+nextDir
			client.changeWorkingDirectory(nextDir)
			dirAndDownFile(client,nextDir)
		}
	}
}

}
