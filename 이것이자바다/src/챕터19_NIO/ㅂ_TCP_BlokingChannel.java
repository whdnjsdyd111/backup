package é��19_NIO;

public class ��_TCP_BlokingChannel {
	// NIO�� �̿��ؼ� TCP ����/Ŭ���̾�Ʈ ���ø����̼��� �����Ϸ��� ���ŷ, �ͺ��ŷ, �񵿱� ���� ��� �߿��� �ϳ��� �����ؾ� �Ѵ�. �� ������ ���� ������ ������ �޶����� �����̴�.
	// �ټ� ���������⵵ ������ ��Ʈ��ũ ������� ���ɰ� ȿ���� �鿡�� ������ ���� �о����� ������ ������ ��Ʈ��ũ ���ø����̼��� ������ �� �ְ� �Ǿ���.
	// �̹� �������� ���ŷ ��ĸ� �����ϰ�, �ͺ��ŷ�� �񵿱� ����� �ٸ� ������ �����ϵ��� �ϰڴ�.
	
			//	ServerSocket Channel And Purpose Of Channel		�������� ä�ΰ� ���� ä���� �뵵
	
	// NIO���� TCP ��Ʈ��ũ ����� ���� ����ϴ� ä���� java.nio.channels.ServerSocketChannel�� java.nio.channels.SocketChannel�̴�.
	// �� �� ä���� IO�� ServerSocket�� Socket�� �����Ǵ� Ŭ������, IO�� ���۸� ������� �ʰ� ���ŷ ����� ��ĸ� �����Ѵٸ� ServerSocketChannel, SocketChannel�� ���۸� �̿��ϰ� ���ŷ�� 
	// �ͺ��ŷ ����� ��� �����Ѵ�. ��� ����� IO�� ū �������� ���µ�, ������ ���� ServerSocketChannel�� Ŭ���̾�Ʈ SocketChannel�� ���� ��û�� �����ϰ� ��ſ� SocketChannel�� �����Ѵ�.
	
	//
	//								1 ���� ��û(connect)	������������������������������������������
	//					���������������������������������������������������������������榢	ServerSocket	��
	//					��								������������������������������������������		
	//					��						2 ���� ����(accept) ��  �� SocketChannel ����
	//		������������������������������������������						������������������������������������������
	//		��	ServerChannel	��						��	ServerChannel	��
	//		��					��	3 ���(read, write)	��					��
	//		��	�Է�		����������	��������������������������������������������������	����������		�Է�	��
	//		��	������ �禡��	����	��	����----------------------��	����	����������	�����ͦ�
	//		��			��	��	��----------------------�榢	��	��			��
	//		��	���	�������榢��	��	��������������������������������������������������	����	���禡��	���	��
	//		��	������	����������	��						��	����������		�����ͦ�
	//		������������������������������������������						������������������������������������������
	
			//	ServerSocket Channel Creation And Connect Accept		�������� ä�� ������ ���� ����
	
	// ������ �����Ϸ��� �켱 ServerSocketChannel ��ü�� ���� �Ѵ�. ServerSocketChannel�� ���� �޼ҵ��� open()���� �����ϰ�, ���ŷ ������� ���۽�Ű�� ���� configureBlocking(true)
	// �޼ҵ带 ȣ���ؾ� �Ѵ�. �⺻������ ���ŷ ������� ����������, ��������� �����ϴ� ������ �ͺ��ŷ�� �����ϱ� ���ؼ��̴�.
	// ��Ʈ�� ���ε��ϱ� ���ؼ��� bind() �޼ҵ尡 ȣ��Ǿ�� �ϴµ�, ��Ʈ ������ ���� InetSocketAddress ��ü�� �Ű������� �ָ� �ȴ�.
	
	//	ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
	//	serverSocketChannel.configureBlocking(true);
	//	serverSocketChannel.bind(new InetSocketAddress(5001));
	
	// ��Ʈ ���ε����� �����ٸ� ServerSocketChannel�� Ŭ���̾�Ʈ ���� ������ ���� accept() �޼ҵ带 �����ؾ� �Ѵ�. accept() �޼ҵ�� Ŭ���̾�Ʈ�� ���� ��û�� �ϱ� ������ ���ŷ�Ǳ� ������
	// UI �� �̺�Ʈ�� ó���ϴ� �����忡�� accept() �޼ҵ带 ȣ������ �ʵ��� �Ѵ�. Ŭ���̾�Ʈ�� ���� ��û�� �ϸ� accept()�� Ŭ���̾�Ʈ�� ����� SocketChannel�� ����� �����Ѵ�.
	
	//	SocketChannel socketChannel = serverSocketChannel.accept();
	
	// ����� Ŭ���̾�Ʈ�� IP�� ��Ʈ ������ �˰� �ʹٸ� SocketChannel�� getRemoteAddress() �޼ҵ带 ȣ���ؼ� SocketAddress�� ������ �ȴ�.
	// ������ ���ϵǴ� ���� InetSocketAddress �ν��Ͻ��̹Ƿ� ������ ���� Ÿ�� ��ȯ�� �� �ִ�.
	
	//	InetSocketAddress socketAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
	
	// InetSocketAddress���� ������ ���� IP�� ��Ʈ ������ �����ϴ� �޼ҵ���� �ִ�.
	
	//	���� Ÿ��		�޼ҵ��(�Ű� ����)		����
	//
	//	String		getHostName()		Ŭ���̾�Ʈ IP ����
	//	int			getPort()			Ŭ���̾�Ʈ ��Ʈ ��ȣ ����
	//	String		toString()			"IP:��Ʈ��ȣ" ������ ���ڿ� ����
	
	// �� �̻� Ŭ���̾�Ʈ�� ���� ���� ������ �ʿ� ���ٸ� ServerSocketChannel�� close() �޼ҵ带 ȣ���ؼ� ��Ʈ�� ����ε����Ѿ� �Ѵ�. �׷��� �ٸ� ���α׷����� �ش� ��Ʈ�� ����� �� �ִ�.
	
