<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My Account</title>
		<style type="text/css">
			<%@include file="/../../../resources/css/userprofile_style.css" %>
		</style>
		
	</head>

	<body>
		<nav>
       		<div class="topnav" id="myTopnav">
       		<a href="${pageContext.request.contextPath}/allcars.jsp">Home</a>
      		<a href="${pageContext.request.contextPath}/carsupply.jsp">Supply</a>
       		<a href="${pageContext.request.contextPath}/usercars">Mine</a>
       		<c:if test="${userDto.getIsAdmin() ne 0}">
    			<a href="${pageContext.request.contextPath}/allusers">Users</a>
 			</c:if>
 			<a id="myAccount" style="color:#007AFF" href="${pageContext.request.contextPath}/useredit.jsp">My Account</a>
       		
       		</div> 
      	</nav>   
	
		<header>
			<h1>CarStore</h1>
		</header>	
  		<div class="line"></div>
		
		<br><br>
  		<form id="form" action="${pageContext.request.contextPath}/useredit" method="post">
    		Username: <input type="text" name="username" value="${userDto.getUsername() }">
    		<br><br>
    		Firstname: <input type="text" name="firstname" value="${userDto.getFirstname() }">
    		<br><br>
    		Secondname: <input type="text" name="secondname" value="${userDto.getSecondname() }">
    		<br><br>
    		Login: <input type="text" name="login" value="${userDto.getLogin() }" disabled>
    		<br><br>
    		Password: <input type="password" name="password" value="${userDto.getPassword() }">
    		<br><br>
    		Repeat Password: <input type="password" name="repeatPassword" value="${userDto.getPassword() }">
    		<br><br>
    		Email: <input type="text" name="email" value="${userDto.getEmail() }">
    		<br><br>
    		Phone: <input type="text" name="phone" value="${userDto.getPhone() }">
    		<br><br>
    		<input id="signupButton" class="button" type="submit" name="submit" value="Edit"> <br>
  		</form>
		
		<div id="signupLine"></div>
		
		<!--  <h1>info1 from WEB-INF/view</h1>
		<br><br> box: ${param.box} -->
	</body>
</html>