<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>${customercard.name}'shome page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>
</head>
<body>
<body>
	<nav class="navbar navbar-default" role="navigation"
		style="background-color: #fff">
		<div class="container-fluid">
			<div class="navbar-header" style="margin-left: 8%; margin-right: 1%">
				<a class="navbar-brand " href="customer_main.html"><p
						class="text-primary">My rent record</p></a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav navbar-left">

					<li><a href="customer_info.html"> Info </a></li>
					<li><a href="myrent.html"> Rent record </a></li>
					<li><a href="customer_repassword.html"> Change password
					</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout.html"><span class=""></span>Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>


</body>
</html>
