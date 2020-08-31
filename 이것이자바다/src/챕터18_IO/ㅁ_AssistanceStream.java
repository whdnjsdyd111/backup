package 챕터18_IO;

public class ㅁ_AssistanceStream {
	// 보조 스트림이란 다른 스트림과 연결되어 여러 가지 편리한 기능을 제공해주는 스트림을 말한다. 보조 스트림을 필터(filter) 스트림이라고도 하는데,
	// 이는 보조 스트림의 일부가 FilterInputStream, FilterOutputStream의 하위 클래스이기 때문이다.
	// 하지만 다른 보조 스트림은 이 클래스들을 상속받지 않기 때문에 이 책에서는 필터 스트림이란 용어 대신 사용 목적에 맞게 보조 스트림이라고 부르기로 하겠다.
	
	// 보조 스트림은 자체적으로 입출력을 수행할 수 없기 때문에 입력 소스와 바로 연결되는 InputStream, FileInputStream, Reader, FileReader,
	// 출력 소스와 바로 연결되는 OuputStream, FileOutputStream, Writer, FileWriter 등에 연결해서 입출력을 수행한다.
	// 보조 스트림은 문자 변환, 입출력 성능 향상, 기본 데이터 타입 입출력, 객체 입출력 등의 기능을 제공한다. 다음은 입력 스트림과 출력 스트림에 보조 스트림을 연결한 모습을 가상화시킨 것이다.
	
	//					┌───┐		┌───────────────┌───┐
	//		┌───────────│	└───────┐	     프로그램		│	└───────┌───────────┐
	//	────→	입력 스트림	│	보조 스트림1────→		────→	보조스트림2	│	출력 스트림	────→
	//		└───────────│	┌───────┘				│	┌───────└───────────┘
	//					└───┘		└───────────────└───┘
	
	// 보조 스트림을 생성할 때에는 자신이 연결될 스트림을 다음과 같이 생성자의 매개값으로 받는다.
	
	//	보조스트림 변수 = new 보조스트림(연결스트림);
	
	// 예를 들어 콘솔 입력 스트림을 문자 변환 보조 스트림인 InputStreamReader에 연결하는 코드는 다음과 같다.
	
	//	InputStream is = new System.in;
	//	InputStreamReader reader = new InputStreamReader(is);
	
	// 다음을 보면 보조 스트림은 또 다른 보조 스트림에도 연결되어 스트림 체인을 구성할 수 있다.
	
	//					┌───┐	┌───┐		┌───────────────┌───┐	┌───┐
	//		┌───────────│보조	└───│보조	└───────┐	     프로그램		│보조	└───│보조	└───────┌───────────┐
	//	────→ 주 입력 스트림	│스트림1	│스트림2		────→		────→스트림1	│스트림2		│주 출력 스트림	────→
	//		└───────────│	┌───│	┌───────┘				│	┌───│	└───────└───────────┘
	//					└───┘	└───┘		└───────────────└───┘	└───┘
	
	// 예를 들어 문자 변환 보조 스트림인 InputStreamReader를 다시 성능 향상 보조 스트림인 BufferedRaeder에 연결하는 코드는 다음과 같다.
	
	//	InputStream is = System.in;
	//	InputStreamReader reader = new InputStreamReader(is);
	//	BufferedReader br = new BufferedReader(reader);
	
			//	Character Conversion Assistance Stream		문자 변환 보조 스트림
	
	// 소스 스트림이 바이트 기반 스트림(InputStream, OutputStream, FileInputStream, FileOutputStream)이면서 입출력 데이터가 문자라면 Reader와 Writer로 변환해서 사용하는 것을 고려해야 한다.
	// 그 이유는 Reader와 Writer는 문자 단위로 입출력하기 때문에 바이트 기반 스트림보다는 편리하고, 문자셋의 종류를 지정할 수 있기 때문에 다양한 문자를 입출력할 수 있다.
	
			/*	InputStreamReader	*/
	
	// InputStreamReader는 바이트 입력 스트림에 연결되어 문자 입력 스트림인 Reader로 변환시키는 보조 스트림이다.
	
	//						InputStreamReader ┌───────────────┐
	//							  ┌───┐		  │		프로그램	  │		
	//				┌─────────────┼---┼───────┐	     		  │
	//	   바이트	────→ InputStream ───→│ Reader────→  문자		  │
	//				└─────────────┼---┼───────┘			  	  │
	//							  └───┘		  └───────────────┘
	
	//	Reader reader = new InputStreamReader("바이트입력스트림");
	
	// 예를 들어 콘솔 입력을 위한 InputStream을 다음과 같이 Reader 타입으로 변환할 수 있다.
	