	//	serverSocketChannel.close();
	
	// ���� ������ �ݺ������� accept() �޼ҵ带 ȣ���ؼ� ���� Ŭ���̾�Ʈ ������ �����ϴ� ���� �⺻���� �ڵ带 �����ش�.
	
			//	Socket Channel Creation And Connect Accept		���� ä�� ������ ���� ��û
	
	// Ŭ���̾�Ʈ�� ������ ���� ��û�� �� ������ java.nio.channels.SocketChannel�� �̿��Ѵ�. SocketChannel�� ���� �޼ҵ��� open()���� �����ϰ�, 
	// ���ŷ ������� ���۽�Ű�� ���� configureBlocking(true) �޼ҵ带 ȣ���Ѵ�. �⺻������ ���ŷ ������� ����������, ��������� �����ϴ� ������ �ͺ��ŷ�� �����ϱ� ���ؼ��̴�.
	// ���� ���� ��û�� connect() �޼ҵ带 ȣ���ϸ� �Ǵµ�, ���� IP�� ��Ʈ ������ ���� InetSocketAddress ��ü�� �Ű������� �ָ� �ȴ�.
	// connect() �޼ҵ�� ������ �Ϸ�� ������ ���ŷ�ǰ�, ������ �Ϸ�Ǹ� ���ϵȴ�. ������ ���� PC�� 5001 ��Ʈ�� ���ε��� ������ ������ ��û�ϴ� �ڵ��̴�.
	
	//	SocketChannel socketChannel = SocketChannel.open();
	//	socketChannel.configureBlocking(true);
	//	socketChannel.connect(new InetSocketAddress("localhost",5001));
	
	// connect() �޼ҵ�� ������ ������ �� ������ ���ŷ�ǹǷ� UI �� �̺�Ʈ�� ó���ϴ� �����忡�� connect()�� ȣ������ �ʵ��� �Ѵ�.
	// ���ŷ�Ǹ� UI �����̳� �̺�Ʈ ó���� �� �� ���� �����̴�. ����� ��, Ŭ���̾�Ʈ ���α׷��� �����ϰų�, �ʿ信 ���� ������ ���� �ʹٸ� ������ ���� SocketChannel�� close() �޼ҵ带 ȣ���ϸ� �ȴ�.
	
	//	socketChannel.close()
	
	// ���� ������ localhost 5001 ��Ʈ�� ���� ��û�ϴ� �ڵ��̴�. connect() �޼ҵ尡 ���������� ���ϵ��� ���� ������ ���̴�.
	
			//	Socket Channel Data Communication		���� ä�� ������ ���
	
	// Ŭ���̾�Ʈ ���� ��û(connect())�ϰ� ������ ���� ����(accept()) �ߴٸ�, ���� SocketChannel ��ü�� read(), write() �޼ҵ带 ȣ���ؼ� ������ ����� �� �� �ִ�.
	// �� �޼ҵ���� ��� ���۸� �̿��ϱ� ������ ���۷� �а�, ���� �۾��� �ؾ� �Ѵ�.
	
	//		������������������������������������������						������������������������������������������
	//		��	ServerChannel	��						��	ServerChannel	��
	//		��					��	 ���(read, write)	��					��
	//		��	�Է�		����������	��������������������������������������������������	����������		�Է�	��
	//		��	������ �禡��	����	��	����----------------------��	����	����������	�����ͦ�
	//		��			��	��	��----------------------�榢	��	��			��
	//		��	���	�������榢��	��	��������������������������������������������������	����	���禡��	���	��
	//		��	������	����������	��						��	����������		�����ͦ�
	//		������������������������������������������						������������������������������������������
	
	// ������ SocketChannel�� write() �޼ҵ带 �̿��ؼ� ���ڿ��� ������ �ڵ��̴�.
	
	//	Charset charset = Charset.forName("UTF-8");
	//	ByteBuffer byteBuffer = charset.encode("Hello Server");
	//	socketChannel.write(byteBuffer);
	
	// ������ SocketChannel�� read() �޼ҵ带 �̿��ؼ� ���ڿ��� �޴� �ڵ��̴�.
	
	//	ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	int byteCount = socketChannel.read(byteBuffer);
	//	byteBuffer.flip();
	//	Charset charset = Charset.forName("UTF-8");
	//	String message = charset.decode(byteBuffer).toString();
	
	// ���� ������ ���� ���� ��, 1 Ŭ���̾�Ʈ�� ���� "Hello Server"�� ������. 2 ������ �� �����͸� �ް� "Hello Client"�� Ŭ���̾�Ʈ�� ������ 4 Ŭ���̾�Ʈ�� �� �����͸� �޴´�.
	
	// ���� ServerExample���� �����ϰ� ClientExample�� �����غ���.
	
	// �����͸� �ޱ� ���� read() �޼ҵ带 ȣ���ϸ� ������ �����͸� ������ �������� ���ŷ(blocking)�Ǵµ�, read() �޼ҵ尡 ���ŷ �����ǰ� ���ϵǴ� ���� ���� �� �����̴�.
	
	//	���ŷ�� �����Ǵ� ���								���ϰ�
	//
	//	������ �����͸� ����								���� ����Ʈ ��
	//	������ ���������� SocketChannel�� close() ȣ��		-1	
	//	������ ������������ ����							IOException �߻�
	
	// ������ ���������� SocketChannel�� close()�� ȣ���ϰ� ������ ������ ���� ������ ������������ ����� ���� ���� ó���� �ؼ� ���ʵ� SocketChannel�� �ݱ� ���� close() �޼ҵ带 ȣ���ؾ� �Ѵ�.
	
