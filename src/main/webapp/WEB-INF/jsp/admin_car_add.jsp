<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>New car</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>

</head>
<body>
	<jsp:include page="admin_main.jsp"></jsp:include>

	<div style="position: relative; top: 10%; width: 80%; margin-left: 10%">
		<form action="car_add_do.html" method="post" id="addcar">
			<div class="form-group">
				<label for="carId">Plate number</label> <input type="text"
					class="form-control" name="carId" id="carId"
					placeholder="Plate number">
			</div>
			<div class="form-group">
				<label for="type">Type</label> <input type="text"
					class="form-control" name="type" id="type"
					placeholder="Sedan, Coupe, Convertible, SUV, Sports car, etc">
			</div>
			<div class="form-group">
				<label for="brand">Brand</label> <input type="text"
					class="form-control" name="brand" id="brand"
					placeholder="BMW, Honda, etc">
			</div>

			<div class="form-group">
				<label for="introduction">Introduction</label>
				<textarea class="form-control" rows="3" name="introduction"
					id="introduction" placeholder="Introduction"></textarea>
			</div>
			<div class="form-group">
				<label for="manufactureDate">Date of manufacture</label> <input
					type="text" class="form-control" name="manufactureDate"
					id="manufactureDate" placeholder="Date of manufacture">
			</div>
			<input type="submit" value="Submit" class="btn btn-success btn-sm"
				class="text-left">
			<script>
				function mySubmit(flag) {
					return flag;
				}
				$("#addcar").submit(
						function() {
							if ($("#type").val() == ''
									|| $("#brand").val() == ''
									|| $("#carId").val() == ''
									|| $("#introduction").val() == ''
									|| $("#manufactureDate").val() == '') {
								alert("Incomplete infomation");
								return mySubmit(false);
							}
						})
			</script>
		</form>
	</div>
</body>
</html>
