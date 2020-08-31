package é��19_NIO;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class ��1_UdpReceiveExample {
	public static void main(String[] args) throws Exception {
		DatagramChannel datagramChannel =
			DatagramChannel.open(StandardProtocolFamily.INET);
		datagramChannel.bind(new InetSocketAddress("localhost", 5001));
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				System.out.println("[���� ����]");
				try {
					while(true) {
						ByteBuffer byteBuffer = ByteBuffer.allocate(100);
						SocketAddress socketAddress = datagramChannel.receive(byteBuffer);
						byteBuffer.flip();
						
						Charset charset = Charset.forName("UTF-8");
						String data = charset.decode(byteBuffer).toString();
						System.out.println("[���� ����: " + socketAddress.toString() + "] " + data);
					}
				} catch (Exception e) {
					System.out.println("[���� ����]");
				}
			}
		};
		thread.start();
		
		Thread.sleep(10000);
		datagramChannel.close();
	}		
}
