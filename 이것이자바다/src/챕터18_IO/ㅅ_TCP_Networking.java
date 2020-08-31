package é��18_IO;

public class ��_TCP_Networking {
	// TCP ( Transmission Control Protocol )�� ���� ������ ���������̴�. ���� ���� ���������̶� Ŭ���̾�Ʈ�� ������ ����� ���¿��� �����͸� �ְ�޴� ���������� ���Ѵ�.
	// Ŭ���̾�Ʈ�� ���� ��û�� �ϰ�, ������ ������ �����ϸ� ��� ���ΰ� �����ǰ�, ��� �����ʹ� ������ ��� ���θ� ���ؼ� ���������� ���޵ȴ�.
	// �׷��� ������ TCP�� �����͸� ��Ȯ�ϰ� ���������� �����Ѵ�. TCP�� ������ �����͸� ������ ���� �ݵ�� ������ �����Ǿ�� �ϰ�(���� �ð��� ���� �ɸ��� �۾�), ������ ��� ���ΰ� �ִܼ�(��Ʈ��ũ ���� ����)�� �ƴ� ���
	// ��������� UDP(User Datagram Protocol)���� ������ ���� �ӵ��� ���� �� �ִ�. 
	// �ڹٴ� TCP ��Ʈ��ŷ�� ���� java.net.ServerSocket�� java.net.Socket Ŭ������ �����ϰ� �ִ�. �� �� Ŭ������ ��� ����� �˾ƺ���� ����.
	
			//	Purpose Of ServerSocket And Socket
	
	// TCP ������ ������ �� ������ �� �� �ִ�. �ϳ��� Ŭ���̾�Ʈ�� ���� �䫊�� �ؿ��� ������ �����ϴ� ���̰�, �ٸ� �ϳ��� ����� Ŭ���̾�Ʈ�� ����ϴ� ���̴�.
	// �ڹٿ����� �� �� ���Һ��� ������ Ŭ������ �����ϰ� �ִ�. Ŭ���̾�Ʈ�� ���� �䫊�� ��ٸ��鼭 ���� ������ ����ϴ� ���� java.net.ServerSocket Ŭ�����̰�,
	// ����� Ŭ���̾�Ʈ�� ����� ����ϴ� ���� java.net.Socket Ŭ�����̴�. Ŭ���̾�Ʈ�� ���� ��û�� �ؿ��� ServerSocket�� ������ �����ϰ� ��ſ� Socket�� �����.
	
	//											����������������������������������������������������������
	//			������������������������������������������			��	����						��
	//			��	Ŭ���̾�Ʈ			��			��		������������������������������������	��
	//			��					�� 1 ���� ��û	��	��������������	ServerSocket ��	��
	//			��		Socket	����������������������������������������5001��������������	accept() ��	��
	//			��		      ��	����������������������������������	��	��������������			��	 ��	��
	//			��					��  3 ���	��	��		������������������������������������	��
	//			������������������������������������������		����������������������	Socket �禡�������� 2 ���� ����
	//											����������������������������������������������������������					
	
	// ������ Ŭ���̾�Ʈ�� ������ ��Ʈ�� ������ �־�� �ϴµ�, �� ��Ʈ�� ���ε�(binding) ��Ʈ��� �Ѵ�. ������ ������ ��Ʈ ��ȣ�� ���ε��ؼ� �����ϹǷ�, ServerSocket�� ������ �� ��Ʈ ��ȣ �ϳ��� �����ؾ� �Ѵ�.
	// ������ 5001���� ���� ���ε� ��Ʈ�̴�. ������ ����Ǹ� Ŭ���̾�Ʈ�� ������ IP �ּҿ� ���ε� ��Ʈ ��ȣ�� Socket�� �����ؼ� ���� ��û�� �� �� �ִ�.
	// ServerSocket�� Ŭ���̾�Ʈ�� ���� ��û�� �ؿ��� accept() �޼ҵ�� ���� ������ �ϰ� ��ſ� Socket�� �����Ѵ�. �׸��� ���� Ŭ���̾�Ʈ�� ������ ������ Socket�� �̿��ؼ� �����͸� �ְ�ް� �ȴ�.
	
			//	ServerSocket Creation And Accept Connection		ServerSocket ������ ���� ����
	
	// ������ �����Ϸ��� �켱 ServerSocket ��ü�� ���� �Ѵ�. ServerSocket�� ��� ���� ������ ����� �����ڿ� ���ε� ��Ʈ�� �����ϰ� ��ü�� �����ϴ� ���̴�.
	// ������ 5001�� ��Ʈ�� ���ε��ϴ� ServerSocket�� �����Ѵ�.
	
	//	ServerSocket serverSocket = new ServerSocket(5001);
	
	// ServerSocket�� ��� �ٸ� ����� ����Ʈ �����ڷ� ��ü�� �����ϰ� ��Ʈ ���ε��� ���� bind() �޼ҵ带 ȣ���ϴ� ���̴�.
	// bind() �޼ҵ��� �Ű����� ��Ʈ ������ ���� InetSocketAddress�̴�.
	
	//	ServerSocket serverSocket = new ServerSocket();
	//	serverSocket.bind(new InetSocketAddress(5001));
	
	// ���� ������ PC�� ��Ƽ IP�� �Ҵ�Ǿ� ���� ���, Ư�� IP�� ������ ���� ���� ������ �ϰ� �ʹٸ� ������ ���� �ۼ��ϵ�, "localhost" ��� ��Ȯ�� IP�� �ָ� �ȴ�.
	
	//	ServerSocket serverSocket = new ServerSocket();
	//	serverSocket.bind( new InetSocketAddress("localhost", 5001) );

	// ServerSocket�� ������ �� �ش� ��Ʈ�� �̹� �ٸ� ���α׷����� ��� ���̶�� BindException�� �߻��Ѵ�. �� ��쿡�� �ٸ� ��Ʈ�� ���ε��ϰų�, �ٸ� ���α׷��� �����ϰ� �ٽ� �����ϸ� �ȴ�.
	// ��Ʈ ���ε����� �����ٸ� ServerSocket�� Ŭ���̾�Ʈ ���� ������ ���� accept() �޼ҵ带 �����ؾ� �Ѵ�. accept() �޼ҵ�� Ŭ���̾�Ʈ�� ���� ��û�ϱ� ������ ���ŷ�Ǵµ�,
	// ���ŷ�̶� �����尡 ��� ���°� �ȴٴ� ���̴�. �׷��� ������ UI�� �����ϴ� �����峪, �̺�Ʈ�� ó���ϴ� �����忡�� accept() �޼ҵ带 ȣ������ �ʵ��� �Ѵ�.
	// ���ŷ�� �Ǹ� UI �����̳� �̺�Ʈ ó���� �� �� ���� �����̴�. Ŭ���̾�Ʈ�� ���� ��û�� �ϸ� accept()�� Ŭ���̾�Ʈ�� ����� Socket�� ����� �����Ѵ�. �̰��� ���� �����̴�.
	// ���� accept()���� ���ŷ�Ǿ� ���� �� ServerSocket�� �ݱ� ���� close() �޼ҵ带 ȣ���ϸ� SocketException�� �߻��Ѵ�. �׷��� ������ ���� ó���� �ʿ��ϴ�.
	
	//	try {
	//		Socket socket = serverSocket.accept();
	//	} catch(Exception e) { }
	
