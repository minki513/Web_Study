package sec04.ex01;
//HttpServletRequest를 이용한 redirect 포워딩 시 바인딩
//바인딩 - 웹 프로그램 실행시 데이터를 서블릿 관련 객체에 저장하는 방법
//브라우저에서 요청할 떄 서블릿에 전달되는 첫 번쨰 request는 웹 브라우저를 통해 재요청되는 둡ㄴ쨰 request와 다른 요청
//redirect 방식으로는 서블릿에서 바인딩한 데이터를 다른 서블릿으로 전송할수 없음
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		request.setAttribute("address", "서울시 성북구");
		response.sendRedirect("second");
	}

}
