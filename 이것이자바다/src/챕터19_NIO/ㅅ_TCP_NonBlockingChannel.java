package é��19_NIO;

public class ��_TCP_NonBlockingChannel {
	// ServerSocketChannel, SocketChannel�� ���ŷ(blocking) ��ĵ� ���������� �ͺ��ŷ(non-blocking) ��ĵ� �����Ѵ�.
	// �̹� �������� �ͺ��ŷ ����� Ư¡�� �ͺ��ŷ�� �ٽ� ��ü�� ������(Selector)�� �����ϰ� ä���� �ͺ��ŷ ������� ����ϴ� ����� ���� �˾ƺ���� ����.
	
			//	Characteristic Of Non-Blocking Way		�ͺ��ŷ ����� Ư¡
	
	// ���ŷ ����� ���� Ŭ���̾�Ʈ�� ���� ��û�� ���� �𸣱� ������ accept()���� ���ŷ�ȴ�. �׸��� ���� Ŭ���̾�Ư �����͸� ������ �𸣹Ƿ� read() �޼ҵ�� �׻� �����͸� ���� �غ� �ϱ� ���� ���ŷ�ȴ�.
	// �׷��� ������ ServerSocketChannel�� ����� SocketChannel�� �ϳ��� �����尡 �Ҵ�Ǿ�� �Ѵ�. ���� ����� Ŭ���̾�Ʈ�� �������� �������� ���� �����ϰ� ������ �ɰ��� ���� ������ ������ ���� �ִ�.
	// �� ������ �ذ��ϱ� ���� ���ݱ����� ������Ǯ(ExecutorService)�� ����߾���.
	
	// �ڹٴ� ���ŷ ����� �� �ٸ� �ذ�å���� �ͺ��ŷ ����� �����ϰ� �ִ�. �ͺ��ŷ ����� connect(), accept(), read(), write() �޼ҵ忡�� ���ŷ�� ����.
	// Ŭ���̾�Ʈ�� ���� ��û�� ������ accept()�� ��� null�� �����Ѵ�. �׸��� Ŭ���̾�Ʈ�� �����͸� ������ ������ read()�� ��� 0�� �����ϰ�, �Ű������� ������ ByteBuffer���� � �����͵� ������� �ʴ´�.
	// �ͺ��ŷ ��Ŀ��� ���� �ڵ�� Ŭ���̾�Ʈ�� ���� ��û�� ���� ������ ���� ������ ��� ����.
	
	//	while(true) {
	//		SocketChannel socketChannel = serverSocketChannel.accept();
	//		...
	//	}
	
	// accept() �޼ҵ尡 ���ŷ���� �ʰ� �ٷ� ���ϵǱ� ������ Ŭ���̾�Ʈ�� ���� ��û�� ������ ������ while ��� ���� �ڵ尡 ���� ���� ����Ǿ� CPU�� �����ϰ� �Һ�Ǵ� �������� �߻��Ѵ�.
	// �׷��� �ͺ��ŷ�� �̺�Ʈ ������ ������ �ϴ� ������(Selector)�� ����Ѵ�. �ͺ��ŷ ä�ο� Selector�� ����� ������ Ŭ���̾�Ʈ�� ���� ��û�� �����ų� �����Ͱ� ������ ���, ä���� Selector�� �뺸�Ѵ�.
	// Selector�� �뺸�� ä�ε��� �����ؼ� �۾� �����尡 accept() �Ǵ� read() �޼ҵ带 �����ؼ� ��� �۾��� ó���ϵ��� �Ѵ�.
	
	// Selector�� ��Ƽ ä���� �۾��� �̱� �����忡�� ó���� �� �ֵ��� ���ִ� ��Ƽ�÷���(multiplexor) ������ �Ѵ�. 1 ä���� Selector�� �ڽ��� ����� �� ���� ������ Ű(SelectionKey)�� �����ϰ�,
	// Selector�� ����Ű��(interest-set)�� �����Ų��. 2 Ŭ���̾�Ʈ�� ó�� ��û�� �ϸ� 3 Selector�� ����Ű�¿� ��ϵ� Ű �߿��� �۾� ó�� �غ� �� Ű�� ���õ� Ű��(selected-set)�� ������ �����Ѵ�.
	// 4 �׸��� �۾� �����尡 ���õ� Ű�¿� �ִ� Ű�� �ϳ��� ������  Ű�� ������ ä�� �۾��� ó���ϰ� �ȴ�. �۾� �����尡 ���õ� Ű�¿� �ִ� ��� Ű�� ó���ϰ� �Ǹ� ���õ� Ű���� �������,
	// Selector�� �ٽ� ����Ű�¿��� �۾� ó�� �غ� �� Ű���� �����ؼ� ���õ� Ű���� ä���.
	
