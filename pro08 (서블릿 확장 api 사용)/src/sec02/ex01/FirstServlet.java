package sec02.ex01;
//redirect 방법으로 최초 요청한 서블릿에서 get방식으로 다른 서블릿으로 데이터를 전달
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		response.sendRedirect("second?name=lee"); //GET방식을 이용해 이름/값 쌍으로 데이터를 다른 서블릿로 전달
	}

}
