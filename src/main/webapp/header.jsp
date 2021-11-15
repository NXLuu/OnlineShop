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
	<header class="p-3 bg-dark text-white">
		<div></div>
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="<%=request.getContextPath()%>"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
					User Management App </a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 p-0">
					<li><a href="<%=request.getContextPath()%>/list"
						class="nav-link px-2 text-secondary">User</a></li>
				</ul>




				<div class="text-end d-flex align-items-center">
					<c:if test="${customer == null}">
						<a class="btn btn-outline-light me-2"
							href="<%=request.getContextPath()%>/login">Login</a>
							<a class="btn btn-warning"
							href="<%=request.getContextPath()%>/sign-up">Sign up</a>
					</c:if>

					<c:if test="${customer != null}">
						<span class="fs-4 pe-4 m-0"><c:out
								value="Hello ${customer.getName()}"></c:out></span>
						<a class="btn btn-outline-light me-2"
							href="<%=request.getContextPath()%>/logout">Logout</a>
						<a class="btn btn-warning"
							href="<%=request.getContextPath()%>/sign-up">Sign up</a>
					</c:if>

				</div>

				<a class="ms-3 btn btn-outline-secondary bg-light text-dark"
					href="<%=request.getContextPath()%>/user/cart"> <i
					class="far fa-shopping-cart"></i>
				</a>
			</div>
		</div>
	</header>



</body>
</html>