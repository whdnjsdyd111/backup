package 챕터19_NIO;

public class ㅂ_TCP_BlokingChannel {
	// NIO를 이용해서 TCP 서버/클라이언트 애플리케이션을 개발하려면 블로킹, 넌블로킹, 비동기 구현 방식 중에서 하나를 결정해야 한다. 이 결정에 따라 구현이 완전히 달라지기 때문이다.
	// 다소 복잡해지기도 했지만 네트워크 입출력의 성능과 효율성 면에서 선택의 폭이 넓어졌기 때문에 최적의 네트워크 애플리케이션을 개발할 수 있게 되었다.
	// 이번 절에서는 블로킹 방식만 설명하고, 넌블로킹과 비동기 방식은 다른 절에서 설명하도록 하겠다.
	
			//	ServerSocket Channel And Purpose Of Channel		서버소켓 채널과 소켓 채널의 용도
	
	// NIO에서 TCP 네트워크 통신을 위해 사용하는 채널은 java.nio.channels.ServerSocketChannel과 java.nio.channels.SocketChannel이다.
	// 이 두 채널은 IO의 ServerSocket과 Socket에 대응되는 클래스로, IO가 버퍼를 사용하지 않고 블로킹 입출력 방식만 지원한다면 ServerSocketChannel, SocketChannel은 버퍼를 이용하고 블로킹과 
	// 넌블로킹 방식을 모두 지원한다. 사용 방법은 IO와 큰 차이점이 없는데, 다음과 같이 ServerSocketChannel은 클라이언트 SocketChannel의 연결 요청을 수락하고 통신용 SocketChannel을 생성한다.
	
	//
	//								1 연결 요청(connect)	┌───────────────────┐
	//					┌──────────────────────────────→│	ServerSocket	│
	//					│								└───────────────────┘		
	//					│						2 연결 수락(accept) 후  ↓ SocketChannel 생성
	//		┌───────────────────┐						┌───────────────────┐
	//		│	ServerChannel	│						│	ServerChannel	│
	//		│					│	3 통신(read, write)	│					│
	//		│	입력		┌───┐	│───────────────────────│	┌───┐		입력	│
	//		│	데이터 ←──	│버	│	│←----------------------│	│버	│───→	데이터│
	//		│			│	│	│----------------------→│	│	│			│
	//		│	출력	───→│퍼	│	│───────────────────────│	│퍼	│←──	출력	│
	//		│	데이터	└───┘	│						│	└───┘		데이터│
	//		└───────────────────┘						└───────────────────┘
	
			//	ServerSocket Channel Creation And Connect Accept		서버소켓 채널 생성과 연결 수락
	
	// 서버를 개발하려면 우선 ServerSocketChannel 객체를 얻어야 한다. ServerSocketChannel은 정적 메소드인 open()으로 생성하고, 블로킹 방식으로 동작시키기 위해 configureBlocking(true)
	// 메소드를 호출해야 한다. 기본적으로 블로킹 방식으로 동작하지만, 명시적으로 설정하는 이유는 넌블로킹과 구분하기 위해서이다.
	// 포트에 바인딩하기 위해서는 bind() 메소드가 호출되어야 하는데, 포트 정보를 가진 InetSocketAddress 객체를 매개값으로 주면 된다.
	
	//	ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
	//	serverSocketChannel.configureBlocking(true);
	//	serverSocketChannel.bind(new InetSocketAddress(5001));
	
	// 포트 바인딩까지 끝났다면 ServerSocketChannel은 클라이언트 연결 수락을 위해 accept() 메소드를 실행해야 한다. accept() 메소드는 클라이언트가 연결 요청을 하기 전까지 블로킹되기 때문에
	// UI 및 이벤트를 처리하는 스레드에서 accept() 메소드를 호출하지 않도록 한다. 클라이언트가 연결 요청을 하면 accept()는 클라이언트와 통신할 SocketChannel을 만들고 리턴한다.
	
	//	SocketChannel socketChannel = serverSocketChannel.accept();
	
	// 연결된 클라이언트의 IP와 포트 정보를 알고 싶다면 SocketChannel의 getRemoteAddress() 메소드를 호출해서 SocketAddress를 얻으면 된다.
	// 실제로 리턴되는 것은 InetSocketAddress 인스턴스이므로 다음과 같이 타입 변환할 수 있다.
	
	//	InetSocketAddress socketAddress = (InetSocketAddress) socketChannel.getRemoteAddress();
	
	// InetSocketAddress에는 다음과 같이 IP와 포트 정보를 리턴하는 메소드들이 있다.
	
	//	리턴 타입		메소드명(매개 변수)		설명
	//
	//	String		getHostName()		클라이언트 IP 리턴
	//	int			getPort()			클라이언트 포트 번호 리턴
	//	String		toString()			"IP:포트번호" 형태의 문자열 리턴
	
	// 더 이상 클라이언트를 위해 연결 수락이 필요 없다면 ServerSocketChannel의 close() 메소드를 호출해서 포트를 언바인딩시켜야 한다. 그래야 다른 프로그램에서 해당 포트를 사용할 수 있다.
	
	//	serverSocketChannel.close();
	
	// 다음 예제는 반복적으로 accept() 메소드를 호출해서 다중 클라이언트 연결을 수락하는 가장 기본적인 코드를 보여준다.
	
			//	Socket Channel Creation And Connect Accept		소켓 채널 생성과 연결 요청
	
	// 클라이언트가 서버에 연결 요청을 할 때에는 java.nio.channels.SocketChannel을 이용한다. SocketChannel은 정적 메소드인 open()으로 생성하고, 
	// 블로킹 방식으로 동작시키기 위해 configureBlocking(true) 메소드를 호출한다. 기본적으로 블로킹 방식으로 동작하지만, 명시적으로 설정하는 이유는 넌블로킹과 구분하기 위해서이다.
	// 서버 연결 요청은 connect() 메소드를 호출하면 되는데, 서버 IP와 포트 정보를 가진 InetSocketAddress 객체를 매개값으로 주면 된다.
	// connect() 메소드는 연결이 완료될 때까지 블로킹되고, 연결이 완료되면 리턴된다. 다음은 로컬 PC의 5001 포트에 바인딩된 서버에 연결을 요청하는 코드이다.
	
