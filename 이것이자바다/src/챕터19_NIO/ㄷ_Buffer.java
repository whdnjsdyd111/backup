package 챕터19_NIO;

public class ㄷ_Buffer {
	// NIO에서는 데이터를 입출력하기 위해 항상 버퍼를 사용해야 한다. 버퍼는 읽고 쓰기가 가능한 메모리 배열이다.
	// 버퍼를 이해하고 잘 사용할 수 있어야 NIO에서 제공하는 API를 올바르게 활용할 수 있다.
	
	//		┌───────────────────────────┐		┌───────────────┐
	//		│프로그램						│		│				│
	//		│							│		│				│
	//		│					┌───┐	│  채널	│				│
	//		│		입력 데이터	←───│버	│───────────│ 1. 파일			│
	//		│					│	│←─────────→│ 2. 네트워크		│
	//		│					│퍼	│			│				│
	//		│		출력 데이터	───→│	│───────────│				│
	//		│					└───┘	│		│				│
	//		│							│		│				│
	//		└───────────────────────────┘		└───────────────┘
	
			//	kind Of Buffer		Buffer의 종류
	
	// Buffer는 저장되는 데이터 타입에 따라 분류될 수 있고, 어떤 메모리를 사용하느냐에 따라 다이렉트(Direct)와 넌다이렉트(NonDirect)로 분류될 수 있다.
	
			/*	Buffer That Follow Data		데이터에 따른 버퍼		*/
	
	// NIO 버퍼는 저장되는 데이터 타입에 따라서 별도의 클래스로 제공한다. 이 버퍼 클래스들은 Buffer 추상 클래스를 모두 상속하고 있다.
	
	//							Buffer
	//								↑
	//			┌───────────┬───────┴───────────┐
	//		ByteBuffer		├──	CharBuffer		├──	FloatBuffer
	//			↑			├──	ShortBuffer		└──	DoubleBuffer
	//			│			├──	IntBuffer
	//		MappedByteBuffer└──	LongBuffer
	
	// 버퍼 클래스의 이름을 보면 어떤 데이터가 저장되는 버퍼인지 쉽게 알 수 있다. ByteBuffer는 byte 데이터가 저장되고, CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer,
	// DoubleBuffer는 각각 char, short, int, long, float, double 데이터가 저장되는 버퍼이다.
	// MappedByteBuffer는 ByteBuffer의 하위 클래스로 파일의 내용에 랜덤하게 접근하기 위해 파일의 내용을 메모리와 맵핑시킨 버퍼이다.
	
			/*	NonDirect And Direct Buffer	*/
	
	// 버퍼가 사용하는 메모리의 위치에 따라서 넌다이렉트(non-direct) 버퍼와 다이렉트(direct) 버퍼로 분류된다. 넌다이렉트 버퍼는 JVM이 관리하는 힙 메모리 공간을 이요하는 버퍼이고,
	// 다이렉트 버퍼는 운영체제가 관리하는 메모리 공간을 이용하는 버퍼이다. 두 버퍼의 특징은 다음과 같다.
	
	//	구성					넌다이렉트 버퍼			다이렉트 버퍼
	//
	//	사용하는 메모리 공간		JVM의 힙 메모리			운영체제의 메모리
	//	버퍼 생성 기간			버퍼 생성이 빠르다.		버퍼 생성이 느리다.
	//	버퍼의 크기				작다.					크다.(큰 데이터를 처리할 때 유리)
	//	입출력 성능				낮다.					높다.(입출력이 빈번할 때 유리)
	
	// 넌다이렉트 버퍼는 JVM 힙 메모리를 사용하므로 버퍼 생성 시간이 빠르지만, 다이렉트 버퍼는 운영체제의 메모리를 할당받기 위해 운영체제의 네이티브(native) C 함수를 호출해야 하고
	// 여러 가지 잡다한 처리를 해야 하므로 상대적으로 버퍼 생성이 느리다. 그렇기 때문에 다이렉트 버퍼는 자주 생성하기 보다는 한 번 생성해 놓고 재사용하는 것이 적합하다.
	// 넌다이렉트 버퍼는 JVM의 제한된 힙 메모리를 사용하므로 버퍼의 크기를 크게 잡을 수 없고, 반면 다이렉트 버퍼는 운영체제가 관리하는 메모리를 사용하므로 운영체제가 허용하는 범위 내에서 대용량 버퍼를 생성시킬 수 있다.
	// 넌다이렉트 버퍼는 입출력을 하기 위해 임시 다이렉트 버퍼를 생성하고 넌다이렉트 버퍼에 있는 애용을 임시 다이렉트 버퍼에 복하한다. 그리고 나서 임시 다이렉트 버퍼를 사용해서 운영체제의 native I/O 기능을 수행한다.
	// 그렇기 때문에 직접 다이렉트 버퍼를 사용하는 것보다는 입출력 성능이 낮다.
	
