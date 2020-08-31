package 챕터19_NIO;

public class ㅅ_TCP_NonBlockingChannel {
	// ServerSocketChannel, SocketChannel은 블로킹(blocking) 방식도 지원하지만 넌블로킹(non-blocking) 방식도 지원한다.
	// 이번 절에서는 넌블로킹 방식의 특징과 넌블로킹의 핵심 객체인 셀렉터(Selector)를 이해하고 채널을 넌블로킹 방식으로 사용하는 방법에 대해 알아보기로 하자.
	
			//	Characteristic Of Non-Blocking Way		넌블로킹 방식의 특징
	
	// 블로킹 방식은 언제 클라이언트가 연결 요청을 할지 모르기 때문에 accept()에서 블로킹된다. 그리고 언제 클라이언특 데이터를 보낼지 모르므로 read() 메소드는 항상 데이터를 받을 준비를 하기 위해 블로킹된다.
	// 그렇기 때문에 ServerSocketChannel과 연결된 SocketChannel당 하나의 스레드가 할당되어야 한다. 따라서 연결된 클라이언트가 많을수록 스레드의 수가 증가하고 서버에 심각한 성능 문제를 유발할 수도 있다.
	// 이 문제를 해결하기 위해 지금까지는 스레드풀(ExecutorService)을 사용했었다.
	
	// 자바는 블로킹 방식의 또 다른 해결책으로 넌블로킹 방식을 지원하고 있다. 넌블로킹 방식은 connect(), accept(), read(), write() 메소드에서 블로킹이 없다.
	// 클라이언트의 연결 요청이 없으면 accept()는 즉시 null을 리턴한다. 그리고 클라이언트가 데이터를 보내지 않으면 read()는 즉시 0을 리턴하고, 매개값으로 전달한 ByteBuffer에는 어떤 데이터도 저장되지 않는다.
	// 넌블로킹 방식에서 다음 코드는 클라이언트가 연결 요청을 하지 않으면 무한 루프를 계속 돈다.
	
	//	while(true) {
	//		SocketChannel socketChannel = serverSocketChannel.accept();
	//		...
	//	}
	
	// accept() 메소드가 블로킹되지 않고 바로 리턴되기 때문에 클라이언트가 연결 요청을 보내기 전까지 while 블록 내의 코드가 쉴새 없이 실행되어 CPU가 과도하게 소비되는 문제점이 발생한다.
	// 그래서 넌블로킹은 이벤트 리스너 역할을 하는 셀렉터(Selector)를 사용한다. 넌블로킹 채널에 Selector를 등록해 놓으면 클라이언트의 연결 요청이 들어오거나 데이터가 도착할 경우, 채널은 Selector에 통보한다.
	// Selector는 통보한 채널들을 선택해서 작업 스레드가 accept() 또는 read() 메소드를 실행해서 즉시 작업을 처리하도록 한다.
	
	// Selector는 멀티 채널의 작업을 싱글 스레드에서 처리할 수 있도록 해주는 멀티플렉서(multiplexor) 역할을 한다. 1 채널은 Selector에 자신을 등록할 때 직업 유형을 키(SelectionKey)로 생성하고,
	// Selector의 관심키셋(interest-set)에 저장시킨다. 2 클라이언트가 처리 요청을 하면 3 Selector는 관심키셋에 등록된 키 중에서 작업 처리 준비가 된 키를 선택된 키셋(selected-set)에 별도로 저장한다.
	// 4 그리고 작업 스레드가 선택된 키셋에 있는 키를 하나씩 꺼내어  키와 연관된 채널 작업을 처리하게 된다. 작업 스레드가 선택된 키셋에 있는 모든 키를 처리하게 되면 선택된 키셋은 비워지고,
	// Selector는 다시 관심키셋에서 작업 처리 준비가 된 키들을 선택해서 선택된 키셋을 채운다.
	
