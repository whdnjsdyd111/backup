package é��18_IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ��1_ClientExample {
	public static void main(String[] args) {
		Socket socket = null;
		
		try {
			socket = new Socket();
			System.out.println("[���� ��û]");
			
			socket.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[���� ����]");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {}
		}
	}
}
