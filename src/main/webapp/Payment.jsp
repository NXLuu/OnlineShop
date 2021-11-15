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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
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
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box
}

body {
	background-color: #eee
}

nav, .wrapper {
	padding: 10px 50px
}

nav .logo a {
	color: #000;
	font-size: 1.2rem;
	font-weight: bold;
	text-decoration: none
}

nav div.ml-auto a {
	text-decoration: none;
	font-weight: 600;
	font-size: 0.8rem
}

header {
	padding: 20px 0px
}

header .active {
	font-weight: 700;
	position: relative
}

header .active .fa-check {
	position: absolute;
	left: 50%;
	bottom: -27px;
	background-color: #fff;
	font-size: 0.7rem;
	padding: 5px;
	border: 1px solid #008000;
	border-radius: 50%;
	color: #008000
}

.progress {
	height: 2px;
	background-color: #ccc
}

.progress div {
	display: flex;
	align-items: center;
	justify-content: center
}

.progress .progress-bar {
	width: 40%
}

#details {
	padding: 30px 50px;
	min-height: 300px
}

input {
	border: none;
	outline: none
}

.form-group .d-flex {
	border: 1px solid #ddd
}

.form-group .d-flex input {
	width: 95%
}

.form-group .d-flex:hover {
	color: #000;
	cursor: pointer;
	border: 1px solid #008000
}

select {
	width: 100%;
	padding: 8px 5px;
	border: 1px solid #ddd;
	border-radius: 5px
}

input[type="checkbox"]+label {
	font-size: 0.85rem;
	font-weight: 600
}

#address, #cart, #summary {
	padding: 20px 50px
}

#address .d-md-flex p.text-justify, #register p.text-muted {
	margin: 0
}

#register {
	background-color: #d9ecf2
}

#register a {
	text-decoration: none;
	color: #333
}

#cart, #summary {
	max-width: 500px
}

.h6 {
	font-size: 1.2rem;
	font-weight: 700
}

.h6 a {
	text-decoration: none;
	font-size: 1rem
}

.item img {
	object-fit: cover;
	border-radius: 5px
}

.item {
	position: relative
}

.number {
	position: absolute;
	font-weight: 800;
	color: #fff;
	background-color: #0033ff;
	padding-left: 7px;
	border-radius: 50%;
	border: 1px solid #fff;
	width: 25px;
	height: 25px;
	top: -5px;
	right: -5px
}

.display-5 {
	font-size: 1rem
}

#cart ~p.text-muted {
	margin: 0;
	font-size: 0.9rem
}

tr.text-muted td {
	border: none
}

.fa-minus, .fa-plus {
	font-size: 0.7rem
}

.table td {
	padding: 0.3rem
}

.btn.text-uppercase {
	border: 1px solid #333;
	font-weight: 600;
	border-radius: 0px
}

.btn.text-uppercase:hover {
	background-color: #333;
	color: #eee
}

.btn.text-white {
	background-color: #66cdaa;
	border-radius: 0px
}

.btn.text-white:hover {
	background-color: #3cb371
}

.wrapper .row+div.text-muted {
	font-size: 0.9rem
}

.mobile, #mobile {
	display: none
}

.buttons {
	vertical-align: text-bottom
}

#register {
	width: 50%
}

@media ( min-width :768px) and (max-width: 991px) {
	.progress .progress-bar {
		width: 33%
	}
	#cart, #summary {
		max-width: 100%
	}
	.wrapper div.h5.large, .wrapper .row+div.text-muted {
		display: none
	}
	.mobile.h5, #mobile {
		display: block
	}
}

@media ( min-width : 576px) and (max-width: 767px) {
	.progress .progress-bar {
		width: 29%
	}
	#cart, #summary {
		max-width: 100%
	}
	.wrapper div.h5.large, .wrapper .row+div.text-muted {
		display: none
	}
	.mobile.h5, #mobile {
		display: block
	}
	.buttons {
		width: 100%
	}
}

@media ( max-width : 575px) {
	.progress .progress-bar {
		width: 38%
	}
	#cart, #summary {
		max-width: 100%
	}
	nav, .wrapper {
		padding: 10px 30px
	}
	#register {
		width: 100%
	}
}

@media ( max-width : 424px) {
	body {
		width: fit-content
	}
}