	//	InputStream is = System.in;
	//	Reader reader = new InputStreamReader(is);
	
	// 파일 입력을 위한 FileInputStream도 다음과 같이 Reader 타입으로 변환시킬 수 있다.
	
	//	FileInputStream fis = new FileInputStream("C:/Temp/file.txt");
	//	Reader reader = new InputStreamReader(fis);
	
	// FileInputStream에 InputStreamReader을 연결하지 않고 FileReader를 직접 생성할 수도 있다. FileReader는 InputStreamReader의 하위 클래스이다.
	// 이것은 FileReader가 내부적으로 FileInputStream에 InputStreamReader 보조 스트림을 연결한 것이라고 볼 수 있다.
	// 다음은 콘솔에서 입력한 한글을 Reader를 이용해서 읽고, 다시 콘솔로 출력하는 예제이다.
	
			/*	OutputStreamWriter	*/
	
	// OutputStreamWriter는 바이트 출력 스트림에 연결되어 문자 출력 스트림인 Writer로 변환시키는 보조 스트림이다.
	
	//				OutputStreamWriter
	//	┌───────────────┌───┐	
	//	│	     프로그램		├───┴───┬---┬─────────────┐
	//	│		문자	────→ Writer│ → │OutputStream ────→	바이트
	//	│				├───┬───┴---┴─────────────┘
	//	└───────────────└───┘
	
	//	Writer writer = new OutputStreamWriter(바이트출력스트림);
	
	// 예를 들어 파일 출력을 위한 FileOutputStream을 다음과 같이 Writer 타입으로 변환할 수 있다.
	
	//	FileOutputStream fos = new FileOutputStream("C:/Temp/file.txt");
	//	Writer writer = new OutputStreamWriter(fos);
	
	// FileOutputStream에 OutputStreamWriter를 연결하지 않고 FileWriter를 직접 생성할 수도 있다. FileWrtier는 OutputStreamWriter의 하위 클래스이다.
	// 이것은 FileWriter가 내부적으로 FileOutputStream에 OutputStreamWriter 보조 스트림을 연결한 것으로 볼 수 있다.
	// 다음은 FileOutputStream을 Writer로 변환해서 문자열을 파일에 저장한다.
	
	//	실행결과
	//
	//	┌───────────────┐───────────┐	┌───────────────────────────────┐
	//	│	:			│ ■ file.txt│	│file.txt - 메모장				│
	//	│	■ Temp		│			│	├───────────────────────────────┤
	//	│	■ Windows	│			│	│바이트 출력 스트림을 문자 출력 스트림으로 변환	│
	//	│	■ 사용자		│			│	│								│
	//	│	:			│			│	│								│
	//	└───────────────┘───────────┘	└───────────────────────────────┘
	
			//	Performance Improvement Assistance Stream		성능 향상 보조 스트림
	
	// 프로그램의 실행 성능은 입출력이 가장 늦은 장치를 따라간다. CPU와 메모리가 아무리 뛰어나도 하드 디스크의 입출력이 낮아지면 프로그램의 실행 성능은 하드 디스크의 처리 속도에 맞춰진다.
	// 네트워크로 데이터를 전송할 때도 마찬가지다. 느린 네트워크 환경이라면 컴퓨터 사양이 아무리 좋아도 메신저와 게임의 속도는 느릴 수밖에 없다.
	// 이 문제에 대한 완전한 해결책은 될 수 없지만, 프로그램이 입출력 소스와 직접 작업하지 않고 중간에 메모리 버퍼(buffer)와 작업함으로써 실행 성능을 향상시킬 수 있다.
	// 예를 들어 프로그램은 직접 하드 디스크에 데이터를 보내지 않고 메모리 버퍼에 데이터를 보냄으로써 쓰기 속도가 향상된다. 
	// 버퍼는 데이터가 쌓이기를 기다렸다가 꽉 차게 되면 데이터를 한꺼번에 하드 디스크로 보냄으로써 출력 횟수를 줄여준다.
	
	//	┌───────────┐		┌───────────────────┐
	//	│	프로그램	│		│		메모리 버퍼		│						┌───────────┐
	//	│			│		│	────────────	│	한 번에 버퍼 내용			│  			│
	//	│  데이터 	┌┐	│──────────→ ┌┬┬┬┬┬┬┬┬┬┐  ─────────────────────→	│  하드 디스크	│
	//	│		└┘	│		│	 └┴┴┴┴┴┴┴┴┴┘	│		모두를 전송			│			│
	//	└───────────┘		│	────────────	│						└───────────┘
	//						└───────────────────┘
	
