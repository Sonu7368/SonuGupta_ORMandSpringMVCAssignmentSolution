<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Save Customer</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/home-style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-update-style.css">
</head>


<body>

	<div>
		<h2>CRM - Customer Relationship Management</h2>
	</div>

	<div>
		<h3> Customer Details </h3>
	
		<form:form name="customer_form" 
				   action="save" 
				   modelAttribute="customer" 
				   method="POST"
				   onsubmit="return isValidData();">

			<!-- customer id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>First Name</label></td>
						<td><form:input path="firstName" id="first_name"/></td>
					</tr>

					<tr>
						<td><label>Last Name</label></td>
						<td><form:input path="lastName" id="last_name"/></td>
					</tr>

					<tr>
						<td><label>Email</label></td>
						<td><form:input type="email" path="email" id="email"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form:form>

		<div style="clear; both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/customer/list"> &larr; Back to list</a>
		</p>
					
	</div>
	<script src="${pageContext.request.contextPath}/resources/script/valid.js"></script>

</body>
</html>