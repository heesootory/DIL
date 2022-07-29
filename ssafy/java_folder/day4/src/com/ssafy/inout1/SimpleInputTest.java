package com.ssafy.inout1;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class SimpleInputTest {
	public static void main(String[] args) {
		SimpleInputTest si = new SimpleInputTest();
//		si.read1();
//		si.read2();
		si.read3();
	}
	void read3() {
		char[] buffer = new char[10];
		try(Reader input = new CharArrayReader(data2.toCharArray())) {
			int read = -1;
			while((read = input.read(buffer))>0) {
				System.out.printf("읽은 개수 : %d, 문자열로 : %s \n", read, new String(buffer, 0, read));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	String data2 = "자바는 객체지향 언어입니다.";

	void read2() {
		// try with resources
		byte[] buffer = new byte[10];
		try (InputStream input = new ByteArrayInputStream(data2.getBytes())) {
			int read = -1;
			while ((read = input.read(buffer)) >0) {
				System.out.printf("읽은 개수 : %d, 문자열로 : %s \n", read, new String(buffer, 0, read));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	String data = "hi java world";

	void read1() {
		// try with resources
		try (InputStream input = new ByteArrayInputStream(data.getBytes())) {
			int read = -1;
			while ((read = input.read()) != -1) {
				System.out.printf("읽은 값 : %d, 문자로 : %c \n", read, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
