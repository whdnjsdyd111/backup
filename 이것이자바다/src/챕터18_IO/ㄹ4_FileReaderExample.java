package é��18_IO;

import java.io.FileReader;

public class ��4_FileReaderExample {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader(
				"C:\\Users\\PC\\eclipse-workspace\\�̰����ڹٴ�\\src\\é��18_IO\\��4_FileReaderExample.java");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while( (readCharNo = fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo);
			System.out.print(data);
		}
		fr.close();
	}
}
