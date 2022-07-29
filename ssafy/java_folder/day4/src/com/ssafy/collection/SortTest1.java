package com.ssafy.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortTest1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("김인중");
		list.add("이해건");
		list.add("현승민");
		list.add("오하늘");
		list.add("남기정");
		list.add("samsung");
		list.add("SAMSUNG");
		
		Collections.sort(list);
		
		System.out.println(list);
	}
}