	// 보조 스트림 중에서는 위와 같이 메모리 버퍼를 제공하여 프로그램의 실행 성능을 향상시키는 것들이 있다. 
	// 바이트 기반 스트림에는 BufferedInputStream, BufferedOutputStream이 있고, 문자 기반 스트림에는 BufferedReader, BufferedWriter가 있다.
	
			/*	BufferedInputStream And BufferedReader	*/
	
	// BufferedInputStream은 바이트 입력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림이고, BufferedReader는 문자 입력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림이다.
	// BufferedInputStream과 BufferedReader는 입력 소스로부터 자신의 내부 버퍼 크기만큼 데이터를 미리 읽고 버퍼에 저장해 둔다. 
	// 프로그램은 외부의 입력 소스로부터 직접 읽는 대신 버퍼로부터 읽음으로써 읽기 성능이 향상한다.
	
	//						┌─────────────────────┐
	//	┌───────────┐		│ BufferedInputStream │
	//	│	프로그램	│		│ 	 BufferedReader	  │				┌───────────┐
	//	│			│ 고속 읽기	│	  ────────────	  │	  미리 버퍼에	│ 			│
	//	│  데이터 	┌┐	│←──────────   ┌┬┬┬┬┬┬┬┬┬┐  ←───────────────│	입력 소스	│
	//	│		└┘	│		│	   └┴┴┴┴┴┴┴┴┴┘	  │	 데이터를 채워둠	│			│
	//	└───────────┘		│	  ────────────	  │				└───────────┘
	//						└─────────────────────┘
	
	// BufferedInputStream과 BufferedReader 보조 스트림은 다음과 같이 생성자의 매개값으로 준 입력 스트림과 연결되어 8192 내부 버퍼 사이즈를 가지게 된다.
	// BufferedInputStream은 최대 8192 바이트가, BufferedReader는 최대 8192 문자가 저장될 수 있다.
	
	//	BufferedInputStream bis = new BufferedInputStream(바이트입력스트림);
	//	BufferedReader br = new BufferedReader(문자입력스트림);
	
	// BufferedInputStream과 BufferedReader로 데이터를 읽어들이는 방법은 InputStream 또는 Reader와 동일하다.
	// 다음은 BufferedInputStream을 사용하지 않았을 때와 사용했을 때, forest.jpg 파일을 읽는 성능 차이를 보여주는 예제이다. 실행 결과를 보면 사용했을 때가 훨씬 성능이 좋아지는 것을 볼 수 있다.
	
	// BufferedReader는 readLine() 메소드를 추가적으로 더 가지고 있는데, 이 메소드를 이용하면 캐리지리턴(\r) 라인피드(\n)로 구분된 행 단위의 문자열을 한꺼번에 읽을 수 있다.
	// 다음 코드는 Enter키를 입력하기 전까지 콘솔에서 입력한 모든 문자열을 한꺼번에 얻는다.
	
	//	Reader reader = new InputStreamReader(System.in);
	//	BufferedReader br = new BufferedReader(reader);
	//	String inputStr = br.readLine();
	
			/*	BufferedOutputStream And BufferedWriter	*/
	
	// BufferedOutputStream은 바이트 출력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림이고, BufferedWriter는 문자 출력 스트림에 연결되어 버퍼를 제공해주는 보조 스트림이다.
	// BufferedOutputStream과 BufferedWriter는 프로그램에서 전송한 데이터를 내부 버퍼에 쌓아 두었다가 버퍼가 꽉 차면, 버퍼의 모든 데이터를 한꺼번에 보낸다.
	// 프로그램 입장에서 보면 직접 데이터를 보내는 것이 아니라, 메모리 버퍼로 데이터를 고속 전송하기 때문에 실행 성능이 향상되는 효과를 얻는다.
	
	//						┌─────────────────────┐
	//	┌───────────┐		│ BufferedOutputStream│
	//	│	프로그램	│		│ 	 BufferedWriter	  │				┌───────────┐
	//	│			│ 고속 읽기	│	  ────────────	  │	  한 번에 버퍼 내용	│ 			│
	//	│  데이터 	┌┐	│──────────→   ┌┬┬┬┬┬┬┬┬┬┐  ───────────────→│	목적지	│
	//	│		└┘	│		│	   └┴┴┴┴┴┴┴┴┴┘	  │	 모두를 전송 	│			│
	//	└───────────┘		│	  ────────────	  │				└───────────┘
	//						└─────────────────────┘
	
