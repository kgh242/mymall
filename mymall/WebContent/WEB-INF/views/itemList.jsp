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
			<th>No</th>
			<th>Name</th>
			<th>Price</th>
			<th>Order</th>
		</tr>
		<c:forEach var="item" items="${itmeList}">
			<tr>
				<td>${item.no}</td><!--item.getNo()  -->
				<td>${item.name}</td>
				<td>${item.price}</td>
				<td><a href="${pageContext.request.contextPath}/OrderController="${item.no}">주문</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan = "4" align="center">
				<c:if test="${paging.currentScreen > 1}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${(paging.currentScreen - 1) * paging.pagePerScreen}"><<</a>
				</c:if>
				<c:if test="${paging.currentPage > 1}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${paging.currentPage - 1}">이전</a>
				</c:if>
				<c:forEach var="i" begin="${paging.startScreenPage + 1}" end="${paging.startScreenPage + paging.currentScreenPage}" step="1">
					<c:if test="${paging.currentPage == i}">
						${i}
					</c:if>
					<c:if test="${paging.currentPage != i}">
						<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${i}">${i}</a>
					</c:if>
				</c:forEach>
				<c:if test="${paging.currentPage < paging.lastPage}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${paging.currentPage + 1}">다음</a>
				</c:if>
				<c:if test="${paging.currentScreen < paging.lastScreen}">
					<a href="${pageContext.request.contextPath}/ItemListController?currentPage=${paging.currentScreen * paging.pagePerScreen + 1}">>></a>
				</c:if>
			</td>
		</tr>
	</table>

</body>
</html>