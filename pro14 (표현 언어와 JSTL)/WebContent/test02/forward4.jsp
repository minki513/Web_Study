<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("id", "hong");
	request.setAttribute("pwd", "1234");
	session.setAttribute("name", "홍길동");
	application.setAttribute("email", "hong@test.com");
	//request.setAttribute("address", "서울시 강남구");
	// 표현언어에서 같은 속성에 대한 우선순위
	//page > request> session> application
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward3</title>
</head>
<body>
	<jsp:forward page="member4.jsp"/>
</body>
</html>