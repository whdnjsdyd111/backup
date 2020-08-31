package 챕터19_NIO;

public class ㄴ_File_Directory {
	// IO는 파일의 속성 정보를 읽기 위해 File 클래스만 제공하지만, NIO는 좀 더 다양한 파일의 속성 정보를 제공해주는 클래스와 인터페이스를
	// java.nio.file, java.nio.file.attribute 패키지에서 제공하고 있다.
	
			//	Path
	
	// NIO에서 제일 먼저 살펴봐야 할 API는 java.nio.file.Path 인터페이스이다. Path는 IO의 java.io.File 클래스에 대응되는 NIO 인터페이스이다.
	// NIO의 API에서 파일의 경로를 지정하기 위해 Path를 사용하기 때문에 Path 사용 방법을 잘 익혀두어야 한다.
	// Path 구현 객체를 얻기 위해서는 java.nio.file.Path 클래스의 정적 메소드인 get() 메소드를 호출해야 한다.
	
	//	Path path = Paths.get(String first, String ... more);
	//	Path path = Paths.get(URI uri);
	
	// get() 메소드의 매개값은 파일의 경로인데, 문자열로 지정할 수도 있고, URI 객체로 지정할 수도 있다. 문자열로 지정할 경우 전체 경로를 한꺼번에 지정해도 좋고, 상위 디렉토리와 하위 디렉토리를 나열해서 지정해도 좋다.
	// 다음은 "C:\Temp\dir\file.txt" 경로를 이용해서 Path 객체를 얻는 방법을 보여준다.
	
	//	Path path = Paths.get("C:/Temp/dir/file.txt");
	//	Path path = Paths.get("C:/Temp/dir", "file.txt");
	//	Path path = Paths.get("C:", "Temp", "dir", "file.txt");
	
	// 파일의 경로는 절대 경로와 상대 경로를 모두 사용할 수 있다. 만약 현재 디렉토리 위치가 "C:\Temp"일 경우 "C:\Temp\dir\file.txt"는 다음과 같이 지정이 가능하다.
	
	//	Path path = Paths.get("dir/file.txt");
	//	Path path = Paths.get("./dir/file.txt");
	
	// 현재 위치가 C:\Temp\dir1" 이라면 "C:\Temp\dir2\file.txt"는 다음과 같이 지정이 가능하다.
	
	//	Path path = Paths.get(".../dir2/file.txt");
	
	// Path 인터페이스에는 다음과 같이 파일 경로에서 얻을 수 있는 여러 가지 정보를 제공해주는 메소드가 있다.
	
	//	리턴 타입		메소드(매개 변수)					설명
	//		
	//												파일 경로가 동일하면 0을 리턴,
	//	int				compareTo(Path other)		상위 경로면 음수,
	//												하위 경로면 양수를 리턴,
	//												음수와 양수 값의 차이나는 문자열의 수
	//
	//	Path			getFileName()				부모 경로를 제외한 파일 또는 디렉토리 이름만 가진 Path 리턴
	//
	//	FileSystem		getFileSystem()				FileSystem 객체 리턴
	//
	//												C:\Temp\dir\file.txt일 경우
	//												index가 0이면 "Temp"의 Path 객체 리턴
	//	Path			getName(int index)			index가 1이면 "dir"의 Path 객체 리턴
	//												index가 2이면 "file.txt"의 Path 객체 리턴
	//
	//	int				getNameCount()				중첩 경로 수, C:\Temp\dir\file.txt일 경우 3을 리턴
	//	
	//	Path			getParent()					바로 위 부모 폴더의 Path 리턴
	//
	//	Path			getRoot()					루트 디렉토리의 Path 리턴
	//
	//	Iterator<Path>	iterator()					경로에 있는 모든 디렉토리와 파일을 Path 객체로 생성하고 반복자를 리턴
	//
	//	Path			normalize()					상대 경로로 표기할 때 불필요한 요소를 제거
	//												C:\Temp\dir\...\dir\file.txt -> C:\Temp\dir2\file.txt
	//
	//	WatchKey		register(...)				WatchService를 등록(와치 서비스에서 설명함)
	//
	//	File			toFile()					java.io.File 객체로 리턴
	//
	//	String			toString()					파일 경로를 문자열로 리턴
	//
	//	URI				toURI()						파일 경로를 URI 객체로 리턴
	
	// 다음 예제는 상대 경로를 이용해서 소스 파일에 대한 Path 객체를 얻고, 파일명, 부모 디렉토리명, 중쳡 경로 수, 경로상에 있는 모든 디렉토리를 출력한다.
	
			//	FileSystem
	
	// 운영체제의 파일 시스템은 FileSystem 인터페이스를 통해서 접근할 수 있다. FileSystem 구현 객체는 FileSystems의 정적 메소드인 getDefault()로 얻을 수 있다.
	
