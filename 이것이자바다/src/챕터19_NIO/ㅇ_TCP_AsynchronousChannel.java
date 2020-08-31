package é��19_NIO;

public class ��_TCP_AsynchronousChannel {
	// NIO�� TCP ���ŷ, �ͺ��ŷ ä�� �̿ܿ� TCP �񵿱� ä�η�, AsynchronousServerSocketChannel�� AsynchronousSocketChannel�� �����Ѵ�.
	// ���� ServerSocketChannel�� SocketChannel�� �����ϴ� Ŭ������ NIO�� �������� Ŭ�����̴�. �� Ŭ������ ��� ����� �˾ƺ���� ����.
	
			//	Characteristic Of Asynchronous Channel
	
	// TCP �񵿱� ä���� ���� ��û(connect()), ���� ����(accept()), �б�(read()), ����(write())�� ȣ���ϸ� ��� �����Ѵ�..
	// �̰��� �ͺ��ŷ ��İ� �����ϴ�. �������� �� �޼ҵ���� ȣ���ϸ� ������Ǯ���� �۾� ó�� ��û�ϰ� �� �޼ҵ���� ��� ���ϵȴ�. �������� �۾� ó���� ������Ǯ�� �۾� �����尡 ����Ѵ�.
	// �۾� �����尡 �۾��� �Ϸ��ϰ� �Ǹ� �ݹ�(callback) �޼ҵ尡 �ڵ� ȣ��Ǳ� ������ �۾� �Ϸ� �� �����ؾ� �� �ڵ尡 �ִٸ� �ݹ� �޼ҵ忡�� �ۼ��ϸ� �ȴ�.
	
	//	������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//	�� �񵿱� ó�� ���																	��
	//	��	|																			��
	//	��	| 1 accept() ����������������				��������������������������������������������������������������������������	��
	//	��	|���������������������� �� �񵿱�	��	3 �۾� ó��		��������Ǯ			�������������������������� ��		��	��
	//	��	|�禡������������������ ��  ä��	�ᦡ������ ��û		��				��	������ 1	�� ��		��	��
	//	��	|	2 ��� ����    ����������������	��			��			 ����	��  5 �۾� ó��	�� �� ��	��	��
	//	��	|�禡������������������������ ������ 1	��			��	4 �۾� ť	 ��	��	  ��		�� �� ��	��	��
	//	��	| 6 �ݹ� �޼ҵ� ȣ��			��			��	��������������������	�������������������������� �� ��	��	��
	//	��	| 6 �ݹ� �޼ҵ� ȣ��			�ᦡ��������������������������	�� �� �� ��	��	�������������������������� �� ��	��	��
	//	��	|�禡������������������������	������ 2	��			��	����������������������	��	������ 2	�� ��  	��	��
	//	��	|1 read/write() ������������	��			��	�� ������� ť����	��  5 �۾� ó��	�� �� ��	��	��
	//	��	|���������������������� 	���񵿱⦢	��			���۾��� ������ �����Ŵ	��	  ��		�� �� ��	��	��
	//	��	|�禡������������������ 	��ä��	 �ᦡ����		��û	��				�������������������������� ��		��	��
	//	��	|	2 ��� ����	 	������������		3 �۾� ó��	��					  :		  ��		��	��
	//	��	��									��					������ n	  ��		��	��
	//	��										��������������������������������������������������������������������������	��
	//	������������������������������������������������������������������������������������������������������������������������������������������������������������������
	
	// �׸��� �� �� �ܼ�ȭ���� �����غ���. ���ø����̼ǿ��� read() �޼ҵ带 ȣ���ϸ� ��� ���ϵ�����, ���������� ���ο����� ������Ǯ�� �۾� �����尡 read() �޼ҵ带 �����Ѵ�.
	// �۾� �����尡 read() �޼ҵ带 ��� �����ϰ� ���� �ݹ� �޼ҵ��� completed() �޼ҵ尡 �ڵ� ȣ��ȴ�. �̶� completed() �޼ҵ带 �����ϴ� ������� ������Ǯ�� �۾� �������̴�.
	
	//
	//										����������������������������������������������������������
	//										��	������Ǯ(ExecutorService)	��
	//		��������������������������	2 read() ȣ��		��		�۾� ������				��
	//		�� 1 ����	��---------------------------�榣������������������������������		��
	//		��		���---------------------------�� read() {		��		��
	//		��������������������������	��� ����			��	 ��		��		��		��
	//										��	 ��		��		��		��
	//										��	 ��		�� 3 ����	��		��
	//		������������������������������������������			��	 ��		��		��		��
	//		�� completed() �޼ҵ�	��			��	 ��		��		��		��
	//		��  5 ����	��������������������������������������������������������������������������		��		��
	//		��		��			��			��	 ��������������������������������		��
	//		������������������������������������������			����������������������������������������������������������
	
			// Asynchronous Channel Group		�񵿱� ä�� �׷�
	
	// �񵿱� �������� ä��(AsynchronousServerSocketChannel)�� �񵿱� ���� ä��(AsynchronousSocketChannel)�� ���캸�� ���� 
	// �켱 �񵿱� ä�� �׷�(AsynchronousChannelGroup)�� ���ؼ� �����غ���. �񵿱� ä�� �׷��� ���� ������Ǯ�� �����ϴ� �񵿱� ä�ε��� �����̶�� �� �� �ִ�.
	// �ϳ��� ������Ǯ�� ����Ѵٸ� ��� �񵿱� ä���� ���� ä�� �׷쿡 ���ؾ� �Ѵ�.
	
	//	������������������  �񵿱� ä�� �׷�  ��������������������������������������������������������������������������������������������������������������������������������������
	//	��	(AsynchronousChannelGroup)															��
	//	��												������Ǯ(ExecutorService)					��
	//	��												��������������������������������������������������������������������������	��
	//	��							���� ��û				��				�������������������������� ��		��	��
	//	��AsynchronousServerSocketChannel�ᦡ������ ����		��				��	������ 1	�� ��		��	��
	//	��									��			��			 ����	�� ���� ���� ó��	�� �� ��	��	��
	//	��	AsynchronousSocketChannel		��			��	   �۾� ť	 ��	��	  ��		�� �� ��	��	��
	//	��	 								��			��	��������������������	�������������������������� �� ��	��	��
	//	��	 								�ᦡ��������������������������	�� �� �� ��	��	�������������������������� �� ��	��	��
	//	��				:					��			��	����������������������	��	������ 2	�� ��  	��	��
	//	��				:					��			��	�� ������� ť����	�� ���� ���� ó��	�� �� ��	��	��
	//	��									��			���۾��� ������ �����Ŵ	��	  ��		�� �� ��	��	��
	//	��		AsynchronousSocketChannel�ᦡ����	��û		��				�������������������������� ��		��	��
	//	��									   �����		��					  :		  ��		��	��
	//	��												��					������ n	  ��		��	��
	//	��												��������������������������������������������������������������������������	��
	//	����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	
	// �񵿱� ä���� ������ �� ä�� �׷��� �������� ������ �⺻ �񵿱� ä�� �׷��� �����ȴ�. �⺻ �񵿱� ä�� �׷��� ���������� ������ ���� ������Ǯ�� �����Ѵ�.
	
