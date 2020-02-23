<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Form người dùng</h2>
	<c:url value="/adduser" var="url"></c:url>
	<form:form modelAttribute="user" method="post" action="${url }">
		Ten: <form:input path="name"/><p style="color: red;"><form:errors path="name"></form:errors></p>
		Mat khau: <form:input path="password"/><p style="color: red;"><form:errors path="password"></form:errors></p>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>