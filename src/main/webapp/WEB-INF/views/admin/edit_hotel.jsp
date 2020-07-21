<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
 
<!DOCTYPE html>
<html>
<head>


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
	<a style="margin-left: 20px;   color: white;" href="/profile/${user.id}" >${user.email}</a>
	
</sec:authorize>
</nav> 
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<nav style="margin-top: 2%;" class="navbar navbar-expand-sm  bg-light">
	<a style="margin-left: 20px;   color: black;" href="/adminBoard/createHotel" > Додати готель</a>
	<a style="margin-left: 20px;   color: black;" href= "/adminBoard/addRoomType">Додати тип кімнати</a>
	<a style="margin-left: 20px;   color: black;" href= "/adminBoard/showAllOrdering">Замовлення</a>
	
	</nav>
</sec:authorize>
<div class="conteiner-fluid" >
	<div class=row >
	<div class="col-sm-2" ></div>
	<div class="col-sm-8" >
	<div style ="margin-top:3%" class="row" >
		<form:form action="${pageContext.request.contextPath}/adminBoard/editHotel/${hotelModel.id}"
		method="POST" modelAttribute="hotelModel" >
		<label style="width: 60px">Назва</label> <form:input path="name"/><br>
		<label style="width: 60px">Місто</label> <form:input path="city"/><br>
		<label style="width: 60px">Адреса</label> <form:input path="street"/><br>
		<input class="btn btn-dark" type="submit" value="Зберегти"  >
		</form:form>
	</div>
	<div class="row" >
	<!-- вивід кімнат готелю -->
	</div>
	<div class="row" >
	<!--show room from hotel  -->
	<table class="table table-stripped" >
	<tr>
		<td> Номер </td>
		<td> Тип кімнати </td>
		<td> Ціна </td>
	</tr>
	<c:forEach items="${roomsByHotel}" var="hotelRooms">
		<tr>
			<td> ${hotelRooms.number } </td>
			<td> ${hotelRooms.typeRoom.typeRoom } </td>
			<td> ${hotelRooms.price } </td>
		</tr>
	</c:forEach>
	</table>
	</div>
	<div class="row" >
	<!--add room to hotel  -->
	<form:form action="${pageContext.request.contextPath}/adminBoard/addRoom/${hotelModel.id}"
		method="POST" modelAttribute="roomModel" >
		<label style="width: 90px">Номер</label> <form:input path="number"/><br>
		<label style="width: 90px">Ціна</label>  <form:input path="price"/><br>
		<label style="width: 90px">Tип Кімнати</label> <form:select path="typeRoom">
			<form:options items="${roomTypes}" />
		</form:select>
		<br>
		<input class="btn btn-dark" type="submit" value="Зберегти" >
		</form:form>
	</div>
		
	</div>
	<div class="col-sm-2" ></div>
	</div>
</div>

</body>


</html>