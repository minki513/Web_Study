package com.spring.ex02;

public class PersonServiceImpl implements PersonService{
	private String name;
	private int age;
	
	public PersonServiceImpl(String name) 
	{ //person.xml���� ���ڰ� �Ѱ� �� ������ ������ ���
		this.name = name;
	}
	
	public PersonServiceImpl(String name,int age) 
	{ //person.xml���� ���ڰ� �ΰ� �� ������ ������ ���
		this.name = name;
		this.age = age;
	}
	@Override
	public void sayHello()
	{
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age +"��");
	}
}