	//	new ThreadPoolExceutor(
	//		0, Integer.MAX_VALUE,
	//		Long.MAX_VALUE, TimeUnit.MILLISECONDS,
	//		new SynchronousQueue<Runnable>(),
	//		threadFactory);
	
	// �̷������� Integer.MAX_VALUE����ŭ �����尡 ������ �� �ֵ��� �Ǿ� �ִ�. 
	// ������ ������Ǯ�� ��κ� �ִ� ������ ���� �����ؼ� ����ϹǷ� ������ ���� AsynchronousChannelGroup�� ���� �����ϰ� ����ϴ� ���� �Ϲ����̴�.
	
	//	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//		�ִ뽺���� ��,
	//		Executors.defaultThreadFactory()
	//	);
	
	// ������ CPU �ھ��� ����ŭ �����带 �����ϴ� ������Ǯ�� �����ϰ� �̰��� �̿��ϴ� �񵿱� ä�� �׷��� �����Ѵ�.
	
	//	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors(),
	//		Executors.defaultThreadFactroy()
	//	);
	
	// �̷��� ������ �񵿱� ä�� �׷��� �񵿱� ä���� ������ �� �Ű������� ���ȴ�. �񵿱� ä�� �׷��� �� �̻� ������� �ʰ� ������ ��쿡�� shutdown()�� shutdownNow() �޼ҵ带 ȣ���� �� �ִ�.
	
	//	channelGroup.shutdown();
	//	channelGroup.shutdownNow();
	
	// shutdown()�� �񵿱� ä�� �׷��� �����ϰڴٴ� �ǻ縸 ������ �� ��� �񵿱� ä�� �׷��� �������� �ʴ´�. �񵿱� ä�� �׷쿡 ���Ե� ��� �񵿱� ä���� ������ ��μ� ä�� �׷��� ����ȴ�.
	// shutdown() �޼ҵ带 ȣ���� ���Ŀ� ���ο� �񵿱� ä���� �񵿱� ä�� �׷쿡 ���Խ�Ű�� ShutdownChannelGroupExceptio�� �߻��Ѵ�.
	// shutdown()�� ���������� �񵿱� ä�� �׷쿡 ���Ե� ��� �񵿱� ä���� �ݾƹ����� �񵿱� ä�� �׷��� �����Ѵ�.
	// ��, �Ϸ� �ݹ��� �����ϰ� �ִ� ������� ����ǰų�, ���ͷ�Ʈ���� �ʴ´�.
	
			//	Asynchronous ServerSocket Channel
	
	// AsynchronousServerSocketChannel�� �� ���� ���� �޼ҵ��� open()�� ȣ���ؼ� ���� �� �ִ�. �⺻ �񵿱� ä�� �׷쿡 ���ԵǴ� AsynchronousServerChannel�� ��� ����� ������ ����
	// �Ű��� ���� open() �޼ҵ带 ȣ���ϴ� ���̴�.
	
	//	AsynchronousServerSocketChannel asynchronousServerSocketChannel =
	//	AsynchronousServerSocketChannel.open();
	
	// ������ �񵿱� ä�� �׷��� �����ϰ� ���⿡ ���ԵǴ� AsynchronousServerSocketChannel�� ��� �ʹٸ� ������ ���� �񵿱� ä�� �׷��� �Ű������� ���� open() �޼ҵ带 ȣ���ϸ� �ȴ�.
	
	//	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors(),
	//		Executors.defaultThreadFactory()
	//	);
	//	AsynchronousServerSocketChannel asynchronousServerSocketChannel = 
	//	AsynchronousServerSocketChannel.open(channelGroup);
	
	// AsynchronousServerSocketChannel�� �����ϰ� ������ ��Ʈ ���ε��� ���� ������ ���� bind() �޼ҵ带 ȣ���ؾ� �Ѵ�.
	
	//	asynchronousServerSocketChannel.bind(new InetSocketAddress(5001));
	
	// AsynchronousServerSocketChannel�� �� �̻� ������� ���� ��쿡�� close() �޼ҵ带 ȣ���ؼ� ������ ����� ��Ʈ�� ����ε����ش�.
	
	//	asynchronousServerSocketChannel.close();
	
	// AsynchronousServerSocketChannel�� ���� ���� �۾��� ������Ǯ�� �̿��ؼ� �񵿱�� ó���Ѵ�. ������ accept() �޼ҵ带 ȣ���ϴ� �ڵ��̴�.
	
	//	accept(A attachment, CompletionHandler<AsynchronousSocketChannel, A> handler);
	
	// ù ��° �Ű����� �ݹ� �޼ҵ��� �Ű������� ������ ÷�� ��ü�ε�, ���� ���� �۾����� ������ ÷�� ��ü�� �ʿ����� �ʱ� ������ null�� �����Ѵ�.
	// �� ��° �Ű����� �ݹ� �޼ҵ带 ������ �ִ� CompletionHandler<AsynchronousSocketChannel, A> ���� ��ü�̴�.
	// A�� ÷�� ��ü Ÿ���ε�, ���� ���� �۾����� ������ ÷�� ��ü�� �ʿ����� �ʱ� ������ Void�� �����Ѵ�. ������ accept() �޼ҵ带 ȣ���ϴ� �⺻ ���븦 �����ش�.
	
	//	asynchronousServerSocketChannel.accept(null,
	//		new CompletionHanlder<AsynchronousSocketChannel, Void>() {
	//		@Override
	//		public void completed(AsynchronousSocketChannel asynchronousSocketChannel ,
	//								Void attachment) {
	//			// ���� ���� �� ������ �ڵ�
	//			asynchronousServerSocketChannel.accept(null, this);	// accept() ��ȣ��
	//		}
	//		@Override
	//		public void failed(Throwable exc, Void attachment) {
	//			// ���� ���� ���� �� ������ �ڵ�
	//		}
	//	});
	
