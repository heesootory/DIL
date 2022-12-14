package com.ssafy.exception3;

public class FruitNotFoundException extends Exception {
	public FruitNotFoundException(String name) {//이것도 생성자
		super(name + "에 해당하는 과일은 없어요 ㅠ^ㅠ");
		
	}
}
