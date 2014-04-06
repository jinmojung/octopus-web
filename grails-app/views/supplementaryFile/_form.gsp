<%@ page import="org.octopus.SupplementaryFile" %>



<div class="fieldcontain ${hasErrors(bean: supplementaryFileInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="supplementaryFile.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${supplementaryFileInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: supplementaryFileInstance, field: 'size', 'error')} ">
	<label for="size">
		<g:message code="supplementaryFile.size.label" default="Size" />
		
	</label>
	<g:textField name="size" value="${supplementaryFileInstance?.size}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: supplementaryFileInstance, field: 'fileTypeResource', 'error')} ">
	<label for="fileTypeResource">
		<g:message code="supplementaryFile.fileTypeResource.label" default="File Type Resource" />
		
	</label>
	<g:textField name="fileTypeResource" value="${supplementaryFileInstance?.fileTypeResource}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: supplementaryFileInstance, field: 'ftpDownload', 'error')} ">
	<label for="ftpDownload">
		<g:message code="supplementaryFile.ftpDownload.label" default="Ftp Download" />
		
	</label>
	<g:textField name="ftpDownload" value="${supplementaryFileInstance?.ftpDownload}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: supplementaryFileInstance, field: 'httpDownload', 'error')} ">
	<label for="httpDownload">
		<g:message code="supplementaryFile.httpDownload.label" default="Http Download" />
		
	</label>
	<g:textField name="httpDownload" value="${supplementaryFileInstance?.httpDownload}"/>
</div>

