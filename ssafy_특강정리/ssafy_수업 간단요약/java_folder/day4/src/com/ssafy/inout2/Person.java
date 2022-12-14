package com.ssafy.inout2;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable{
	private static final long serialVersionUID = 4745410959216873527L;
	String name;
	String pNum;
	
	public Person() {
	}
	
	public Person(String name, String pNum) {
		this.name = name;
		this.pNum = pNum;
	}

	@Override
	public String toString() {
		return "name=" + name + ", pNum=" + pNum;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pNum);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		Person other = (Person) obj;
		return pNum.equals(other.pNum);
	}

	@Override
	public int compareTo(Person o) {
		return this.pNum.compareTo(o.pNum);
	}
	
}