	// 다음 예제는 컴퓨터에서 200MB 크기의 버퍼를 생성하려고 했는데, 다이렉트 버퍼는 정상적으로 생성되는 반면, 넌다이렉트 버퍼는 OutOfMemoryError가 발생한다.
	// 컴퓨터의 성능과 현재 상태에 따라서 버퍼의 크기가 유동적이기 때문에 크기를 조정하면서 테스트 해보길 바란다.
	// 예제에서 사용된 버퍼는 ByteBuffer이고, allocate() 메소드는 넌다이렉트 버퍼를 생성하는 메소드이다.
	// 그리고 allocateDirect() 메소드는 다이렉트 버퍼를 생성하는 메소드이다. 이 메소드들에 대한 자세한 내용은 곧 설명하도록 한다.
	
	// 다음 예제는 넌다이렉트 버퍼와 다이렉트 버퍼의 성능 테스트 결과를 출력한다. 이미지 파일을 100번 복사하는데 걸린 시간을 측정해본 결과 다이렉트 버퍼가 훨씬 빠른 것을 볼 수 있다.
	// 아직은 예제 코드가 이해되지 않을 수 있다. 여기서는 다이렉트 버퍼의 반복적 입출력 성능이 빠르다는 것만 이해해두고 넘어가자.
	
			//	Creation Buffer		Buffer 생성
	
	// 각 데이터 타입별로 넌다이렉트 버퍼를 생성하기 위해서는 각 Buffer 클래스의 allocate()와 wrap() 메소드를 호출하면 되고, 다이렉트 버퍼는 ByteBuffer의 allocateDirect() 호출하면 된다.
	
			/*	allocate() Method	*/
	
	// allocate() 메소드는 JVM 힙 메모리에 넌다이렉트 버퍼를 생성한다. 다음은 데이터 타입별로 Buffer를 생성하는 allocate() 메소드이다. 매개값은 해당 데이터 타입의 저장 개수를 말한다.
	
	//	리턴 타입			메소드(매개 변수)								설명
	//
	//	ByteBuffer		ByteBuffer.allocate(int capacity)		capacity개만큼의 byte 값을 저장
	//	CharBuffer		CharBuffer.allocate(int capacity)		capacity개만큼의 char 값을 저장
	//	DoubleBuffer	DoubleBuffer.allocate(int capacity)		capacity개만큼의 double 값을 저장
	//	FloatBuffer		FloatBuffer.allocate(int capacity)		capacity개만큼의 float 값을 저장
	//	IntBuffer		IntBuffer.allocate(int capacity)		capacity개만큼의 int 값을 저장
	//	LongBuffer		LongBuffer.allocate(int capacity)		capacity개만큼의 long 값을 저장
	//	ShortBuffer		ShortBuffer.allocate(int capacity)		capacity개만큼의 short 값을 저장
	
	// 다음은 최대 100개의 바이트를 저장하는 ByteBuffer를 생성하고, 최대 100개의 문자를 저장하는 CharBuffer를 생성하는 코드이다.
	
	//	ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	//	CharBuffer charBuffer = CharBuffer.allocate(100);
	
			/*	wrap() Method	*/
	
	// 각 타입별로 Buffer 클래스는 모두 wrap() 메소드를 가지고 있는데, wrap() 메소드는 이미 생성되어 있는 자바 배열을 래핑해서 Buffer 객체를 생성한다.
	// 자바 배열은 JVM 힙 메모리에 생성되므로 wrap()은 넌다이렉트 버퍼를 생성한다. 다음은 길이가 100인 byte[]를 이용해서 ByteBuffer를 생성하고, 길이가 100인 char[]를 이용해서 CharBuffer를 생성한다.
	
	//	byte[] byteArr = new byte[100];
	//	ByteBuffer byteBuffer = ByteBuffer.wrap(byteArr);
	//	char[] charArr = new char[100];
	//	CharBuffer charBuffer = CharBuffer.wrap(charArr);
	
