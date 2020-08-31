package é��18_IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ��03_BufferedInputStreamExample {
	public static void main(String[] args) throws Exception {
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\PC\\eclipse-workspace\\�̰����ڹٴ�\\src\\é��18_IO\\forest.jpg");
		start = System.currentTimeMillis();
		while(fis1.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("������� �ʾ��� ��: " + (end - start) + "ms");
		fis1.close();
		
		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\PC\\eclipse-workspace\\�̰����ڹٴ�\\src\\é��18_IO\\forest.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		start = System.currentTimeMillis();
		while(bis.read() != -1) {}
		end = System.currentTimeMillis();
		System.out.println("������� ��: " + (end - start) + "ms");
		fis2.close();
	}
}
