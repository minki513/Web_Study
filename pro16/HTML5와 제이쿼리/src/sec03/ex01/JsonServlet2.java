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
		
		JSONObject totalObject = new JSONObject(); //배열을 저장한 totalObiect 선언
		JSONArray membersArray = new JSONArray(); //memberinfo JSon객체를 저장할 memebersArray 배열을 선언
		JSONObject memberInfo = new JSONObject(); //회원 한명의 정보가 들어갈 memberinfo JSON객체 선언
		
		memberInfo.put("name", "박지성"); 
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날센돌이");	
		membersArray.add(memberInfo); //회원 정보를 membersArray 배열에 저장
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "칼치");
		membersArray.add(memberInfo);
		
		totalObject.put("members", membersArray); //totalObject에 members라는name으로 membersArray를 value로 저장
		
		String jsonInfo = totalObject.toJSONString(); //jsonobject를 문자열로 변환
		System.out.print(jsonInfo);
		writer.print(jsonInfo); //json 데이터를 브라우저로 전송
		
	}
}
