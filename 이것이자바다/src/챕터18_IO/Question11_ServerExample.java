package é��18_IO;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Question11_ServerExample {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("localhost", 5001));
		
		System.out.println("[���� ����]");
		
		System.out.println();
		
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				
				InputStream is = socket.getInputStream();
				
				byte[] bytes = new byte[1000];
				int readByteCount = -1;
				
				
				
				System.out.println("[���� �̸� �ޱ� ����]");
				
				is.read(bytes, 0, 100);
				String fileName = new String(bytes, 0, 100, "UTF-8");
				fileName = fileName.trim();
				System.out.println("���� �̸�: " + fileName);
				
				System.out.println("[���� �̸� �ޱ� �Ϸ�]");
				
				System.out.println();
				
				System.out.println("[���� �ޱ� ����]" + fileName);
				
				FileOutputStream fos = new FileOutputStream("C:/Temp/" + fileName);
				while( (readByteCount = is.read(bytes)) != -1) {
					fos.write(bytes);
				}
				fos.flush();
				
				System.out.println("[���� �ޱ� �Ϸ�]");
				
				
				
				fos.close();
				is.close();
				socket.close();
			} catch (Exception e) {
				break;
			}
		}
		
		serverSocket.close();
		System.out.println("[���� ����]");
	}
}
