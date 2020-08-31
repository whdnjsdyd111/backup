package 챕터18_IO;

public class ㅅ_TCP_Networking {
	// TCP ( Transmission Control Protocol )는 연결 지향적 프로토콜이다. 연결 지향 프로토콜이란 클라이언트와 서버가 연결된 상태에서 데이터를 주고받는 프로토콜을 말한다.
	// 클라이언트가 연결 요청을 하고, 서버가 연결을 수락하면 통신 선로가 고정되고, 모든 데이터는 고정된 통신 선로를 통해서 순차적으로 전달된다.
	// 그렇기 때문에 TCP는 데이터를 정확하고 안정적으로 전달한다. TCP의 단점은 데이터를 보내기 전에 반드시 연결이 형성되어야 하고(가장 시간이 많이 걸리는 작업), 고정된 통신 선로가 최단선(네트워크 길이 측면)이 아닐 경우
	// 상대적으로 UDP(User Datagram Protocol)보다 데이터 전송 속도가 느릴 수 있다. 
	// 자바는 TCP 네트워킹을 위해 java.net.ServerSocket과 java.net.Socket 클레스를 제공하고 있다. 이 두 클래스의 사용 방법을 알아보기로 하자.
	
			//	Purpose Of ServerSocket And Socket
	
	// TCP 서버의 역할은 두 가지로 볼 수 있다. 하나는 클라이언트가 연결 요쳥을 해오면 연결을 수락하는 것이고, 다른 하나는 연결된 클라이언트와 통신하는 것이다.
	// 자바에서는 이 두 역할별로 별도의 클래스를 제공하고 있다. 클라이언트의 연결 요쳥을 기다리면서 연결 수락을 담당하는 것이 java.net.ServerSocket 클래스이고,
	// 연결된 클라이언트와 통신을 담당하는 것이 java.net.Socket 클래스이다. 클라이언트가 연결 요청을 해오면 ServerSocket은 연결을 수락하고 통신용 Socket을 만든다.
	
	//											┌───────────────────────────┐
	//			┌───────────────────┐			│	서버						│
	//			│	클라이언트			│			│		┌────────────────┐	│
	//			│					│ 1 연결 요청	│	────┴──	ServerSocket │	│
	//			│		Socket	────────────────────5001──────→	accept() │	│
	//			│		      ↖	────────────────┐	│	────┬──			│	 │	│
	//			│					│  3 통신	│	│		└───────────┼────┘	│
	//			└───────────────────┘		└──────────	Socket ←────┘ 2 연결 수락
	//											└───────────────────────────┘					
	
	// 서버는 클라이언트가 접속할 포트를 가지고 있어야 하는데, 이 포트를 바인딩(binding) 포트라고 한다. 서버는 고정된 포트 번호에 바인딩해서 실행하므로, ServerSocket을 생성할 때 포트 번호 하나를 지정해야 한다.
	// 위에서 5001번이 서버 바인딩 포트이다. 서버가 실행되면 클라이언트는 서버의 IP 주소와 바인딩 포트 번호를 Socket을 생성해서 연결 요청을 할 수 있다.
	// ServerSocket은 클라이언트가 연결 요청을 해오면 accept() 메소드로 연결 수락을 하고 통신용 Socket을 생성한다. 그리고 나서 클라이언트와 서버는 각각의 Socket을 이용해서 데이터를 주고받게 된다.
	
			//	ServerSocket Creation And Accept Connection		ServerSocket 생성과 연결 수락
	
	// 서버를 개발하려면 우선 ServerSocket 객체를 얻어야 한다. ServerSocket을 얻는 가장 간단한 방법은 생성자에 바인딩 포트를 대입하고 객체를 생성하는 것이다.
	// 다음은 5001번 포트에 바인딩하는 ServerSocket을 생성한다.
	
	//	ServerSocket serverSocket = new ServerSocket(5001);
	
	// ServerSocket을 얻는 다른 방법은 디폴트 생성자로 객체를 생성하고 포트 바인딩을 위해 bind() 메소드를 호출하는 것이다.
	// bind() 메소드의 매개값은 포트 정보를 가진 InetSocketAddress이다.
	
	//	ServerSocket serverSocket = new ServerSocket();
	//	serverSocket.bind(new InetSocketAddress(5001));
	
	// 만약 서버가 PC에 멀티 IP가 할당되어 있을 경우, 특정 IP로 접속할 때만 연결 수락을 하고 싶다면 다음과 같이 작성하되, "localhost" 대신 정확한 IP를 주면 된다.
	
	//	ServerSocket serverSocket = new ServerSocket();
	//	serverSocket.bind( new InetSocketAddress("localhost", 5001) );

	// ServerSocket을 생성할 때 해당 포트가 이미 다른 프로그램에서 사용 중이라면 BindException이 발생한다. 이 경우에는 다른 포트로 바인딩하거나, 다른 프로그램을 종료하고 다시 실행하면 된다.
	// 포트 바인딩까지 끝났다면 ServerSocket은 클라이언트 연결 수락을 위해 accept() 메소드를 실행해야 한다. accept() 메소드는 클라이언트가 연결 요청하기 전까지 블로킹되는데,
	// 블로킹이란 스레드가 대기 상태가 된다는 뜻이다. 그렇기 때문에 UI를 생성하는 스레드나, 이벤트를 처리하는 스레드에서 accept() 메소드를 호출하지 않도록 한다.
	// 블로킹이 되면 UI 갱신이나 이벤트 처리를 할 수 없기 때문이다. 클라이언트가 연결 요청을 하면 accept()는 클라이언트와 통신할 Socket을 만들고 기턴한다. 이것이 연결 수락이다.
	// 만약 accept()에서 블로킹되어 있을 때 ServerSocket을 닫기 위해 close() 메소드를 호출하면 SocketException이 발생한다. 그렇기 때문에 예외 처리가 필요하다.
	
