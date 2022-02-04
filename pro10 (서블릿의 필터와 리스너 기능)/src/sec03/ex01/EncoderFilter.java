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

//@WebFilter("/*") //webfilter 애너테이션을 이용해 모든 요청이 필터를 거침
public class EncoderFilter implements Filter {
	ServletContext context;
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩");
		context = fConfig.getServletContext();
	}
	
    public EncoderFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		System.out.println("destroy 호출");
	}

	//실제 필터 기능 구현
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8"); //한글 인코딩 설정 작업
		String context = ((HttpServletRequest)request).getContextPath(); //웹 애플리케이션 컨텍스트 이름 가져옴
		String pathinfo = ((HttpServletRequest)request).getRequestURI(); //웹 브라우저에서 요청한 요청 url가져옴
		String realPath = request.getRealPath(pathinfo); //요청 url의 실제 경로 가져옴
		String mesg = "Context 정보 : " + context + "\n URI 정보 : " + pathinfo + "\n 물리적 경료 : " + realPath;
		System.out.println(mesg);
		
		//dofilter()메서드를 기준으로 위쪽에 위한 코드는 요청 필터기능을 수행하고 아래에 위치한 코드는 응답 필터기능을 수행
		
		long begin = System.currentTimeMillis(); //요청 필터에서 요청 처리 전의 시각을 구함
		chain.doFilter(request, response); //다음 필터로 넘기는 작업 수행
		
		long end = System.currentTimeMillis(); //응답 필터에서 요청 처리 후의 시각을 구함
		System.out.println("작업 시간 : " + (end-begin) + "ms"); //작업 요청 전과 후의 시각 차를 구함
	}

}
