package é��19_NIO;

import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class ��1_UdpSendExample {
	public static void main(String[] args) throws Exception {
		DatagramChannel datagramChannel =
				DatagramChannel.open(StandardProtocolFamily.INET);
		
		System.out.println("[�߽� ����]");
		
		for (int i = 0; i < 3; i++) {
			String data = "�޼���" + i;
			Charset charset = Charset.forName("UTF-8");
			ByteBuffer byteBuffer = charset.encode(data);
			
			int byteCount = datagramChannel.send(
				byteBuffer,
				new InetSocketAddress("localhost", 5001)
			);
			System.out.println("[���� ����Ʈ ��] " + byteCount + " bytes");
		}
		
		System.out.println("[�߽� ����]");
		
		datagramChannel.close();
	}
}
