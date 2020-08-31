package 챕터19_NIO;

public class ㅇ_TCP_AsynchronousChannel {
	// NIO는 TCP 블로킹, 넌블로킹 채널 이외에 TCP 비동기 채널로, AsynchronousServerSocketChannel과 AsynchronousSocketChannel을 제공한다.
	// 각각 ServerSocketChannel과 SocketChannel에 대응하는 클래스로 NIO의 보석같은 클래스이다. 두 클래스의 사용 방법을 알아보기로 하자.
	
			//	Characteristic Of Asynchronous Channel
	
	// TCP 비동기 채널은 연결 요청(connect()), 연결 수락(accept()), 읽기(read()), 쓰기(write())를 호출하면 즉시 리턴한다..
	// 이것은 넌블로킹 방식과 동일하다. 차이점은 이 메소드들을 호출하면 스레드풀에게 작업 처리 요청하고 이 메소드들은 즉시 리턴된다. 실질적인 작업 처리는 스레드풀의 작업 스레드가 담당한다.
	// 작업 스레드가 작업을 완료하게 되면 콜백(callback) 메소드가 자동 호출되기 때문에 작업 완료 후 실행해야 할 코드가 있다면 콜백 메소드에서 작성하면 된다.
	
	//	┌───────────────────────────────────────────────────────────────────────────────┐
	//	│ 비동기 처리 방식																	│
	//	│	|																			│
	//	│	| 1 accept() ┌──────┐				┌───────────────────────────────────┐	│
	//	│	|──────────→ │ 비동기	│	3 작업 처리		│스레드풀			┌───────────┐ ┐		│	│
	//	│	|←────────── │  채널	■───┐ 요청		│				│	스레드 1	│ │		│	│
	//	│	|	2 즉시 리턴    └──────┘	│			│			 ┌→	│  5 작업 처리	│ │ 최	│	│
	//	│	|←───────────── 스레드 1	│			│	4 작업 큐	 │	│	  ■		│ │ 대	│	│
	//	│	| 6 콜백 메소드 호출			│			│	┌───────┐┘	└───────────┘ │ 개	│	│
	//	│	| 6 콜백 메소드 호출			■─────────────→	│ ■ ■ ■	│	┌───────────┐ │ 수	│	│
	//	│	|←─────────────	스레드 2	│			│	└───────┘─→	│	스레드 2	│ │  	│	│
	//	│	|1 read/write() ┌────┐	│			│	각 스레드는 큐에서	│  5 작업 처리	│ │ 제	│	│
	//	│	|──────────→ 	│비동기│	│			│작업을 가져와 실행시킴	│	  ■		│ │ 한	│	│
	//	│	|←────────── 	│채널	 ■──┘		요청	│				└───────────┘ │		│	│
	//	│	|	2 즉시 리턴	 	└────┘		3 작업 처리	│					  :		  │		│	│
	//	│	↓									│					스레드 n	  ┘		│	│
	//	│										└───────────────────────────────────┘	│
	//	└───────────────────────────────────────────────────────────────────────────────┘
	
	// 그림을 좀 더 단순화시켜 이해해보자. 애플리케이션에서 read() 메소드를 호출하면 즉시 리턴되지만, 실질적으로 내부에서는 스레드풀의 작업 스레드가 read() 메소드를 실행한다.
	// 작업 스레드가 read() 메소드를 모두 실행하고 나면 콜백 메소드인 completed() 메소드가 자동 호출된다. 이때 completed() 메소드를 실행하는 스레드는 스레드풀의 작업 스레드이다.
	
	//
	//										┌───────────────────────────┐
	//										│	스레드풀(ExecutorService)	│
	//		┌───────────┐	2 read() 호출		│		작업 스레드				│
	//		│ 1 실행	│---------------------------→┌──────────────┐		│
	//		│		↓←---------------------------│ read() {		│		│
	//		└───────────┘	즉시 리턴			│	 │		│		│		│
	//										│	 │		│		│		│
	//										│	 │		│ 3 실행	│		│
	//		┌───────────────────┐			│	 │		│		│		│
	//		│ completed() 메소드	│			│	 │		│		│		│
	//		│  5 실행	┌───────────────────────────────────↓		│		│
	//		│		↓			│			│	 └──────────────┘		│
	//		└───────────────────┘			└───────────────────────────┘
	
			// Asynchronous Channel Group		비동기 채널 그룹
	
	// 비동기 서버소켓 채널(AsynchronousServerSocketChannel)과 비동기 소켓 채널(AsynchronousSocketChannel)을 살펴보기 전에 
	// 우선 비동기 채널 그룹(AsynchronousChannelGroup)에 대해서 이해해보자. 비동기 채널 그룹은 같은 스레드풀을 공유하는 비동기 채널들의 묶음이라고 볼 수 있다.
	// 하나의 스레드풀을 사용한다면 모든 비동기 채널은 같은 채널 그룹에 속해야 한다.
	
	//	┌────────  비동기 채널 그룹  ──────────────────────────────────────────────────────────────────┐
	//	│	(AsynchronousChannelGroup)															│
	//	│												스레드풀(ExecutorService)					│
	//	│												┌───────────────────────────────────┐	│
	//	│							연결 요청				│				┌───────────┐ ┐		│	│
	//	│AsynchronousServerSocketChannel■───┐ 수락		│				│	스레드 1	│ │		│	│
	//	│									│			│			 ┌→	│ 연결 수락 처리	│ │ 최	│	│
	//	│	AsynchronousSocketChannel		│			│	   작업 큐	 │	│	  ■		│ │ 대	│	│
	//	│	 								│			│	┌───────┐┘	└───────────┘ │ 개	│	│
	//	│	 								■─────────────→	│ ■ ■ ■	│	┌───────────┐ │ 수	│	│
	//	│				:					│			│	└───────┘─→	│	스레드 2	│ │  	│	│
	//	│				:					│			│	각 스레드는 큐에서	│ 연결 수락 처리	│ │ 제	│	│
	//	│									│			│작업을 가져와 실행시킴	│	  ■		│ │ 한	│	│
	//	│		AsynchronousSocketChannel■──┘	요청		│				└───────────┘ │		│	│
	//	│									   입출력		│					  :		  │		│	│
	//	│												│					스레드 n	  ┘		│	│
	//	│												└───────────────────────────────────┘	│
	//	└───────────────────────────────────────────────────────────────────────────────────────┘
	
