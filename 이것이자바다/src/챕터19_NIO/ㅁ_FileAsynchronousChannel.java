	package 챕터19_NIO;

public class ㅁ_FileAsynchronousChannel {
	// FileChannel의 read()와 write() 메소드는 파일 입출력 작업 동안 블로킹된다. 만약 UI 및 이벤트를 처리하는 스레드에서 이 메소드들을 호출하면 블로킹되는 동안에 UI 갱신이나 이벤트 처리를 할 수 없다.
	// 따라서 별도의 작업 스레드를 생성해서 이 메소드들을 호출해야 한다. 만약 동시에 처리해야 할 파일 수가 많다면 스레드의 수도 증가하기 때문에 문제가 될 수 있다.
	// 그래서 자바 NIO는 불특정 다수의 파일 및 대용량 파일의 입출력 작업을 위해서 비동기 파일 채널(AsynchronousFileChannel)을 별도로 제공하고 있다.
	
	// AsynchronousFileChannel의 특징은 파일의 데이터 입출력을 위해 read()와 write() 메소드를 호출하면 스레드풀에게 작업 처리를 요청하고 이 메소드들을 즉시 리턴시킨다.
	// 실질적인 입출력 작업 처리는 스레드풀의 작업 스레드가 담당한다. 작업 스레드가 파일 입출력을 완료하게 되면 콜백(callback) 메소드가 자동 호출되기 때문에 작업 완료 후 실행해야 할 코드가 있다면
	// 콜백 메소드에 작성하면 된다.
	
	//	┌───────────────────────────────────────────────────────────────────────────────┐
	//	│AsynchronousFileChannel														│
	//	│	|																			│
	//	│	|	1 read() ┌──────┐				┌───────────────────────────────────┐	│
	//	│	|──────────→ │ 비동기	│	3 작업 처리		│				┌───────────┐ ┐		│	│
	//	│	|←────────── │  채널	■───┐ 요청		│				│	스레드 1	│ │		│	│
	//	│	|	2 즉시 리턴    └──────┘	│			│			 ┌→	│  5 작업 처리	│ │ 최	│	│
	//	│	|←───────────── 스레드 1	│			│	4 작업 큐	 │	│	  ■		│ │ 대	│	│
	//	│	| 6 콜백 메소드 호출			│			│	┌───────┐┘	└───────────┘ │ 개	│	│
	//	│	| 6 콜백 메소드 호출			■─────────────→	│ ■ ■ ■	│	┌───────────┐ │ 수	│	│
	//	│	|←─────────────	스레드 2	│			│	└───────┘─→	│	스레드 2	│ │  	│	│
	//	│	|	1 read() ┌──────┐	│			│	각 스레드는 큐에서	│  5 작업 처리	│ │ 제	│	│
	//	│	|──────────→ │ 비동기	│	│			│작업을 가져와 실행시킴	│	  ■		│ │ 한	│	│
	//	│	|←────────── │	채널	■───┘	요청		│				└───────────┘ │		│	│
	//	│	|	2 즉시 리턴	 └──────┘	3 작업 처리		│					  :		  │		│	│
	//	│	↓									│					스레드 n	  ┘		│	│
	//	│										└───────────────────────────────────┘	│
	//	└───────────────────────────────────────────────────────────────────────────────┘
	
			//	AsynchronousFileChannel Creation And Close		파일 비동기 채널 생성과 닫기
	
	// AsynchronousFileChannel은 두 가지 정적 메소드인 open()을 호출해서 얻을 수 있다. 첫 번째 open() 메소드는 다음과 같이 파일의 Path 객체와 열거 옵션 값을 매개값으로 받는다.
	
	//	AsynchronousFileChannel fileChannel= AsynchronousFileChannel.open(
	//		Path file,
	//		OpenOption... options
	//	);
	
	// 이렇게 생성된 AsynchronousFileChannel은 내부적으로 생성되는 기본 스레드풀을 이용해서 스레드를 관리한다.
	// 기본 스레드풀의 최대 스레드 개수는 개발자가 지정할 수 없기 때문에 다음과 같이 두 번째 open() 메소드로 AsynchronousFileChannel을 만들 수도 있다.
	
	//	AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
	//		Path file,
	//		Set<? extends OpenOption> options,
	//		ExecutorService executor,
	//		FileAttribute<?>... attrs
	//	);
	
	// file 매개값은 파일의 Path 객체이고, options 매개값은 열거 옵션 값들이 저장된 Set 객체이다. executor 매개값은 스레드풀인 ExecutorService 객체이다.
	// attrs 매개값은 파일 생성 시 파일 속성값이 될 FileAttribute를 나열하면 된다. 예를 들어 "C:\Temp\file.txt" 파일에 대한 AsynchronousFileChannel은 다음과 같이 생성할 수 있다.
	
