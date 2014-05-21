<html>
	<head>
		<meta name="layout" content="nocss"/>
		<title>Octopus Result</title>
		<script type="text/javascript">
		function setHeight(){
		}
		</script>
</head>
<body>
<div style="float: left;width: 20%;cursor: pointer;" onclick="history.back();">
	<img alt="main" src="${resource(dir: 'images', file: 'octopus_logo.png')}" style="width: 100%;">
	</div>
	<div style="float: right;font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 30px;width: 75%;margin-left: 20px;margin-top: 25px;cursor: pointer;" onclick="history.back();">
Back to Octopus
	</div>
<iframe id="iframe" src="${madeHubPath}"  style="width: 100%;height: 3500px; overflow:auto;" frameborder="0" onload="setHeight()"></iframe>
</body>
</html>