	//	SocketChannel socketChannel = SocketChannel.open();
	//	socketChannel.configureBlocking(true);
	//	socketChannel.connect(new InetSocketAddress("localhost",5001));
	
	// connect() 메소드는 서버와 연결이 될 때까지 블로킹되므로 UI 및 이벤트를 처리하는 스레드에서 connect()를 호출하지 않도록 한다.
	// 블로킹되면 UI 갱신이나 이벤트 처리를 할 수 없기 때문이다. 연결된 후, 클라이언트 프로그램을 종료하거나, 필요에 따라서 연결을 끊고 싶다면 다음과 같이 SocketChannel의 close() 메소드를 호출하면 된다.
	
	//	socketChannel.close()
	
	// 다음 예제는 localhost 5001 포트로 연결 요청하는 코드이다. connect() 메소드가 정상적으로 리턴도면 연결 성공한 것이다.
	
			//	Socket Channel Data Communication		소켓 채널 데이터 통신
	
	// 클라이언트 연결 요청(connect())하고 서버가 연결 수락(accept()) 했다면, 양쪽 SocketChannel 객체의 read(), write() 메소드를 호출해서 데이터 통신을 할 수 있다.
	// 이 메소드들은 모두 버퍼를 이용하기 때문에 버퍼로 읽고, 쓰는 작업을 해야 한다.
	
	//		┌───────────────────┐						┌───────────────────┐
	//		│	ServerChannel	│						│	ServerChannel	│
	//		│					│	 통신(read, write)	│					│
	//		│	입력		┌───┐	│───────────────────────│	┌───┐		입력	│
	//		│	데이터 ←──	│버	│	│←----------------------│	│버	│───→	데이터│
	//		│			│	│	│----------------------→│	│	│			│
	//		│	출력	───→│퍼	│	│───────────────────────│	│퍼	│←──	출력	│
	//		│	데이터	└───┘	│						│	└───┘		데이터│
	//		└───────────────────┘						└───────────────────┘
	
	// 다음은 SocketChannel의 write() 메소드를 이용해서 문자열을 보내는 코드이다.
	
	//	Charset charset = Charset.forName("UTF-8");
	//	ByteBuffer byteBuffer = charset.encode("Hello Server");
	//	socketChannel.write(byteBuffer);
	
	// 다음은 SocketChannel의 read() 메소드를 이용해서 문자열을 받는 코드이다.
	
	//	ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	int byteCount = socketChannel.read(byteBuffer);
	//	byteBuffer.flip();
	//	Charset charset = Charset.forName("UTF-8");
	//	String message = charset.decode(byteBuffer).toString();
	
	// 다음 예제는 연결 성공 후, 1 클라이언트가 먼저 "Hello Server"를 보낸다. 2 서버가 이 데이터를 받고 "Hello Client"를 클라이언트로 보내면 4 클라이언트가 이 데이터를 받는다.
	
	// 먼저 ServerExample부터 실행하고 ClientExample을 실행해보자.
	
	// 데이터를 받기 위해 read() 메소드를 호출하면 상대방이 데이터를 보내기 전까지는 블로킹(blocking)되는데, read() 메소드가 블로킹 해제되고 리턴되는 경우는 다음 세 가지이다.
	
	//	블로킹이 해제되는 경우								리턴값
	//
	//	상대방이 데이터를 보냄								읽은 바이트 수
	//	상대방이 정상적으로 SocketChannel의 close() 호출		-1	
	//	상대방이 비정상적으로 종료							IOException 발생
	
	// 상대방이 정상적으로 SocketChannel의 close()를 호출하고 연결을 끊었을 경우와 상대방이 비정상적으로 종료된 경우는 예외 처리를 해서 이쪽도 SocketChannel을 닫기 위해 close() 메소드를 호출해야 한다.
	
	//	try {
	//		...
	//		// 상대방이 비정상적으로 종료했을 경우 IOException 발생
	//		int byteCount = socketChannel.read(byteBuffer);	────────────┐
	//																	│
	//		// 상대방이 정상적으로 Socket의 close()를 호출했을 경우					│
	//		if(readByteCount == -1) {									│
	//			throw new IOException();	// 강제로 IOException 발생시킴   	┤
	//		}															│
	//		...															│
	//	} catch (Exception e) {	←───────────────────────────────────────┘
	//		try { socketChannel.close(); } catch(Exception e2) {}
	//	}
	
			//	Handling Thread Parallelism		스레드 병렬 처리
	
	// TCP 블로킹 방식은 데이터 입출력이 완료되기 전까지 read()와 write() 메소드가 블로킹된다. 만약 애플리케이션을 실행시키는 main 스레드가 직접 입출력 작업을 담당하게 되면 입출력이 완료될 때까지
	// 다른 작업을 할 수 없는 상태가 된다. 예를 들어 서버 애플리케이션은 지속적으로 클라이언트의 연결 수락 기능을 수행해야 하는데, 입출력에서 블로킹되면 이 작업을 할 수 없게 된다. 
	// 또한 클라이언트1과 입출력하는 동안에는 클라이언트2와 입출력을 할 수 없게 된다. 그렇기 때문에 클라이언트 연결(채널) 하나에 작업 스레드 하나를 할당해서 병렬 처리해야 한다.
	