	//	
	//
	//										��������������������������������������������������������������������������������������������������������������������������������������������������
	//		������������������������������������������			������						����������������������������������������������������������					��
	//		��		Ŭ���̾�Ʈ		��	2 ó�� ��û	��	 ������������������������		��	������(Selector)			��					��
	//		�� (SocketChannel-1)	���禡���������������������������榢	Socket	�� 1 ���	��							��					��
	//		������������������������������������������	5 ����	��	 ��Channel-1	����������	�� ����Ű��						��					��
	//										��	 ������������������������	��	������������������					��	��������������������������	��
	//										��					�������榢�� ����O	��	  3 ���õ� Ű��		��	��  �۾� ������	��	��
	//		������������������������������������������			��						����		��	 ������������������������	��	��			��	��
	//		��		Ŭ���̾�Ʈ		��	2 ó�� ��û	��	 ������������������������	�������榢�� ����O	���������榢 ����O ����O	���������������榢  4 �۾� ó��	��	��
	//		�� (SocketChannel-2)	���禡���������������������������榢	Socket	���������� 	����		��	 ������������������������	��	��			��	��
	//		������������������������������������������	5 ����	��	 ��Channel-2	�� 1 ���	����	:	��					��	��	  �ͺ��ŷ	��	��
	//										��	 ������������������������		����	:	��					��	��������������������������	��
	//										��						������������������					��					��
	//										��						����������������������������������������������������������					��
	//										��������������������������������������������������������������������������������������������������������������������������������������������������
	
	// �ͺ��ŷ���� �۾� �����带 �� �ϳ��� ����� �ʿ�� ����. ä�� �۾� ó�� �� (4) ������Ǯ�� ����� �� �ִ�. �۾� �����尡 ���ŷ���� �ʱ� ������ ���� ���� ������� ���� ���� �۾��� ������� ó���� �� �־�
	// ���ŷ ��� ���ٴ� ������ ������ ���� �� �ִ�.
	
			//	Selector Creation And Registration		������ ������ ���
	
	// Selector�� ���� �޼ҵ��� open() �޼ҵ带 ȣ���Ͽ� �����Ѵ�. open() �޼ҵ�� IOException�� �߻��� �� �ֱ� ������ ���� ó���� �ʿ��ϴ�.
	
	//	try {
	//		Selector selector = Selector.open();
	//	} catch(IOException e) {
	
	// Selector�� ����� �� �ִ� ä���� SelectableChannel�� ���� ä�θ� �����ѵ�, TCP ��ſ� ���Ǵ� ServerSocketChannel, SocketChannel�� UDP ��ſ� ���Ǵ� DatagramChannel�� ���
	// SelectableChannel�� ���� Ŭ�����̹Ƿ� Selector�� ����� �� �ִ�. ������ ���� �ͺ��ŷ���� ������ �͸� �����ϴ�. ������ ServerSocketChannel�� �ͺ��ŷ���� �����ϴ� �ڵ��̴�.
	
	//	ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
	//	serverSocketChannel.configureBlocking(false);
	
	// ������ SocketChannel�� �ͺ��ŷ���� �����ϴ� �ڵ��̴�.
	
	//	SocketChannel socketChannel = SocketChannel.open();
	//	socketChannel.configureBlocking(false);
	
	// �� ä���� register() �޼ҵ带 �̿��ؼ� Selector�� ����ϴµ�, ù ��° �Ű����� Selector�̰� �� ��° �Ű����� ä���� �۾� �����̴�.
	
	//	SelectionKey selectionKey = serverSocketChannel.register(Selector sel, int ops);
	//	SelectionKey selectionKey = socketChannel.register(Selector sel, int ops);
	
	// ������ �� ��° �Ű������� ����� �� �ִ� �۾� ������ SelectionKey�� ������̴�.
	
	//	SelectionKey�� ���	����		
	//
	//	OP_ACCEPT			ServerSocketChannel�� ���� ���� �۾�
	//	OP_CONNECT			SocketChannel�� ���� ���� �۾�
	//	OP_READ				SocketChannel�� ������ �б� �۾�
	//	OP_WRITE			SocketChannel�� ������ ���� �۾�
	
	// register()�� ä�ΰ� �۾� ���� ������ ��� �ִ� SelectionKey�� �����ϰ� Selector�� ����Ű�¿� ������ �� �ش� SelectionKey�� �����Ѵ�.
	// ������ ServerSocketChannel�� Selector�� �ڽ��� �۾� ������ ����ϴ� �ڵ��̴�.
	
	//	SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_ONNECT);
	//	SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
	//	SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_WRITE);
	
	// SocketChannel�� �۾��� �� �����ε�, ���� ���� ��û �۾��� OP_CONNECT, �б� �۾��� OP_READ, ���� �۾��� OP_WRITE�� �����Ѵ�. 
	// ������ ���� ������ SocketChannel�� �� ���� �̻��� �۾� ������ ����� ������. ��, register()�� �� �� �̻� ȣ���� �� ����. 
	// ����� �� ���� �ϵ�, �۾� ������ ����Ǹ� �̹� ������ SelectionKey�� �����ؾ� �Ѵ�.
	// register()�� ������ SelectionKey�� �۾� ���� ����, ÷�� ��ü ����, ä�� ��� ��� ���� �� �� ����Ѵ�. SelectionKey�� ������ ������ �ʿ�� ���µ�, ä���� Selector�� ����ϸ� ä����
	// KeyFor() �޼ҵ�� SelectionKey�� �������� ���� �� �ֱ� �����̴�.
	
