package com.ssafy.exception1;

public class ExceptionTest3 {
	public static void main(String[] args) {
		int[] nums = { 10 };
		
		try {
			System.out.println(nums[2]);
		}catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace(); // 인덱스 에러
		}catch (ArithmeticException e) {
			e.printStackTrace(); //수학적 예외상황
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램을 종료합니다.");
	}
}
