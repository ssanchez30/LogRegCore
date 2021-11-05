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

	<div class="container">

		<nav
			class="navbar navbar-expand-lg navbar-light bg-light d-flex justify-content-between">
			<h1>Hello, <c:out value="${firstName}"></c:out><c:out value=" ${lastName}"></c:out> </h1>

			<form action="/logout" method="GET" class="form-inline my-2 my-lg-0">

				<button type="submit" class="btn btn-outline-info my-2 my-sm-0"
					type="submit">Logout</button>
			</form>

		</nav>
		
		<h1>User Dashboard</h1>
		
		</div>

<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="./js/script.js" ></script>

</body>