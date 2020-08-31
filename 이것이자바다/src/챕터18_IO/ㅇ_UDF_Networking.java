package 챕터18_IO;

public class ㅇ_UDF_Networking {
	// UDP(User Datagram Protocol)는 비연결 지향적 프로토콜이다. 비연결 지향적이란 데이터를 주고받을 때 연결 절차를 거치지 않고, 발신자가 일방적으로 데이터를 발신하는 방식이다.
	// 연결 과정이 없기 때문에 TCP보다는 빠른 전송을 할 수 있지만 데이터 전달의 신뢰성은 떨어진다. UDP는 발신자가 데이터 패킷을 순차적으로 보내더라도 이 패킷들은 서로 다른 통신 선로를 통해 전달될 수 있다.
	// 먼저 보낸 패킷이 느린 선로를 통해 전송될 경우 나중에 보낸 패킷보다 늦게 도착할 수 있다. 그리고 일부 패킷은 잘못된 선로로 전송되어 잃어버릴 수도 있다.
	
	// UDP는 편지에 비유할 수 있다. 반신자는 봉투(패킷)에 수신자의 주소(원격지 IP와 포트)와 발신자의 주소(로컬 IP와 포트)를 쓴다. 그리고 봉투 안에 편지(전송할 데이터)를 넣고 편지를 보낸다.
	// 발신자는 수신자가 편지를 받았는지, 못 받았는지를 알지 못한다. 게다가 최근데 보낸 편지가 예전에 보낸 편지보다 더 빨리 도착할 수도 있고, 전혀 도착하지 않을 수도 있다.
	
	// 일반적으로 데이터 전달의 신뢰성보다는 속도가 중요한 프로그램에서는 UDP를 사용하고, 데이터 전달의 신뢰성이 중요한 프로그램에서는 TCP를 사용한다. 자바에서는 UDP 프로그래밍을 위해
	// java.net.DatagramSocket과 java.net.DatagramPacket 클래스를 제공하고 있다.
	// DatagramSocket은 발신점과 수신점에 해당하는 클래스이고, DatagramPacket은 주고받는 패킷 클래스이다.
	
	//		┌───────────┐														┌───────────┐
	//		│발신자		│														│수신자		│
	//		│		DatagramSocket ─────────→ DatagramPacket ───────→ DatagramSocket		│
	//		│			│														│			│
	//		└───────────┘														└───────────┘
	
			//	Caller Implementation	발신자 구현
	
	// 발신자 프로그램을 구현해보면서 DatagramSocket을 사용하는 방법을 이해해보자. 우선 DatagramSocket 객체를 다음과 같이 생성한다.
	
	//	DatagramSocket datagramSocket = new DatagramSocket();
	
	// 보내고자 하는 데이터를 byte[] 배열로 생성하는데, 문자열인 경우 다음과 같이 UTF-8로 인코딩해서 byte[] 배열을 얻으면 된다.
	
	//	byte[] byteArr = data.getBytes("UTF-8");
	
	// 이제 데이터와 수신자 정보를 담고 있는 DatagramPacket을 생성해야 하는데, DatagramPacket 생성자의 첫 번째 매개값은 보낼 데이터인 byte[] 배열이고,
	// 두 번째 매개값은 byte[] 배열에서 보내고자 하는 항목 수이다. 전체 항목을 보내려면 length 값으로 대입하면 된다. 세 번째 매개값은 수신자 IP와 포트 정보를 가지고 있는 SocketAddress이다.
	// SocketAddress는 추상 클래스이므로 하위 클래스인 InetSocketAddress 객체를 생성해서 대입하면 된다. 다음은 로컬 PC 5001번을 수신자로 하는 DatagramPacket을 생성하는 코드이다.
	
	//	byte[] byteArr = data.getBytes("UTF-8");
	//	DatagramPacket packet = new DatagramPakcet(
	//		byteArr, byteArr.length,
	//		new InetSocketAddress("localhost", 5001)
	//	);
	