	// BufferedOutputStream과 BufferedWriter 보조 스트림은 다음과 같이 생성자의 매개값으로 준 출력 스트림과 연결되어 8192 내부 버퍼 사이즈를 가지게 된다.
	// BufferedOutputStream은 8192 바이트가, BufferedWriter는 8192 문자가 최대 저장될 수 있다.
	
	//	BufferedOutputStream bos = new BufferedOutputStream(바이트출력스트림);
	//	BufferedWriter bw = new BufferedWriter(문자출력스트림);
	
	// BufferedOutputStream과 BufferedWriter로 데이터를 출력하는 방법은 OutputStream 또는 Writer와 동일하다.
	// 주의할 점은 버퍼가 가즉 찼을 때만 출력을 하기 때문에 마지막 자투리 데이터 부분이 목적지로 가지 못하고 버퍼에 남아있을 수 있다.
	// 그래서 마지막 출력 작업을 마친 후에 flush() 메소드를 호출하여 버퍼에 잔류하고 있는 데이터를 모두 보내도록 해야한다.
	// 다음은 파일 복사 예제인데 BufferedOutputStream을 사용했을 때와 사용하지 않았을 때의 프로그램 실행 성능 차이를 보여준다. 실행 결과를 보면 사용했을 때가 훨씬 성능이 좋아지는 것을 볼 수 있다.
	
			//	Basic Type InOutput Assistance Stream		기본 타입 입출력 보조 스트림
	
	// 바이트 스트림은 바이트 단위로 입출력하기 때문에 자바의 기본 데이터 타입인 boolean, char, short, int, long, float, double 단위로 입출력할 수 없다.
	// 그러나 DataInputStream과 DataOutputStream 보조 스트림을 연결하면 기본 데이터 타입으로 입출력이 가능하다.
	
	//											  ┌─────────────────┐
	//							  ┌───┐			  │ 	프로그램		┌───┐
	//				┌─────────────│	  └─────────────┐	          	│	└──────────────┌─────────────┐
	//	   바이트	────→ InputStream │ DataInputStream ──→   기본	  ──→ DataOutputStream │ OutputStream ────→	바이트
	//				└─────────────│	  ┌─────────────┘	데이터 타입		│	┌──────────────└─────────────┘
	//							  └───┘			  │	 (int, double)	└───┘
	//											  └─────────────────┘
	
	// 다음은 DataInputStream과 DataOutputStream 객체를 생성하는 코드이다. 다른 보조 스트림과 마찬가지로 연결할 바이트 입출력 스트림을 생성자의 매개값으로 주면 된다.
	
	//	DataInputStream dis = new DataInputStream(바이트입력스트림);
	//	DataOutputStream dos = new DataOutputStream(바이트출력스트림);
	
	// 다음은 기본 데이터 타입을 입출력하기 위해 DataInputStream과 DataOutputStream이 제공하는 메소드들을 보여준다.
	
	//		DataInputStream				│		DataOutputStream
	//									│
	//	boolean		readBoolean()		│	void		writeBoolean(boolean v)
	//	byte		readByte()			│	void		writeByte(int v)
	//	char		readChar()			│	void		writeChar(int v)
	//	double		readDouble()		│	void		writeDouble(double v)
	//	float		readFloat()			│	void		writeFloat(float v)
	//	int			readInt()			│	void		writeInt(int v)
	//	long		readLong()			│	void		writeLong(long v)
	//	short		readShort()			│	void		writeShort(int v)
	//	String		readString()		│	void		writeUTF(String str)
	
	// 이 메소드들은 입출력할 때 주의할 점이 있는데, 데이터 타입의 크기가 모두 다르므로 DataOutputStream으로 출력한 데이터를 다시 DataInputStream으로 읽어올 때는 출력한 순서와 동일한 순서로 읽어야 한다.
	// 예를 들어 출력할 때의 순서가 int ㅡ→ boolean ㅡ→ double 이라면 읽을 때는 순서도 int ㅡ→ boolean ㅡ→ double 이어야 한다.
	// 다음은 이름, 성적, 순위 순으로 파일에 출력하고 다시 이름, 성적, 순위 순으로 파일로부터 입력받는 예제이다.
	
			//	Printer Assistance Stream		프린터 보조 스트림
	
	// PrintStream과 PrintWriter는 프린터와 유사하게 출력하는 print(), println() 메소드를 가지고 있는 보조 스트림이다.
	// 지금까지 매우 빈번히 사용했던 콘솔 출력 스트림인 System.out이 바로 PrintStream 타입이기 때문에 print(), println() 메소드를 사용할 수 있었다.
	// PrintStream은 바이트 출력 스트림과 연결되고, PrintWriter는 문자 출력 스트림과 연결된다. PrintStream과 PrintWriter는 거의 같은 기능을 가지고 있다.

