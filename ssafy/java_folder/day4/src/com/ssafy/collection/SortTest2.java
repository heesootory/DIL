package com.ssafy.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest2 {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		
		list.add(new Person("Mike1","123"));
		list.add(new Person("Mike3","111"));
		list.add(new Person("Mike2","321"));
		list.add(new Person("Mike5","987"));
		list.add(new Person("Mike6","555"));
		list.add(new Person("Mike4","456"));
		
		Collections.sort(list);

		for(Person p : list) {
			System.out.println(p);
		}
		
		System.out.println("----------------");
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		
		for(Person p : list) {
			System.out.println(p);
		}
	}
}
