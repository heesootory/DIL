package com.ssafy.person.dto;

public class Person {
	private int no;
	private String name;
	private int age;
	private String msg;		// 자기소개
	
	
	
	public Person() {
		super();
	}

	public Person(int no, String name, int age, String msg) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.msg = msg;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Person [no=" + no + ", name=" + name + ", age=" + age + ", msg=" + msg + "]";
	}
	
	
}
