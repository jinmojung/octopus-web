package org.octopus

import grails.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class BigWigService {
	static transactional = false
	def grailsApplication
	
	def makeTempHub(projects){
		def bigWigDir = grailsApplication.config.bigWig.dir
		def tempTxtContent = ""
		def tempTxtNaame = System.currentTimeMillis().toString()
		def tempTxt = new File("${bigWigDir}${tempTxtNaame}.txt")
		tempTxtContent +=
"""
browser hide all
browser pack knownGene
"""
		tempTxtContent = writeTempTxt(tempTxtContent,projects)
		println "trackDbTxtContent "+tempTxtContent
		tempTxt.withWriter{out ->
			out.append(tempTxtContent)
		}
		return tempTxtNaame
	}
	
	def writeTempTxt(trackDbTxtContent,projects){
		int index = 0
		String color = ""
		projects.each{
			if((index % 6)== 0){
				color = "color=0,0,0"
			}else if((index % 6) == 1){
				color = "color=255,0,0"
			}else if((index % 6) == 2){
				color = "color=0,255,0"
			}else if((index % 6) == 3){
				color = "color=0,0,255"
			}else if((index % 6) == 4){
				color = "color=0,255,255"
			}else if((index % 6) == 5){
				color = "color=255,0,255"
			}
			def ucscFilePathName = getUcscFilePathName(it.ucscFilePath)
			trackDbTxtContent +=
"""
track type=bigWig name="${ucscFilePathName}" db=mm9 description="${it.ucscFilePath}" ${color} visibility=2 bigDataUrl=${it.ucscFilePath}
"""
			index++
		}
		return trackDbTxtContent
		
	}
	
	def getUcscFilePathName(String ucscFilePath){
	def result
	def lastIndexOf = ucscFilePath.lastIndexOf('/')
	if(lastIndexOf != -1){
		result = ucscFilePath.substring(lastIndexOf+1, ucscFilePath.length())
	}else{
		result = ucscFilePath
	}
	return result
}
	

}
