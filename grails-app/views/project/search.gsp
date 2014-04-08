<html>
	<head>
		<meta name="layout" content="main"/>
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
		    
			var availableTags = [
				"ActionScript",
				"AppleScript",
				"Asp",
				"BASIC",
				"C",
				"C++",
				"Clojure",
				"COBOL",
				"ColdFusion",
				"Erlang",
				"Fortran",
				"Groovy",
				"Haskell",
				"Java",
				"JavaScript",
				"Lisp",
				"Perl",
				"PHP",
				"Python",
				"Ruby",
				"Scala",
				"Scheme"
			];

		});
		
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
				<g:hiddenField name="ucscCheck" value=""/>
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