	// 배열의 모든 데이터가 아니라 일부 데이터만 가지고 Buffer 객체를 생성할 수도 있다. 이 경우 시작 인덱스와 길이를 추가적으로 지정하면 된다.
	// 다음은 0 인덱스부터 50개만 버퍼로 생성한다.
	
	//	byte[] byteArray = new byte[100];
	//	ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray, 0, 50);
	//	char[] charArray = new char[100];
	//	CharBuffer charBuffer = CharBuffer.wrap(charArray, 0, 50);
	
	// CharBuffer는 추가적으로 CharSequence 타입의 매개값을 갖는 wrap() 메소드도 제공한다.
	// String이 CharSequence 인터페이스를 구현했기 때문에 매개값으로 문자열을 제공해서 다음과 같이 CharBuffer를 생성할 수 있다.
	
	//	CharBuffer charBuffer  = CharBuffer.wrap( "NIO 입추력은 버퍼를 이용합니다" );
	
			/*	allocateDirect() Method	*/
	
	// ByteBuffer의 allocateDirect() 메소드는 JVM 힙 메모리 바깥쪽, 즉 운영체제가 관리하는 메모리에 다이렉트 버퍼를 생성한다. 이 메소드는 각 타입별 Buffer 클래스에는 없고, ByteBuffer에서만 제공된다.
	// 각 타입별로 다이렉트 버퍼를 생성하고 싶다면 우선 ByteBuffer의 allocateDirect() 메소드로 버퍼를 생성한 다음 ByteBuffer의 asCharBuffer(), asShortBuffer(), asIntBuffer(),
	// asLongBuffer(), asFloatBuffer(), asDoubleBuffer() 메소드를 이용해서 해당 타입별 Buffer를 얻으면 된다.
	
	// 다음은 100개의 바이트(byte)를 저장하는 다이렉트 ByteBuffer와 50개의 문자(char)를 저장하는 다이렉트 CharBuffer, 25개의 정수(int)를 저장하는 다이렉트 IntBuffer를 생성하는 코드이다.
	// char는 2바이트 크기를 가지고, int는 4바이트 크기를 가지기 때문에 초기 다이렉트 ByteBuffer 생성 크기에 따라 저장 용량이 결정된다.
	
	//	// 100개의 byte값 저장
	//	ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
	//	// 50개의 char값 저장
	//	CharBuffer charBuffer = ByteBuffer.allocateDirect(100).asCharBuffer();
	//	// 25개의 int값 저장
	//	IntBuffer intBuffer = ByteBuffer.allocateDirect(100).asIntBuffer();
	
			/*	ByteOrder	*/
	
	// 데이터를 처리할 때 바이트 처리 순서는 운영 체제마다 차이가 있다. 이러한 차이는 데이터를 다른 운영체제로 보내거나 받을 때 영향을 미치기 때문에 데이터를 다루는 버퍼도 이를 고려해야 한다.
	// 앞쪽 바이트부터 먼저 처리하는 것을 Big endian이라고 하고, 뒤쪽 바이트부터 먼저 처리하는 것을 Little endian이라고 한다.
	
	//							Resister					Resister
	//		Memory			┌───────────────┐			┌───────────────┐			Memory	
	//		│...│			│  OA OB OC OD	│			│  OA OB OC OD	│			│...│
	//		├───┤			└───────────────┘			└───────────────┘			├───┤
	//	  α	│OA	│←──────────────┘  │  │  │					│  │  │  └──────→	α	│OD	│
	//		├───┤				   │  │  │					│  │  │  				├───┤
	// α + 1│OB	│←─────────────────┘  │  │					│  │  └─────────→ α + 1 │OC	│
	//		├───┤					  │  │					│  │    				├───┤
	// α + 2│OC	│←────────────────────┘  │					│  └────────────→ α + 2 │OB	│
	//		├───┤ 						 │					│  						├───┤  
	// α + 3│OD	│←───────────────────────┘					└───────────────→ α + 3 │OA	│
	//		├───┤																	├───┤
	//		│...│																	│	│
	//					Big-endian								Little-endian
	
	// Little endian으로 동작하는 운영체제에서 만든 데이터 파일을 Big endian으로 동작하는 운영체제에서 읽는다면 ByteOrder 클래스로 데이터 순서를 맞춰야 한다.
	// ByteOrder 클래스의 nativeOrder() 메소드는 현재 동작하고 있는 운영체제가 Big endian인지 Little endian인지 알려준다.
	// JVM도 일종의 독립된 운영체제이기 때문에 이런 문제를 취급하는데, JRE가 설치된 어떤 환경이든 JVM은 무조건 Big endian으로 동작하도록 되어 있다.
	// 다음 예제는 현재 컴퓨터의 운영체제와 바이트를 해석하는 순서에 대해 출력한다.
	
