package org.octopus
import grails.converters.JSON;
import groovy.json.JsonBuilder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


Document projectDocument = Jsoup.connect('http://www.ncbi.nlm.nih.gov/geo/query/acc.cgi?acc=GSM1095383')
.timeout(60000)
.get();
Project project = makeProject(projectDocument)

println project.iid
println project.status
println project.title
//http://www.ncbi.nlm.nih.gov/portal/utils/file_backend.cgi?Db=gds&HistoryId=NCID_1_670979906_130.14.18.97_5555_1394257072_1113654523_0MetA0_S_HStore&QueryKey=2&Sort=&Filter=all&CompleteResultCount=2189&Mode=file&View=docsum&p$l=Email&portalSnapshot=%2Fprojects%2FGEO%2FGeoProd%401.15&BaseUrl=&PortName=live&FileName=
def makeProject(projectDocument){
	Project project = new Project();
	project.iid = "GSM1095383"
	def contents = []
	def projectContents = projectDocument.select("tr[valign=top] ");
	projectContents.each{
		def children = it.children()
		if(children.size() == 4){
			def hashMap = new HashMap()
			println "children"+children[0].text().trim()
			if(children[0].text().trim() != "Supplementary file"){
				children.eachWithIndex { oneResult,index->
					if(index == 0){
						println "SupplementaryFileName="+oneResult.text().trim()
						hashMap.put("SupplementaryFileName",oneResult.text().trim())
					}else if(index == 1){
						println "SupplementaryFileSize="+oneResult.text().trim()
						hashMap.put("SupplementaryFileSize",oneResult.text().trim())
					}else if(index == 2){
						def result = oneResult.html().trim()
						def patternFtp = ~/<a href="(\S*)">\(ftp\)/
						def matcherFtp = patternFtp.matcher(result)
						if (matcherFtp.find()) {
							println "ftpDownload"+matcherFtp.group(1).toString()
							hashMap.put("ftpDownload",matcherFtp.group(1).toString())
						}
						
						def patternHttp = ~/<a href="(\S*)">\(http\)/
						def matcherHttp = patternHttp.matcher(result)
						if (matcherHttp.find()) {
							println "httpDownload"+matcherHttp.group(1).toString()
							hashMap.put("ftpDownload",matcherHttp.group(1).toString())
						}
						hashMap.put("ftpDownload",oneResult.html().trim())
					}else if(index == 3){
						println "fileTypeResource="+oneResult.text().trim()
						hashMap.put("fileTypeResource",oneResult.text().trim())
					}
				}
				contents.add(hashMap)
				
			}
		}
	}
	
	
	contents.each{
		if(it.title == "Status"){
			project.status = it.contents
		}else if(it.title == "Title"){
			project.title = it.contents
		}else if(it.title == "Sample type"){
			project.sampleType = it.contents
		}else if(it.title == "Source name"){
			project.sourceName = it.contents
		}else if(it.title == "Organism"){
			project.organism = it.contents
		}else if(it.title == "Characteristics"){
			project.characteristics = it.contents
		}else if(it.title == "Treatment protocol"){
			project.treatmentProtocol = it.contents
		}else if(it.title == "Growth protocol"){
			project.growthProtocol = it.contents
		}else if(it.title == "Extracted molecule"){
			project.extractedMolecule = it.contents
		}else if(it.title == "Extraction protocol"){
			project.extractionProtocol = it.contents
		}else if(it.title == "Library strategy"){
			project.libraryStrategy = it.contents
		}else if(it.title == "Library source"){
			project.librarySource = it.contents
		}else if(it.title == "Library selection"){
			project.librarySelection = it.contents
		}else if(it.title == "Instrument model"){
			project.instrumentModel = it.contents
		}else if(it.title == "Data processing"){
			project.dataProcessing = it.contents
		}else if(it.title == "Submission date"){
			project.submissionDate = it.contents
		}else if(it.title == "Last update date"){
			project.lastUpdateDate = it.contents
		}else if(it.title == "Contact name"){
			project.contactName = it.contents
		}else if(it.title == "E-mail"){
			project.email = it.contents
		}else if(it.title == "Phone"){
			project.phone = it.contents
		}else if(it.title == "Organization name"){
			project.organizationName = it.contents
		}else if(it.title == "Department"){
			project.department = it.contents
		}else if(it.title == "Lab"){
			project.lab = it.contents
		}else if(it.title == "Street address"){
			project.streetAddress = it.contents
		}else if(it.title == "City"){
			project.city = it.contents
		}else if(it.title == "State/province"){
			project.StateProvince = it.contents
		}else if(it.title == "ZIP/Postal code"){
			project.zipPostalCode = it.contents
		}else if(it.title == "Country"){
			project.country = it.contents
		}else if(it.title == "Platform ID"){
			project.platformId = it.contents
		}else if(it.title == "BioSample"){
			project.bioSample = it.contents
		}else if(it.title == "SRA"){
			project.sra = it.contents
		}
	}
	return project
}