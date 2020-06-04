<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>${detail.carId}</title>
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
				<h3 class="panel-title">${detail.carId}</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<tr>
						<th>Plate</th>
						<td>${detail.carId}</td>
					</tr>
					<tr>
						<th width="15%">Type</th>
						<td>${detail.type}</td>
					</tr>
					<tr>
						<th>Brand</th>
						<td>${detail.brand}</td>
					</tr>
					<tr>
						<th>Introduction</th>
						<td>${detail.introduction}</td>
					</tr>
					<tr>
						<th>Date of manufacture</th>
						<td>${detail.manufactureDate}</td>
					</tr>
					<tr>
						<th>State</th>
						<c:if test="${detail.state==1}">
							<td>Available</td>
						</c:if>
						<c:if test="${detail.state==0}">
							<td>Rented out</td>
						</c:if>

					</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>

</body>
</html>