	// 운영체제와 JVM의 바이트 해석 순서가 다를 경우에는 JVM이 운영체제와 데이터를 교환할 때 자동적으로 처리해주기 때문에 문제는 없다.
	// 하지만 다이렉트 버퍼일 경우 운영체제의 native I/O를 사용하므로 운영체제의 기본 해석 순서로 JVM의 해석 순서를 맞추는 것이 성능에 도움이 된다.
	// 다음과 같이 allocateDirect()로 버퍼를 생성한 후, order() 메소드를 호출해서 nativeOrder()의 리턴값으로 세팅해주면 된다.
	
	//	ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100).order(ByteOrder.nativeOrder());
	
			//	Position Properties Of Buffer	Buffer의 위치 속성
	
	// Buffer를 생성하는 방법을 알았으니 이제는 사용하는 방법을 알아보자. Buffer를 사용하려면 먼저 Buffer의 위치 속성 개념과 위치 속성이 언제 변경되는지 알고 있어야 한다.
	// 다음은 Buffer의 네 가지 위치 속성을 정리한 것이다.
	
	//	속성			설명
	//
	//	position	현재 읽거나 쓰는 위치값이다. 인덱스 값이기 때문에 0부터 시작하며, limit보다 큰값을 가질 수 없다.
	//				만약 position과 limit의 값이 같아진다면 더 이상 데이터를 쓰거나 읽을 수 없다는 뜻이 된다.
	//
	//	limit		버퍼에서 읽거나 쓸 수 있는 위치의 한계를 나타낸다. 이 값은 capacity보다 작거나 같은 값을 가진다.
	//				최초에 버퍼를 만들었을 때는 capacity와 같은 값을 가진다.
	//
	//	capacity	버퍼의 최대 데이터 개수(메모리 크기)를 나타낸다. 인덱스 값이 아니라 수량임을 주의하자.
	//
	//	mark		reset() 메소드를 실행했을 때에 돌아오는 위치를 지정하는 인덱스로서 mark() 메소드로 지정할 수 있다.
	//				주의할 점은 반드시 position 이하의 값으로 지정해주어야 한다. position이나 limit의 값이 mark 값보다 작은 경우, mark는 자동 제거된다.
	//				mark가 없는 상태에서 reset() 메소드를 호출하면 InvalidMarkException이 발생한다.
	
	// position, limit, capacity, mark 속성의 크기 관계는 다음과 같다. mark는 position보다 클 수 없고, position은 limit보다 클 수 없으며, limit은 capacity보다 클 수 없다.
	
	//	0	≤	mark	≤	position	≤	limit	≤	capacity
	
	// 예를 들어 다음과 같이 7바이트 크기의 버퍼가 있다고 가정해보자. 처음에는 limit과 capacity가 모두 7이라는 값을 가지고 있고 position은 0을 가지고 있다.
	// 버퍼의 크기가 7이므로 인덱스는 6까지이다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│	│	│	│	│	│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//				  ↑							  ↑
	//				  │							  │
	//			   position						limit
	
	// 먼저 2바이트를 버퍼에 저장해보자. 2바이트는 position이 위치한 0 인덱스에서 시작해서 버퍼에 저장된다.
	// 따라서 다음과 같이 처음 2바이트는 채워지고 position은 2번 인덱스가 된다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│///│///│	│	│	│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//						  ↑					  ↑
	//						  │					  │
	//					   position				limit
	
	// 계속해서 3바이트를 저장해보자. 3바이트는 position 2 인덱스에서 시작해서 버퍼에 저장된다.
	// 따라서 다음과 같이 5바이트가 채워지고 position은 5번 인덱스가 된다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│///│///│///│///│///│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//									  ↑		  ↑
	//									  │		  │
	//								   position	limit
	
	// 이제 버퍼에 저장되어 있는 바이트를 읽어보자. 먼저 flip() 메소드를 호출해야 한다. flip() 메소드를 호출하면 limit을 현재 position 5 인덱스로 설정하고, position을 0번 인덱스로 설정한다.
	// 따라서 다음과 같이 된다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│///│///│///│///│///│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//				  ↑	↖────────────────────   ↑	↖──────┘
	//				  │		   flip()	  │	  flip()
	//			   position				limit
	