	//											┌────────────────────────────────────────────┐
	//											│	accept()							서버	 │
	//											│	  |		2			 ┌──────────────────┐│
	//		┌───────────────┐	1 연결 요청			│	  |	   스레드 생성		 │	작업 스레드 1	    ││			
	//		│	클라이언트1		│──────────────────────────────────────────→ │┌────────────────┐││
	//		│(SocketChannel)│	3 처리 요청			│	  | SocketChennl 생성	 ││	SocketChannel  │││
	//		└───────────────┘←─────────────────────────────────────────→ ││		4 작업 처리	   │││
	//							5 응답			│	  |					 │└────────────────┘││
	//											│	  |		2			 └──────────────────┘│
	//		┌───────────────┐	1 연결 요청			│	  |	   스레드 생성		 ┌──────────────────┐│
	//		│	클라이언트2		│──────────────────────────────────────────→ │	작업 스레드 2	    ││
	//		│(SocketChannel)│	3 처리 요청			│	  | SocketChennl 생성	 │┌────────────────┐││
	//		└───────────────┘←─────────────────────────────────────────→ ││	SocketChannel  │││
	//							5 응답			│	  |					 ││		4 작업 처리	   │││
	//											│	  |					 │└────────────────┘││
	//											│	  ↓					 └──────────────────┘│
	//											└────────────────────────────────────────────┘
	
	// 위와 같이 스레드 병렬 처리를 할 경우 수천 개의 클라이언트가 동시에 연결되면 수천 개의 스레드가 서버에 생성되기 때문에 서버 성능이 급격히 저하되고, 다운되는 현상이 발생할 수 있다.
	// 클라이언트의 폭증으로 인해 서버의 과도한 스레드 생성을 방지하려면 스레드풀을 사용하는 것이 바람직하다. 다음은 스레드풀을 이용할 경우 서버 구현 방식을 보여준다.
	
	//
	//
	//									┌───────────────────────────────────────────────────────────────────────────┐
	//									│																		서버	│
	//									│					┌───────────────────────────────────────────────────┐	│
	//						1 연결 요청		│	수락 작업 생성		│	스레드풀(ExecutorService)							│	│
	//		┌───────────────────┐───────────→	■	────┐	│	  작업 큐					 ┌──────────┐			│	│
	//		│	클라이언트 1...n	│3 처리 요청│	요청 작업 생성	│	│	┌───────┐───────────────→│	스레드 1	│			│	│
	//		│	SocketChannel	│───────────→	■	────┼──────→│ ■ ■ ■	│				 │수락 작업 처리	│			│	│
	//		└───────────────────┘───┐	│	요청 작업 생성	│	│	└───────┘───────────┐	 │	  ■	   2 SocketChannel 생성	
	//				↑		3 처리 요청	└───────→	■	────┘	│	각 스레드는 큐에서			│	 └──────────┘			│	│
	//				│					│					│	작업을 가져와 실행시킴		│	 ┌──────────┐			│	│
	//				│					│					│						└───→│	스레드 2	│			│	│
	//				│					│					│							 │요청 작업 처리	│			│	│
	//				│					│					│							 │	  ■	   4 SocketChannel 사용
	//				│5 응답				│					│							 └──────────┘			│	│
	//				└─────────────────────────────────────────────────────────────────────────┘		스레드 수 제한	│	│
	//									│					└───────────────────────────────────────────────────┘	│
	//									└───────────────────────────────────────────────────────────────────────────┘
	
	// 스레드풀은 스레드 수를 제한해서 사용하기 때문에 갑작스런 클라이언트의 폭증은 작업 큐의 작업량만 증가할 뿐 스레드 수에는 변함이 없기 때문에 서버 성능은 완만히 저하된다.
	// 다만 대기하는 작업량이 증가하기 때문에 개별 클라이언트에서 응답을 늦게 받을 수 있다. 이 경우 서버의 하드웨어 사양에 맞게 적절히 스레드풀의 스레드 수를 늘려주면 된다.
	
			//	Chatting Server Implementation		채팅 서버 구현
	
	// 채팅 서버를 구현해보면서 SocketChannel이 어떻게 사용되는지 이해해보자.
	
			/*	Server Class Structure		서버 클래스 구조	*/
	
	// 다음은 서버 클래스의 구조를 보여준다.
	
	// 24_ JavaFX 메인 클래스로 만들기 위해 Application을 상속받는다.
	// 25_ 스레드풀인 ExecutorService 필드를 선언한다.
	// 26_ 클라이언트의 연결을 수락하는 ServerSocketChannel 필드를 선언한다.
	// 27_ 연결된 클라이언트를 저장하는 List<Client> 타입의 connections 필드를 선언한다. 그리고 스레드에 안전한 Vector로 초기화한다.
	// 29_ startClient()는 서버 시작 시 호출되는 메소드이다.
	// 73_ stopServer()는 서버 종료 시 호출되는 메소드이다.
	// 95_ Client 클래스는 연결된 클라이언트를 표현하는데, 데이터 통신 코드를 포함한다.
	// 175_ UI 생성 코드는 레이아웃을 구성하고 ServerExample을 실행시킨다.
	
	// 실행 화면에서 [start] 버튼을 클릭하면 startServer() 메소드가 호출되고, [start] 버튼은 [stop] 버튼으로 변경된다. 
	// [stop] 버튼을 클릭하면 stopServer() 메소드가 호출되고, 다시 [start] 버튼으로 변경된다.
	
			/*	startServer() Method	*/
	
	// [start] 버튼을 클릭하면 startServer() 메소드가 실행되는데, startServer() 메소드에서는 ExecutorService 생성, ServerSocketChannel 생성 및 포트 바인딩, 연결 수락 코드가 필요하다.
	// 다음은 CPU 코어의 수에 맞게 스레드를 생성해서 관리하는 ExecutorService를 생성한다.
	
	//	01	void startServer() {
	//	02		executorService = Executors.newFixedThreadPool(
	//	03			Runtime.getRuntime().availableProcessors()
	//	04		);
	
	// 다음은 5001번 포트에서 클라이언트의 연결을 수락하는 ServerSocketChannel을 생성한다.
	
	//	01	try {
	//	02		serverSocketChannel = ServerSocketChannel.open();
	//	03		serverSocketChannel.configureBlocking(true);
	//	04		serverSocketChannel.bind(new InetSocketAddress(5001));
	//	05	} catch(Exception e) {
	//	06		if(serverSocketChannel.isOpen()) { stopServer(); }
	//	07		return;
	//	08	}
	
