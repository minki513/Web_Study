package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		JSONObject totalObject = new JSONObject(); //�迭�� ���������� ������ jsonObiect ����
		JSONArray membersArray = new JSONArray();
		JSONObject memberInfo = new JSONObject(); 
		
		memberInfo.put("name", "������"); 
		memberInfo.put("age", "25");
		memberInfo.put("gender", "����");
		memberInfo.put("nickname", "��������");	
		membersArray.add(memberInfo); //ȸ�� ������ membersArray �迭�� ����
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "�迬��");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "����");
		memberInfo.put("nickname", "Įġ");
		membersArray.add(memberInfo);
		totalObject.put("members", membersArray); //totalObject�� members���name���� membersArray�� value�� ����
		
		JSONArray bookArray = new JSONArray();
		JSONObject bookInfo = new JSONObject();
		bookInfo.put("title", "�ʺ��ڸ� ���� �ڹ� ���α׷���");
		bookInfo.put("writer", "�̺���");
		bookInfo.put("price", "30000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8080/pro16/image/image1.jpg");
		bookArray.add(bookInfo);
		
		bookInfo = new JSONObject();
		bookInfo.put("title", "����� ���̽�");
		bookInfo.put("writer", "�̽���");
		bookInfo.put("price", "12000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://localhost:8080/pro16/image/image2.jpg");
		bookArray.add(bookInfo);
		
		totalObject.put("books", bookArray);
		String jsonInfo = totalObject.toJSONString(); //jsonobject�� ���ڿ��� ��ȯ
		System.out.print(jsonInfo);
		writer.print(jsonInfo); //json �����͸� �������� ����
	}
}