	//	SelectionKey key = socketChannel.keyFor(selector);
	
			//	Selected KeySet		���õ� Ű��
	
	// Selector�� �����Ϸ��� select() �޼ҵ带 ȣ���ؾ� �Ѵ�. select()�� ����Ű�¿� ����� SelectionKey�κ��� �۾� ó�� �غ� �Ǿ��ٴ� �뺸�� �� ������ ���(���ŷ)�Ѵ�. 
	// �ּ��� �ϳ��� Selection�κ��� �۾� ó�� �غ� �Ǿ��ٴ� �뺸�� ���� �����Ѵ�. �̶� ���ϰ��� �뺸�� �ؿ� SelectionKey�� ���̴�.
	// ���� �� ���� ������ select() �޼ҵ带 ������ ǥ�̴�.
	
	//	���� Ÿ��	�޼ҵ��(�Ű� ����)			����
	//
	//	int		select()				�ּ��� �ϳ��� ä���� �۾� ó�� �غ� �� ������ ���ŷ�ȴ�.
	//	int		select(long timeout)	select()�� �����ѵ�, �־��� �ð�(�и�������) ���ȸ� ���ŷ�ȴ�.
	//	int		selectNow()				ȣ�� ��� ���ϵȴ�. �۾� ó�� �غ�� ä���� ������ ä�� ���� �����ϰ�, ���ٸ� 0�� �����Ѵ�.
	
	// �η� ù ��° select()�� ����ϴµ�, �� �޼ҵ�� ���ŷ�ǹǷ� UI �� �̺�Ʈ�� ó���ϴ� �����忡�� ȣ��Ǹ� �� �ǰ�, ������ �۾� �����带 �����ؼ� �����ؾ� �Ѵ�.
	// select()�� �����ϴ� ���� ���� �� �����̴�.
	
	//	- ä���� �۾� ó�� �غ� �Ǿ��ٴ� �뺸�� �� ��
	//	- Selector�� wakeup() �޼ҵ带 ȣ���� ��
	//	- select()�� ȣ���� �����尡 ���ͷ�Ʈ�� ��
	
	// ServerSocketChannel�� �۾� ������ OP_ACCEPT �ϳ� �ۿ� ������, SocketChannel�� ��Ȳ�� ���� �б� �۾��� ���� �۾��� �����ư��� �۾� ������ ������ �� �ִ�.
	// ä���� �۾� ������ ����Ǹ� SelectionKey�� �۾� ������ interestOps() �޼ҵ�� �����ؾ� �۾� �����尡 �ùٸ��� ä�� �۾��� �� �� �ִ�.
	// ������ SelectionKey�� �۾� ������ OP_WRITE�� �����ϴ� �ڵ��̴�.
	
	//	selectionKey.interestOps(SelectionKey.OP_WRITE);
	//	selector.wakeup();
	
	// SelectionKey�� �۾� ������ ����Ǹ� Selector�� wakeup() �޼ҵ带 ȣ���ؼ� ���ŷ�Ǿ� �ִ� select()�� ��� �����ϰ�, ����� �۾� ������ �����ϵ��� select()�� �ٽ� �����ؾ� �Ѵ�.
	// ������ select() �޼ҵ尡 1 �̻��� ���� ������ ���, selectedKeys() �޼ҵ�� �۾� ó�� �غ�� SelectionKey���� Set �÷������� ��´�. �̰��� ���õ� Ű���̴�.
	
	//	int keyCount = selector.select();
	//	if(keyCount > 0) {
	//		Set<SelectionKey> selectedKeys = selector.selectedKeys();
	//	}
	
			//	Handling Channel Task 	ä�� �۾� ó��
	
	// �۾� �����尡 �ؾ� �� ���� ���õ� Ű�¿��� SelectionKey�� �ϳ��� ������ �۾� �������� ä�� �۾� ó���ϴ� ���̴�. 
	// SelectionKey�� � �۾� �������� �˾Ƴ��� ����� SelectionKey�� ���� �޼ҵ� �߿��� � ���� true�� �����ϴ��� �����ϸ� �ȴ�.
	
	//	���� Ÿ��		�޼ҵ��(�Ű� ����)		����
	//
	//	boolean		isAcceptable()		�۾� ������ OP_ACCEPT�� ���
	//	boolean		isConnectable()		�۾� ������ OP_CONNECT�� ���
	//	boolean		isReadable()		�۾� ������ OP_READ�� ���
	//	boolean		isWritable()		�۾� ������ OP_WRITE�� ���
	
	// ������ �۾� �����尡 �۾� �������� �۾��� ó���ϴ� ����� �����ش�.
	
