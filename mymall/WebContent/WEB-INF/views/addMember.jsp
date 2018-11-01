<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember Form</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/AddMemberController" method="post">
		<table>
			<tr>
				<td>id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td>level</td>
				<td>
					<select name="level">
					<option value=0>고객</option>
					<option value=1>관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="제출"/></td>

			</tr>
		</table>
	</form>
</body>
</html>