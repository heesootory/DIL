package com.ssafy.inout1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
	public static void main(String[] args) {
		String path = "C:\\Temp\\";
		
		String originFile = path + "ByeJava.txt"; //얘를 InputStream 에 넣을꺼야
		String destFile = path + "복사본.txt";  //얘를 OutputStream
		
		try(FileOutputStream fo = new FileOutputStream(destFile);
				FileInputStream fi = new FileInputStream(originFile)){
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fi.read(buf)) > 0) {
				fo.write(buf, 0, size);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