@media ( max-width : 375px) {
	.progress .progress-bar {
		width: 35%
	}
	body {
		width: fit-content
	}
}
</style>
<body>
	<jsp:include page="header.jsp" />
	<div class="wrapper">
	<form method="post" action="<%=request.getContextPath()%>/user/cart/add-order">
		<div class="h5 large">Shipment & Payment</div>
		<div class="row">
			<div
				class="col-lg-6 col-md-8 col-sm-10 offset-lg-0 offset-md-2 offset-sm-1">
				<div class="mobile h5">Shipment</div>
				<div id="details" class="bg-white rounded p-0">
					
						<div class="form-group mb-3">
							<label class="text-muted">Recipient</label> <input type="text"
								value="David Smith" class="form-control" name="recipient">
						</div>
						<div class="form-group mb-3">
							<label class="text-muted">Contact Phone</label>
							<div
								class="d-flex jusify-content-start align-items-center rounded p-2">
								<input type="text" value="012456789" name="contactPhone">
								<span class="fas fa-check text-success pr-sm-2 pr-0"></span>
							</div>
						</div>
						<div class="form-group mb-3">
							<label class="text-muted">Shipping Company</label> <select name="shippingCaompany">
								<option class="text-muted" value="Giao hang nhanh">Giao
									hang nhanh</option>
								<option class="text-muted" value="Viettel Post" >Viettel
									Post</option>
							</select>
						</div>
						
						<div class="form-group mb-3">
							<label class="text-muted">Payment Method</label> <select  name="paymentMethod">
								<option class="text-muted" value="Payment on Delivery">Payment on Delivery</option>
								<option class="text-muted" value="Credit Card">Credit Card</option>
							</select>
						</div>
					
				</div>
				<input type="checkbox" checked> <label>Shipping
					address is same as billing</label>
				<div id="address" class="bg-light rounded mt-3">
					<div class="h5 font-weight-bold text-primary">Shopping
						Address</div>
					<div
						class="d-md-flex justify-content-md-start align-items-md-center pt-3">
						<div class="mr-auto">
							<b>Home Address</b>
							<p class="text-justify text-muted">
								<c:out value="${customer.getAddress().getNumberHome()}" />
								<c:out value="${customer.getAddress().getStreet()}" />
								Street
							</p>
							<p class="text-uppercase text-muted">
								<c:out value="${customer.getAddress().getDistrict()}" />
								,
								<c:out value="${customer.getAddress().getCity()}" />
							</p>
						</div>
						<div class="rounded py-2 px-3" id="register">
							<a href="#"> <b>Change Address</b>
							</a> <a class="btn btn-outline-primary w-50 ">Create new Address</a>
						</div>
					</div>
				</div>
			</div>
			<div
				class="col-lg-6 col-md-8 col-sm-10 offset-lg-0 offset-md-2 offset-sm-1 pt-lg-0 pt-3">
				<div id="cart" class="bg-white rounded">
					<div class="d-flex justify-content-between align-items-center">
						<div class="h6">Cart Summary</div>
						<div class="h6">
							<a href="<%=request.getContextPath()%>/user/cart">Edit</a>
						</div>
					</div>
					
					<c:forEach var="itemBook" items="${listItemBook}">
							<div
						class="d-flex jusitfy-content-between align-items-center pt-3 pb-2 border-bottom">
								<div class="item pr-2">
									<img alt="" width="80" height="80" src="${itemBook.getCoverImage()}"
										style="height: 60px;">
								</div>
								<div class="d-flex flex-column px-3">
									<b class="h5"><c:out value="${itemBook.getBook().getTitle()}" /></b> <a href="#"
									class="h5 text-primary"><c:out value="${itemBook.getBook().getAuthor()}" /></a>
								</div>
								
								<div class="ml-auto">
									<b class="h5"><c:out value="${itemBook.getPrice()}" /></b>
								</div>
				
								
							</div>
					</c:forEach>
					<%
					float totalMoney = 0;
					List<ItemBook> listItemBook = (List) request.getAttribute("listItemBook");
					for (ItemBook itemBook : listItemBook) {
						totalMoney += itemBook.getPrice();
					}
					%>
					<div class="my-3">
						<input type="text" class="w-100 form-control text-center"
							placeholder="Gift Card or Promo Card">
					</div>
					<div class="d-flex align-items-center">
						<h4>Subtotal</h4>
						<div class="ml-auto font-weight-bold"><%=totalMoney%></div>
					</div>
					<div class="d-flex align-items-center py-2 border-bottom">
						<h4>Shipping</h4>
						<div class="ml-auto font-weight-bold">10</div>
					</div>
					<div class="d-flex align-items-center py-2">
						<h4>Total</h4>
						<div class="ml-auto d-flex">
							<div class="text-primary text-uppercase px-3">usd</div>
							<div class="font-weight-bold"><%=totalMoney+10%></div>
						</div>
					</div>
					<div class="h4 pt-3">
					<span class="fas fa-shield-alt text-primary pr-2"></span> Security
					of your shopping
				</div>
				<div class="row pt-lg-3 buttons mb-sm-0 mb-2">
					<div class="col-md-6">
						<a class="btn text-uppercase" href="<%=request.getContextPath()%>">back to shopping</a>
					</div>
					<div class="col-md-6 pt-md-0 pt-3">
						<button class="btn text-white ml-auto" type="submit">
							<span class="fas fa-lock"></span> Checkout
						</button>
					</div>
				</div>
				<div class="text-muted pt-3" id="mobile">
					<span class="fas fa-lock"></span> Your information is save
				</div>
				</div>
				<input type="hidden" value="<%=totalMoney+10%>" name="totalMoney" />
				
			</div>
			</form>
		</div>
		<div class="text-muted">
			<span class="fas fa-lock"></span> Your information is save
		</div>
	</div>




</body>
</html>