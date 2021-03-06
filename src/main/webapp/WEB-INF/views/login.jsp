<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Login</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/home">DMMTravel</a>
  <sec:authorize access="!isAuthenticated()">
	<a style="margin-left: 20px;   color: white;" href="/login" > Login</a>
	<br>
	<a style="margin-left: 20px;   color: white;" href="/register" > Register</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<a style="margin-left: 20px;   color: white;" href="/hotels" > Готелі</a>
	<br>
	<a style="margin-left: 20px;   color: white;" href="/profile/${user.id}" >${username}</a>
</sec:authorize>
  
</nav> 

	
	
	<div class="row" >
		<div class="col-sm-2" ></div>
		<div class =col-sm-8 >
			<div style="margin-left:25%;
						margin-top:5%">
				<h1>Вхід</h1>
				<c:if test="${param.fail}">
					<p>Fail to autorize</p>
				</c:if>
				
				<form:form action="/login" modelAttribute="userModel" method="POST">
		 		<label>Email </label><br>
		 		<form:input type="text" path="email"/><br>
		 		<label>Пароль</label><br>
		 		<form:password path="password"/><br>
		 		<input style="margin-top: 3%;  width: 185px;" class="btn btn-dark" type="submit" value="Увійти">
		 		<!-- <label> Remamber Me</label>
		 		<input type="checkbox" name="rememberme"> -->
		 		</form:form>
			</div>
				
		</div>
		<div class="col-sm-2" ></div>
	</div>

</body>
</html>
