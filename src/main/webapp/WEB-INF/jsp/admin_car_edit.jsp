<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Edit ${detail.carId}</title>
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
		style="position: relative; top: 10%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Edit ${detail.carId}</h3>
			</div>
			<div class="panel-body">
				<form action="car_edit_do.html?id=${detail.carId}" method="post"
					id="addcar">

					<div class="input-group">
						<span class="input-group-addon">Plate Number</span> <input
							readonly="readonly" type="text" class="form-control"
							name="carId" id="carId"
							value="${detail.carId}">
					</div>
					
					<div class="input-group">
						<span class="input-group-addon">Type</span> <input type="text"
							class="form-control" name="type" id="type" value="${detail.type}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Brand</span> <input type="text"
							class="form-control" name="brand" id="brand"
							value="${detail.brand}">
					</div>

					<div class="input-group">
						<span class="input-group-addon">Introduction</span> <input
							type="text" class="form-control" name="introduction"
							id="introduction" value="${detail.introduction}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Date of manufacture</span> <input
							type="text" class="form-control" name="manufactureDate"
							id="manufactureDate" value="${detail.manufactureDate}">
					</div>

					<div class="input-group">
						<span class="input-group-addon">State</span> <input type="text"
							class="form-control" name="state" id="state"
							value="${detail.state}">
					</div>
					<input type="submit" value="Submit" class="btn btn-success btn-sm"
						class="text-left">
					<script>
						function mySubmit(flag) {
							return flag;
						}
						$("#editcar")
								.submit(
										function() {
											if ($("#type").val() == ''
													|| $("#brand").val() == ''

													|| $("#introduction").val() == ''
													|| $("#manufactureDate")
															.val() == ''
													|| $("#state").val() == '') {

												alert("Incomplete infomation");
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