	// DatagramPacket을 생성했다면, 이것을 매개값으로 해서 DatagramSocket의 send() 메소드를 호출하면 수신자에게 데이터가 전달된다.
	
	//	datagramSocket.send(pocket);
	
	// 더 이상 보낼 데이터가 없을 경우에는 DatagramSocket을 닫기 위해 close() 메소드를 호출한다.
	
	//	datagramSocket.close();
	
	// 다음은 발신자 프로그램의 전체 코드이다. for문을 두 번 반복하는데 각각 "메세지1", "메세지2" 문자열을 전송하도록 했다.
	
			//	Recipient Implementation	수신자 구현
	
	// 수신자 프로그램을 구현해보면서 DatagramSocket을 사용하는 방법을 이해해보자. 수신자로 사용할 DatagramSocket 객체는 다음과 같이 바인딩할 포트 번호를 매개값으로 지정하고 생성해야 한다.
	
	//	DatagramSocket datagramSocket = new DatagramSocket(5001);
	
	// DatagramSocket이 생성되었다면 다음과 같이 receive() 메소드를 호출해서 패킷을 읽을 준비를 한다. receive() 메소드는 패킷을 받을 때까지 블로킹되고, 
	// 패킷이 도착하면 매개값으로 주어진 DatagramPacket에 패킷 내용을 저장한다.
	
	//	datagramSocket.receive(datagramPacket);
	
	// 패킷의 내용을 저장할 DatagramPacket 객체는 다음과 같이 생성한다. 첫 번째 매개값은 읽은 패킷 데이터를 저장할 바이트 배열이고, 
	// 두 번째 매개값은 읽을 수 있는 최대 바이트 수로 첫 번째 바이트 배열의 크기와 같거나 작아야 한다. 일반적으로 첫 번째 바이트 배열의 크기를 준다.
	
	//	DatagramPacket datagramPacket = new DatagramPacket(new byte[100], 100);
	
	// receive() 메소드로 패킷을 읽었다면 DatagramPacket의 getData() 메소드로 데이터가 저장된 바이트 배열을 얻어낼 수 있다.
	// 그리고 getLength()를 호출해서 읽은 바이트 수를 얻을 수 있다. 받은 데이터가 인코딩된 문자열이라면 다음과 같이 디코딩해서 문자열을 얻으면 된다.
	
	//	String data = new String(packet.getData(), 0, packet.getLength(), "UTF-8");
	
	// 만약 수신자가 패킷을 받고 나서 발신자에게 응답 패킷을 보내고 싶다면 발신자의 IP와 포트를 알아야 한다.
	// DatagramPacket의 getSocketAddress()를 호출하면 발신자의 SocketAddress 객체를 얻어 낼수 있어, 발신자에게 응답 패킷을 보낼 때 send() 메소드에서 이용할 수 있다.
	
	//	SocketAddress socketAddress = packet.getSocketAddress();
	
	// 수신자는 항상 데이터를 받을 준비를 해야 하므로 작업 스레드를 생성해서 receive() 메소드를 반복적으로 호출해야 한다. 작업 스레드를 종료시키는 방법은 receive() 메소드가 블로킹되어 있는 상태에서
	// DatagramSocket의 close()를 호출하면 된다. 이 경우 receive() 메소드에서 SocketException이 발생하게 되고, 예외 처리 코드에서 작업 스레드를 종료시키면 된다.
	
	//	datgramScoket.close();
	
	// 다음은 수신자 프로그램의 전체 코드이다. 실행 후 10초가 지나면 수신자를 종료하도록 했다.
	
	// 실행 순서는 상관없지만, 수신자를 먼저 실행하고 발신자를 실행해야만 발신자가 보낸 데이터를 수신자가 모두 받을 수 있다.
	// 발신자를 먼서 실행하면 수신자가 실행하기 전에 보낸 데이터는 받을 수 없다.
}