	//	ExecutorService executorService = Executor.newFixedThreadPool(
	//		Runtime.getRuntime().availableProcessors()
	//	);
	//
	//	AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
	//		Paths.get("C:/Temp/file.txt"),
	//		EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE),
	//		executorService
	//	);
	
	// Runtime.getRuntime().availableProcessors()는 CPU의 코어 수를 리턴한다. 쿼드 코어 CPU일 경우는 4를 리턴, 하이퍼 스레딩일 경우 8을 리턴한다.
	// EnumSet.of() 메소드는 매개값으로 나열된 열거 상수를 Set 객체에 담아 리턴한다. AsynchronousFileChannel을 더 이상 사용하지 않을 경우에는 다음과 같이 close() 메소드를 호출해서 닫아준다.
	
	// fileChannel.close()
	
			//	File Reading And Writing	파일 읽기와 쓰기
	
	// AsynchronousFileChannel이 생성되었다면 read(), write() 메소드를 이용해서 입출력할 수 있다.
	
	//	read(ByteBuffer dst, long position, A attachment, CompletionHandler<Intger, A> handler);
	//	write(ByteBuffer src, long position, A attachment, CompletionHandler<Intger, A> handler);
	
	// 이 메소드들을 호출하면 즉시 리턴되고, 스레드풀의 스레득 입출력 작업을 진행한다. dst와 src 매개값은 읽거나 쓰기 위한 ByteBuffer이고, position 매개값은 파일에서 읽을 위치이거나 쓸 위치이다.
	// 파일의 첫 번째 바이트부터 읽거나 첫 번째 위치에 바이트를 쓰고 싶다면 position을 0으로 주면 된다. attachment 매개값은 콜백 메소드로 전달할 첨부 객체이다.
	// 첨부 객체는 콜백 메소드에서 결과값 외에 추가적인 정보를 얻고자 할 때 사용하는 객체를 말한다. 만약 첨부 객체가 필요없다면 null을 대입해도 된다.
	// handler 매개값은 CompletionHandler<Intger, A> 구현 객체를 지정한다. Integer는 입출력 작업의 결과 타입으로, read()와 write()가 읽거나 쓴 바이트 수이다.
	// A는 첨부 객체 타입으로 개발자가 CompletionHandler 구현 객체를 작성할 때 임의로 지정이 가능하다. 만약 첨부 객체가 필요 없다면 A는 Void가 된다.
	// CompletionHandler<Integer, A> 구현 객체는 비동기 작업이 정상적으로 완료된 경우와 예외 발생으로 실패된 경우에는 자동 콜백되는 다음 두 가지 메소드를 가지고 있어야 한다.
	
	//	리턴 타입		메소드명(매개 변수)								설명
	//
	//	void		completion(Integer result, A attachment)	작업이 정상적으로 완료된 경우 콜백
	//	void		failed(Throwable exc, A attachment)			예외 때문에 작업이 실패된 경우 콜백
	
	// completed() 메소드의 result 매개값은 작업 결과가 대입되는데, read()와 write() 작업 결과는 읽거나 쓴 바이트 수이다. attachment 매개값은 read()와 write() 호출 시 제공된 첨부 객체이다.
	// failed() 메소드의 exc 매개값은 작업 처리 도중 발생한 예외이다. 주목할 점은 콜백 메소드를 실행하는 스레드는 read()와 write()를 호출한 스레드가 아니고 스레드풀의 작업 스레드라는 것이다.
	// 그렇기 때문에 JavaFX 애플리케이션일 경우 UI 생성 및 변경 작업을 이 메소드에서 직접할 수 없고 Platform.runLater()를 이용해야 한다.
	// 다음은 CompletionHandler 구현 클래스를 작성하는 방법을 보여준다.
	
	//	new CompletionHandler<Integer, A>() {
	//		@Override
	//		public void completed(Integer result, A attachment) {...}
	//		@Override
	//		public void failed(Throwable exc, A attachment) {...}
	//	};
	
	// 다음은 AsynchronousFileChannel을 이용해서 비동기적으로 "C:\Temp" 디렉토리에 file0.txt ~ file9.txt까지 총 10개의 파일을 생성한 후 "안녕하세요"라는 내용을 쓴다.
	// 그리고 비동기 작업이 완료되었을 때 사용된 바이트 수와 처리를 담당했던 스레드 이름을 콘솔에 출력한다.
	
	// 이 예제에서도 역시 70라인의 read() 메소드가 즉시 리턴되더라도 뒤에서는 작업 스레드가 파일 읽기 작업을 하고 있기 때문에 바로 AsynchronousFileChannel을 닫으면 안된다.
	// 작업이 정상적으로 완료되었거나, 실패일 경우 채널을 닫아야 하므로 completed()와 failed() 메소드에서 AsynchronousFileChannel의 close()를 호출해야 한다.
}