	//	try {
	//		...
	//		// ������ ������������ �������� ��� IOException �߻�
	//		int byteCount = socketChannel.read(byteBuffer);	��������������������������
	//																	��
	//		// ������ ���������� Socket�� close()�� ȣ������ ���					��
	//		if(readByteCount == -1) {									��
	//			throw new IOException();	// ������ IOException �߻���Ŵ   	��
	//		}															��
	//		...															��
	//	} catch (Exception e) {	�禡������������������������������������������������������������������������������
	//		try { socketChannel.close(); } catch(Exception e2) {}
	//	}
	
			//	Handling Thread Parallelism		������ ���� ó��
	
	// TCP ���ŷ ����� ������ ������� �Ϸ�Ǳ� ������ read()�� write() �޼ҵ尡 ���ŷ�ȴ�. ���� ���ø����̼��� �����Ű�� main �����尡 ���� ����� �۾��� ����ϰ� �Ǹ� ������� �Ϸ�� ������
	// �ٸ� �۾��� �� �� ���� ���°� �ȴ�. ���� ��� ���� ���ø����̼��� ���������� Ŭ���̾�Ʈ�� ���� ���� ����� �����ؾ� �ϴµ�, ����¿��� ���ŷ�Ǹ� �� �۾��� �� �� ���� �ȴ�. 
	// ���� Ŭ���̾�Ʈ1�� ������ϴ� ���ȿ��� Ŭ���̾�Ʈ2�� ������� �� �� ���� �ȴ�. �׷��� ������ Ŭ���̾�Ʈ ����(ä��) �ϳ��� �۾� ������ �ϳ��� �Ҵ��ؼ� ���� ó���ؾ� �Ѵ�.
	
	//											��������������������������������������������������������������������������������������������
	//											��	accept()							����	 ��
	//											��	  |		2			 ������������������������������������������
	//		����������������������������������	1 ���� ��û			��	  |	   ������ ����		 ��	�۾� ������ 1	    ����			
	//		��	Ŭ���̾�Ʈ1		���������������������������������������������������������������������������������������� ������������������������������������������
	//		��(SocketChannel)��	3 ó�� ��û			��	  | SocketChennl ����	 ����	SocketChannel  ������
	//		�����������������������������������禡���������������������������������������������������������������������������������� ����		4 �۾� ó��	   ������
	//							5 ����			��	  |					 ������������������������������������������
	//											��	  |		2			 ������������������������������������������
	//		����������������������������������	1 ���� ��û			��	  |	   ������ ����		 ������������������������������������������
	//		��	Ŭ���̾�Ʈ2		���������������������������������������������������������������������������������������� ��	�۾� ������ 2	    ����
	//		��(SocketChannel)��	3 ó�� ��û			��	  | SocketChennl ����	 ������������������������������������������
	//		�����������������������������������禡���������������������������������������������������������������������������������� ����	SocketChannel  ������
	//							5 ����			��	  |					 ����		4 �۾� ó��	   ������
	//											��	  |					 ������������������������������������������
	//											��	  ��					 ������������������������������������������
	//											��������������������������������������������������������������������������������������������
	
	// ���� ���� ������ ���� ó���� �� ��� ��õ ���� Ŭ���̾�Ʈ�� ���ÿ� ����Ǹ� ��õ ���� �����尡 ������ �����Ǳ� ������ ���� ������ �ް��� ���ϵǰ�, �ٿ�Ǵ� ������ �߻��� �� �ִ�.
	// Ŭ���̾�Ʈ�� �������� ���� ������ ������ ������ ������ �����Ϸ��� ������Ǯ�� ����ϴ� ���� �ٶ����ϴ�. ������ ������Ǯ�� �̿��� ��� ���� ���� ����� �����ش�.
	
	//
	//
	//									����������������������������������������������������������������������������������������������������������������������������������������������������������
	//									��																		����	��
	//									��					����������������������������������������������������������������������������������������������������������	��
	//						1 ���� ��û		��	���� �۾� ����		��	������Ǯ(ExecutorService)							��	��
	//		������������������������������������������������������������������	��	����������	��	  �۾� ť					 ������������������������			��	��
	//		��	Ŭ���̾�Ʈ 1...n	��3 ó�� ��û��	��û �۾� ����	��	��	�������������������������������������������������榢	������ 1	��			��	��
	//		��	SocketChannel	��������������������������	��	�����������������������榢 �� �� ��	��				 ������ �۾� ó��	��			��	��
	//		��������������������������������������������������	��	��û �۾� ����	��	��	������������������������������������������	 ��	  ��	   2 SocketChannel ����	
	//				��		3 ó�� ��û	������������������	��	����������	��	�� ������� ť����			��	 ������������������������			��	��
	//				��					��					��	�۾��� ������ �����Ŵ		��	 ������������������������			��	��
	//				��					��					��						���������榢	������ 2	��			��	��
	//				��					��					��							 ����û �۾� ó��	��			��	��
	//				��					��					��							 ��	  ��	   4 SocketChannel ���
	//				��5 ����				��					��							 ������������������������			��	��
	//				������������������������������������������������������������������������������������������������������������������������������������������������������		������ �� ����	��	��
	//									��					����������������������������������������������������������������������������������������������������������	��
	//									����������������������������������������������������������������������������������������������������������������������������������������������������������
	
	// ������Ǯ�� ������ ���� �����ؼ� ����ϱ� ������ ���۽��� Ŭ���̾�Ʈ�� ������ �۾� ť�� �۾����� ������ �� ������ ������ ������ ���� ������ ���� ������ �ϸ��� ���ϵȴ�.
	// �ٸ� ����ϴ� �۾����� �����ϱ� ������ ���� Ŭ���̾�Ʈ���� ������ �ʰ� ���� �� �ִ�. �� ��� ������ �ϵ���� ��翡 �°� ������ ������Ǯ�� ������ ���� �÷��ָ� �ȴ�.
	
			//	Chatting Server Implementation		ä�� ���� ����
	
	// ä�� ������ �����غ��鼭 SocketChannel�� ��� ���Ǵ��� �����غ���.
	