	//	FileSystem fileSystem = FileSystems.getDefault();
	
	// FileSystem은 다음과 같은 메소드를 제공한다.
	
	//	리턴 타입					매개 변수					설명
	//
	//	Iterable<FileStore>		getFileStores()			드라이버 정보를 가진 FileStore 객체들을 리턴
	//	Iterable<Path>			getRootDirectories()	루트 디렉토리 정보를 가진 Path 객체들을 리턴
	//	String					getSeparator()			디렉토리 구분자 리턴
	
	// FileStore는 드라이버를 표현한 객체로 다음과 같은 메소드를 제공한다.
	
	//	리턴 타입		메소드(매개 변수)				설명
	//		
	//	long		getTotalSpace()			드라이버 전체 공간 크기(단위: 바이트) 리턴
	//	long		getUnallocatedSpace()	할당되지 않은 공간 크기(단위: 바이트) 리턴
	//	long		getUsableSpace()		사용 가능한 공간 크기, getUnallocatedSpace()와 동일한 값
	//	boolean		isReadOnly()			읽기 전용 여부
	//	String		name()					드라이버명 리턴
	//	String		type()					파일 시스템 종류
	
			//	Reading File Properties And File, Directory Creation/ Delete	파일 속성 읽기 및 파일,디렉토리 생성/삭제
	
	// java.nio.Files 클래스는 파일과 디렉토리의 생성 및 삭제, 그리고 이들의 속성을 읽는 메소드를 제공하고 있다.
	// 여기서 속성이란 파일이나 디렉토리가 숨김인지, 디렉토리인지, 크기가 어떻게 되는지, 소우자가 누구인지에 대한 정보를 말한다.
	// 다음은 java.nio.file.Files 클래스가 제공하는 정적 메소드들이다. 매개 변수에 대한 자세한 설명은 API 도큐먼트를 참고하자.
	
	//	리턴 타입					메소드(매개변수					설명
	//
	//	long 또는 Path			copy(..)					복사
	//	Path					createDirectories(..)		모든 부모 디렉토리 생성
	//	Path					createDirectory(..)			경로의 마지막 디렉토리만 생성
	//	Path					createFile(..)				파일 생성
	//	void					delete(..)					삭제
	//	boolean					deleteExists(..)			존재한다면 삭제
	//	boolean					exists(..)					존재 여부
	//	FileStore				getFileStore(..)			파일이 위치한 FileStore(드라이브) 리턴
	//	FileTime				getLastModifiedTime(..)		마지막 수정 시간을 리턴
	//	UserPrincipal			getOwner(..)				소유자 정보를 리턴
	//	boolean					isDirectory(..)				디렉토리인지 여부
	//	boolean					isExecutable(..)			실행 가능 여부
	//	boolean					isHidden(..)				숨김 여부
	//	boolean					isReadable(..)				읽기 가능 여부
	//	boolean					isRegularFile(..)			일반 파일인지 여부
	//	boolean					isSameFile(..)				같은 파일인지 여부
	//	boolean					isWritable(..)				쓰기 가능 여부
	//	Path					move(..)					파일 이동
	//	BufferedReader			newBufferedReader(..)		텍스트 파일을 읽는 BufferedReader 리턴
	//	BufferedWriter			newBufferedWriter(..)		텍스트 파일에 쓰는 BufferedWriter 리턴
	//	SeekableByteChannel		newByteChannel(..)			파일에 읽고 쓰는 바이트 채널을 리턴
	//	DirectoryStream<Path>	newDirectoryStream(..)		디렉토리의 모든 내용을 스트림으로 리턴
	//	InputStream				newInputStream(..)			파일의 InputStream 리턴
	//	OutputStream			newOutputStream(..)			파일의 OutputStream 리턴
	//	boolean					notExists(..)				존재하지 않는지 여부
	//	String					probeContentType(..)		파일의 MIME 타입을 리턴
	//	byte[]					readAllBytes(..)			파일의 모든 바이트를 읽고 배열로 리턴
	//	List<String>			readAllLines(..)			텍스트 파일의 모든 라인을 읽고 리턴
	//	long					size(..)					파일의 크기 리턴
	//	Path					write(..)					파일에 바이트나 문자열을 저장
	
	// 다음 예제는 파일의 속성을 읽고 출력한다.
	
			//	WatchService
	
	// 와치 서비스(WatchService)는 자바 7에서 처음 소개된 것으로 디렉토리 내부에서 파일 생성, 삭제, 수정 등의 내용 변화를 감시하는데 사용된다.
	// 흔하게 볼 수 있는 와치 서비스의 적용 예는 에디터에서 파일을 편집하고 있을 때, 에디터 바깥에서 파일 내용을 수정하게 되면 파일 내용이 변경됐으니 파일을 다시 불러올 것인지 묻는 대화상자를 띄우는 것이다.
	// 와치 서비스는 일반적으로 파일 변경 통지 매커니즘으로 알려져 있다. WatchService를 생성하려면 다음과 같이 FileSystem의 newWatchService() 메소드를 호출하면 된다.
	