	//				PrintStream / PrintWriter
	//	┌───────────────┌─────────┐
	//	│	 프로그램		│	 	  │
	//	│	     		│ print() └───────┌───────────────────────────┐
	//	│	기본 타입	────→ println()	────────→ OutputStream / Writer	────→
	//	│	또는			│ printf()┌───────└───────────────────────────┘
	//	│	문자열		│	 	  │
	//	└───────────────└─────────┘
	
	// PrintStream과 PrintWriter는 다른 보조 스트림과 마찬가지로 연결할 출력 스트림을 생성자의 매개값으로 받는다.
	
	//	PrintStream ps = new PrintStream(바이트출력스트림);
	//	PrintWriter pw = new PrintWriter(문자출력스트림);
	
	// println() 메소드는 출력할 데이터 끝에 개행 문자인 '\n'를 더 추가시켜주기 때문에 콘솔이나 파일에서 줄 바꿈이 일어난다. 그러나 print() 메소드는 개행 없이 계속해서 문자를 출력시킨다.
	// println()과 print() 메소드는 출력할 데이터 타입에 따라 다음과 같이 오버 로딩이 되어 있다.
	
	//	PrintStream / PrintWriter
	//
	//	void	print(boolean b)			void		println(boolean b)
	//	void	print(char c)				void		println(char c)
	//	void	print(double d)				void		println(double d)
	//	void	print(float f)				void		println(float f)
	//	void	print(int i)				void		println(int i)
	//	void	print(long l)				void		println(long i)
	//	void	print(Object o)				void		println(Object o)
	//	void	print(String s)				void		println(String s)
	//										void		println()
	
	// 다음 예제는 FileOutputStream에 보조 스트림으로 PrintStream을 연결해서 print()와 println() 메소드로 문자열을 출력시킨다.
	
	//	실행결과
	//
	//	┌───────────────┐───────────┐	┌───────────────────────────────┐
	//	│	:			│ ■ file.txt│	│file.txt - 메모장				│
	//	│	■ Temp		│			│	├───────────────────────────────┤
	//	│	■ Windows	│			│	│[프린터 보조 스트림]					│
	//	│	■ 사용자		│			│	│마치 프린터가 출력하는 것처럼				│
	//	│	:			│			│	│데이터를 출력합니다.					│
	//	└───────────────┘───────────┘	└───────────────────────────────┘
	
	// InputStream과 PrintWriter는 println()과 print() 이외에 printf()도 제공한다.
	// printf() 메소드는 형식화된 문자열(format string)을 출력할 수 있도록 하기 위해 자바 5부터 추가된 메소드이다.
	// 첫 번째 매개값으로 형식화된 문자열을 지정하고, 두 번째 매개값부터 형식화된 문자열에 들어갈 값을 나열해주면 된다.
	
	//						printf( String format, Object... args)
	//								 형식화된 문자열		형식화된 문자열에 제공될 매개값
	//									↙
	//
	//		%	[argument_index$]	[flags]	[width]	[.precision]	conversion
	//				매개값의 순번		 -, 0	 전체 자릿수	    소수 자릿수		    변환문자
	
	// 형식화된 문자열에서 %와 conversion (변환문자)은 필수적으로 작성하고 그 이외의 항목은 생략할 수 있다. 
	// argument_index$는 적용할 매개값의 순번인데 1$는 첫 번째 매개값, 2$는 두 번째 매개값을 말한다. flags는 빈공간을 채우는 방법인데, 생략되면 왼쪽이 공백으로 채워지고, -는 오른쪽이 공백으로 채워진다.
	// 0은 왼족이 0으로 채워진다. width는 전체 자릿수이며, precision은 소수자릿수를 뜻한다. 변환문자에 정수(d), 실수(f), 문자열(s)과 시간과 관련된 문자가 와서 매개값을 해당 타입으로 출력한다.
	// 형식화된 문자열에 대한 자세한 내용은 Java API 도큐먼트에서 java.util.Formatter 클래스의 Format String Syntax 부분을 읽어보면 된다.
	// 형식화된 문자열에서 자주 사용되는 것을 정리해보면 다음과 같다.
		