	//	Thread thread = new Thread() {	// ������ ����
	//		@Override
	//		public void run() {
	//			while(true) {
	//				try {
	//					int keyCount = selector.select();	// �۾� ó�� �غ�� Ű ����
	//					if(keyCount == 0) { continue; }	// Ű�� ���� ��� ���� ó������ ���ư�
	//					Set<SelectionKey> selectedKeys = selector.selectedKeys();	// ���õ� Ű�� ���
	//					Iterator<SelectionKey> iterator = selectedKeys.iterator();	// �ݺ��� ���
	//					while(iterator.hasNext()) {
	//						SelectionKey selectionKey = iterator.next();	// Ű�� �ϳ��� ������
	//						if(selectionKey.isAccetable()) { // ���� ���� �۾� ó�� }
	//						else if(selectionKey.isReadable()) { // �б� �۾� ó�� }
	//						else if(selectionKey.isWritable()) { // ���� �۾� ó�� }
	//						iterator.remove();	// ���õ� Ű�¿��� ó�� �Ϸ�� SelectionKey�� ����
	//					}
	//				} catch (Exception e) {
	//					break;
	//				}
	//			}
	//		}
	//	};
	//	thread.start();
	
	// �۾� �����尡 ä�� �۾��� ó���Ϸ��� ä�� ��ü�� �ʿ��ѵ�, SelectionKey�� channel() �޼ҵ带 ȣ���ϸ� ���� �� �ִ�.
	// ������ �۾� ������ OP_ACCEPT�� ���, ���� ���� �۾� ó������ �ʿ��� ServerSocketChannel�� ��� �ڵ��̴�.
	
	//	ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
	
	// �۾� �����尡 ä�� �۾��� ó���ϴ� ���� ä�� ��ü �̿ܿ� �ٸ� ��ü�� �ʿ��� ���� �ִ�. �̷��� ��ü�� SelectionKey�� ÷���� �ΰ�, ����� �� �ִ�. SelectionKey�� attach() �޼ҵ�� ��ü�� ÷���ϰ�,
	// attachment() �޼ҵ�� ÷�ε� ��ü�� ���� �� ����Ѵ�.
	// ������ Client ��ü�� selectionKey�� ÷���ϰ�, ���� �ڵ��̴�.
	
	//	[åü ÷���ϱ�]
	//	Client client = new Client(socketChannel);
	//	SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
	//	selectionKey.attach(client);	// ��ü�� ÷����
	//
	//	[÷�ε� ��ü ���]
	//	if(selectionKey.isReadable()) {
	//		Client client = (Client) selectionKey.attachment();	// ÷�ε� ��ü ���
	//		...
	//	}
	
			//	Chatting Server Implementation		ä�� ���� ����
	
	// TCP ���ŷ���� ���캸�Ҵ� ä�� ������ �ͺ��ŷ���� �����غ��鼭 ������(Selector)�� �ͺ��ŷ ServerSocketChannel �׸��� �ͺ��ŷ SocketChannel�� ��� ���Ǵ��� �����غ���.
	
			/*	Server Class Structure		���� Ŭ���� ����	*/
	
	// 01_ JavaFx ���� Ŭ������ ����� ���� Application�� ����Ѵ�.
	// 02_ �ͺ��ŷ�� �ٽ� ��ü�� Selector �ʵ带 �����Ѵ�.
	// 03_ Ŭ���̾�Ʈ ������ �����ϴ� ServerSocketChannel �ʵ带 �����Ѵ�.
	// 04_ ����� Ŭ���̾�Ʈ�� �����ϴ� List<Client> Ÿ���� connections �ʵ带 �����Ѵ�. �׸��� �����忡 ������ Vector�� �ʱ�ȭ �Ѵ�.
	// 06_ startServer()�� ���� ���� �� ȣ��Ǵ� �޼ҵ��̴�.
	// 07_ stopServer()�� ���� ���� �� ȣ��Ǵ� �޼ҵ��̴�.
	// 09_ accept()�� �۾� �����尡 ���� ���� �۾��� ó���ϱ� ���� ȣ���ϴ� �޼ҵ��̴�.
	// 11_ Client Ŭ������ ����� Ŭ���̾�Ʈ�� ǥ���ϴµ�, ������ ��� �ڵ带 �����Ѵ�.
	// 14_ UI ���� �ڵ�� ���̾ƿ��� �����ϰ� ServerExample�� �����Ѵ�.
	
	// ���� ȭ�鿡�� [start] ��ư�� Ŭ���ϸ� startServer() �޼ҵ尡 ȣ��ǰ�, [start] ��ư�� [stop] ��ư���� ����ȴ�.
	// [stop] ��ư�� Ŭ���ϸ� stopServer() �޼ҵ尡 ȣ��ǰ�, �ٽ� [start] ��ư���� ����ȴ�.
	
			/*	startServer() Method	*/
	
	// [start] ��ư�� Ŭ���ϸ� startServer() �޼ҵ尡 ����Ǵµ�, startServer() �޼��忡���� selector ����, �ͺ��ŷ ServerSocketChannel ���� �� ��Ʈ ���ε�, Selector ���,
	// �۾� ������ ���� �ڵ尡 �ʿ��ϴ�. ������ ServerSocketChannel�� Selector�� �ڽ��� �۾� ������ ����ϴ� �ڵ带 �����ش�.
	
