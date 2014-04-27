package org.octopus



def hubRootDir = "D:\\hub"

def tempFolderNaame = System.currentTimeMillis().toString()
def tempRootDir = new File("${hubRootDir}/${tempFolderNaame}")
tempRootDir.mkdirs()
def hubTxt =  new File("${hubRootDir}/${tempFolderNaame}/hub.txt")
hubTxt.withWriter{out -> 
	def txt = 
"""
hub octopusHub 
shortLabeloctopusHub 
longLabel octopusHub 
genomesFile genomes.txt
email 82jjm1000@gmail.com
"""
	out.append(txt)
	
}

def genomesTxt =  new File("${hubRootDir}/${tempFolderNaame}/genomes.txt")
genomesTxt.withWriter{out ->
	def txt =
"""
genome mm9
trackDb mm9/trackDb.txt

"""
	out.append(txt)
	
}

def mm9Dir =  new File("${hubRootDir}/${tempFolderNaame}/mm9")
mm9Dir.mkdirs()
def trackDbTxt =  new File("${hubRootDir}/${tempFolderNaame}/mm9/trackDb.txt")
trackDbTxt.withWriter{out ->
	def txt =
"""
track octopusSearch
superTrack on show
group regulation
visibility full
shortLabel octopusSearch
longLabel octopusSearch

"""
	out.append(txt)
	
}
println "sdfsdf"