	// 비동기 채널을 생성할 때 채널 그룹을 지정하지 않으면 기본 비동기 채널 그룹이 생성된다. 기본 비동기 채널 그룹은 내부적으로 다음과 같이 스레드풀을 생성한다.
	
	//	new ThreadPoolExceutor(
	//		0, Integer.MAX_VALUE,
	//		Long.MAX_VALUE, TimeUnit.MILLISECONDS,
	//		new SynchronousQueue<Runnable>(),
	//		threadFactory);
	
	// 이론적으로 Integer.MAX_VALUE개만큼 스레드가 증가할 수 있도록 되어 있다. 
	// 하지만 스레드풀은 대부분 최대 스레드 수를 지정해서 사용하므로 다음과 같이 AsynchronousChannelGroup을 직접 생성하고 사용하는 것이 일반적이다.
	
	//	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//		최대스레드 수,
	//		Executors.defaultThreadFactory()
	//	);
	
	// 다음은 CPU 코어의 수만큼 스레드를 관리하는 스레드풀을 생성하고 이것을 이용하는 비동기 채널 그룹을 생성한다.
	
	//	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors(),
	//		Executors.defaultThreadFactroy()
	//	);
	
	// 이렇게 생성된 비동기 채널 그룹은 비동기 채널을 생성할 때 매개값으로 사용된다. 비동기 채널 그룹을 더 이상 사용하지 않고 종료할 경우에는 shutdown()과 shutdownNow() 메소드를 호출할 수 있다.
	
	//	channelGroup.shutdown();
	//	channelGroup.shutdownNow();
	
	// shutdown()은 비동기 채널 그룹을 종료하겠다는 의사만 전달할 뿐 즉시 비동기 채널 그룹을 종료하지 않는다. 비동기 채널 그룹에 포함된 모든 비동기 채널이 닫히면 비로소 채널 그룹이 종료된다.
	// shutdown() 메소드를 호출한 이후에 새로운 비동기 채널을 비동기 채널 그룹에 포함시키면 ShutdownChannelGroupExceptio이 발생한다.
	// shutdown()는 강제적으로 비동기 채널 그룹에 포함된 모든 비동기 채널을 닫아버리고 비동기 채널 그룹을 종료한다.
	// 단, 완료 콜백을 실행하고 있는 스레드는 종료되거나, 인터럽트되지 않는다.
	
			//	Asynchronous ServerSocket Channel
	
	// AsynchronousServerSocketChannel은 두 가지 정적 메소드인 open()을 호출해서 얻을 수 있다. 기본 비동기 채널 그룹에 포함되는 AsynchronousServerChannel을 얻는 방법은 다음과 같이
	// 매개값 없는 open() 메소드를 호출하는 것이다.
	
	//	AsynchronousServerSocketChannel asynchronousServerSocketChannel =
	//	AsynchronousServerSocketChannel.open();
	
	// 별도로 비동기 채널 그룹을 생성하고 여기에 포함되는 AsynchronousServerSocketChannel을 얻고 싶다면 다음과 같이 비동기 채널 그룹을 매개값으로 갖는 open() 메소드를 호출하면 된다.
	
	//	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors(),
	//		Executors.defaultThreadFactory()
	//	);
	//	AsynchronousServerSocketChannel asynchronousServerSocketChannel = 
	//	AsynchronousServerSocketChannel.open(channelGroup);
	
	// AsynchronousServerSocketChannel을 생성하고 나서는 포트 바인딩을 위해 다음과 같이 bind() 메소드를 호출해야 한다.
	
	//	asynchronousServerSocketChannel.bind(new InetSocketAddress(5001));
	
	// AsynchronousServerSocketChannel을 더 이상 사용하지 않을 경우에는 close() 메소드를 호출해서 서버가 사용한 포트를 언바인딩해준다.
	
	//	asynchronousServerSocketChannel.close();
	
	// AsynchronousServerSocketChannel은 연결 수락 작업을 스레드풀을 이용해서 비동기로 처리한다. 다음은 accept() 메소드를 호출하는 코드이다.
	
	//	accept(A attachment, CompletionHandler<AsynchronousSocketChannel, A> handler);
	
	// 첫 번째 매개값은 콜백 메소드의 매개값으로 제공할 첨부 객체인데, 연결 수락 작업에는 별도의 첨부 객체가 필요하지 않기 때문에 null을 지정한다.
	// 두 번째 매개값은 콜백 메소드를 가지고 있는 CompletionHandler<AsynchronousSocketChannel, A> 구현 객체이다.
	// A는 첨부 객체 타입인데, 연결 수락 작업에는 별도의 첨부 객체가 필요하지 않기 때문에 Void로 지정한다. 다음은 accept() 메소드를 호출하는 기본 뼈대를 보여준다.
	
