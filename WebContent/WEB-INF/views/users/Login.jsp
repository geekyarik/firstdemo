<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="C:/Users/y3809/eclipse-workspace/mavenproject/WebContent/css/login_style.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LogIn</title>
	<style type="text/css">
		<%@include file="/../../../resources/css/login_style.css" %>
	</style>
</head>

<body>
	<header>
		<h1>CarStore</h1>
	</header>


  <h1 class="menu">LOGIN</h1>
  <div class="line"></div>
  
  <br><br>
  <form id="form" action="${pageContext.request.contextPath}/login" method="post">
    Login: <input type="text" name="login">
    <div class="line"></div>
    <br><br>
    Password: <input type="password" name="password">
    <div class="line"></div>
    <br><br>
    <c:if test="${error ne null}">
    
  </c:if>
    <input class="button" id="signinButton" type="submit" name="submit" value="SIGN IN"> <br>
    <div class="line" id="singinline"></div>
  </form>
	
	<a id="signupButton" class="button" href="${pageContext.request.contextPath}/registration.jsp">SIGN UP
		<p id="tip">if you don`t have an account</p>
	</a>
	
	<p class="error">
      <font color="red" size=2 >${error}</font>
    </p>
	<!--<a hr
	ef="${pageContext.request.contextPath}/registration.jsp" >
		<input id="signupButton" class="button" type="submit" name="signup" value="SIGN UP"></input>
	</a> -->
	
</body>
</html>