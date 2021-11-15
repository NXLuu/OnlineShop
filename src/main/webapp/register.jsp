<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://kit-pro.fontawesome.com/releases/v5.12.1/css/pro.min.css">
</head>
<body class="bg-secondary">
	<header class="p-3 bg-dark text-white">
		<div class="container">
			<div
				class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
				<a href="<%=request.getContextPath()%>"
					class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
					User Management App </a>

				<ul
					class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
					<li><a href="<%=request.getContextPath()%>/list"
						class="nav-link px-2 text-secondary">User</a></li>
				</ul>

				<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
					<input type="search" class="form-control form-control-dark"
						placeholder="Search..." aria-label="Search">
				</form>

				<div class="text-end">
					<c:if test="${isLoggedIn == null}">
						<a class="btn btn-outline-light me-2"
							href="<%=request.getContextPath()%>/login">Login</a>
					</c:if>
					<c:if test="${isLoggedIn != null}">
						<a class="btn btn-outline-light me-2"
							href="<%=request.getContextPath()%>/logout">Logout</a>
					</c:if>


					<a class="btn btn-warning"
						href="<%=request.getContextPath()%>/sign-up">Sign up</a>
				</div>
			</div>
		</div>
	</header>

	<div
		class="modal modal-signin position-static d-block bg-secondary py-5"
		tabindex="-1" role="dialog" id="modalSignin">
		<div class="modal-dialog" role="document">
			<div class="modal-content rounded-5 shadow">
				<div class="modal-header p-5 pb-4 border-bottom-0">
					<!-- <h5 class="modal-title">Modal title</h5> -->
					<h2 class="fw-bold mb-0">Sign Up</h2>

					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>



				<div class="modal-body p-5 pt-0">
					<c:if test="${message != null}">
						<div class="alert alert-danger d-flex align-items-center"
							role="alert">
							<i class="fas fa-exclamation-triangle pe-2"></i>
							<div>
								<c:out value="  ${message}" />
							</div>
						</div>
					</c:if>

					<form method="post" action="sign-up">
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-4"
								id="floatingFullName" placeholder="fullname" name="fullname">
							<label for="floatingFullName">Full name</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-4"
								id="floatingPhone" placeholder="Phone" name="phone">
							<label for="floatingPhone">Phone</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-4"
								id="floatingEmail" placeholder="name@example.com" name="email">
							<label for="floatingInputEmail">User Name</label>
						</div>
						<div class="form-floating mb-3">
							<input type="password" class="form-control rounded-4"
								id="floatingPassword" placeholder="Password" name="password">
							<label for="floatingPassword">Password</label>
						</div>
						
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-4"
								id="floatingNumberHome" placeholder="Number Home" name="numberHome">
							<label for="floatingNumberHome">Number Home</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-4"
								id="floatingStreet" placeholder="Street" name="street">
							<label for="floatingStreet">Street</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-4"
								id="floatingDistrict" placeholder="Number Home" name="district">
							<label for="floatingDistrict">District</label>
						</div>
						<div class="form-floating mb-3">
							<input type="text" class="form-control rounded-4"
								id="floatingCity" placeholder="City" name="city">
							<label for="floatingCity">City</label>
						</div>
						<button class="w-100 mb-2 btn btn-lg rounded-4 btn-primary"
							type="submit">Sign Up</button>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>