	//	try {
	//		Socket socket = serverSocket.accept();
	//	} catch(Exception e) { }
	
	// 연결된 클라이언트의 IP와 포트 정보를 알고 싶다면 Socket의 getRemoteSocketAddress() 메소드를 호출해서 SocketAddress를 얻으면 된다.
	// 실제 리턴되는 것은 InetSocketAddress 객체이므로 다음과 같이 타입 변환할 수 있다
	
	//	InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
	
	// InetSocketAddress에는 IP와 포트 정보를 리턴하는 다음과 같은 메소드들이 있다.
	
	//	리턴 타입		메소드명(매개 변수)		설명
	//
	//	String		getHostName()		클라이언트 IP 리턴
	//
	//	int			getPort()			클라이언트 포트 번호 리턴
	//
	//	String		toString			"IP:포트번호" 형태의 문자열 리턴
	
	// 더 이상 클라이언트 연결 수락이 필요 없으면 ServerSocket의 close() 메소드를 호출해서 포트를 언바인딩시켜야 한다. 그래야 다른 프로그램에서 해당 포트를 재사용할 수 있다.
	
	//	serverSocket.close();
	
	// 다음 예제는 반복적으로 accept() 메소드를 호출해서 다중 클라이언트 연결을 수락하는 가장 기본적인 코드를 보여준다.
	
			//	Socket Creation And Connection Request		Socket 생성과 연결 요청
	
	// 클라이언트가 서버에 연결 요청을 하려면 java.net.Socket을 이용해야 한다. Socket 객체를 생성함과 동시에 연결 요청을 하려면 생성자의 매개값으로 서버의 IP 주소와 바인딩 포트 번호를 제공하면 된다.
	// 다음은 로컬 PC의 5001 포트에 연결 요청하는 코드이다.
	
	//	try {
	//		Socket socket = new Socket("localhost", 5001);	// 방법 1
	//		Socket socket = new Socket( new InetSocketAddress("localhost", 5001) );	// 방법 2
	//	} catch (UnknownHostException e) {
	//		// IP 표기 방법이 잘못되었을 경우
	//	} catch (IOException e) {
	//		// 해당 포트의 서버에 연결할 수 없는 경우
	//	}
	
	// 외부 서버에 접속하려면 localhost 대신 정확한 IP를 입력하면 된다. 만약 IP 대신 도메인 이름만 알고 있다면, 도메인 이름을 IP 주소로 번역해야 하므로 InetSocketAddress 객체를 이용하는 방법을 사용해야 한다.
	// Socket 생성과 동시에 연결 요청을 하지 않고, 다음과 같이 기본 생성자로 Socket을 생성한 후, connect() 메소드로 연결 요청을 할 수도 있다.
	
	//	socket = new Socket();
	//	socket.connect( new InetSocketAddress("localhost", 5001) );
	
	// 연결 요청을 할 때는 두 가지 예외가 발생할 수 있다. UnknownHostException은 잘못 표기된 IP 주소를 입력했을 경우에 발생하고, IOException은 주어진 포트로 접속할 수 없을 때 발생한다.
	// 따라서 두 가지 예외를 처리해야 한다. Socket 생성자 및 connect() 메소드는 서버와 연결이 될 때까지 블로킹된다. 그렇기 때문에 UI를 생성하는 스레드나, 이벤트를 처리하는 스레드에서 
	// Socket 생성자 및 connect()를 호출하지 않도록 한다. 블로킹이 되면 UI 갱신이나 이벤트 처리를 할 수 없기 때문이다.
	// 연결된 후, 클라이언트 프로그램을 종료하거나, 강제적으로 연결을 끊고 싶다면 Socket의 close() 메소드를 다음과 같이 호출하면 된다.
	// close() 메소드도 IOException이 발생할 수 있기 때문에 예외 처리가 필요하다.
	
	//	try {
	//		socket.close();
	//	} catch (IOException e) {}
	
	// 다음 예제는 localhost 5001 포트로 연결을 요청하는 코드이다. connect() 메소드가 정상적으로 리턴하면 연결이 성공한 것이다.
	
	// 이전에 예제에서 작성한 ServerExample과 ClientExample을 실행할 때 먼저 ServerExample부터 실행하고 ClientExample을 실행해보자.
	
			/*	Socket Data Communications		Socket 데이터 통신	*/
	
	// 클라이언트가 연결 요청(connect())하고 서버가 연결 수락(accept()) 했다면, 양쪽의 Socket 객체로부터 각각 입력 스트림(InputStream)과 출력 스트림(OutputStream)을 얻을 수 있다.
	
	//		┌───────────┐											┌───────────┐
	//		│	프로그램	│	InputStream				OutputStream	│	프로그램	│
	//		│			│───────────────────────────────────────────│			│
	//		│			│←------------------------------------------│			│
	//		│			│───────────────────────────────────────────│			│
	//		│	Socket	│	OutputStream			InputStream		│	Socket	│
	//		│			│───────────────────────────────────────────│			│
	//		│			│------------------------------------------→│			│
	//		│			│───────────────────────────────────────────│			│
	//		└───────────┘											└───────────┘
	
