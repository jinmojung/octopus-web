package org.octopus

import java.text.SimpleDateFormat


/**
 * util
 * <p>
 * util
 *
 * @author jinmo
 *
 * ** 변경이력 **<br>
 * --------------------------------------------------------------------------------------	<br>
 * 변경일 			작성자				변경사항<br>
 * --------------------------------------------------------------------------------------<br>
 * 2014.03.24		정진모				신규 작성	<br>
 * <br>
 */
class Util {
	
	/**
	 * get Tissue
	 * @param from 
	 * @return String 
	 */
	public static String getTissue(from) {
		def matcher = ( from =~ /tissue:\s?(\S*)/ )
		if(matcher.find()){
			return matcher.group(1)
		}else{
			return Const.NO_DATA
		}
	}
	
	public static String getAntibody(from){
		def matcher = ( from =~ /antibody:\s?(\S*)/ )
		if(matcher.find()){
			return matcher.group(1)
		}else{
			return Const.NO_DATA
		}
	}
	
}
