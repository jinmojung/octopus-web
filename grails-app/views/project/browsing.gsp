<html>
	<head>
		<meta name="layout" content="nocss"/>
		<script type="text/javascript">
		function setHeight(){
		}
		// 현재 도메인의 모든 쿠키 검색후 전부 삭제 
		function cookiesAllDel(){
		 var cookiesArray = "";
		 var cookiesCount = 0;
		 var ckArray = "";
		 cookiesArray = document.cookie.split(";");
		 cookiesCount = cookiesArray.length;
		 for (var i = 0; i < cookiesCount; i++ ){
		  ckArray = cookiesArray[i].split("=");
		  alert(ckArray)
		  //document.cookie = ckArray[0] + "=''; path=/; expires='';"
		 }
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
<iframe id="iframe" src="${madeHubPath}"  style="width: 100%;height: 3500px; overflow:auto;" frameborder="0" onload="cookiesAllDel()"></iframe>
</body>
</html>
