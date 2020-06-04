<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Customer list</title>
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


	<div class="panel panel-default"
		style="position: relative; top: 80px; width: 90%; margin-left: 5%">
		<div class="panel-heading">
			<h3 class="panel-title">Customer list</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Customer ID</th>
						<th>Name</th>
						<th>Sex</th>
						<th>Birth</th>
						<th>Address</th>
						<th>Tel</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${customers}" var="customer">
						<tr>
							<td><c:out value="${customer.customerId}"></c:out></td>
							<td><c:out value="${customer.name}"></c:out></td>
							<td><c:out value="${customer.sex}"></c:out></td>
							<td><c:out value="${customer.birth}"></c:out></td>
							<td><c:out value="${customer.address}"></c:out></td>
							<td><c:out value="${customer.tel}"></c:out></td>
							<td><a
								href="customer_edit.html?customerId=<c:out value="${customer.customerId}"></c:out>"><button
										type="button" class="btn btn-info btn-xs">Edit</button></a></td>
							<td><a
								href="customer_delete.html?customerId=<c:out value="${customer.customerId}"></c:out>"><button
										type="button" class="btn btn-danger btn-xs">Delete</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
