<html>
	<head>
		<meta name="layout" content="nocss"/>
		<script type="text/javascript">
		function delTempHubDir(tempHubDir){
			$.ajax({
				url: "${createLink(contoller:'project',action:'delTempHubDir')}",
				type: "GET",
				data: "tempHubDir=" + tempHubDir,
				success: function(response) {
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
				}
			});
		}
		</script>
</head>
<body>
<div style="width: 100%; height: 100%; overflow: auto; -webkit-overflow-scrolling: touch;">
<iframe src="${madeHubPath}" scrolling="no" style="width: 100%;height: 3500px" frameborder="0" onload="delTempHubDir('${tempHubDir}')"></iframe>
</div>
</body>
</html>