	// 다음은 Socket으로부터 InputStream과 OutputStream을 얻는 코드이다.
	
	//	// 입력 스트림 얻기
	//	InputStream is = socket.getInputStream();
	//
	//	// 출력 스트림 얻기
	//	OutputStream os = socket.getOutputStream();
	
	// 상대방에게 데이터를 보내기 위해서는 보낼 데이터를 byte[] 배열로 생성하고, 이것을 매개값으로 해서 OutputStream의 write() 메소드를 호출하면 된다.
	// 다음은 문자열을 UTF-8로 인코딩한 바이트 배열을 얻어내고, write() 메소드로 전송한다.
	
	//	String data = "보낼 데이터";
	//	byte[] byteArr = data.getBytes("UTF-8");
	//	OutputStream outputStream = socket.getOutputStream();
	//	outputStream.write(byteArr);
	//	outputStream.flush();
	
	// 상대방이 보낸 데이터를 받기 위해서는 받은 데이터를 저장할 bye[] 배열을 하나 생성하고, 이것을 매개값으로해서 InputStream의 read() 메소드를 호출하면 된다.
	// read() 메소드는 읽은 데이터를 byte[] 배열에 저장하고 읽은 바이트 수를 리턴한다. 다음은 데이터를 읽고 UTF-8로 디코딩한 문자열을 얻는 코드이다.
	
	//	byte[] byteArr = new byte[100];
	//	InputStream inputStream = socket.getInputStream();
	//	int readByteCount = inputStream.read(byteArr);
	//	String data = new String(byteArr, 0, readByteCount, "UTF-8");
	
	// 다음 예제는 성공 후, 1 클라이언트가 먼저 "Hello Server"를 서버로 보낸다. 2 서버가 이 데이터를 받고 3 "Hello Client"를 클라이언트로 보내면 4 클라이언트가 이 데이터를 받는다.
	
	// 이전에 예제에서 작성한 ServerExample과 ClientExample을 실행할 때 먼저 ServerExample부터 실행하고 ClientExample을 실행해보자.
	
	// 데이터를 받기 위해 InputStream의 read() 메소드를 호출하면 상대방이 데이터를 보내기 전까지는 블로킹(blocking)되는데, read() 메소드가 블로킹 해제되고 리턴되는 경우는 다음 세 가지이다.
	
	//	블로킹이 해제되는 경우						리턴값
	//
	//	상대방이 데이터를 보냄						읽은 바이트 수
	//	
	//	상대방이 정상적으로 Socket의 close()를 호출	-1
	//		
	//	상대방이 비정상적으로 종료					IOException 발생
	
	// 상대방이 정상적으로 Socket의 close()를 호출하고 연결을 끊었을 경우와 비정상적으로 종료했을 경우, 모두 예외 처리를 해서 이쪽도 Socket을 닫기 위해 close() 메소드를 호출해야 한다.
	
	//	try {
	//		...
	//		// 상대방이 비정상적으로 종료했을 경우 IOException 발생
	//		int readByteCount = inputStream.read(byteArr);	────────────────┐
	//																		│
	//		// 상대방이 정상적으로 Socket의 close()를 호출했을 경우						│
	//		if(readByteCount == -1) {										│
	//			throw new IOException();	// 강제로 IOException 발생 시킴	────┤
	//		}																│
	//		...																│
	//	} catch (Exception e) {												│
	//		try { socket.close(); } catch(Exception e2) {}	←───────────────┘
	//	}
	
			/*	Handling Thread Parallelism		스레드 병렬 처리		*/
	
	// 연결 수락을 위해 ServerSocket의 accept()를 실행하거나, 서버 연결 요청을 위해 Socket 생성자 또는 connect()를 실행할 경우에는 해당 작업이 완료되기 전까지 블로킹(blocking)된다.
	// 데이터 통신을 할 때에도 마찬가지인데 InputStream의 read() 메소드는 상대방이 데이터를 보내기 전까지 블로킹되고, 
	// OutputStream의 write() 메소드는 데이터를 완전하게 보내기 전까지 블로킹된다. 결론적으로 말해서 ServerSocket과 Socket은 동기(블로킹) 방식으로 구동된다.
	// 만약 서버를 실행시키는 main 스레드가 직접 입출력 작업을 담당하게 되면 입출력이 완료될 때까지 다른 작업을 할 수 없는 상태가 된다.
	// 서버 애플리케이션은 지속적으로 클라이언트의 연결 수락 기능을 수행해야 하는데, 입출력에서 블로킹되면 이 작업을 할 수 없게 된다.
	// 또한 클라이언트 1과 입출력하는 동안에는 클라이언트2와 입출력을 할 수 없게 된다. 그렇기 때문에 accept(), connect(), read(), write()는 별도의 작업 스레드를 생성해서 병렬적으로 처리하는 것이 좋다.
	// 다음은 서버가 별도의 작업 스레드를 생성하고, 다중 클라이언트와 병렬적으로 통신하는 모습을 보여준다.
	
