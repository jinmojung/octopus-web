<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="nocss">
		<script type="text/javascript">
		$(function() {
			$("#username").focus()
			$("#password").keypress(function (event) {
				var keyCode = event.keyCode;
		    	if (!keyCode) keyCode = event.which;
				if (keyCode == 13) {
					$("#submit").click();
				}
			});
		});
		</script>
	</head>
<body>		
<div class="loginTopEng">LOGIN</div>
<div class="loginField">
	<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
	    <ul>
	    	<g:if test="${params?.login_error != null}">
	        <li>
	            <div class="LoginName01 "></div>
	            <div class="IDLiInput Forange">fail to login</div>
	        </li>
	        </g:if>
	        <li>
	            <div class="LoginName01">ID</div>
	            <div class="IDLiInput"><input class="input InputMid" type='text' class='text_' name='j_username' id='username'  maxlength="15" style="ime-mode:disabled;"/></div>
	        </li>
	        <li>
	            <div class="LoginName01">PW</div>
	            <div class="IDLiInput"><input class="input InputMid" type='password' class='text_' name='j_password' id='password' /></div>
	        </li>
	        <li>
	            <div class="LoginName01"></div>
	            <div class="IDLiInput">
	            <a class="PageBttnG InputMid" href="#" onclick="$(this).closest('form').submit()" id="submit" value='Login' >login</a>
	            </div>
	        </li>
	    </ul>
	</form>
</div>
</body>
</html>