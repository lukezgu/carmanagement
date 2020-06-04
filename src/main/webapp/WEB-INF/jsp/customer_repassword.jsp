<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>home page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>
</head>
<body>
	<jsp:include page="customer_main.jsp"></jsp:include>
<div style="position: relative; top: 15%">
	<c:if test="${!empty succ}">
		<div class="alert alert-success alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			${succ}
		</div>
	</c:if>
	<c:if test="${!empty error}">
		<div class="alert alert-danger alert-dismissable">
			<button type="button" class="close" data-dismiss="alert"
				aria-hidden="true">&times;</button>
			${error}
		</div>
	</c:if>
</div>

	<div style="width: 60%; margin-left: 20%; margin-top: 10%">
		<form class="form-horizontal" method="post"
			action="customer_repassword_do.html" id="repassword">
			<div class="form-group">
				<label for="oldPassword" class="col-sm-2 control-label">Old password</label>
				<div class="col-sm-10">
					<input class="form-control" type="password" id="oldPassword"
						name="oldPassword" placeholder="">
				</div>
			</div>
			<div class="form-group">
				<label for="newPassword" class="col-sm-2 control-label">New password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="newPassword"
						name="newPassword" placeholder="" placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<label for="reNewPassword" class="col-sm-2 control-label">Conform new password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="reNewPassword"
						name="reNewPassword" placeholder="">
				</div>
			</div>
			<p id="msg" style="margin-left: 10%; position: absolute"></p>
			<br />
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Submit" class="btn btn-default">
				</div>
			</div>
		</form>


	</div>
	<script>
		function mySubmit(flag) {
			return flag;
		}

		$(document)
				.keyup(
						function() {
							if ($("#newPassword").val() != $("#reNewPassword")
									.val()
									&& $("#newPassword").val() != ""
									&& $("#reNewPassword").val() != ""
									&& $("#newPassword").val().length == $(
											"#reNewPassword").val().length) {
								$("#msg").text("Inputs don't match. ");
							} else {
								$("#msg").text("");
							}
						})

		$("#repassword")
				.submit(
						function() {
							if ($("#oldPassword").val() == ''
									|| $("#newPassword").val() == ''
									|| $("#reNewPassword").val() == '') {
								$("#msg").text("Incomplete ");
								return mySubmit(false);
							} else if ($("#newPassword").val() != $(
									"#reNewPassword").val()) {
								$("#msg").text("Inputs don't match. ");
								return mySubmit(false);
							}
						})
	</script>


</body>
</html>
