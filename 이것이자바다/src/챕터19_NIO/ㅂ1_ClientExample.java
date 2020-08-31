package 챕터19_NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ㅂ1_ClientExample {
	public static void main(String[] args) {
		SocketChannel socketChannel = null;
		
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(true);
			System.out.println("[연결 요청]");
			socketChannel.connect(new InetSocketAddress("localhost", 5001));
			System.out.println("[연결 성공]");
		} catch (Exception e) {}
		
		if(socketChannel.isOpen()) {
			try {
				socketChannel.close();
			} catch(IOException e) {}
		}
	}
}
