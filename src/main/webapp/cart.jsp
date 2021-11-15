<%@page import="java.util.List"%>
<%@page import="model.itemBook.ItemBook"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	integrity="sha512-braXHF1tCeb8MzPktmUHhrjZBSZknHvjmkUdkAbeqtIrWwCchhcpUeAf2Sq3yIq1Q1x5PlroafjceOUbIE3Q5g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/alpinejs/2.3.0/alpine.js"
	integrity="sha512-nIwdJlD5/vHj23CbO2iHCXtsqzdTTx3e3uAmpTm4x2Y8xCIFyWu4cSIV8GaGe2UNVq86/1h9EgUZy7tn243qdA=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</head>
<style>
.styleCart .title {
	margin-bottom: 5vh
}

.styleCart .card {
	margin: auto;
	max-width: 950px;
	width: 90%;
	box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
	border-radius: 1rem;
	border: transparent
}

@media ( max-width :767px) {
	.styleCart .card {
		margin: 3vh auto
	}
}

.styleCart .cart {
	background-color: #fff;
	padding: 4vh 5vh;
	border-bottom-left-radius: 1rem;
	border-top-left-radius: 1rem
}

@media ( max-width :767px) {
	.styleCart .cart {
		padding: 4vh;
		border-bottom-left-radius: unset;
		border-top-right-radius: 1rem
	}
}

.styleCart .summary {
	background-color: #ddd;
	border-top-right-radius: 1rem;
	border-bottom-right-radius: 1rem;
	padding: 4vh;
	color: rgb(65, 65, 65)
}

@media ( max-width :767px) {
	.styleCart .summary {
		border-top-right-radius: unset;
		border-bottom-left-radius: 1rem
	}
}

.styleCart .summary .col-2 {
	padding: 0
}

.styleCart.summary .col-10 {
	padding: 0
}

.styleCart .row {
	margin: 0
}

.styleCart .title b {
	font-size: 1.5rem
}

.styleCart .main {
	margin: 0;
	padding: 2vh 0;
	width: 100%
}

.styleCart .col-2, .col {
	padding: 0 1vh
}

.styleCart a {
	padding: 0 1vh
}

.styleCart .close {
	margin-left: auto;
	font-size: 0.7rem
}

.styleCart .close:hover {
	cursor: pointer;
}

.styleCart img {
	width: 3.5rem
}

.styleCart .back-to-shop {
	margin-top: 4.5rem
}

.styleCart h5 {
	margin-top: 4vh
}

.styleCart hr {
	margin-top: 1.25rem
}

.styleCart form {
	padding: 2vh 0
}

.styleCart select {
	border: 1px solid rgba(0, 0, 0, 0.137);
	padding: 1.5vh 1vh;
	margin-bottom: 4vh;
	outline: none;
	width: 100%;
	background-color: rgb(247, 247, 247)
}

.styleCart input {
	border: 1px solid rgba(0, 0, 0, 0.137);
	padding: 1vh;
	margin-bottom: 4vh;
	outline: none;
	width: 100%;
	background-color: rgb(247, 247, 247)
}

.styleCart input:focus::-webkit-input-placeholder {
	color: transparent
}

.styleCart .btn {
	background-color: #000;
	border-color: #000;
	color: white;
	width: 100%;
	font-size: 0.7rem;
	margin-top: 4vh;
	padding: 1vh;
	border-radius: 0
}

.styleCart .btn:focus {
	box-shadow: none;
	outline: none;
	box-shadow: none;
	color: white;
	-webkit-box-shadow: none;
	-webkit-user-select: none;
	transition: none
}

.styleCart .btn:hover {
	color: white
}

.styleCart a {
	color: black
}

.styleCart a:hover {
	color: black;
	text-decoration: none
}

.styleCart #code {
	background-image: linear-gradient(to left, rgba(255, 255, 255, 0.253),
		rgba(255, 255, 255, 0.185)),
		url("https://img.icons8.com/small/16/000000/long-arrow-right.png");
	background-repeat: no-repeat;
	background-position-x: 95%;
	background-position-y: center
}
</style>
<body style="background-color: #D1D5DB;">
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="card styleCart mt-4">
			<div class="row">
				<div class="col-md-8 cart">
					<div class="title">
						<div class="row">
							<div class="col">
								<h4>
									<b>Shopping Cart</b>
								</h4>
							</div>
							<div class="col align-self-center text-right text-muted">
								<c:out value="${listItemBook.size()}" />
								items
							</div>
						</div>
					</div>
					<c:forEach var="itemBook" items="${listItemBook}">
						<div class="row">
							<div class="row main align-items-center">
								<div class="col-2">
									<img class="img-fluid" src="${itemBook.getCoverImage()}"
										style="height: 60px;">
								</div>
								<div class="col">
									<div class="row text-muted">
										<c:out value="${itemBook.getBook().getTitle()}" />
									</div>
									<div class="row">
										<c:out value="${itemBook.getBook().getAuthor()}" />
									</div>
								</div>
								<div class="col">
									<a href="#">-</a><a href="#" class="border">1</a><a href="#">+</a>
								</div>
								<div class="col">
									&euro;
									<c:out value="${itemBook.getPrice()}" />
									<a class="close"
										href="<%=request.getContextPath()%>/user/cart/delete?id=<c:out value='${itemBook.getID()}' />">&#10005;</a>
								</div>
							</div>
						</div>

					</c:forEach>
					<div class="back-to-shop">
						<a href="<%=request.getContextPath()%>/">&leftarrow; <span
							class="text-muted"> Back to shop</span></a>
					</div>
				</div>
				<div class="col-md-4 summary">
					<div>
						<h5>
							<b>Summary</b>
						</h5>
					</div>
					<hr>
					<%
					float totalMoney = 0;
					List<ItemBook> listItemBook = (List) request.getAttribute("listItemBook");
					for (ItemBook itemBook : listItemBook) {
						totalMoney += itemBook.getPrice();
					}
					%>
					<div class="row">
						<div class="col" style="padding-left: 0;">
							ITEMS
							<c:out value="${listItemBook.size()}" />
						</div>
						<div class="col text-right">
							&euro;
							<%=totalMoney%></div>
					</div>
					<input type="hidden" name="totalMoney" value="<%=totalMoney%>" />
					<form>
						<p>GIVE CODE</p>
						<input id="code" placeholder="Enter your code">
					</form>
					<div class="row"
						style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">

						<div class="col">TOTAL PRICE</div>
						<div class="col text-right">
							&euro;
							<%=totalMoney%></div>
					</div>
					<a class="btn" href="<%=request.getContextPath()%>/user/cart/payment">CHECKOUT</a>
				</div>
			</div>
		</div>
	</div>



</body>
</html>