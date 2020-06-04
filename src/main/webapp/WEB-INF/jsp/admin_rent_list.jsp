<%@ page import="com.car.entity.Car"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Log</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>

</head>
<body>
	<jsp:include page="admin_main.jsp"></jsp:include>

	<div style="position: relative; top: 10%">
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
	<div class="panel panel-default" style="width: 90%; margin-left: 5%">
		<div class="panel-heading">
			<h3 class="panel-title">Log</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Car Plate Number</th>
						<th>Customer ID</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="alog">
						<tr>
							<td><c:out value="${alog.carId}"></c:out></td>
							<td><c:out value="${alog.customerId}"></c:out></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
