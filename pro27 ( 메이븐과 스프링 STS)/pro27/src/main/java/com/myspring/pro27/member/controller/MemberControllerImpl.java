package com.myspring.pro27.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myspring.pro27.member.service.MemberService;
import com.myspring.pro27.member.vo.MemberVO;


@Controller("memberController")
public class MemberControllerImpl implements MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	MemberVO memberVO;

	@Override
	@RequestMapping(value="/member/listMembers.do", method=RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = getViewName(request);
		//String viewName = (String)request.getAttribute("viewName");
		//System.out.println(viewName);
		//logger.info("info 레벨 : viewName = " + viewName);
		logger.debug("debug 레벨 : viewName = " + viewName);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/addMember.do", method=RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}

	@Override
	@RequestMapping(value="/member/removeMember.do", method=RequestMethod.GET)
	public ModelAndView removeMember(@RequestParam("id") String id, 
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	/*
	@RequestMapping(value="/member/*Form.do", method=RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response)throws Exception{
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	*/
	
	@Override
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("member") MemberVO member, RedirectAttributes rAttr, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		memberVO = memberService.login(member);  //login()메서드를 호출하면서 로그인 정보를 전달
		if(memberVO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberVO); //세션에 회원정보를 저장
			session.setAttribute("isLogOn", true); //세션에 로그인 상태를 true로 설정
			mav.setViewName("redirect:/member/listMembers.do"); //memberVO로 반환된 값이 있으면 세션을 이용해 로그인 상태를 true로 함
		} else {
			rAttr.addAttribute("result", "loginFailed");
			mav.setViewName("redirect:/member/loginForm.do"); //로그인 실패 시 다시 로그인 창으로 리다이렉트
		}
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/logout.do", method=RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("member");
		session.removeAttribute("isLogOn");  //로그아웃 요청시 세션에 저장된 로그인 정보와 회원정보를 삭제
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}
	
	@RequestMapping(value="/member/*Form.do", method=RequestMethod.GET)
	public ModelAndView form(@RequestParam(value="result", required=false) String result,  //로그인 창 요청시 매개변수 result가 전송되면 변수 result에 값을 저장
			HttpServletRequest request, HttpServletResponse response)throws Exception{  //최초로 로그인 창을 요청할때는 매개변수 result가 전송되지 않으므로 무시
		String viewName = getViewName(request);
		//String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", result);
		mav.setViewName(viewName);
		return mav;
	}
	
	private String getViewName(HttpServletRequest request)throws Exception{
		String contextPath=request.getContextPath();
		String uri=(String)request.getAttribute("javax.servlet.include.request_uri");
		if(uri==null ||uri.trim().equals("")) {
			uri=request.getRequestURI();
		}
		
		int begin=0;
		if (!((contextPath==null)||("".equals(contextPath)))) {
			begin=contextPath.length();
		}
		
		int end;
		if(uri.indexOf(";")!=-1) {
			end=uri.indexOf(";");
		}else if(uri.indexOf("?")!=-1) {
			end=uri.indexOf("?");
		}else {
			end=uri.length();
		}
		
		String viewName=uri.substring(begin,end);
		if(viewName.indexOf(".")!=-1) {
			viewName=viewName.substring(0,viewName.indexOf("."));
		}
		if(viewName.lastIndexOf("/")!=-1) {
			viewName=viewName.substring(viewName.lastIndexOf("/",1), viewName.length());
		}
		return viewName;
	}
}
