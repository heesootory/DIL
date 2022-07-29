package com.ssafy.inout2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersonListWriteTest {
	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<>();
		list.add(new Person("김형균", "970"));
		list.add(new Person("안태윤", "777"));
		list.add(new Person("김형균", "418"));
		list.add(new Person("김인중", "888"));
		list.add(new Person("비밀번호", "486"));
		

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("personList.dat"))) {
			os.writeObject(list);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
