<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "이순신");
	request.setAttribute("address", "서울시 강남구"); //request객체에 setAttribute()를 이용해 name과 address를 바인딩
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫번째 jsp</title>
</head>
<body>
	<%
		RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp"); //request객체를 다른 jsp로 포워딩
		dispatch.forward(request, response);
	%>
</body>
</html>