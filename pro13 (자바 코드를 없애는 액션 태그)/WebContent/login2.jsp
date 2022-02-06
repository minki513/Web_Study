<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<%
		String msg = request.getParameter("msg"); //브라우저에서 접속 시에는 msg값을 가져와서 표시/ 최초 접속 시에는 null이므로 아무것도 표시 안함
		if(msg != null){
	%>
	<h1><%=msg %></h1>
	<%
		}
	%>
	<form action="result2.jsp" method="post">
		아이디 : <input type="text" name="userID"><br>
		비밀번호 : <input type="password" name="userPw"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시입력">
	</form>
</body>
</html>