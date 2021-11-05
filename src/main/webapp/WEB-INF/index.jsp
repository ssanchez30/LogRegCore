<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>

	<c:set var="mensaje" value="${errorMessage }" />
	<c:if test="${mensaje != null }">

		<div
			class="alert alert-${clase} alert-dismissible fade show messageOut"
			role="alert">
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
			<strong><c:out value="${errorMessage }"></c:out></strong>
		</div>
	</c:if>


	<div class="container d-flex flex-row">



		<div class="col-5">


			<form action="/users/add" method="POST" class="bg-dark px-4">

				<h1 class="text-primary text-center py-3">Register</h1>

				<label for="firstname" class="form-label text-white">FirstName:</label>
				<input type="text" id="firstname" name="firstname" class="form-control mb-3">
				
				<label for="lastname" class="form-label text-white">LastName: </label> 
				<input type="text" id="lastname" name="lastname" class="form-control mb-3"> 
				
				<label for="email" class="form-label text-white">Email: </label>
				<input type="email" id="email" name="email" class="form-control mb-3">
				
				<label for="password" class="form-label text-white">Password:</label>
				<input type="password" id="password" name="password" class="form-control mb-3">
				
				<label for="confpass" class="form-label text-white">Confirm Password: </label>
				<input type="password" id="confpass" name="confpass" class="form-control mb-3">
				
				<button type="submit" class="btn btn-primary my-4">Register</button>

			</form>

		</div>

		<div class="col-2"></div>

		<div class="col-5">

			<form action="/authentication" method="POST" class="bg-dark px-3">

				<h1 class="text-success text-center py-4">Login</h1>
				
				<label for="logEmail" class="form-label text-white">Email:</label>
				<input type="email" id="logEmail" name="logEmail" class="form-control mb-3">
				
				<label for="logPass" class="form-label text-white">Password:</label>
				<input type="password" id="logPass" name="logPass" class="form-control mb-3">
				
				<button type="submit" class="btn btn-success my-4">Login</button>

			</form>

		</div>

	</div>


	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script src="./js/script.js"></script>

</body>
</html>