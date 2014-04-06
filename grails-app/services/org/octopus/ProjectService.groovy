package org.octopus

import grails.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class ProjectService {
	static transactional = false
	
	
	def getTotalProjectIids(url){
		def projectIids = []
		def totalProject = Jsoup.
		connect(url).timeout(Constants.TIMEOUT).get()
		String result = totalProject.toString()
		int totalProjectCnt = 0
		def pattern = ~/Sample Accession:\s(GSM\d+)/
		def matcher = pattern.matcher(result)
		while (matcher.find()) {
			projectIids.add(matcher.group(1).toString())
			totalProjectCnt++
		}
		
		return projectIids
	}
	
	@Transactional
	def saveProject(iid){
		def projectDocument = getDocument(iid)
		Project project = makeProject(projectDocument,iid)
		def supplementaryFiles = makeSupplementaryFile(projectDocument)
		supplementaryFiles.each{
			project.addToSupplementaryFiles(it)
		}
		project.save(flush :true,failOnError :true)
		println project
	}

	def getDocument(iid){
		Document projectDocument = Jsoup.
		connect('http://www.ncbi.nlm.nih.gov/geo/query/acc.cgi?acc='+iid)
		.timeout(Constants.TIMEOUT).get()
		return projectDocument
	}
	
	def makeSupplementaryFile(projectDocument){
		def supplementaryFiles = []
		def projectContents = projectDocument.select("tr[valign=top] ")
		projectContents.each{
			def children = it.children()
			if(children.size() == 4){
				if(children[0].text().trim() != "Supplementary file"){
					SupplementaryFile supplementaryFile = new SupplementaryFile()
					children.eachWithIndex { oneResult,index->
						if(index == 0){
							supplementaryFile.name = oneResult.text().trim()
						}else if(index == 1){
							supplementaryFile.size = oneResult.text().trim()
						}else if(index == 2){
							def result = oneResult.html().trim()
							def patternFtp = ~/<a href="(\S*)">\(ftp\)/
							def matcherFtp = patternFtp.matcher(result)
							if (matcherFtp.find()) {
								supplementaryFile.ftpDownload = matcherFtp.group(1).toString()
							}
							def patternHttp = ~/<a href="(\S*)">\(http\)/
							def matcherHttp = patternHttp.matcher(result)
							if (matcherHttp.find()) {
								supplementaryFile.httpDownload = matcherHttp.group(1).toString()
							}
						}else if(index == 3){
							supplementaryFile.fileTypeResource = oneResult.text().trim()
						}
					}
					supplementaryFiles.add(supplementaryFile)
					
				}
			}
		
		}
		return supplementaryFiles
	}
	def makeProject(projectDocument,iid){
		Project project = new Project()
		project.iid = iid
		def contents = []
		def projectContents = projectDocument.select("tr[valign=top] ")
		projectContents.each{
			def children = it.children()
			if(children.size() == 2){
				def hashMap = new HashMap()
				children.eachWithIndex { oneResult,index->
					if(index == 0){
						hashMap.put("title",oneResult.text().trim())
					}else{
						hashMap.put("contents",oneResult.text().trim())
					}
				}
				contents.add(hashMap)
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
				project.stateProvince = it.contents
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

}
