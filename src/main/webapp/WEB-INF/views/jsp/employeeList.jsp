<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees List</title>
</head>
<body>

	<h1>Employees List</h1>


	<table border=1>
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee phone</th>
			<th>Employee email</th>
			<th>Employee city</th>
			<th>Employee Department</th>
			<th>Office address</th>
			<th>Employee status</th>
			<th>change</th>
			<th>Push</th>
		</tr>
	 	<c:forEach var="employee" items="${employeeDtoList}">
			<tr>
				<td>${employee.employeeId}</td>
				<td>${employee.employeeName}</td>
				<td>${employee.phone}</td>
				<td>${employee.email}</td>
				<td>${employee.city}</td>
				<td>${employee.department}</td>
				<td>${employee.address}</td>
				<td>${employee.status}</td>
				<td><a href="<c:url value='/changeStatus/${employee.employeeId}'/>" > Change status</a></td>
				<c:if test = "${employee.department == 'Government'}">
				<td><a href="<c:url value='/push/${employee.employeeId}'/>" > PUSH</a></td>
				</c:if>
			</tr>
		</c:forEach>

	</table>
<br>
<a href="<c:url value='/backToUserHome'/>" > back</a>
</body>
</html>