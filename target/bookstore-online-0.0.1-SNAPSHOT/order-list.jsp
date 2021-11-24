<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/source/styles.css" />
<link rel="stylesheet"
	href="https://kit-pro.fontawesome.com/releases/v5.12.1/css/pro.min.css">
<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
</head>
<body>

	<a class="btn btn-primary" href="<%=request.getContextPath()%>/Home">Back to shop</a>

	<div class="container px-4  ">

		<section
			class="text-center d-flex align-items-center justify-content-between py-2 mt-5 border-bottom border-top">
			<h4 class="m-0">Order Management</h4>
			<h5 class="m-0 d-flex"></h5>
		</section>

		<table class="table table-hover shadow align-middle">
			<thead class="bg-dark text-white">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Price</th>
					<th scope="col">status</th>
					<th scope="col">item</th>
					<th scope="col">Ship</th>
					<th scope="col" class="w-25">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" begin="0" end="${listOrder.size()-1}">
					<tr>
						<td style="font-family: 'Press Start 2P', cursive;"><c:out
								value="${listOrder.get(i).getID()}" /></td>

						<td><c:out value="${listOrder.get(i).getTotalPrice()}" /></td>
						<td><c:out value="${listOrder.get(i).getStatus()}" /></td>
						<td><c:forEach var="item" items="${cartMap.get(i)}">
								<p class="m-0">
									<c:out value="${item}" />
								</p>
							</c:forEach></td>

						</td>
						<td><c:out
								value="${listOrder.get(i).getShipment().getMethod()} - ${listOrder.get(i).getShipment().getPrice()}" /></td>
						<td>
							<div>
								<a class="btn btn-outline-primary"
									href="<%=request.getContextPath()%>/admin/item-book//edit?id=<c:out value='${order.getID()}' />"><i
									class="bi bi-pencil-fill"></i> Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
									class="btn btn-outline-danger"
									href="<%=request.getContextPath()%>/admin/item-book/delete?id=<c:out value='' />"><i
									class="bi bi-trash-fill"></i> Delete</a>
							</div>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>







</body>
</html>