
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
	<%

	%>
	<jsp:include page="header.jsp" />
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post" enctype="multipart/form-data">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post" enctype="multipart/form-data">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New Item Book
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Price of Item book</label> <input type="text"
						class="form-control" name="price" required="required">
				</fieldset>

				<select class="form-select mt-3 p-2"
					aria-label="Default select example" name="book">

					<option selected>Select Book</option>
					<c:forEach var="book" items="${listBook}">
						<option value="${book.getId()}"><c:out
								value="${book.getId()} - ${book.getTitle()} - ${book.getAuthor()}" /></option>
					</c:forEach>
				</select>

				<div class="mb-3 mt-3">
					<label for="formFile" class="form-label">Cover Image</label> <input
						class="form-control" type="file" id="formFile" name="coverImage">
				</div>
				<button type="submit" class="btn btn-success mt-4">Save</button>
				</form>
			</div>
		</div>



	</div>
</body>
</html>