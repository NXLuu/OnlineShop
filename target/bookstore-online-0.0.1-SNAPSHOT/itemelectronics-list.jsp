<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Electronic Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="<%=request.getContextPath()%>/electronics" class="navbar-brand"> Manager Electronics </a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Electronics</h3>
			<hr>
                        
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new-electronic" class="btn btn-success">Add New </a>
			</div>
			
			<br>
                        
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Producer</th>
                                                <th>Image</th>
						<th>Price</th>
						<th>Discount</th>
                                                <th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="itemElectronic" items="${listItemElectronic}">
						<tr>
							<td><c:out value="${itemElectronic.electronic.name}" /></td>
							<td><c:out value="${itemElectronic.electronic.producer}" /></td>
							<td><img src= "${itemElectronic.image}" width="350" height="300"/></td>
							<td><c:out value="${itemElectronic.price}" /></td>
                                                        <td><c:out value="${itemElectronic.discount}" /></td>
							<td><a href="editelectronics?id=<c:out value='${itemElectronic.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteelectronics?id=<c:out value='${itemElectronic.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
