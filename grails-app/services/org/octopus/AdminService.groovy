package org.octopus



/**
 * admin Service
 * <p>
 * admin 사용자 생성 상황실 사용자 엑셀업로드 상황실 부서 엑셀 업로드
 *
 * @author 진영우
 * <br>
 * ** 변경이력 **<br>
 * --------------------------------------------------------------------------------------<br>
 * 변경일 			작성자				변경사항<br>
 * --------------------------------------------------------------------------------------<br>
 * 2013.01.16		진영우				신규 작성	<br>
 * 2013.03.07                장시영 			uploadGovDeptByExcel 메소드 추가<br>
 *
 */
class AdminService {
	
	/**
	 * 주소 검색
	 * @param id 아이디
	 * @param password 비밀번호
	 * @return User 생성된 User 객체
	 */
	def createAdminUser(id,password){
		def user = new User(username:id,password:password).save(flush: true)
		if(user != null){
			UserRole.create(user, Role.findByAuthority('ROLE_ADMIN'), true)
		}
		return user
	}
}
