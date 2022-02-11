package com.spring.ex01;

import org.aopalliance.intercept.MethodInvocation;
import org.aopalliance.intercept.MethodInterceptor;

public class LoggingAdvice implements MethodInterceptor
{
	public Object invoke(MethodInvocation invocation) throws Throwable
	{
		//메서드 호출 전에 수행되는 구문
		System.out.println("[메서드 호출 전 : LogginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 전"); 
		
		Object object = invocation.proceed(); //invocation을 이용해 메서드 호출
		
		//메서드 호출 후에 수행되는 구문
		System.out.println("[메서드 호출 후 : logginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출 후");
		return object;
	}
}
