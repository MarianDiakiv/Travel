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
	<div style="margin-top: 3%" class="row" >
		<div class ="col-sm-2" ></div>
		<div class ="col-sm-8" >
				
				<div class="row" >
				
					<form:form action="/adminBoard/addRoomType" method="POST" modelAttribute="roomType" >
 						<label>Тип кімнати</label> <form:input path="typeRoom"/><br>
						<input class="btn btn-dark" type="submit" value="Зберегти" >
					</form:form>
				</div>
				
					 <div class ="row" >
					 <P style="margin-left: 40%"> Типи Кімнат </P>
					 <table class= " table table-dark table-striped">
								<tr>
									<td>id</td>
									<td>Тип кімнати</td>s
								</tr>
								<c:forEach items="${types}" var="t" >
									<tr>
										<td>${t.id}</td>
										<td>${t.typeRoom}</td>
									</tr>
								</c:forEach>
							</table>
						</div> 
				
		</div>
		<div class ="col-sm-2" ></div>
	</div>
</div> 



</body>
</html>