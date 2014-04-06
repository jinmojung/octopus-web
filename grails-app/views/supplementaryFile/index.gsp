
<%@ page import="org.octopus.SupplementaryFile" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'supplementaryFile.label', default: 'SupplementaryFile')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-supplementaryFile" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-supplementaryFile" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'supplementaryFile.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="size" title="${message(code: 'supplementaryFile.size.label', default: 'Size')}" />
					
						<g:sortableColumn property="fileTypeResource" title="${message(code: 'supplementaryFile.fileTypeResource.label', default: 'File Type Resource')}" />
					
						<g:sortableColumn property="ftpDownload" title="${message(code: 'supplementaryFile.ftpDownload.label', default: 'Ftp Download')}" />
					
						<g:sortableColumn property="httpDownload" title="${message(code: 'supplementaryFile.httpDownload.label', default: 'Http Download')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${supplementaryFileInstanceList}" status="i" var="supplementaryFileInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${supplementaryFileInstance.id}">${fieldValue(bean: supplementaryFileInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: supplementaryFileInstance, field: "size")}</td>
					
						<td>${fieldValue(bean: supplementaryFileInstance, field: "fileTypeResource")}</td>
					
						<td>${fieldValue(bean: supplementaryFileInstance, field: "ftpDownload")}</td>
					
						<td>${fieldValue(bean: supplementaryFileInstance, field: "httpDownload")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${supplementaryFileInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