	// ����� Ŭ���̾�Ʈ�� IP�� ��Ʈ ������ �˰� �ʹٸ� Socket�� getRemoteSocketAddress() �޼ҵ带 ȣ���ؼ� SocketAddress�� ������ �ȴ�.
	// ���� ���ϵǴ� ���� InetSocketAddress ��ü�̹Ƿ� ������ ���� Ÿ�� ��ȯ�� �� �ִ�
	
	//	InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
	
	// InetSocketAddress���� IP�� ��Ʈ ������ �����ϴ� ������ ���� �޼ҵ���� �ִ�.
	
	//	���� Ÿ��		�޼ҵ��(�Ű� ����)		����
	//
	//	String		getHostName()		Ŭ���̾�Ʈ IP ����
	//
	//	int			getPort()			Ŭ���̾�Ʈ ��Ʈ ��ȣ ����
	//
	//	String		toString			"IP:��Ʈ��ȣ" ������ ���ڿ� ����
	
	// �� �̻� Ŭ���̾�Ʈ ���� ������ �ʿ� ������ ServerSocket�� close() �޼ҵ带 ȣ���ؼ� ��Ʈ�� ����ε����Ѿ� �Ѵ�. �׷��� �ٸ� ���α׷����� �ش� ��Ʈ�� ������ �� �ִ�.
	
	//	serverSocket.close();
	
	// ���� ������ �ݺ������� accept() �޼ҵ带 ȣ���ؼ� ���� Ŭ���̾�Ʈ ������ �����ϴ� ���� �⺻���� �ڵ带 �����ش�.
	
			//	Socket Creation And Connection Request		Socket ������ ���� ��û
	
	// Ŭ���̾�Ʈ�� ������ ���� ��û�� �Ϸ��� java.net.Socket�� �̿��ؾ� �Ѵ�. Socket ��ü�� �����԰� ���ÿ� ���� ��û�� �Ϸ��� �������� �Ű������� ������ IP �ּҿ� ���ε� ��Ʈ ��ȣ�� �����ϸ� �ȴ�.
	// ������ ���� PC�� 5001 ��Ʈ�� ���� ��û�ϴ� �ڵ��̴�.
	
	//	try {
	//		Socket socket = new Socket("localhost", 5001);	// ��� 1
	//		Socket socket = new Socket( new InetSocketAddress("localhost", 5001) );	// ��� 2
	//	} catch (UnknownHostException e) {
	//		// IP ǥ�� ����� �߸��Ǿ��� ���
	//	} catch (IOException e) {
	//		// �ش� ��Ʈ�� ������ ������ �� ���� ���
	//	}
	
	// �ܺ� ������ �����Ϸ��� localhost ��� ��Ȯ�� IP�� �Է��ϸ� �ȴ�. ���� IP ��� ������ �̸��� �˰� �ִٸ�, ������ �̸��� IP �ּҷ� �����ؾ� �ϹǷ� InetSocketAddress ��ü�� �̿��ϴ� ����� ����ؾ� �Ѵ�.
	// Socket ������ ���ÿ� ���� ��û�� ���� �ʰ�, ������ ���� �⺻ �����ڷ� Socket�� ������ ��, connect() �޼ҵ�� ���� ��û�� �� ���� �ִ�.
	
	//	socket = new Socket();
	//	socket.connect( new InetSocketAddress("localhost", 5001) );
	
	// ���� ��û�� �� ���� �� ���� ���ܰ� �߻��� �� �ִ�. UnknownHostException�� �߸� ǥ��� IP �ּҸ� �Է����� ��쿡 �߻��ϰ�, IOException�� �־��� ��Ʈ�� ������ �� ���� �� �߻��Ѵ�.
	// ���� �� ���� ���ܸ� ó���ؾ� �Ѵ�. Socket ������ �� connect() �޼ҵ�� ������ ������ �� ������ ���ŷ�ȴ�. �׷��� ������ UI�� �����ϴ� �����峪, �̺�Ʈ�� ó���ϴ� �����忡�� 
	// Socket ������ �� connect()�� ȣ������ �ʵ��� �Ѵ�. ���ŷ�� �Ǹ� UI �����̳� �̺�Ʈ ó���� �� �� ���� �����̴�.
	// ����� ��, Ŭ���̾�Ʈ ���α׷��� �����ϰų�, ���������� ������ ���� �ʹٸ� Socket�� close() �޼ҵ带 ������ ���� ȣ���ϸ� �ȴ�.
	// close() �޼ҵ嵵 IOException�� �߻��� �� �ֱ� ������ ���� ó���� �ʿ��ϴ�.
	
	//	try {
	//		socket.close();
	//	} catch (IOException e) {}
	
	// ���� ������ localhost 5001 ��Ʈ�� ������ ��û�ϴ� �ڵ��̴�. connect() �޼ҵ尡 ���������� �����ϸ� ������ ������ ���̴�.
	
	// ������ �������� �ۼ��� ServerExample�� ClientExample�� ������ �� ���� ServerExample���� �����ϰ� ClientExample�� �����غ���.
	
			/*	Socket Data Communications		Socket ������ ���	*/
	
	// Ŭ���̾�Ʈ�� ���� ��û(connect())�ϰ� ������ ���� ����(accept()) �ߴٸ�, ������ Socket ��ü�κ��� ���� �Է� ��Ʈ��(InputStream)�� ��� ��Ʈ��(OutputStream)�� ���� �� �ִ�.
	
	//		��������������������������											��������������������������
	//		��	���α׷�	��	InputStream				OutputStream	��	���α׷�	��
	//		��			������������������������������������������������������������������������������������������			��
	//		��			����------------------------------------------��			��
	//		��			������������������������������������������������������������������������������������������			��
	//		��	Socket	��	OutputStream			InputStream		��	Socket	��
	//		��			������������������������������������������������������������������������������������������			��
	//		��			��------------------------------------------�榢			��
	//		��			������������������������������������������������������������������������������������������			��
	//		��������������������������											��������������������������
	
	// ������ Socket���κ��� InputStream�� OutputStream�� ��� �ڵ��̴�.
	
	//	// �Է� ��Ʈ�� ���
	//	InputStream is = socket.getInputStream();
	//
	//	// ��� ��Ʈ�� ���
	//	OutputStream os = socket.getOutputStream();
	
	// ���濡�� �����͸� ������ ���ؼ��� ���� �����͸� byte[] �迭�� �����ϰ�, �̰��� �Ű������� �ؼ� OutputStream�� write() �޼ҵ带 ȣ���ϸ� �ȴ�.
	// ������ ���ڿ��� UTF-8�� ���ڵ��� ����Ʈ �迭�� ����, write() �޼ҵ�� �����Ѵ�.
	
	//	String data = "���� ������";
	//	byte[] byteArr = data.getBytes("UTF-8");
	//	OutputStream outputStream = socket.getOutputStream();
	//	outputStream.write(byteArr);
	//	outputStream.flush();
	
	// ������ ���� �����͸� �ޱ� ���ؼ��� ���� �����͸� ������ bye[] �迭�� �ϳ� �����ϰ�, �̰��� �Ű��������ؼ� InputStream�� read() �޼ҵ带 ȣ���ϸ� �ȴ�.
	// read() �޼ҵ�� ���� �����͸� byte[] �迭�� �����ϰ� ���� ����Ʈ ���� �����Ѵ�. ������ �����͸� �а� UTF-8�� ���ڵ��� ���ڿ��� ��� �ڵ��̴�.
	
	//	byte[] byteArr = new byte[100];
	//	InputStream inputStream = socket.getInputStream();
	//	int readByteCount = inputStream.read(byteArr);
	//	String data = new String(byteArr, 0, readByteCount, "UTF-8");
	
