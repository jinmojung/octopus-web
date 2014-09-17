package org.octopus



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.octopus.dto.TreeDto
import grails.converters.*

class TestController {
	def projectService
	def ftpDownService
	def hubService
	def springSecurityService
	def bigWigService

    def index() {
		println "index"+params
		def totalProjectIids = projectService.getTotalProjectIids("${params.url}&HistoryId=${params.HistoryId}&QueryKey=${params.QueryKey}&Filter=${params.Filter}&CompleteResultCount=${params.CompleteResultCount}&Mode=${params.Mode}&View=${params.View}&PortName=${params.PortName}"+'&p$l='+params.p$l)
		int i = 0
		totalProjectIids.each{
			try {
				i++
				projectService.saveProject(it)
				println "save "+ i
			} catch (Exception e) {
				e.printStackTrace()
			}
		}
	}
	
	def ftpDownFromProject(){
		println "index"+params
		def projectList = Project.list()
		int i = 0
		projectList.each{
			try {
				i++
				ftpDownService.ftpDownFromProject(it)
			} catch (Exception e) {
				e.printStackTrace()
			}
		}
	}
	
	def test(){
		println "test"
		def projectList = Project.findAllByBrowsingStatus(Const.BROWSING_STATUS_MAKE_UCSC_FINISH)
		def madeHubPath = hubService.makeTempHub(projectList)
		println madeHubPath
		
	}
	
	def read(){
		println "read"
		ExcelBuilder excelBuilder = new ExcelBuilder('Octopus_list.xlsx',null).eachLine([labels:true,sheet:0]) {
			try{
				if(cell(5)!=null){
					try {
						String Antibody = cell(1).toString()
						String Species = cell(2).toString()
						String Tissue = cell(3).toString()
						String GSM = cell(5).toString()
						String File = cell(7).toString()
						def projecct = Project.findByIid(GSM)
						if(projecct){
							if(File != 'null'){
								projecct.browsingStatus = Const.BROWSING_STATUS_MAKE_UCSC_FINISH
								projecct.ucscFilePath = File
								if(Antibody != 'null'){
									projecct.antibody = Antibody
								}
								if(Species != 'null'){
									projecct.species = Species
								}
								if(Tissue != 'null'){
									projecct.tissue = Tissue
								}
								projecct.save(flush:true)
								println "1111111"
							}
						}else{
							println "2222222222222"
							projectService.saveProject(GSM)
						}
						println "GSM "+GSM
						println "File "+File
					} catch (Exception e) {
						e.printStackTrace()
					}
				}
			}catch (Exception e) {
				e.printStackTrace()
			}
		}
	}
	
	def update(){
		println "update"
		def projectList = Project.list()
		int i = 0
		println projectList.size()
		projectList.each {
			println i
//			if(it.ucscFilePath != null && it.ucscFilePath != ""){
//				it.ucscFilePath = "http://octopus-explorer.com/ucsc/bigWig/"+it.ucscFilePath
//				it.save(flush:true)
//				println "it.ucscFilePath != null"
//			}
			if(it.ucscFilePath == "http://octopus-explorer.com/ucsc/bigWig/http://octopus-explorer.com/ucsc/bigWig/"){
				it.ucscFilePath = ""
				it.save(flush:true)
				println 'it.ucscFilePath == "http://octopus-explorer.com/ucsc/bigWig/"'
			}
			i++
		}
	}
	
	
	def read2(){
		println "read2"
		ExcelBuilder excelBuilder = new ExcelBuilder('Octopus_list3.xlsx',null).eachLine([labels:true,sheet:0]) {
			try{
				if(cell(5)!=null){
					try {
						String Antibody = cell(1).toString()
						String Species = cell(2).toString()
						String Tissue = cell(3).toString()
						String GSM = cell(5).toString()
						String File = cell(7).toString()
						Project projecct = new Project()
						if(GSM != 'null'){
							projecct.iid = GSM
						}
						if(Antibody != 'null'){
							projecct.antibody = Antibody
						}
						if(Species != 'null'){
							projecct.species = Species
						}
						if(Tissue != 'null'){
							projecct.tissue = Tissue
						}
						projecct.ucscFilePath = File
						projecct.save()
						
						println "projecct "+projecct
					} catch (Exception e) {
						e.printStackTrace()
					}
				}
			}catch (Exception e) {
				e.printStackTrace()
			}
		}
	}
	
	def encode(){
		render springSecurityService.encodePassword(params.pw)
	}
	
