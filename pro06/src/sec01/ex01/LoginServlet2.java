package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("init �޼��� ȣ��");
	}

	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //�� ���������� ���۵� �������� ���ڵ��� ������
		response.setContentType("text/html;charset=utf-8"); //setContentType()�� �̿��� ������ �������� ������ html���� ����
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		String data="<html>";
			data +="<body>";
			data +="���̵� : " + id;
			data +="<br>";
			data +="�н����� : " + pw;
			data+="</html>";
			data +="</body>";
		out.print(data); //PrintWriter�� print()�� �̿��� html�±� ���ڿ��� �� �������� ���
	}

}
