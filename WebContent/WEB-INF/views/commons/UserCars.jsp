<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%> --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="hostUrl">${pageContext.request.requestURL}</c:set>
<c:set var="hostUri">${pageContext.request.requestURI}</c:set>

<html>
<head>
	<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My Cars</title>
	<style type="text/css">
		<%@include file="/../../../resources/css/allCars_style.css" %>
	</style>
</head>
<body>

<nav>
       		<div class="topnav" id="myTopnav">
       		<a href="${pageContext.request.contextPath}/allcars.jsp">Home</a>
      		<a href="${pageContext.request.contextPath}/carsupply.jsp">Supply</a>
       		<a style="color:#007AFF" href="${pageContext.request.contextPath}/usercars">Mine</a>
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

	<br><br>
	<a href="${pageContext.request.contextPath}/logout">logout</a>
		
	<br><br>
	
	<c:set var="userCars" value="${userCarsDto.cars}"/>
		<c:if test="${userCars ne null && userCars.size() gt 0}">
		<table id="userCars" border="1">
			<tr>
				<th>Brand</th>
				<th>Model</th>
				<th>Gearbox</th>
				<th>Details</th>
				<th>Engine Capacity</th>
				<th>Year</th>
				<th>Mileage</th>
				<th>Price</th>
				<!-- <th>Edit_Item</th>
				<th>Delete_Item</th>  -->
			</tr>
			<c:forEach var="row" items="${userCars}">
				<tr>
					<td>${row.getBrand()}</td>
					<td>${row.getModel()}</td>
					<td>${row.getGearBox()}</td>
					<td>${row.getDetails()}</td>
					<td>${row.getEngineCapacity()} cm²</td>
					<td>${row.getYear()}</td>
					<td>${row.getMileage()}</td>
					<td>${row.getPrice()}$</td>
					<!-- <td><a href="${pageContext.request.contextPath}/itemedit?idItem=${row.getIdItem()}">edit</a></td>
					<td><a href="#" onclick="checkDeleteItem('${hostContext}/itemdelete?idItem=${row.getIdItem()}')">delete</a></td>	-->
				</tr>
			</c:forEach>			
		</table>
	</c:if>
	<!-- 
	<script type="text/javascript">
		function checkDeleteItem(url) {
			if (confirm("Are you sure?")) {
				window.location.href = url;
			}
		}
		function selectVisibleItems(url) {
			var visibleItems = document.getElementById("idVisibleItems");
			window.location.href = url
				+ visibleItems.options[visibleItems.selectedIndex].value;
		}
	</script>
	 -->
	
	<div class="dropdown">
 		<button class="dropbtn">Cars On A Page</button>
  		<div class="dropdown-content">
  		<a href="${pageContext.request.contextPath}/usercars?pageOffset=5">5</a>
    	<a href="${pageContext.request.contextPath}/usercars?pageOffset=10">10</a>
    	<a href="${pageContext.request.contextPath}/usercars?pageOffset=15">15</a>
  	</div>
  
  <br><br>
  
  	<div class="pagination">
  	<c:if test="${userCarsDto.getPageCount() gt 1}">
  		<c:if test="${userCarsDto.getCurrentPage() gt 1}">
			<a href="${pageContext.request.contextPath}/usercars?currentPage=${userCarsDto.getCurrentPage() - 1}">Previous</a>
		</c:if>
  	
  		<c:forEach begin="1" end="${userCarsDto.getPageCount() }" varStatus="loop">
  			<c:choose>
      			<c:when test="${userCarsDto.getCurrentPage() == loop.index}">
      				<a style="color:#007AFF" href="${hostContext}/usercars?currentPage=${loop.index}">${loop.index}</a>
      			</c:when>

      			<c:otherwise>
      				<a href="${hostContext}/usercars?currentPage=${loop.index}">${loop.index}</a>
      			</c:otherwise>
   			</c:choose>
   		</c:forEach>
	
		<c:if test="${userCarsDto.getCurrentPage() lt userCarsDto.getPageCount()}">
			<a href="${pageContext.request.contextPath}/usercars?currentPage=${userCarsDto.getCurrentPage() + 1}">Next</a>
		</c:if>
	</c:if>
	</div>
	 

	<!-- 
	<script type="text/javascript">
		function checkDeleteItem(url) {
			if (confirm("Are you sure?")) {
				window.location.href = url;
			}
		}
		function selectVisibleItems(url) {
			var visibleItems = document.getElementById("idVisibleItems");
			window.location.href = url
				+ visibleItems.options[visibleItems.selectedIndex].value;
		}
	</script>
	 -->
</body>
</html>