	// 06 ~ 07_ 5001번 포트를 이미 다른 프로그램에서 사용하고 있다면 java.net.BindException이 발생한다. 이 경우에는 ServerSocketChannel이 열려 있는지 확인하고,
	//			stopServer() 메소드를 실행한다. 그리고 return을 실행해서 startServer() 메소드를 종료한다.
	
	// 다음은 연결 수락 작업을 Runnable 객체로 만들고 스레드풀의 작업 스레드로 실행시키는 코드이다. ServerSocketChannel은 반복해서 클라이언트 연결 요청을 기다려야 하므로 스레드풀의 작업 스레드상에서
	// accept() 메소드를 반복적으로 호출해주어야 한다.
	
	//	01	Runnable runnable = new Runnable() {
	//	02		@Override
	//	03		public void run() {
	//	04			Platform.runLater( () -> {
	//	05				displayText("[서버 시작]");
	//	06				btnStartStop.setText("stop");
	//	07			});
	//	08			while(true) {
	//	09				try {
	//	10					SocketChannel socketChannel = serverSocketChannel.accept();			// 연결 수락
	//	11					String message = "[연결 수락: " + socketChannel.getRemoteAddress() +
	//	12										": " + Thread.currentThread().getName() + "]";
	//	13					Platform.runLater( () -> displayText(message) );
	//	14		
	//	15					Client client = new Client(socketChannel);	// Client 객체 저장
	//	16					connections.add(client);
	//	17
	//	18					Platform.runLater( () -> displayText("[연결 개수: " + connections.size() + "]") );
	//	19				} catch (Exception e) {
	//	20					if(serverSocketChannel.isOpen()) { stopServer(); }
	//	21					break;
	//	22				}
	//	23			}
	//	24		}
	//	25	};
	//	26	executorService.submit(runnable);	// 스레드풀에서 처리
	//	27	}	// startServer() 메소드 끝
	
	// 01_ 연결 수락 작업을 Runnable로 정의한다.
	// 04 ~ 07_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용되었다. "[서버 시작]"을 출력하도록 displayText()를 호출하고, [start] 버튼의 글자를 [stop]으로 변경한다.
	// 08_ 반복적으로 클라이언트의 연결을 수락하기 위해 무한 루프를 작성한다.
	// 10_ ServerSocketChannel의 accept()를 실행해서 클라이언트의 연결 요청을 기다린다. 클라이언트가 연결 요청을 해오면 연결을 수락하고 통신용 SocketChannel을 리턴한다.
	// 11 ~ 13_ "[연결 수락: 클라이언트 IP: 작업 스레드 이름]"으로 문자열을 생성하고, 출력하기 위해 displayText()를 호출한다.
	// 15 ~ 16_ SocketChannel로 Client 객체를 생성하고 connections 컬렉션에 추가한다.
	// 18_ "[연결 개수: 현재 관리되고 있는 Client 객체 수]"로 문자열을 생성하고, 출력하기 위해 displayText()를 호출한다.
	// 20 ~ 21_ accept()에서 예외가 발생하면 ServerSocketChannel이 열려있는지 확인하고 stopServer()를 호출한다. 그리고 무한 루프를 종료시킨다.
	// 26_ 연결 수락 작업을 스레드풀에서 처리하기 위해 ExecutorService의 submit()을 호출한다.
	
			/*	stopServer() Method	*/
	
	// [stop] 버튼을 클릭하면 stopServer() 메소드가 실행되는데, stopServer() 메소드에서는 연결된 모든 
	// SocketChannel 닫기, ServerSocketChannel 닫기, ExecutorService 종료 코드가 필요하다.
	
	//	01	void stopServer() {
	//	02		try {
	//	03			Iterator<Client> iterator = connections.iterator();		// 모든 SocketChannel 닫기
	//	04			while(iterator.hasNext()) {
	//	05				Client client = iterator.next();
	//	06				client.socketChannel.close();
	//	07				iterator.remove();
	//	08			}
	//	09			if(serverSocketChannel != null && serverSocketChannel.isOpen()) {	// ServerSocketChannel 닫기
	//	10				serverSocketChannel.close();
	//	11			}
	//	12			if(executorService != null && !executorService.isShutdown()) {	// ExecutorService 종료
	//	13				executorService.shutdown();
	//	14			}
	//	15			Platform.runLater( () -> {
	//	16				displayText("[서버 멈춤]");
	//	17				btnStartStop.setText("start");
	//	18			});
	//	19		} catch (Exception e) {}
	//	20	}
	
	// 03_ connections 컬렉션으로부터 반복자를 얻어낸다.
	// 04 ~ 08_ while문으로 반복자를 반복하면서 Client를 하나씩 얻는다. Client가 가지고 있는 SocketChannel을 닫고 connections 컬렉션에서 Client를 제거한다.
	// 09 ~ 11_ ServerSocketChannel이 null이 아니고, 열려 있으면 ServerSocketChannel을 닫는다.
	// 12 ~ 14_ ExecutorService가 null이 아니고, 열려 있으면 ExecutorService를 종료한다.
	// 15 ~ 18_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용되었다. "[서버 멈춤]"을 출력하도록 displayText()를 호출하고, [stop] 버튼의 글자를 [start]로 변경한다.
	
			/*	Client Class	*/
	
	// 서버는 다수의 클라이언트가 연결하기 때문에 클러이언트를 관리해야 한다. 클라이언트별로 고유한 데이터를 저장할 필요도 있기 때문에 Client 클래스를 작성하고, 
	// 연결 수락 시 마다 Client 인스턴스를 생성해서 관리하는 것이 좋다. Client 클래스에는 데이터 받기 및 보내기 코드가 포함된다. 다음은 Client 클래스의 구조를 보여준다.
	
	//	01	class Client {
	//	02		SocketChannel socketChannel;
	//	03	
	//	04		Client(SocketChannel socketChannel) {
	//	05			this.socketChannel = socketChannel;
	//	06			receive();
	//	07		}
	//	08
	//	09		void receive() { // 데이터 받기 코드 }
	//	10		void send(String data) { // 데이터 전송 코드 }
	//	11	}
	
