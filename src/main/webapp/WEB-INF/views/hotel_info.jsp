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
	 <form:form style ="margin-top: 20px; margin-left:20px;" action="${pageContext.request.contextPath}/hotels/city"
	  method="POST" modelAttribute="searchCity" >
		<label class ="text-secondary">Місто</label> <form:input path="city"/>
		<input  class="btn btn-dark" type="submit" value="Пошук" >
		
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
<div class="conteiner-fluid" >
<div class="row">
	<div class="col-sm-2" ></div>
	<div class="col-sm-8" >
	<!-- main content   -->
		<div style="margin-top:2%" class="row" > 
			<div class = "col-sm-3" >Назва готелю</div>
			<div class = "col-sm-9" >${hotel.name}</div>
		</div>
		<div class="row" > 
			<div class = "col-sm-3" >Місто</div>
			<div class = "col-sm-9" >${hotel.city}</div>
		</div>
		<div class="row" > 
			<div class = "col-sm-3" >Вулиця</div>
			<div class = "col-sm-9" >${hotel.street}</div>
		</div>
		<div style="margin-top:2%" class="row" >
			<form:form action="${pageContext.request.contextPath}/findfreerooms/${hotel.id}"
			method="POST" modelAttribute="dateAtrr">
				 <label style="margin-left:20px;">Оберіть дату поселення</label><form:input style="margin-left:20px;" path="date1" type="Date"/>
				 <label style="margin-left:20px;">Оберіть дату виселення</label><form:input style="margin-left:20px;" path="date2" type="Date"/>
				 <input class="btn btn-light" type="Submit" value="Підтвердити"  >
			</form:form>
		</div>
		<div class="row" >
			<p style="font-size: 17px; ">Кімнати</p>
			<table class="table table-stripped" >
				<tr>
					<td>Номер</td>
					<td>Тип кімнати</td>
					<td>Ціна</td>
					<td>Бронювання</td>
				</tr>
				<c:forEach items="${roomsByHotel}" var="hotelRooms">
		<tr>
			<td> ${hotelRooms.number } </td>
			<td> ${hotelRooms.typeRoom.typeRoom } </td>
			<td> ${hotelRooms.price } </td>
			<%-- <td><a href="${pageContext.request.contextPath}/order/${hotelRooms.id}/${dateAtrr}" >Забронювати</a></td> --%>
			<td> <form:form action="${pageContext.request.contextPath}/order/${hotelRooms.id}"
			method="POST" modelAttribute="dateAtrr" >
				 <div style="margin-top: 5px;" ><label>Оберіть дату</label><form:input style="margin-left:20px;" path="date1" type="Date"/><br></div>
				 <div style="margin-top: 5px;" ><label>Оберіть дату</label><form:input style="margin-left:20px;" path="date2" type="Date"/><br> </div>
				<input class="btn btn-dark" type="submit" value="Забронювати" >
			</form:form> </td>
		</tr>
	</c:forEach>
			</table>
		</div>
	</div>
	<div class="col-sm-2" ></div>
</div>

</div>
</body>
</html>