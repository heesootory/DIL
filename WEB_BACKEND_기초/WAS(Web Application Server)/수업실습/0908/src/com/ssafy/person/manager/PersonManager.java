package com.ssafy.person.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ssafy.person.dto.Person;

public class PersonManager {
	
	private List<Person> list;
	private int idx = 0;			//총 인원
	
	private static PersonManager instance = new PersonManager();
	
	private PersonManager() {
		list = new ArrayList<Person>();
	};
	
	public static PersonManager getInstance() {
		return instance;
	}
	
	//목록을 조회 -> 읽기 전용으로 만들기 위해, 배열로 전달함.
	public Person[] getAll() {
		if(idx == 0) {
			return null;
		}else {
			return list.toArray(new Person[list.size()]);
		}
	}
	
	//번호에 해당하는 사람을 조회
	public Person getPerson(int no) {
		for(Person rp : list) {
			if(rp.getNo() == no) {
				return rp;
			}
		}
		return null;
	}
	
	// 사람을 추가 -> 이름이 없거나 , 나이가 없거나 하면 예외를 생성해서 던질수 있다.
	public void addPerson(Person p) {
		list.add(p);
		idx++;
	}
	
	//사람을 수정
	public void updatePerson(Person p) {
		for(Person person : list) {
			if(person.getNo() == p.getNo()) {
				person.setName(p.getName());
				person.setAge(p.getAge());
				person.setMsg(p.getMsg());
			}
		}
	}
	
	// 사람을 삭제
	public void removePerson(int no) {
		Person p = this.getPerson(no);
		list.remove(p);
		idx--;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