	// ���� ������ ���� ��, 1 Ŭ���̾�Ʈ�� ���� "Hello Server"�� ������ ������. 2 ������ �� �����͸� �ް� 3 "Hello Client"�� Ŭ���̾�Ʈ�� ������ 4 Ŭ���̾�Ʈ�� �� �����͸� �޴´�.
	
	// ������ �������� �ۼ��� ServerExample�� ClientExample�� ������ �� ���� ServerExample���� �����ϰ� ClientExample�� �����غ���.
	
	// �����͸� �ޱ� ���� InputStream�� read() �޼ҵ带 ȣ���ϸ� ������ �����͸� ������ �������� ���ŷ(blocking)�Ǵµ�, read() �޼ҵ尡 ���ŷ �����ǰ� ���ϵǴ� ���� ���� �� �����̴�.
	
	//	���ŷ�� �����Ǵ� ���						���ϰ�
	//
	//	������ �����͸� ����						���� ����Ʈ ��
	//	
	//	������ ���������� Socket�� close()�� ȣ��	-1
	//		
	//	������ ������������ ����					IOException �߻�
	
	// ������ ���������� Socket�� close()�� ȣ���ϰ� ������ ������ ���� ������������ �������� ���, ��� ���� ó���� �ؼ� ���ʵ� Socket�� �ݱ� ���� close() �޼ҵ带 ȣ���ؾ� �Ѵ�.
	
	//	try {
	//		...
	//		// ������ ������������ �������� ��� IOException �߻�
	//		int readByteCount = inputStream.read(byteArr);	����������������������������������
	//																		��
	//		// ������ ���������� Socket�� close()�� ȣ������ ���						��
	//		if(readByteCount == -1) {										��
	//			throw new IOException();	// ������ IOException �߻� ��Ŵ	����������
	//		}																��
	//		...																��
	//	} catch (Exception e) {												��
	//		try { socket.close(); } catch(Exception e2) {}	�禡������������������������������
	//	}
	
			/*	Handling Thread Parallelism		������ ���� ó��		*/
	
	// ���� ������ ���� ServerSocket�� accept()�� �����ϰų�, ���� ���� ��û�� ���� Socket ������ �Ǵ� connect()�� ������ ��쿡�� �ش� �۾��� �Ϸ�Ǳ� ������ ���ŷ(blocking)�ȴ�.
	// ������ ����� �� ������ ���������ε� InputStream�� read() �޼ҵ�� ������ �����͸� ������ ������ ���ŷ�ǰ�, 
	// OutputStream�� write() �޼ҵ�� �����͸� �����ϰ� ������ ������ ���ŷ�ȴ�. ��������� ���ؼ� ServerSocket�� Socket�� ����(���ŷ) ������� �����ȴ�.
	// ���� ������ �����Ű�� main �����尡 ���� ����� �۾��� ����ϰ� �Ǹ� ������� �Ϸ�� ������ �ٸ� �۾��� �� �� ���� ���°� �ȴ�.
	// ���� ���ø����̼��� ���������� Ŭ���̾�Ʈ�� ���� ���� ����� �����ؾ� �ϴµ�, ����¿��� ���ŷ�Ǹ� �� �۾��� �� �� ���� �ȴ�.
	// ���� Ŭ���̾�Ʈ 1�� ������ϴ� ���ȿ��� Ŭ���̾�Ʈ2�� ������� �� �� ���� �ȴ�. �׷��� ������ accept(), connect(), read(), write()�� ������ �۾� �����带 �����ؼ� ���������� ó���ϴ� ���� ����.
	// ������ ������ ������ �۾� �����带 �����ϰ�, ���� Ŭ���̾�Ʈ�� ���������� ����ϴ� ����� �����ش�.
	
	//											��������������������������������������������������������������������������
	//											��	accept()					����	��
	//											��	  |		2	������������������������������������������
	//		����������������������������������	1 ���� ��û			��	  |	������ ����	��	�۾� ������ 1	   ����			
	//		��	Ŭ���̾�Ʈ1		�����������������������������������������������������������������������榢����������������������������������������
	//		��	(Socket)	��	3 ó�� ��û			��	  |			����		Socket	  ������
	//		�����������������������������������禡�����������������������������������������������������������������榢��		4 �۾� ó��	  ������
	//							5 ����			��	  |			������������������������������������������
	//											��	  |		2	������������������������������������������
	//		����������������������������������	1 ���� ��û			��	  |	������ ����	������������������������������������������
	//		��	Ŭ���̾�Ʈ2		�����������������������������������������������������������������������榢	�۾� ������ 1	   ����
	//		��	(Socket)	��	3 ó�� ��û			��	  |			������������������������������������������
	//		�����������������������������������禡�����������������������������������������������������������������榢��		Socket	  ������
	//							5 ����			��	  |			����		4 �۾� ó��	  ������
	//											��	  |			������������������������������������������
	//											��	  ��			������������������������������������������
	//											��������������������������������������������������������������������������
	
	// ���� ���� ������� ���� ó���� �� ���, ��õ ���� Ŭ���̾�Ʈ�� ���ÿ� ����Ǹ� �������� ��õ ���� �����尡 �����Ǳ� ������ ���� ������ �ް��� ���ϵǰ�, �ٿ�Ǵ� ������ �߻��� �� �ִ�.
	// Ŭ���̾�Ʈ�� �������� ���� ������ ������ ������ ������ �����Ϸ��� ������Ǯ�� ����ϴ� ���� �ٶ����ϴ�. ������ ������Ǯ�� �̿��� ���� ���� ����� �����ش�.
	
	//
	//
	//									����������������������������������������������������������������������������������������������������������������������������������������������������������
	//									��																		����	��
	//									��					����������������������������������������������������������������������������������������������������������	��
	//						1 ���� ��û		��	���� �۾� ����		��	������Ǯ(ExecutorService)							��	��
	//		������������������������������������������������������������������	��	����������	��	  �۾� ť					 ������������������������			��	��
	//		��	Ŭ���̾�Ʈ 1...n	��3 ó�� ��û��	��û �۾� ����	��	��	�������������������������������������������������榢	������ 1	��			��	��
	//		��		Socket		��������������������������	��	�����������������������榢 �� �� ��	��				 ������ �۾� ó��	��			��	��
	//		��������������������������������������������������	��	��û �۾� ����	��	��	������������������������������������������	 ��	  ��	   2 Socket ����	��	��
	//				��		3 ó�� ��û	������������������	��	����������	��	�� ������� ť����			��	 ������������������������			��	��
	//				��					��					��	�۾��� ������ �����Ŵ		��	 ������������������������			��	��
	//				��					��					��						���������榢	������ 2	��			��	��
	//				��					��					��							 ����û �۾� ó��	��			��	��
	//				��					��					��							 ��	  ��	   4 ��û ó��		��	��
	//				��5 ����				��					��							 ������������������������			��	��
	//				������������������������������������������������������������������������������������������������������������������������������������������������������		������ �� ����	��	��
	//									��					����������������������������������������������������������������������������������������������������������	��
	//									����������������������������������������������������������������������������������������������������������������������������������������������������������
	
	// 1 Ŭ���̾�Ʈ�� ���� ��û�� �ϸ� 2 ������ ������Ǯ���� ���� ������ �ϰ� Socket�� �����Ѵ�. 3 Ŭ���̾�Ʈ�� �۾� ó�� ��û�� �ϸ� 4 ������ ������Ǯ���� ��û�� ó���ϰ� 5 ������ Ŭ���̾�Ʈ�� ������.
	