	// 01_ Client를 ServerExample의 내부 클래스로 선언한다.
	// 02_ 통신용 SocketChannel을 필드로 선언한다.
	// 04 ~ 07_ Client 생성자를 선언한다. 매개값으로 SocketChannel 필드를 초기화하고 receive()를 호출한다.
	// 09_ 클라이언트의 데이터를 받기 위해 receive() 메소드를 선언한다.
	// 10_ 데이터를 클라이언트로 보내기 위해 send() 메소드를 선언한다.
	
	// 다음 코드는 클라이언트의 데이터를 받는 receive() 메소드이다. 스레드풀의 작업 스레드가 처리하도록 Runnable로 작업을 정의하고 있고,
	// 클라이언트가 보낸 데이터를 반복적으로 받기 위해 무한 루프를 돌면서 SocketChannel의 read() 메소드를 호출하고 있다.
	
	//	01	void receive() {
	//	02		Runnable runnable = new Runnable() {
	//	03			@Override
	//	04			public void run() {
	//	05				while(true) {
	//	06					try {
	//	07						ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	08
	//	09						// 클라이언트가 비정상 종료를 했을 경우 IOException 발생
	//	10						int readByteCount = socketChannel.read(byteBuffer);		// 데이터 받기
	//	11
	//	12						// 클라이언트가 정상적으로 SocketChannel의 close()를 호출했을 경우
	//	13						if(readByteCount == -1) {
	//	14							throw new IOException();
	//	15						}
	//	16
	//	17						String message = "[요청 처리: " + socketChannel.getRemoteAddress() +
	//	18											": " + Thread.currentThread().getName() + "]";
	//	19						Platform.runLater( () -> displayText(message) );
	//	20
	//	21						byteBuffer.flip();		// 문자열로 변환
	//	22						Charset charset = Charset.forName("UTF-8");
	//	23						String data = charset.decode(byteBuffer).toString();
	//	24
	//	25						for(Client client : connections) {
	//	26							client.send(data);
	//	27						}
	//	28					} catch(Exception e) {
	//	29						try {
	//	30							connections.remove(Client.this);
	//	31							String message = "[클라이언트 통신 안됨: " +
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
	//	42		executorService.submit(runnable);		// 스레드풀에서 처리
	//	43	}
	
	// 02_ 클라이언트로부터 데이터를 받는 작업을 Runnable로 정의한다.
	// 04_ run() 메소드를 재정의한다.
	// 05_ 작업을 무한 반복한다.
	// 07_ 100개의 바이트를 저장할 수 있는 ByteBuffer를 생성한다.
	// 10_ SocketChannel의 read() 메소드를 호출한다. 클라이언트가 데이터를 보내기 전까지 블로킹된다. 데이터를 받으면 byteBuffer에 저장하고 받은 바이트 개수를 readByteCount에 저장한다.
	// 13 ~ 15_ 클라이언트가 정상적으로 SocketChannel의 close()를 호출했을 경우, 10라인의 read() 메소드는 -1을 리턴한다. 이 경우 IOException을 강제로 발생시킨다.
	// 17 ~ 19_ 정상적으로 데이터를 받았을 경우, "[요청 처리: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 생성하고 displayText()를 호출해서 출력한다.
	// 21 ~ 23_ 정상적으로 데이터를 받게 되면 받은 데이터가 저장된 ByteBuffer의 flip() 메소드를 호출해서 위치 속성값을 변경한 후 UTF-8로 디코딩한 문자열을 얻는다.
	// 25 ~ 27_ 문자열을 모든 클라이언트에게 보내기 위해 connections에 저장된 Client를 하나씩 얻어 send() 메소드를 호출한다.
	// 30_ 예외가 발생하면 connections 컬렉션에서 Client를 제거한다. 예외는 10라인과 14라인에서 발생하는데, 모두 클라이언트와 통신이 안 될 때이다.
	// 31 ~ 34_ "[클라이언트 통신 안됨: 클라이언트 IP: 작업스레드이름]" 으로 구성된 문자열을 생성하고 dispalyText()를 호출해서 출력한다.
	// 35_ SocketChannel을 닫는다.
	// 42_ 스레드풀에서 작업을 처리하기 위해 submit()을 호출한다.
	
	// 다음 코드는 데이터를 클라이언트로 보내는 send() 메소드이다. 스레드풀의 작업 스레드가 처리하도록 작업을 Runnable로 정의하고 있다.
	
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
	//	11						String message = "[클라이언트 통신 안됨: " +
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
	
	// 02_ 데이터를 클라이언트로 보내는 작업을 Runnable로 생성한다.
	// 04_ run()을 재정의한다.
	// 06 ~ 07_ send() 메소드의 매개값으로 받은 문자열로부터 UTF-8로 인코딩한 ByteBuffer를 얻는다.
	// 08_ SocketChannel의 write() 메소드를 호출한다.
	// 11 ~ 14_ 8라인에서 예외가 발생하면 "[클라이언트 통신 안됨: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 생성하고 displayText()를 호출해서 출력한다.
	// 15_ connections 컬렉션에서 예외가 발생한 Client를 제거한다.
	// 16_ SocketChannel을 닫는다.
	// 22_ 스레드풀에서 작업을 처리하기 위해 submit()을 호출한다.
	
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
	
	// 27라인은 외부 CSS 파일(app.css)을 Scene에 적용하고 있다. 그 이유는 TextArea의 배경색 때문인데, TextArea는 여러 겹의 컨테이너로 둘러싸여 있는 복잡한 구조를 가지고 있어 단순히
	// TextArea의 setStyle()로 배경색을 바꿀 수 없다. 그래서 다음과 같이 외부 CSS 클래스 선택자를 이용해서 컨테이너의 배경색을 변경했다.
	
	// text-area만 gold색으로 설정하고, 나머지 컨테이너들은 모두 투명(transparent)으로 설정함으로써 TextArea의 전체 배경색이 gold색으로 보이도록 했다.
	
