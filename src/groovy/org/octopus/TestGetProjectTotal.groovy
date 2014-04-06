package org.octopus
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;


def totalProject = Jsoup.connect('http://www.ncbi.nlm.nih.gov/portal/utils/file_backend.cgi?Db=gds&HistoryId=NCID_1_14881859_130.14.22.33_5555_1393052711_655119526_0MetA0_S_HStore&QueryKey=3&Sort=&Filter=all&CompleteResultCount=2187&Mode=file&View=docsum&p$l=Email&portalSnapshot=%2Fprojects%2FGEO%2FGeoProd%401.15&BaseUrl=&PortName=live&FileName=').
timeout(60000).get();
//println totalProject
String result = totalProject.toString()


int totalProjectCnt = 0
def pattern = ~/Sample Accession:\s(GSM\d+)/
def matcher = pattern.matcher(result)
while (matcher.find()) {
	println "matcher.group(1)"+matcher.group(1)
	totalProjectCnt++
}

println "totalProjectCnt"+totalProjectCnt