	// 버퍼에서 3바이트를 읽는다고 가정해보자. position이 0번 인덱스이므로 처음 3바이트가 읽혀지고 position은 다음과 같이 3번 인덱스로 이동한다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│XXX│XXX│XXX│///│///│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//							  ↑		  ↑
	//							  │		  │
	//						  position	limit
	
	// position이 3번 인덱스를 가리키고 있을 때 mark() 메소드를 호출해서 현재 위치를 기억시켜 놓는다. 따라서 mark는 3번 인덱스에 위치한다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│XXX│XXX│XXX│///│///│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//							 ↑ ↑	  ↑
	//							 │ │	limit
	//							 │ position	
	//							mark
	
	// 이어서 2 바이트를 더 읽어보자. 다음과 같이 position은 5번 인덱스로 이동한다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│XXX│XXX│XXX│XXX│XXX│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//							  ↑		 ↑ ↑
	//							  │		 │ │
	//							mark	 │ limit
	//			 					  position
	
	// 이번에는 position을 mark 위치로 다시 이동해야 한다고 가정해보자. reset() 메소드를 호출하면 position은 mark가 있는 3번 인덱스로 이동한다.
	// 주의할 점은 mark가 없는 상태에서 reset() 메소드를 호출하면 InvalidMarkException 예외가 발생한다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│XXX│XXX│XXX│///│///│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//							 ↑ ↑	  ↑
	//							 │ │	limit
	//							 │ position	
	//							mark
	
	// 이번에는 버퍼를 되감아 동일한 데이터를 한 번 더 읽고 싶다고 가정해보자. rewind() 메소드를 호출하면 limit은 변하지 않지만 position은 0번 인덱스로 다시 설정된다.
	// mark는 position이나 limit이 mark보다 작은 값으로 조정되면 자동적으로 없어진다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│///│///│///│///│///│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//				  ↑	↖───────────────────	  ↑
	//				  │		rewind()	  │
	//			  position				limit
	
	// 만약 rewind() 대신 clear() 메소드를 호출하면 Buffer의 세 가지 속성은 초기화된다. limit은 capacity로, position은 0으로 설정되고 mark는 자동적으로 없어진다.
	// 하지만 데이터는 삭제되지 않는다.
	
	//										   capacity
	//											  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│///│///│///│///│///│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘
	//				  ↑	↖─────────────────────┘└──────↗   ↑
	//				  │				   clear()	  │
	//			  position						limit
	
	// 버퍼의 위치 속성을 변경하는 또 다른 메소드로 compact()가 있다. compact()를 호출하면 현재 position에서 limit 사이의 데이터가 0번 인덱스로 복사되고 현재 position은 복사된 데이터 다음 위치로 이동한다.
	// 예를 들어 flip() 메소드 호출 후 세 개의 데이터를 읽고 다음과 같이 position이 3번 인덱스 위치에 있을 때 compact()가 호출되면 3번 인덱스와 4번 인덱스의 데이터는 0번 인덱스와 1번 인덱스로 복사되고
	// position은 2번 인덱스로 이동한다. 그리고 limit은 capacity로 이동한다. 주의할 점은 0번과 1번 인덱스를 제외한 나머지 인덱스의 데이터는 삭제되지 않고 남아있다.
	
	//										   capacity													   capacity
	//											  │															  │
	//		인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓						인덱스	  0	  1	  2	  3	  4	  5	  6	  ↓
	//				┌───┬───┬───┬───┬───┬───┬───┬---┐							┌───┬───┬───┬───┬───┬───┬───┬---┐
	//		Buffer	│XXX│XXX│XXX│///│///│	│	ː	ː	────→			Buffer	│///│///│	│	│	│	│	ː	ː
	//				└───┴───┴───┴───┴───┴───┴───┴---┘ 	compact()				└───┴───┴───┴───┴───┴───┴───┴---┘ 
	//				  a	  b	  c	  d	  e											  d	  e	  c	  d	  e
	//							  ↑		  ↑												  ↑					  ↑
	//							  │		  │												  │					  │
	//						   position	limit										  position				limit
	
	// compact()를 호출하는 이유는 읽지 않은 데이터 뒤에 새로운 데이터를 저장하기 위해서이다.
	
			//	Buffer Method
	
	// Buffer를 생성한 후 사용할 때에는  Buffer가 제공하는 메소드를 잘 활용해야 한다.
	// Buffer마다 공통적으로 사용하는 메소드들도 있고, 데이터 타입멸로 Buffer가 개별적으로 가지고 있는 메소드들도 있다.
	
