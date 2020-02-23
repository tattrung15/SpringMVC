<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Danh sách người dùng</h2>
	<hr>
	<a href='<c:url value="/them-khach-hang"></c:url>'>Them khach hang</a>
	<a href='<c:url value="/xem-gio-hang"></c:url>'>Xem gio hang</a>
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Phone</td>
			<td>Choose</td>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.phone }</td>
				<td>
					<a href="<c:url value='/chi-tiet-nguoi-dung/${user.id }'></c:url>">Chi tiet</a>
					<a href="<c:url value='/xoa-nguoi-dung/${user.id }'></c:url>">Xoa</a>
					<a href="<c:url value='/sua-nguoi-dung/${user.id }'></c:url>">Sua</a>
					<a href="<c:url value='/them-nguoi-dung/${user.id }'></c:url>">Add user</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>