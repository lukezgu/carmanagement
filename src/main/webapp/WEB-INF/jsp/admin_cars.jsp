<%@ page import="com.car.entity.Car"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>All vehicles</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>
</head>
<body>
	<jsp:include page="admin_main.jsp"></jsp:include>

	<div class="panel panel-default" style="width: 90%; margin-left: 5%">
		<div class="panel-heading" style="background-color: #fff">
			<h3 class="panel-title">All vehicles</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Plate_number</th>
						<th>Type</th>
						<th>Brand</th>
						<th>Introduction</th>
						<th>Date of manufacture</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cars}" var="car">
						<tr>
							<td><c:out value="${car.carId}"></c:out></td>
							<td><c:out value="${car.type}"></c:out></td>
							<td><c:out value="${car.brand}"></c:out></td>
							<td><c:out value="${car.introduction}"></c:out></td>
							<td><c:out value="${car.manufactureDate}"></c:out></td>

							<c:if test="${car.state==1}">

								<td><a
									href="rentcar.html?carId=<c:out value="${car.carId}"></c:out>"><button
											type="button" class="btn btn-primary btn-xs">Rent</button></a></td>
							</c:if>
							<c:if test="${car.state==0}">
								<td><a
									href="returncar.html?carId=<c:out value="${car.carId}"></c:out>"><button
											type="button" class="btn btn-primary btn-xs">Return</button></a></td>
							</c:if>
							<td><a
								href="cardetail.html?carId=<c:out value="${car.carId}"></c:out>"><button
										type="button" class="btn btn-success btn-xs">Detail</button></a></td>
							<td><a
								href="updatecar.html?carId=<c:out value="${car.carId}"></c:out>"><button
										type="button" class="btn btn-info btn-xs">Edit</button></a></td>
							<td><a
								href="deletecar.html?carId=<c:out value="${car.carId}"></c:out>"><button
										type="button" class="btn btn-danger btn-xs">Delete</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
