package é��18_IO;

import java.io.FileInputStream;

public class Question07 {
	public static void main(String[] args) throws Exception {
		
		String filePath = 
				"C:\\Users\\PC\\eclipse-workspace\\�̰����ڹٴ�\\src\\é��18_IO\\��04_BufferedReaderExample.java";
		
		FileInputStream fis = new FileInputStream(filePath);
		
		int data;
		
		while( (data = fis.read()) != -1) {
			System.out.write(data);
		}
		
		fis.close();
	}
}