	//	01	void startServer() {
	//	02		try {
	//	03			selector = Selector.open();	// Selector ����
	//	04			serverSocketChannel = ServerSocketChannel.open();
	//	05			serverSocketChannel.configureBlocking(false);	// �ͺ��ŷ���� ����
	//	06			serverSocketChannel.bind(new InetSocketAdderss(5001));
	//	07			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);	// Selector�� �۾� ������ ���
	//	08		} catch (Exception e) {
	//	09			if(serverSocketChannel.isOpen()) { stopServer(); }
	//	10			return;
	//	11		}
	
	// 03_ Selector�� �����Ѵ�.
	// 04_ ServerSocketChannel�� �����Ѵ�.
	// 05_ ServerSocketChannel�� �ͺ��ŷ ���� �����Ѵ�.
	// 06_ ServerSocketChannel�� 5001�� ��Ʈ�� ���ε��Ѵ�.
	// 07_ Selector�� ����ϵ� �۾� ������ OP_ACCEPT�� �����Ѵ�.
	// 09_ ���ܰ� �߻��ϸ� ServerSocketChannel�� �������� ��� stopServer()�� ȣ���Ѵ�.
	// 10_ return�� �����ؼ� startServer() ������ �ߴ��Ѵ�.
	
	// ������ �۾� ó�� �غ� �� SelectionKey�� �����ϰ�, �۾� �������� �۾� �����尡 ó���ϴ� �ڵ��̴�.
	
	//	01	Thread thread = new Thread() {	// ������ ����
	//	02		@Override
	//	03		public void run() {
	//	04			while(true) {
	//	05				try {
	//	06					int keyCount = selector.select();	// �۾� ó�� �غ� �� ä���� ���� ������ ���
	//	07					if(keyCount == 0) { continue; }
	//	08					Set<SelectionKey> selectedKeys = selector.selectedKeys();	// �۾� ó�� �غ� �� Ű�� ��� Set �÷������� ����
	//	09					Iterator<SelectionKey> iterator = selectedKeys.iterator();
	//	10					while(iterator.hasNext()) {
	//	11						SelectionKey selectionKey = iterator.next();
	//	12						if (selectionKey.isAcceptable()) {		// ���� ���� �۾��� ���
	//	13							accept(selectionKey);
	//	14						} else if (selectionKey.isReadable()) {	// �б� �۾��� ���
	//	15							Client client = (Client) selectionKey.attachment();
	//	16							client.receive(selectionKey);
	//	17						} else if (selectionKey.isWritable()) {	// ���� �۾��� ���
	//	18							Client client = (Client) selectionKey.attachment();
	//	19							client.send(selectionKey);
	//	20						}
	//	21						iterator.remove();		// ���õ� Ű�¿��� ó�� �Ϸ�� SeletionKey�� ����
	//	22					}
	//	23				} catch (Exception e) {
	//	24					if(serverSocketChannel.isOpen()) { stopServer(); }
	//	25					break;
	//	26				}
	//	27			}
	//	28		}
	//	29	};
	//	30	thread.start();
	//	31
	//	32	Platform.runLater( () -> {
	//	33		displayText("[���� ����]");
	//	34		btnStartStop.setText("stop");
	//	35	});
	//	36	}	// startServer() �޼ҵ� ��
	
	// 01_ �۾� �����带 �����Ѵ�.
	// 04_ �ݺ������� ���õ� Ű���� ��� �۾��� ó���ϱ� ���� ���� ������ �ۼ��Ѵ�.
	// 06_ �۾� ó�� �غ�� SelectionKey�� �뺸�� �ޱ� ���� ���ŷ�Ѵ�.
	// 07_ wakeup() ȣ�� �� select()�� 0�� �����ϹǷ� ������ ó������ ���ư���.
	// 08_ selectedKeys()�� ȣ���ؼ� ���õ� Ű���� ��´�.
	// 09_ ���õ� Ű���� �ݺ��ڸ� ��´�.
	// 10 ~ 11_ �ݺ��ڸ� �ݺ��ϸ鼭 SelectionKey�� �ϳ��� ������.
	// 12 ~ 13_ �۾� ������ OP_ACCEPT�� ��� accept() �޼ҵ带 �����Ѵ�.
	// 14 ~ 16_ �۾� ������ OP_READ�� ��� SelectionKey�� ÷�� ��ü�� Client�� ���� receive() �޼ҵ带 ȣ���Ѵ�.
	// 17 ~ 19_ �۾� ������ OP_WRITE�� ��� SelectionKey�� ÷�� ��ü�� Client�� ���� send() �޼ҵ带 ȣ���Ѵ�.
	// 21_ �۾� ó���� SelectionKey�� ���õ� Ű�¿��� �����Ѵ�.
	// 24 ~ 25_ ���ܰ� �߻��ϸ� ServerSocket�� �������� ��� stopServer()�� ȣ���Ѵ�.
	// 30_ �۾� �����带 �����Ѵ�.
	// 32 ~ 35_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ����ؼ� "[���� ����]"�� ����ϱ� ���� displayText()�� ȣ���Ѵ�. �׸��� [start] ��ư�� ���ڸ� [stop]���� �����Ѵ�.
	
