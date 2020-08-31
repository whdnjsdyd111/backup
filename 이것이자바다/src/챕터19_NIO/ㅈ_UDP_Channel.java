package 챕터19_NIO;

public class ㅈ_UDP_Channel {
	// NIO에서 UDP 채널은 DatagramChannel이다. DatagramChannel도 TCP 채널과 마찬가지로 블로킹과 넌블로킹 방식으로 사용할 수 있지만, 이 책에서는 블로킹 방식만 설명하도록 하겠다.
	
			//	Creation Caller		발신자 만들기
	
	// 발신자 프로그램을 구현해보면서 DatagramChannel을 사용하는 방법에 대해 알아보기로 하자. Datagram을 생성하려면 open() 메소드를 호출해야 한다.
	// open() 메소드는 ProtocalFamily 인터페이스 타입의 매개값을 가지는데, 이 객체의 역할은 IPv4와 IPv6를 구분하기 위해서이다.
	// 구현 객체는 StandardProtocalFamily 열거 상수를 사용하면 된다. 다음은 IPv4를 사용하는 DatagramChannel을 생성하는 코드이다.
	
	//	DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocalFamily.INET);
	
	// DatagramChannel을 이용해서 데이터를 보내기 위해서는 send() 메소드를 이용한다. send() 메소드의 첫 번째 매개값은 보낼 데이터를 가지고 있는 ByteBuffer이고,
	// 두 번째 매개값은 수신자 IP와 포트 정보를 가지고 있는 SocketAddress이다. SocketAddress는 추상 클래스이므로 하위 클래스인 InetSocketAddress 객체를 생성하고 대입하면 된다.
	// send() 메소드의 리턴값은 실제로 보낸 바이트 수이다. 다음은 로컬 PC 5001번을 수신자로하고 데이터를 보낸다.
	
	//	int byteCount = datagramChannel.send(byteBuffer, new InetSocketAddress("local", 5001));
	
	// 더 이상 보낼 데이터가 없을 경우에는 DatagramChannel을 닫기 위해 close() 메소드를 호출한다.
	
	//	datagramChannel.close();
	
	// 다음 예제는 UDP 발신 프로그렘이다. for문은 두 번 반복하는데 각각 "메세지1", "메세제2" 문자열을 전송한다.
	
			//	Creation Receiver	수신자 만들기
	
	// 이번에는 DatagramChannel로 수신자 프로그램을 구현하는 방법에 대해 알아보기로 하자. DatagramChannel을 이용해서 데이터를 받기 위해서는 bind() 메소드를 호출해서 포트와 먼저 바인딩을 해야한다.
	// 매개값은 SocketAddress 타입으로 InetSocketAddress 객체를 대입하면 된다.
	
	//	DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocalFamily.INET);
	//	datagramChannel.bind(new InetSocketAddress(5001));
	
	// 포트와 바인딩이 되었다면 다음과 같이 receive() 메소드로 데이터를 받을 수 있다. receive() 메소드의 매개값은 받은 데이터를 저장할 ByteBuffer이고,
	// 리턴 타입은 원격 클라이언트의 IP와 포트 정보를 가지고 있는 SocketAddress이다. 실제로는 InetSockeAddress가 리턴된다.
	
	// 데이터를 받기 전까지 receive() 메소드는 블로킹되고, 데이터를 받으면 리턴된다. 수신자는 항상 데이터를 받을 준비를 해야 하므로 작업 스레드를 생성해서 receive() 메소드를 반복적으로 호출해야 한다.
	// 작업 스레드를 종료시키는 방법은 두 가지인데, receive() 메소드가 블로킹되어 있는 상태에서 작업 스레드의 interrupt()를 호출시켜 ClosedByInterruptException 예외를 발생 시키거나,
	// 다음과 같이 DatagramChannel의 close()를 호출시켜 AsynchronousCloseException 예외를 발생시키는 것이다. 그리고 예외 처리 코드에서 작업 스레드를 종료시키면 된다.
	
	//	datagramChannel.close();
	
	// 다음은 수신자 프로그램의 전체 코드이다. 실행 후 10초가 지나면 수신자를 종료하도록 했다.
	
			//	Run Sender And Receiver		수신자와 발신자 실행
	
	// 실행 순서는 상관없지만, 수신자를 먼저 실행하고 발신자를 실행해야만 발신자가 보낸 데이터를 수신자가 모두 받을 수 있다.
	// 발신자를 먼서 실행하면 수신자가 실행하기 전에 보낸 데이터는 받을 수 없다.
}