	//	asynchronousServerSocketChannel.accept(null,
	//		new CompletionHanlder<AsynchronousSocketChannel, Void>() {
	//		@Override
	//		public void completed(AsynchronousSocketChannel asynchronousSocketChannel ,
	//								Void attachment) {
	//			// 연결 수락 후 실행할 코드
	//			asynchronousServerSocketChannel.accept(null, this);	// accept() 재호출
	//		}
	//		@Override
	//		public void failed(Throwable exc, Void attachment) {
	//			// 연결 수락 실패 시 실행할 코드
	//		}
	//	});
	
	// completed() 메소드는 연결 수락이 완료되었을 때 스레드풀의 스레드가 호출한다. 첫 번째 매개값은 연결 수락 후 리턴된 AsynchronousSocketChannel이 대입되고,
	// 두 번째 매개값은 첨부 객체인데 accept()의 첫 번째 매개값이 null이므로 null이 대입된다. 만약 스레드풀의 스레드가 연결 수락에 문제가 생겨 예외를 발생시키면 failed()가 호출된다.
	// failed()의 첫 번째 매개값은 예외 객체이고 두 번째 매개값은 첨부 객체인데 accept()의 첫 번째 매개값이 null이므로 null이 대입된다.
	// 주목할 점은 accept()를 반복해서 호출하는 무한 루프가 없다는 것이다. 대신 completed() 메소드 끝에 accept()를 재호출해서 반복적으로 클라이언트의 연결 수락 작업을 수행한다.
	
			//	Asynchronous Socket Channel
	
	// AsynchronousSocketChannel은 서버와 클라이언트에 각각 존재하는데, 클라이언트가 AsynchronousSocketChannel을 생성해서 서버로 연결 요청을 하면 서버의
	// AsynchronousServerSocketChannel은 연결 수락 후 AsynchronousSocketChannel을 생성해서 서로 통신할 수 있도록 만들어준다.
	// AsynchronousServerSocketChannel이 생성하는 AsynchronousSocketChannel은 자동적으로 AsynchronousServerSocketChannel과 같은 비동기 채널 그룹에 속하게 된다.
	// 클라이언트에서 AsynchronousSocketChannel을 생성하려면 두 가지 open() 메소드를 사용할 수 있다. 기본 비동기 채널에 포함되는 AsynchronousSocketChannel을 얻고 싶다면
	// 매개값없는 open() 메소드를 호출하면 된다.
	
	//	AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open();
	
	// 별도로 비동기 채널 그룹을 생성하고 여기에 포함되는 AsynchronousSocketChannel을 얻고 싶다면 다음과 같이 비동기 채널 그룹을 매개값으로 갖는 open() 메소드를 호출하면 된다.
	
	//	AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors();
	//		Executors.defaultThreadFactory()
	//	);
	//	AsynchronousSocketChannel asynchronousSocketChannel = 
	//	AsynchronousSocketChannel.open(channelGroup);
	
	//	AsynchronousSocketChannel을 더 이상 사용하지 않을 경우에는 close() 메소드를 호출해서 연결을 끊어준다.
	
	//	asynchronousSocketChannel.close();
	
	// 클라이언트가 생성하는 AsynchronousSocketChannel은 서버 요청 작업을 스레드풀을 이용해서 비동기로 처리한다. 다음은 connect() 메소드를 호출하는 코드이다.
	
	//	connect(SocketAddress remote, A attachment, CompletionHandler<Void, A> handler);
	
	// 첫 번째 매개값은 서버 IP와 연결 포트 정보를 가진 InetSocketAddress 객체이다. 두 번째 매개값은 콜백 메소드의 매개값으로 제공할 첨부 객체인데, 
	// 연결 요청 작업에는 별도의 첨부 객체가 필요하지 않기 때문에 null을 지정한다. 세 번째 매개값은 CompletionHandler<Void, A> 구현 객체이다. 
	// A는 첨부 객체 타입인데, 연결 요청 작업에는 별도의 첨부 객체가 필요하지 않기 때문에 Void로 지정한다.
	// 다음은 connect() 메소드를 호출하는 기본 뼈대를 보여준다.
	
	//	asynchronousSocketChannel.connect(new InetSocketAddress("localhost", 5001), null,
	//		new CompletionHandler<Void, Void>() {
	//			@Override
	//			public void completed(Void result, Void attachment) {
	//				// 연결 성공 후 실행할 코드
	//			}
	//			@Override
	//			public void failed(Throwable e, Void attachment) {
	//				// 연결 실패 후 실행할 코드
	//			}
	//		});
	//
	
	// completed() 메소드는 연결이 성송했을 때 스레드풀의 스레드를 호출한다. 첫 번째 매개값은 null이 대입되고, 두 번째 매개값은 첨부 객체인데 connect()의 두 번째 매개값이 null이므로 null이 대입된다.
	// completed() 메소드에는 서버가 보낸 데이터를 받기 위한 모드가 일반적으로 작성된다. 만약 스레드풀의 스레드가 연결 요청에 문제가 생겨 예외가 발생되면 failed()가 호출된다.
	// 첫 번째 매개값은 예외 객체이고, 두 번째 매개값은 첨부 객체인데 connect()의 두 번째 매개값이 null이므로 null이 대입된다.
	
			//	Asynchronous Socket Channel Data Communication
	
	// 클라이언트와 서버가 연결되면 양쪽 AsynchronousSocketChannel의 read()와 write() 메소드로 데이터 통신을 할 수 있다.
	// 이 메소드들은 호출하는 즉시 리턴되고, 실질적인 입출력 작업은 스레드풀의 스레드가 담당한다. 다음은 read()와 write()를 호출하는 코드이다.
	
	//	read(ByteBuffer dst, A attachment, CompletionHandler<Integer, A> handler);
	//	write(ByteBuffer src, A attachment, CompletionHandler<Integer, A> handler);
	