	//		형식화된 문자			설명											출력 형태	
	//	────────────────────────────────────────────────────────────────────────────────────
	//			%d			정수											123
	//	정수		%6d			6자리 정수. 왼쪽 빈자리 공백							___ 123
	//			%-6d		6자리 정수. 오른쪽 빈자리 공백						123 ___
	//			%06d		6자리 정수. 왼쪽 빈자리 0 채움						000123
	//	────────────────────────────────────────────────────────────────────────────────────
	//			%10.2f		소수점 이상 7자리, 소수점 이하 2자리. 왼쪽 빈자리 공백		___ 123.45
	//	실수		%-10.2f		소수점 이상 7자리, 소수점 이하 2자리, 오른쪽 빈자리 공백		123.45 ___
	//			%010.2f		소수점 이상 7자리, 소수점 이하 2자리 , 왼쪽 빈자리 0 채움		0000123.45
	//	────────────────────────────────────────────────────────────────────────────────────
	//			%s			문자열										abc
	//	문자열	%6s			6자리 문자열. 왼쪽 빈자리 공백						___ abc
	//			%-6s		6자리 문자열. 오른쪽 빈자리 공백						abc ___
	//	────────────────────────────────────────────────────────────────────────────────────
	//			%tF			%tY - %tm - %td								2020-02-23
	//			%tY			4자리 년										2020
	//			%tY			2자리 년										20
	//			%tm			2자리 월										02
	//	날짜		%td			2자리 일										23
	//			%tH			2자리 시 (0 ~ 23)								13
	//			%tI			시 (0 ~ 12)									1
	//			%tM			2자리 분										42
	//			%tS			2자리 초										55
	//	────────────────────────────────────────────────────────────────────────────────────
	//			/t			탭(tab)										
	//	특수		/n			줄바꿈								
	//	문자		%%			%											%
	//	────────────────────────────────────────────────────────────────────────────────────
	
	// 다음은 printf() 메소드를 사용해서 다양한 형식으로 출력하는 예제이다.
	
			//	Object InOutput Assistance Stream		객체 입출력 보조 스트림
	
	// 자바는 메모리에 생성된 객체를 파일 또는 네트워크로 출력할 수가 있다. 객체는 문자가 아니기 때문에 바이트 기반 스트림으로 출력해야 한다. 
	// 객체를 출력하기 위해서는 객체의 데이터(필드값)를 일렬로 늘어선 연속적인 바이트로 변경해야 하는데, 이것을 객체 직렬화(serialization)라고 한다.
	// 반대로 파일에 저장되어 있거나 네트워크에서 전송된 객체를 읽을 수도 있는데, 입력 스트림으로부터 읽어들인 연속적인 바이트를 객체로 복원하는 것을 역직렬화(deserialization)라고 한다.
	
			/*	ObjectInputStream And ObjectOutputStream	*/
	
	// 자바는 객체를 입출력할 수 있는 두 개의 보조 스트림인 ObjectInputStream과 ObjectOutputStream을 제공한다.
	// ObjectOutputStream은 바이트 출력 스트림과 연결되어 객체를 직렬화하는 역할을 하고, ObjectInputStream은 바이트 입력 스트림과 연결되어 객체로 역직렬화하는 역할을 한다.
	
	//											  	┌─────────────────┐
	//							  ┌───┐			  	│ 	프로그램		┌───┐
	//				┌─────────────│	  └─────────────┐	          	│	└──────────────┌─────────────┐
	//	   바이트	────→ InputStream │ ObjectInputStream ──→   객체	  ──→ DataOutputStream │ OutputStream ────→	바이트
	//				└─────────────│	  	역직렬화		│		┌┐		│		직렬화	   └─────────────┘
	//							  │	  ┌─────────────┘ 		└┘		│	┌──────────────┘
	//							  └───┘				└───────────────└───┘
	
	// ObjectInputStream과 ObjectOutputStream은 다른 보조 스트림과 마찬가지로 연결한 바이트 입출력 스트림을 생성자의 매개값으로 받는다.
	
	//	ObjectInputStream ois = new ObjectInputStream(바이트입력스트림);
	//	ObjectOutputStream oos = new ObjectOutputStream(바이트출력스트림);
	
	// ObjectOutputStream으로 객체를 직렬화하기 위해서는 writeObject() 메소드를 사용한다.
	
	//	oos.writeObject(객체);
	
	// 반대로 ObjectInputStream의 readObject() 메소드는 입력 스트림에서 읽은 바이트를 역직렬화해서 객체로 생성한다.
	// readObject() 메소드의 리턴 타입은 Object 타입이기 때문에 객체 원래의 타입으로 변환해야 한다.
	
	//	객체타입 변수 = (객체타입) ois.readObject();
	
	// 다음은 다양한 객체를 파일에 저장하고, 다시 파일로부터 읽어 객체로 복원하는 예제이다. 복수의 객체를 저장할 경우, 출력된 객체 순서와 동일한 순서로 객체를 읽어야 한다.
	
