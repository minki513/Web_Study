package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("mainController") //MainController 클래스를 빈으로 자동변환, 빈 id는 mainController
@RequestMapping("/test") //첫번째 단계의 url요청이 /test이면 mainController 빈을 요청
public class MainController {
	//두 번째 단계의 url요청이 /main1.do이면 mainController빈의 main1()메서드를 요청 (get 방식으로 요청)
	@RequestMapping(value="/main1.do", method=RequestMethod.GET)
	
	public ModelAndView main1(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main1");
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/main2.do", method=RequestMethod.GET)
	public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "main2");
		mav.setViewName("main");
		return mav;
}
}
