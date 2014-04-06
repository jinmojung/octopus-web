package org.octopus

class SupplementaryFile {
	String name
	String size
	String fileTypeResource
	String ftpDownload
	String httpDownload

    static constraints = {
    
	}
	static mapping = {
		version false
		ftpDownload type: 'text'
		httpDownload type: 'text'
	}
}