	// 첫 번째 매개값은 읽고 쓰기 위한 ByteBuffer 객체이다. 두 번째 매개값은 콜백 메소드의 매개값으로 제공할 첨부 객체이다. 세 번째 매개값은 CompletionHandler<Integer, A> 구현 객체이다.
	// Integer는 읽고 쓴 바이트 수이고, A는 첨부 객체 타입이다. 다음은 read() 메소드를 호출하는 기본 뼈대를 보여준다.
	
	//	asynchronousSocketChannel.read(byteBuffer, attachment,
	//		new CompletionHandler<Integer, A>() {
	//		@Override
	//		public void completed(Integer result, A attachment) {
	//			// 받은 데이터를 처리하는 코드
	//			asynchronousSocketChannel.read(byteBuffer, attachment, this);
	//		}
	//		@Override
	//		public void failed(Throwable exc, A attachment) {
	//			// 실패된 경우 실행할 코드
	//		}
	//	});	
	
	// 스레드풀의 작업 스레드가 읽기 작업을 완료하면 completed() 메소드를 호출한다. 첫 번째 매개값은 읽은 바이트 수이고, 두 번째 매개값은 첨부 객체인데 read() 메소드 호출 시 사용된 두 번째 매개값이 대입된다.
	// 만약 스레드풀의 작업 스레드에서 읽기 작업 도중 문제가 생겨 예외가 발생하면 스레드는 failed() 메소드를 호출한다. 첫 번째 매개값은 예외 객체이고, 
	// 두 번째 매개값은 첨부 객체인데 read() 메소드 호출 시 사용된 두 번째 매개값이 대입된다. 주목할 점은 read()를 반복해서 호출하는 무한 루프가 없다는 점이다.
	// 대신 completed() 메소드 끝에 read()를 재호출해서 반복적으로 데이터를 받는 작업을 수행한다. 다음은 write() 메소드를 호출하는 기본 뼈대를 보여준다.
	
	//	asynchronousSocketChannel.write(byteBuffer, attachment,
	//		new CompletionHandler<Integer, A>() {
	//		@Override
	//		public void completed(Integer result, A attachment) {
	//			// 성공한 경우 실행할 코드
	//		}
	//		@Override
	//		public void failed(Throwable exc, A attachment) {
	//			// 실패된 경우 실행할 코드
	//		}
	//	});
	
	// 스레드풀의 작업 스레드가 쓰기 작업을 완료하면 completed() 메소드를 호출한다. 첫 번째 매개값은 사용한 바이트 수이고, 두 번째 매개값은 첨부 객체인데 write() 메소드 호출 시 사용된 두 번째 매개값이 대입된다.
	// 만약 스레드풀의 작업 스레드에서 쓰기 작업 도중 문제가 생겨 예외가 발생하면 스레드는 failed() 메소드를 호출한다. 
	// 첫 번째 매개값은 예외 객체이고 두 번째 매개값은 첨부 객체인데 write() 메소드 호출 시 사용된 두 번째 매개값이 대입된다.
	
			//	Chatting Server Implementation		채팅 서버 구현
	
	// TCP 블로킹과 넌블로킹에서 살펴보았던 채팅 서버를 비동기 채널로 구현해보면서 AsynchronousServerSocketChannel과 AsynchronousSocketChannel이 어떻게 사용되는지 이해해보자.
	
			/*	Server Class Structure		서버 클래스 구조	*/
	
	// 01_ JavaFX 메인 클래스로 만들기 위해 Application을 상속받는다.
	// 02_ 비동기 채널 그룹인 AsynchronousChannelGroup 필드를 선언한다.
	// 03_ 클라이언트 연결을 수락하는 AsynchronousServerSocketChannel 필드를 선언한다.
	// 04_ 연결된 클라이언트를 저장하는 List<Client> 타입의 connections 필드를 선언한다. 그리고 스레드에 안전한 Vector로 초기화했다.
	// 06_ startServer()는 서버 시작 시 호출되는 메소드이다.
	// 07_ stopServer()는 서버 종료 시 호출되는 메소드이다.
	// 09_ Client 클래스는 연결된 클라이언트를 표현하는데, 데이터 통신 코드를 포함한다.
	// 12_ UI 생성 코드는 레이아웃을 구성하고 ServerExample을 실행시킨다.
	
	// 실행화면에서 [start] 버튼을 클릭하면 startServer() 메소드가 호출되고, [start] 버튼은 [stop] 버튼으로 변경된다.
	// [stop] 버튼을 클릭하면 stopServer() 메소드가 호출되고, [start] 버튼을 다시 변경한다.
	
			/*	startServer() Method	*/
	
	// [start] 버튼을 클릭하면 startServer() 메소드가 실행되는데, startServer() 메소드에는 AsynchronousChannelGroup 생성, AsynchronousServerSocketChannel 생성 및
	// 포트 바인딩, 연결 수락 코드가 있어야 한다. 다음은 CPU 코어의 수만큼 스레드를 관리하는 스레드풀을 생성하고 이것을 이용하는 비동기 채널 그룹을 생성한다.
	
	//	01	void startServer() {
	//	02		try {
	//	03			channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//	04				Runtime.getRuntime().availableProcessors(),
	//	05				Executors.defaultThreadFactory()
	//	06			);

	// 다음은 5001번 포트에서 클라이언트의 연결을 수락하는 AsynchronousServerSocketChannel을 생성한다.
	
	//	01			serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
	//	02			serverSocketChannel.bind(new InetSocketAddress(5001));
	//	03		} catch(Exception e) {
	//	04			if(serverSocketChannel.isOpen()) { stopServer(); }
	//	05			return;
	//	06		}
	//	07		Platform.runLater( () -> {
	//	08			displayText("[서버 시작]");
	//	09			btnStartStop.setText("stop");
	//	10		});
	
