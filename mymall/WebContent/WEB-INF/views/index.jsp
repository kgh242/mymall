<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index Page</h1>
	<c:if test="${loginMember != null}">
	<a href = "LogoutMemberController">로그아웃</a>
	<a href = "ModifyMemberController?id=${loginMember.id}">정보수정</a><br>
	<a href = "RemoveMemberController?id=${loginMember.no}">회원탈퇴</a>
	<a href = "GetMemberController?id=${loginMember}">${loginMember}</a>님 반갑습니다.
	<a href = "ModifyMemberController?id=${loginMember.id}">정보수정</a>
	<a href = "OrderListController?memberNO=${loginMember.no}">주문목록</a>
	<a href = "ItemListController">물품목록</a><br>
	<a href = "GetMemberController?id=${loginMember.id}">${loginMember.id}</a>님이
	<c:if test="${loginMember.level == 0}">고객</c:if>
	<c:if test="${loginMember.level == 1}">관리자</c:if> 권한 로그인
	</c:if>
	<c:if test="${loginMember == null}">
		<a href = "LoginMemberController">로그인</a>
	</c:if>
	<br>
	<a href="${pageContext.request.contextPath}/AddMemberController">회원가입</a>
</body>
</html>