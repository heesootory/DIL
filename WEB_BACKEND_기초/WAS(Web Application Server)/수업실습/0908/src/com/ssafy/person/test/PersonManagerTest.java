package com.ssafy.person.test;

import java.util.Arrays;

import com.ssafy.person.dto.Person;
import com.ssafy.person.manager.PersonManager;

public class PersonManagerTest {
	public static void main(String[] args) {
		PersonManager pm = PersonManager.getInstance();
		Person p = new Person();
		p.setNo(10);
		p.setName("choi");
		p.setAge(26);
		p.setMsg("안녕하세요");
		
		pm.addPerson(p);
		System.out.println(pm.getPerson(10));
		System.out.println(Arrays.toString(pm.getAll()));
		
	}
}