	// 04 ~ 05_ 5001번 포트가 이미 다른 프로그램에서 사용하고 있다면 java.net.BindException이 발생한다. 이 경우 AsynchronousServerSocketChannel이 여려 있는지 확인하고,
	//			stopServer() 메소드를 실행한다. 그리고 return을 실행해서 startServer() 메소드를 종료한다.
	// 07 ~ 10_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용되었다. "[서버 시작]"을 출력하도록 displayText()를 호출하고, [start] 버튼의 글자를 [stop]으로 변경한다.
	
	// 다음은 연결 수락 작업을 하기 위해 accpet() 메소드를 호출하는 코드이다.
	
	//	01	serverSocketChannel.accept(null,
	//	02		new CompletionHandler<AsynchronousSocketChannel, Void>() {
	//	03		@Override
	//	04		public void completed(AsynchronousSocketChannel socketChannel,
	//	05			Void attachment) {
	//	06			try {
	//	07				String message = "[연결 수락: " + socketChannel.getRemoteAddress() + ": " +
	//	08									Thread.currentThread() + "]";
	//	09				Platform.runLater( () -> displayText(message) );
	//	10			} catch (IOException e) {}
	//	11
	//	12			Client client = new Client(socketChannel);		// Client 객체 저장
	//	13			connections.add(client);
	//	14			Platform.runLater( () -> displayText("[연결 개수: " + connections.size() + "]") );
	//	15
	//	16			serverSocketChannel.accept(null, this);		// accept() 다시 호출
	//	17		}
	//	18		@Override
	//	19		public void failed(Throwable exc, Void attachment) {
	//	20			if(serverSocketChannel.isOpen()) { stopServer(); }
	//	21		}
	//	22	});	// accept() 메소드 끝
	//	23	}	// startServer() 메소드 끝

	// 01 ~ 02_ 연결 수락을 위해 accept() 메소드를 호출한다. 첫 번째 매개값인 첨부 객체는 null을 주고, 
	//			두 번째 매개값은 CompletionHandler<AsynchronousSocketChannel, Void> 타입의 익명 객체를 준다.
	//			AsynchronousSocketChannel은 결과 타입이고, Void는 첨부 타입인데 첨부가 없기 때문에 Void이다.
	// 04_ 연결 수락 작업이 성공되었을 때 콜백되는 completed()를 재정의한다. 첫 번째 매개 타입은 결과 타입인 AsynchronousSocketChannel이고, 두 번째 매개 타입인 Void이다.
	// 07 ~ 09_ "[연결 수락: 클라이언트 IP: 작업스레드이름]"으로 문자열을 생성하고, 출력하기 위해 displayText()를 호출한다.
	// 12 ~ 13_ Client 객체를 생성하고 connections 컬렉션에 추가한다.
	// 14_ "[연결 개수: 현재 관리되고 있는 Client 객체 수]"로 문자열을 생성하고 출력하기 위해 displayText()를 호출한다.
	// 16_ accept() 메소드를 재호출한다.
	// 19_ 연결 수락 작업이 실패되었을 때 콜백되는 failed()를 재정의한다. 첫 번째 매개 타입은 Throwable이고, 두 번째 매개 타입은 첨부 타입인 Void 이다.
	// 20_ AsynchronousServerSocketChannel이 열려 있다면 stopServer()를 호출한다.
	
			/*	stopServer() Method	*/
	
	// [stop] 버튼을 클릭하면 stopServer() 메소드가 실행되는데, stopServer() 메소드에는 모든 비동기 채널 닫기, 비동기 채널 그룹 종료 코드가 있어야 한다.
	
	//	01	void stopServer() {
	//	02		try {
	//	03			connections.clear();
	//	04			if(channelGroup != null && !channelGroup.isShutdown()) {
	//	05				channelGroup.shutdownNow();		// 비동기 채널 그룹 종료(모든 비동기 채널이 닫힘)
	//	06			}
	//	07			Platform.runLater( () -> {
	//	08				displayText("[서버 멈춤]");
	//	09				btnStartStop.setText("start");
	//	10			});
	//	11		} catch (Exception e) {}
	//	12	}
	
	// 03_ connections 컬렉션에 저장되어 있는 모든 Client를 제거한다.
	// 04 ~ 06_ 비동기 채널 그룹이 null이 아니고, 종료되지 않았다면 shutdownNow()를 호출해서 강제적으로 비동기 채널 그룹에 포함된 모든 비동기 채널을 닫아버리고 비동기 채널 그룹을 종료한다.
	// 07 ~ 10_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용되었다."[서버 멈춤]"을 출력하도록 displayText()를 호출하고 [stop] 버튼의 글자를 [start]로 변경한다.
	
			/*	Client Class	*/
	
	// 서버는 다수의 클라이언트가 연결하기 때문에 클라이언트를 관리해야 한다. 클러이언트별로 고유한 데이터를 저장할 필요도 있기 때문에 Client 클래를 작성하고, 
	// 연결 수락 시 마다 Client 인스턴스를 생성해서 관리하는 것이 좋다. Client 클래스에는 데이터 받기 및 보내기 코드가 있어야 한다. 다음은 Client 클래스의 구조를 보여준다.
	
	//	01	class Client {
	//	02		AsynchronousSocketChannel socketChannel;
	//	03
	//	04		Client(AsynchronousSocketChannel socketChannel) {
	//	05			this.socketChannel = socketChannel;
	//	06			receive();
	//	07		}
	//	08
	//	09		void receive() { // 데이터 받기 코드 }
	//	10		void send(String data) { // 데이터 전송 코드 }
	//	11	}

