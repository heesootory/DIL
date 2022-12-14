package com.ssafy.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("김형균");
		names.add("장재욱");
		names.add("김현수");
		names.add("김현수");
		names.add(0, "한상원");
		
		System.out.println(names);
		
		//비어있는지 쳌
		System.out.println(names.isEmpty());
		System.out.println(names.size());
		
		
//		for(int i = 0 ; i<names.size(); i++) {
//			System.out.println(names.get(i));
//		}
//		
		
//		names.set(4, "이지우");
		
		names.remove(0);
		names.remove("김현수");
		
		
		
//		for(String name : names) {
//			System.out.println(name);
//		}
		
		//삭제할떙
		
		names.clear();
		names.add("양");
		names.add("양");
		names.add("킴");

		//앞에서부터 지워본다.
//		for(int i = 0 ; i<names.size(); i++) {
//			if(names.get(i).equals("양")) {
//				names.remove(i);
//			}
//		}
		//뒤에서부터 보면서 지운다.
		for(int i = names.size()-1 ; i>=0; i--) {
			if(names.get(i).equals("양")) {
				names.remove(i);
			}
		}
		
		for(String name : names) {
			System.out.println(name);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