	//	
	//
	//										┌───────────────────────────────────────────────────────────────────────┐
	//		┌───────────────────┐			│서버						┌───────────────────────────┐					│
	//		│		클라이언트		│	2 처리 요청	│	 ┌──────────┐		│	설렉터(Selector)			│					│
	//		│ (SocketChannel-1)	│←──────────────→│	Socket	│ 1 등록	│							│					│
	//		└───────────────────┘	5 응답	│	 │Channel-1	│───┐	│ 관심키셋						│					│
	//										│	 └──────────┘	│	│┌──────┐					│	┌───────────┐	│
	//										│					└──→││ ┌┬O	│	  3 선택된 키셋		│	│  작업 스레드	│	│
	//		┌───────────────────┐			│						││		│	 ┌──────────┐	│	│			│	│
	//		│		클라이언트		│	2 처리 요청	│	 ┌──────────┐	┌──→││ ┌┬O	│───→│ ┌┬O ┌┬O	│──────→│  4 작업 처리	│	│
	//		│ (SocketChannel-2)	│←──────────────→│	Socket	│───┘ 	││		│	 └──────────┘	│	│			│	│
	//		└───────────────────┘	5 응답	│	 │Channel-2	│ 1 등록	││	:	│					│	│	  넌블로킹	│	│
	//										│	 └──────────┘		││	:	│					│	└───────────┘	│
	//										│						│└──────┘					│					│
	//										│						└───────────────────────────┘					│
	//										└───────────────────────────────────────────────────────────────────────┘
	
	// 넌블로킹에서 작업 스레드를 꼭 하나만 사용할 필요는 없다. 채널 작업 처리 시 (4) 스레드풀을 사용할 수 있다. 작업 스레드가 블로킹되지 않기 때문에 적은 수의 스레드로 많은 양의 작업을 고속으로 처리할 수 있어
	// 블로킹 방식 보다는 서버의 성능이 향상될 수 있다.
	
			//	Selector Creation And Registration		셀렉터 생성과 등록
	
	// Selector는 정적 메소드인 open() 메소드를 호출하여 생성한다. open() 메소드는 IOException이 발생할 수 있기 때문에 예외 처리가 필요하다.
	
	//	try {
	//		Selector selector = Selector.open();
	//	} catch(IOException e) {
	
	// Selector에 등록할 수 있는 채널은 SelectableChannel의 하위 채널만 가능한데, TCP 통신에 사용되는 ServerSocketChannel, SocketChannel과 UDP 통신에 사용되는 DatagramChannel은 모두
	// SelectableChannel의 하위 클래스이므로 Selector에 등록할 수 있다. 주의할 점은 넌블로킹으로 설정된 것만 가능하다. 다음은 ServerSocketChannel을 넌블로킹으로 설정하는 코드이다.
	
	//	ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
	//	serverSocketChannel.configureBlocking(false);
	
	// 다음은 SocketChannel을 넌블로킹으로 설정하는 코드이다.
	
	//	SocketChannel socketChannel = SocketChannel.open();
	//	socketChannel.configureBlocking(false);
	
	// 각 채널은 register() 메소드를 이용해서 Selector에 등록하는데, 첫 번째 매개값은 Selector이고 두 번째 매개값은 채널의 작업 유형이다.
	
	//	SelectionKey selectionKey = serverSocketChannel.register(Selector sel, int ops);
	//	SelectionKey selectionKey = socketChannel.register(Selector sel, int ops);
	
	// 다음은 두 번째 매개값으로 사용할 수 있는 작업 유형별 SelectionKey의 상수들이다.
	
	//	SelectionKey의 상수	설명		
	//
	//	OP_ACCEPT			ServerSocketChannel의 연결 수락 작업
	//	OP_CONNECT			SocketChannel의 서버 연결 작업
	//	OP_READ				SocketChannel의 데이터 읽기 작업
	//	OP_WRITE			SocketChannel의 데이터 쓰기 작업
	
	// register()는 채널과 작업 유형 정보를 담고 있는 SelectionKey를 생성하고 Selector의 관심키셋에 저장한 후 해당 SelectionKey를 리턴한다.
	// 다음은 ServerSocketChannel이 Selector에 자신의 작업 유형을 등록하는 코드이다.
	
	//	SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_ONNECT);
	//	SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
	//	SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_WRITE);
	
	// SocketChannel의 작업은 세 가지인데, 서버 연결 요청 작업은 OP_CONNECT, 읽기 작업은 OP_READ, 쓰기 작업은 OP_WRITE로 지정한다. 
	// 주의할 점은 동일한 SocketChannel로 두 가지 이상의 작업 유형을 등록할 수없다. 즉, register()를 두 번 이상 호출할 수 없다. 
	// 등록은 한 번만 하되, 작업 유형이 변경되면 이미 생성된 SelectionKey를 수정해야 한다.
	// register()가 리턴한 SelectionKey는 작업 유형 변경, 첨부 객체 저장, 채널 등록 취소 등을 할 때 사용한다. SelectionKey를 별도로 관리할 필요는 없는데, 채널이 Selector를 등록하면 채널의
	// KeyFor() 메소드로 SelectionKey를 언제든지 얻을 수 있기 때문이다.
	
