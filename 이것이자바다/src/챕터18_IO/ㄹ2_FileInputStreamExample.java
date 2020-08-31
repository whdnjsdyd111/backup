package 챕터18_IO;

import java.io.FileInputStream;

public class ㄹ2_FileInputStreamExample {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(
			"C:\\Users\\PC\\eclipse-workspace\\이것이자바다\\src\\챕터18_IO\\ㄹ2_FileInputStreamExample.java"
		);
		
		int data;
		while( ( data = fis.read() ) != -1) {
			System.out.write(data);				// 1 byte 씩 읽고 콘솔에 출력
			System.out.println(data);
		}
		fis.close();
	}
}
