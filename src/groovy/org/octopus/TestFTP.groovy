import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


class TestFTP {

	static main(args) {
		println "Aa"
		download()
		println "end"
	}
	
	public static int download() throws Exception {
		
		  FTPClient client = null;
		  BufferedOutputStream bos = null;
		  File fPath  = null;
		  File fDir = null;
		  File f   = null;
		  //http://www.ncbi.nlm.nih.gov/geo/query/acc.cgi?acc=GSM1295560&targ=self&form=xml&view=quick
		  def url  = "ftp-trace.ncbi.nlm.nih.gov"  //서버 ip
		  def id   = "anonymous"// ftp 접속 id
		  def pwd  = "" // ftp 접속 비밀번호
		  def remoteDir  ="/sra/sra-instant/reads/ByExp/sra/SRX/SRX396/SRX396744/"//다운로드 경로
		  def filePath = "SRR1055880.sra"
		  def fileName = "SRR1055880.sra"
		  int result = -1;
		  
		  try{
		   
		   f = new File("D:\\download", "test1.sra");
		   
		   client = new FTPClient();
		   client.setControlEncoding("UTF-8");
		   client.connect(url, 21);
		   
		   int resultCode = client.getReplyCode();
		
		   if (FTPReply.isPositiveCompletion(resultCode) == false){
			client.disconnect();
			println("FTP 서버에 연결할 수 없습니다.");
		   }
		   else
		   {
			client.setSoTimeout(5000);
			boolean isLogin = client.login(id, pwd);
			
			if (isLogin == false){
			 println("FTP 서버에 로그인 할 수 없습니다.");
			}
			
			client.setFileType(FTP.BINARY_FILE_TYPE);
			def list = client.listNames(remoteDir)
			list.each {
				println "fffff"+it
				client.changeWorkingDirectory(it)
				def listFiles = client.listFiles()
				listFiles.each {
					println "22222"+it.getName()
					bos = new BufferedOutputStream(new FileOutputStream(f));
					boolean isSuccess = client.retrieveFile(it.getName(), bos);
					
					if (isSuccess){
					 result = 1; // 성공
					}
					else{
					 println("파일 다운로드를 할 수 없습니다.");
					}
				}
			}
			
			client.logout();
		   } // if ~ else
		  }
		  catch (Exception e){
		   println("FTP Exception : " + e);
		  }
		  finally{
		   if (bos != null) try {bos.close();} catch (Exception e) {}
		   if (client != null && client.isConnected()) try {client.disconnect();} catch (Exception e) {}
		   
		   return result;
		  } // try ~ catch ~ finally
		 } // download()
	

}