	//	SelectionKey key = socketChannel.keyFor(selector);
	
			//	Selected KeySet		선택된 키셋
	
	// Selector를 구동하려면 select() 메소드를 호출해야 한다. select()는 관심키셋에 저장된 SelectionKey로부터 작업 처리 준비가 되었다는 통보가 올 때까지 대기(블로킹)한다. 
	// 최소한 하나의 Selection로부터 작업 처리 준비가 되었다는 통보가 오면 리턴한다. 이때 리턴값은 통보를 해온 SelectionKey의 수이다.
	// 다음 세 가지 종류의 select() 메소드를 설명한 표이다.
	
	//	리턴 타입	메소드명(매개 변수)			설명
	//
	//	int		select()				최소한 하나의 채널이 작업 처리 준비가 될 때까지 블로킹된다.
	//	int		select(long timeout)	select()와 동일한데, 주어진 시간(밀리세컨드) 동안만 블로킹된다.
	//	int		selectNow()				호출 즉시 리턴된다. 작업 처리 준비된 채널이 있으면 채널 수를 리턴하고, 없다면 0을 리턴한다.
	
	// 부로 첫 번째 select()를 사용하는데, 이 메소드는 블로킹되므로 UI 및 이벤트를 처리하는 스레드에서 호출되면 안 되고, 별도의 작업 스레드를 생성해서 실행해야 한다.
	// select()가 리턴하는 경우는 다음 세 가지이다.
	
	//	- 채널이 작업 처리 준비가 되었다는 통보를 할 때
	//	- Selector의 wakeup() 메소드를 호출할 때
	//	- select()를 호출한 스레드가 인터럽트될 때
	
	// ServerSocketChannel은 작업 유형이 OP_ACCEPT 하나 밖에 없지만, SocketChannel은 상황에 따라서 읽기 작업과 쓰기 작업을 번갈아가며 작업 유형을 변경할 수 있다.
	// 채널의 작업 유형이 변경되면 SelectionKey의 작업 유형을 interestOps() 메소드로 변경해야 작업 스레드가 올바르게 채널 작업을 할 수 있다.
	// 다음은 SelectionKey의 작업 유형을 OP_WRITE로 변경하는 코드이다.
	
	//	selectionKey.interestOps(SelectionKey.OP_WRITE);
	//	selector.wakeup();
	
	// SelectionKey의 작업 유형이 변경되면 Selector의 wakeup() 메소드를 호출해서 블로킹되어 있는 select()를 즉시 리턴하고, 변경된 작업 유형을 감지하도록 select()를 다시 실행해야 한다.
	// 다음은 select() 메소드가 1 이상의 값을 리턴할 경우, selectedKeys() 메소드로 작업 처리 준비된 SelectionKey들을 Set 컬렉션으로 얻는다. 이것이 선택된 키셋이다.
	
	//	int keyCount = selector.select();
	//	if(keyCount > 0) {
	//		Set<SelectionKey> selectedKeys = selector.selectedKeys();
	//	}
	
			//	Handling Channel Task 	채널 작업 처리
	
	// 작업 스레드가 해야 할 일은 선택된 키셋에서 SelectionKey를 하나씩 꺼내어 작업 유형별로 채널 작업 처리하는 것이다. 
	// SelectionKey가 어떤 작업 유형인지 알아내는 방법은 SelectionKey의 다음 메소드 중에서 어떤 것이 true를 리턴하는지 조사하면 된다.
	
	//	리턴 타입		메소드명(매개 변수)		설명
	//
	//	boolean		isAcceptable()		작업 유형이 OP_ACCEPT인 경우
	//	boolean		isConnectable()		작업 유형이 OP_CONNECT인 경우
	//	boolean		isReadable()		작업 유형이 OP_READ인 경우
	//	boolean		isWritable()		작업 유형이 OP_WRITE인 경우
	
	// 다음은 작업 스레드가 작업 유형별로 작업을 처리하는 방법을 보여준다.
	
