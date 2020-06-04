<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>${customercard.name}'s home page</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>
</head>
<body>
	<jsp:include page="customer_main.jsp"></jsp:include>

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
	<div class="col-xs-5 col-md-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">My info</h3>
				
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<tr>
						<th width="20%">Customer ID</th>
						<td>${customerinfo.customerId}</td>
					</tr>
					<tr>
						<th>Name</th>
						<td>${customerinfo.name}</td>
					</tr>
					<tr>
						<th>Sex</th>
						<td>${customerinfo.sex}</td>
					</tr>
					<tr>
						<th>Birth</th>
						<td>${customerinfo.birth}</td>
					</tr>
					<tr>
						<th>Address</th>
						<td>${customerinfo.address}</td>
					</tr>
					<tr>
						<th>Tel</th>
						<td>${customerinfo.tel}</td>
					</tr>
					</tbody>
				</table>
			</div>
			<a class="btn btn-success btn-sm" href="customer_info_edit.html"
				role="button">Edit</a>
		</div>
	</div>
</body>
</html>
