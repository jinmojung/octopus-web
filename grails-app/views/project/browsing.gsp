<html>
	<head>
		<meta name="layout" content="main"/>
</head>
<body>
<g:each in="${projectList}" status="i" var="projectInstance">
	<iframe src="${projectInstance.ucscFilePath }" scrolling="no" style="width: 100%;height: 3000px" frameborder="0"></iframe>
</g:each>
</body>
</html>
