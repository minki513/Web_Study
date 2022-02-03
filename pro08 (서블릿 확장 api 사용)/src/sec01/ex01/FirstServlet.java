package sec01.ex01;
//redirect 방법은 서블릿의 요청이 클라이언트의 웹 브라우저를 다시 거쳐 요청되는 방식
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.sendRedirect("second"); //sendRedirect()메서드를 이용해 웹 브라우저에게 다른 서블릿인 second로 재요청
	}

}
