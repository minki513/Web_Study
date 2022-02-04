package sec04.ex02;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class LoginImpl implements HttpSessionListener {

	   String user_id;
       String user_pw;
       static int total_user=0;
       
    public LoginImpl() {}
    public LoginImpl(String user_id, String user_pw) {
    	this.user_id = user_id;
    	this.user_pw = user_pw;
    }
    public void sessionCreated(HttpSessionEvent se)  { //技记 积己矫 捞亥飘 贸府
         System.out.println("技记 积己");
         ++total_user;
    }

    public void sessionDestroyed(HttpSessionEvent se)  { //技记 家戈矫 捞亥飘 贸府
    	System.out.println("技记 家戈");
        --total_user;
    }
	
}
