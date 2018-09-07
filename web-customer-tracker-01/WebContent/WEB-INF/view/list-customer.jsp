<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>Insert title here</title>
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id = "wapper">
		<div id="header">
			<h2>List Customers</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
			/>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="temp" items="${theCustomers}">
				
					<!-- Update -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${temp.id }"></c:param>
					</c:url>
					
					<!-- Delete -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${temp.id }"></c:param>
					</c:url>
					
					
					<tr>
						<td>${temp.firstName} </td>
						<td>${temp.lastName} </td>
						<td>${temp.email} </td>	
						<td>
							<a href="${updateLink}">Update</a>|
							<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want delete this customer?'))) return false">Delete</a>
													
						</td>
					</tr>
					
				
				</c:forEach>
			
			</table>
			
		</div>
	</div>
</body>
</html>