	// completed() �޼ҵ�� ���� ������ �Ϸ�Ǿ��� �� ������Ǯ�� �����尡 ȣ���Ѵ�. ù ��° �Ű����� ���� ���� �� ���ϵ� AsynchronousSocketChannel�� ���Եǰ�,
	// �� ��° �Ű����� ÷�� ��ü�ε� accept()�� ù ��° �Ű����� null�̹Ƿ� null�� ���Եȴ�. ���� ������Ǯ�� �����尡 ���� ������ ������ ���� ���ܸ� �߻���Ű�� failed()�� ȣ��ȴ�.
	// failed()�� ù ��° �Ű����� ���� ��ü�̰� �� ��° �Ű����� ÷�� ��ü�ε� accept()�� ù ��° �Ű����� null�̹Ƿ� null�� ���Եȴ�.
	// �ָ��� ���� accept()�� �ݺ��ؼ� ȣ���ϴ� ���� ������ ���ٴ� ���̴�. ��� completed() �޼ҵ� ���� accept()�� ��ȣ���ؼ� �ݺ������� Ŭ���̾�Ʈ�� ���� ���� �۾��� �����Ѵ�.
	
			//	Asynchronous Socket Channel
	
	// AsynchronousSocketChannel�� ������ Ŭ���̾�Ʈ�� ���� �����ϴµ�, Ŭ���̾�Ʈ�� AsynchronousSocketChannel�� �����ؼ� ������ ���� ��û�� �ϸ� ������
	// AsynchronousServerSocketChannel�� ���� ���� �� AsynchronousSocketChannel�� �����ؼ� ���� ����� �� �ֵ��� ������ش�.
	// AsynchronousServerSocketChannel�� �����ϴ� AsynchronousSocketChannel�� �ڵ������� AsynchronousServerSocketChannel�� ���� �񵿱� ä�� �׷쿡 ���ϰ� �ȴ�.
	// Ŭ���̾�Ʈ���� AsynchronousSocketChannel�� �����Ϸ��� �� ���� open() �޼ҵ带 ����� �� �ִ�. �⺻ �񵿱� ä�ο� ���ԵǴ� AsynchronousSocketChannel�� ��� �ʹٸ�
	// �Ű������� open() �޼ҵ带 ȣ���ϸ� �ȴ�.
	
	//	AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open();
	
	// ������ �񵿱� ä�� �׷��� �����ϰ� ���⿡ ���ԵǴ� AsynchronousSocketChannel�� ��� �ʹٸ� ������ ���� �񵿱� ä�� �׷��� �Ű������� ���� open() �޼ҵ带 ȣ���ϸ� �ȴ�.
	
	//	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors();
	//		Executors.defaultThreadFactory()
	//	);
	//	AsynchronousSocketChannel asynchronousSocketChannel = 
	//	AsynchronousSocketChannel.open(channelGroup);
	
	//	AsynchronousSocketChannel�� �� �̻� ������� ���� ��쿡�� close() �޼ҵ带 ȣ���ؼ� ������ �����ش�.
	
	//	asynchronousSocketChannel.close();
	
	// Ŭ���̾�Ʈ�� �����ϴ� AsynchronousSocketChannel�� ���� ��û �۾��� ������Ǯ�� �̿��ؼ� �񵿱�� ó���Ѵ�. ������ connect() �޼ҵ带 ȣ���ϴ� �ڵ��̴�.
	
	//	connect(SocketAddress remote, A attachment, CompletionHandler<Void, A> handler);
	
	// ù ��° �Ű����� ���� IP�� ���� ��Ʈ ������ ���� InetSocketAddress ��ü�̴�. �� ��° �Ű����� �ݹ� �޼ҵ��� �Ű������� ������ ÷�� ��ü�ε�, 
	// ���� ��û �۾����� ������ ÷�� ��ü�� �ʿ����� �ʱ� ������ null�� �����Ѵ�. �� ��° �Ű����� CompletionHandler<Void, A> ���� ��ü�̴�. 
	// A�� ÷�� ��ü Ÿ���ε�, ���� ��û �۾����� ������ ÷�� ��ü�� �ʿ����� �ʱ� ������ Void�� �����Ѵ�.
	// ������ connect() �޼ҵ带 ȣ���ϴ� �⺻ ���븦 �����ش�.
	
	//	asynchronousSocketChannel.connect(new InetSocketAddress("localhost", 5001), null,
	//		new CompletionHandler<Void, Void>() {
	//			@Override
	//			public void completed(Void result, Void attachment) {
	//				// ���� ���� �� ������ �ڵ�
	//			}
	//			@Override
	//			public void failed(Throwable e, Void attachment) {
	//				// ���� ���� �� ������ �ڵ�
	//			}
	//		});
	//
	
	// completed() �޼ҵ�� ������ �������� �� ������Ǯ�� �����带 ȣ���Ѵ�. ù ��° �Ű����� null�� ���Եǰ�, �� ��° �Ű����� ÷�� ��ü�ε� connect()�� �� ��° �Ű����� null�̹Ƿ� null�� ���Եȴ�.
	// completed() �޼ҵ忡�� ������ ���� �����͸� �ޱ� ���� ��尡 �Ϲ������� �ۼ��ȴ�. ���� ������Ǯ�� �����尡 ���� ��û�� ������ ���� ���ܰ� �߻��Ǹ� failed()�� ȣ��ȴ�.
	// ù ��° �Ű����� ���� ��ü�̰�, �� ��° �Ű����� ÷�� ��ü�ε� connect()�� �� ��° �Ű����� null�̹Ƿ� null�� ���Եȴ�.
	
			//	Asynchronous Socket Channel Data Communication
	
	// Ŭ���̾�Ʈ�� ������ ����Ǹ� ���� AsynchronousSocketChannel�� read()�� write() �޼ҵ�� ������ ����� �� �� �ִ�.
	// �� �޼ҵ���� ȣ���ϴ� ��� ���ϵǰ�, �������� ����� �۾��� ������Ǯ�� �����尡 ����Ѵ�. ������ read()�� write()�� ȣ���ϴ� �ڵ��̴�.
	
	//	read(ByteBuffer dst, A attachment, CompletionHandler<Integer, A> handler);
	//	write(ByteBuffer src, A attachment, CompletionHandler<Integer, A> handler);
	
	// ù ��° �Ű����� �а� ���� ���� ByteBuffer ��ü�̴�. �� ��° �Ű����� �ݹ� �޼ҵ��� �Ű������� ������ ÷�� ��ü�̴�. �� ��° �Ű����� CompletionHandler<Integer, A> ���� ��ü�̴�.
	// Integer�� �а� �� ����Ʈ ���̰�, A�� ÷�� ��ü Ÿ���̴�. ������ read() �޼ҵ带 ȣ���ϴ� �⺻ ���븦 �����ش�.
	