	//		┌───────────────────────────────────────────────┐
	//		│	class = "text-area"							│
	//		│	┌───────────────────────────────────────┐	│
	//		│	│	class = "scroll-pane"				│	│
	//		│	│	┌───────────────────────────────┐	│	│
	//		│	│	│	class = "viewport"			│	│	│
	//		│	│	│	┌───────────────────────┐	│	│	│
	//		│	│	│	│	class = "content"	│	│	│	│
	//		│	│	│	│						│	│	│	│
	//		│	│	│	└───────────────────────┘	│	│	│
	//		│	│	└───────────────────────────────┘	│	│
	//		│	└───────────────────────────────────────┘	│
	//		└───────────────────────────────────────────────┘
	
		//	Chatting Client Implementation		채팅 클라이언트 구현
		
	// 채팅 클라이언트 구현 코드를 보면서 Socket이 어떻게 사용되는지 이해해보자.
	
			/*	Client Class Structure		클라이언트 클래스 구조		*/
	
	// 다음 예제은 클라이언트 클래스의 구조를 보여준다.
	
	// 01_ JavaFX 메인 클래스로 만들기 위해 Application을 상속한다.
	// 02_ 클라이언트 통신을 위해 SocketChannel 필드를 선언한다.
	// 04_ startClient() 메소드는 [start] 버튼을 클릭하면 호출된다.
	// 05_ stopClient() 메소드는 [stop] 버튼을 클릭하면 호출된다.
	// 06_ receive() 메소드는 서버에서 보낸 데이터를 받는다.
	// 07_ send() 메소드는 [send] 버튼을 클릭하면 호출되는데, 서버로 데이터를 보낸다.
	// 10_ UI 생성코드는 레이아웃을 구성하고 ClientExample을 실행시킨다.
	
	// 실행 화면에서 [start] 버튼을 클릭하면 startClient() 메소드가 호출되고, [start] 버튼은 [stop] 버튼으로 변경된다.
	// [stop] 버튼을 클릭하면 stopClient() 메소드가 호출되고, 다시 [start] 버튼으로 변경된다.
	
			/*	startClient() Method	*/
	
	// [start] 버튼을 클릭하면 startClient() 메소드가 실행하는데, startClient() 메소드에는 Socket 생성 및 연결 요청 코드가 있다.
	
	//	01	void startClient() {
	//	02		Thread thread = new Thread() {		// 스레드 생성
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					socketChannel = SocketChannel.open();
	//	07					socketChannel.configureBlocking(true);
	//	08					socketChannel.connect(new InetSocketAddress("localhost", 5001));
	//	09					Platform.runLater( () -> {
	//	10						try {
	//	11							displayText("[연결 완료: " + socketChannel.getRemoteAddress() + "]");
	//	12							btnConn.setText("stop");
	//	13							btnSend.setDisable(false);
	//	14						} catch (Exception e) {}	
	//	15					});
	//	16				} catch(Exception e) {
	//	17					Platform.runLater( () -> displayText("[서버 통신 안됨]"));
	//	18					if(socketChannel.isOpen()) { stopClient(); }
	//	19					return;
	//	20				}
	//	21				receive();	// 서버에서 보낸 데이터 받기
	//	22			}
	//	23		};
	//	24		thread.start();	// 스레드 시작
	//	25	}
	
	// 02_ 작업 스레드를 생성한다. 작업 스레드가 필요한 이유는 8라인의 connect()와 21라인의 receive()에서 블로킹이 일어나기 때문이다. JavaFX Application Thread는 이 메소드들을 호출하지 않는 것이 좋다.
	// 04_ run() 메소드를 재정의한다.
	// 06 ~ 07_ 통신용 블로킹 SocketChannel을 생성한다.
	// 08_ local 5001 포트로 연결 요청을 한다.
	// 09_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용되었다.
	// 11_ "[연결 완료: 서버IP]"로 구성된 문자열을 생성하고, displayText()로 출력한다.
	// 12_ [start] 버튼의 글자를 [stop]으로 변경한다.
	// 13_ [send] 버튼을 활성화한다.
	// 17_ 예외가 발생하면 "[서버 통신 안됨"]을 출력하도록 displayText()를 호출한다.
	// 18_ SocketChannel이 열려있면 stopClient() 메소드를 호출한다.
	// 19_ return을 실행해서 스레드를 종료한다.
	// 21_ 예외가 발생하지 않으면 receive() 메소드를 호출한다.
	// 24_ 작업 스레드를 시작한다.
	
			/*	stopClient() Method	*/
	
	// [stop] 버튼을 클릭하거나 서버 통신이 안 될 경우 stopClient() 메소드가 실행되는데, stopClient() 메소드에는 SocketChannel을 닫는 close() 메소드 호출 코드가 있다.
	
	//	01	void stopClient() {
	//	02		try {
	//	03			Platform.runLater( () -> {
	//	04				displayText("[연결 끊음]");
	//	05				btnConn.setText("start");
	//	06				btnSend.setDisable(true);
	//	07			});
	//	08			if(socketChannel != null && socketChannel.isOpen()) {
	//	09				socketChannel.close();	// 연결 끊기
	//	10			}
	//	11		} catch(IOException e) {}
	//	12	}
	
	// 03_ UI를 변경하기 위해 Platform.runLater()가 사용되었다.
	// 04_ "[연결 끊음]"을 출력하도록 displayText()를 호출한다.
	// 05_ [stop] 버튼의 글자를 [start]로 변경한다.
	// 06_ [send] 버튼을 비활성화한다.
	// 08_ socketChannel 필드가 null이 아니고, 현재 열려 있는 경우,
	// 09_ SocketChannel을 닫는다.
	
			/*	receive() Method	*/
	
	// receive() 메소드는 서버에서 보낸 데이터를 받는 역할을 한다. 이 메소드는 startClient()에서 생성한 작업 스레드상에서 호출된다.
	
