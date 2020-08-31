package 챕터19_NIO;

public class ㄹ_FileChannel {
	// java.nio.channels.FileChannel을 이용하면 파일 읽기와 쓰기를 할 수 있다. FileChannel은 동기화 처리가 되어 있기 때문에 멀티 스레드 환경에서 사용해도 안전하다.
	
	
	//		┌────────────────┐				┌───────┐
	//		│				 │	FileChannel	│		│
	//		│	입력		┌───┐───────────────│		│
	//		│	데이터 ←──	│버	│←--------------│		│
	//		│			│	│				│	파일	│
	//		│	출력	───→│퍼	│--------------→│		│
	//		│	데이터	└───┘───────────────│		│
	//		│				 │				│		│
	//		└────────────────┘				└───────┘
	
			//	FileChannel Creation And Close		FileChannel 생성과 닫기
	
	// FileChannel은 정적 메소드인 open()을 호출해서 얻을 수도 있지만, IO의 FileInputStream, FileOutputStream의 getChannel() 메소드를 호출해서 얻을 수 있다.
	// 다음은 open() 매소드로 FileChannel을 얻는 방법을 보여준다.
	
	//	FileChannel fileChannel = FileChannel.open(Path path, OpenOption... options);
	
	// 첫 번째 path 매개값은 열거나, 생성하고자 하는 파일의 경로를 Path 객체로 생성해서 지정하면 되고, 두 번째 options 매개값은 열기 옵션 값인데 StandardOpenOption의 다음 열거 상수를 나열해주면 된다.
	
	//	열거 상수				설명
	//
	//	READ				읽기용으로 파일을 연다.
	//	WRITE				쓰기용으로 파일을 연다.
	//	CREATE				파일이 없다면 새 파일을 생성한다.
	//	CREATE_NEW			새 파일을 만든다. 이미 파일이 있으면 예외와 함께 실패한다.
	//	APPEND				파일 끝에 데이터를 추가한다(WRITE나 CREATE와 함께 사용됨).
	//	DELETE_ON_CLOSE		채널을 닫을 때 파일을 삭제한다(임시 파일을 삭제할 때 사용).
	//	TRUNCATE_EXISTING	파일을 0바이트로 잘라낸다(WRITE 옵션과 함께  사용됨).
	
	// 예를 들어 "C:\Temp\file.txt" 파일을 생성하고, 어떤 내용을 쓰고 싶다면 다음과 같이 매개값을 지정하면 된다.
	
	//	FileChannel fileChannel = FileChannel.open(
	//		Paths.get("C:/Temp/file.txt");
	//		StandardOpenOption.CREATE_NEW,
	//		StandardOpenOption.WRITE
	//	);
	
	// 다음은 "C:\Temp\file.txt" 파일을 읽고, 쓸 수 있도록 FileChannel을 생성한다.
	
	//	FileChannel fileChannel = FileChannel.open(
	//		Paths.get("C:/Temp/file.txt"),
	//		StandardOpenOption.READ,
	//		StandardOpenOption.WRITE
	//	);
	
	// FileChannel을 더 이상 이용하지 않을 경우에는 다음과 같이 close() 메소드를 호출해서 닫아주어야 한다.
	
	//	fileChannel.close();
	
			//	File Reading And Writing		파일 쓰기와 읽기
	
	// 파일에 바이트를 쓰려면 다음과 같이 FileChannel의 write() 메소드를 호출하면 된다. 매개값으로 ByteBuffer 객체를 주면 되는데, 파일에 쓰여지는 바이트는 ByteBuffer의 position부터 limit까지이다.
	// position이 0이고 limit이 capacity와 동일하다면 ByteBuffer의 모든 바이트가 파일에 쓰여진다. write() 메소드의 리턴값은 ByteBuffer에서 파일로 쓰여진 바이트 수이다.
	
	//	int bytesCount = fileChannel.write(ByteBuffer src);
	
	// 다음 예제는 FileChannel을 이용해서 문자열을 C:\Temp\file.txt 파일에 저장한다.
	
	// 이번에는 파일 읽기를 살펴보자. 파일로부터 바이트를 읽기 위해서는 다음과 같이 FileChannel의 read() 메소드를 호출하면 된다.
	// 매개값으로 ByteBuffer 객체를 주면 되는데, 파일에서 얽혀지는 바이트는 ByteBuffer의 position부터 저장된다. position이 0이면 ByteBuffer의 첫 바이트부터 저장된다.
	// read() 메소드의 리턴값은 파일에서 ByteBuffer로 읽혀진 바이트 수이다. 한 번 읽을 수 있는 최대 바이트수는 ByteBuffer의 capacity까지므로 리턴되는 최대값은 capacity가 된다.
	// 더 이상 읽을 바이트가 없다면 read() 메소드는 -1을 리턴한다.
	
