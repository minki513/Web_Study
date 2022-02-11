package com.spring.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest2 {
	public static void main(String[] args)
	{
		//���� �� person.xml�� �о�鿩 ���� ����
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		//id�� personService1�� ���� ������
		PersonService person1 = (PersonService) factory.getBean("personService1");
		person1.sayHello();
		System.out.println();
		//id�� personService2�� ���� ������
		PersonService person2 = (PersonService) factory.getBean("personService2");
		person2.sayHello();
	}
}