	//											┌───────────────────────────────────┐
	//											│	accept()					서버	│
	//											│	  |		2	┌──────────────────┐│
	//		┌───────────────┐	1 연결 요청			│	  |	스레드 생성	│	작업 스레드 1	   ││			
	//		│	클라이언트1		│──────────────────────────────────→│┌────────────────┐││
	//		│	(Socket)	│	3 처리 요청			│	  |			││		Socket	  │││
	//		└───────────────┘←─────────────────────────────────→││		4 작업 처리	  │││
	//							5 응답			│	  |			│└────────────────┘││
	//											│	  |		2	└──────────────────┘│
	//		┌───────────────┐	1 연결 요청			│	  |	스레드 생성	┌──────────────────┐│
	//		│	클라이언트2		│──────────────────────────────────→│	작업 스레드 1	   ││
	//		│	(Socket)	│	3 처리 요청			│	  |			│┌────────────────┐││
	//		└───────────────┘←─────────────────────────────────→││		Socket	  │││
	//							5 응답			│	  |			││		4 작업 처리	  │││
	//											│	  |			│└────────────────┘││
	//											│	  ↓			└──────────────────┘│
	//											└───────────────────────────────────┘
	
	// 위와 같이 스레드로 병렬 처리를 할 경우, 수천 개의 클라이언트가 동시에 연결되면 서버에서 수천 개의 스레드가 생성되기 때문에 서버 성능이 급격히 저하되고, 다운되는 현상이 발생할 수 있다.
	// 클라이언트의 폭증으로 인해 서버의 과도한 스레드 생성을 방지하려면 스레드풀을 사용하는 것이 바람직하다. 다음은 스레드풀을 이용한 서버 구현 방식을 보여준다.
	
	//
	//
	//									┌───────────────────────────────────────────────────────────────────────────┐
	//									│																		서버	│
	//									│					┌───────────────────────────────────────────────────┐	│
	//						1 연결 요청		│	수락 작업 생성		│	스레드풀(ExecutorService)							│	│
	//		┌───────────────────┐───────────→	■	────┐	│	  작업 큐					 ┌──────────┐			│	│
	//		│	클라이언트 1...n	│3 처리 요청│	요청 작업 생성	│	│	┌───────┐───────────────→│	스레드 1	│			│	│
	//		│		Socket		│───────────→	■	────┼──────→│ ■ ■ ■	│				 │수락 작업 처리	│			│	│
	//		└───────────────────┘───┐	│	요청 작업 생성	│	│	└───────┘───────────┐	 │	  ■	   2 Socket 생성	│	│
	//				↑		3 처리 요청	└───────→	■	────┘	│	각 스레드는 큐에서			│	 └──────────┘			│	│
	//				│					│					│	작업을 가져와 실행시킴		│	 ┌──────────┐			│	│
	//				│					│					│						└───→│	스레드 2	│			│	│
	//				│					│					│							 │요청 작업 처리	│			│	│
	//				│					│					│							 │	  ■	   4 요청 처리		│	│
	//				│5 응답				│					│							 └──────────┘			│	│
	//				└─────────────────────────────────────────────────────────────────────────┘		스레드 수 제한	│	│
	//									│					└───────────────────────────────────────────────────┘	│
	//									└───────────────────────────────────────────────────────────────────────────┘
	
	// 1 클라이언트가 연결 요청을 하면 2 서버의 스레드풀에서 연결 수락을 하고 Socket을 생성한다. 3 클라이언트가 작업 처리 요청을 하면 4 서버의 스레드풀에서 요청을 처리하고 5 응답을 클라이언트로 보낸다.
	
	// 스레드풀은 스레드 수를 제한해서 사용하기 때문에 갑작스런 클라이언트의 폭증은 작업 큐의 작업량만 증가시킬 뿐 스레드 수는 변함없기 때문에 서버 성능은 완만히 저하된다.
	// 다만 대기하는 작업량이 많을 경우 개별 클라이언트에서 응답을 늦게 받을 수 있다.
	
			//	Chatting Server Implementation		채팅 서버 구현
	
	// 채팅 서버 구현 코드를 보면서 스레드풀(ExecutorService), ServerSocket, Socket들이 어떻게 사용되는지 이해해보자.
	
			/*	Server Class Structure		서버 클래스 구조	*/
	
	// 다음 예제는 서버 클래스의 구조를 보여준다.
	
	// 24_ JavaFX 메인 클래스로 만들기 위해 Application을 상속받고 있다.
	// 25_ 스레드풀인 ExecutorService 필드가 선언되어 있다.
	// 26_ 클라이언트의 연결을 수락하는 ServerSocket 필드가 선언되어 있다.
	// 27_ 연결된 클라이언트를 저장하는 List<Client> 타입의 connections 필드가 선언되어 있다. 그리고 스레드에 안전한 Vector로 초기화 했다.
	// 29_ startServer()는 서버 시작 시 호출되는 메소드이다.
	// 72_ stopServer()는 서버 종료 시 호출되는 메소드이다.
	// 96_ Client 클래스는 연결된 클라이언트를 표현하는데, 데이터 통신 코드를 포함한다.
	// 173_ UI 생성 코드는 레이아웃을 구성하고 ServerExample을 실행시킨다.
	
	// 실행 화면에서 [start] 버튼을 클리갛면 startServer() 메소드가 호출되고, [start] 버튼은 [stop] 버튼으로 변경된다.
	// [stop] 버튼을 클릭하면 stopServer() 메소드가 호출되고, 다시 [start] 버튼으로 변경된다.
	
			/*	startServer() Method	*/
	
	// [start] 버튼을 클릭하면 startServer() 메소드가 실행하는데, startServer() 메소드에는 ExecutorService 생성, ServerSocket 생성 및 포트 바인딩, 연결 수락 코드가 있다.
	// 먼저 ExecutorService 생성 코드를 보자.
	
	//	01	void startServer() {
	//	02		executorService = Executors.newFixedThreadPool(
	//	03			Runtime.getRuntime().availableProcessors()
	//	04		);
	