	//	Thread thread = new Thread() {	// 스레드 생성
	//		@Override
	//		public void run() {
	//			while(true) {
	//				try {
	//					int keyCount = selector.select();	// 작업 처리 준비된 키 감지
	//					if(keyCount == 0) { continue; }	// 키가 없을 경우 루프 처음으로 돌아감
	//					Set<SelectionKey> selectedKeys = selector.selectedKeys();	// 선택된 키셋 얻기
	//					Iterator<SelectionKey> iterator = selectedKeys.iterator();	// 반복자 얻기
	//					while(iterator.hasNext()) {
	//						SelectionKey selectionKey = iterator.next();	// 키를 하나씩 꺼내옴
	//						if(selectionKey.isAccetable()) { // 연결 수락 작업 처리 }
	//						else if(selectionKey.isReadable()) { // 읽기 작업 처리 }
	//						else if(selectionKey.isWritable()) { // 쓰기 작업 처리 }
	//						iterator.remove();	// 선택된 키셋에서 처리 완료된 SelectionKey를 제거
	//					}
	//				} catch (Exception e) {
	//					break;
	//				}
	//			}
	//		}
	//	};
	//	thread.start();
	
	// 작업 스레드가 채널 작업을 처리하려면 채널 객체가 필요한데, SelectionKey의 channel() 메소드를 호출하면 얻을 수 있다.
	// 다음은 작업 유형이 OP_ACCEPT일 경우, 연결 수락 작업 처리에서 필요한 ServerSocketChannel을 얻는 코드이다.
	
	//	ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
	
	// 작업 스레드가 채널 작업을 처리하다 보면 채널 객체 이외에 다른 객체가 필요할 수도 있다. 이러한 객체는 SelectionKey에 첨부해 두고, 사용할 수 있다. SelectionKey의 attach() 메소드는 객체를 첨부하고,
	// attachment() 메소드는 첨부된 객체를 얻을 때 사용한다.
	// 다음은 Client 객체를 selectionKey에 첨부하고, 얻어내는 코드이다.
	
	//	[책체 첨부하기]
	//	Client client = new Client(socketChannel);
	//	SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
	//	selectionKey.attach(client);	// 객체를 첨부함
	//
	//	[첨부된 객체 얻기]
	//	if(selectionKey.isReadable()) {
	//		Client client = (Client) selectionKey.attachment();	// 첨부된 객체 얻기
	//		...
	//	}
	
			//	Chatting Server Implementation		채팅 서버 구현
	
	// TCP 블로킹에서 살펴보았던 채팅 서버를 넌블로킹으로 구현해보면서 셀렉터(Selector)와 넌블로킹 ServerSocketChannel 그리고 넌블로킹 SocketChannel이 어떻게 사용되는지 이해해보자.
	
			/*	Server Class Structure		서버 클래스 구조	*/
	
	// 01_ JavaFx 메인 클래스로 만들기 위해 Application을 상속한다.
	// 02_ 넌블로킹의 핵심 객체인 Selector 필드를 선언한다.
	// 03_ 클라이언트 연결을 수락하는 ServerSocketChannel 필드를 선언한다.
	// 04_ 연결된 클라이언트를 저장하는 List<Client> 타입의 connections 필드를 선언한다. 그리고 스레드에 안전한 Vector로 초기화 한다.
	// 06_ startServer()는 서버 시작 시 호출되는 메소드이다.
	// 07_ stopServer()는 서버 종료 시 호출되는 메소드이다.
	// 09_ accept()는 작업 스레드가 연결 수락 작업을 처리하기 위해 호출하는 메소드이다.
	// 11_ Client 클래스는 연결된 클라이언트를 표현하는데, 데이터 통신 코드를 포함한다.
	// 14_ UI 생성 코드는 레이아웃을 구성하고 ServerExample을 실행한다.
	
	// 생성 화면에서 [start] 버튼을 클릭하면 startServer() 메소드가 호출되고, [start] 버튼은 [stop] 버튼으로 변경된다.
	// [stop] 버튼을 클릭하면 stopServer() 메소드가 호출되고, 다시 [start] 버튼으로 변경된다.
	
			/*	startServer() Method	*/
	
	// [start] 버튼을 클릭하면 startServer() 메소드가 실행되는데, startServer() 메서드에서는 selector 생성, 넌블로킹 ServerSocketChannel 생성 및 포트 바인딩, Selector 등록,
	// 작업 스레드 생성 코드가 필요하다. 다음은 ServerSocketChannel이 Selector에 자신의 작업 유형을 등록하는 코드를 보여준다.
	