			/*	stopServer() Method	*/
	
	// [stop] ��ư�� Ŭ���ϸ� stopServer() �޼ҵ尡 ����Ǵµ�, stopServer() �޼ҵ忡�� ����� ��� SocketChannel �ݱ�, ServerSocketChannel �ݱ�, Selector �ݱ� �ڵ尡 �ʿ��ϴ�.
	
	//	01	void stopServer() {
	//	02		try {
	//	03			Iterator<Client> iterator = connections.iterator();
	//	04			while(iterator.hasNext()) {
	//	05				Client client = iterator.next();
	//	06				client.socketChannel.close();	// ����� SocketChannel �ݱ�
	//	07				iterator.remove();
	//	08			}
	//	09			if(serverSocketChannel != null && serverSocketChannel.isOpen()) {
	//	10				serverSocketChannel.close();	// ServerSocketChannel �ݱ�
	//	11			}
	//	12			if(selector != null && selector.isOpen()) {
	//	13				selector.close();	// Selector �ݱ�
	//	14			}
	//	15			Platform.runLater( () -> {
	//	16				displayText("[���� ����]");
	//	17				btnStartStop.setText("start");
	//	18			});
	//	19		} catch (Exception e) {}
	//	20	}

	// 03_ connections �÷����� �ݺ��ڸ� ��´�.
	// 04 ~ 08_ �ݺ��ڸ� �ݺ��ϸ鼭 Client�� �ϳ��� ����, SocketChannel�� �ݰ� connections �÷��ǿ��� �����Ѵ�.
	// 09 ~ 11_ ServerSocketChannel�� null�� �ƴϰ�, �����ִٸ� �ݴ´�.
	// 12 ~ 14_ Selector�� null�� �ƴϰ�, �����ִٸ� �ݴ´�.
	// 15 ~ 18_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ����ؼ� "[���� ����]"�� ����ϱ� ���� dispalyText()�� ȣ���Ѵ�. �׸��� [stop] ��ư�� ���ڸ� [start]�� �����Ѵ�.
	
			/*	accept(SelectionKey selectionKey) Method	*/
	
	// �۾� ������� SelectionKey�� isAcceptable()�� true�� �����ϸ�, �� �۾� ������ OP_ACCEPT��� accept() �޼ҵ带 ȣ���Ѵ�. 
	// accept() �޼ҵ�� ������ �����ϰ� Client ��ü�� �����ϴ� ������ �Ѵ�.
	
	//	01	void acccept(SelectionKey selectionKey) {
	//	02		try {
	//	03			ServerSocketChannel serverSocketChannel =
	//	04				(ServerSocketChannel) selectionKey.channel();		// ServerSocketChannel ���
	//	05			SocketChannel socketChannel = serverSocketChannel.accept();	// ���� ����
	//	06			
	//	07			String message = "[���� ����: " + socketChannel.getRemoteAddress() + ": " +
	//	08				Thread.currentThread().getName() + "]";
	//	09			Platform.runLater( () -> displayText(message) );
	//	10		
	//	11			Client client = new Client(socketChannel);
	//	12			connections.add(client);
	//	13
	//	14			Platform.runLater( () -> displayText("[���� ����: " + connections.size() + "]") );
	//	15		} catch(Exception e) {
	//	16			if(serverSocketChannel.isOpen()) { stopServer(); }
	//	17		}
	//	18	}

	// 03_ SelectionKey�κ��� ServerSocketChannel�� ��´�.
	// 05_ ServerSocketChannel�� accept()�� ȣ���ϸ� ��� SocketChannel�� �����Ѵ�.
	// 07 ~ 09_ "[���� ����: Ŭ���̾�Ʈ IP: �۾��������̸�]" ���ڿ��� �����ϰ�, displayText()�� ����Ѵ�.
	// 11 ~ 12_ Client�� �����ϰ� connections �÷��ǿ� �߰��Ѵ�.
	// 14_ "[���� ����]" ���ڿ��� �����ϰ�, displayText()�� ����Ѵ�.
	// 16_ ���ܰ� �߻��ϸ� ServerSocketChannel�� �������� ��� stopServer()�� ȣ���Ѵ�.
	
			/*	Client Class	*/
	
	// ������ �ټ��� Ŭ���̾�Ʈ�� �����ϱ� ������ Ŭ���̾�Ʈ�� �����ؾ� �Ѵ�. Ŭ���̾�Ʈ���� ������ �����͸� ������ �ʿ䵵 �ֱ� ������ Client Ŭ������ �ۼ��ϰ�, 
	// ���� ���� �� ���� Client �ν��Ͻ��� �����ؼ� �����ϴ� ���� ����. Client Ŭ�������� ������ �ޱ� �� ������ �ڵ尡 �־�� �Ѵ�.
	// ������ Client Ŭ������ ������ �����ش�.
	
