package 챕터18_IO;

import java.io.FileInputStream;

public class Question07 {
	public static void main(String[] args) throws Exception {
		
		String filePath = 
				"C:\\Users\\PC\\eclipse-workspace\\이것이자바다\\src\\챕터18_IO\\ㅁ04_BufferedReaderExample.java";
		
		FileInputStream fis = new FileInputStream(filePath);
		
		int data;
		
		while( (data = fis.read()) != -1) {
			System.out.write(data);
		}
		
		fis.close();
	}
}
