<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta  charset="utf-8">
<title>Add Customer</title>
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">	
<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
	</div>
	<div id="container">
		<h3>Add - Customer</h3>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><label>FirstName</label></td>
						<td><form:input path="firstName"/></td>
					</tr>
					<tr>
						<td><label>LastName</label></td>
						<td><form:input path="lastName"/></td>
					</tr>
					<tr>
						<td><label>Email</label></td>
						<td><form:input path="Email"/></td>
					</tr>	
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"></td>
					</tr>		
				</tbody>
			</table>
		
		</form:form>
		
		<div style="clear; both;"></div>
		<p><a href="${pagaContext.request.contextPath}/web-customer-tracker-01/customer/list">Back To List</a></p>
		
		
	</div>
	
</body>
</html>