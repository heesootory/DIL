package com.ssafy.generic;

public class UseBoxTest {
	public static void main(String[] args) {
		//필드로 Object를 가지고 있으니 무엇이든지 저장할 수 있음. 
//		NormalBox nbox = new NormalBox();
//		nbox.setSome("Hello");
//		
//		Object some = nbox.getSome();
//		if(some instanceof String) {
//			String someStr = (String) some;
//			System.out.println(someStr);
//		}
		
//		GenericBox<String> gbox = new GenericBox<>();
//		gbox.setSome("Hi");
//		String some = gbox.getSome();
//		
//		System.out.println(some);
		
		NumberBox<Number> nbox = new NumberBox<>();
		nbox.addSome(1,2,3,4,5,6);
		
		
	}
}
