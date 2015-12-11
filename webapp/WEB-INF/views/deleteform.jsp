<%@page import="com.hanains.guestbook.dao.GuestBookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String no=request.getParameter("no");
	GuestBookDao dao=new GuestBookDao();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>

</head>
<body>
	<form action="/guestbook3/delete" method="post" name="frm">
	
	<input type='hidden' name="no" value="${no}">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" id="password"></td>
			<td><input type="submit" value="확인"></td>
			<td><a href="/guestbook3">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>