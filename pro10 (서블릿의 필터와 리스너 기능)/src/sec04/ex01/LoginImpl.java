package sec04.ex01;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginImpl implements HttpSessionBindingListener{
	String user_id;
	String user_pw;
	static int total_user = 0;
	
	public LoginImpl() {}
	
	public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) { //세션에 저장시 접속자수를 증가
		System.out.println("사용자 접속");
		++total_user;
	}
	
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) { //세션에서 소멸시 접속자수 감소
		System.out.println("사용자 접속 해제");
		total_user--;
	}
}
	

