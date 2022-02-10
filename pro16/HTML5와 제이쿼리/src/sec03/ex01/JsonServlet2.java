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
//@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
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
		
		JSONObject totalObject = new JSONObject(); //�迭�� ������ totalObiect ����
		JSONArray membersArray = new JSONArray(); //memberinfo JSon��ü�� ������ memebersArray �迭�� ����
		JSONObject memberInfo = new JSONObject(); //ȸ�� �Ѹ��� ������ �� memberinfo JSON��ü ����
		
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
		
		String jsonInfo = totalObject.toJSONString(); //jsonobject�� ���ڿ��� ��ȯ
		System.out.print(jsonInfo);
		writer.print(jsonInfo); //json �����͸� �������� ����
		
	}
}
