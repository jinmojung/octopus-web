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
	<div id="align" style="width: 100%;text-align: center;">  
	<div id="content" style="height: 50px;margin-top: 100px;">  
		<g:form controller="project" action="search">
			<input id="keyword" name="keyword" type="text" autocomplete="off" value="" style="height: 30px;width: 400px;font-size: 16px;">
			<g:submitButton name="search" style="height: 30px;width: 100px;font-size: 16px;"/>
		</g:form>
	</div>  
	</div> 
	</body>
</html>