			/*	Server Class Structure		���� Ŭ���� ����	*/
	
	// ������ ���� Ŭ������ ������ �����ش�.
	
	// 24_ JavaFX ���� Ŭ������ ����� ���� Application�� ��ӹ޴´�.
	// 25_ ������Ǯ�� ExecutorService �ʵ带 �����Ѵ�.
	// 26_ Ŭ���̾�Ʈ�� ������ �����ϴ� ServerSocketChannel �ʵ带 �����Ѵ�.
	// 27_ ����� Ŭ���̾�Ʈ�� �����ϴ� List<Client> Ÿ���� connections �ʵ带 �����Ѵ�. �׸��� �����忡 ������ Vector�� �ʱ�ȭ�Ѵ�.
	// 29_ startClient()�� ���� ���� �� ȣ��Ǵ� �޼ҵ��̴�.
	// 73_ stopServer()�� ���� ���� �� ȣ��Ǵ� �޼ҵ��̴�.
	// 95_ Client Ŭ������ ����� Ŭ���̾�Ʈ�� ǥ���ϴµ�, ������ ��� �ڵ带 �����Ѵ�.
	// 175_ UI ���� �ڵ�� ���̾ƿ��� �����ϰ� ServerExample�� �����Ų��.
	
	// ���� ȭ�鿡�� [start] ��ư�� Ŭ���ϸ� startServer() �޼ҵ尡 ȣ��ǰ�, [start] ��ư�� [stop] ��ư���� ����ȴ�. 
	// [stop] ��ư�� Ŭ���ϸ� stopServer() �޼ҵ尡 ȣ��ǰ�, �ٽ� [start] ��ư���� ����ȴ�.
	
			/*	startServer() Method	*/
	
	// [start] ��ư�� Ŭ���ϸ� startServer() �޼ҵ尡 ����Ǵµ�, startServer() �޼ҵ忡���� ExecutorService ����, ServerSocketChannel ���� �� ��Ʈ ���ε�, ���� ���� �ڵ尡 �ʿ��ϴ�.
	// ������ CPU �ھ��� ���� �°� �����带 �����ؼ� �����ϴ� ExecutorService�� �����Ѵ�.
	
	//	01	void startServer() {
	//	02		executorService = Executors.newFixedThreadPool(
	//	03			Runtime.getRuntime().availableProcessors()
	//	04		);
	
	// ������ 5001�� ��Ʈ���� Ŭ���̾�Ʈ�� ������ �����ϴ� ServerSocketChannel�� �����Ѵ�.
	
	//	01	try {
	//	02		serverSocketChannel = ServerSocketChannel.open();
	//	03		serverSocketChannel.configureBlocking(true);
	//	04		serverSocketChannel.bind(new InetSocketAddress(5001));
	//	05	} catch(Exception e) {
	//	06		if(serverSocketChannel.isOpen()) { stopServer(); }
	//	07		return;
	//	08	}
	
	// 06 ~ 07_ 5001�� ��Ʈ�� �̹� �ٸ� ���α׷����� ����ϰ� �ִٸ� java.net.BindException�� �߻��Ѵ�. �� ��쿡�� ServerSocketChannel�� ���� �ִ��� Ȯ���ϰ�,
	//			stopServer() �޼ҵ带 �����Ѵ�. �׸��� return�� �����ؼ� startServer() �޼ҵ带 �����Ѵ�.
	
	// ������ ���� ���� �۾��� Runnable ��ü�� ����� ������Ǯ�� �۾� ������� �����Ű�� �ڵ��̴�. ServerSocketChannel�� �ݺ��ؼ� Ŭ���̾�Ʈ ���� ��û�� ��ٷ��� �ϹǷ� ������Ǯ�� �۾� ������󿡼�
	// accept() �޼ҵ带 �ݺ������� ȣ�����־�� �Ѵ�.
	
	//	01	Runnable runnable = new Runnable() {
	//	02		@Override
	//	03		public void run() {
	//	04			Platform.runLater( () -> {
	//	05				displayText("[���� ����]");
	//	06				btnStartStop.setText("stop");
	//	07			});
	//	08			while(true) {
	//	09				try {
	//	10					SocketChannel socketChannel = serverSocketChannel.accept();			// ���� ����
	//	11					String message = "[���� ����: " + socketChannel.getRemoteAddress() +
	//	12										": " + Thread.currentThread().getName() + "]";
	//	13					Platform.runLater( () -> displayText(message) );
	//	14		
	//	15					Client client = new Client(socketChannel);	// Client ��ü ����
	//	16					connections.add(client);
	//	17
	//	18					Platform.runLater( () -> displayText("[���� ����: " + connections.size() + "]") );
	//	19				} catch (Exception e) {
	//	20					if(serverSocketChannel.isOpen()) { stopServer(); }
	//	21					break;
	//	22				}
	//	23			}
	//	24		}
	//	25	};
	//	26	executorService.submit(runnable);	// ������Ǯ���� ó��
	//	27	}	// startServer() �޼ҵ� ��
	
