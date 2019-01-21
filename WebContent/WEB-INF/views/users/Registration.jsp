<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Registration</title>
		<style type="text/css">
			<%@include file="/../../../resources/css/registration_style.css" %>
		</style>
		<script src="/../../../resources/js/registration.js"></script>
		
	</head>

	<body>
		<header>
			<h1>CarStore</h1>
		</header>
		
		<h1 class="menu">REGISTRATION</h1>
  		<div class="line"></div>
		
		<c:if test="${error ne null}">
    		<p>
      			<font color="red">${error}</font>
    		</p>
  		</c:if>
		
		<br><br>
  		<form id="form" action="${pageContext.request.contextPath}/registration" method="post">
    		Username: <input type="text" name="username">
    		<div class="shortLine"></div>
    		<br>
    		Firstname: <input type="text" name="firstname">
    		<div class="shortLine"></div>
    		<br>
    		Secondname: <input type="text" name="secondname">
    		<div class="shortLine"></div>
    		<br>
    		Login: <input type="text" name="login">
    		<div class="shortLine"></div>
    		<br>
    		Password: <input type="password" name="password" id="password" required>
    		<div class="shortLine"></div>
    		<br>
    		Repeat Password: <input type="password" name="repeatPassword" id="confirm_password" required>
    		<div class="shortLine"></div>
    		<br>
    		Email: <input type="text" name="email">
    		<div class="shortLine"></div>
    		<br>
    		Phone: <input type="text" name="phone">
    		<div class="shortLine"></div>
    		<br>
    		<input id="signupButton" class="button" type="submit" name="submit" value="SIGN UP"> <br>
  		</form>
		
		<div id="signupLine"></div>
		
		<!--  <h1>info1 from WEB-INF/view</h1>
		<br><br> box: ${param.box} -->
	</body>
</html>