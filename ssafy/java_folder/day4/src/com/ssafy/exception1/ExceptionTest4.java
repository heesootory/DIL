package com.ssafy.exception1;

import java.util.Random;

public class ExceptionTest4 {
	public static void main(String[] args) {
//		int num = new Random().nextInt(2);
		int num = 1;
		
		try {
			System.out.println("1");
			int i = 1 / num; //예외가 발생할 수 있는 부분
			System.out.println("2");
			return;
		}catch (ArithmeticException e) {
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
		System.out.println("5");
		
	}
}