	// 01_ ���� ���� �۾��� Runnable�� �����Ѵ�.
	// 04 ~ 07_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ���Ǿ���. "[���� ����]"�� ����ϵ��� displayText()�� ȣ���ϰ�, [start] ��ư�� ���ڸ� [stop]���� �����Ѵ�.
	// 08_ �ݺ������� Ŭ���̾�Ʈ�� ������ �����ϱ� ���� ���� ������ �ۼ��Ѵ�.
	// 10_ ServerSocketChannel�� accept()�� �����ؼ� Ŭ���̾�Ʈ�� ���� ��û�� ��ٸ���. Ŭ���̾�Ʈ�� ���� ��û�� �ؿ��� ������ �����ϰ� ��ſ� SocketChannel�� �����Ѵ�.
	// 11 ~ 13_ "[���� ����: Ŭ���̾�Ʈ IP: �۾� ������ �̸�]"���� ���ڿ��� �����ϰ�, ����ϱ� ���� displayText()�� ȣ���Ѵ�.
	// 15 ~ 16_ SocketChannel�� Client ��ü�� �����ϰ� connections �÷��ǿ� �߰��Ѵ�.
	// 18_ "[���� ����: ���� �����ǰ� �ִ� Client ��ü ��]"�� ���ڿ��� �����ϰ�, ����ϱ� ���� displayText()�� ȣ���Ѵ�.
	// 20 ~ 21_ accept()���� ���ܰ� �߻��ϸ� ServerSocketChannel�� �����ִ��� Ȯ���ϰ� stopServer()�� ȣ���Ѵ�. �׸��� ���� ������ �����Ų��.
	// 26_ ���� ���� �۾��� ������Ǯ���� ó���ϱ� ���� ExecutorService�� submit()�� ȣ���Ѵ�.
	
			/*	stopServer() Method	*/
	
	// [stop] ��ư�� Ŭ���ϸ� stopServer() �޼ҵ尡 ����Ǵµ�, stopServer() �޼ҵ忡���� ����� ��� 
	// SocketChannel �ݱ�, ServerSocketChannel �ݱ�, ExecutorService ���� �ڵ尡 �ʿ��ϴ�.
	
	//	01	void stopServer() {
	//	02		try {
	//	03			Iterator<Client> iterator = connections.iterator();		// ��� SocketChannel �ݱ�
	//	04			while(iterator.hasNext()) {
	//	05				Client client = iterator.next();
	//	06				client.socketChannel.close();
	//	07				iterator.remove();
	//	08			}
	//	09			if(serverSocketChannel != null && serverSocketChannel.isOpen()) {	// ServerSocketChannel �ݱ�
	//	10				serverSocketChannel.close();
	//	11			}
	//	12			if(executorService != null && !executorService.isShutdown()) {	// ExecutorService ����
	//	13				executorService.shutdown();
	//	14			}
	//	15			Platform.runLater( () -> {
	//	16				displayText("[���� ����]");
	//	17				btnStartStop.setText("start");
	//	18			});
	//	19		} catch (Exception e) {}
	//	20	}
	
	// 03_ connections �÷������κ��� �ݺ��ڸ� ����.
	// 04 ~ 08_ while������ �ݺ��ڸ� �ݺ��ϸ鼭 Client�� �ϳ��� ��´�. Client�� ������ �ִ� SocketChannel�� �ݰ� connections �÷��ǿ��� Client�� �����Ѵ�.
	// 09 ~ 11_ ServerSocketChannel�� null�� �ƴϰ�, ���� ������ ServerSocketChannel�� �ݴ´�.
	// 12 ~ 14_ ExecutorService�� null�� �ƴϰ�, ���� ������ ExecutorService�� �����Ѵ�.
	// 15 ~ 18_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ���Ǿ���. "[���� ����]"�� ����ϵ��� displayText()�� ȣ���ϰ�, [stop] ��ư�� ���ڸ� [start]�� �����Ѵ�.
	
			/*	Client Class	*/
	
	// ������ �ټ��� Ŭ���̾�Ʈ�� �����ϱ� ������ Ŭ���̾�Ʈ�� �����ؾ� �Ѵ�. Ŭ���̾�Ʈ���� ������ �����͸� ������ �ʿ䵵 �ֱ� ������ Client Ŭ������ �ۼ��ϰ�, 
	// ���� ���� �� ���� Client �ν��Ͻ��� �����ؼ� �����ϴ� ���� ����. Client Ŭ�������� ������ �ޱ� �� ������ �ڵ尡 ���Եȴ�. ������ Client Ŭ������ ������ �����ش�.
	
	//	01	class Client {
	//	02		SocketChannel socketChannel;
	//	03	
	//	04		Client(SocketChannel socketChannel) {
	//	05			this.socketChannel = socketChannel;
	//	06			receive();
	//	07		}
	//	08
	//	09		void receive() { // ������ �ޱ� �ڵ� }
	//	10		void send(String data) { // ������ ���� �ڵ� }
	//	11	}
	
	// 01_ Client�� ServerExample�� ���� Ŭ������ �����Ѵ�.
	// 02_ ��ſ� SocketChannel�� �ʵ�� �����Ѵ�.
	// 04 ~ 07_ Client �����ڸ� �����Ѵ�. �Ű������� SocketChannel �ʵ带 �ʱ�ȭ�ϰ� receive()�� ȣ���Ѵ�.
	// 09_ Ŭ���̾�Ʈ�� �����͸� �ޱ� ���� receive() �޼ҵ带 �����Ѵ�.
	// 10_ �����͸� Ŭ���̾�Ʈ�� ������ ���� send() �޼ҵ带 �����Ѵ�.
	
	// ���� �ڵ�� Ŭ���̾�Ʈ�� �����͸� �޴� receive() �޼ҵ��̴�. ������Ǯ�� �۾� �����尡 ó���ϵ��� Runnable�� �۾��� �����ϰ� �ְ�,
	// Ŭ���̾�Ʈ�� ���� �����͸� �ݺ������� �ޱ� ���� ���� ������ ���鼭 SocketChannel�� read() �޼ҵ带 ȣ���ϰ� �ִ�.
	
