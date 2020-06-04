<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Car Rental</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/js.cookie.js"></script>
<style>
#login {
	float: left;
	height: 42%;
	width: 20%;
	margin-left: 40%;
	margin-top: 5%;
	display: inline;
	z-index: 999;
}
</style>
</head>
<body>
	<c:if test="${!empty error}">
		<script>
			alert("${error}");
			window.location.href = "login.html";
		</script>
	</c:if>
	<h2 style="text-align: center; font-family: ''; color: black">Car
		Rental Management System</h2>
	<div class="panel panel-default" id="login">
		<div class="panel-body">
			<div class="form-group">
				<label for="id">ID</label> <input type="text" class="form-control"
					id="id" placeholder="">
			</div>
			<div class="form-group">
				<label for="password">Password</label> <input type="password"
					class="form-control" id="password" placeholder="">
			</div>
			<div class="checkbox text-left">
				<label> <input type="checkbox" id="remember">Remember
				</label>
			</div>

			<p style="text-align: right; color: red; position: absolute"
				id="info"></p>
			<br />
			<button id="loginButton" class="btn btn-primary  btn-block">Login
			</button>
		</div>
	</div>
	<script>
		$("#id").keyup(function() {
			if (isNaN($("#id").val())) {
				$("#info").text("ID must be numbers");
			} else {
				$("#info").text("");
			}
		})
		// remember login
		function rememberLogin(username, password, checked) {
			Cookies.set('loginStatus', {
				username : username,
				password : password,
				remember : checked
			}, {
				expires : 30,
				path : ''
			})
		}
		function setLoginStatus() {
			var loginStatusText = Cookies.get('loginStatus')
			if (loginStatusText) {
				var loginStatus
				try {
					loginStatus = JSON.parse(loginStatusText);
					$('#id').val(loginStatus.username);
					$('#password').val(loginStatus.password);
					$("#remember").prop('checked', true);
				} catch (__) {
				}
			}
		}

		setLoginStatus();
		$("#loginButton").click(function() {
			var id = $("#id").val();
			var password = $("#password").val();
			var remember = $("#remember").prop('checked');

			if (isNaN(id)) {
				$("#info").text("ID must be numbers");
			} else {
				$.ajax({
					type : "POST",
					url : "/api/loginCheck",
					data : {
						id : id,
						password : password
					},
					dataType : "json",
					success : function(data) {
						if (data.stateCode.trim() == "0") {
							$("#info").text("Incorrect username or password");
						} else if (data.stateCode.trim() == "1") {
							$("#info").text("");
							window.location.href = "/admin_main.html";
						} else if (data.stateCode.trim() == "2") {
							if (remember) {
								rememberLogin(id, password, remember);
							} else {
								Cookies.remove('loginStatus');
							}
							$("#info").text("");
							window.location.href = "/customer_main.html";
						}
					}
				});
			}
		})
	</script>
</body>
</html>
