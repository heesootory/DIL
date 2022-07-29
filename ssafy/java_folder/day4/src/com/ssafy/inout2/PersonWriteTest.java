package com.ssafy.inout2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonWriteTest {
	public static void main(String[] args) {
		Person p = new Person("김형균", "970");
		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("person.dat"))){
			os.writeObject(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
