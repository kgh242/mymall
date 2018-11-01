<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>멤버 수정 페이지</h1>
	<form action="ModifyMemberController" method ="post">
		<table border = "1">	
			<tr>
				<td>id</td>
				<td><input type="text" name="id" value="${member.id}" readonly></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="text" name="pw" value="${member.pw}"></td>
			</tr>
			<tr>
				<td>level</td>
				<td>
					<c:if test="${member.level == 0}">
					<input type="radio" name="level" value="0" checked>고객
					<input type="radio" name="level" value="1" >관리자
					</c:if>
					<c:if test="${member.level == 1}">
					<input type="radio" name="level" value="0">고객
					<input type="radio" name="level" value="1" checked>관리자
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="제출"/></td>
			</tr>
		</table>
	</form>
</body>
</html>