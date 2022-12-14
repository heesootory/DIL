package com.ssafy.generic;

class Person {

}

class Student extends Person {

}

class PersonBox<T> {

}

public class WildCardTest {
	public static void main(String[] args) {
		PersonBox<Object> pobj = new PersonBox<>();
		PersonBox<Person> pper = new PersonBox<>();
		PersonBox<Student> pst = new PersonBox<>();

		PersonBox<?> pAll = pobj;
		pAll = pper;
		pAll = pst;

		// Person 또는 상속 받은 경우만 넣을 수 있다.
		PersonBox<? extends Person> pChild = pper;
		pChild = pst;
//		pChild = pobj;

		// Person 또는 조상만 받을 수 있다.
		PersonBox<? super Person> pSuper = pper;
		pSuper = pobj;
//		pSuper = pst;

	}
}
