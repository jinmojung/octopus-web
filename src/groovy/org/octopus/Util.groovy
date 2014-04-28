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
	public static String getTissue(String... from) {
		def matcher
		String result = ''
		from.each{
			matcher = ( it =~ /tissue:\s?(\S*)/ )
			if(matcher.find()){
				result = matcher.group(1)
			}
			matcher = ( it =~ /(\S*)(\s?)tissue/ )
			if(matcher.find()){
				result = matcher.group(1)
			}
		}
		if(result == ''){
			return Const.NO_DATA
		}else{
			return result
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
