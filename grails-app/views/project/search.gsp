<html>
	<head>
		<meta name="layout" content="nocss"/>
		<link href="${resource(dir: 'css/ui-lightness/', file: 'jquery-ui-1.10.4.css')}" rel="stylesheet">
		<script src="${resource(dir: 'js', file: 'jquery-ui-1.10.4.min.js')}"></script>
		<script type="text/javascript">
		$(function() {
			$.ajax({
		        type: "GET",
		        url: '<g:createLink controller="project" action="getAutoSearchText"/>',
		        success : function(response) {
		            $("#keyword").autocomplete({
		                source: response
		            });
		        }
		    });

			$("#keyword").focus()
			
		    $("#search" ).click(function() {
			    if($("#keyword").val() != ''){
			    	$("#searchForm" ).submit()
				}
	    	});

		    $("#browsing" ).click(function() {
			    if($("input[name=ucscCheck]:checked").size() != 0){
			    	$("#browsingForm" ).submit()
				}
	    	});
		    var docHeight = $(window).height();
		    var footerHeight = $('#footer').height();
		    var footerTop = $('#footer').position().top + footerHeight;
		    if(docHeight > footerTop){
		    	$('#footer').css('margin-top',  (docHeight-footerTop - 15) + 'px');
			}else{
				$('#footer').css('margin-top',  15 + 'px');
			}
		    $( window ).resize(function() {
		    	var docHeight = $(window).height();
			    var footerHeight = $('#footer').height();
			    var footerTop = $('#footer').position().top + footerHeight;
			    if(docHeight > footerTop){
			    	$('#footer').css('margin-top',  (docHeight-footerTop - 15) + 'px');
				}else{
					$('#footer').css('margin-top',  15 + 'px');
				}
	    	});
		});
		
		</script>
	</head>
	<body>
	<div style="float: left;width: 30%;">
	<img alt="main" src="${resource(dir: 'images', file: 'octopus_logo.png')}" style="width: 100%;">
	</div>
	<div style="float: right;font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 30px;width: 65%;margin-left: 20px;margin-top: 5px;">
The Octopus interface can be used to search the 
GEO database for ChIP-seq data sets and display 
information in a user-friendly way through the 
UCSC browser. Current searches are restricted to 
data sets related to the JAK-STAT pathway.
	</div>
	<div style="width: 100%;clear: both;text-align: center;">
	<div style="height: 50px;padding-top: 100px;height: 100%;">
		<g:form name="searchForm" controller="project" action="search" method="GET">
			<input id="keyword" name="keyword" type="text" autocomplete="off" value="${params.keyword}" style="border:solid;font-family: Arial, Helvetica, sans-serif;height: 50px;width: 400px;font-size: 25px;">
			<span id="search" style="cursor:pointer;  margin-left:20px; font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 30px;">SEARCH</span>
		</g:form>
		<g:form name="browsingForm" controller="project" action="browsing">
			<g:if test="${projectList?.size() > 0 }">
			<table style="margin: auto;padding-top: 20px;padding-bottom: 20px;">
				<tr>
					<td></td>
					<td style="min-width: 150px;text-align: center;font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 20px;">Antibody</td>
					<td style="min-width: 150px;text-align: center;font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 20px;">Species</td>
					<td style="min-width: 150px;text-align: center;font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 20px;">Tissue</td>
					<td style="min-width: 150px;text-align: center;font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 20px;">GSM_number</td>
				</tr>
				<g:hiddenField name="ucscCheck" value=""/>
				<g:each in="${projectList}" status="i" var="projectInstance">
					<tr>
						<td><g:checkBox name="ucscCheck" value="${projectInstance.iid}" checked="false" style="width:20px;height:20px;"/></td>
						<td style="min-width: 150px;text-align: center;font-family: Arial, Helvetica, sans-serif;font-size: 16px;">${projectInstance.antibody}</td>
						<td style="min-width: 150px;text-align: center;font-family: Arial, Helvetica, sans-serif;font-size: 16px;">${projectInstance.organism}</td>
						<td style="min-width: 150px;text-align: center;font-family: Arial, Helvetica, sans-serif;font-size: 16px;">${projectInstance.tissue}</td>
						<td style="min-width: 150px;text-align: center;font-family: Arial, Helvetica, sans-serif;font-size: 16px;"><g:link action="show" id="${projectInstance.id}">${projectInstance.iid}</g:link></td>
					</tr>
				</g:each>
			</table>
			<span id="browsing" style="cursor:pointer;  margin-top:30px; font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 30px;">BROWSING</span>
			</g:if>
			<g:else>
			<div style="font-family: Arial, Helvetica, sans-serif;font-weight: bold;font-size: 30px;padding-top: 50px;">
				<g:if test="${params.keyword != null && params.keyword != ''}">
				No Data
				</g:if>
			</div>
			</g:else>
		</g:form>
	</div>
	</div>
	<div id="footer" style="width: 98%;text-align: center;font-family: Arial, Helvetica, sans-serif;font-size: 18px;">
	The Octopus Explorer was developed by Keunsoo Kang, Jinmo Jung and Lothar Hennighausen
	<br/>
	Octopus explorer는 강근수, 정진모, 로타 헤닉하우젠이 개발하였습니다. 
	<br/>
	2014 – all rights reserved
	</div>
	
	</body>
</html>

