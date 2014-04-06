
<%@ page import="org.octopus.SupplementaryFile" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'supplementaryFile.label', default: 'SupplementaryFile')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-supplementaryFile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-supplementaryFile" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list supplementaryFile">
			
				<g:if test="${supplementaryFileInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="supplementaryFile.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${supplementaryFileInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${supplementaryFileInstance?.size}">
				<li class="fieldcontain">
					<span id="size-label" class="property-label"><g:message code="supplementaryFile.size.label" default="Size" /></span>
					
						<span class="property-value" aria-labelledby="size-label"><g:fieldValue bean="${supplementaryFileInstance}" field="size"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${supplementaryFileInstance?.fileTypeResource}">
				<li class="fieldcontain">
					<span id="fileTypeResource-label" class="property-label"><g:message code="supplementaryFile.fileTypeResource.label" default="File Type Resource" /></span>
					
						<span class="property-value" aria-labelledby="fileTypeResource-label"><g:fieldValue bean="${supplementaryFileInstance}" field="fileTypeResource"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${supplementaryFileInstance?.ftpDownload}">
				<li class="fieldcontain">
					<span id="ftpDownload-label" class="property-label"><g:message code="supplementaryFile.ftpDownload.label" default="Ftp Download" /></span>
					
						<span class="property-value" aria-labelledby="ftpDownload-label"><g:fieldValue bean="${supplementaryFileInstance}" field="ftpDownload"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${supplementaryFileInstance?.httpDownload}">
				<li class="fieldcontain">
					<span id="httpDownload-label" class="property-label"><g:message code="supplementaryFile.httpDownload.label" default="Http Download" /></span>
					
						<span class="property-value" aria-labelledby="httpDownload-label"><g:fieldValue bean="${supplementaryFileInstance}" field="httpDownload"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:supplementaryFileInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${supplementaryFileInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
