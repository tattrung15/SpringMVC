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
	<h2>Danh sách giỏ hàng</h2>
	<hr>
	<a href='<c:url value="/danh-sach-khach-hang"></c:url>'>Danh sách khach hang</a>
	<hr>
	<table>
		<tr>
			<td>Tên người dùng</td>
			<td>SDT</td>
			<td>Số lượng</td>
			<td>Choose</td>
		</tr>
		<c:forEach items="${order.items }" var="item">
			<tr>
				<td>${item.user.name }</td>
				<td>${item.user.phone }</td>
				<td>${item.number }</td>
				<td><a href="<c:url value='/xoa-san-pham/${item.user.id }'></c:url>">Xoa</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>