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
	<title>All Cars</title>
	<style type="text/css">
		<%@include file="/../../../resources/css/allCars_style.css" %>
	</style>
</head>

<body>
	<nav>
       		<div class="topnav" id="myTopnav">
       		<a style="color:#007AFF" href="${pageContext.request.contextPath}/allcars.jsp">Home</a>
      		<a href="${pageContext.request.contextPath}/carsupply.jsp">Supply</a>
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

	<br><br>
	<a href="${pageContext.request.contextPath}/logout">logout</a>
	
	
	
	<!-- <a href="${pageContext.request.contextPath}/itemcreate">Create new Item</a>  -->
	<br><br>
	<!-- 
	<select id="idVisibleItems" onchange="selectVisibleItems('${hostContext}/itemcount?visibleItems=')">
		<option value="100000"
				<c:if test="${visibleItems eq '100000'}">
					selected="selected"
				</c:if>
			>all items</option>
		<option value="5" 
				<c:if test="${visibleItems eq '5'}">
					selected="selected"
				</c:if>
			>5 items</option>
		<option value="10"
				<c:if test="${visibleItems eq '10'}">
					selected="selected"
				</c:if>
			>10 items</option>
		<option value="25"
				<c:if test="${visibleItems eq '25'}">
					selected="selected"
				</c:if>
			>25 items</option>
	</select>
	-->
	<br><br>
	<c:set var="allCars" value="${allCarsDto.cars}"/>
	<c:if test="${allCars ne null && allCars.size() gt 0}">
		<table border="1">
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
			<c:forEach var="row" items="${allCars}">
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
  		<a href="${pageContext.request.contextPath}/allcars?pageOffset=5">5</a>
    	<a href="${pageContext.request.contextPath}/allcars?pageOffset=10">10</a>
    	<a href="${pageContext.request.contextPath}/allcars?pageOffset=15">15</a>
  	</div>
  
  <br><br>
  
  	<div class="pagination">
  	<c:if test="${allCarsDto.getPageCount() gt 1}">
  		<c:if test="${allCarsDto.getCurrentPage() gt 1}">
			<a href="${pageContext.request.contextPath}/allcars?currentPage=${allCarsDto.getCurrentPage() - 1}">Previous</a>
		</c:if>
  	
  		<c:forEach begin="1" end="${allCarsDto.getPageCount() }" varStatus="loop">
  			<c:choose>
      			<c:when test="${allCarsDto.getCurrentPage() == loop.index}">
      				<a style="color:#007AFF" href="${hostContext}/allcars?currentPage=${loop.index}">${loop.index}</a>
      			</c:when>

      			<c:otherwise>
      				<a href="${hostContext}/allcars?currentPage=${loop.index}">${loop.index}</a>
      			</c:otherwise>
   			</c:choose>
   		</c:forEach>
	
		<c:if test="${allCarsDto.getCurrentPage() lt allCarsDto.getPageCount()}">
			<a href="${pageContext.request.contextPath}/allcars?currentPage=${allCarsDto.getCurrentPage() + 1}">Next</a>
		</c:if>
	</c:if>
	</div>
	 
</body>
</html>