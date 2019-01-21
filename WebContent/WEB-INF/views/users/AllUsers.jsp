<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="hostUrl">${pageContext.request.requestURL}</c:set>
<c:set var="hostUri">${pageContext.request.requestURI}</c:set>
<!--<c:set var="hostContext" value="${fn:substring(hostUrl, 0, fn:length(hostUrl) - fn:length(hostUri))}${pageContext.request.contextPath}" /> -->
<html>

<head>
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>All Users</title>
	<style type="text/css">
		<%@include file="/../../../resources/css/allCars_style.css" %>
	</style>
</head>

<body>
	<nav>
       		<div class="topnav" id="myTopnav">
       		<a href="${pageContext.request.contextPath}/allcars.jsp">Home</a>
      		<a href="${pageContext.request.contextPath}/carsupply.jsp">Supply</a>
       		<a href="${pageContext.request.contextPath}/usercars">Mine</a>
       		<c:if test="${userDto.getIsAdmin() ne 0}">
    			<a style="color:#007AFF" href="${pageContext.request.contextPath}/allusers">Users</a>
 			</c:if>
 			<a id="myAccount" href="${pageContext.request.contextPath}/useredit.jsp">My Account</a>
       		
       		</div> 
      	</nav>  
      	
      	<header>
			<h1>CarStore</h1>
		</header>	
  		<div class="line"></div> 

	<br><br>
	<a href="${pageContext.request.contextPath}/logout">logout</a>
	
	<br><br>
	<c:set var="allUsers" value="${allUsersDto.users}"/>
	<c:if test="${allUsers ne null && allUsers.size() gt 0}">
		<table id="allUsers" border="1">
			<tr>
				<th>Username</th>
				<th>Firstname</th>
				<th>Secondname</th>
				<th>Login</th>
				<th>Password</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Active</th>
				<th>Admin</th>
				<!-- <th>Edit_Item</th>
				<th>Delete_Item</th>  -->
			</tr>
			<c:forEach var="row" items="${allUsers}">
				<tr>
					<td>${row.getUsername()}</td>
					<td>${row.getFirstname()}</td>
					<td>${row.getSecondname()}</td>
					<td>${row.getLogin()}</td>
					<td>${row.getPassword()}</td>
					<td>${row.getEmail()}</td>
					<td>${row.getPhone()}</td>
					<td>${row.getIsActive()}</td>
					<td>${row.getIsAdmin()}</td>
					<!-- <td><a href="${pageContext.request.contextPath}/itemedit?idItem=${row.getId()}">edit</a></td>
					<td><a href="#" onclick="checkDeleteItem('${hostContext}/itemdelete?idItem=${row.getId()}')">delete</a></td>	-->
				</tr>
			</c:forEach>			
		</table>
	</c:if>
	
	<div class="dropdown">
 		<button class="dropbtn">Users On A Page</button>
  		<div class="dropdown-content">
  		<a href="${pageContext.request.contextPath}/allusers?pageOffset=5">5</a>
    	<a href="${pageContext.request.contextPath}/allusers?pageOffset=10">10</a>
    	<a href="${pageContext.request.contextPath}/allusers?pageOffset=15">15</a>
  	</div>
  
  <br><br>
  
  	<div class="pagination">
  	<c:if test="${allUsersDto.getPageCount() gt 1}">
  		<c:if test="${allUsersDto.getCurrentPage() gt 1}">
			<a href="${pageContext.request.contextPath}/allusers?currentPage=${allUsersDto.getCurrentPage() - 1}">Previous</a>
		</c:if>
  	
  		<c:forEach begin="1" end="${allUsersDto.getPageCount() }" varStatus="loop">
  			<c:choose>
      			<c:when test="${allUsersDto.getCurrentPage() == loop.index}">
      				<a style="color:#007AFF" href="${hostContext}/allusers?currentPage=${loop.index}">${loop.index}</a>
      			</c:when>

      			<c:otherwise>
      				<a href="${hostContext}/allusers?currentPage=${loop.index}">${loop.index}</a>
      			</c:otherwise>
   			</c:choose>
   		</c:forEach>
	
		<c:if test="${allUsersDto.getCurrentPage() lt allUsersDto.getPageCount()}">
			<a href="${pageContext.request.contextPath}/allusers?currentPage=${allUsersDto.getCurrentPage() + 1}">Next</a>
		</c:if>
	</c:if>
	</div>
</body>
</html>