
<%@ page import="org.octopus.Project" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-project" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="iid" title="${message(code: 'project.iid.label', default: 'Iid')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'project.status.label', default: 'Status')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'project.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="sampleType" title="${message(code: 'project.sampleType.label', default: 'Sample Type')}" />
					
						<g:sortableColumn property="sourceName" title="${message(code: 'project.sourceName.label', default: 'Source Name')}" />
					
						<g:sortableColumn property="organism" title="${message(code: 'project.organism.label', default: 'Organism')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${projectInstanceList}" status="i" var="projectInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${projectInstance.id}">${fieldValue(bean: projectInstance, field: "iid")}</g:link></td>
					
						<td>${fieldValue(bean: projectInstance, field: "status")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "title")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "sampleType")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "sourceName")}</td>
					
						<td>${fieldValue(bean: projectInstance, field: "organism")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${projectInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