	//	asynchronousSocketChannel.read(byteBuffer, attachment,
	//		new CompletionHandler<Integer, A>() {
	//		@Override
	//		public void completed(Integer result, A attachment) {
	//			// ���� �����͸� ó���ϴ� �ڵ�
	//			asynchronousSocketChannel.read(byteBuffer, attachment, this);
	//		}
	//		@Override
	//		public void failed(Throwable exc, A attachment) {
	//			// ���е� ��� ������ �ڵ�
	//		}
	//	});	
	
	// ������Ǯ�� �۾� �����尡 �б� �۾��� �Ϸ��ϸ� completed() �޼ҵ带 ȣ���Ѵ�. ù ��° �Ű����� ���� ����Ʈ ���̰�, �� ��° �Ű����� ÷�� ��ü�ε� read() �޼ҵ� ȣ�� �� ���� �� ��° �Ű����� ���Եȴ�.
	// ���� ������Ǯ�� �۾� �����忡�� �б� �۾� ���� ������ ���� ���ܰ� �߻��ϸ� ������� failed() �޼ҵ带 ȣ���Ѵ�. ù ��° �Ű����� ���� ��ü�̰�, 
	// �� ��° �Ű����� ÷�� ��ü�ε� read() �޼ҵ� ȣ�� �� ���� �� ��° �Ű����� ���Եȴ�. �ָ��� ���� read()�� �ݺ��ؼ� ȣ���ϴ� ���� ������ ���ٴ� ���̴�.
	// ��� completed() �޼ҵ� ���� read()�� ��ȣ���ؼ� �ݺ������� �����͸� �޴� �۾��� �����Ѵ�. ������ write() �޼ҵ带 ȣ���ϴ� �⺻ ���븦 �����ش�.
	
	//	asynchronousSocketChannel.write(byteBuffer, attachment,
	//		new CompletionHandler<Integer, A>() {
	//		@Override
	//		public void completed(Integer result, A attachment) {
	//			// ������ ��� ������ �ڵ�
	//		}
	//		@Override
	//		public void failed(Throwable exc, A attachment) {
	//			// ���е� ��� ������ �ڵ�
	//		}
	//	});
	
	// ������Ǯ�� �۾� �����尡 ���� �۾��� �Ϸ��ϸ� completed() �޼ҵ带 ȣ���Ѵ�. ù ��° �Ű����� ����� ����Ʈ ���̰�, �� ��° �Ű����� ÷�� ��ü�ε� write() �޼ҵ� ȣ�� �� ���� �� ��° �Ű����� ���Եȴ�.
	// ���� ������Ǯ�� �۾� �����忡�� ���� �۾� ���� ������ ���� ���ܰ� �߻��ϸ� ������� failed() �޼ҵ带 ȣ���Ѵ�. 
	// ù ��° �Ű����� ���� ��ü�̰� �� ��° �Ű����� ÷�� ��ü�ε� write() �޼ҵ� ȣ�� �� ���� �� ��° �Ű����� ���Եȴ�.
	
			//	Chatting Server Implementation		ä�� ���� ����
	
	// TCP ���ŷ�� �ͺ��ŷ���� ���캸�Ҵ� ä�� ������ �񵿱� ä�η� �����غ��鼭 AsynchronousServerSocketChannel�� AsynchronousSocketChannel�� ��� ���Ǵ��� �����غ���.
	
			/*	Server Class Structure		���� Ŭ���� ����	*/
	
	// 01_ JavaFX ���� Ŭ������ ����� ���� Application�� ��ӹ޴´�.
	// 02_ �񵿱� ä�� �׷��� AsynchronousChannelGroup �ʵ带 �����Ѵ�.
	// 03_ Ŭ���̾�Ʈ ������ �����ϴ� AsynchronousServerSocketChannel �ʵ带 �����Ѵ�.
	// 04_ ����� Ŭ���̾�Ʈ�� �����ϴ� List<Client> Ÿ���� connections �ʵ带 �����Ѵ�. �׸��� �����忡 ������ Vector�� �ʱ�ȭ�ߴ�.
	// 06_ startServer()�� ���� ���� �� ȣ��Ǵ� �޼ҵ��̴�.
	// 07_ stopServer()�� ���� ���� �� ȣ��Ǵ� �޼ҵ��̴�.
	// 09_ Client Ŭ������ ����� Ŭ���̾�Ʈ�� ǥ���ϴµ�, ������ ��� �ڵ带 �����Ѵ�.
	// 12_ UI ���� �ڵ�� ���̾ƿ��� �����ϰ� ServerExample�� �����Ų��.
	
	// ����ȭ�鿡�� [start] ��ư�� Ŭ���ϸ� startServer() �޼ҵ尡 ȣ��ǰ�, [start] ��ư�� [stop] ��ư���� ����ȴ�.
	// [stop] ��ư�� Ŭ���ϸ� stopServer() �޼ҵ尡 ȣ��ǰ�, [start] ��ư�� �ٽ� �����Ѵ�.
	
			/*	startServer() Method	*/
	
	// [start] ��ư�� Ŭ���ϸ� startServer() �޼ҵ尡 ����Ǵµ�, startServer() �޼ҵ忡�� AsynchronousChannelGroup ����, AsynchronousServerSocketChannel ���� ��
	// ��Ʈ ���ε�, ���� ���� �ڵ尡 �־�� �Ѵ�. ������ CPU �ھ��� ����ŭ �����带 �����ϴ� ������Ǯ�� �����ϰ� �̰��� �̿��ϴ� �񵿱� ä�� �׷��� �����Ѵ�.
	
	//	01	void startServer() {
	//	02		try {
	//	03			channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//	04				Runtime.getRuntime().availableProcessors(),
	//	05				Executors.defaultThreadFactory()
	//	06			);

	// ������ 5001�� ��Ʈ���� Ŭ���̾�Ʈ�� ������ �����ϴ� AsynchronousServerSocketChannel�� �����Ѵ�.
	
	//	01			serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
	//	02			serverSocketChannel.bind(new InetSocketAddress(5001));
	//	03		} catch(Exception e) {
	//	04			if(serverSocketChannel.isOpen()) { stopServer(); }
	//	05			return;
	//	06		}
	//	07		Platform.runLater( () -> {
	//	08			displayText("[���� ����]");
	//	09			btnStartStop.setText("stop");
	//	10		});
	
