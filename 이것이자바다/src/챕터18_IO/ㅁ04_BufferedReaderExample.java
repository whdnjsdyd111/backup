package é��18_IO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ��04_BufferedReaderExample {
	public static void main(String[] args) throws Exception {
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader);		// ���� ��Ʈ�� ����
		
		System.out.print("�Է�: ");
		String lineString = br.readLine();
		
		System.out.print("���: " + lineString);
	}
}
