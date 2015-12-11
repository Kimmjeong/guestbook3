<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% pageContext.setAttribute("enter", "\n"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook3/insert" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<c:set var="countTotal" value="${fn:length(list) }" />
	<c:forEach items="${list }" var="vo" varStatus="status">

		<br>
		<table width=510 border=1>
			<tr>
				<td>[${countTotal-status.index }]</td>
				<td>${vo.name }</td>
				<td>${vo.reg_date }</td>
				<td><a href="/guestbook3/deleteform/${vo.no }">삭제</a></td>
			</tr>
			<tr>
				<%-- 텍스트박스 개행 처리 --%>
				<td colspan=4>${fn:replace(vo.message,enter,"<br>") }</td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>