			/*	Class That Can Be Serialization(Serializable)		직렬화가 가능한 클래스(Serializable)	*/
	
	// 자바는 Serializable 인터페이스를 구현한 클래스만 직렬화할 수 있도록 제한하고 있다. Serializable 인터페이스는 필드나 메소드가 없는 빈 인터페이스지만, 
	// 객체를 직렬화할때 private 필드를 포함한 모든 필드를 바이트로 변환해도 좋다는 표시 역할을 한다.
	
	// public class XXX implements Serializable { }
	
	// 객체를 직렬화하면 바이트로 변환되는 것은 필드들이고, 생성자 및 메소드는 직렬화에 포함되지 않는다. 따라서 역직렬화할 때에는 필드의 값만 복원된다.
	// 하지만 모든 필드가 직렬화 대상이 되는 것은 아니다. 필드 선언에 static 또는 transient 붙어 있을 경우에는 직렬화가 되지 않는다.
	
	//	public class XXX implements Serializable {
	//		public int field1;	────────┐				일렬로 늘어선 바이트 데이터
	//		protected int field2;	────┤	직렬화	┌───────┬───────┬───────┬───────┐
	//		int field3;	────────────────┼─────────→	│field1	│field2	│field3	│field4	│
	//		private int field4;	────────┘			└───────┴───────┴───────┴───────┘
	//		public static int field5;	┐
	//		transient int field6;	────┴───→ static 또는 transient 키워드가 붙은 필드는 직렬화에서 제외
	
	// 다음은 직렬화되는 필드와 그렇지 못한 필드가 어떤 것이 있는지 확인해주는 예제이다.
	
	// 먼저 SerializableWriter 클래스를 실행하면 ClassA 객체를 직렬화해서 Object.dat 파일에 저장한다. 그리고 나서 SerializableReader 클래스를 실행하면 Object.dat 파일에 저장된 데이터를 읽고
	// ClassA 객체로 역직렬화 한다. 실행 결과를 보면 field1과 field2는 값이 복원되는 것을 알 수 있다. static 필드인 field3과 transient 필드인 field4는 값이 복원되지 않는다.
	// Object.dat 파일에는 field1과 field2의 데이터만 저장되어 있다.
	
			/*	serialVersionUID Field	*/
	
	// 직렬화된 객체를 역직렬화할 때는 직렬화했을 때와 같은 클래스를 사용해야 한다. 클래스의 이름이 같더라도 클래스의 내용이 변경되면, 역직렬화는 실패하여 다음과 같은 예외가 발생한다.
	
	//	java.io.InvalidClassException: XXX; local class incompatible: stream classdesc;
	// 	serialVersionUID = -913799490637378756, local class serialVersionUID = -1174725809595957294
	
	// 위의 내용은 직렬화할 때와 역직렬화할 때 사용된 클래스의 serialVersionUID가 다르다는 것이다. serialVersionUID는 같은 클래스임을 알려주는 식별자 역할을 하는데,
	// serializable 인터페이스를 구현한 클래스를 컴파일하면 자동적으로 serialVersionUID 정적 필드가 추가된다. 문제는 클래스를 재컴파일하면 serialVersionUID의 값이 달라진다는 것이다.
	// 네트워크로 객체를 직렬화하여 전송하는 경우, 보내는 쪽과 받는 쪽이 모두 같은 serialVersionUID를 갖는 클래스를 가지고 있어야 하는데
	// 한 쪽에서 클래스를 변경해서 재컴파일하면 다른 serialVersionUID를 가지게 되므로 역직렬화에 실패하게 된다.
	
	// 다음 예제는 직렬화할 때 사용했던 클래스를 재컴파일한 후 역직렬화하면 예외가 발생한다는 것을 보여준다.
	// 우선 ClassC 클래스를 다음과 같이 작성한다. ClassC 클래스를 작성할 때 serialVersionUID 필드를 선언하지 않았기 때문에 컴파일 시 자동으로 생성된다.
	// SerialVersionUIDExample1을 실행해서 객체를 파일에 저장한 후, SerialVersionUIDExample2를 실행하면 정상적으로 객체가 복원되는 것을 확인할 수 있다.
	
	// 예제를 실행 후 ClassC 클래스에 field2 필드를 추가하고 저장(컴파일)한다. field2가 추가 되었기 때문에 serialVersionUID 필드값이 변경된다.
	
	// 파일에 저장된 ClassC 객체를 복원하기 위해 SerialVersionUIDExample2를 실행하면 예외가 발생한다.
	