	// ������Ǯ�� ������ ���� �����ؼ� ����ϱ� ������ ���۽��� Ŭ���̾�Ʈ�� ������ �۾� ť�� �۾����� ������ų �� ������ ���� ���Ծ��� ������ ���� ������ �ϸ��� ���ϵȴ�.
	// �ٸ� ����ϴ� �۾����� ���� ��� ���� Ŭ���̾�Ʈ���� ������ �ʰ� ���� �� �ִ�.
	
			//	Chatting Server Implementation		ä�� ���� ����
	
	// ä�� ���� ���� �ڵ带 ���鼭 ������Ǯ(ExecutorService), ServerSocket, Socket���� ��� ���Ǵ��� �����غ���.
	
			/*	Server Class Structure		���� Ŭ���� ����	*/
	
	// ���� ������ ���� Ŭ������ ������ �����ش�.
	
	// 24_ JavaFX ���� Ŭ������ ����� ���� Application�� ��ӹް� �ִ�.
	// 25_ ������Ǯ�� ExecutorService �ʵ尡 ����Ǿ� �ִ�.
	// 26_ Ŭ���̾�Ʈ�� ������ �����ϴ� ServerSocket �ʵ尡 ����Ǿ� �ִ�.
	// 27_ ����� Ŭ���̾�Ʈ�� �����ϴ� List<Client> Ÿ���� connections �ʵ尡 ����Ǿ� �ִ�. �׸��� �����忡 ������ Vector�� �ʱ�ȭ �ߴ�.
	// 29_ startServer()�� ���� ���� �� ȣ��Ǵ� �޼ҵ��̴�.
	// 72_ stopServer()�� ���� ���� �� ȣ��Ǵ� �޼ҵ��̴�.
	// 96_ Client Ŭ������ ����� Ŭ���̾�Ʈ�� ǥ���ϴµ�, ������ ��� �ڵ带 �����Ѵ�.
	// 173_ UI ���� �ڵ�� ���̾ƿ��� �����ϰ� ServerExample�� �����Ų��.
	
	// ���� ȭ�鿡�� [start] ��ư�� Ŭ������ startServer() �޼ҵ尡 ȣ��ǰ�, [start] ��ư�� [stop] ��ư���� ����ȴ�.
	// [stop] ��ư�� Ŭ���ϸ� stopServer() �޼ҵ尡 ȣ��ǰ�, �ٽ� [start] ��ư���� ����ȴ�.
	
			/*	startServer() Method	*/
	
	// [start] ��ư�� Ŭ���ϸ� startServer() �޼ҵ尡 �����ϴµ�, startServer() �޼ҵ忡�� ExecutorService ����, ServerSocket ���� �� ��Ʈ ���ε�, ���� ���� �ڵ尡 �ִ�.
	// ���� ExecutorService ���� �ڵ带 ����.
	
	//	01	void startServer() {
	//	02		executorService = Executors.newFixedThreadPool(
	//	03			Runtime.getRuntime().availableProcessors()
	//	04		);
	
	// 02_ ExecutorService ��ü�� ��� ���� Executors.newFixedThreadPool() �޼ҵ带 ȣ���Ѵ�.
	// 03_ CPU �ھ��� ����ŭ �����带 ���鵵�� �Ѵ�.
	
	// �̹����� ServerSocket ���� �� ��Ʈ ���ε� �ڵ带 ����.
	
	//	01	try {
	//	02		serverSocket = new ServerSocket();
	//	03		serverSocket.bind(new InetSocketAddress("localhost", 5001));
	//	04	} catch(Exception e) {
	//	05		if(!serverSocket.isClosed()) { stopServer(); }
	//	06		return;
	//	07	}
	
	// 02_ ServerSocket ��ü�� �����Ѵ�.
	// 03_ ServerSocket�� ���� ��ǻ�� 5001 ��Ʈ�� ���ε��Ѵ�.
	// 05_ ���ܰ� �߻��� ��� ServerSocket�� �������� ������ stopServer() �޼ҵ带 ȣ���Ѵ�.
	// 06_ startServer() �޼ҵ带 �����Ѵ�.
	
	// �̹����� ������ �����ϴ� �ڵ带 ����.
	
	//	01	Runnable runnable = new Runnable() {		// ���� �۾� ����
	//	02		@Override
	//	03		public void run() {
	//	04			Platform.runLater( () -> {
	//	05				displayText("[���� ����]");
	//	06				btnStartStop.setText("stop");
	//	07			});
	//	08			while(true) {
	//	09				try {
	//	10					Socket socket = serverSocket.accept();		// ���� ����
	//	11					String message = "[���� ����: " + socket.getRemoteSocketAddress() + 
	//	12									": " + Thread.currentThread().getName() + "]";
	//	13					Platform.runLater( () -> displayText(message) );
	//	14
	//	15					Client client = new Client(socket);	
	//	16					connections.add(client);			// Client ��ü ����
	//	17					Platform.runLater( () -> displayText("���� ����: " + connections.size() + "]"));
	//	18				} catch(Exception e) {
	//	19					if(!serverSocket.isClosed()) { stopServer(); }
	//	20					break;
	//	21				}
	//	22			}
	//	23		}
	//	24	};
	//	25	executorService.submit(runnable);		// ������Ǯ���� ó��
	//	26	}	// startServer() �޼ҵ� ��
	
	// 01_ ���� ���� �۾��� Runnable�� �����Ѵ�.
	// 03_ run() �޼ҵ带 �������Ѵ�.
	// 04_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ���Ǿ���.
	// 05_ "[���� ����]"�� ����ϵ��� displayText()�� ȣ���ߴ�.
	// 06_ [start] ��ư�� ���ڸ� [stop]���� �����Ѵ�.
	// 08_ Ŭ���̾�Ʈ�� ���� ������ ������ �ݺ��ϵ��� �Ѵ�.
	// 10_ Ŭ���̾�Ʈ�� ���� ��û�� ��ٸ���, ���� ������ �ϴ� accept() �޼ҵ带 ȣ���Ѵ�.
	// 11_ ���� ������ �Ǹ� Ŭ���̾�Ʈ IP �ּҿ� ������ �̸��� ���Ե� ���� ���� �޼��� ���ڿ��� �����.
	// 13_ �޼����� ����ϵ��� displayText()�� ȣ���Ѵ�
	// 15_ Client ��ü�� �����Ѵ�.
	// 16_ Client ��ü�� connections �÷��ǿ� �߰��Ѵ�.
	// 17_ connections �÷��ǿ� ����� Client ��ü ���� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 19_ ���ܰ� �߻����� ���, ServerSocket�� �������� ������ stopServer()�� ȣ���Ѵ�.
	// 20_ break�� ����ؼ� while���� �����.
	// 25_ ������Ǯ�� �۾� �����忡�� ���� ���� �۾��� ó���ϱ� ���� submit()�� ȣ���Ѵ�.
	
			/*	stopServer() Method		*/
	
	// [stop] ��ư�� Ŭ���ϸ� stopServer() �޼ҵ尡 ����Ǵµ�, stopServer() �޼ҵ忡�� ����� ��� Socket �ݱ�, ServerSocket �ݱ�, ExecutorService ���� �ڵ尡 �ִ�.
	
