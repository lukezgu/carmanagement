<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>New customer</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>

</head>
<body>
	<jsp:include page="admin_main.jsp"></jsp:include>

	<div class="col-xs-6 col-md-offset-3"
		style="position: relative; top: 25%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">New customer</h3>
			</div>
			<div class="panel-body">
				<form action="customer_add_do.html" method="post" id="customeredit">
					<div class="input-group">
						<span class="input-group-addon">Customer ID</span> <input
							type="text" class="form-control" name="customerId"
							id="customerId"">
					</div>

					<div class="input-group">
						<span class="input-group-addon">Name</span> <input type="text"
							class="form-control" name="name" id="name">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Sex</span> <input type="text"
							class="form-control" name="sex" id="sex">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Birth</span> <input type="text"
							class="form-control" name="birth" id="birth">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Address</span> <input type="text"
							class="form-control" name="address" id="address">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Tel</span> <input type="text"
							class="form-control" name="tel" id="tel">
					</div>
					<input type="submit" value="Submit" class="btn btn-success btn-sm"
						class="text-left">
					<script>
						function mySubmit(flag) {
							return flag;
						}
						$("#customeredit").submit(
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
