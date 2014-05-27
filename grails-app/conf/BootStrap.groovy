import org.octopus.Const;
import org.octopus.Role

class BootStrap {

	def adminService
	
    def init = { servletContext ->
		addRole()
		addAdminUser()
    }
    def destroy = {
    }
	
	def addRole(){
		try {
			new Role(authority: Const.ROLE_USER).save()
			new Role(authority: Const.ROLE_ADMIN).save()
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
	def addAdminUser(){
		try {
			adminService.createAdminUser("admin", "1111")
		} catch (Exception e) {
			e.printStackTrace()
		}
	}
}