	// 04 ~ 05_ 5001�� ��Ʈ�� �̹� �ٸ� ���α׷����� ����ϰ� �ִٸ� java.net.BindException�� �߻��Ѵ�. �� ��� AsynchronousServerSocketChannel�� ���� �ִ��� Ȯ���ϰ�,
	//			stopServer() �޼ҵ带 �����Ѵ�. �׸��� return�� �����ؼ� startServer() �޼ҵ带 �����Ѵ�.
	// 07 ~ 10_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ���Ǿ���. "[���� ����]"�� ����ϵ��� displayText()�� ȣ���ϰ�, [start] ��ư�� ���ڸ� [stop]���� �����Ѵ�.
	
	// ������ ���� ���� �۾��� �ϱ� ���� accpet() �޼ҵ带 ȣ���ϴ� �ڵ��̴�.
	
	//	01	serverSocketChannel.accept(null,
	//	02		new CompletionHandler<AsynchronousSocketChannel, Void>() {
	//	03		@Override
	//	04		public void completed(AsynchronousSocketChannel socketChannel,
	//	05			Void attachment) {
	//	06			try {
	//	07				String message = "[���� ����: " + socketChannel.getRemoteAddress() + ": " +
	//	08									Thread.currentThread() + "]";
	//	09				Platform.runLater( () -> displayText(message) );
	//	10			} catch (IOException e) {}
	//	11
	//	12			Client client = new Client(socketChannel);		// Client ��ü ����
	//	13			connections.add(client);
	//	14			Platform.runLater( () -> displayText("[���� ����: " + connections.size() + "]") );
	//	15
	//	16			serverSocketChannel.accept(null, this);		// accept() �ٽ� ȣ��
	//	17		}
	//	18		@Override
	//	19		public void failed(Throwable exc, Void attachment) {
	//	20			if(serverSocketChannel.isOpen()) { stopServer(); }
	//	21		}
	//	22	});	// accept() �޼ҵ� ��
	//	23	}	// startServer() �޼ҵ� ��

	// 01 ~ 02_ ���� ������ ���� accept() �޼ҵ带 ȣ���Ѵ�. ù ��° �Ű����� ÷�� ��ü�� null�� �ְ�, 
	//			�� ��° �Ű����� CompletionHandler<AsynchronousSocketChannel, Void> Ÿ���� �͸� ��ü�� �ش�.
	//			AsynchronousSocketChannel�� ��� Ÿ���̰�, Void�� ÷�� Ÿ���ε� ÷�ΰ� ���� ������ Void�̴�.
	// 04_ ���� ���� �۾��� �����Ǿ��� �� �ݹ�Ǵ� completed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� ��� Ÿ���� AsynchronousSocketChannel�̰�, �� ��° �Ű� Ÿ���� Void�̴�.
	// 07 ~ 09_ "[���� ����: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ���ڿ��� �����ϰ�, ����ϱ� ���� displayText()�� ȣ���Ѵ�.
	// 12 ~ 13_ Client ��ü�� �����ϰ� connections �÷��ǿ� �߰��Ѵ�.
	// 14_ "[���� ����: ���� �����ǰ� �ִ� Client ��ü ��]"�� ���ڿ��� �����ϰ� ����ϱ� ���� displayText()�� ȣ���Ѵ�.
	// 16_ accept() �޼ҵ带 ��ȣ���Ѵ�.
	// 19_ ���� ���� �۾��� ���еǾ��� �� �ݹ�Ǵ� failed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� Throwable�̰�, �� ��° �Ű� Ÿ���� ÷�� Ÿ���� Void �̴�.
	// 20_ AsynchronousServerSocketChannel�� ���� �ִٸ� stopServer()�� ȣ���Ѵ�.
	
			/*	stopServer() Method	*/
	
	// [stop] ��ư�� Ŭ���ϸ� stopServer() �޼ҵ尡 ����Ǵµ�, stopServer() �޼ҵ忡�� ��� �񵿱� ä�� �ݱ�, �񵿱� ä�� �׷� ���� �ڵ尡 �־�� �Ѵ�.
	
	//	01	void stopServer() {
	//	02		try {
	//	03			connections.clear();
	//	04			if(channelGroup != null && !channelGroup.isShutdown()) {
	//	05				channelGroup.shutdownNow();		// �񵿱� ä�� �׷� ����(��� �񵿱� ä���� ����)
	//	06			}
	//	07			Platform.runLater( () -> {
	//	08				displayText("[���� ����]");
	//	09				btnStartStop.setText("start");
	//	10			});
	//	11		} catch (Exception e) {}
	//	12	}
	
	// 03_ connections �÷��ǿ� ����Ǿ� �ִ� ��� Client�� �����Ѵ�.
	// 04 ~ 06_ �񵿱� ä�� �׷��� null�� �ƴϰ�, ������� �ʾҴٸ� shutdownNow()�� ȣ���ؼ� ���������� �񵿱� ä�� �׷쿡 ���Ե� ��� �񵿱� ä���� �ݾƹ����� �񵿱� ä�� �׷��� �����Ѵ�.
	// 07 ~ 10_ �۾� ������� UI�� �������� ���ϹǷ� Platform.runLater()�� ���Ǿ���."[���� ����]"�� ����ϵ��� displayText()�� ȣ���ϰ� [stop] ��ư�� ���ڸ� [start]�� �����Ѵ�.
	
			/*	Client Class	*/
	
	// ������ �ټ��� Ŭ���̾�Ʈ�� �����ϱ� ������ Ŭ���̾�Ʈ�� �����ؾ� �Ѵ�. Ŭ���̾�Ʈ���� ������ �����͸� ������ �ʿ䵵 �ֱ� ������ Client Ŭ���� �ۼ��ϰ�, 
	// ���� ���� �� ���� Client �ν��Ͻ��� �����ؼ� �����ϴ� ���� ����. Client Ŭ�������� ������ �ޱ� �� ������ �ڵ尡 �־�� �Ѵ�. ������ Client Ŭ������ ������ �����ش�.
	
	//	01	class Client {
	//	02		AsynchronousSocketChannel socketChannel;
	//	03
	//	04		Client(AsynchronousSocketChannel socketChannel) {
	//	05			this.socketChannel = socketChannel;
	//	06			receive();
	//	07		}
	//	08
	//	09		void receive() { // ������ �ޱ� �ڵ� }
	//	10		void send(String data) { // ������ ���� �ڵ� }
	//	11	}