	//	01	void receive() {
	//	02		Runnable runnable = new Runnable() {
	//	03			@Override
	//	04			public void run() {
	//	05				while(true) {
	//	06					try {
	//	07						ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	08
	//	09						// Ŭ���̾�Ʈ�� ������ ���Ḧ ���� ��� IOException �߻�
	//	10						int readByteCount = socketChannel.read(byteBuffer);		// ������ �ޱ�
	//	11
	//	12						// Ŭ���̾�Ʈ�� ���������� SocketChannel�� close()�� ȣ������ ���
	//	13						if(readByteCount == -1) {
	//	14							throw new IOException();
	//	15						}
	//	16
	//	17						String message = "[��û ó��: " + socketChannel.getRemoteAddress() +
	//	18											": " + Thread.currentThread().getName() + "]";
	//	19						Platform.runLater( () -> displayText(message) );
	//	20
	//	21						byteBuffer.flip();		// ���ڿ��� ��ȯ
	//	22						Charset charset = Charset.forName("UTF-8");
	//	23						String data = charset.decode(byteBuffer).toString();
	//	24
	//	25						for(Client client : connections) {
	//	26							client.send(data);
	//	27						}
	//	28					} catch(Exception e) {
	//	29						try {
	//	30							connections.remove(Client.this);
	//	31							String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " +
	//	32												socketChannel.getRemoteAddress() + ": " +
	//	33												Thread.currentThread().getName() + "]";
	//	34							Platform.runLater( () -> displayText(message) );
	//	35							socketChannel.close();
	//	36						} catch (IOException e2) {}
	//	37						break;
	//	38					}
	//	39				}
	//	40			}
	//	41		};
	//	42		executorService.submit(runnable);		// ������Ǯ���� ó��
	//	43	}
	
	// 02_ Ŭ���̾�Ʈ�κ��� �����͸� �޴� �۾��� Runnable�� �����Ѵ�.
	// 04_ run() �޼ҵ带 �������Ѵ�.
	// 05_ �۾��� ���� �ݺ��Ѵ�.
	// 07_ 100���� ����Ʈ�� ������ �� �ִ� ByteBuffer�� �����Ѵ�.
	// 10_ SocketChannel�� read() �޼ҵ带 ȣ���Ѵ�. Ŭ���̾�Ʈ�� �����͸� ������ ������ ���ŷ�ȴ�. �����͸� ������ byteBuffer�� �����ϰ� ���� ����Ʈ ������ readByteCount�� �����Ѵ�.
	// 13 ~ 15_ Ŭ���̾�Ʈ�� ���������� SocketChannel�� close()�� ȣ������ ���, 10������ read() �޼ҵ�� -1�� �����Ѵ�. �� ��� IOException�� ������ �߻���Ų��.
	// 17 ~ 19_ ���������� �����͸� �޾��� ���, "[��û ó��: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����ϰ� displayText()�� ȣ���ؼ� ����Ѵ�.
	// 21 ~ 23_ ���������� �����͸� �ް� �Ǹ� ���� �����Ͱ� ����� ByteBuffer�� flip() �޼ҵ带 ȣ���ؼ� ��ġ �Ӽ����� ������ �� UTF-8�� ���ڵ��� ���ڿ��� ��´�.
	// 25 ~ 27_ ���ڿ��� ��� Ŭ���̾�Ʈ���� ������ ���� connections�� ����� Client�� �ϳ��� ��� send() �޼ҵ带 ȣ���Ѵ�.
	// 30_ ���ܰ� �߻��ϸ� connections �÷��ǿ��� Client�� �����Ѵ�. ���ܴ� 10���ΰ� 14���ο��� �߻��ϴµ�, ��� Ŭ���̾�Ʈ�� ����� �� �� ���̴�.
	// 31 ~ 34_ "[Ŭ���̾�Ʈ ��� �ȵ�: Ŭ���̾�Ʈ IP: �۾��������̸�]" ���� ������ ���ڿ��� �����ϰ� dispalyText()�� ȣ���ؼ� ����Ѵ�.
	// 35_ SocketChannel�� �ݴ´�.
	// 42_ ������Ǯ���� �۾��� ó���ϱ� ���� submit()�� ȣ���Ѵ�.
	
	// ���� �ڵ�� �����͸� Ŭ���̾�Ʈ�� ������ send() �޼ҵ��̴�. ������Ǯ�� �۾� �����尡 ó���ϵ��� �۾��� Runnable�� �����ϰ� �ִ�.
	
	//	01	void send(String data) {
	//	02		Runnable runnable = new Runnable() {
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					Charset charset = Charset.forName("UTF-8");
	//	07					ByteBuffer byteBuffer = charset.encode(data);
	//	08					socketChannel.write(byteBuffer);
	//	09				} catch(Exception e) {
	//	10					try {
	//	11						String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " +
	//	12											socketChannel.getRemoteAddress() + ": " +
	//	13											Thread.currentThread().getName() + "]";
	//	14						Platform.runLater( () -> displayText(message) );
	//	15						connections.remove(Client.this);
	//	16						socketChannel.close();
	//	17					} catch (IOException e2) {}
	//	18				}
	//	19			}
	//	20		};
	//	21		executorService.submit(runnable);
	//	22	}
	
	// 02_ �����͸� Ŭ���̾�Ʈ�� ������ �۾��� Runnable�� �����Ѵ�.
	// 04_ run()�� �������Ѵ�.
	// 06 ~ 07_ send() �޼ҵ��� �Ű������� ���� ���ڿ��κ��� UTF-8�� ���ڵ��� ByteBuffer�� ��´�.
	// 08_ SocketChannel�� write() �޼ҵ带 ȣ���Ѵ�.
	// 11 ~ 14_ 8���ο��� ���ܰ� �߻��ϸ� "[Ŭ���̾�Ʈ ��� �ȵ�: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����ϰ� displayText()�� ȣ���ؼ� ����Ѵ�.
	// 15_ connections �÷��ǿ��� ���ܰ� �߻��� Client�� �����Ѵ�.
	// 16_ SocketChannel�� �ݴ´�.
	// 22_ ������Ǯ���� �۾��� ó���ϱ� ���� submit()�� ȣ���Ѵ�.
	
			/*	UI Creation Code	UI ���� �ڵ�	*/
	
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
	
