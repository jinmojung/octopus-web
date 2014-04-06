
<%@ page import="org.octopus.Project" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="list-project" class="content scaffold-list" role="main">
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="iid" title="${message(code: 'project.iid.label', default: 'Iid')}" />
					
						<g:sortableColumn property="title" title="${message(code: 'project.title.label', default: 'Title')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${projectInstanceList}" status="i" var="projectInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${projectInstance.id}">${fieldValue(bean: projectInstance, field: "iid")}</g:link></td>
					
						<td>${fieldValue(bean: projectInstance, field: "title")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
		</div>
	</body>
</html>