	// 01_ Client를 ServerExample의 내부 클래스로 선언한다.
	// 02_ 통신용 AsynchronousSocketChannel을 필드로 선언한다.
	// 04 ~ 07_ Client 생성자를 선언한다. 매개값으로 AsynchronousSocketChannel 필드를 초기화 하고 receive()를 호출한다.
	// 09_ 클라이언트의 데이터를 받기 위해 receive() 메소드를 선언한다.
	// 10_ 데이터를 클라이언트로 보내기 위해 send() 메소드를 선언한다.
	
	// 다음 코드는 클라이언트에서 보낸 데이터를 받는 receive() 메소드이다.
	
	//	01	void receive() {
	//	02		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	03		socketChannel.read(byteBuffer, byteBuffer,
	//	04			new CompletionHandler<Integer, ByteBuffer>() {
	//	05			@Override
	//	06			public void completed(Integer result, ByteBuffer attachment) {
	//	07				try {
	//	08					String message = "[요청 처리: " + socketChannel.getRemoteAddress() + ": " +
	//	09										Thread.currentThread().getName() + "]";
	//	10					Platform.runLater( () -> displayText(message) );
	//	11
	//	12					attachment.flip();		// 문자열 변환
	//	13					Charset charset = Charset.forName("UTF-8");
	//	14					String data = charset.decode(attachment).toString();
	//	15	
	//	16					for(Client client : connections) {	// 모든 클라이언트에게 보내기
	//	17						client.send(data);	
	//	18					}
	//	19
	//	20					ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	21					socketChannel.read(byteBuffer, byteBuffer, this);	// 다시 데이터 읽기
	//	22				} catch(Exception e) {}
	//	23			}
	//	24			@Override
	//	25			public void failed(Throwable exc, ByteBuffer attachment) {
	//	26				try {
	//	27					String message = "[클라이언트 통신 안됨: " + 
	//	28										socketChannel.getRemoteAddress() + ": " +
	//	29										Thread.currentThread().getName() + "]";
	//	30					Platform.runLater( () -> displayText(message) );
	//	31					connections.remove(Client.this);
	//	32					socketChannel.close();
	//	33				} catch (IOException e) {}
	//	34			}
	//	35		});
	//	36	}
	
	// 02_ 100개의 바이트를 저장할 수 있는 ByteBuffer를 생성한다.
	// 03 ~ 04_ read()를 호출한다. 첫 번째 매개값은 읽은 데이터를 저장할 ByteBuffer이고, 두 번째 매개값은 콜백 메소드의 매개값으로 전달할 첨부 객체인 ByteBuffer이다. 
	//			첫 번째 매개값과 두 번째 매개값은 동일한 ByteBuffer이다. 세 번째 매개값은 CompletionHandler<Integer, ByteBuffer> 객체이다.
	//			결과 타입은 Integer이고, 첨부 타입은 ByteBuffer이다.
	// 06_ 읽기 작업이 성공되었을 때 콜백되는 completed()를 재정의한다. 첫 번째 매개 타입은 결과 타입인 Integer이고, 두 번째 매개 타입은 첨부 타입인 ByteBuffer이다.
	// 08 ~ 10_ "[요청 처리: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 생성하고 displayText()를 호출해서 출력한다.
	// 12 ~ 14_ 첨부 객체인 ByteBuffer의 flip() 메소드를 호출해서 위치 속성값을 변경한 후 UTF-8로 디코딩한 문자열을 얻는다.
	// 16 ~ 18_ 문자열을 모든 클라이언트에게 보내기 위해 connections에 저장된 Client를 하나씩 얻어 send() 메소드를 호출한다.
	// 20 ~ 21_ 100개의 바이트를 저장할 수 있는 ByteBuffer를 생성하고 read()를 재호출한다.
	// 25_ 읽기 작업이 실패되었을 때 콜백되는 failed()를 재정의한다. 첫 번째 매개 타입은 Throwable이고, 두 번째 매개 타입은 첨부 타입인 ByteBuffer이다.
	// 27 ~ 30_ "[클라이언트 통신 안됨: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 생성하고 displayText()를 호출해서 출력한다.
	// 31_ connections 컬렉션에게 Client 객체를 제거한다.
	// 32_ AsynchronousSocketChannel을 닫는다.
	
	// 다음 코드는 데이터를 클라이언트로 보내는 send() 메소드이다.
	
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
	//	12					String message = "[클라이언트 통신 안됨: " +
	//	13										socketChannel.getRemoteAddress() + ": " + 
	//	14										Thread.currentThread().getName() + "]";
	//	15					Platform.runLater( () -> displayText(message) );
	//	16					connections.remove(Client.this);
	//	17					socketChannel.close();
	//	18				} catch(IOException e) {}
	//	19			}
	//	20		});
	//	21	}
	
	// 02 ~ 03_ send() 매개값인 보낼 문자열로부터 UTF-8로 인코딩한 ByteBuffer를 얻는다.
	// 04 ~ 05_ write()를 호출한다. 첫 번째 매개값은 데이터가 있는 ByteBuffer이고, 두 번째 매개값은 콜백 메소드의 매개값으로 전달한 첨부 객체인데 쓰기 작업에는 첨부 객체가 필요하지 않기 때문에 null로 지정한다.
	//			세 번째 매개값은 CompletionHandler<Integer, Void> 객체이다. 결과 타입은 Integer이고, 첨부할 객체가 없으므로 첨부타입은 Void이다.
	// 07_ 쓰기 작업이 성공되었을 때 콜백되는 completed()를 재정의한다. 첫 번째 매개 타입은 결과 타입인 Integer이고 두 번째 매개 타입은 첨부 타입인 Void이다.
	// 10_ 쓰기 작업이 실패되었을 때 콜백되는 failed()를 재정의한다. 첫 번째 매개 타입은 Throwable이고, 두 번째 매개 타입은 첨부 타입인 Void이다.
	// 12 ~ 15_ "[클라이언트 통신 안됨: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 생성하고 displayText()를 호출해서 출력한다.
	// 16_ connections 컬렉션에서 Client 객체를 제거한다.
	// 17_ AsynchronousSocketChannel을 닫는다.
	