	//	01	void receive() {
	//	02		while(true) {
	//	03			try {
	//	04				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	05	
	//	06				// 서버가 비정상적으로 종료했을 경우 IOException 발생
	//	07				int readByteCount = socketChannel.read(byteBuffer);		// 데이터 받기
	//	08	
	//	09				// 서버가 정상적으로 Socket의 close()를 호출했을 경우
	//	10				if(readByteCount == -1) {
	//	11					throw new IOException();
	//	12				}
	//	13	
	//	14				byteBuffer.flip();
	//	15				Charset charset = Charset.forName("UTF-8");
	//	16				String data = charset.decode(byteBuffer).toString();	// 문자열로 변환
	//	17	
	//	18				Platform.runLater( () -> displayText("[받기 완료]" + data)); 
	//	19			} catch(Exception e) {
	//	20				Platform.runLater( () -> displayText("[서버 통신 안됨]"));
	//	21				stopClient();
	//	22				break;
	//	23			}
	//	24		}
	//	25	}
	
	// 02_ 반복적으로 읽기 위해 무한 루프를 작성한다.
	// 04_ 받은 데이터를 저장할 길이가 100인 ByteBuffer를 생성한다.
	// 07_ SocketChannel의 read() 메소드를 호출한다. 서버가 데이터를 보내기 전까지 블로킹 되고, 데이터를 받으면 byteBuffer에 저장한 후 받은 바이트 개수는 readByteCount에 저장한다.
	// 10 ~ 12_ 서버가 정상적으로 Socket의 close()를 호출했을 경우, 7라인의 read() 메소드는 -1을 리턴한다. 이 경우 IOException을 강제로 발생시킨다.
	// 14 ~ 16_ 정상적으로 데이터를 받았을 경우, flip() 메소드로 ByteBuffer의 위치 속성값을 변경하고 UTF-8로 디코딩한 문자열을 얻는다.
	// 18_ "[받기 완료] + 받은 문자열"을 출력하도록 displayText()를 호출한다.
	// 20_ 서버가 비정상적으로 연결을 끊게 되면 7라인에서 IOExceptiond이 발생하고, 서버 측 SocketChannel이 close()를 호출해서 정상적으로 연결을 끊게 되면 11라인에서 IOException을 발생한다.
	//		예외가 발생하면 "[서버 통신 안됨]"을 출력하도록 displayText()를 호출한다.
	// 21_ stopClient()를 호출한다.
	// 22_ break를 실행해서 무한루프를 빠져나온다.
	
			/*	send(String data) Method	*/
	
	// 사용자가 메세지를 입력하고 [send] 버튼을 클릭하면 메세지를 매개값으로 해서 send(String data) 메소드가 호출된다.
	// 이 메소드는 메세지를 서버로 보내는 역할을 한다.
	
	//	01	void send(String data) {
	//	02		Thread thread = new Thread() {	// 스레드 생성
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					Charset charset = Charset.forName("UTF-8");
	//	07					ByteBuffer byteBuffer = charset.encode(data);
	//	08					socketChannel.write(byteBuffer);	// 서버로 데이터 보내기
	//	09					Platform.runLater( () -> displayText("[보내기 완료]"));
	//	10				} catch(Exception e) {
	//	11					Platform.runLater( () -> displayText("[서버 통신 안됨]"));
	//	12					stopClient();
	//	13				}
	//	14			}
	//	15		};
	//	16		thread.start();	// 스레드 생성
	//	17	}
	
	// 02_ 데이터를 서버로 보내는 새로운 작업 스레드를 생성한다.
	// 04_ run()을 재정의한다.
	// 06 ~ 07_ send() 메소드의 매개값으로 받은 문자열로부터 UTF-8로 인코딩한 ByteBuffer를 얻는다.
	// 08_ ByteBuffer 내용을 서버로 전송하기 위해 SocketChannel의 write()를 호출한다.
	// 09_ "[보내기 완료]"를 출력하도록 displayText()를 호출한다.
	// 11_ 8라인에서 예외가 발생하면 "[서버 통신 안됨]"을 출력하도록 displayText()를 호출한다.
	// 12_ stopClient()를 호출한다.
	// 16_ 작업 스레드를 시작한다.
	
			/*	UI Creation Code	UI 생성 코드	*/
	
	// 다음은 ClientExample UI 생성 코드를 보여준다. 프로그램적 레이아웃을 이용해서 컨트롤을 배치했다.
	
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
	
	// 다음은 채팅 서버와 클라이언트를 실행하는 방법을 보여준다. 서버인 ServerExample을 한 개 실행하고 클라이언트인 ClientExample을 두 개 실행한다.
	
	//		┌───────────────────────┐		┌───────────────────────┐		┌───────────────────────┐
	//		│Server			  ─	□ x	│		│Client			  ─	□ x	│		│Client			  ─	□ x	│
	//		├───────────────────────┤		├───────────────────────┤		├───────────────────────┤
	//		│						│		│						│		│						│
	//		│						│		│						│		│						│
	//		│						│		│						│		│						│
	//		├───────────────────────┤		├──────┬──────────┬─────┤		├──────┬──────────┬─────┤
	//		│		  start			│		│ start│		  │ send│		│ start│		  │ send│
	//		└───────────────────────┘		└──────┴──────────┴─────┘		└──────┴──────────┴─────┘
	
	// ServerExample의 [start] 버튼을 클릭하고, 이어서 두 개의 ClientExample의 [start] 버튼을 각각 클릭한다. 
	// 그 결과로 ServerExample에서 연결 개수가 2로 나오는지 확인한다.
	
	//		┌───────────────────────┐		┌───────────────────────┐		┌───────────────────────┐
	//		│Server			  ─	□ x	│		│Client			  ─	□ x	│		│Client			  ─	□ x	│
	//		├───────────────────────┤		├───────────────────────┤		├───────────────────────┤
	//		│[서버시작]				│		│[연결 완료: loaclhost...]	│		│[연결 완료: loaclhost...]	│
	//		│[연결 수락: .. thread - 3]	│		│						│		│						│
	//		│[연결 개수: 1]				│		│						│		│						│
	//		│[연결 수락: .. thread - 2]	│		│						│		│						│
	//		│[연결 개수: 2]				│		│						│		│						│
	//		├───────────────────────┤		├──────┬──────────┬─────┤		├──────┬──────────┬─────┤
	//		│		  stop 			│		│ start│		  │ send│		│ start│		  │ send│
	//		└───────────────────────┘		└──────┴──────────┴─────┘		└──────┴──────────┴─────┘
	
