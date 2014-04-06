<!DOCTYPE html>
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
	<div>
	<g:formRemote update="result" url='[controller: "project", action:"search"]' name="form" after="showSearching()">
		<g:textField name="keyword"/>
		<g:submitButton name="search"/>
	</g:formRemote>
	<div id="result"></div>
	</div>
	</body>
</html>