			/*	UI Code	*/
	
	// UI 생성 코드는 TCP 블로킹 채널의 채팅 서버와 동일하다.
	
			//	Chatting Client Implementation		채팅 클라이언트 구현
	
	// 다음은 클라이언트 클래스의 구조를 보여준다.
	
	// 01_ JavaFX 메인 클래스로 만들기 위해 Application을 상속한다.
	// 02_ 비동기 채널 그룹인 AsynchronousChannelGroup 필드를 선언한다.
	// 03_ 연결 요청을 하는 AsynchronousSocketChannel 필드를 선언한다.
	// 05_ startClient() 메소드는 [start] 버튼을 클릭하면 호출된다.
	// 06_ stopClient() 메소드는 [stop] 버튼을 클릭하면 호출된다.
	// 07_ receive() 메소드는 서버에서 보낸 데이터를 보낸다.
	// 08_ send() 메소드는 [send] 버튼을 클릭하면 호출되는데. 데이터를 서버로 보낸다.
	// 11_ UI 생성 코드는 레이아웃을 구성하고 ClientExample을 실행시킨다.
	
	// 실행화면에서 [start] 버튼을 클릭하면 startClient() 메소드가 호출되고, [start] 버튼은 [stop] 버튼으로 변경된다.
	//  [stop] 버튼을 클릭하면 stopClient() 메소드가 호출되고, [start] 버튼으로 다시 변경된다.
	
			/*	startClient() Method	*/
	
	// [start] 버튼을 클릭하면 startClient() 메소드가 실행되는데, startClient() 메소드에는 AsynchronousChannelGroup 생성,
	// AsynchronousSocketChannel 생성 및 연결 요청 코드가 있어야 한다. 다음은 CPU 코어의 수만큼 스레드를 관리하는 스레드풀을 생성하고 이것을 이용하는 비동기 채널 그룹을 생성한다.
	
	//	01	void startClient() {
	//	02		try {
	//	03			ChannelGroup = AsynchronousChannelGroup.withFixedThreadPool(
	//	04				Runtime.getRuntime().availableProcessors(),
	//	05				Executors.defaultThreadFactory()
	//	06			);
	
	// 다음은 AsynchronousSocketChannel을 생성하고 로컬 5001으로 연결 요청을 하는 코드이다.
	
	//	01			socketChannel = AsynchronousSocketChannel.open(channelGroup);
	//	02			socketChannel.connect(new InetSocketAddress("localhost", 5001), null,
	//	03				new CompletionHandler<Void, Void>() {
	//	04				@Override
	//	05				public void completed(Void result, Void attachment) {
	//	06					Platform.runLater( () -> {
	//	07						try {
	//	08							displayText("[연결 완료: " + socketChannel.getRemoteAddress() + "]");
	//	09							btnConn.setText("stop");
	//	10							btnSend.setDisable(false);
	//	11						} catch (Exception e) {}
	//	12					});
	//	13					receive();	// 서버에 보낸 데이터 받기
	//	14				}
	//	15				@Override
	//	16				public void failed(Throwable exc, Void attachment) {
	//	17					Platform.runLater( () -> displayText("[서버 통신 안됨]") );
	//	18					if(socketChannel.isOpen()) { stopClient(); }
	//	19				}
	//	20			});
	//	21		} catch (IOException e) {}
	//	22	} // startClient() 끝

	// 01_ AsynchronousSocketChannel을 생성한다.
	// 02_ 로컬 5001번 포트로 연결 요청을 하기 위해 connect()를 호출한다. 첫 번째 매개값은 서버 IP와 연결 포트 정보를 가진 InetSocketAddress 객체이다.
	// 05_ 연결 요청 작업이 성공되었을 때 콜백되는 completed()를 재정의한다. 첫 번째 매개 타입과 두 번째 매개 타입은 모두 각각 Void로 지정한다.
	// 06_ UI를 변경하기 위해 Platform.runLater()가 사용되었다.
	// 08_ "[연결 완료: 서버IP]"로 구성된 문자열을 생성하고 displayText()로 출력한다
	// 09 ~ 10_ [start] 버튼의 글자를 [stop]으로 변경한다. 그리고 [send] 버튼을 활성화한다.
	// 13_ 서버의 데이터를 받기 위해 receive() 메소드를 호출한다.
	// 16_ 연결 요청 작업이 실패되었을 때 콜백되는 failed()를 재정의한다. 첫 번째 매개 타입은 Throwable이고, 두 번째 매개 타입은 Void이다.
	// 17_ "[서버 통신 안됨]"을 출력하도록 displayText()를 호출한다.
	// 18_ AsynchronousSocketChannel이 열려있으면 stopClient() 메소드를 호출한다.
	
			/*	stopClient() Method	*/
	
	//	01	void stopClient() {
	//	02		try {
	//	03			Platform.runLater( () -> {
	//	04				displayText("[연결 끊음]");
	//	05				btnConn.setText("start");
	//	06				btnSend.setDisable(true);
	//	07			});
	//	08			if(channelGroup != null && !channelGroup.isShutdown()) {
	//	09				channelGroup.shutdownNow();
	//	10			}
	//	11		} catch (IOException e) {}
	//	12	}
	
