<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Change password</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>

</head>
<body>
	<jsp:include page="admin_main.jsp"></jsp:include>

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
	<div class="col-xs-6 col-md-offset-3"
		style="position: relative; top: 25%">
		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">Change password</h3>
			</div>
			<div class="panel-body">
				<form method="post" action="admin_repassword_do" class="form-inline"
					id="repassword">
					<div class="input-group">
						<input type="password" id="oldPassword" name="oldPassword"
							placeholder="Old password" class="form-control"
							class="form-control"> <input type="password"
							id="newPassword" name="newPassword" placeholder="New password"
							class="form-control" class="form-control"> <input
							type="password" id="reNewPassword" name="reNewPassword"
							placeholder="Confirm new password" class="form-control"
							class="form-control"> <em id="msg" style="color: red"></em>
						<br /> <span> <input type="submit" value="Submit"
							class="btn btn-default">
						</span>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script>
		function mySubmit(flag) {
			return flag;
		}

		$(document).keyup(
				function() {
					if ($("#newPassword").val() != $("#reNewPassword").val()
							&& $("#newPassword").val() != ""
							&& $("#reNewPassword").val() != ""
							&& $("#newPassword").val().length == $(
									"#reNewPassword").val().length) {
						$("#msg").text("Inputs don't match. ");
					} else {
						$("#msg").text("");
					}
				})

		$("#repassword").submit(
				function() {
					if ($("#oldPassword").val() == ''
							|| $("#newPassword").val() == ''
							|| $("#reNewPassword").val() == '') {
						$("#msg").text("Incomplete");
						return mySubmit(false);
					} else if ($("#newPassword").val() != $("#reNewPassword")
							.val()) {
						$("#msg").text("Inputs don't match.");
						return mySubmit(false);
					}
				})
	</script>

</body>
</html>
