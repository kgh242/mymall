<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item List</title>
</head>

<body>
	<h1>상품목록</h1>
	<table border="1">
		<tr>
			<th>No</th><th>Name</th><th>Price</th><th>Order</th>
		</tr>
		<c:forEach var="item" items="${itmeList}">
			<tr>
				<td>${item.no}</td><!--item.getNo()  -->
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td><a href="${pageContext.request.contextPath}/OrderController">주문</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan = "4" align="center">
				<c:if test="${currentScreen > 1}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${(currentScreen - 1) * pagePerScreen}"><<</a>
				</c:if>
				<c:if test="${currentPage > 1}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${currentPage - 1}"><</a>
				</c:if>
				<c:forEach var="i" begin="${startScreenPage + 1}" end="${startScreenPage + currentScreenPage}" step="1">
					<c:if test="${currentPage == i}">
						${i}
					</c:if>
					<c:if test="${currentPage != i}">
						<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${currentPage < lastPage}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${currentPage + 1}">></a>
				</c:if>
				<c:if test="${currentScreen < lastScreen}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${currentScreen * pagePerScreen + 1}">>></a>
				</c:if>
			</td>
		</tr>
	</table>

</body>
</html>