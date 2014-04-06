package org.octopus



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

class TestController {
	def projectService
	def ftpDownService

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

}
