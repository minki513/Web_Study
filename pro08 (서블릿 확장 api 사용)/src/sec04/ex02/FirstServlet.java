package sec04.ex02;
//HttpServletRequest를 이용한 dispatch 포워딩 시 바인딩
//바인딩 - 웹 프로그램 실행시 데이터를 서블릿 관련 객체에 저장하는 방법

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
		RequestDispatcher dispatch = request.getRequestDispatcher("second");
		dispatch.forward(request, response); //바인딩된 request를 다시 두번째 서블릿으로 포워드
	}

}