	// 01_ Client�� ServerExample�� ���� Ŭ������ �����Ѵ�.
	// 02_ ��ſ� AsynchronousSocketChannel�� �ʵ�� �����Ѵ�.
	// 04 ~ 07_ Client �����ڸ� �����Ѵ�. �Ű������� AsynchronousSocketChannel �ʵ带 �ʱ�ȭ �ϰ� receive()�� ȣ���Ѵ�.
	// 09_ Ŭ���̾�Ʈ�� �����͸� �ޱ� ���� receive() �޼ҵ带 �����Ѵ�.
	// 10_ �����͸� Ŭ���̾�Ʈ�� ������ ���� send() �޼ҵ带 �����Ѵ�.
	
	// ���� �ڵ�� Ŭ���̾�Ʈ���� ���� �����͸� �޴� receive() �޼ҵ��̴�.
	
	//	01	void receive() {
	//	02		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	03		socketChannel.read(byteBuffer, byteBuffer,
	//	04			new CompletionHandler<Integer, ByteBuffer>() {
	//	05			@Override
	//	06			public void completed(Integer result, ByteBuffer attachment) {
	//	07				try {
	//	08					String message = "[��û ó��: " + socketChannel.getRemoteAddress() + ": " +
	//	09										Thread.currentThread().getName() + "]";
	//	10					Platform.runLater( () -> displayText(message) );
	//	11
	//	12					attachment.flip();		// ���ڿ� ��ȯ
	//	13					Charset charset = Charset.forName("UTF-8");
	//	14					String data = charset.decode(attachment).toString();
	//	15	
	//	16					for(Client client : connections) {	// ��� Ŭ���̾�Ʈ���� ������
	//	17						client.send(data);	
	//	18					}
	//	19
	//	20					ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	21					socketChannel.read(byteBuffer, byteBuffer, this);	// �ٽ� ������ �б�
	//	22				} catch(Exception e) {}
	//	23			}
	//	24			@Override
	//	25			public void failed(Throwable exc, ByteBuffer attachment) {
	//	26				try {
	//	27					String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " + 
	//	28										socketChannel.getRemoteAddress() + ": " +
	//	29										Thread.currentThread().getName() + "]";
	//	30					Platform.runLater( () -> displayText(message) );
	//	31					connections.remove(Client.this);
	//	32					socketChannel.close();
	//	33				} catch (IOException e) {}
	//	34			}
	//	35		});
	//	36	}
	
	// 02_ 100���� ����Ʈ�� ������ �� �ִ� ByteBuffer�� �����Ѵ�.
	// 03 ~ 04_ read()�� ȣ���Ѵ�. ù ��° �Ű����� ���� �����͸� ������ ByteBuffer�̰�, �� ��° �Ű����� �ݹ� �޼ҵ��� �Ű������� ������ ÷�� ��ü�� ByteBuffer�̴�. 
	//			ù ��° �Ű����� �� ��° �Ű����� ������ ByteBuffer�̴�. �� ��° �Ű����� CompletionHandler<Integer, ByteBuffer> ��ü�̴�.
	//			��� Ÿ���� Integer�̰�, ÷�� Ÿ���� ByteBuffer�̴�.
	// 06_ �б� �۾��� �����Ǿ��� �� �ݹ�Ǵ� completed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� ��� Ÿ���� Integer�̰�, �� ��° �Ű� Ÿ���� ÷�� Ÿ���� ByteBuffer�̴�.
	// 08 ~ 10_ "[��û ó��: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����ϰ� displayText()�� ȣ���ؼ� ����Ѵ�.
	// 12 ~ 14_ ÷�� ��ü�� ByteBuffer�� flip() �޼ҵ带 ȣ���ؼ� ��ġ �Ӽ����� ������ �� UTF-8�� ���ڵ��� ���ڿ��� ��´�.
	// 16 ~ 18_ ���ڿ��� ��� Ŭ���̾�Ʈ���� ������ ���� connections�� ����� Client�� �ϳ��� ��� send() �޼ҵ带 ȣ���Ѵ�.
	// 20 ~ 21_ 100���� ����Ʈ�� ������ �� �ִ� ByteBuffer�� �����ϰ� read()�� ��ȣ���Ѵ�.
	// 25_ �б� �۾��� ���еǾ��� �� �ݹ�Ǵ� failed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� Throwable�̰�, �� ��° �Ű� Ÿ���� ÷�� Ÿ���� ByteBuffer�̴�.
	// 27 ~ 30_ "[Ŭ���̾�Ʈ ��� �ȵ�: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����ϰ� displayText()�� ȣ���ؼ� ����Ѵ�.
	// 31_ connections �÷��ǿ��� Client ��ü�� �����Ѵ�.
	// 32_ AsynchronousSocketChannel�� �ݴ´�.
	
	// ���� �ڵ�� �����͸� Ŭ���̾�Ʈ�� ������ send() �޼ҵ��̴�.
	
	//	01	void send(String data) {
	//	02		Charset charset = Charset.forName("UTF-8");
	//	03		ByteBuffer byteBuffer = charset.encode(data);
	//	04		socketChannel.write(byteBuffer, null,
	//	05			new CompletionHandler<Integer, Void>() {
	//	06			@Override
	//	07			public void completed(Integer result, Void attachment) {
	//	08			}
	//	09			@Override
	//	10			public void failed(Throwable exc, Void attachment) {
	//	11				try {
	//	12					String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " +
	//	13										socketChannel.getRemoteAddress() + ": " + 
	//	14										Thread.currentThread().getName() + "]";
	//	15					Platform.runLater( () -> displayText(message) );
	//	16					connections.remove(Client.this);
	//	17					socketChannel.close();
	//	18				} catch(IOException e) {}
	//	19			}
	//	20		});
	//	21	}
	
	// 02 ~ 03_ send() �Ű����� ���� ���ڿ��κ��� UTF-8�� ���ڵ��� ByteBuffer�� ��´�.
	// 04 ~ 05_ write()�� ȣ���Ѵ�. ù ��° �Ű����� �����Ͱ� �ִ� ByteBuffer�̰�, �� ��° �Ű����� �ݹ� �޼ҵ��� �Ű������� ������ ÷�� ��ü�ε� ���� �۾����� ÷�� ��ü�� �ʿ����� �ʱ� ������ null�� �����Ѵ�.
	//			�� ��° �Ű����� CompletionHandler<Integer, Void> ��ü�̴�. ��� Ÿ���� Integer�̰�, ÷���� ��ü�� �����Ƿ� ÷��Ÿ���� Void�̴�.
	// 07_ ���� �۾��� �����Ǿ��� �� �ݹ�Ǵ� completed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� ��� Ÿ���� Integer�̰� �� ��° �Ű� Ÿ���� ÷�� Ÿ���� Void�̴�.
	// 10_ ���� �۾��� ���еǾ��� �� �ݹ�Ǵ� failed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� Throwable�̰�, �� ��° �Ű� Ÿ���� ÷�� Ÿ���� Void�̴�.
	// 12 ~ 15_ "[Ŭ���̾�Ʈ ��� �ȵ�: Ŭ���̾�Ʈ IP: �۾��������̸�]"���� ������ ���ڿ��� �����ϰ� displayText()�� ȣ���ؼ� ����Ѵ�.
	// 16_ connections �÷��ǿ��� Client ��ü�� �����Ѵ�.
	// 17_ AsynchronousSocketChannel�� �ݴ´�.
	
