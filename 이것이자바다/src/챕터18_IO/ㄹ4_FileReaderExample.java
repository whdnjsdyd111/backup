package 챕터18_IO;

import java.io.FileReader;

public class ㄹ4_FileReaderExample {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader(
				"C:\\Users\\PC\\eclipse-workspace\\이것이자바다\\src\\챕터18_IO\\ㄹ4_FileReaderExample.java");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while( (readCharNo = fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.print(data);
		}
		fr.close();
	}
}
