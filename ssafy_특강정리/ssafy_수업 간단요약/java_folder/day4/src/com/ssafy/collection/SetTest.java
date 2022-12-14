package com.ssafy.collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Kim");
		set.add("Hong");
		set.add("Lim");
		set.add("Kim"); //중복을 허용하지 않기 때문에 ..
		set.add("Apple");
		System.out.println(set);
		
//		Person p1 = new Person("김현수", "654");
//		Person p2 = new Person("안태윤", "654");
//		
//		System.out.println(p1 == p2 );
//		System.out.println(p1.equals(p2));
		
		Set<Person> pSet = new HashSet<>();
		pSet.add(new Person("김현수", "654"));
		pSet.add(new Person("안태윤", "654"));
		System.out.println(pSet);
//		
		
	}
}