	// 27������ �ܺ� CSS ����(app.css)�� Scene�� �����ϰ� �ִ�. �� ������ TextArea�� ���� �����ε�, TextArea�� ���� ���� �����̳ʷ� �ѷ��ο� �ִ� ������ ������ ������ �־� �ܼ���
	// TextArea�� setStyle()�� ������ �ٲ� �� ����. �׷��� ������ ���� �ܺ� CSS Ŭ���� �����ڸ� �̿��ؼ� �����̳��� ������ �����ߴ�.
	
	// text-area�� gold������ �����ϰ�, ������ �����̳ʵ��� ��� ����(transparent)���� ���������ν� TextArea�� ��ü ������ gold������ ���̵��� �ߴ�.
	
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
	
		//	Chatting Client Implementation		ä�� Ŭ���̾�Ʈ ����
		
	// ä�� Ŭ���̾�Ʈ ���� �ڵ带 ���鼭 Socket�� ��� ���Ǵ��� �����غ���.
	
			/*	Client Class Structure		Ŭ���̾�Ʈ Ŭ���� ����		*/
	
	// ���� ������ Ŭ���̾�Ʈ Ŭ������ ������ �����ش�.
	
	// 01_ JavaFX ���� Ŭ������ ����� ���� Application�� ����Ѵ�.
	// 02_ Ŭ���̾�Ʈ ����� ���� SocketChannel �ʵ带 �����Ѵ�.
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
	//	06					socketChannel = SocketChannel.open();
	//	07					socketChannel.configureBlocking(true);
	//	08					socketChannel.connect(new InetSocketAddress("localhost", 5001));
	//	09					Platform.runLater( () -> {
	//	10						try {
	//	11							displayText("[���� �Ϸ�: " + socketChannel.getRemoteAddress() + "]");
	//	12							btnConn.setText("stop");
	//	13							btnSend.setDisable(false);
	//	14						} catch (Exception e) {}	
	//	15					});
	//	16				} catch(Exception e) {
	//	17					Platform.runLater( () -> displayText("[���� ��� �ȵ�]"));
	//	18					if(socketChannel.isOpen()) { stopClient(); }
	//	19					return;
	//	20				}
	//	21				receive();	// �������� ���� ������ �ޱ�
	//	22			}
	//	23		};
	//	24		thread.start();	// ������ ����
	//	25	}
	
	// 02_ �۾� �����带 �����Ѵ�. �۾� �����尡 �ʿ��� ������ 8������ connect()�� 21������ receive()���� ���ŷ�� �Ͼ�� �����̴�. JavaFX Application Thread�� �� �޼ҵ���� ȣ������ �ʴ� ���� ����.
	// 04_ run() �޼ҵ带 �������Ѵ�.
	// 06 ~ 07_ ��ſ� ���ŷ SocketChannel�� �����Ѵ�.
	// 08_ local 5001 ��Ʈ�� ���� ��û�� �Ѵ�.
	// 09_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ���Ǿ���.
	// 11_ "[���� �Ϸ�: ����IP]"�� ������ ���ڿ��� �����ϰ�, displayText()�� ����Ѵ�.
	// 12_ [start] ��ư�� ���ڸ� [stop]���� �����Ѵ�.
	// 13_ [send] ��ư�� Ȱ��ȭ�Ѵ�.
	// 17_ ���ܰ� �߻��ϸ� "[���� ��� �ȵ�"]�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 18_ SocketChannel�� �����ָ� stopClient() �޼ҵ带 ȣ���Ѵ�.
	// 19_ return�� �����ؼ� �����带 �����Ѵ�.
	// 21_ ���ܰ� �߻����� ������ receive() �޼ҵ带 ȣ���Ѵ�.
	// 24_ �۾� �����带 �����Ѵ�.
	
			/*	stopClient() Method	*/
	
	// [stop] ��ư�� Ŭ���ϰų� ���� ����� �� �� ��� stopClient() �޼ҵ尡 ����Ǵµ�, stopClient() �޼ҵ忡�� SocketChannel�� �ݴ� close() �޼ҵ� ȣ�� �ڵ尡 �ִ�.
	
	//	01	void stopClient() {
	//	02		try {
	//	03			Platform.runLater( () -> {
	//	04				displayText("[���� ����]");
	//	05				btnConn.setText("start");
	//	06				btnSend.setDisable(true);
	//	07			});
	//	08			if(socketChannel != null && socketChannel.isOpen()) {
	//	09				socketChannel.close();	// ���� ����
	//	10			}
	//	11		} catch(IOException e) {}
	//	12	}
	
	// 03_ UI�� �����ϱ� ���� Platform.runLater()�� ���Ǿ���.
	// 04_ "[���� ����]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 05_ [stop] ��ư�� ���ڸ� [start]�� �����Ѵ�.
	// 06_ [send] ��ư�� ��Ȱ��ȭ�Ѵ�.
	// 08_ socketChannel �ʵ尡 null�� �ƴϰ�, ���� ���� �ִ� ���,
	// 09_ SocketChannel�� �ݴ´�.
	
			/*	receive() Method	*/
	
	// receive() �޼ҵ�� �������� ���� �����͸� �޴� ������ �Ѵ�. �� �޼ҵ�� startClient()���� ������ �۾� ������󿡼� ȣ��ȴ�.
	
	//	01	void receive() {
	//	02		while(true) {
	//	03			try {
	//	04				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	05	
	//	06				// ������ ������������ �������� ��� IOException �߻�
	//	07				int readByteCount = socketChannel.read(byteBuffer);		// ������ �ޱ�
	//	08	
	//	09				// ������ ���������� Socket�� close()�� ȣ������ ���
	//	10				if(readByteCount == -1) {
	//	11					throw new IOException();
	//	12				}
	//	13	
	//	14				byteBuffer.flip();
	//	15				Charset charset = Charset.forName("UTF-8");
	//	16				String data = charset.decode(byteBuffer).toString();	// ���ڿ��� ��ȯ
	//	17	
	//	18				Platform.runLater( () -> displayText("[�ޱ� �Ϸ�]" + data)); 
	//	19			} catch(Exception e) {
	//	20				Platform.runLater( () -> displayText("[���� ��� �ȵ�]"));
	//	21				stopClient();
	//	22				break;
	//	23			}
	//	24		}
	//	25	}
	