	//	01	void stopServer() { 
	// 	02		try {	// ��� Socket �ݱ�
	// 	03			Iterator<Client> iterator = connections.iterator();
	//	04			while(iterator.hasNext()) {
	//	05				Client client = iterator.next();
	//	06				client.socket.close();
	//	07				iterator.remove();
	//	08			}	//
	//	09			if(serverSocket != null && !serverSocket.isClosed()) {	// ServerSocket �ݱ�
	//	10				serverSocket.close();
	//	11			}	//
	//	12			if(executorService != null && !executorService.isShutdown()) {	// ExecutorService ����
	//	13				executorService.shutdown();
	//	14			}	//
	//	15			Platform.runLater( () -> {
	//	16				displayText("[���� ����]");
	//	17				btnStartStop.setText("start");
	//	18			});
	//	19		} catch(Exception e) { }
	//	20	}
	
	// 03_ connections �÷������κ��� �ݺ��ڸ� ����.
	// 04_ while������ �ݺ��ڸ� �ݺ��Ѵ�.
	// 05_ �ݺ��ڷκ��� Client�� �ϳ��� ��´�.
	// 06_ Client�� ������ �ִ� Socket�� �ݴ´�.
	// 07_ connections �÷��ǿ��� Client�� �����Ѵ�.
	// 09_ ServerSocket�� null�� �ƴϰ�, �������� ������
	// 10_ ServerSocket�� �ݴ´�.
	// 12_ ExecutorService�� null�� �ƴϰ�, ���� ���°� �ƴϸ�
	// 13_ ExecutorService�� �����Ѵ�.
	// 15_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ���Ǿ���.
	// 16_ "[���� ����]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 17_ [stop] ��ư�� ���ڸ� [start]�� �����Ѵ�.
		
			/*	Client Class	*/
	
	// ������ �ټ��� Ŭ���̾�Ʈ�� �����ϱ� ������ ������ Ŭ���̾�Ʈ�� ������� �Ѵ�. Ŭ���̾�Ʈ���� ������ �����͸� ������ �ʿ䵵 �ֱ� ������ Client Ŭ������ �����ϰ�,
	// ���� ���� �� ���� Client �ν��Ͻ��� �����ؼ� �����ϴ� ���� ����. ������ Client Ŭ������ ������ �����ش�.
	
	// 	01	Class Client {
	// 	02		Socket socket;
	// 	03	
	// 	04		Client(Socket socket) {
	// 	05			this.socket = socket;
	// 	06			receive();
	// 	07		}
	// 	08		
	// 	09		void receive() { // ������ �ޱ� �ڵ� }
	// 	10		void send(String data) { // ������ ���� �ڵ� }
	// 	11	}
	
	// 01_ Client�� ServerExample�� ���� Ŭ������ �����Ѵ�.
	// 02_ Socket �ʵ带 �����Ѵ�.
	// 04_ Client �����ڸ� �����Ѵ�.
	// 05_ �Ű������� ���� Socket�� �ʵ尪���� �����Ѵ�.
	// 06_ receive() �޼ҵ带 ȣ���Ѵ�.
	// 09_ �����͸� �ޱ� ���� receive() �޼ҵ带 �����Ѵ�.
	// 10_ �����͸� ������ ���� send() �޼ҵ带 �����Ѵ�.
	
	// Ŭ���̾�Ʈ�� �����͸� �޴� receive() �޼ҵ� �ڵ带 ����.
	