	//	01	void startServer() {
	//	02		try {
	//	03			selector = Selector.open();	// Selector 생성
	//	04			serverSocketChannel = ServerSocketChannel.open();
	//	05			serverSocketChannel.configureBlocking(false);	// 넌블로킹으로 설정
	//	06			serverSocketChannel.bind(new InetSocketAdderss(5001));
	//	07			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);	// Selector에 작업 유형을 등록
	//	08		} catch (Exception e) {
	//	09			if(serverSocketChannel.isOpen()) { stopServer(); }
	//	10			return;
	//	11		}
	
	// 03_ Selector을 생성한다.
	// 04_ ServerSocketChannel을 생성한다.
	// 05_ ServerSocketChannel을 넌블로킹 모드로 설정한다.
	// 06_ ServerSocketChannel을 5001번 포트로 바인딩한다.
	// 07_ Selector를 등록하되 작업 유형을 OP_ACCEPT로 지정한다.
	// 09_ 예외가 발생하면 ServerSocketChannel이 열려있을 경우 stopServer()를 호출한다.
	// 10_ return을 실행해서 startServer() 실행을 중단한다.
	
	// 다음은 작업 처리 준비가 된 SelectionKey를 선택하고, 작업 유형별로 작업 스레드가 처리하는 코드이다.
	
	//	01	Thread thread = new Thread() {	// 스레드 생성
	//	02		@Override
	//	03		public void run() {
	//	04			while(true) {
	//	05				try {
	//	06					int keyCount = selector.select();	// 작업 처리 준비가 된 채널이 있을 때까지 대기
	//	07					if(keyCount == 0) { continue; }
	//	08					Set<SelectionKey> selectedKeys = selector.selectedKeys();	// 작업 처리 준비가 된 키를 얻고 Set 컬렉션으로 리턴
	//	09					Iterator<SelectionKey> iterator = selectedKeys.iterator();
	//	10					while(iterator.hasNext()) {
	//	11						SelectionKey selectionKey = iterator.next();
	//	12						if (selectionKey.isAcceptable()) {		// 연결 수라 작업일 경우
	//	13							accept(selectionKey);
	//	14						} else if (selectionKey.isReadable()) {	// 읽기 작업일 경우
	//	15							Client client = (Client) selectionKey.attachment();
	//	16							client.receive(selectionKey);
	//	17						} else if (selectionKey.isWritable()) {	// 쓰기 작업일 경우
	//	18							Client client = (Client) selectionKey.attachment();
	//	19							client.send(selectionKey);
	//	20						}
	//	21						iterator.remove();		// 선택된 키셋에서 처리 완료된 SeletionKey를 제거
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
	//	33		displayText("[서버 시작]");
	//	34		btnStartStop.setText("stop");
	//	35	});
	//	36	}	// startServer() 메소드 끝
	
	// 01_ 작업 스레드를 생성한다.
	// 04_ 반복적으로 선택된 키셋을 얻어 작업을 처리하기 위해 무한 루프를 작성한다.
	// 06_ 작업 처리 준비된 SelectionKey의 통보를 받기 위해 블로킹한다.
	// 07_ wakeup() 호출 시 select()는 0을 리턴하므로 루프의 처음으로 돌아간다.
	// 08_ selectedKeys()를 호출해서 선택된 키셋을 얻는다.
	// 09_ 선택된 키셋의 반복자를 얻는다.
	// 10 ~ 11_ 반복자를 반복하면서 SelectionKey를 하나씩 꺼낸다.
	// 12 ~ 13_ 작업 유형이 OP_ACCEPT일 경우 accept() 메소드를 실행한다.
	// 14 ~ 16_ 작업 유형이 OP_READ일 경우 SelectionKey의 첨부 객체인 Client를 얻어내고 receive() 메소드를 호출한다.
	// 17 ~ 19_ 작업 유형이 OP_WRITE일 경우 SelectionKey의 첨부 객체인 Client를 얻어내고 send() 메소드를 호출한다.
	// 21_ 작업 처리된 SelectionKey를 선택된 키셋에서 제거한다.
	// 24 ~ 25_ 예외가 발생하면 ServerSocket이 열려있을 경우 stopServer()를 호출한다.
	// 30_ 작업 스레드를 시작한다.
	// 32 ~ 35_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()를 사용해서 "[서버 시작]"을 출력하기 위해 displayText()를 호출한다. 그리고 [start] 버튼의 글자를 [stop]으로 변경한다.
	
			/*	stopServer() Method	*/
	
	// [stop] 버튼을 클릭하면 stopServer() 메소드가 실행되는데, stopServer() 메소드에는 연결된 모든 SocketChannel 닫기, ServerSocketChannel 닫기, Selector 닫기 코드가 필요하다.
	
