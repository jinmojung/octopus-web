<html>
	<head>
		<meta name="layout" content="main"/>
		<script type="text/javascript">
		function showSearching(){
			$('#result').text('searching')
		}
		</script>
	</head>
	<body>
	<div id="align" style="width: 100%;text-align: center;">  
	<div id="content" style="height: 50px;margin-top: 100px;">  
		<g:form controller="project" action="search" method="GET">
			<input id="keyword" name="keyword" type="text" autocomplete="off" value="${params.keyword}" style="height: 30px;width: 400px;font-size: 16px;">
			<g:submitButton name="search" style="height: 30px;width: 100px;font-size: 16px;"/>
		</g:form>
		<g:form controller="project" action="browsing">
			<div>
			<g:if test="${projectList?.size() > 0 }">
			<table style="margin: auto;">
				<g:each in="${projectList}" status="i" var="projectInstance">
					<tr>
						<td><g:checkBox name="ucscCheck" value="${projectInstance.iid}" checked="false"/></td>
						<td>${projectInstance.title}</td>
						<td>${projectInstance.iid}</td>
					</tr>
				</g:each>
			</table>
			<g:submitButton name="browsing" style="height: 30px;width: 100px;font-size: 16px;"/>
			</g:if>
			<g:else>
			<div>
				<g:if test="${params.keyword != null && params.keyword != ''}">
				no data
				</g:if>
			</div>
			</g:else>
		</div>
		</g:form>
	</div>  
	</div> 
	</body>
</html>

