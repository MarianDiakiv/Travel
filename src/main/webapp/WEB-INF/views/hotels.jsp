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
	<a style="margin-left: 20px;   color: white;" href="/profile/${user.id}" >${username}</a>
	 <form:form style ="margin-top: 20px; margin-left:20px;" action="${pageContext.request.contextPath}/hotels/city"
	  method="POST" modelAttribute="searchCity" >
		<label class ="text-secondary">Місто</label> <form:input path="city"/>
		<input class="btn btn-dark" type="submit" value="Пошук" >
		
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

<div class ="conteiner-fluid" >
	<div class="row" >
	<div class="col-sm-2"></div>
	<div style ="margin-top:3%" class="col-sm-8">
		
		<c:forEach items="${hotelsModel}" var="hotel" >
			<a href="${pageContext.request.contextPath}/hotel_details/${hotel.id}" >
			<div style="margin-top:1%;" class="row" >
				
				<span style ="color:black; margin-left:20px;">${hotel.name}</span>
				<span style ="color:black; margin-left:20px;" > Місто ${hotel.city}</span>
				<span style ="color:black; margin-left:20px;" > Адрес ${hotel.street}</span>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a href="${pageContext.request.contextPath}/adminBoard/editHotel/${hotel.id}" >Редагувати </a>
				</sec:authorize>
			</div>
			</a>
			
		</c:forEach>
	</div>
	<div class="col-sm-2"></div>
	</div>
</div>
</body>
</html>