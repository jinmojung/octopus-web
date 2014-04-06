import javax.servlet.http.HttpServletRequest;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;


class TestShell {

	static main(args) {
		println "Aa"
		download()
		println "end"
	}
	
	public static int download() throws Exception {
		String[] env = {"PATH=D:\\grails\\jdk1.7.0_25"};
		String cmd = "D:\\down\\코드맵핑_(상담관리)_v1.0.0.11.xlsx";  //e.g test.sh -dparam1 -oout.txt
		Process process = Runtime.getRuntime().exec(cmd, env);
	}
}

