package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP프로그래밍입니다.","utf-8")); //cookie객체를 생성한 후 cookietest이름으로 한글 정보를 인코딩해서 쿠키에 저장
		c.setMaxAge(24*60*60); //유효기간 설정
		response.addCookie(c); //생성된 큐기를 브라우저로 전송
		//c.setMaxAge(-1); //유효시간을 음수로 지정하여 session쿠키를 만든다.
		
		out.println("현재시간 : " +d);
		out.println("현재시간을 cookie로 저장합니다.");
	}

}