	// 02_ ExecutorService 객체를 얻기 위해 Executors.newFixedThreadPool() 메소드를 호출한다.
	// 03_ CPU 코어의 수만큼 스레드를 만들도록 한다.
	
	// 이번에는 ServerSocket 생성 및 포트 바인딩 코드를 보자.
	
	//	01	try {
	//	02		serverSocket = new ServerSocket();
	//	03		serverSocket.bind(new InetSocketAddress("localhost", 5001));
	//	04	} catch(Exception e) {
	//	05		if(!serverSocket.isClosed()) { stopServer(); }
	//	06		return;
	//	07	}
	
	// 02_ ServerSocket 객체를 생성한다.
	// 03_ ServerSocket을 로컬 컴퓨터 5001 포트와 바인딩한다.
	// 05_ 예외가 발생할 경우 ServerSocket이 닫혀있지 않으면 stopServer() 메소드를 호출한다.
	// 06_ startServer() 메소드를 종료한다.
	
	// 이번에는 연결을 수락하는 코드를 보자.
	
	//	01	Runnable runnable = new Runnable() {		// 수락 작업 생성
	//	02		@Override
	//	03		public void run() {
	//	04			Platform.runLater( () -> {
	//	05				displayText("[서버 시작]");
	//	06				btnStartStop.setText("stop");
	//	07			});
	//	08			while(true) {
	//	09				try {
	//	10					Socket socket = serverSocket.accept();		// 연결 수락
	//	11					String message = "[연결 수락: " + socket.getRemoteSocketAddress() + 
	//	12									": " + Thread.currentThread().getName() + "]";
	//	13					Platform.runLater( () -> displayText(message) );
	//	14
	//	15					Client client = new Client(socket);	
	//	16					connections.add(client);			// Client 객체 저장
	//	17					Platform.runLater( () -> displayText("연결 개수: " + connections.size() + "]"));
	//	18				} catch(Exception e) {
	//	19					if(!serverSocket.isClosed()) { stopServer(); }
	//	20					break;
	//	21				}
	//	22			}
	//	23		}
	//	24	};
	//	25	executorService.submit(runnable);		// 스레드풀에서 처리
	//	26	}	// startServer() 메소드 끝
	
	// 01_ 연결 수락 작업을 Runnable로 정의한다.
	// 03_ run() 메소드를 재정의한다.
	// 04_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용되었다.
	// 05_ "[서버 시작]"을 출력하도록 displayText()를 호출했다.
	// 06_ [start] 버튼의 글자를 [stop]으로 변경한다.
	// 08_ 클라이언트의 연결 수락을 무한히 반복하도록 한다.
	// 10_ 클라이언트의 연결 요청을 기다리고, 연결 수락을 하는 accept() 메소드를 호출한다.
	// 11_ 연결 수락이 되면 클라이언트 IP 주소와 스레드 이름이 포함된 연결 수락 메세지 문자열을 만든다.
	// 13_ 메세지를 출력하도록 displayText()를 호출한다
	// 15_ Client 객체를 생성한다.
	// 16_ Client 객체를 connections 컬렉션에 추가한다.
	// 17_ connections 컬렉션에 저장된 Client 객체 수를 출력하도록 displayText()를 호출한다.
	// 19_ 예외가 발생했을 경우, ServerSocket이 닫혀있지 않으면 stopServer()를 호출한다.
	// 20_ break를 사용해서 while문을 멈춘다.
	// 25_ 스레드풀의 작업 스레드에서 연결 수락 작업을 처리하기 위해 submit()을 호출한다.
	
			/*	stopServer() Method		*/
	
	// [stop] 버튼을 클릭하면 stopServer() 메소드가 실행되는데, stopServer() 메소드에는 연결된 모든 Socket 닫기, ServerSocket 닫기, ExecutorService 종료 코드가 있다.
	
	//	01	void stopServer() { 
	// 	02		try {	// 모든 Socket 닫기
	// 	03			Iterator<Client> iterator = connections.iterator();
	//	04			while(iterator.hasNext()) {
	//	05				Client client = iterator.next();
	//	06				client.socket.close();
	//	07				iterator.remove();
	//	08			}	//
	//	09			if(serverSocket != null && !serverSocket.isClosed()) {	// ServerSocket 닫기
	//	10				serverSocket.close();
	//	11			}	//
	//	12			if(executorService != null && !executorService.isShutdown()) {	// ExecutorService 종료
	//	13				executorService.shutdown();
	//	14			}	//
	//	15			Platform.runLater( () -> {
	//	16				displayText("[서버 멈춤]");
	//	17				btnStartStop.setText("start");
	//	18			});
	//	19		} catch(Exception e) { }
	//	20	}
	
	// 03_ connections 컬렉션으로부터 반복자를 얻어낸다.
	// 04_ while문으로 반복자를 반복한다.
	// 05_ 반복자로부터 Client를 하나씩 얻는다.
	// 06_ Client가 가지고 있는 Socket을 닫는다.
	// 07_ connections 컬렉션에서 Client를 제거한다.
	// 09_ ServerSocket이 null이 아니고, 닫혀있지 않으면
	// 10_ ServerSocket을 닫는다.
	// 12_ ExecutorService가 null이 아니고, 종료 상태가 아니면
	// 13_ ExecutorService를 종료한다.
	// 15_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용되었다.
	// 16_ "[서버 멈춤]"을 출력하도록 displayText()를 호출한다.
	// 17_ [stop] 버튼의 글자를 [start]로 변경한다.
		
