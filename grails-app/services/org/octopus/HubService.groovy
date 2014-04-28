package org.octopus

import grails.transaction.Transactional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

class HubService {
	static transactional = false
	def grailsApplication
	
	def makeTempHub(projects){
		def hubRootDir = grailsApplication.config.hubRoot.dir
		def copyCmd = grailsApplication.config.copy.cmd
		def bigWigDir = grailsApplication.config.bigWig.dir
		def trackDbTxtContent = ""
		
		def tempFolderNaame = System.currentTimeMillis().toString()
		def tempRootDir = new File("${hubRootDir}${tempFolderNaame}")
		tempRootDir.mkdirs()
		def hubTxt =  new File("${hubRootDir}${tempFolderNaame}/hub.txt")
		hubTxt.withWriter{out ->
			def txt =
"""
hub octopusHub 
shortLabel octopusHub 
longLabel octopusHub 
genomesFile genomes.txt
email 82jjm1000@gmail.com
"""
			out.append(txt)
			
		}
		
		def genomesTxt =  new File("${hubRootDir}${tempFolderNaame}/genomes.txt")
		genomesTxt.withWriter{out ->
			def txt =
"""
genome mm9
trackDb mm9/trackDb.txt

"""
			out.append(txt)
			
		}
		
		def mm9Dir =  new File("${hubRootDir}${tempFolderNaame}/mm9")
		mm9Dir.mkdirs()
		copyBigWig("${hubRootDir}${tempFolderNaame}${File.separator}mm9",projects)
		
		def trackDbTxt =  new File("${hubRootDir}${tempFolderNaame}/mm9/trackDb.txt")
		trackDbTxtContent +=
"""
track octopusSearch
superTrack on show
group regulation
visibility full
shortLabel octopusSearch
longLabel octopusSearch

"""
		trackDbTxtContent = writeTrackDbTxt(trackDbTxtContent,projects)
		println "trackDbTxtContent "+trackDbTxtContent
		trackDbTxt.withWriter{out ->
			out.append(trackDbTxtContent)
		}
		return tempFolderNaame
	}
	
	def copyBigWig(todir,projects){
		def hubRootDir = grailsApplication.config.hubRoot.dir
		def copyCmd = grailsApplication.config.copy.cmd
		def bigWigDir = grailsApplication.config.bigWig.dir
		Runtime rt = Runtime.getRuntime()
		projects.each{
			println "${copyCmd} ${bigWigDir}${it.ucscFilePath} ${todir}"
			rt.exec("${copyCmd} ${bigWigDir}${it.ucscFilePath} ${todir}")
		}
		
	}
	
	def writeTrackDbTxt(trackDbTxtContent,projects){
		println "writeTrackDbTxt"+projects.size()
		int index = 0
		String color = ""
		
		projects.each{
			if((index % 8)== 0){
				color = "color 0,0,0"
			}else if((index % 8) == 1){
				color = "color 255,0,0"
			}else if((index % 8) == 2){
				color = "color 0,255,0"
			}else if((index % 8) == 3){
				color = "color 0,0,255"
			}else if((index % 8) == 4){
				color = "color 0,255,255"
			}else if((index % 8) == 5){
				color = "color 255,255,0"
			}else if((index % 8) == 6){
				color = "color 255,0,255"
			}else if((index % 8) == 7){
				color = "color 255,255,255"
			}
			trackDbTxtContent +=
"""

track octopusSearch${index}
bigDataUrl ${it.ucscFilePath}
parent octopusSearch
visibility full
${color}
shortLabel ${it.antibody}_${it.organism}_${it.tissue}_${it.iid}
longLabel ${it.antibody}_${it.organism}_${it.tissue}_${it.iid}
type bigWig 0 100
"""
			index++
		}
		return trackDbTxtContent
		
	}
	

}
