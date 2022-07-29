package com.ssafy.generic;

public class NumberBox<T extends Number>{
	public void addSome(T... ts) {
		double sum = 0;
		
		for(T t : ts) {
			sum += t.doubleValue();
		}
		
		System.out.println("총합은 ? "+ sum);
	}
	
	
}