			/*	Client Class	*/
	
	// 서버에 다수의 클라이언트가 연결하기 때문에 서버는 클라이언트를 관리햐야 한다. 클라이언트별로 고유한 데이터를 저장할 필요도 있기 때문에 Client 클래스를 작헝하고,
	// 연결 수락 시 마다 Client 인스턴스를 생성해서 관리하는 것이 좋다. 다음은 Client 클래스의 구조를 보여준다.
	
	// 	01	Class Client {
	// 	02		Socket socket;
	// 	03	
	// 	04		Client(Socket socket) {
	// 	05			this.socket = socket;
	// 	06			receive();
	// 	07		}
	// 	08		
	// 	09		void receive() { // 데이터 받기 코드 }
	// 	10		void send(String data) { // 데이터 전송 코드 }
	// 	11	}
	
	// 01_ Client를 ServerExample의 내부 클래스로 선언한다.
	// 02_ Socket 필드를 선언한다.
	// 04_ Client 생성자를 선언한다.
	// 05_ 매개값으로 받은 Socket을 필드값으로 저장한다.
	// 06_ receive() 메소드를 호출한다.
	// 09_ 데이터를 받기 위해 receive() 메소드를 선언한다.
	// 10_ 데이터를 보내기 위해 send() 메소드를 선언한다.
	
	// 클라이언트의 데이터를 받는 receive() 메소드 코드를 보자.
	
