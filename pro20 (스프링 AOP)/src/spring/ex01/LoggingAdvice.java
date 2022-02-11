package com.spring.ex01;

import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;

public class LoggingAdvice implements MethodInterceptor
{
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		//�޼��� ȣ�� ���� ����Ǵ� ����
		System.out.println("[�޼��� ȣ�� �� : LogginAdvice");
		System.out.println(invocation.getMethod() + "�޼��� ȣ�� ��"); 
		
		Object object = invocation.proceed(); //invocation�� �̿��� �޼��� ȣ��
		
		//�޼��� ȣ�� �Ŀ� ����Ǵ� ����
		System.out.println("[�޼��� ȣ�� �� : logginAdvice");
		System.out.println(invocation.getMethod() + "�޼��� ȣ�� ��");
		return object;
	}
}