			/*	UI Code	*/
	
	// UI ���� �ڵ�� TCP ���ŷ ä���� ä�� ������ �����ϴ�.
	
			//	Chatting Client Implementation		ä�� Ŭ���̾�Ʈ ����
	
	// ������ Ŭ���̾�Ʈ Ŭ������ ������ �����ش�.
	
	// 01_ JavaFX ���� Ŭ������ ����� ���� Application�� ����Ѵ�.
	// 02_ �񵿱� ä�� �׷��� AsynchronousChannelGroup �ʵ带 �����Ѵ�.
	// 03_ ���� ��û�� �ϴ� AsynchronousSocketChannel �ʵ带 �����Ѵ�.
	// 05_ startClient() �޼ҵ�� [start] ��ư�� Ŭ���ϸ� ȣ��ȴ�.
	// 06_ stopClient() �޼ҵ�� [stop] ��ư�� Ŭ���ϸ� ȣ��ȴ�.
	// 07_ receive() �޼ҵ�� �������� ���� �����͸� ������.
	// 08_ send() �޼ҵ�� [send] ��ư�� Ŭ���ϸ� ȣ��Ǵµ�. �����͸� ������ ������.
	// 11_ UI ���� �ڵ�� ���̾ƿ��� �����ϰ� ClientExample�� �����Ų��.
	
	// ����ȭ�鿡�� [start] ��ư�� Ŭ���ϸ� startClient() �޼ҵ尡 ȣ��ǰ�, [start] ��ư�� [stop] ��ư���� ����ȴ�.
	//  [stop] ��ư�� Ŭ���ϸ� stopClient() �޼ҵ尡 ȣ��ǰ�, [start] ��ư���� �ٽ� ����ȴ�.
	
			/*	startClient() Method	*/
	
	// [start] ��ư�� Ŭ���ϸ� startClient() �޼ҵ尡 ����Ǵµ�, startClient() �޼ҵ忡�� AsynchronousChannelGroup ����,
	// AsynchronousSocketChannel ���� �� ���� ��û �ڵ尡 �־�� �Ѵ�. ������ CPU �ھ��� ����ŭ �����带 �����ϴ� ������Ǯ�� �����ϰ� �̰��� �̿��ϴ� �񵿱� ä�� �׷��� �����Ѵ�.
	
	//	01	void startClient() {
	//	02		try {
	//	03			ChannelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//	04				Runtime.getRuntime().availableProcessors(),
	//	05				Executors.defaultThreadFactory()
	//	06			);
	
	// ������ AsynchronousSocketChannel�� �����ϰ� ���� 5001���� ���� ��û�� �ϴ� �ڵ��̴�.
	
	//	01			socketChannel = AsynchronousSocketChannel.open(channelGroup);
	//	02			socketChannel.connect(new InetSocketAddress("localhost", 5001), null,
	//	03				new CompletionHandler<Void, Void>() {
	//	04				@Override
	//	05				public void completed(Void result, Void attachment) {
	//	06					Platform.runLater( () -> {
	//	07						try {
	//	08							displayText("[���� �Ϸ�: " + socketChannel.getRemoteAddress() + "]");
	//	09							btnConn.setText("stop");
	//	10							btnSend.setDisable(false);
	//	11						} catch (Exception e) {}
	//	12					});
	//	13					receive();	// ������ ���� ������ �ޱ�
	//	14				}
	//	15				@Override
	//	16				public void failed(Throwable exc, Void attachment) {
	//	17					Platform.runLater( () -> displayText("[���� ��� �ȵ�]") );
	//	18					if(socketChannel.isOpen()) { stopClient(); }
	//	19				}
	//	20			});
	//	21		} catch (IOException e) {}
	//	22	} // startClient() ��

	// 01_ AsynchronousSocketChannel�� �����Ѵ�.
	// 02_ ���� 5001�� ��Ʈ�� ���� ��û�� �ϱ� ���� connect()�� ȣ���Ѵ�. ù ��° �Ű����� ���� IP�� ���� ��Ʈ ������ ���� InetSocketAddress ��ü�̴�.
	// 05_ ���� ��û �۾��� �����Ǿ��� �� �ݹ�Ǵ� completed()�� �������Ѵ�. ù ��° �Ű� Ÿ�԰� �� ��° �Ű� Ÿ���� ��� ���� Void�� �����Ѵ�.
	// 06_ UI�� �����ϱ� ���� Platform.runLater()�� ���Ǿ���.
	// 08_ "[���� �Ϸ�: ����IP]"�� ������ ���ڿ��� �����ϰ� displayText()�� ����Ѵ�
	// 09 ~ 10_ [start] ��ư�� ���ڸ� [stop]���� �����Ѵ�. �׸��� [send] ��ư�� Ȱ��ȭ�Ѵ�.
	// 13_ ������ �����͸� �ޱ� ���� receive() �޼ҵ带 ȣ���Ѵ�.
	// 16_ ���� ��û �۾��� ���еǾ��� �� �ݹ�Ǵ� failed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� Throwable�̰�, �� ��° �Ű� Ÿ���� Void�̴�.
	// 17_ "[���� ��� �ȵ�]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 18_ AsynchronousSocketChannel�� ���������� stopClient() �޼ҵ带 ȣ���Ѵ�.
	
			/*	stopClient() Method	*/
	
	//	01	void stopClient() {
	//	02		try {
	//	03			Platform.runLater( () -> {
	//	04				displayText("[���� ����]");
	//	05				btnConn.setText("start");
	//	06				btnSend.setDisable(true);
	//	07			});
	//	08			if(channelGroup != null && !channelGroup.isShutdown()) {
	//	09				channelGroup.shutdownNow();
	//	10			}
	//	11		} catch (IOException e) {}
	//	12	}
	
	// 03_ UI�� �����ϱ� ���� Platform.runLater()�� ���Ǿ���.
	// 04_ "[���� ����]"�� ����ϵ��� displayText()�� ȣ���Ѵ�.
	// 05_ [stop] ��ư�� ���ڸ� [start]�� �����Ѵ�.
	// 06_ [send] ��ư�� ��Ȱ��ȭ�Ѵ�.
	// 08 ~ 10_ �񵿱� ä�� �׷��� null�� �ƴϰ�, ������� �ʾҴٸ� shutdownNow()�� ȣ���ؼ� ���������� �񵿱� ä�� �׷쿡 ���Ե� ��� �񵿱� ä���� �ݾƹ����� �񵿱� ä�� �׷��� �����Ѵ�.
	