			/*	Common Method	*/
	
	// 각 타입별 버퍼 클래스는 Buffer 추상 클래스를 상속하고 있다. Buffer 추상 클래스에는 모든 버퍼가 공통적으로 가져야 할 메소드들이 정의되어 있는데, 
	// 위치 속성을 변경하는 flip(), rewind(), clear(), mark(), reset()도 모두 Buffer 추상 클래스에 있다.
	// 다음은 Buffer 추상 클래스가 가지고 있는 메소드들을 정리한 표이다.
	
	//	리턴 타입		메소드(매개 변수)					설명
	//
	//	Object		array()						버퍼가 래핑(wrap)한 배열을 리턴
	//	int			arrayOffset()				버퍼의 첫 번째 요소가 있는 내부 배열의 인덱스를 리턴
	//	int			capacity()					버퍼의 전체 크기를 리턴
	//	Buffer		clear()						버퍼의 위치 속성을 초기화(position = 0, limit = capacity)
	//	Buffer		flip()						limit을 position으로, position을 0 인덱스로 이동
	//	boolean		hasArray()					버퍼가 래핑(wrap)한 배열을 가지고 있는지 여부
	//	boolean		hasRemaining()				position과 limit 사이에 요소가 있는지 여부 (position < limit)
	//	boolean		isDrect()					운영체제의 버퍼를 사용하는지 여부
	//	boolean		isReadOnly()				버퍼가 읽기 전용인지 여부
	//	int			limit()						limit 위치를 리턴
	//	Buffer		limit(int newLimit)			newLimit으로 limit 위치를 설정
	//	Buffer		mark()						현재 위치를 mark로 표시
	//	int			position()					position 위치를 리턴
	//	Buffer		position(int newPosition)	newPosition으로 position 위치를 설정
	//	int			remaining()					position과 limit 사이의 요소의 개수
	//	Buffer		reset()						position을 mark 위치로 이동
	//	Buffer		rewind()					position을 0 인덱스로 이동
	
			/*	Method For Reading And Storing Data		데이터를 읽고 저장하는 메소드		*/
	
	// 버퍼에 데이터를 저장하는 메소드는 put()이고, 데이터를 읽는 메소드는 get()이다. 이 메소드들은 Buffer 추상 클래스에는 없고, 각 타입별 하위 Buffer 클래스가 가지고 있다.
	// get()과 put() 메소드는 상대적(Relative)과 절대적(Absolute)으로 구분된다. 버퍼 내의 현재 위치 속성인 position에서 데이터를 읽고, 저장하는 경우는 상대적이고,
	// position과 상관없이 주어진 인덱스에서 데이터를 읽고, 저장할 경우는 절대적이다. 상대적 get()과 put() 메소드를 호출하면 position의 값은 증가하지만, 
	// 절대적 get()과 put() 메소드를 호출하면 position의 값은 증가되지 않는다. 만약 position 값이 limit 값까지 증가했는데도 상대적 get()을 사용하면 BufferUnderflowException 예외가 발생하고,
	// put() 메소드를 사용하면 BufferOverflowException이 발생한다.
	
	// 다음은 ByteBuffer와 CharBuffer에서 제공하는 get() 메소드와 put() 메소드를 나열한 표이다.
	// ShortBuffer, IntBuffer, LongBuffer, FloatBuffer, DoubleBuffer들도 데이터 타입만 다를 뿐 비슷한 메소드를 가지고 있다.
	
