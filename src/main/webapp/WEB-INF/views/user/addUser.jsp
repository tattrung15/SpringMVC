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
	<c:url value="/them-khach-hang" var="url"></c:url>
	<form:form modelAttribute="user" method="post" action="${url }">
		ID: <form:input path="id"/><p style="color: red;"><form:errors path="id"></form:errors></p>
		Ten: <form:input path="name"/><p style="color: red;"><form:errors path="name"></form:errors></p>
		Phone: <form:input path="phone"/><p style="color: red;"><form:errors path="phone"></form:errors></p>
		<button type="submit">Submit</button>
	</form:form>
</body>
</html>