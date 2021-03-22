<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login Page</h2>

${msg}
<f:form method= "POST" action = "operations" modelAttribute = "user" >
User Name:
<f:input type = "text" path = "username"/>
<f:errors path = "username"></f:errors>
<br>
Password:
<f:input type = "password" path = "password"/>
<f:errors path = "password"></f:errors>
<br>

<input type = "submit" value= "Login"/>


</f:form>



</body>
</html>