	//	01	void stopServer() {
	//	02		try {
	//	03			Iterator<Client> iterator = connections.iterator();
	//	04			while(iterator.hasNext()) {
	//	05				Client client = iterator.next();
	//	06				client.socketChannel.close();	// 연결된 SocketChannel 닫기
	//	07				iterator.remove();
	//	08			}
	//	09			if(serverSocketChannel != null && serverSocketChannel.isOpen()) {
	//	10				serverSocketChannel.close();	// ServerSocketChannel 닫기
	//	11			}
	//	12			if(selector != null && selector.isOpen()) {
	//	13				selector.close();	// Selector 닫기
	//	14			}
	//	15			Platform.runLater( () -> {
	//	16				displayText("[서버 멈춤]");
	//	17				btnStartStop.setText("start");
	//	18			});
	//	19		} catch (Exception e) {}
	//	20	}

	// 03_ connections 컬렉션의 반복자를 얻는다.
	// 04 ~ 08_ 반복자를 반복하면서 Client를 하나씩 꺼내, SocketChannel을 닫고 connections 컬렉션에서 제거한다.
	// 09 ~ 11_ ServerSocketChannel이 null이 아니고, 열려있다면 닫는다.
	// 12 ~ 14_ Selector가 null이 아니고, 열려있다면 닫는다.
	// 15 ~ 18_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()를 사용해서 "[서버 멈춤]"을 출력하기 위해 dispalyText()를 호출한다. 그리고 [stop] 버튼의 글자를 [start]로 변경한다.
	
			/*	accept(SelectionKey selectionKey) Method	*/
	
	// 작업 스레드는 SelectionKey의 isAcceptable()가 true를 리턴하면, 즉 작업 유형이 OP_ACCEPT라면 accept() 메소드를 호출한다. 
	// accept() 메소드는 연결을 수락하고 Client 객체를 생성하는 역할을 한다.
	
	//	01	void acccept(SelectionKey selectionKey) {
	//	02		try {
	//	03			ServerSocketChannel serverSocketChannel =
	//	04				(ServerSocketChannel) selectionKey.channel();		// ServerSocketChannel 얻기
	//	05			SocketChannel socketChannel = serverSocketChannel.accept();	// 연결 수락
	//	06			
	//	07			String message = "[연결 수락: " + socketChannel.getRemoteAddress() + ": " +
	//	08				Thread.currentThread().getName() + "]";
	//	09			Platform.runLater( () -> displayText(message) );
	//	10		
	//	11			Client client = new Client(socketChannel);
	//	12			connections.add(client);
	//	13
	//	14			Platform.runLater( () -> displayText("[연결 개수: " + connections.size() + "]") );
	//	15		} catch(Exception e) {
	//	16			if(serverSocketChannel.isOpen()) { stopServer(); }
	//	17		}
	//	18	}

	// 03_ SelectionKey로부터 ServerSocketChannel을 얻는다.
	// 05_ ServerSocketChannel의 accept()를 호출하면 즉시 SocketChannel을 리턴한다.
	// 07 ~ 09_ "[연결 수락: 클라이언트 IP: 작업스레드이름]" 문자열을 생성하고, displayText()로 출력한다.
	// 11 ~ 12_ Client를 생성하고 connections 컬렉션에 추가한다.
	// 14_ "[연결 개수]" 문자열을 생성하고, displayText()로 출력한다.
	// 16_ 예외가 발생하면 ServerSocketChannel이 열려있을 경우 stopServer()를 호출한다.
	
			/*	Client Class	*/
	
	// 서버는 다수의 클라이언트가 연결하기 때문에 클라이언트를 관리해야 한다. 클라이언트별로 고유한 데이터를 저장할 필요도 있기 때문에 Client 클래스를 작성하고, 
	// 연결 수락 시 마다 Client 인스턴스를 생성해서 관리하는 것이 좋다. Client 클래스에는 데이터 받기 및 보내기 코드가 있어야 한다.
	// 다음은 Client 클래스의 구조를 보여준다.
	
