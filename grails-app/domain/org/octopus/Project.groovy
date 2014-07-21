package org.octopus

class Project {
	String iid
	String status
	String title
	String sampleType
	String sourceName
	String organism
	String characteristics
	String treatmentProtocol
	String growthProtocol
	String extractedMolecule
	String extractionProtocol
	String libraryStrategy
	String librarySource
	String librarySelection
	String instrumentModel
	String description
	String dataProcessing
	String lastUpdateDate
	String contactName
	String email
	String organizationName
	String department
	String lab
	String streetAddress
	String city
	String zipPostalCode
	String country
	String sra
	String bioSample
	String experimentType
	String summary
	String overallDesign
	String submissionDate
	String phone
	String stateProvince
	String platformId
	String browsingStatus
	String ucscFilePath
	String tissue
	String antibody
	String species
	String stage
	String treatment
	String dataLevel
	
	
	static hasMany = [supplementaryFiles: SupplementaryFile]
	
	static transients = ['dataLevel']

    static constraints = {
		iid unique: true
    
	}
	static mapping = {
		version false
		treatmentProtocol type: 'text'
		growthProtocol type: 'text'
		extractionProtocol type: 'text'
		dataProcessing type: 'text'
		characteristics type: 'text'
		browsingStatus type: 'text'
	}
	
	String getTissue(){
		if(tissue != null){
			return tissue
		}else{
			return Util.getTissue(characteristics,sourceName)
		}
	}
	
	String getAntibody(){
		if(antibody != null){
			return antibody
		}else{
			return Util.getAntibody(characteristics)
		}
	}
	
	String getSpecies(){
		if(species != null){
			return species
		}else{
			return organism
		}
	}
	

}