	// 만약 불가피하게 클래스의 수정이 필요하다면 클래스 작성 시 다음과 같이 servialVersionUID를 명시적으로 선언하면 된다.
	
	//	public class XXX implements Serializable {
	//		static final long serialVersionUID = 정수값;
	//		...
	//	}
	
	// 클래스에 serialVersionUID가 명시적으로 선언되어 있으면 컴파일 시에 serialVersionUID 필드가 추가되지 않기 때문에 동일한 serialVersionUID 값을 유지할 수 있다.
	// serialVersionUID의 값은 개발자가 임의로 줄 수 있지만 가능하다면 클래스마다 다른 값을 갖도록 하는 것이 좋다.
	// 그래서 자바는 <JDK 설치 경로>\bin 폴더에 serialVersionUID 값을 자동으로 생성시켜주는 serialver.exe 명령어를 제공하고 있다.
	// serialver.exe를 명령 프롬프트에서 실행시키는 방법은 다음과 같다.
	
	//	C:\Temp>dir
	//		C 드라이브의 볼륨: 운영 디스크				┌───────────────────────────────────────────────────────────────────┐
	//		볼륨 일련 번호: A449-4261					│	public class XXX implements Serializable {						│
	//											│		static final long serialVersionUID = 5835806237290266999L;	│
	//		C:\Temp 디렉터리						│	}													↑			│
	//											└───────────────┬───────────────────────────────────────┼───────────┘
	//	2020-02-23	오후 09:26	<DIR>		.					│										│
	//	2020-02-23	오후 09:26	<DIR>		..					│										│
	//	2020-02-23	오후 09:26				208 XXX.class		│										│
	//	2020-02-23	오후 09:26				 67 XXX.java	────┘										│ 복사해서 클래스의 필드로 만든다.
	//					2개 파일					275 바이트													│
	//					2개 디렉터리	84,131,876,864 바이트 남음												│
	//															┌───────────────────────────────────────┘
	//	C:\Temp>serialver XXX									│
	//	XXX:	static final long serialVersionUID = 5835806237290266999L;
	
			/*	writeObject() And readObject() Method	*/
	
	// 두 클래스가 상속 관계에 있다고 가정해보자. 부모 클래스가 Serializable 인터페이스를 구현하고 있으면 자식 클래스는 Serializable 인터페이스를 구현하지 않아도
	// 자식 객체를 직렬화하면 부모 필드 및 자식 필드가 모두 직렬화된다. 하지만 그 반대로 부모 클래스가 Serializable 인터페이스를 구현하고 있지 않고,
	// 자식 클래스만 Serializable 인터페이스를 구현하고 있다면 자식 객체를 직렬화할 때 부모의 필드는 직렬화에서 제외된다. 이 경우 부모 클래스의 필드를 직렬화하고 싶다면 다음 두 가지 방법 중 하나를 선택해야 한다.
	
	//	- 부모 클래스가 Serializable 인터페이스를 구현하도록 한다.
	//	- 자식 클래스에서 writeObject()와 readObject() 메소드를 선언해서 부모 객체의 필드를 직접 출력시킨다.
	
	// 첫 번째 방법이 제일 좋은 방법이 되겠지만, 부모 클래스의 소스를 수정할 수 없는 경우에는 두 번째 방법을 사용해야 한다.
	// writeObject() 메소드는 직렬화될 때 자동으로 호출되고, readObject() 메소드는 역직렬화할 때 자동적으로 호출된다.
	// writeObject()와 readObject() 메소드의 선언 방법을 보여준다.
	
	//	private void writeObject(ObjectOutputStream out) throws IOException {
	//		out.writeXXX(부모필드);	┬ 부모 객체의 필드값을 출력함
	//			:				────┘
	//		out.defaultWriteObject();	────────→ 자식 객체의 필드값을 직렬화
	//	}
	
	//	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	//		부모필드 = in.readXXX();	┬ 부모 객체의 필드값을 읽어옴
	//			:				────┘
	//		in.defaultReadObject();		────→ 자식 객체의 필드값을 역직렬화
	//	}
	
	// 두 메소드를 작성할 때 주의할 점은 접근 제한자가 private가 아니면 자동 호출되지 않기 때문에 반드시 private를 붙여주어야 한다.
	// writeObject()와 readObject() 메소드의 매개값인 ObjectOutputStream과 ObjectInputStream은 다양한 종류의 writeXXX(), readXXX() 메소드를 제공하므로
	// 부모 필드 타입에 맞는 것을 선택해서 사용하면 된다. defaultWriteObject()와 defaultReadObject()는 자식 클래스에 정의된 필드들을 모두 직렬화하고 역직렬화한다.
}