	// 두 개의 ClientExample 입력란에 메세지를 입력하고 [send] 버튼을 클릭한다.
	// 그 결과로 ServerExample에서는 연결 처리가 출력되고 각각의 ClientExample에서는 메세지가 출력되는 것을 확인한다.
	
	//		┌───────────────────────┐		┌───────────────────────┐		┌───────────────────────┐
	//		│Server			  ─	□ x	│		│Client			  ─	□ x	│		│Client			  ─	□ x	│
	//		├───────────────────────┤		├───────────────────────┤		├───────────────────────┤
	//		│:						│		│[연결 완료: loaclhost...]	│		│[연결 완료: loaclhost...]	│
	//		│[요청 처리: .. thread - 2]	│		│[보내기 완료]				│		│[받기 완료] 첫 번째			│				
	//		│[요청 처리: .. thread - 1]	│		│[받기 완료] 첫 번째			│		│[보내기 완료]				│
	//		│						│		│[받기 완료] 두 번째			│		│[받기 완료] 두 번째			│
	//		│						│		│						│		│						│
	//		│						│		│						│		│						│
	//		├───────────────────────┤		├──────┬──────────┬─────┤		├──────┬──────────┬─────┤
	//		│		  stop			│		│ start│첫 번째	  │ send│		│ start│두 번째	  │ send│
	//		└───────────────────────┘		└──────┴──────────┴─────┘		└──────┴──────────┴─────┘
	
	// 첫 번째 ClientExample의 [stop] 버튼을 클릭한다. 그 결과로 ClientExample에서 연결 끊음이 출력되고, ServerExample에서 클라이언트 통신 안됨이 출력되는지 확인 한다.
	
	//		┌───────────────────────┐		┌───────────────────────┐		┌───────────────────────┐
	//		│Server			  ─	□ x	│		│Client			  ─	□ x	│		│Client			  ─	□ x	│
	//		├───────────────────────┤		├───────────────────────┤		├───────────────────────┤
	//		│:						│		│:						│		│[연결 완료: loaclhost...]	│
	//		│[클라이언트 통신 안됨: ..]		│		│[서버 통신 안됨]				│		│[받기 완료] 첫 번째			│				
	//		│						│		│[연결 끊음]				│		│[보내기 완료]				│
	//		│						│		│						│		│[받기 완료] 두 번째			│
	//		│						│		│						│		│						│
	//		│						│		│						│		│						│
	//		├───────────────────────┤		├──────┬──────────┬─────┤		├──────┬──────────┬─────┤
	//		│		  stop			│		│ start│		  │ send│		│ start│		  │ send│
	//		└───────────────────────┘		└──────┴──────────┴─────┘		└──────┴──────────┴─────┘
	
	// ServerExample의 [stop] 버튼을 클릭한다. 그 결과로 ServerExample에서 서버 멈춤이 출력되고, ClientExample에서 서버 통신 안됨이 출력되는지 확인한다.
	
	//		┌───────────────────────┐		┌───────────────────────┐		┌───────────────────────┐
	//		│Server			  ─	□ x	│		│Client			  ─	□ x	│		│Client			  ─	□ x	│
	//		├───────────────────────┤		├───────────────────────┤		├───────────────────────┤
	//		│:						│		│:						│		│[연결 완료: loaclhost...]	│
	//		│[클라이언트 통신 안됨: ..]		│		│[서버 통신 안됨]				│		│[받기 완료] 첫 번째			│				
	//		│[클라이언트 통신 안됨: ..]		│		│[연결 끊음]				│		│[보내기 완료]				│
	//		│[서버 멈춤]				│		│						│		│[받기 완료] 두 번째			│
	//		│						│		│						│		│[서버 통신 안됨]				│
	//		│						│		│						│		│[연결 끊음]				│
	//		├───────────────────────┤		├──────┬──────────┬─────┤		├──────┬──────────┬─────┤
	//		│		  start			│		│ start│		  │ send│		│ start│		  │ send│
	//		└───────────────────────┘		└──────┴──────────┴─────┘		└──────┴──────────┴─────┘
	
			//	Blocking And Interrupt		블로킹과 인터럽트
	
	// IO의 Socket에서는 입출력 스트림의 read()와 write() 메소드로 인해 작업 스레드가 블로킹되었을 때 다른 스레드가 작업 스레드의 interrupt() 메소드를 호출해도 블로킹 상태가 풀리지 않는다.
	// 그래서 Socket의 close() 메소드를 호출해서 SocketException을 발생시켜야 한다.
	// 그러나 NIO의 SocketChannel의 경우 read()와 write() 메소드로 인해 작업 스레드가 블로킹되었을 때 다른 스레드가 작업 스레드의 interrupt() 메소드를 호출하면
	// ClosedByInterruptException이 발생하고 SocketChannel을 닫을 수도 있는데, 이때에는 AsynchronousCloseException이 발생되면서 블로킹 상태가 풀린다.
	// 다음 코드는 작업 스레드의 interrupt() 메소드를 호출해서 읽는 작업을 중지시키면서 SocketChannel을 닫도록 유도한다.
	
	//	Thread thread = null;
	//	public void receive() {
	//		thread = new Thread() {
	//			@Override
	//			public void run() {
	//				try {								┌───────────────────┐
	//					...								↓					│
	//					int byteCount = socketChannel.read(byteBuffer);	┐	│
	//					...			ClosedByInterruptException 발생		│2	│
	//				} catch(Exception e) {		┌───────────────────────┘	│
	//					socketChannel.close();	↓							│
	//				}														│1
	//			}															│
	//		};																│
	//		thread.start();													│
	//	}																	│
	//																		│
	//	public void stop() {			다른 스레드가 stop()을 호출					│
	//		thread.interrupt();	────────────────────────────────────────────┘
	//	}
}
