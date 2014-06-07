package org.octopus



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.*
@Transactional(readOnly = true)
class LogoutController {


    def index() {
        session.invalidate()
		redirect  uri: '/'
    }

}
