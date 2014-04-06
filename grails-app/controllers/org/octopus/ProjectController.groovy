package org.octopus



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProjectController {

	def grailsApplication
	
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Project.list(params), model:[projectInstanceCount: Project.count()]
    }

    def show(Project projectInstance) {
        respond projectInstance
    }

    def create() {
        respond new Project(params)
    }

    @Transactional
    def save(Project projectInstance) {
        if (projectInstance == null) {
            notFound()
            return
        }

        if (projectInstance.hasErrors()) {
            respond projectInstance.errors, view:'create'
            return
        }

        projectInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'projectInstance.label', default: 'Project'), projectInstance.id])
                redirect projectInstance
            }
            '*' { respond projectInstance, [status: CREATED] }
        }
    }

    def edit(Project projectInstance) {
        respond projectInstance
    }

    @Transactional
    def update(Project projectInstance) {
        if (projectInstance == null) {
            notFound()
            return
        }

        if (projectInstance.hasErrors()) {
            respond projectInstance.errors, view:'edit'
            return
        }

        projectInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Project.label', default: 'Project'), projectInstance.id])
                redirect projectInstance
            }
            '*'{ respond projectInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Project projectInstance) {

        if (projectInstance == null) {
            notFound()
            return
        }

        projectInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Project.label', default: 'Project'), projectInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectInstance.label', default: 'Project'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
	
	def search(){
		def projectList = []
		if(params.keyword != null && params.keyword != ''){
			projectList = Project.findAllByTitleLikeOrSourceNameLike("%${params.keyword}%","%${params.keyword}%")
		}
		println projectList.size()
		render(view: "search", model: [projectList: projectList])
	}
	def browsing(){
		println params
	}
	
	def getUcscFile(){
		def ucscDir = grailsApplication.config.ucsc.dir
		def filename = 'K4me3_mm9_MGp6_GSE48685.ucsc.bigWig'
		String userAgent = request.getHeader("User-Agent");
		if (userAgent != null && userAgent.indexOf("MSIE 5.5") > -1) { // MS IE 5.5 이하
		  response.setHeader("Content-Disposition", "filename=${filename};");
		} else if (userAgent != null && userAgent.indexOf("MSIE") > -1) { // MS IE (보통은 6.x 이상 가정)
		  response.setHeader("Content-Disposition", "attachment; filename=${filename};");
		} else { // 모질라나 오페라
		  response.setHeader("Content-Disposition", "attachment; filename=${filename};");
		}

		File attachFile = new File("${ucscDir}${filename}")
		response.setContentLength((int)attachFile.length())
		OutputStream out = response.getOutputStream()
		out.write(attachFile.getBytes())
		out.close()
	}
}
