<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="conteiner-fluid">
 
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
	<a style="margin-left: 20px;   color: white;"  href="/profile/${user.id}" >${user.email}</a>
	<form:form action="/logout" method="POST">
	<input style="    margin-top: 15;" class="btn  btn-dark" type="submit" value="Вийти">
	</form:form>
</sec:authorize>
</nav> 
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<nav style="margin-top: 2%;" class="navbar navbar-expand-sm  bg-light">
	<a style="margin-left: 20px;   color: black;" href="/adminBoard/createHotel" > Додати готель</a>
	<a style="margin-left: 20px;   color: black;" href= "/adminBoard/addRoomType">Додати тип кімнати</a>
	<a style="margin-left: 20px;   color: black;" href= "/adminBoard/showAllOrdering">Замовлення</a>
	
	</nav>
</sec:authorize>


<div class="row" >
	<div class=col-sm-2 ></div>
	<div class=col-sm-8 >
		<div class="row" >
		<!-- edit user  -->
		<form:form action="${pageContext.request.contextPath}/user/edit/${user.id}"
		method="POST" modelAttribute="user" >
		<label style ="    width: 100px;">Вік</label><form:input path="age"/><br>
		<label style ="    width: 100px;">Повне ім'я</label><form:input path="fullName"/><br>
		<label style ="    width: 100px;">Email</label><form:input path="email"/><br>
		<input class="btn btn-dark" type="submit" value="Зберегти" >
		</form:form>
		</div>
		<div class="row" >
		
		</div>
	</div>
	<div class="col-sm-2" ></div>
</div>
<div class="row" >
	<<%-- form:form action="${pageContext.request.contextPath}/uploadFile/${user.id}" method="POST" 
  enctype="multipart/form-data" modelAttribute="fileModel">
  	<form:input type="file" path="fileData"/><br>
  	<input type="submit" value="Upload File">
	</form:form>
</div>
<div  class ="row">
  <form action="${pageContext.request.contextPath}/uploadFile/${user.id}" method="POST" 
  enctype="multipart/form-data">
  <input type="file" name = "fileData"><br>
  <input type="submit" value="Upload File" >
  </form>
  </div> --%>

</body>
</html>