	def search(){
		def projectList = []
		def keyword = params.keyword
		if(keyword != null && keyword != ''){
			if(keyword.indexOf("_") != -1){
				def keywordSplit = keyword.split("_")
				def antibody = keywordSplit[0]
				def species = keywordSplit[1]
				def tissue = keywordSplit[2]
				def projectListTemp = []
				projectListTemp = Project.createCriteria().list{
					eq("browsingStatus", Const.BROWSING_STATUS_MAKE_UCSC_FINISH)
					if(species != Const.NO_DATA){
						or{
							eq("species", species)
							eq("organism", species)
						}
					}
				}
				projectListTemp.each {
					if(antibody != Const.NO_DATA && tissue == Const.NO_DATA){
						if(it.antibody == antibody){
							projectList << it
						}
					}else if(antibody == Const.NO_DATA && tissue != Const.NO_DATA){
						if(it.tissue == tissue){
							projectList << it
						}
					}else if(antibody == Const.NO_DATA && tissue == Const.NO_DATA){
						projectList << it
					}else if(antibody != Const.NO_DATA && tissue != Const.NO_DATA){
						if(it.antibody == antibody && it.tissue == tissue){
							projectList << it
						}
					}
				}
			}else{
				projectList = Project.createCriteria().list{
					eq("browsingStatus", Const.BROWSING_STATUS_MAKE_UCSC_FINISH)
					or{
						like("characteristics", "%${keyword}%")
						like("organism", "%${keyword}%")
					}
				}
			}
		}
		render(view: "search", model: [projectList: projectList])
	}
	
	def browsing(){
		def projectList = []
		def ucscCheck = params.ucscCheck.split(",")
		ucscCheck.each {
			if(it != ''){
				projectList << Project.findByIid(it)
			}
		}
		def tempHubDir = bigWigService.makeTempHub(projectList)
		def madeHubPath = "http://genome.ucsc.edu/cgi-bin/hgTracks?org=mouse&db=mm9&hgt.customText=http://octopus-explorer.com/ucsc/bigWig/${tempHubDir}.txt"
		//redirect url: madeHubPath
		render(view: "browsing", model: [madeHubPath: madeHubPath])
	}
	
	def json(){
		def projectList = []
		def keyword = params.keyword
		if(keyword != null && keyword != ''){
			if(keyword.indexOf("_") != -1){
				def keywordSplit = keyword.split("_")
				def antibody = keywordSplit[0]
				def species = keywordSplit[1]
				def tissue = keywordSplit[2]
				def projectListTemp = []
				projectListTemp = Project.createCriteria().list{
					eq("browsingStatus", Const.BROWSING_STATUS_MAKE_UCSC_FINISH)
					if(species != Const.NO_DATA){
						or{
							eq("species", species)
							eq("organism", species)
						}
					}
				}
				projectListTemp.each {
					if(antibody != Const.NO_DATA && tissue == Const.NO_DATA){
						if(it.antibody == antibody){
							projectList << it
						}
					}else if(antibody == Const.NO_DATA && tissue != Const.NO_DATA){
						if(it.tissue == tissue){
							projectList << it
						}
					}else if(antibody == Const.NO_DATA && tissue == Const.NO_DATA){
						projectList << it
					}else if(antibody != Const.NO_DATA && tissue != Const.NO_DATA){
						if(it.antibody == antibody && it.tissue == tissue){
							projectList << it
						}
					}
				}
			}else{
				projectList = Project.createCriteria().list{
					eq("browsingStatus", Const.BROWSING_STATUS_MAKE_UCSC_FINISH)
					or{
						like("characteristics", "%${keyword}%")
						like("organism", "%${keyword}%")
					}
				}
			}
		}
		def projectListGroupByResult =projectList.groupBy({it.antibody}, {it.species}, {it.tissue})
		def result = []
		def antibodyInex = -1
		projectListGroupByResult.each{ antibody, species -> 
			def antibodyDto = new TreeDto(text:antibody)
			result.add(antibodyDto)
			antibodyInex++
			species.each{ species1, tissue -> 
				def speciesDto = new TreeDto(text:species1)
				antibodyDto.children.add(speciesDto)
				tissue.each{ tissue1, iid ->
					def tissueDto = new TreeDto(text:tissue1)
					speciesDto.children.add(tissueDto)
					iid.each{ iid1->
						def iidDto = new TreeDto(text:"<a href='"+request.contextPath +"/project/show/"+iid1.id+"'>$iid1.iid</a>",state:"open")
						tissueDto.children.add(iidDto)
					}
				}
			}
		}
		render result as JSON
	}
	
	

}
