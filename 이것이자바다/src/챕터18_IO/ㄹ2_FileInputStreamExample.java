package é��18_IO;

import java.io.FileInputStream;

public class ��2_FileInputStreamExample {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream(
			"C:\\Users\\PC\\eclipse-workspace\\�̰����ڹٴ�\\src\\é��18_IO\\��2_FileInputStreamExample.java"
		);
		
		int data;
		while( ( data = fis.read() ) != -1) {
			System.out.write(data);				// 1 byte �� �а� �ֿܼ� ���
			System.out.println(data);
		}
		fis.close();
	}
}
