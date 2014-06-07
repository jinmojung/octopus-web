package org.octopus



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class TestController {
	def projectService
	def ftpDownService
	def hubService

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
		ExcelBuilder excelBuilder = new ExcelBuilder('Octopus_list2.xlsx',null).eachLine([labels:true,sheet:0]) {
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
	
	

}
