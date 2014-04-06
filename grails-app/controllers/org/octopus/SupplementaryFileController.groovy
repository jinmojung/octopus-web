package org.octopus



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SupplementaryFileController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SupplementaryFile.list(params), model:[supplementaryFileInstanceCount: SupplementaryFile.count()]
    }

    def show(SupplementaryFile supplementaryFileInstance) {
        respond supplementaryFileInstance
    }

    def create() {
        respond new SupplementaryFile(params)
    }

    @Transactional
    def save(SupplementaryFile supplementaryFileInstance) {
        if (supplementaryFileInstance == null) {
            notFound()
            return
        }

        if (supplementaryFileInstance.hasErrors()) {
            respond supplementaryFileInstance.errors, view:'create'
            return
        }

        supplementaryFileInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'supplementaryFileInstance.label', default: 'SupplementaryFile'), supplementaryFileInstance.id])
                redirect supplementaryFileInstance
            }
            '*' { respond supplementaryFileInstance, [status: CREATED] }
        }
    }

    def edit(SupplementaryFile supplementaryFileInstance) {
        respond supplementaryFileInstance
    }

    @Transactional
    def update(SupplementaryFile supplementaryFileInstance) {
        if (supplementaryFileInstance == null) {
            notFound()
            return
        }

        if (supplementaryFileInstance.hasErrors()) {
            respond supplementaryFileInstance.errors, view:'edit'
            return
        }

        supplementaryFileInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SupplementaryFile.label', default: 'SupplementaryFile'), supplementaryFileInstance.id])
                redirect supplementaryFileInstance
            }
            '*'{ respond supplementaryFileInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SupplementaryFile supplementaryFileInstance) {

        if (supplementaryFileInstance == null) {
            notFound()
            return
        }

        supplementaryFileInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SupplementaryFile.label', default: 'SupplementaryFile'), supplementaryFileInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'supplementaryFileInstance.label', default: 'SupplementaryFile'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
