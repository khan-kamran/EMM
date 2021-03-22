<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "f" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>
<spring:url value="/resources/core/js/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/core/js/registrationJS.js" var="registrationJS" />
<script src="${jqueryJs}"></script>
<script src="${registrationJS}"></script>
</head>
<body>
	<h1>Enter Employee details</h1>


<f:form method= "POST" action = "register" modelAttribute = "employee" >
Employee Name:
<f:input path = "employeeName"/>
<f:errors path="employeeName" style="color:red" />
<br>
Phone:
<f:input path = "phone"/>
<f:errors path="phone" style="color:red" />
<br>
email:
<f:input path = "email"/>
<f:errors path="email" style="color:red" />
<br>
Gender:
<f:radiobutton path = "gender" name="gender" value="male" required = "required"/> Male
<f:radiobutton path = "gender" name="gender" value="female" required = "required"/> Female
<br>
Department:
  <f:radiobutton id = "Government" onClick = 'departmentAddress(this.id);' path = "department" name="department" value="Government" required = "required"/> Government
  <f:radiobutton id="Private" onClick = "departmentAddress(this.id);" path = "department" name="department" value="Private" required = "required"/> Private
  <f:radiobutton id="Inhouse" onClick = "departmentAddress(this.id);" path = "department" name="department" value="In house" required = "required"/> In house
  <f:radiobutton id="Overseas" onClick = "departmentAddress(this.id);" path = "department" name="department" value="Overseas" required = "required"/>Overseas
<br>
City:

<f:select  path="city">
<option  disabled selected>Select City:</option>
<c:forEach  items="${clist}" var= "city" >
<option>
<c:out value="${city.name}"></c:out>
</option>
</c:forEach>
</f:select>
<br>
Office Address :
<br>
<f:select id ="dAddress" path="address">
<option  disabled selected>Select Address:</option>
</f:select>
<br>
<br>
<input type = "submit" value= "Register"/>
</f:form>

<spring:url value="/resources/core/js/jquery.min.js" var="jqueryJs" />
<spring:url value="/resources/core/js/registrationJS.js" var="registrationJS" />
<script src="${jqueryJs}"></script>
<script src="${registrationJS}"></script>
<br>
<a href="<c:url value='/backToUserHome'/>" > back</a>
</body>
</html>