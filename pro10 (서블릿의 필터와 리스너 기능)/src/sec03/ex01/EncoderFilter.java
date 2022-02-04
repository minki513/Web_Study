package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

//@WebFilter("/*") //webfilter �ֳ����̼��� �̿��� ��� ��û�� ���͸� ��ħ
public class EncoderFilter implements Filter {
	ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 ���ڵ�");
		context = fConfig.getServletContext();
	}
	
    public EncoderFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		System.out.println("destroy ȣ��");
	}

	//���� ���� ��� ����
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter ȣ��");
		request.setCharacterEncoding("utf-8"); //�ѱ� ���ڵ� ���� �۾�
		String context = ((HttpServletRequest)request).getContextPath(); //�� ���ø����̼� ���ؽ�Ʈ �̸� ������
		String pathinfo = ((HttpServletRequest)request).getRequestURI(); //�� ���������� ��û�� ��û url������
		String realPath = request.getRealPath(pathinfo); //��û url�� ���� ��� ������
		String mesg = "Context ���� : " + context + "\n URI ���� : " + pathinfo + "\n ������ ��� : " + realPath;
		System.out.println(mesg);
		
		//dofilter()�޼��带 �������� ���ʿ� ���� �ڵ�� ��û ���ͱ���� �����ϰ� �Ʒ��� ��ġ�� �ڵ�� ���� ���ͱ���� ����
		
		long begin = System.currentTimeMillis(); //��û ���Ϳ��� ��û ó�� ���� �ð��� ����
		chain.doFilter(request, response); //���� ���ͷ� �ѱ�� �۾� ����
		
		long end = System.currentTimeMillis(); //���� ���Ϳ��� ��û ó�� ���� �ð��� ����
		System.out.println("�۾� �ð� : " + (end-begin) + "ms"); //�۾� ��û ���� ���� �ð� ���� ����
	}

}