	//	int bytesCount = fileChannel.read(ByteBuffer dst);
	
	// 버퍼에 한 바이트를 저장할 때마다 position이 1씩 증가하게 되는데, read() 메소드가 -1을 리턴할 때까지 버퍼에 저장한 마지막 바이트의 위치는 position-1 인덱스이다.
	// 다음 예제는 이전 예제에서 생성한 C:\Temp\file.txt 파일을 읽고 콘솔에 출력한다.
	
	// 파일의 크기가 100바이트보다 작지만 17라인에서는 ByteBuffer의 크기를 100으로 주었다. 24라인은 FileChannel의 read() 메소드를 호출해서 최대 100바이트를 읽는다.
	// 그러나 파일의 크기가 100바이트보다 작으므로 byteCount에는 100보다 작은 값이 저장된다. 26라인에서 flip()을 호출한 이유는 limit을 현재 position으로 설정하고
	// position을 0으로 설정하기 위해서이다. 18라인은 position에서 limit까지 읽고 문자열로 변환한다. 28라인에서 claer()를 호출한 이유는 position을 0번 인덱스로, 
	// limit을 capacity로 설정해서 ByteBuffer를 초기화하기 위해서이다.
	
			//	File Copy	파일 복사
	
	// 파일 복사를 구현하기 위해서는 하나의 ByteBuffer를 사이에 두고, 파일 읽기용 FileChannel과 파일 쓰기용 FileChannel이 읽기와 쓰기를 교대로 번갈아 수행하도록 하면 된다.
	
	//		┌───────────┐			┌───────────────────┐			┌───────────┐
	//		│			│FileChannel│		프로그램		│FileChannel│			│
	//		│			│───────────│	┌───────────┐	│───────────│			│
	//		│	소스 파일	│---------------→	버퍼		←---------------│	타겟 파일	│
	//		│			│───────────│	│			│	│───────────│			│
	//		│			│			│	└───────────┘	│			│			│
	//		└───────────┘			└───────────────────┘			└───────────┘
	
	// 다음 예제는 FileChannel을 이용해서 이미지 파일을 복사한다. 이 예제의 12라인에서는 크기가 100인 다이렉트 버퍼를 생성했다. 채널에서 읽고 다시 채널로 쓰는 경우 다이렉트 버퍼가 좋은 성능을 내기 때문이다.
	// 이클립스에서 예제를 실행할 경우, 생성된 파일이 Package Explorer에 보이지 않으므로 F5키를 눌러서 프로젝트를 새로고침(refresh)해야 한다.
	
	// 이번 예제처럼 ByteBuffer와 FileChannel 2개를 직접 생성해서 복사를 구현해도 좋지만, 단순히 파일을 복사할 목적이라면 NIO의 Files 클래스의 copy() 메소드를 사용하는 것이 더 편리하다.
	
	//	Path targetPath = Files.copy(Path source, Path target, CopyOption... options);
	
	// 첫 번째 source 매개값에는 원본 파일의 Path 객체를 지정하고, 두 번째 target 매개값에는 타겟 파일의 Path 객체를 지정하면 된다.
	// 세 번째 매개값은 다음 세 가지 StandardCopyOption 열거 상수를 목적에 맞게 나열해주면 된다.
	
	//	열거 상수				설명
	//
	//	REPLACE_EXISTING	타겟 파일이 존재하면 대체한다.
	//	COPY_ATTRIBUTE		파일의 속성까지도 복사한다.
	//	NOFOLLOW_LINKS		링크 파일일 경우 링크 파일만 복사하고 링크된 파일은 복사하지 않는다.
	
	// 다음 예제는 Files 클래스의 copy() 메소드를 이용해서 이미지 파일을 복사한다.
	
	// 이 예제에서 주의할 점은 66라인에서 write() 메소드가 즉시 리턴되더라도 조금 뒤에서는 작업 스레드가 파일 쓰기 작업을 하고 있기 때문에 바로 AsynchronousFileChannel을 닫으면 안된다.
	// 작업이 정상적으로 완료되었거나, 실패일 경우 채널을 닫아야 하므로 completed()와 failed() 메소드에서 AsynchronousFileChannel의 close()를 호출해야 한다.
	// 다음 예제는 이전 예제에서 생성한 file0.txt ~ file9.txt를 읽고 콘솔에 출력한다.
}