	//	01	class Client {
	//	02		SocketChannel socketChannel;
	//	03		String sendData;	// Ŭ���̾�Ʈ�� ���� �����͸� �����ϴ� �ʵ�
	//	04
	//	05		Client(SocketChannel socketChannel) {
	//	06			this.socketChannel = socketChannel;
	//	07			socketChannel.configureBlocking(false);
	//	08			SelectionKey selectionKey = socketChannel.register(selector,
	//	09																SelectionKey.OP_READ);		// �ͺ��ŷ���� �����ϰ� �б� �۾� �������� Selector�� ��Ͻ�Ŵ
	//	10			selectionKey.attach(this);		// SelectionKey�� �ڱ� �ڽ��� ÷�� ��ü�� ����
	//	11		}
	//	12
	//	13		void receive(SelectionKey selectionKey) { // ������ �ޱ� �ڵ� }
	//	14		void send(SelectionKey seletionKey) { // ������ ���� �ڵ� }
	//	15	}

	// 01_ Client�� ServerExample�� ���� Ŭ������ �����Ѵ�.
	// 02_ ��ſ� SocketChannel �ʵ带 �����Ѵ�.
	// 03_ Ŭ���̾�Ʈ�� ���� �����͸� ������ String �ʵ带 �����Ѵ�.
	// 05_ �����ڸ� �����Ѵ�.
	// 06_ �Ű������� SocketChannel �ʵ带 �ʱ�ȭ�Ѵ�.
	// 07_ SocketChannel�� �ͺ��ŷ ���� �����Ѵ�.
	// 08 ~ 09_ SocketChannel�� �۾� ������ Selector�� ����Ѵ�. �۾� ������ OP_READ�� �����Ѵ�.
	// 10_ SelectionKey�� ÷�� ��ü�� Client�� �����Ѵ�.
	// 13_ Ŭ���̾�Ʈ�� ���� �����͸� �ޱ� ���� receive() �޼ҵ带 �����Ѵ�.
	// 14_ �����͸� Ŭ���̾�Ʈ�� ������ ���� send() �޼ҵ带 �����Ѵ�.
	
	// ���� �ڵ�� Ŭ���̾�Ʈ�� �����͸� �޴� receive() �޼ҵ��̴�. �۾� ������� SelectionKey�� isReadable()�� true�� �����ϸ�, �� �۾� ������ OP_READ��� receive() �޼ҵ带 ȣ���Ѵ�.
	// ���ŷ ����� �ڵ�� �������� ���� ������ ������� �ʴ� ���� SocketChannel�� read() �޼ҵ尡 ��� ���ϵǴ� ���̴�.
	
	//	01	void receive(SelectionKey selectionKey) {
	//	02		try {
	//	03			ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	04
	//	05			// ������ ������ ���Ḧ ���� ��� �ڵ� IOException �߻�
	//	06			int byteCount = socketChannel.read(byteBuffer);		// ������ �ޱ�
	//	07	
	//	08			// ������ SocketChannel�� close() �޼ҵ带 ȣ���� ���
	//	09			if(byteCount == -1) {
	//	10				throw new IOException();
	//	11			}
	//	12	
	//	13			String message = "[��û ó��: " + socketChannel.getRemoteAddress() + ": " +
	//	14								Thread.currentThread().getName() + "]";
	//	15			Platform.runLater( () -> displayText(message) );
	//	16
	//	17			byteBuffer.flip();		// ���ڿ� ��ȯ
	//	18			Charset charset = Charset.forName("UTF-8");
	//	19			String data = charset.decode(byteBuffer).toString();
	//	20
	//	21			for(Client client : connections) {		// ��� Ŭ���̾�Ʈ���� ���ڿ��� �����ϴ� �ڵ�
	//	22				client.sendData = data;
	//	23				SelectionKey key = client.socketChannel.keyFor(selector);
	//	24				key.interestOps(SelectionKey.OP_WRITE);	// �۾� ���� ����
	//	25			}
	//	26			selector.wakeup();	// ����� �۾� ������ �����ϵ��� �ϱ� ���� Selector�� select() ���ŷ�� �����ǰ� �ٽ� �����ϵ��� �Ѵ�.
	//	27		} catch(Exception e) {
	//	28			try {
	//	29				connections.remove(this);
	//	30				String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " + 
	//	31									socketChannel.getRemoteAddress() + ": " +
	//	32									Thread.currentThread().getName() + "]";
	//	33				Platform.runLater( () -> displayText(message) );
	//	34				socketChannel.close();
	//	35			} catch(IOException e2) {}
	//	36		}
	//	37	}
	
