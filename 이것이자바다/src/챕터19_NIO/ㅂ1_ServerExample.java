package 챕터19_NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ㅂ1_ServerExample {
	public static void main(String[] args) {
		ServerSocketChannel serverSocketChannel = null;
		
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(true);
			serverSocketChannel.bind(new InetSocketAddress(5001));
			
			while(true) {
				System.out.println("[연결 기다림]");
				SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
				System.out.println("[연결 수락함] " + isa.getHostName());
			}
		} catch (Exception e) {}
		
		if(serverSocketChannel.isOpen()) {	// ServerSocketChannel이 열려있을 경우
			try {
			serverSocketChannel.close();	// ServerSocketChannel 닫기
			} catch (IOException e) {}
		}
	}
}
