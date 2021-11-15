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
	<jsp:include page="header.jsp" />


	<div class="container px-4  ">

		<section
			class="text-center d-flex align-items-center justify-content-between py-2 mt-5 border-bottom border-top">
			<h4 class="m-0">Item Book Management</h4>
			<h5 class="m-0 d-flex">
				<a class="btn btn-primary me-2"
					href="<%=request.getContextPath()%>/admin/item-book/new"><i
					class="bi bi-plus-circle"></i> Add New Item Book</a>
				<form class="d-flex m-0" action="search" method="post">
					<input class="form-control me-2" type="search"
						placeholder="Title of Book" aria-label="Search" name="searchTitle"
						value="<c:out value='${searchTitle}' />">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</h5>
		</section>
		
		<table class="table table-hover shadow align-middle">
			<thead class="bg-dark text-white">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Cover Image</th>
					<th scope="col">Price</th>
					<th scope="col">Book</th>
					<th scope="col" class="w-25">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="itemBook" items="${listItemBook}">
					<tr>
						<td style="font-family: 'Press Start 2P', cursive;"><c:out
								value="${itemBook.getID()}" /></td>
						<td><c:if test="${itemBook.getCoverImage() == null}">
								<img class="img-fluid"
									style="width: 40px; height: 40px;"
									src="http://res.cloudinary.com/multichoice/image/upload/v1630841637/lfwmtioizab0976ebcna.png">
							</c:if> <c:if test="${itemBook.getCoverImage() != null}">
								<img class="rounded-circle img-fluid"
									style="width: 40px; height: 40px;"
									src="<c:out value="${itemBook.getCoverImage()}" />" alt="...">
							</c:if></td>
						<td><c:out value="${itemBook.getPrice()}" /></td>
						<td><c:out
								value="${itemBook.getBook().getTitle()} - ${itemBook.getBook().getAuthor()}" /></td>
						<td>
							<div>
								<a class="btn btn-outline-primary"
									href="<%=request.getContextPath()%>/admin/item-book//edit?id=<c:out value='${itemBook.getID()}' />"><i
									class="bi bi-pencil-fill"></i> Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
									class="btn btn-outline-danger"
									href="<%=request.getContextPath()%>/admin/item-book/delete?id=<c:out value='${itemBook.getID()}' />"><i
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