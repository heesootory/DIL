package com.ssafy.exception2;

public class CheckedExceptionTest {
	public static void main(String[] args) {
		CheckedExceptionTest c = new CheckedExceptionTest();
		
		try {
			c.method1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void method1() throws ClassNotFoundException {
		method2();
	}
	
	public void method2() throws ClassNotFoundException {
		Class.forName("SSAFY");
	}
}
