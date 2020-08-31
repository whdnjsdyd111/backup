package é��19_NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ��2_ServerExample {
	public static void main(String[] args) {
		ServerSocketChannel serverSocketChannel = null;
		
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(true);
			serverSocketChannel.bind(new InetSocketAddress("localhost", 5001));
			
			while(true) {
				System.out.println("[���� ���]");
				SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
				System.out.println("[���� ������] " + isa.getHostName());
				
				ByteBuffer byteBuffer = null;
				Charset charset = Charset.forName("UTF-8");
				
				byteBuffer = ByteBuffer.allocate(100);
				int byteCount = socketChannel.read(byteBuffer);
				byteBuffer.flip();
				String message = charset.decode(byteBuffer).toString();
				System.out.println("[������ �ޱ� ����] " + message);
				
				byteBuffer = charset.encode("Hello Client");
				socketChannel.write(byteBuffer);
				System.out.println("[������ ������ ����]");
			}
		} catch (Exception e) {}
		
		if(serverSocketChannel.isOpen()) {
			try {
				serverSocketChannel.close();
			} catch(IOException e) {}
		}
	}
}
