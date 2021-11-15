
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
<link rel="stylesheet" href="styles.css">
<link rel="stylesheet"
	href="https://kit-pro.fontawesome.com/releases/v5.12.1/css/pro.min.css">
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-4 g-3">
				<c:forEach var="itemBook" items="${listItemBook}">
					<div class="col">
						<div class="card shadow-sm">
							<img class="card-img-top figure-img img-fluid "
								style="height: 250px;" src="${itemBook.getCoverImage()}"
								alt="Card image cap">

							<div class="card-body d-flex align-items-center">
								<div>
									<h5 class="card-title">
										Title:
										<c:out value="${itemBook.getBook().getTitle()}" />
									</h5>
									<p class="card-text">
										Author:
										<c:out value="${itemBook.getBook().getAuthor()}" />

									</p>
									<h5 class="text-danger">
										Price:
										<c:out value="${itemBook.getPrice()}" />
									</h5>
									<a class="btn btn-primary"
										href="<%=request.getContextPath()%>/user/cart/add?id=<c:out value='${itemBook.getID()}' />">
										<i class="fas fa-cart-plus"></i> Add to cart
									</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>
</body>
</html>