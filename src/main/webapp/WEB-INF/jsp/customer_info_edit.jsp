
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
	<jsp:include page="customer_main.jsp"></jsp:include>

	<div class="col-xs-5 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Edit</h3>
			</div>
			<div class="panel-body">
				<form action="customer_edit_do_r.html" method="post" id="edit">

					<div class="input-group">
						<span class="input-group-addon">Customer ID</span> <input
							type="text" readonly="readonly" class="form-control"
							name="customerId" id="customerId"
							value="${customerinfo.customerId}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Name</span> <input type="text"
							class="form-control" name="name" id="name"
							value="${customerinfo.name}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Sex</span> <input type="text"
							class="form-control" name="sex" id="sex"
							value="${customerinfo.sex}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Birth</span> <input type="text"
							class="form-control" name="birth" id="birth"
							value="${customerinfo.birth}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Address</span> <input type="text"
							class="form-control" name="address" id="address"
							value="${customerinfo.address}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Tel</span> <input type="text"
							class="form-control" name="tel" id="tel"
							value="${customerinfo.tel}">
					</div>
					<br /> <input type="submit" value="Submit"
						class="btn btn-success btn-sm" class="text-left">
					<script>
						function mySubmit(flag) {
							return flag;
						}
						$("#edit").submit(
								function() {
									if ($("#name").val() == ''
											|| $("#sex").val() == ''
											|| $("#birth").val() == ''
											|| $("#address").val() == ''
											|| $("#tel").val() == '') {
										alert("Incomplete information. ");
										return mySubmit(false);
									}
								})
					</script>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