			/*	receive() Method	*/
	
	// receive() �޼ҵ�� �������� ���� �����͸� �޴� ������ �Ѵ�. �� �޼ҵ�� startClient()���� connect()�� �������� �� �ݹ�Ǵ� completed() ������ ȣ���Ѵ�.
	
	//	01	void receive() {
	//	02		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	03		socketChannel.read(byteBuffer, byteBuffer,
	//	04			new CompletionHandler<Integer, ByteBuffer>() {
	//	05			@Override
	//	06			public void completed(Integer result, ByteBuffer attachment) {
	//	07				try {
	//	08					attachment.flip();
	//	09					Charset charset = Charset.forName("UTF-8");
	//	10					String data = charset.decode(attachment).toString();
	//	11					Platform.runLater( () -> displayText("[�ޱ� �Ϸ�] " + data) );
	//	12					
	//	13					ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	14					socketChannel.read(byteBuffer, byteBuffer, this);	// �ٽ� ������ �б�
	//	15				} catch(Exception e) {}
	//	16			}
	//	17			@Override
	//	18			public void failed(Throwable exc, ByteBuffer attachment) {
	//	19				Platform.runLater( () -> displayText("[���� ��� �ȵ�]") );
	//	20				stopClient();
	//	21			}
	//	22		});
	//	23	}
	
	// 02_ ���� �����͸� ������ ���̰� 100�� ByteBuffer�� �����Ѵ�.
	// 03 ~ 04_ read()�� ȣ���Ѵ�. ù ��° �Ű����� ���� �����͸� ������ ByteBuffer�̰�, �� ��° �Ű������ݹ� �޼ҵ��� �Ű������� ������ ÷�� ��ü�� ByteBuffer�̴�.
	//			ù ��° �Ű����� �� ��° �Ű����� ������ ByteBuffer�̴�. �� ��° �Ű����� CompletionHandler<Integer, ByteBuffer> ��ü�̴�.
	//			��� Ÿ���� Integer�̰�, ÷�� Ÿ���� ByteBuffer�̴�.
	// 06_ �б� �۾��� �����Ǿ��� �� �ݹ�Ǵ� completed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� ��� Ÿ���� Integer�̰�, �� ��° �Ű� Ÿ���� ÷�� Ÿ���� ByteBuffer�̴�.
	// 08 ~ 11_ ÷�� ��ü�� ByteBuffer�� flip() �޼ҵ带 ȣ���ؼ� ��ġ �Ӽ����� ������ �� UTF-8�� ���ڵ��� ���ڿ��� ��´�. �׸��� ���ڿ��� ����ϱ� ���� displayText()�� ȣ���Ѵ�.
	// 13 ~ 14_ 100���� ����Ʈ�� ������ �� �ִ� ByteBuffer�� �����ϰ� read()�� ��ȣ���Ѵ�.
	// 18_ �б� �۾��� ���еǾ��� �� �ݹ�Ǵ� failed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� Throwable�̰�, �� ��° �Ű� Ÿ���� ÷�� Ÿ���� ByteBuffer�̴�.
	// 19_ "[���� ��� �ȵ�]" ���ڿ��� ����ϱ� ���� displayText()�� ȣ���Ѵ�.
	// 20_ stopClient()�� ȣ���Ѵ�.
	
			/*	send(String data) Method	*/
	
	// send(String data) �޼ҵ�� ����ڰ� �޼����� �Է��ϰ� [send] ��ư�� Ŭ���ϸ� �޼����� �Ű������� �ؼ� ȣ��ȴ�.
	// send() �޼ҵ�� �޼����� ������ ������ ������ �Ѵ�.
	
	//	01	void send(String data) {
	//	02		Charset charset = Charset.forName("UTF-8");
	//	03		ByteBuffer byteBuffer = charset.encode(data);
	//	04		socketChannel.write(byteBuffer, null, new CompletionHandler<Integer, Void>() {
	//	05			@Override
	//	06			public void completed(Integer result, Void attachment) {
	//	07				Platform.runLater( () -> displayText("[������ �Ϸ�]") );
	//	08			}
	//	09			@Override
	//	10			public void failed(Throwable exc, Void attachment) {
	//	11				Platform.runLater( () -> displayText("[���� ��� �ȵ�]") );
	//	12				stopClient();
	//	13			}
	//	14		});
	//	15	}
	
	// 02 ~ 03_ send()�� �Ű����� ���ڿ��κ��� UTF-8�� ���ڵ��� ByteBuffer�� ��´�.
	// 04_ write()�� ȣ���Ѵ�. ù ��° �Ű����� �����Ͱ� �ִ� ByteBuffer�̰�, �� ��° �Ű����� �ݹ� �޼ҵ��� �Ű������� ������ ÷�� ��ü�ε� �����Ƿ� null�̴�.
	//		�� ��° �Ű����� CompletionHandler<Integer, Void> ��ü�̴�. ��� Ÿ���� Integer�̰�, ÷���� ��ü�� �����Ƿ� ��ü Ÿ���� Void�̴�.
	// 06_ ���� �۾��� �����Ǿ��� �� �ݹ�Ǵ� completed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� ��� Ÿ���� Integer�̰�, �� ��° �Ű� Ÿ���� ÷�� Ÿ���� Void�̴�.
	// 07_ "[������ �Ϸ�]"�� ����ϱ� ���� displayText()�� ȣ���Ѵ�.
	// 10_ ���� �۾��� ���еǾ��� �� �ݹ�Ǵ� failed()�� �������Ѵ�. ù ��° �Ű� Ÿ���� Throwable�̰�, �� ��° �Ű� Ÿ���� ÷�� Ÿ���� Void�̴�.
	// 11_ "[���� ��� �ȵ�]"�� ����ϱ� ���� displayText()�� ȣ���Ѵ�.
	// 12_ stopClient()�� ȣ���Ѵ�.
	
			/*	UI Code	*/
	
	// UI ���� �ڵ�� TCP ���ŷ ä���� ä�� Ŭ���̾�Ʈ�� �����ϹǷ� �����Ѵ�. ä�� ������ Ŭ���̾�Ʈ ���� ����� TCP ���ŷ ä���� ä�� ������ Ŭ���̾�Ʈ ���� ����� �����ϴ�.
}