	//		 구분		│	ByteBuffer									│	CharBuffer
	//				│												│
	//		  │		│	get()										│
	//		  │		│	get(byte[] dst)								│	get()
	//		  │		│	get(byte[] dst, int offset, int length)		│	get(char[] dst)
	//		  │		│	getChar()									│	get(char[] dst, int offset, int length)
	//		  │상대적	│	getDouble()									│
	//		  │		│	getFloat()									│
	//		  │		│	getInt()									│
	//		  │		│	getLong()									│
	//	get() │		│	getShort()									│
	//		  ─────────────────────────────────────────────────────────────────────────────────────────────────
	//		  │		│	get(int index)								│
	//		  │		│	getChar(int index)							│
	//		  │		│	getDouble(int index)						│
	//		  │절대적	│	getFloat(int index)							│	get(int index)
	//		  │		│	getInt(int index)							│
	//		  │		│	getLong(int index)							│
	//		  │		│	getShort(int index)							│
	//	───────────────────────────────────────────────────────────────────────────────────────────────────────
	//		  │		│	put(byte b)									│
	//		  │		│	put(byte[] b)								│
	//		  │		│	put(byte[] src, int offset, int length)		│	put(char c)
	//		  │		│	put(ByteBuffer src)							│	put(char[] c)
	//		  │		│	putChar(char value)							│	put(char[] src, int offset, int length)
	//		 │상대적	│	putDouble(double value)						│	put(CharBuffer src)
	//		  │		│	putFloat(float value)						│	put(String src)
	//		  │		│	putInt(int value)							│	put(String src, int start, int end)
	//		  │		│	putLong(long value)							│
	//	put() │		│	putShort(short value)						│
	//		  ─────────────────────────────────────────────────────────────────────────────────────────────────
	//		  │		│	put(int index, byte b)						│
	//		  │		│	putChar(int index, char value)				│
	//		  │		│	putDouble(int index, double value)			│
	//		  │		│	putFloat(int index, float value)			│	put(int index, char c)
	//		  │		│	putInt(int index, int value)				│
	//		  │		│	putLong(int index, long value)				│
	//		  │		│	putShort(int index, short value)			│
	//		  │		│
	//		  │		│
	
	// 상대적 메소드와 절대적 메소드를 쉽게 구분하는 방법은 index 매개 변수가 없으면 상대적이고, index 매개 변수가 있으면 절대적이다.
	
			/*	Kind Of Buffer Exception		버퍼 예외의 종류	*/

	// 버퍼 클래스에서 발생하는 예외를 살펴보자. 주로 버퍼가 다 찼을 때 데이터를 저장하려는 경우와 버퍼에서 더 이상 읽어올 데이터가 없을 때 데이터를 읽으려는 경우에 예외가 발생한다.
	// 다음 표는 버퍼와 관련된 예외 클래스이다. 이 중에서 가장 흔하게 발생하는 예외는 BufferOverflowException과 BufferUnderflowException이다.
	
	//	예외							설명
	//
	//	BufferOverflowException		position이 limit에 도달했을 때 put()을 호출하면 발생
	//	BufferUnderflowException	position이 limit에 도달했을 때 get()를 호출하면 발생
	//	InvalidMarkException		mark가 없는 상태에서 reset() 메소드를 호출하면 발생
	//	ReadOnlyBufferException		읽기 전용 버퍼에서 put() 또는 compact() 메소드를 호출하면 발생
	
	// 다음 예제는 데이터를 버퍼에 쓰고, 읽을 때, 그리고 위치 속성을 변경하는 메소드를 호출할 대 버퍼의 위치 속성값의 변화를 보여준다.
	
	// 다음 예제는 compact() 메소드를 호출 후, 변경된 버퍼의 내용과 position, limit의 위치를 보여준다.
	
			//	Buffer Change	Buffer 변환
	
	// 채널이 데이터를 읽고 쓰는 버퍼는 모두 ByteBuffer이다. 그렇기 때문에 채널을 통해 읽은 데이터를 복원하려면 ByteBuffer를 문자열 또는 다른 타입 버퍼(CharBuffer, ShortBuffer, IntBuffer,
	// LongBuffer, FloatBuffer, DoubleBuffer)로 변환해야 한다. 반대로 문자열 또는 다른 타입 버퍼의 내용을 채널을 통해 쓰고 싶다면 ByteBuffer로 변환해야 한다.
	
			/*	ByteBuffer <-> String	*/
	
	// 프로그램에서 가장 많이 처리되는 데이터는 String 타입, 즉 문자열이다. 채널을 통해 문자열을 파일이나 네트워크로 전송하려면 특정 문자셋(UTF-8, EUC-KR)으로 인코딩해서 ByteBuffer로 변환해야 한다.
	// 먼저 문자셋을 표현하는 java.nio.charset.Charset 객체가 필요한데, 다음 두 가지 방법으로 얻을 수 있다.
	
	//	Charset charset = Charset.forName("UTF-8");		// 매개값으로 주어진 문자셋
	//	Charset charset = Charset.defaultCharset();		// 운영체제가 사용하는 디폴트 문자셋
	
	// Charset을 이용해서 문자열을 ByteBuffer로 변환하려면 다음과 같이 encode() 메소드를 호출하면 된다.
	
	//	String data = ...;
	//	ByteBuffer byteBuffer = charset.encode(data);
	