	// 03_ UI를 변경하기 위해 Platform.runLater()가 사용되었다.
	// 04_ "[연결 끊음]"을 출력하도록 displayText()를 호출한다.
	// 05_ [stop] 버튼의 글자를 [start]로 변경한다.
	// 06_ [send] 버튼을 비활성화한다.
	// 08 ~ 10_ 비동기 채널 그룹이 null이 아니고, 종료되지 않았다면 shutdownNow()를 호출해서 강제적으로 비동기 채널 그룹에 포함된 모든 비동기 채널을 닫아버리고 비동기 채널 그룹을 종료한다.
	
			/*	receive() Method	*/
	
	// receive() 메소드는 서버에서 보낸 데이터를 받는 역할을 한다. 이 메소드는 startClient()에서 connect()가 성공했을 때 콜백되는 completed() 내에서 호출한다.
	
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
	//	11					Platform.runLater( () -> displayText("[받기 완료] " + data) );
	//	12					
	//	13					ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	14					socketChannel.read(byteBuffer, byteBuffer, this);	// 다시 데이터 읽기
	//	15				} catch(Exception e) {}
	//	16			}
	//	17			@Override
	//	18			public void failed(Throwable exc, ByteBuffer attachment) {
	//	19				Platform.runLater( () -> displayText("[서버 통신 안됨]") );
	//	20				stopClient();
	//	21			}
	//	22		});
	//	23	}
	
	// 02_ 받은 데이터를 저장할 길이가 100인 ByteBuffer를 생성한다.
	// 03 ~ 04_ read()를 호출한다. 첫 번째 매개값은 읽은 데이터를 저장할 ByteBuffer이고, 두 번째 매개값은콜백 메소드의 매개값으로 전달할 첨부 객체인 ByteBuffer이다.
	//			첫 번째 매개값과 두 번째 매개값은 동일한 ByteBuffer이다. 세 번째 매개값은 CompletionHandler<Integer, ByteBuffer> 객체이다.
	//			결과 타입은 Integer이고, 첨부 타입은 ByteBuffer이다.
	// 06_ 읽기 작업이 성공되었을 때 콜백되는 completed()를 재정의한다. 첫 번째 매개 타입은 결과 타입인 Integer이고, 두 번째 매개 타입은 첨부 타입인 ByteBuffer이다.
	// 08 ~ 11_ 첨부 객체인 ByteBuffer의 flip() 메소드를 호출해서 위치 속성값을 변경한 후 UTF-8로 디코딩한 문자열을 얻는다. 그리고 문자열을 출력하기 위해 displayText()를 호출한다.
	// 13 ~ 14_ 100개의 바이트를 저장할 수 있는 ByteBuffer를 생성하고 read()를 재호출한다.
	// 18_ 읽기 작업이 실패되었을 때 콜백되는 failed()를 재정의한다. 첫 번째 매개 타입은 Throwable이고, 두 번째 매개 타입은 첨부 타입인 ByteBuffer이다.
	// 19_ "[서버 통신 안됨]" 문자열을 출력하기 위해 displayText()를 호출한다.
	// 20_ stopClient()를 호출한다.
	
			/*	send(String data) Method	*/
	
	// send(String data) 메소드는 사용자가 메세지를 입력하고 [send] 버튼을 클릭하면 메세지를 매개값으로 해서 호출된다.
	// send() 메소드는 메세지를 서버로 보내는 역할을 한다.
	
	//	01	void send(String data) {
	//	02		Charset charset = Charset.forName("UTF-8");
	//	03		ByteBuffer byteBuffer = charset.encode(data);
	//	04		socketChannel.write(byteBuffer, null, new CompletionHandler<Integer, Void>() {
	//	05			@Override
	//	06			public void completed(Integer result, Void attachment) {
	//	07				Platform.runLater( () -> displayText("[보내기 완료]") );
	//	08			}
	//	09			@Override
	//	10			public void failed(Throwable exc, Void attachment) {
	//	11				Platform.runLater( () -> displayText("[서버 통신 안됨]") );
	//	12				stopClient();
	//	13			}
	//	14		});
	//	15	}
	
	// 02 ~ 03_ send()의 매개값인 문자열로부터 UTF-8로 인코딩한 ByteBuffer를 얻는다.
	// 04_ write()를 호출한다. 첫 번째 매개값은 데이터가 있는 ByteBuffer이고, 두 번째 매개값은 콜백 메소드의 매개값으로 전달한 첨부 객체인데 없으므로 null이다.
	//		세 번째 매개값은 CompletionHandler<Integer, Void> 객체이다. 결과 타입은 Integer이고, 첨부할 객체가 없으므로 객체 타입은 Void이다.
	// 06_ 쓰기 작업이 성공되었을 때 콜백되는 completed()를 재정의한다. 첫 번째 매개 타입은 결과 타입인 Integer이고, 두 번째 매개 타입은 첨부 타입인 Void이다.
	// 07_ "[보내기 완료]"를 출력하기 위해 displayText()를 호출한다.
	// 10_ 쓰기 작업이 실패되었을 때 콜백되는 failed()를 재정의한다. 첫 번째 매개 타입은 Throwable이고, 두 번째 매개 타입은 첨부 타입인 Void이다.
	// 11_ "[서버 통신 안됨]"을 출력하기 위해 displayText()를 호출한다.
	// 12_ stopClient()를 호출한다.
	
			/*	UI Code	*/
	
	// UI 생성 코드는 TCP 블로킹 채널의 채팅 클라이언트와 동일하므로 생략한다. 채팅 서버와 클라이언트 실행 방법은 TCP 블로킹 채널의 채팅 서버와 클라이언트 실행 방법과 동일하다.
}
