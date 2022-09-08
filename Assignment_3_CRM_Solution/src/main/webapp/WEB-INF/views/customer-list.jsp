<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Customers List</title>
	
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/home-style.css">
</head>


<body>

	<div>
		<h2>CRM - Customer Relationship Management</h2>
	</div>

	<div>
		<input type="button" value="Add customer"
			   onclick="window.location.href='add'; return false;"
			   class="add-button" />

		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>


			<core:forEach items="${customers}" var="customer">
				
				<!-- update link-->
				<core:url  var="updateLink" value="/customer/update">
					<core:param name="id" value="${customer.id}" />
				</core:url>					

				<!-- delete link -->
				<core:url var="deleteLink" value="/customer/delete">
					<core:param name="id" value="${customer.id}" />
				</core:url>					
				
				<tr>
					<td> ${customer.firstName} </td>
					<td> ${customer.lastName} </td>
					<td> ${customer.email} </td>
					<td>
						<a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
						   onclick="return confirm('Are you sure you want to delete ${customer.firstName}? This can\'t be undone')">Delete</a>
					</td>
				</tr>

			</core:forEach>
		</table>
	</div>
</body>
</html>