	//	01	void receive() {
	//	02		Runnable runnable = new Runnable() {	// 받기 작업 생성
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					while(true) {
	//	07						byte[] byteArr = new byte[100];
	//	08						InputStream inputStream = socket.getInputStream();
	//	09	
	//	10						// 클라이언트가 비정상 종료를 했을 경우 IOException 발생
	//	11						int readByteCount = inputStream.read(byteArr);
	//	12						
	//	13						// 클라이언트가 정상적으로 Socket의 close()를 호출했을 경우
	//	14						if(readByteCount == -1) { throw new IOException(); }
	//	15	
	//	16						String message = "[요청 처리: " + socket.getRemoteSocketAddress() + 
	//	17										": " + Thread.currentThread().getName() + "]";
	//	18						Platform.runLater( () -> displayText(message) );
	//	19	
	//	20						String data = new String(byteArr, 0, readByteCount, "UTF-8");	// 문자열로 변환
	//	21	
	//	22						for(Client client : connections) {	// 모든 클라이언트에게 보냄
	//	23							client.send(data);
	//	24						}	//
	//	25					}
	//	26				} catch(Exception e) {
	//	27					try {
	//	28						connections.remove(Client.this);
	//	29						String message = "[클라이언트 통신 안됨: " + 
	//	30										socket.getRemoteSocketAddress() +
	//	31										": " + Thread.currentThread().getName() + "]";
	//	32						Platform.runLater( () -> displayText(message) );
	//	33						socket.close();
	//	34					} catch(IOException e2) {} 
	//	35				}
	//	36			}
	//	37		};
	//	38		executorService.submit(runnable);	// 스레드풀에서 처리
	//	39	}
	
	// 02_ 클라이언트로부터 데이터를 받는 작업을 Runnable로 정의한다.
	// 04_ run() 메소드를 재정의한다.
	// 06_ 작업을 무한 반복한다.
	// 07_ 받는 데이터를 저장할 byte[] 배열인 byteArr를 생성한다.
	// 08_ Socket으로부터 InputStream을 얻는다
	// 11_ InputStream의 read() 메소드를 호출한다. 클라이언트가 데이터를 보내기 전까지 클로킹되고, 데이터를 받으면 byteArr에 저장한 후 받은 바이트 개수를 readByteCount에 저장한다.
	// 14_ 클라이언트가 정상적으로 Socket의 close()를 호출했을 경우, 11라인의 read() 메소드는 -1을 리턴한다. 이 경우 IOException을 강제로 발생시킨다.
	// 16_ 정상적으로 데이터를 받았을 경우, "[요청 처리: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 만든다.
	// 18_ 문자열을 출력하도록 displayText()를 호출한다.
	// 20_ String(byteArr, 0, readByteCount, "UTF-8")을 이용해서 UTF-8로 디코딩한 문자열을 얻는다.
	// 22~24_ 문자열을 모든 클라이언트에게 보내기 위해 connections에 저장된 Client를 하나씩 얻어 send() 메소드를 호출한다.
	// 28_ 예외가 발생하면 connections 컬렉션에서 Client 객체를 제거한다. 예외는 11라인과 14라인에서 발생하는데, 모두 클라이언트와 통신이 되지 않을 때이다.
	// 29_ "[클라이언트 통신 안됨: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 생성한다.
	// 32_ 문자열을 출력하도록 displayText()로 호출한다.
	// 33_ Socket을 닫는다
	// 38_ 스레드풀에서 작업을 처리하기 위해 submit()을 호출한다.
	
	// 클라이언트로 메세지를 보내는 send(String data) 메소드 코드를 보자.
	
	//	01	void send(String data) {
	//	02		Runnable runnable = new Runnable() {	// 보내기 작업 생성
	//	03			@Override
	//	04			public void run() {
	//	05				try {	// 클라이언트로 데이터 보내기
	//	06					byte[] byteArr = data.getBytes("UTF-8");
	//	07					OutputStream outputStream = socket.getOutputStream();
	//	08					outputStream.write(byteArr);
	//	09					outputStream.flush();	//
	//	10				} catch(Exception e) {
	//	11					try {
	//	12						String message = "[클라이언트 통신 안됨: " +
	//	13										socket.getRemoteSocketAddress() + ": " +
	//	14										Thread.currentThread().getName() + "]";
	//	15						Platform.runLater( () -> displayText(message) );
	//	16						connections.remove(Client.this);
	//	17						socket.close();
	//	18					} catch(IOException e2) {}
	//	19				}
	//	20			}
	//	21		};
	//	22		executorService.submit(runnable);	// 스레드풀에서 처리
	//	23	}
	
	// 02_ 데이터를 클라이언트로 보내는 작업을 Runnable로 생성한다.
	// 04_ run()을 재정의한다.
	// 06_ 보낼 문자열로부터 UTF-8로 인코딩한 바이트 배열을 얻는다.
	// 07_ Socket에서 출력 스트림을 얻는다.
	// 08_ 바이트 배열을 매개값으로 해서 write() 메소드를 호출한다.
	// 09_ 출력 스트림의 내부 버퍼를 완전히 비우도록 flush()를 호출한다.
	// 12_ 8라인에서 예외가 발생하면 "[클라이언트 통신 안됨: 클라이언트 IP: 작업스레드이름]"으로 구성된 문자열을 생성한다.
	// 15_ 문자열을 출력하도록 displayText()를 호출한다.
	// 16_ connections 컬렉션에서 예외가 발생한 Client를 제거한다.
	// 17_ Socket을 닫는다.
	// 22_ 스레드풀에서 작업을 처리하기 위해 submit()을 호출한다.
	
			/*	UI Creation Code	UI 생성 코드	*/
	
	// 다음은 JavaFX를 이용한 UI 생성 코드를 보여준다. 프로그램적 레이아웃을 이용해서 컴포넌트를 배치했다.
	
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
	
	// 27라인은 외부 CSS 파일(app.css)을 Scene에 적용하고 있다. 그 이유는 TextArea의 배경색 때문인데, TextArea는 여러 겹의 컨테이너로 둘러싸여 있는 복잡한 구조를 가지고 있어
	// 단순히 TextArea의 setStyle()로 배경색을 바꿀 수 없다. 그래서 다음과 같이 외부 CSS 클래스 선택자를 이용해서 컨테이너의 배경색을 변경했다.
	
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
	
	// text-area만 gold색으로 설정하고, 나머지 컨테이너들은 모두 투명(transparent)으로 설정함으로써 TextArea 전체 배경색이 gold색으로 보이게 했다.
	
			//	Chatting Client Implementation		채팅 클라이언트 구현
	
	// 채팅 클라이언트 구현 코드를 보면서 Socket이 어떻게 사용되는지 이해해보자.
	
			/*	Client Class Structure		클라이언트 클래스 구조		*/
	
	// 다음 예제은 클라이언트 클래스의 구조를 보여준다.
	
	// 01_ JavaFX 메인 클래스로 만들기 위해 Application을 상속한다.
	// 02_ 클라이언트 통신을 위해 Socket 필드를 선언한다.
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
	//	06					socket = new Socket();
	//	07					socket.connect(new InetSocketAddress("localhost", 5001));	// 소켓 생성 및 연결 요청
	//	08					Platform.runLater( () -> {
	//	09						displayText("[연결 완료: " + socket.getRemoteSocketAddress() + "]");
	//	10						btnConn.setText("stop");
	//	11						btnSend.setDisable(false);
	//	12					});
	//	13				} catch(Exception e) {
	//	14					Platform.runLater( () -> displayText("[서버 통신 안됨]"));
	//	15					if(!socket.isClosed()) { stopClient(); }
	//	16					return;
	//	17				}
	//	18				receive();	// 서버에서 보낸 데이터 받기
	//	19			}
	//	20		};
	//	21		thread.start();	// 스레드 시작
	//	22	}
	
	// 02_ 작업 스레드를 생성한다. 작업 스레드가 필요한 이유는 7라인의 connect()와 18라인의 receive()에서 블로킹이 일어나기 때문이다. JavaFX Application Thread는 이 메소드들을 호출하지 않는 것이 좋다.
	// 04_ run() 메소드를 재정의한다.
	// 06_ 통신용 Socket을 생성한다.
	// 07_ local 5001 포트로 연결 요청을 한다.
	// 08_ 작업 스레드는 UI를 변경하지 못하므로 Platform.runLater()가 사용되었다.
	// 09_ "[연결 완료]"를 출력하도록 displayText()를 호출한다.
	// 10_ [start] 버튼의 글자를 [stop]으로 변경한다.
	// 11_ [send] 버튼을 활성화한다.
	// 14_ 예외가 발생하면 "[서버 통신 안됨"]을 출력하도록 displayText()를 호출한다.
	// 15_ Socket이 닫혀있지 않으면 stopClient() 메소드를 호출한다.
	// 16_ return을 실행해서 작업을 종료한다.
	// 18_ 예외가 발생하지 않으면 receive() 메소드를 호출한다.
	// 21_ 작업 스레드를 시작한다.
	
			/*	stopClient() Method	*/
	
	// [stop] 버튼을 클릭하거나 서버 통신이 안 될 경우 stopClient() 메소드가 실행되는데, stopClient() 메소드에는 Socket을 닫는 close() 메소드 호출 코드가 있다.
	
	//	01	void stopClient() {
	//	02		try {
	//	03			Platform.runLater( () -> {
	//	04				displayText("[연결 끊음]");
	//	05				btnConn.setText("start");
	//	06				btnSend.setDisable(true);
	//	07			});
	//	08			if(socket != null && !socket.isClosed()) {
	//	09				socket.close();
	//	10			}
	//	11		} catch(IOException e) {}
	//	12	}
	
	// 03_ UI를 변경하기 위해 Platform.runLater()가 사용되었다.
	// 04_ "[연결 끊음]"을 출력하도록 displayText()를 호출한다.
	// 05_ [stop] 버튼의 글자를 [start]로 변경한다.
	// 06_ [send] 버튼을 비활성화한다.
	// 08_ socket 필드가 null이 아니고, 현재 닫혀있지 않을 경우
	// 09_ Socket을 닫는다.
	
			/*	receive() Method	*/

	// receive() 메소드는 서버에서 보낸 데이터를 받는 역할을 한다. 이 메소드는 startClient()에서 생성한 작업 스레드상에서 호출된다.
	
	//	01	void receive() {
	//	02		while(true) {
	//	03			try {
	//	04				byte[] byteArr = new byte[100];
	//	05				InputStream inputStream = socket.getInputStream();
	//	06	
	//	07				// 서버가 비정상적으로 종료했을 경우 IOException 발생
	//	08				int readByteCount = inputStream.read(byteArr);		// 데이터 받기
	//	09	
	//	10				// 서버가 정상적으로 Socket의 close()를 호출했을 경우
	//	11				if(readByteCount == -1) { throw new IOException(); }
	//	12	
	//	13				String data = new String(byteArr, 0, readByteCount, "UTF-8");	// 문자열로 변환
	//	14	
	//	15				Platform.runLater( () -> displayText("[받기 완료]" + data)); 
	//	16			} catch(Exception e) {
	//	17				Platform.runLater( () -> displayText("[서버 통신 안됨]"));
	//	18				stopClient();
	//	19				break;
	//	20			}
	//	21		}
	//	22	}
	
	// 02_ 반복적으로 읽기 위해 무한 루프를 작성한다.
	// 04_ 받은 데이터를 저장할 길이가 100인 바이트 배열을 생성한다.
	// 05_ Socket으로부터 InputStream을 얻는다.
	// 08_ InputStream의 read() 메소드를 호출한다. 서버가 데이터를 보내기 전까지 블로킹되며, 데이터를 받으면 byteArr에 저장하고 받은 바이트 개수는 readByteCount에 저장한다.
	// 11_ 서버가 정상적으로 Socket의 close()를 호출했을 경우, 8라인의 read() 메소드는 -1을 리턴한다. 이 경우 IOException을 강제로 발생시킨다.
	// 13_ 정상적으로 데이터를 받았을 경우, String(byteArr, 0, readByteCount, "UTF-8")을 이용해서 UTF-8로 디코딩한 문자열을 얻는다.
	// 15_ "[받기 완료] + 받은 문자열"을 출력하도록 displayText()를 호출한다.
	// 17_ 서버가 비정상적으로 연결을 끊게 되면 8라인에서 IOExceptiond이 발생하고, 서버 측 Socket이 close()를 호출해서 정상적으로 연결을 끊게 되면 11라인에서 IOException을 발생한다.
	//		예외가 발생하면 "[서버 통신 안됨]"을 출력하도록 displayText()를 호출한다.
	// 18_ stopClient()를 호출한다.
	// 19_ break를 실행해서 무한루프를 빠져나온다.
	
			/*	send(String data) Method	*/
	
	// send(String data) 메소드는 사용자가 메세지를 입력하고 [send] 버튼을 클릭하면 메세지를 매개값으로 호출한다.
	// send() 메소드는 서버로 메세지를 보내는 역할을 한다.
	
	//	01	void send(String data) {
	//	02		Thread thread = new Thread() {	// 스레드 생성
	//	03			@Override
	//	04			public void run() {
	//	05				try {
	//	06					byte[] byteArr = data.getBytes("UTF-8");
	//	07					OutputStream outputStream = socket.getOutputStream();	// 서버로 데이터 보내기
	//	08					outputStream.write(byteArr);
	//	09					outputStream.flush();
	//	10					Platform.runLater( () -> displayText("[보내기 완료]"));
	//	11				} catch(Exception e) {
	//	12					Platform.runLater( () -> displayText("[서버 통신 안됨]"));
	//	13					stopClient();
	//	14				}
	//	15			}
	//	16		};
	//	17		thread.start();	// 스레드 생성
	//	18	}
	
	// 02_ 데이터를 서버로 보내는 새로운 작업 스레드를 생성한다.
	// 04_ run()을 재정의한다.
	// 06_ 보낼 문자열로부터 UTF-8로 인코딩한 바이트 배열을 얻는다.
	// 07_ Socket에서 출력 스트림을 얻는다.
	// 08_ 바이트 배열을 매개값으로 해서 write() 메소드를 호출한다.
	// 09_ 출력 스트림의 내부 버퍼를 완전히 비우도록 flush()를 호출한다.
	// 10_ "[보내기 완료]"를 출력하도록 displayText()를 호출한다.
	// 12_ 8라인에서 예외가 발생하면 "[서버 통신 안됨]"을 출력하도록 displayText()를 호출한다.
	// 13_ stopClient()를 호출한다.
	// 17_ 작업 스레드를 시작한다.
	
			/*	UI Creation Code	UI 생성 코드	*/
	
	// 다음은 JavaFX를 이용한 UI 생성 코드를 보여준다. 프로그램적 레이아웃을 이용해서 컨트롤을 배치했다.
	
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
}