	// 반대로 파일이나 네트워크로부터 읽은 ByteBuffer가 특정 문자셋(UTF-8, EUC-KR)으로 인코딩되어 있을 경우, 해당 문자셋으로 디코딩해야만 문자열로 복원할 수 있다.
	// Charset은 ByteBuffer를 디코딩해서 CharBuffer로 변환시키는 decode() 메소드를 제공하고 있기 때문에 다음과 같이 문자열로 쉽게 복원할 수 있다.
	
	//	ByteBuffer byteBuffer = ...;
	//	String data = charset.decode(byteBuffer).toString();
	
	// 다음 예제는 문자열을 UTF-8로 인코딩해서 얻은 ByteBuffer를 다시 UTF-8로 디코딩해서 문자열로 복원한다.
	
			/*	ByteBuffer <-> IntBuffer	*/
	
	// int[] 배열을 생성하고 이것을 파일이나 네트워크로 출력하기 위해서는 int[] 배열 또는 IntBuffer로부터 ByteBuffer를 생성해야 한다.
	// int 타입은 4byte 크기를 가지므로 int[] 배열 크기 또는 IntBuffer의 capacity보다 4배 큰 capacity를 가진 ByteBuffer를 생성하고, 
	// ByteBuffer의 putInt() 메소드로 정수값을 하나씩 저장하면 된다. 다음은 int[] 배열을 IntBuffer로 래핑하고(꼭 IntBuffer로 래핑할 필요는 없다), 4배 큰 ByteBuffer를 생성한 후 정수값을 저장한다.
	// 주목할 점은 putInt() 메소드는 position을 이동시키기 때문에 모두 저장한 후에는 position을 0으로 되돌려 놓는 flip() 메소드를 호출해야 한다.
	
	//	int[] data = new int[] { 10, 20 };
	//	IntBuffer intBuffer = IntBuffer.wrap(data);
	//	ByteBuffer byteBuffer = ByteBuffer.allocate(intBuffer.capacity*4);
	//	for(int i = 0; i < intBuffer.capacity(); i++) {
	//		byteBuffer.putInt(intBuffer.get(i));
	//	}
	//	byteBuffer.flip();
	
	// 반대로 파일이나 네트워크로부터 입력된 ByteBuffer에 4바이트씩 연속된 int 데이터가 저장되어 있을 경우, int[] 배열로 복원이 가능하다. ByteBuffer의 asIntBuffer() 메소드로 IntBuffer를 얻고,
	// IntBuffer의 capacity와 동일한 크기의 int[] 배열을 생성한다. 그리고 IntBuffer의 get() 메소드로 int 값들을 배열에 저장하면 된다.
	
	//	ByteBuffer byteBuffer = ...;
	//	IntBuffer intBuffer = byteBuffer.asIntBuffer();
	//	int[] data = new int[intBuffer.capacity()];
	//	intBuffer.get(data);
	
	// 참고로 ByteBuffer에서 asIntBuffer()로 얻은 IntBuffer에서는 arrray() 메소드를 사용해서 int[] 배열을 얻을 수 없다.
	// array() 메소드는 래핑한 배열만 리턴하기 때문에 int[] 배열을 wrap() 메소드로 래핑한 IntBuffer에서만 사용할 수 있음을 기억하길 바란다.
	// 다음 예제는 int[] 배열로부터 얻은 ByteBuffer를 이용해서 다시 int[] 배열로 복원한다.
	
	// ByteBuffer와 IntBuffer 간의 변환을 이해하면 ByteBuffer와 ShortBuffer, LongBuffer, FloatBuffer, DoubleBuffer 간의 변환도  비슷한 방법으로 하면 된다.
	// 다음은 ByteBuffer가 가지고 있는 기본 타입 버퍼로 변환하는 asXXXBuffer() 메소드들이다.
	
	//	리턴 타입			변환 메소드				설명
	//
	//	ShortBuffer		asShortBuffer		2바이트씩 연속된 short 데이터를 가진 ByteBuffer일 경우
	//	IntBuffer		asIntBuffer			4바이트씩 연속된 int 데이터를 가진 ByteBuffer일 경우
	//	LongBuffer		asLongBuffer		8바이트씩 연속된 long 데이터를 가진 ByteBuffer일 경우
	//	FloatBuffer		asFloatBuffer		4바이트씩 연속된 float 데이터를 가진 ByteBuffer일 경우
	//	DoubleBuffer	asDoubleBuffer		8바이트씩 연속된 double 데이터를 가진 ByteBuffer일 경우
	
}
