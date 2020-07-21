<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
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
<div class ="conteiner-fluid" >
	<div style="margin-top: 3%" class = "row" >
		<div class="col-sm-1" ></div>
		<div class="col-sm-9" >
			<div class="row" >
				<table class="table table-stripped">
					<tr>
						<td>ID</td>
						<td>Дата поселення</td>
						<td>Дата виселення</td>
						<td>ID кімнати</td>
						<td>Номер кімнати</td>
						<td>Тип</td>
						<td>ID готелю</td>
						<td>Готель</td>
						<td>Місто</td>
						<td>Адрес</td>
						<td>ID користувача</td>
						<td>ПІП</td>
						<td>Email</td>
					</tr>
					<c:forEach items="${orders}" var="o" >
						<tr>
							<td>${o.id}</td>
							<td>${o.dateOfSettlement}</td>
							<td>${o.departureDate}</td>
							<td>${o.room.id}</td>
							<td>${o.room.number}</td>
							<td>${o.room.typeRoom.typeRoom}</td>
							<td>${o.room.hotel.id}</td>
							<td>${o.room.hotel.name}</td>
							<td>${o.room.hotel.city}</td>
							<td>${o.room.hotel.street}</td>
							<td>${o.userEntity.id}</td>
							<td>${o.userEntity.fullName}</td>
							<td>${o.userEntity.email}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class=col-sm-2 ></div>
	</div>
</div>
</body>
</html>