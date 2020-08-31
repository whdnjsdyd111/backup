package é��18_IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ��1_ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));	// ServerSocket ����
			
			while(true) {
				System.out.println("[���� ��ٸ�]");
				Socket socket = serverSocket.accept();	// Ŭ���̾�Ʈ ���� ����
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[���� ������] " + isa.getHostName());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(!serverSocket.isClosed()) {		// ServerSocket�� �������� ���� ���
			try {	
				serverSocket.close();		// // ServerSocket �ݱ�		
			}catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}
