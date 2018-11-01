<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세정보</title>
</head>
<body>
	<h1>회원 상세정보</h1>
	<table border="1">
		<tr>
			<th>no</th><th>id</th><th>pw</th><th>level</th>
		</tr>
		<tr>
			<td>${member.no}</td>
			<td>${member.id}</td>
			<td>${member.pw}</td>
			<td>
				<c:choose>
					<c:when test="${member.level == 0}">
						고객
					</c:when>
					<c:otherwise>
						관리자
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>