	//	01	void receive() {
	//	02		Runnable runnable = new Runnable() {	// �ޱ� �۾� ����
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					while(true) {
	//	07						byte[] byteArr = new byte[100];
	//	08						InputStream inputStream = socket.getInputStream();
	//	09	
	//	10						// Ŭ���̾�Ʈ�� ������ ���Ḧ ���� ��� IOException �߻�
	//	11						int readByteCount = inputStream.read(byteArr);
	//	12						
	//	13						// Ŭ���̾�Ʈ�� ���������� Socket�� close()�� ȣ������ ���
	//	14						if(readByteCount == -1) { throw new IOException(); }
	//	15	
	//	16						String message = "[��û ó��: " + socket.getRemoteSocketAddress() + 
	//	17										": " + Thread.currentThread().getName() + "]";
	//	18						Platform.runLater( () -> displayText(message) );
	//	19	
	//	20						String data = new String(byteArr, 0, readByteCount, "UTF-8");	// ���ڿ��� ��ȯ
	//	21	
	//	22						for(Client client : connections) {	// ��� Ŭ���̾�Ʈ���� ����
	//	23							client.send(data);
	//	24						}	//
	//	25					}
	//	26				} catch(Exception e) {
	//	27					try {
	//	28						connections.remove(Client.this);
	//	29						String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " + 
	//	30										socket.getRemoteSocketAddress() +
	//	31										": " + Thread.currentThread().getName() + "]";
	//	32						Platform.runLater( () -> displayText(message) );
	//	33						socket.close();
	//	34					} catch(IOException e2) {} 
	//	35				}
	//	36			}
	//	37		};
	//	38		executorService.submit(runnable);	// ������Ǯ���� ó��
	//	39	}
	
	// 02_ Ŭ���̾�Ʈ�κ��� �����͸� �޴� �۾��� Runnable�� �����Ѵ�.
	// 04_ run() �޼ҵ带 �������Ѵ�.
	// 06_ �۾��� ���� �ݺ��Ѵ�.
	// 07_ �޴� �����͸� ������ byte[] �迭�� byteArr�� �����Ѵ�.
	// 08_ Socket���κ��� InputStream�� ��´�
	// 11_ InputStream�� read() �޼ҵ带 ȣ���Ѵ�. Ŭ���̾�Ʈ�� �����͸� ������ ������ Ŭ��ŷ�ǰ�, �����͸� ������ byteArr�� ������ �� ���� ����Ʈ ������ readByteCount�� �����Ѵ�.
	// 14_ Ŭ���̾�Ʈ�� ���������� Socket�� close()�� ȣ������ ���, 11������ read() �޼ҵ�� -1�� �����Ѵ�. �� ��� IOException�� ������ �߻���Ų��.
	// 16_ ���������� �����͸� �޾��� ���, "[��û ó��: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����.
	// 18_ ���ڿ��� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 20_ String(byteArr, 0, readByteCount, "UTF-8")�� �̿��ؼ� UTF-8�� ���ڵ��� ���ڿ��� ��´�.
	// 22~24_ ���ڿ��� ��� Ŭ���̾�Ʈ���� ������ ���� connections�� ����� Client�� �ϳ��� ��� send() �޼ҵ带 ȣ���Ѵ�.
	// 28_ ���ܰ� �߻��ϸ� connections �÷��ǿ��� Client ��ü�� �����Ѵ�. ���ܴ� 11���ΰ� 14���ο��� �߻��ϴµ�, ��� Ŭ���̾�Ʈ�� ����� ���� ���� ���̴�.
	// 29_ "[Ŭ���̾�Ʈ ��� �ȵ�: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����Ѵ�.
	// 32_ ���ڿ��� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 33_ Socket�� �ݴ´�
	// 38_ ������Ǯ���� �۾��� ó���ϱ� ���� submit()�� ȣ���Ѵ�.
	
	// Ŭ���̾�Ʈ�� �޼����� ������ send(String data) �޼ҵ� �ڵ带 ����.
	
	//	01	void send(String data) {
	//	02		Runnable runnable = new Runnable() {	// ������ �۾� ����
	//	03			@Override
	//	04			public void run() {
	//	05				try {	// Ŭ���̾�Ʈ�� ������ ������
	//	06					byte[] byteArr = data.getBytes("UTF-8");
	//	07					OutputStream outputStream = socket.getOutputStream();
	//	08					outputStream.write(byteArr);
	//	09					outputStream.flush();	//
	//	10				} catch(Exception e) {
	//	11					try {
	//	12						String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " +
	//	13										socket.getRemoteSocketAddress() + ": " +
	//	14										Thread.currentThread().getName() + "]";
	//	15						Platform.runLater( () -> displayText(message) );
	//	16						connections.remove(Client.this);
	//	17						socket.close();
	//	18					} catch(IOException e2) {}
	//	19				}
	//	20			}
	//	21		};
	//	22		executorService.submit(runnable);	// ������Ǯ���� ó��
	//	23	}
	
	// 02_ �����͸� Ŭ���̾�Ʈ�� ������ �۾��� Runnable�� �����Ѵ�.
	// 04_ run()�� �������Ѵ�.
	// 06_ ���� ���ڿ��κ��� UTF-8�� ���ڵ��� ����Ʈ �迭�� ��´�.
	// 07_ Socket���� ��� ��Ʈ���� ��´�.
	// 08_ ����Ʈ �迭�� �Ű������� �ؼ� write() �޼ҵ带 ȣ���Ѵ�.
	// 09_ ��� ��Ʈ���� ���� ���۸� ������ ��쵵�� flush()�� ȣ���Ѵ�.
	// 12_ 8���ο��� ���ܰ� �߻��ϸ� "[Ŭ���̾�Ʈ ��� �ȵ�: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����Ѵ�.
	// 15_ ���ڿ��� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 16_ connections �÷��ǿ��� ���ܰ� �߻��� Client�� �����Ѵ�.
	// 17_ Socket�� �ݴ´�.
	// 22_ ������Ǯ���� �۾��� ó���ϱ� ���� submit()�� ȣ���Ѵ�.
	
			/*	UI Creation Code	UI ���� �ڵ�	*/
	
	// ������ JavaFX�� �̿��� UI ���� �ڵ带 �����ش�. ���α׷��� ���̾ƿ��� �̿��ؼ� ������Ʈ�� ��ġ�ߴ�.
	
	//	01	TextArea txtDisplay;
	//	02	Button btnStartStop;
	//	03	
	//	04	@Override
	//	05	public void start(Stage primaryStage) throws Exception {
	//	06		BorderPane root = new BorderPane();
	//	07		root.setPrefSize(500, 300);
	//	08	
	//	09		txtDisplay = new TextArea();
	//	10		txtDisplay.setEditable(false);
	//	11		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
	//	12		root.setCenter(txtDisplay);
	//	13	
	//	14		btnStartStop = new Button("start");
	//	15		btnStartStop.setPrefHeight(30);
	//	16		btnStartStop.setMaxWidth(Double.MAX_VALUE);
	//	17		btnStartStop.setOnAction( e -> {		// start�� stop ��ư�� Ŭ������ �� �̺�Ʈ ó�� �ڵ�
	//	18			if(btnStartStop.getText().equals("start")) {
	//	19				startServer();
	//	20			} else if(btnStartStop.getText().equals("stop")) {
	//	21				stopServer();
	//	22			}
	//	23		});		//
	//	24		root.setBottom(btnStartStop);
	//	25	
	//	26		Scene scene = new Scene(root);
	//	27		scene.getStylesheets().add(getClass().getResource("app.css").toString());
	//	28		primaryStage.setScene(scene);
	//	29		primaryStage.setTitle("Server");
	//	30		primaryStage.setOnCloseRequest( event -> stopServer() );	// ������ ���� ��� �ݱ� ��ư�� Ŭ������ �� �̺�Ʈ ó�� �ڵ�
	//	31		primaryStage.show();
	//	32	}
	//	33	
	//	34	void displayText(String text) {
	//	35		txtDisplay.appendText(text + "\n");
	//	36	}
	//	37	
	//	38	public static void main(String[] args) {
	//	39		launch(args);
	//	40	}
	
	// 27������ �ܺ� CSS ����(app.css)�� Scene�� �����ϰ� �ִ�. �� ������ TextArea�� ���� �����ε�, TextArea�� ���� ���� �����̳ʷ� �ѷ��ο� �ִ� ������ ������ ������ �־�
	// �ܼ��� TextArea�� setStyle()�� ������ �ٲ� �� ����. �׷��� ������ ���� �ܺ� CSS Ŭ���� �����ڸ� �̿��ؼ� �����̳��� ������ �����ߴ�.
	
	//		��������������������������������������������������������������������������������������������������
	//		��	class = "text-area"							��
	//		��	����������������������������������������������������������������������������������	��
	//		��	��	class = "scroll-pane"				��	��
	//		��	��	������������������������������������������������������������������	��	��
	//		��	��	��	class = "viewport"			��	��	��
	//		��	��	��	��������������������������������������������������	��	��	��
	//		��	��	��	��	class = "content"	��	��	��	��
	//		��	��	��	��						��	��	��	��
	//		��	��	��	��������������������������������������������������	��	��	��
	//		��	��	������������������������������������������������������������������	��	��
	//		��	����������������������������������������������������������������������������������	��
	//		��������������������������������������������������������������������������������������������������
	
	// text-area�� gold������ �����ϰ�, ������ �����̳ʵ��� ��� ����(transparent)���� ���������ν� TextArea ��ü ������ gold������ ���̰� �ߴ�.
	
			//	Chatting Client Implementation		ä�� Ŭ���̾�Ʈ ����
	
	// ä�� Ŭ���̾�Ʈ ���� �ڵ带 ���鼭 Socket�� ��� ���Ǵ��� �����غ���.
	
			/*	Client Class Structure		Ŭ���̾�Ʈ Ŭ���� ����		*/
	
	// ���� ������ Ŭ���̾�Ʈ Ŭ������ ������ �����ش�.
	
	// 01_ JavaFX ���� Ŭ������ ����� ���� Application�� ����Ѵ�.
	// 02_ Ŭ���̾�Ʈ ����� ���� Socket �ʵ带 �����Ѵ�.
	// 04_ startClient() �޼ҵ�� [start] ��ư�� Ŭ���ϸ� ȣ��ȴ�.
	// 05_ stopClient() �޼ҵ�� [stop] ��ư�� Ŭ���ϸ� ȣ��ȴ�.
	// 06_ receive() �޼ҵ�� �������� ���� �����͸� �޴´�.
	// 07_ send() �޼ҵ�� [send] ��ư�� Ŭ���ϸ� ȣ��Ǵµ�, ������ �����͸� ������.
	// 10_ UI �����ڵ�� ���̾ƿ��� �����ϰ� ClientExample�� �����Ų��.
	
	// ���� ȭ�鿡�� [start] ��ư�� Ŭ���ϸ� startClient() �޼ҵ尡 ȣ��ǰ�, [start] ��ư�� [stop] ��ư���� ����ȴ�.
	// [stop] ��ư�� Ŭ���ϸ� stopClient() �޼ҵ尡 ȣ��ǰ�, �ٽ� [start] ��ư���� ����ȴ�.
	
			/*	startClient() Method	*/
	
	// [start] ��ư�� Ŭ���ϸ� startClient() �޼ҵ尡 �����ϴµ�, startClient() �޼ҵ忡�� Socket ���� �� ���� ��û �ڵ尡 �ִ�.
	
	//	01	void startClient() {
	//	02		Thread thread = new Thread() {		// ������ ����
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					socket = new Socket();
	//	07					socket.connect(new InetSocketAddress("localhost", 5001));	// ���� ���� �� ���� ��û
	//	08					Platform.runLater( () -> {
	//	09						displayText("[���� �Ϸ�: " + socket.getRemoteSocketAddress() + "]");
	//	10						btnConn.setText("stop");
	//	11						btnSend.setDisable(false);
	//	12					});
	//	13				} catch(Exception e) {
	//	14					Platform.runLater( () -> displayText("[���� ��� �ȵ�]"));
	//	15					if(!socket.isClosed()) { stopClient(); }
	//	16					return;
	//	17				}
	//	18				receive();	// �������� ���� ������ �ޱ�
	//	19			}
	//	20		};
	//	21		thread.start();	// ������ ����
	//	22	}
	
	// 02_ �۾� �����带 �����Ѵ�. �۾� �����尡 �ʿ��� ������ 7������ connect()�� 18������ receive()���� ���ŷ�� �Ͼ�� �����̴�. JavaFX Application Thread�� �� �޼ҵ���� ȣ������ �ʴ� ���� ����.
	// 04_ run() �޼ҵ带 �������Ѵ�.
	// 06_ ��ſ� Socket�� �����Ѵ�.
	// 07_ local 5001 ��Ʈ�� ���� ��û�� �Ѵ�.
	// 08_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ���Ǿ���.
	// 09_ "[���� �Ϸ�]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 10_ [start] ��ư�� ���ڸ� [stop]���� �����Ѵ�.
	// 11_ [send] ��ư�� Ȱ��ȭ�Ѵ�.
	// 14_ ���ܰ� �߻��ϸ� "[���� ��� �ȵ�"]�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 15_ Socket�� �������� ������ stopClient() �޼ҵ带 ȣ���Ѵ�.
	// 16_ return�� �����ؼ� �۾��� �����Ѵ�.
	// 18_ ���ܰ� �߻����� ������ receive() �޼ҵ带 ȣ���Ѵ�.
	// 21_ �۾� �����带 �����Ѵ�.
	
			/*	stopClient() Method	*/
	
	// [stop] ��ư�� Ŭ���ϰų� ���� ����� �� �� ��� stopClient() �޼ҵ尡 ����Ǵµ�, stopClient() �޼ҵ忡�� Socket�� �ݴ� close() �޼ҵ� ȣ�� �ڵ尡 �ִ�.
	
	//	01	void stopClient() {
	//	02		try {
	//	03			Platform.runLater( () -> {
	//	04				displayText("[���� ����]");
	//	05				btnConn.setText("start");
	//	06				btnSend.setDisable(true);
	//	07			});
	//	08			if(socket != null && !socket.isClosed()) {
	//	09				socket.close();
	//	10			}
	//	11		} catch(IOException e) {}
	//	12	}
	
	// 03_ UI�� �����ϱ� ���� Platform.runLater()�� ���Ǿ���.
	// 04_ "[���� ����]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 05_ [stop] ��ư�� ���ڸ� [start]�� �����Ѵ�.
	// 06_ [send] ��ư�� ��Ȱ��ȭ�Ѵ�.
	// 08_ socket �ʵ尡 null�� �ƴϰ�, ���� �������� ���� ���
	// 09_ Socket�� �ݴ´�.
	
			/*	receive() Method	*/

	// receive() �޼ҵ�� �������� ���� �����͸� �޴� ������ �Ѵ�. �� �޼ҵ�� startClient()���� ������ �۾� ������󿡼� ȣ��ȴ�.
	
	//	01	void receive() {
	//	02		while(true) {
	//	03			try {
	//	04				byte[] byteArr = new byte[100];
	//	05				InputStream inputStream = socket.getInputStream();
	//	06	
	//	07				// ������ ������������ �������� ��� IOException �߻�
	//	08				int readByteCount = inputStream.read(byteArr);		// ������ �ޱ�
	//	09	
	//	10				// ������ ���������� Socket�� close()�� ȣ������ ���
	//	11				if(readByteCount == -1) { throw new IOException(); }
	//	12	
	//	13				String data = new String(byteArr, 0, readByteCount, "UTF-8");	// ���ڿ��� ��ȯ
	//	14	
	//	15				Platform.runLater( () -> displayText("[�ޱ� �Ϸ�]" + data)); 
	//	16			} catch(Exception e) {
	//	17				Platform.runLater( () -> displayText("[���� ��� �ȵ�]"));
	//	18				stopClient();
	//	19				break;
	//	20			}
	//	21		}
	//	22	}
	
	// 02_ �ݺ������� �б� ���� ���� ������ �ۼ��Ѵ�.
	// 04_ ���� �����͸� ������ ���̰� 100�� ����Ʈ �迭�� �����Ѵ�.
	// 05_ Socket���κ��� InputStream�� ��´�.
	// 08_ InputStream�� read() �޼ҵ带 ȣ���Ѵ�. ������ �����͸� ������ ������ ���ŷ�Ǹ�, �����͸� ������ byteArr�� �����ϰ� ���� ����Ʈ ������ readByteCount�� �����Ѵ�.
	// 11_ ������ ���������� Socket�� close()�� ȣ������ ���, 8������ read() �޼ҵ�� -1�� �����Ѵ�. �� ��� IOException�� ������ �߻���Ų��.
	// 13_ ���������� �����͸� �޾��� ���, String(byteArr, 0, readByteCount, "UTF-8")�� �̿��ؼ� UTF-8�� ���ڵ��� ���ڿ��� ��´�.
	// 15_ "[�ޱ� �Ϸ�] + ���� ���ڿ�"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 17_ ������ ������������ ������ ���� �Ǹ� 8���ο��� IOExceptiond�� �߻��ϰ�, ���� �� Socket�� close()�� ȣ���ؼ� ���������� ������ ���� �Ǹ� 11���ο��� IOException�� �߻��Ѵ�.
	//		���ܰ� �߻��ϸ� "[���� ��� �ȵ�]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 18_ stopClient()�� ȣ���Ѵ�.
	// 19_ break�� �����ؼ� ���ѷ����� �������´�.
	
			/*	send(String data) Method	*/
	
	// send(String data) �޼ҵ�� ����ڰ� �޼����� �Է��ϰ� [send] ��ư�� Ŭ���ϸ� �޼����� �Ű������� ȣ���Ѵ�.
	// send() �޼ҵ�� ������ �޼����� ������ ������ �Ѵ�.
	
	//	01	void send(String data) {
	//	02		Thread thread = new Thread() {	// ������ ����
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					byte[] byteArr = data.getBytes("UTF-8");
	//	07					OutputStream outputStream = socket.getOutputStream();	// ������ ������ ������
	//	08					outputStream.write(byteArr);
	//	09					outputStream.flush();
	//	10					Platform.runLater( () -> displayText("[������ �Ϸ�]"));
	//	11				} catch(Exception e) {
	//	12					Platform.runLater( () -> displayText("[���� ��� �ȵ�]"));
	//	13					stopClient();
	//	14				}
	//	15			}
	//	16		};
	//	17		thread.start();	// ������ ����
	//	18	}
	
	// 02_ �����͸� ������ ������ ���ο� �۾� �����带 �����Ѵ�.
	// 04_ run()�� �������Ѵ�.
	// 06_ ���� ���ڿ��κ��� UTF-8�� ���ڵ��� ����Ʈ �迭�� ��´�.
	// 07_ Socket���� ��� ��Ʈ���� ��´�.
	// 08_ ����Ʈ �迭�� �Ű������� �ؼ� write() �޼ҵ带 ȣ���Ѵ�.
	// 09_ ��� ��Ʈ���� ���� ���۸� ������ ��쵵�� flush()�� ȣ���Ѵ�.
	// 10_ "[������ �Ϸ�]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 12_ 8���ο��� ���ܰ� �߻��ϸ� "[���� ��� �ȵ�]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 13_ stopClient()�� ȣ���Ѵ�.
	// 17_ �۾� �����带 �����Ѵ�.
	
			/*	UI Creation Code	UI ���� �ڵ�	*/
	
	// ������ JavaFX�� �̿��� UI ���� �ڵ带 �����ش�. ���α׷��� ���̾ƿ��� �̿��ؼ� ��Ʈ���� ��ġ�ߴ�.
	
	//	01	TextArea txtDisplay;
	//	02	TextField txtInput;
	//	03	Button btnConn, btnSend;
	//	04	
	//	05	@Override
	//	06	public void start(Stage primaryStage) throws Exception {
	//	07		BorderPane root = new BorderPane();
	//	08		root.setPrefSize(500, 300);
	//	09	
	//	10		txtDisplay = new TextArea();
	//	11		txtDisplay.setEditable(false);
	//	12		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
	//	13		root.setCenter(txtDisplay);
	//	14	
	//	15		BorderPane bottom = new BorderPane();
	//	16			txtInput = new TextField();
	//	17			txtInput.setPrefSize(60, 30);
	//	18			BorderPane.setMargin(txtInput, new Insets(0, 1, 1, 1));
	//	19
	//	20			btnConn = new Button("start");
	//	21			btnConn.setPrefSize(60, 30);
	//	22			btnConn.setOnAction( e -> {
	//	23				if(btnConn.getText().equals("start")) {
	//	24					startClient();
	//	25				} else if(btnConn.getText().equals("stop")) {
	//	26					stopClient();
	//	27				}
	//	28			});			
	//	29	
	//	30			btnSend = new Button("send");
	//	31			btnSend.setPrefSize(60, 30);
	//	32			btnSend.setDisable(true);
	//	33			btnSend.setOnAction( e -> send(txtInput.getText()));
	//	34	
	//	35			bottom.setCenter(txtInput);
	//	36			bottom.setLeft(btnConn);
	//	37			bottom.setRight(btnSend);
	//	38		root.setBottom(bottom);
	//	39	
	//	40		Scene scene = new Scene(root);
	//	41		scene.getStylesheets().add(getClass().getResource("app.css").toString());
	//	42		primaryStage.setScene(scene);
	//	43		primaryStage.setTitle("Client");
	//	44		primaryStage.setOnCloseRequest( event -> stopClient() );
	//	45		primaryStage.show();
	//	46	}
	//	47	
	//	48	void displayText(String text) {
	//	49		txtDisplay.appendText(text + "\n");
	//	50	}
	//	51	
	//	52	public static void main(String[] args) {
	//	53		launch(args);
	//	54	}
	
	// ������ ä�� ������ Ŭ���̾�Ʈ�� �����ϴ� ����� �����ش�. ������ ServerExample�� �� �� �����ϰ� Ŭ���̾�Ʈ�� ClientExample�� �� �� �����Ѵ�.
	
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��Server			  ��	�� x	��		��Client			  ��	�� x	��		��Client			  ��	�� x	��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��						��		��						��		��						��
	//		��						��		��						��		��						��
	//		��						��		��						��		��						��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��		  start			��		�� start��		  �� send��		�� start��		  �� send��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	
	// ServerExample�� [start] ��ư�� Ŭ���ϰ�, �̾ �� ���� ClientExample�� [start] ��ư�� ���� Ŭ���Ѵ�. 
	// �� ����� ServerExample���� ���� ������ 2�� �������� Ȯ���Ѵ�.
	
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��Server			  ��	�� x	��		��Client			  ��	�� x	��		��Client			  ��	�� x	��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��[��������]				��		��[���� �Ϸ�: loaclhost...]	��		��[���� �Ϸ�: loaclhost...]	��
	//		��[���� ����: .. thread - 3]	��		��						��		��						��
	//		��[���� ����: 1]				��		��						��		��						��
	//		��[���� ����: .. thread - 2]	��		��						��		��						��
	//		��[���� ����: 2]				��		��						��		��						��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��		  stop 			��		�� start��		  �� send��		�� start��		  �� send��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	
	// �� ���� ClientExample �Է¶��� �޼����� �Է��ϰ� [send] ��ư�� Ŭ���Ѵ�.
	// �� ����� ServerExample������ ���� ó���� ��µǰ� ������ ClientExample������ �޼����� ��µǴ� ���� Ȯ���Ѵ�.
	
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��Server			  ��	�� x	��		��Client			  ��	�� x	��		��Client			  ��	�� x	��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��:						��		��[���� �Ϸ�: loaclhost...]	��		��[���� �Ϸ�: loaclhost...]	��
	//		��[��û ó��: .. thread - 2]	��		��[������ �Ϸ�]				��		��[�ޱ� �Ϸ�] ù ��°			��				
	//		��[��û ó��: .. thread - 1]	��		��[�ޱ� �Ϸ�] ù ��°			��		��[������ �Ϸ�]				��
	//		��						��		��[�ޱ� �Ϸ�] �� ��°			��		��[�ޱ� �Ϸ�] �� ��°			��
	//		��						��		��						��		��						��
	//		��						��		��						��		��						��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��		  stop			��		�� start��ù ��°	  �� send��		�� start���� ��°	  �� send��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	
	// ù ��° ClientExample�� [stop] ��ư�� Ŭ���Ѵ�. �� ����� ClientExample���� ���� ������ ��µǰ�, ServerExample���� Ŭ���̾�Ʈ ��� �ȵ��� ��µǴ��� Ȯ�� �Ѵ�.
	
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��Server			  ��	�� x	��		��Client			  ��	�� x	��		��Client			  ��	�� x	��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��:						��		��:						��		��[���� �Ϸ�: loaclhost...]	��
	//		��[Ŭ���̾�Ʈ ��� �ȵ�: ..]		��		��[���� ��� �ȵ�]				��		��[�ޱ� �Ϸ�] ù ��°			��				
	//		��						��		��[���� ����]				��		��[������ �Ϸ�]				��
	//		��						��		��						��		��[�ޱ� �Ϸ�] �� ��°			��
	//		��						��		��						��		��						��
	//		��						��		��						��		��						��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��		  stop			��		�� start��		  �� send��		�� start��		  �� send��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	
	// ServerExample�� [stop] ��ư�� Ŭ���Ѵ�. �� ����� ServerExample���� ���� ������ ��µǰ�, ClientExample���� ���� ��� �ȵ��� ��µǴ��� Ȯ���Ѵ�.
	
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��Server			  ��	�� x	��		��Client			  ��	�� x	��		��Client			  ��	�� x	��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��:						��		��:						��		��[���� �Ϸ�: loaclhost...]	��
	//		��[Ŭ���̾�Ʈ ��� �ȵ�: ..]		��		��[���� ��� �ȵ�]				��		��[�ޱ� �Ϸ�] ù ��°			��				
	//		��[Ŭ���̾�Ʈ ��� �ȵ�: ..]		��		��[���� ����]				��		��[������ �Ϸ�]				��
	//		��[���� ����]				��		��						��		��[�ޱ� �Ϸ�] �� ��°			��
	//		��						��		��						��		��[���� ��� �ȵ�]				��
	//		��						��		��						��		��[���� ����]				��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
	//		��		  start			��		�� start��		  �� send��		�� start��		  �� send��
	//		��������������������������������������������������		��������������������������������������������������		��������������������������������������������������
}