	//	01	class Client {
	//	02		SocketChannel socketChannel;
	//	03		String sendData;	// 클라이언트로 보낼 데이터를 저장하는 필드
	//	04
	//	05		Client(SocketChannel socketChannel) {
	//	06			this.socketChannel = socketChannel;
	//	07			socketChannel.configureBlocking(false);
	//	08			SelectionKey selectionKey = socketChannel.register(selector,
	//	09																SelectionKey.OP_READ);		// 넌블로킹으로 설정하고 읽기 작업 유형으로 Selector에 등록시킴
	//	10			selectionKey.attach(this);		// SelectionKey에 자기 자신을 첨부 객체로 저장
	//	11		}
	//	12
	//	13		void receive(SelectionKey selectionKey) { // 데이터 받기 코드 }
	//	14		void send(SelectionKey seletionKey) { // 데이터 전송 코드 }
	//	15	}

	// 01_ Client를 ServerExample의 내부 클래스로 선언한다.
	// 02_ 통신용 SocketChannel 필드를 선언한다.
	// 03_ 클라이언트로 보낼 데이터를 저장할 String 필드를 선언한다.
	// 05_ 생성자를 선언한다.
	// 06_ 매개값으로 SocketChannel 필드를 초기화한다.
	// 07_ SocketChannel을 넌블로킹 모드로 설정한다.
	// 08 ~ 09_ SocketChannel의 작업 유형을 Selector에 등록한다. 작업 유형은 OP_READ로 지정한다.
	// 10_ SelectionKey의 첨부 객체로 Client를 저장한다.
	// 13_ 클라이언트가 보낸 데이터를 받기 위해 receive() 메소드를 선언한다.
	// 14_ 데이터를 클라이언트로 보내기 위해 send() 메소드를 선언한다.
	
	// 다음 코드는 클라이언트의 데이터를 받는 receive() 메소드이다. 작업 스레드는 SelectionKey의 isReadable()이 true를 리턴하면, 즉 작업 유형이 OP_READ라면 receive() 메소드를 호출한다.
	// 블로킹 방식의 코드와 차이점은 무한 루프를 사용하지 않는 점과 SocketChannel의 read() 메소드가 즉시 리턴되는 점이다.
	
	//	01	void receive(SelectionKey selectionKey) {
	//	02		try {
	//	03			ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	04
	//	05			// 상대방이 비정상 종료를 했을 경우 자동 IOException 발생
	//	06			int byteCount = socketChannel.read(byteBuffer);		// 데이터 받기
	//	07	
	//	08			// 상대방이 SocketChannel의 close() 메소드를 호출할 경우
	//	09			if(byteCount == -1) {
	//	10				throw new IOException();
	//	11			}
	//	12	
	//	13			String message = "[요청 처리: " + socketChannel.getRemoteAddress() + ": " +
	//	14								Thread.currentThread().getName() + "]";
	//	15			Platform.runLater( () -> displayText(message) );
	//	16
	//	17			byteBuffer.flip();		// 문자열 변환
	//	18			Charset charset = Charset.forName("UTF-8");
	//	19			String data = charset.decode(byteBuffer).toString();
	//	20
	//	21			for(Client client : connections) {		// 모든 클라이언트에게 문자열을 전송하는 코드
	//	22				client.sendData = data;
	//	23				SelectionKey key = client.socketChannel.keyFor(selector);
	//	24				key.interestOps(SelectionKey.OP_WRITE);	// 작업 유형 변경
	//	25			}
	//	26			selector.wakeup();	// 변경된 작업 유형을 감지하도록 하기 위해 Selector의 select() 블로킹을 해제되고 다시 실행하도록 한다.
	//	27		} catch(Exception e) {
	//	28			try {
	//	29				connections.remove(this);
	//	30				String message = "[클라이언트 통신 안됨: " + 
	//	31									socketChannel.getRemoteAddress() + ": " +
	//	32									Thread.currentThread().getName() + "]";
	//	33				Platform.runLater( () -> displayText(message) );
	//	34				socketChannel.close();
	//	35			} catch(IOException e2) {}
	//	36		}
	//	37	}
	
