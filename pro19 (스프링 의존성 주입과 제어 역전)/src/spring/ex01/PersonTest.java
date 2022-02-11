package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	public static void main(String[] args)
	{
		//실행 시 person.xml을 읽어들여 빈을 생성
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("Person.xml"));
		//id가 personService인 빈을 가져옴
		PersonService person = (PersonService) factory.getBean("personService");
		person.sayHello(); //생성된 빈을 이용해 name값을 출력
	}
}
