package 챕터18_IO;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Question11_ServerExample {
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket();
		serverSocket.bind(new InetSocketAddress("localhost", 5001));
		
		System.out.println("[서버 시작]");
		
		System.out.println();
		
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				
				InputStream is = socket.getInputStream();
				
				byte[] bytes = new byte[1000];
				int readByteCount = -1;
				
				
				
				System.out.println("[파일 이름 받기 시작]");
				
				is.read(bytes, 0, 100);
				String fileName = new String(bytes, 0, 100, "UTF-8");
				fileName = fileName.trim();
				System.out.println("파일 이름: " + fileName);
				
				System.out.println("[파일 이름 받기 완료]");
				
				System.out.println();
				
				System.out.println("[파일 받기 시작]" + fileName);
				
				FileOutputStream fos = new FileOutputStream("C:/Temp/" + fileName);
				while( (readByteCount = is.read(bytes)) != -1) {
					fos.write(bytes);
				}
				fos.flush();
				
				System.out.println("[파일 받기 완료]");
				
				
				
				fos.close();
				is.close();
				socket.close();
			} catch (Exception e) {
				break;
			}
		}
		
		serverSocket.close();
		System.out.println("[서버 종료]");
	}
}
