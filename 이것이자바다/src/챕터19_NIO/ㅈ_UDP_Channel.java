package é��19_NIO;

public class ��_UDP_Channel {
	// NIO���� UDP ä���� DatagramChannel�̴�. DatagramChannel�� TCP ä�ΰ� ���������� ���ŷ�� �ͺ��ŷ ������� ����� �� ������, �� å������ ���ŷ ��ĸ� �����ϵ��� �ϰڴ�.
	
			//	Creation Caller		�߽��� �����
	
	// �߽��� ���α׷��� �����غ��鼭 DatagramChannel�� ����ϴ� ����� ���� �˾ƺ���� ����. Datagram�� �����Ϸ��� open() �޼ҵ带 ȣ���ؾ� �Ѵ�.
	// open() �޼ҵ�� ProtocalFamily �������̽� Ÿ���� �Ű����� �����µ�, �� ��ü�� ������ IPv4�� IPv6�� �����ϱ� ���ؼ��̴�.
	// ���� ��ü�� StandardProtocalFamily ���� ����� ����ϸ� �ȴ�. ������ IPv4�� ����ϴ� DatagramChannel�� �����ϴ� �ڵ��̴�.
	
	//	DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocalFamily.INET);
	
	// DatagramChannel�� �̿��ؼ� �����͸� ������ ���ؼ��� send() �޼ҵ带 �̿��Ѵ�. send() �޼ҵ��� ù ��° �Ű����� ���� �����͸� ������ �ִ� ByteBuffer�̰�,
	// �� ��° �Ű����� ������ IP�� ��Ʈ ������ ������ �ִ� SocketAddress�̴�. SocketAddress�� �߻� Ŭ�����̹Ƿ� ���� Ŭ������ InetSocketAddress ��ü�� �����ϰ� �����ϸ� �ȴ�.
	// send() �޼ҵ��� ���ϰ��� ������ ���� ����Ʈ ���̴�. ������ ���� PC 5001���� �����ڷ��ϰ� �����͸� ������.
	
	//	int byteCount = datagramChannel.send(byteBuffer, new InetSocketAddress("local", 5001));
	
	// �� �̻� ���� �����Ͱ� ���� ��쿡�� DatagramChannel�� �ݱ� ���� close() �޼ҵ带 ȣ���Ѵ�.
	
	//	datagramChannel.close();
	
	// ���� ������ UDP �߽� ���α׷��̴�. for���� �� �� �ݺ��ϴµ� ���� "�޼���1", "�޼���2" ���ڿ��� �����Ѵ�.
	
			//	Creation Receiver	������ �����
	
	// �̹����� DatagramChannel�� ������ ���α׷��� �����ϴ� ����� ���� �˾ƺ���� ����. DatagramChannel�� �̿��ؼ� �����͸� �ޱ� ���ؼ��� bind() �޼ҵ带 ȣ���ؼ� ��Ʈ�� ���� ���ε��� �ؾ��Ѵ�.
	// �Ű����� SocketAddress Ÿ������ InetSocketAddress ��ü�� �����ϸ� �ȴ�.
	
	//	DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocalFamily.INET);
	//	datagramChannel.bind(new InetSocketAddress(5001));
	
	// ��Ʈ�� ���ε��� �Ǿ��ٸ� ������ ���� receive() �޼ҵ�� �����͸� ���� �� �ִ�. receive() �޼ҵ��� �Ű����� ���� �����͸� ������ ByteBuffer�̰�,
	// ���� Ÿ���� ���� Ŭ���̾�Ʈ�� IP�� ��Ʈ ������ ������ �ִ� SocketAddress�̴�. �����δ� InetSockeAddress�� ���ϵȴ�.
	
	// �����͸� �ޱ� ������ receive() �޼ҵ�� ���ŷ�ǰ�, �����͸� ������ ���ϵȴ�. �����ڴ� �׻� �����͸� ���� �غ� �ؾ� �ϹǷ� �۾� �����带 �����ؼ� receive() �޼ҵ带 �ݺ������� ȣ���ؾ� �Ѵ�.
	// �۾� �����带 �����Ű�� ����� �� �����ε�, receive() �޼ҵ尡 ���ŷ�Ǿ� �ִ� ���¿��� �۾� �������� interrupt()�� ȣ����� ClosedByInterruptException ���ܸ� �߻� ��Ű�ų�,
	// ������ ���� DatagramChannel�� close()�� ȣ����� AsynchronousCloseException ���ܸ� �߻���Ű�� ���̴�. �׸��� ���� ó�� �ڵ忡�� �۾� �����带 �����Ű�� �ȴ�.
	
	//	datagramChannel.close();
	
	// ������ ������ ���α׷��� ��ü �ڵ��̴�. ���� �� 10�ʰ� ������ �����ڸ� �����ϵ��� �ߴ�.
	
			//	Run Sender And Receiver		�����ڿ� �߽��� ����
	
	// ���� ������ ���������, �����ڸ� ���� �����ϰ� �߽��ڸ� �����ؾ߸� �߽��ڰ� ���� �����͸� �����ڰ� ��� ���� �� �ִ�.
	// �߽��ڸ� �ռ� �����ϸ� �����ڰ� �����ϱ� ���� ���� �����ʹ� ���� �� ����.
}
