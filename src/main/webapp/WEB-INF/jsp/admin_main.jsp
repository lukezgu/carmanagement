<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Admin</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
body {
	margin: 0;
	padding: 0;
	overflow: visible;
}
</style>
</head>
<body>
	<nav
		style="position: fixed; z-index: 999; width: 100%; background-color: #fff"
		class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header" style="margin-left: 8%; margin-right: 1%">
				<a class="navbar-brand" href="admin_main.html">Car rental
					management</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-left">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> Car management <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="allcars.html">All cars</a></li>
							<li class="divider"></li>
							<li><a href="car_add.html">Add a new car</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"> Customer management <b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="allcustomers.html">View customers</a></li>
							<li class="divider"></li>
							<li><a href="customer_add.html">New customer</a></li>
						</ul></li>
					
						<li><a href="rentlist.html"> Rent logs </a></li>
					<li><a href="admin_repassword.html"> Change password </a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="logout.html"><span class=""></span>Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<!-- <!-- 模态框（Modal） -->
<%-- 	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">温馨提示</h4>
				</div>
				<div class="modal-body">使用结束后请安全退出。</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">知道了
					</button>
				</div>
			</div>
			/.modal-content
		</div>
		/.modal
	</div>
	-->
	<c:if test="${!empty login}">
		<script>
			$(function() {
				$("#myModal").modal({
					show : true
				})
			})
		</script>
	</c:if>
 --%>
</body>
</html>
