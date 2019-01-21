<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	<title>Car Supply</title>
	<style type="text/css">
			<%@include file="/../../../resources/css/userprofile_style.css" %>
	</style>
</head>
<body>

	<nav>
   		<div class="topnav" id="myTopnav">
   		<a href="${pageContext.request.contextPath}/allcars.jsp">Home</a>
   		<a style="color:#007AFF" href="${pageContext.request.contextPath}/carsupply.jsp">Supply</a>
   		<a href="${pageContext.request.contextPath}/usercars">Mine</a>
   		<c:if test="${userDto.getIsAdmin() ne 0}">
  			<a href="${pageContext.request.contextPath}/allusers">Users</a>
		</c:if>
		<a id="myAccount" href="${pageContext.request.contextPath}/useredit.jsp">My Account</a>
   		</div> 
   	</nav>   

	<header>
		<h1>CarStore</h1>
	</header>
		
	
  	<div class="line"></div>
  	
  	<form id="form" action="${pageContext.request.contextPath}/carcreate" method="post">
    Brand: <input type="text" name="brand">
    <br><br>
    Model <input type="text" name="model">
    <br><br>
    Gearbox <input type="text" name="gearbox">
    <br><br>
    Details: <input type="text" name="details">
    <br><br>
    Engine Capacity: <input type="text" name="engineCapacity">
    <br><br>
    Year: <input type="text" name="year">
    <br><br>
    Mileage: <input type="text" name="mileage">
    <br><br>
    Price: <input type="text" name="price">
    <br><br>
    <input class="button" id="signinButton" type="submit" name="submit" value="Supply"> <br>
    
  </form>

</body>
</html>