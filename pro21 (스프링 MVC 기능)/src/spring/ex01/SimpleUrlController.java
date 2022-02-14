package com.spring.ex01;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SimpleUrlController implements Controller { //���������� �����ϴ� controller�������̽��� �ݵ�� ����
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("index.jsp"); //�۾��� ��ģ �� ���̸��� modelandview�� index.jsp�� �����Ͽ� ��ȯ
	}
}
