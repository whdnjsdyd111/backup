package é��18_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class Question11_ClientExample {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 5001);
		OutputStream os = socket.getOutputStream();
		
		String filePath = 
				"C:/Users/PC/eclipse-workspace/�̰����ڹٴ�/src/é��18_IO/house.jpg";
		File file = new File(filePath);
		
		
		
		System.out.println("[���� �̸� ������]");
		
		String fileName = file.getName();
		System.out.println(fileName);
		byte[] bytes = fileName.getBytes("UTF-8");
		bytes = Arrays.copyOf(bytes, 100);
		os.write(bytes);
		
		System.out.println("[���� �̸� ������ ����]");
		
		System.out.println();
		
		System.out.println("[���� ������ ����] " + fileName);
		
		FileInputStream fis = new FileInputStream(file);
		byte[] fileBytes = new byte[1000];
		int data = 0;
		while( (data = fis.read(fileBytes)) != -1) {
			os.write(fileBytes);
		}
		
		os.flush();
		
		fis.close();
		os.close();
		socket.close();
	}
}