	// 03_ 저장 공간의 크기가 100인 ByteBuffer를 생성한다. 
	// 06_ SocketChannel의 read() 메소드를 호출한다. read()는 즉시 리턴되는데, 읽은 데이터는 byteBuffer에 저장하고, 받은 바이트 개수를 리턴한다.
	// 09 ~ 11_ 클라이언트가 정상적으로 SocketChannel의 close()를 호출했을 경우, 6라인의 read() 메소드는 -1을 리턴한다. 이 경우 IOException을 강제로 발생시킨다.
	// 13 ~ 15_ 정상적으로 데이터를 받았을 경우, "[요청 처리: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 생성하고 displayText()를 호출해서 출력한다.
	// 17 ~ 19_ 정상적으로 데이터를 받게 되면 받은 데이터가 저장된 ByteBuffer의 flip() 메소드를 호출해서 위치 속성값을 변경한 후 UTF-8로 디코딩한 문자열을 얻는다.
	// 21_ connections 컬렉션에 저장된 Client를 하나씩 꺼낸다.
	// 22_ 클라이언트로 보낼 문자열을 Client의 필드인 sendData에 저장한다.
	// 23_ Client의 통신 채널로부터 SelectionKey를 얻는다.
	// 24_ 채널의 작업 유형을 OP_WRITE로 변경한다.
	// 26_ Selector의 wakeup() 메소드를 호출한다. 이 메소드가 호출되면 Selector의 select() 메소드가 블로킹 해제되고, 변경된 작업 유형을 감지하도록 select() 메소드가 다시 호출된다.
	// 29_ 예외가 발생하면 해당 connections 컬렉션에서 Client 객체를 제거한다. 예외는 6라인과 10라인에서 발생하는데, 모두 클라이언트와 통신이 안 될때이다.
	// 30 ~ 33_ "[클라이언트 통신 안됨: 클라이언트IP: 작업스레드이름]"으로 구성된 문자열을 생성하고 displayText()를 호출해서 출력한다.
	// 34_  SocketChannel을 닫는다.
	
	// 다음 코드는 데이터를 클라이언트로 보내는 send() 메소드이다.
	
	//	01	void send(SelectionKey selectionKey) {
	//	02		try {
	//	03			Charset charset = Charset.forName("UTF-8");
	//	04			ByteBuffer byteBuffer = charset.encode(sendData);
	//	05			socketChannel.write(byteBuffer);	// 데이터 보내기
	//	06			socketChannel.interestOps(SelectionKey.OP_READ);	// 작업 유형 변경
	//	07			selector.wakeup();	// 변경된 작업 유형을 감지하도록 Selector의 select() 블로킹 해제
	//	08		} catch(Exception e) {
	//	09			try {
	//	10				String message = "[클라이언트 통신 안됨: " +
	//	11									socketChannel.getRemoteAddress() + ": " +
	//	12									Thread.currentThread().getName() + "]";
	//	13				Platform.runLater( () -> displayText(message) );
	//	14				connections.remove(this);
	//	15				socketChannel.close();
	//	16			} catch (IOException e2) {}
	//	17		}
	//	18	}

	// 03 ~ 04_ 클라이언트로 보낼 문자열로부터 UTF-8로 인코딩된 ByteBuffer를 얻는다.
	// 05_ SocketChannel의 write() 메소드를 호출해서 ByteBuffer의 내용을 클라이언트로 보낸다.
	// 06_ 작업 유형을 OP_READ로 변경한다.
	// 07_ Selector의 wakeup() 메소드를 호출한다. 이 메소드가 호출되면 Selector의 select() 메소드가 블로킹 해제되고, 변경된 작업 유형을 감지하도록 select() 메소드가 다시 호출된다.
	// 10 ~ 13_ 5라인에서 예외가 발생하면 "[클라이언트 통신 안됨: 클라이언트IP: 작업스레드이름]" 으로 구성된 문자열을 생성하고 displayText()를 호출해서 출력한다.
	// 14_ connections 컬렉션에서 예외가 발생한 Client를 제거한다.
	// 15_ SocketChannel을 닫는다.
	
			/*	UI Creation Code	UI 생성 코드	*/
		
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
	//	17		btnStartStop.setOnAction( e -> {		// start와 stop 버튼을 클릭했을 때 이벤트 처리 코드
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
	//	30		primaryStage.setOnCloseRequest( event -> stopServer() );	// 윈도우 우측 상단 닫기 버튼을 클릭했을 때 이벤트 처리 코드
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
	
			//	Chatting Client Implementation		채팅 클라이언트 구현
	
	// 채팅 클라이언트도 넌블로킹 SocketChannel을 사용하여 개발할 수 있지만 넌블로킹 방식은 주로 서버를 개발할 때 이용하기 때문에 넌블로킹 방식의 채팅 클라이언트 구현 설명은 생략한다.
	// 채팅 클라이언트는 TCP 블로킹 채널의 채팅 클라이언트를 그대로 사용해도 된다. 넌블로킹 방식의 채팅 클라이언트는 ClientExample을 보고 참고하길 바란다.
	// 채팅 서버와 클라이언트 실행 방법은 TCP 블로킹 채널의 채팅 서버와 클라이언트 실행 방법과 동일하다.

}