	// 02_ �ݺ������� �б� ���� ���� ������ �ۼ��Ѵ�.
	// 04_ ���� �����͸� ������ ���̰� 100�� ByteBuffer�� �����Ѵ�.
	// 07_ SocketChannel�� read() �޼ҵ带 ȣ���Ѵ�. ������ �����͸� ������ ������ ���ŷ �ǰ�, �����͸� ������ byteBuffer�� ������ �� ���� ����Ʈ ������ readByteCount�� �����Ѵ�.
	// 10 ~ 12_ ������ ���������� Socket�� close()�� ȣ������ ���, 7������ read() �޼ҵ�� -1�� �����Ѵ�. �� ��� IOException�� ������ �߻���Ų��.
	// 14 ~ 16_ ���������� �����͸� �޾��� ���, flip() �޼ҵ�� ByteBuffer�� ��ġ �Ӽ����� �����ϰ� UTF-8�� ���ڵ��� ���ڿ��� ��´�.
	// 18_ "[�ޱ� �Ϸ�] + ���� ���ڿ�"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 20_ ������ ������������ ������ ���� �Ǹ� 7���ο��� IOExceptiond�� �߻��ϰ�, ���� �� SocketChannel�� close()�� ȣ���ؼ� ���������� ������ ���� �Ǹ� 11���ο��� IOException�� �߻��Ѵ�.
	//		���ܰ� �߻��ϸ� "[���� ��� �ȵ�]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 21_ stopClient()�� ȣ���Ѵ�.
	// 22_ break�� �����ؼ� ���ѷ����� �������´�.
	
			/*	send(String data) Method	*/
	
	// ����ڰ� �޼����� �Է��ϰ� [send] ��ư�� Ŭ���ϸ� �޼����� �Ű������� �ؼ� send(String data) �޼ҵ尡 ȣ��ȴ�.
	// �� �޼ҵ�� �޼����� ������ ������ ������ �Ѵ�.
	
	//	01	void send(String data) {
	//	02		Thread thread = new Thread() {	// ������ ����
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					Charset charset = Charset.forName("UTF-8");
	//	07					ByteBuffer byteBuffer = charset.encode(data);
	//	08					socketChannel.write(byteBuffer);	// ������ ������ ������
	//	09					Platform.runLater( () -> displayText("[������ �Ϸ�]"));
	//	10				} catch(Exception e) {
	//	11					Platform.runLater( () -> displayText("[���� ��� �ȵ�]"));
	//	12					stopClient();
	//	13				}
	//	14			}
	//	15		};
	//	16		thread.start();	// ������ ����
	//	17	}
	
	// 02_ �����͸� ������ ������ ���ο� �۾� �����带 �����Ѵ�.
	// 04_ run()�� �������Ѵ�.
	// 06 ~ 07_ send() �޼ҵ��� �Ű������� ���� ���ڿ��κ��� UTF-8�� ���ڵ��� ByteBuffer�� ��´�.
	// 08_ ByteBuffer ������ ������ �����ϱ� ���� SocketChannel�� write()�� ȣ���Ѵ�.
	// 09_ "[������ �Ϸ�]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 11_ 8���ο��� ���ܰ� �߻��ϸ� "[���� ��� �ȵ�]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 12_ stopClient()�� ȣ���Ѵ�.
	// 16_ �۾� �����带 �����Ѵ�.
	
			/*	UI Creation Code	UI ���� �ڵ�	*/
	
	// ������ ClientExample UI ���� �ڵ带 �����ش�. ���α׷��� ���̾ƿ��� �̿��ؼ� ��Ʈ���� ��ġ�ߴ�.
	
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
	
			//	Blocking And Interrupt		���ŷ�� ���ͷ�Ʈ
	
	// IO�� Socket������ ����� ��Ʈ���� read()�� write() �޼ҵ�� ���� �۾� �����尡 ���ŷ�Ǿ��� �� �ٸ� �����尡 �۾� �������� interrupt() �޼ҵ带 ȣ���ص� ���ŷ ���°� Ǯ���� �ʴ´�.
	// �׷��� Socket�� close() �޼ҵ带 ȣ���ؼ� SocketException�� �߻����Ѿ� �Ѵ�.
	// �׷��� NIO�� SocketChannel�� ��� read()�� write() �޼ҵ�� ���� �۾� �����尡 ���ŷ�Ǿ��� �� �ٸ� �����尡 �۾� �������� interrupt() �޼ҵ带 ȣ���ϸ�
	// ClosedByInterruptException�� �߻��ϰ� SocketChannel�� ���� ���� �ִµ�, �̶����� AsynchronousCloseException�� �߻��Ǹ鼭 ���ŷ ���°� Ǯ����.
	// ���� �ڵ�� �۾� �������� interrupt() �޼ҵ带 ȣ���ؼ� �д� �۾��� ������Ű�鼭 SocketChannel�� �ݵ��� �����Ѵ�.
	
	//	Thread thread = null;
	//	public void receive() {
	//		thread = new Thread() {
	//			@Override
	//			public void run() {
	//				try {								������������������������������������������
	//					...								��					��
	//					int byteCount = socketChannel.read(byteBuffer);	��	��
	//					...			ClosedByInterruptException �߻�		��2	��
	//				} catch(Exception e) {		��������������������������������������������������	��
	//					socketChannel.close();	��							��
	//				}														��1
	//			}															��
	//		};																��
	//		thread.start();													��
	//	}																	��
	//																		��
	//	public void stop() {			�ٸ� �����尡 stop()�� ȣ��					��
	//		thread.interrupt();	������������������������������������������������������������������������������������������
	//	}
}
