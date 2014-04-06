package org.octopus

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTP;
def ftpUrl = 'ftp://ftp-trace.ncbi.nlm.nih.gov/sra/sra-instant/reads/ByExp/sra/SRX%2FSRX469%2FSRX469920'
def pattern = ~/\S*:\/\/([^\/]*)(\S*)/
def matcher = pattern.matcher(ftpUrl)
def domain = ""
def remoteDir = ""
def currentDir = ""
while (matcher.find()) {
	domain = matcher.group(1)
	remoteDir = matcher.group(2)
	println "domain"+domain
	println "remoteDir"+remoteDir
	
}

FTPClient client = new FTPClient();
FileInputStream fis = null
def rootDir = 'D:\\ftp'
def tempDir = 'D:\\temp'
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

def dirAndDownFile(FTPClient client,rootDir){
	def currentDir = rootDir
	FTPFile[] fileList = client.listFiles()
	fileList.each {
		println "1111111111111"+currentDir
		if(it.isFile()){
			println "222222222222"+currentDir
			File remoteDir = new File("D:\\ftp${currentDir}")
			remoteDir.mkdirs()
			String fileName = it.name
			File f = new File('D:\\temp\\', fileName);
			BufferedOutputStream bos = null;
			InputStream fin = null
			try {
				bos = new BufferedOutputStream(new FileOutputStream(f));
				boolean isSuccess = client.retrieveFile(it.getName(), bos);
				if(isSuccess){
					Runtime rt = Runtime.getRuntime()
					println 'cmd /c move '+'D:\\temp\\'+fileName+' '+remoteDir.absolutePath
					rt.exec('cmd /c move '+'D:\\temp\\'+fileName+' '+remoteDir.absolutePath)
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