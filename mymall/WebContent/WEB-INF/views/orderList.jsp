<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>주문내역</h1>
	<table border="1">
		<tr>
			<th>OrderNo</th>
			<th>ItemNo</th>
			<th>Name</th>
			<th>Price</th>
			<th>OrderDate</th>
		</tr>
		<c:forEach var = "list" items="${memberItemList}">
			<tr>
				<td>${list.memberItemNo}</td>
				<td>${list.ItemNo}</td>
				<td>${list.itemName}</td>
				<td>${list.itemPrice}</td>
				<td>${list.orderDate}</td>
			</tr>			
		</c:forEach>
	</table>
</body>
</html>