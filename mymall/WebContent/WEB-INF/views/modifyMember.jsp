<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>수정 페이지</h1>
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
					<select name="level">
						<option value=0>고객</option>
						<option value=1>관리자</option>
					</select>
					</c:if>
					<c:if test="${member.level == 1}">
					<select name="level">
						<option value=0>고객</option>
						<option value=1>관리자</option>
					</select>
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