	//	WatchService watchService = FileSystems.getDefault().newWatchService();
	
	// WatchService를 생성했다면 감시가 필요한 디렉토리의 Path 객체에서 register() 메소드로 WatchService를 등록하면 된다. 이때 어떤 변화(생성, 삭제, 수정)를 감시할 것인지를
	// StandardWatchEventKinds 상수로 지정할 수 있다. 다음은 생성, 수정, 삭제를 감시하도록 WatchService를 등록한다.
	
	//	path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
	//								StandardWatchEventKinds.ENTRY_MODIFY,
	//								StandardWatchEventKinds.ENTRY_DELETE);
	
	// 디렉토리(Path)에 WatchService를 등록한 순간부터 디렉토리 내부에서 변경이 발생되면 와치 이벤트(WatchEvent)가 발생하고, WatchService는 해당 이벤트 정보를 가진 와치키(WatchKey)를 생성하여
	// 큐(Queue)에 넣어준다. 프로그램은 무한 루프를 돌면서 WatchService의 take() 메소드를 호출하여 WatchKey가 큐에 들어올 때까지 대기하고 있다가 WatchKey가 큐에 들어오면 WatchKey를 얻어 처리하면 된다.
	
	//	while(true) {
	//		WatchKey watchKey = watchService.take()		// 큐에 WatchKey가 들어올 때까지 대기
	//	}
	
	// WatchKey를 얻고나서 해야 할 일은 pollEvents() 메소드를 호출해서 WatchEvent 리스트를 얻어내는 것이다.
	// 한 개의 WatchEvent가 아니라 List<WatchEvent<?>>로 리턴하는 이유는 여러개의 파일이 동시에 삭제, 수정, 생성될 수 있기 때문이다. 참고로 WatchEvent는 파일당 하나씩 발생한다.
	
	//	List<WatchEvent<?>> list = watchKey.pollEvents();
	
	// 프로그램은 WatchEvent 리스트에서 WatchEvent를 하나씩 꺼내어 이벤트의 종류와 Path 객체를 얻어낸 다음 적절히 처리하면 된다.
	
	//	for(WatchEvent watchEvent : list) {
	//		// 이벤트 종류 얻기
	//		Kind kind = watchEvent.kind();
	//		// 감지된 Path 얻기
	//		Path path = (Path) watchEvent.context();
	//		// 이벤트 종류별로 처리
	//		if(kind == StandardWatchEventKinds.ENTRY_CREATE) {
	//			// 생성되었을 경우, 실행할 코드
	//		} else if(kind == StandardWatchEventKinds.ENTRY_DELETE) {
	//			// 삭제되었을 경우, 실행할 코드
	//		} else if(kind == StandardWatchEventKinds.ENTRY_MODIFY) {
	//			// 변경되었을 경우, 실행할 코드
	//		} else if(kind == StandardWatchEventKinds.OVERFLOW) {
	//		}	
	//	}
	
	// OVERFLOW 이벤트는 운영체제에서 이벤트가 소실됐거나 버려진 경우에 발생하므로 별도의 처리 코드가 필요 없다. 따라서 CREATE, DELETE, MODIFY 이벤트만 처리하면 된다.
	// 한 번 사용된 WatchKey는 reset() 메소드로 초기화해야 하는데, 새로운 WatchEvent가 발생하면 큐에 다시 들어가기 때문이다. 초기화에 성공하면 reset() 메소드는 true를 리턴하지만, 
	// 감시하는 디렉토리가 삭제 되었거나 키가 더 이상 유효하지 않을 경우에는 false를 리턴한다. WatchKey가 더 이상 유효하지 않게 되면 무한 루프를 빠져나와 WatchService의 close() 메소드를 호출하고 종료하면 된다.
	
	//	while(true) {
	//		WatchKey watchKey = watchService.take();
	//		List<WatchEvent<?>> list = watchKey.pollEvents();
	//		
	//		for(WatchEvent watchEvent : list) {
	//			...
	//		}
	//		boolean valid = watchKey.reset();
	//		if(!valid) { break; }
	//	}
	//	watchService.close();
	
	// 다음 예제는 C:\Temp 디렉토리를 감시 디렉토리로 설정했다. 실행 후, C:\Temp\dir 디렉토리와 C:\Temp\file.txt 파일을 생성하고, file.txt 파일 내용을 수정한 다음 저장하였다.
	// 그리고 dir, file.txt를 동시에 삭제 했다. 이 모든 행위들이 TextArea에 기록되는 것을 볼 수 있다.
}