	// 03_ ���� ������ ũ�Ⱑ 100�� ByteBuffer�� �����Ѵ�. 
	// 06_ SocketChannel�� read() �޼ҵ带 ȣ���Ѵ�. read()�� ��� ���ϵǴµ�, ���� �����ʹ� byteBuffer�� �����ϰ�, ���� ����Ʈ ������ �����Ѵ�.
	// 09 ~ 11_ Ŭ���̾�Ʈ�� ���������� SocketChannel�� close()�� ȣ������ ���, 6������ read() �޼ҵ�� -1�� �����Ѵ�. �� ��� IOException�� ������ �߻���Ų��.
	// 13 ~ 15_ ���������� �����͸� �޾��� ���, "[��û ó��: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����ϰ� displayText()�� ȣ���ؼ� ����Ѵ�.
	// 17 ~ 19_ ���������� �����͸� �ް� �Ǹ� ���� �����Ͱ� ����� ByteBuffer�� flip() �޼ҵ带 ȣ���ؼ� ��ġ �Ӽ����� ������ �� UTF-8�� ���ڵ��� ���ڿ��� ��´�.
	// 21_ connections �÷��ǿ� ����� Client�� �ϳ��� ������.
	// 22_ Ŭ���̾�Ʈ�� ���� ���ڿ��� Client�� �ʵ��� sendData�� �����Ѵ�.
	// 23_ Client�� ��� ä�ηκ��� SelectionKey�� ��´�.
	// 24_ ä���� �۾� ������ OP_WRITE�� �����Ѵ�.
	// 26_ Selector�� wakeup() �޼ҵ带 ȣ���Ѵ�. �� �޼ҵ尡 ȣ��Ǹ� Selector�� select() �޼ҵ尡 ���ŷ �����ǰ�, ����� �۾� ������ �����ϵ��� select() �޼ҵ尡 �ٽ� ȣ��ȴ�.
	// 29_ ���ܰ� �߻��ϸ� �ش� connections �÷��ǿ��� Client ��ü�� �����Ѵ�. ���ܴ� 6���ΰ� 10���ο��� �߻��ϴµ�, ��� Ŭ���̾�Ʈ�� ����� �� �ɶ��̴�.
	// 30 ~ 33_ "[Ŭ���̾�Ʈ ��� �ȵ�: Ŭ���̾�ƮIP: �۾��������̸�]"���� ������ ���ڿ��� �����ϰ� displayText()�� ȣ���ؼ� ����Ѵ�.
	// 34_  SocketChannel�� �ݴ´�.
	
	// ���� �ڵ�� �����͸� Ŭ���̾�Ʈ�� ������ send() �޼ҵ��̴�.
	
	//	01	void send(SelectionKey selectionKey) {
	//	02		try {
	//	03			Charset charset = Charset.forName("UTF-8");
	//	04			ByteBuffer byteBuffer = charset.encode(sendData);
	//	05			socketChannel.write(byteBuffer);	// ������ ������
	//	06			socketChannel.interestOps(SelectionKey.OP_READ);	// �۾� ���� ����
	//	07			selector.wakeup();	// ����� �۾� ������ �����ϵ��� Selector�� select() ���ŷ ����
	//	08		} catch(Exception e) {
	//	09			try {
	//	10				String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " +
	//	11									socketChannel.getRemoteAddress() + ": " +
	//	12									Thread.currentThread().getName() + "]";
	//	13				Platform.runLater( () -> displayText(message) );
	//	14				connections.remove(this);
	//	15				socketChannel.close();
	//	16			} catch (IOException e2) {}
	//	17		}
	//	18	}

	// 03 ~ 04_ Ŭ���̾�Ʈ�� ���� ���ڿ��κ��� UTF-8�� ���ڵ��� ByteBuffer�� ��´�.
	// 05_ SocketChannel�� write() �޼ҵ带 ȣ���ؼ� ByteBuffer�� ������ Ŭ���̾�Ʈ�� ������.
	// 06_ �۾� ������ OP_READ�� �����Ѵ�.
	// 07_ Selector�� wakeup() �޼ҵ带 ȣ���Ѵ�. �� �޼ҵ尡 ȣ��Ǹ� Selector�� select() �޼ҵ尡 ���ŷ �����ǰ�, ����� �۾� ������ �����ϵ��� select() �޼ҵ尡 �ٽ� ȣ��ȴ�.
	// 10 ~ 13_ 5���ο��� ���ܰ� �߻��ϸ� "[Ŭ���̾�Ʈ ��� �ȵ�: Ŭ���̾�ƮIP: �۾��������̸�]" ���� ������ ���ڿ��� �����ϰ� displayText()�� ȣ���ؼ� ����Ѵ�.
	// 14_ connections �÷��ǿ��� ���ܰ� �߻��� Client�� �����Ѵ�.
	// 15_ SocketChannel�� �ݴ´�.
	
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
	
			//	Chatting Client Implementation		ä�� Ŭ���̾�Ʈ ����
	
	// ä�� Ŭ���̾�Ʈ�� �ͺ��ŷ SocketChannel�� ����Ͽ� ������ �� ������ �ͺ��ŷ ����� �ַ� ������ ������ �� �̿��ϱ� ������ �ͺ��ŷ ����� ä�� Ŭ���̾�Ʈ ���� ������ �����Ѵ�.
	// ä�� Ŭ���̾�Ʈ�� TCP ���ŷ ä���� ä�� Ŭ���̾�Ʈ�� �״�� ����ص� �ȴ�. �ͺ��ŷ ����� ä�� Ŭ���̾�Ʈ�� ClientExample�� ���� �����ϱ� �ٶ���.
	// ä�� ������ Ŭ���̾�Ʈ ���� ����� TCP ���ŷ ä���� ä�� ������ Ŭ���̾�Ʈ ���� ����� �����ϴ�.

}
