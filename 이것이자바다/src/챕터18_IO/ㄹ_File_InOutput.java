package 챕터18_IO;

public class ㄹ_File_InOutput {
			//	File Class
	
	// IO 패키지 (java.io)에서 제공하는 File 클래스는 파일 크기, 파일 속성, 파일 이름 등의 정보를 얻어내는 기능과 파일 생성 및 삭제 기능을 제공하고 있다.
	// 그리고 디렉토리를 생성하고 디렉토리에 존재하는 파일 리스트를 얻어내는 기능도 있다. 그러나 파일의 데이터를 읽고 쓰는 기능은 지원하지 않는다.
	// 파일의 입출력은 스트림을 사용해야 한다. 다음은 C:\Temp 디렉토리의 file.txt 파일을 File 객체로 생성하는 코드이다.
	
	//	File file = new File("C:\\Temp\\file.txt");
	//	File file = new File("C:/Temp/file.txt");
	
	// 디렉토리 구분자는 운영체제마다 조금씩 다르다. 윈도우에서는 \ 또는 /를 사용할 수 있고, 유닉스나 리눅스에서는 \를 사용한다.
	// File.separator 상수를 출력해보면 해당 운영체제에서 사용하는 디렉토리 구분자를 확인할 수 있다. 만약 \를 디렉토리 구분자로 사용한다면 이스케이프 문자(\\)로 기술해야 한다.
	
	// File 객체를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다. 생성자 매개값으로 주어진 경로가 유효하지 않더라도 컴파일 에러나 예외가 발생하지 않는다.
	// File 객체를 통해 해당 경로에 실제로 파일이나 디렉토리가 있는지 확인하려면 exists() 메소드를 호출할 수 있다. 
	// 디렉토리 또는 파일이 파일 시스템에 존재한다면  true를 리턴하고 존재하지 않는다면 false를 리턴한다.
	
	//	boolean isExist = file.exists();
	
	// exists() 메소드의 리턴값이 false라면 createNewFile(), mkdir(), mkdirs() 메소드로 파일 또는 디렉토리를 생성할 수 있다.
	
	//	리턴 타입		메소드				설명
	//
	//	boolean		createNewFile()		새로운 파일을 생성
	//	boolean		mkdir()				새로운 디렉토리를 생성
	//	boolean		mkdirs()				경로상에 없는 모든 디렉토리를 생성
	//	boolean		delete()			파일 또는 디렉토리를 삭제
	
	// 파일 또는 디렉토리가 존재할 경우에는 다음 메소드를 통해 정보를 얻어낼 수 있다.
	
	//	리턴 타입		메소드 							설명
	//	
	//	boolean		canExecute()					실행할 수 있는 파일인지 여부
	//	boolean		canRead()						읽을 수 있는 파일인지 여부
	//	boolean		canWrite()						수정 및 저장할 수 있는 파일인지 여부
	//	String		getName()						파일의 이름을 리턴
	//	String		getParent()						부모 디렉토리를 리턴
	//	File		getParentFile()					부모 디렉토리를 File 객체로 생성 후 리턴
	//	String		getPath()						전체 경로를 리턴
	//	boolean		isDirectory()					디렉토리인지 여부
	//	boolean		isFile()						파일인지 여부
	//	boolean		isHidden()						숨김 파일인지 여부
	//	long		lastModified()					마지막 수정 날짜 및 시간을 리턴
	//	long		length()						파일의 크기를 리턴
	//	String[]	list()							디렉토리에 포함된 파일 및 서브디렉토리 목록 전부를 String 배열로 리턴
	//	String[]	list(FilenameFilter filter)		디렉토리에 포함된 파일 및 서브디렉토리 목록 중에 FilenameFilter에 맞는 것만 String 배열로 리턴
	//	File[]		listFiles()						디렉토리에 포함된 파일 및 서브 디렉토리 목록 전부를 File 배열로 리턴
	//	File[]		listFiles(FilenameFilter filter)디렉토리에 포함된 파일 및 서브 디렉토리 목록 중에 FilenameFilter에 맞는 것만 File 배열로 리턴
	
	// 다음은 C:\ 디렉토리에 Dir 디렉토리와 file1.txt, file2.txt, file3.txt 파일을 생성하고, Temp 디렉토리에 있는 파일 목록을 출력하는 예제이다.
	
			//	FileInputStream
	
	// FileInputStream 클래스는 파일로부터 바이트 단위로 읽어들일 때 사용하는 바이트 기반 입력 스트림이다. 바이트 단위로 읽기 때문에 그림, 오디오, 비디오, 덱스트 파일 등 모든 종류의 파일을 읽을 수 있다.
	// 다음은 FileInputStream을 생성하는 두 가지 방법을 보여준다.
	
	//	// 첫 번째 방법
	//	FileInputStream fis = new FileInputStream("C:/Temp/image.gif");
	//
	//	// 두 번째 방법
	//	File file = new File("C:/Temp/image.gif");
	//	FileInputStream fis = new FileInputStream(file);
	
	// 첫 번째 방법은 문자열로된 파일의 경로를 가지고 FileInputStream을 생성한다. 만약 읽어야 할 파일이 File 객체로 이미 생성되어 있다면 두 번째 방법으로 좀 더 쉽게 FileInputStream을 생성할 수 있다.
	// FileInputStream 객체가 생성될 때 파일과 직접 연결이 되는데, 만약 파일이 존재하지 않으면 FileNotFoundException을 발생시키므로 try-catch문으로 예외 처리를 해야 한다.
	// FileInputStream은 InputStream의 하위 클래스이기 때문에 사용 방법이 InputStream과 동일하다.
	// 한 바이트를 읽기 위해서 read() 메소드를 사용하거나, 읽은 바이트를 byte 배열에 저장하기 위해서 read(byte[] b) 또는 read(byte[] b, int off, int len) 메소드를 사용한다.
	// 전체 파일의 내용을 읽기 위해서는 이 메소들을 반복 실행해서 -1이 나올 때까지 읽으면 된다. 파일의 내용을 모두 읽은 후에는 close() 메소드를 호출해서 파일을 닫아준다.
	
	//	FileInputStream fis = new FileInputStream("C:/Temp/image.gif");
	//	int readByteNo;
	//	byte[] readBytes = new byte[100];
	//	while( (readByteNo = fis.read(readBytes) ) != -1 ) {	
	//		// 읽은 바이트 배열(readBytes)을 처리
	//	}
	//	fis.close();
	
	// 다음은 FileInputStreamExample.java 소스 파일을 읽고 콘솔에 보여주는 예제이다.
	
			//	FileOutputStream
	
	// FileOutputStream은 바이트 단위로 데이터를 파일에 저장할 때 사용하는 바이트 기반 출력 스트림이다. 바이트 단위로 저장하기 때문에 그림, 오디오, 비디오, 텍스트 등 모든 종류의 데이터를 파일로 저장할 수 있다.
	// 다음은 FileOutputStream을 생성하는 두 가지 방법을 보여준다. 첫 번째 방법은 파일의 경로를 가지고 FileOutputStream을 생성하지만, 저장할 파일이 File 객체로 이미 생성되어 있다면
	// 두 번째 방법으로 좀 더 쉽게 FileOutputStream을 생성할 수 있다.
	
	//	// 방법 1
	//	FileOutputStream fos = new FileOutputStream("C:/Temp/image.gif");
	//
	//	// 방법 2
	//	File file = new File("C:/Temp/image.gif");
	//	FileOutputStream fos = new FileOutputStream(file);
	
	// 주의할 점은 파일이 이미 존재할 경우, 데이터를 출력하면 파일을 덮어쓰게 되므로, 기존의 파일 내용은 사라지게 된다. 
	// 기존의 파일 내용 끝에 데이터를 추가할 경우에는 FileOutputStream 생성자의 두 번째 매개값을 true로 주면 된다.
	
	//	FileOutputStream fos = new FileOutputStream("C:/Temp/data.txt", true);
	//	FileOutputStream fos = new FileOutputStream(file, true);
	
	// FileOutputStream은 OutputStream의 하위 클래스이기 때문에 사용 방법이 OutputStream과 동일하다.
	// 한 바이트를 저장하기 위해서 write() 메소드를 사용하고 바이트 배열을 한꺼번에 저장하기 위해서 write(byte[] b) 또는 write(byte[] b, int off, int len) 메소드를 사용한다.
	
	//	FileOutputStream fos = new FileOutputStream("C:/Temp/images.gif");
	//	byte[] data = ...;
	//	fos.write(data);
	//	fos.flush();
	//	fos.close();
	
	// write() 메소드를 호출한 이후에 flush() 메소드로 출력 버퍼에 잔류하는 데이터를 완전히 출력하도록 하고, close() 메소드를 호출해서 파일을 닫아준다.
	// 다음은 원본 파일을 타겟 파일로 복사하는 예제이다. 복사 프로그램의 원리는 원본 파일에서 읽은 바이트를 바로 타겟 파일로 저장하는 것이기 때문에 
	// FileInputStream에서 읽은 바이트를 바로 FileOutputStream으로 저장하면 된다.
	
	// 15라인의 readByteNo는 실제로 읽은 바이트 수가 저장될 변수이고, 16라인은 실제로 읽은 바이트가 저장되는 배열이다. 17라인은 FileInputStream의 read(byte[] b) 메소드로 한 번에 100 바이트를 읽어
	// readBytes에 저장하고 100을 readByteNo에 저장한다. 그리고 readByteNo가 -1이 아닌지 검사한다. 이렇게 계속해서 루핑을 돌다가 마지막 루핑 시에는 100개보다 작은 바이트를 읽어
	// raedBytes에 저장하고 바이틀 수를 readByteNo에 저장한다. 예를 들어 파일의 사이즈가 520 바이트라면 while문은 6번 루핑하는데 마지막 루핑 시에는 20바이트만 읽어 
	// FileOutputStream의 write(byte[] b, int off, int len) 메소드로 저장한다. b는 readBytes가 되고, off는 0, len은 readByteNo가 된다.
	
			//	FileReader
	
	// FileReader 클래스는 텍스트 파일을 프로그램으로 읽어들일 때 사용하는 문자 기반 스트림이다. 문자 단위로 읽기 때문에 텍스트가 아닌 그림, 오디오, 비디오 등의 파일은 읽을 수 없다.
	// 다음은 FileReader를 생성하는 두 가지 방법을 보여준다. 첫 번째 방법은 전체 파일의 경로를 가지고 FileReader를 생성하지만, 
	// 읽어야 할 파일이 File 객체로 이미 생성되어 있다면 두 번째 방법으로 좀 더 쉽게 FileReader를 생성할 수 있다.
	
	//	// 방법1
	//	FileReader fr = new FileReader("C:/Temp/file.txt");
	//
	//	// 방법2
	//	File file = new File("C:/Temp/file.txt");
	//	FileReader fr = new FileReader(file);
	
	// FileReader 객체가 생성될 때 파일과 직접 연결이 되는데, 만약 파일이 존재하지 않으면 FileNotFoundException을 발생시키므로 try-catch문으로 예외 처리를 해야 한다.
	// FileReader는 Reader의 하위 클래스이기 때문에 사용 방법이 Reader와 동일하다. 한 문자를 읽기 위해서 read() 메소드를 사용하거나, 읽은 문자를 char 배열에 저장하기 위해서 read(char[] cbuf) 또는
	// read(char[] cbuf, int off, int len) 메소드를 사용한다. 전체 파일의 내용을 읽기 위해서는 이 메소드들을 반복 실행해서 -1이 나올 때까지 읽으면 된다.
	
	//	FileReader fr = new FileReader("C:/Temp/file.txt");
	//	int readCharNo;
	//	char[] cbuf = new char[100];
	//	while( (readCharNo = fr.read(cbuf)) != -1) {
	//		// 읽은 문자 배열(cbuf)를 처리
	//	}
	//	fr.close();
	
	// 파일의 내용을 모두 읽은 후에는 close() 메소드를 호출해서 파일을 닫아준다. 다음은 FileReaderExample.java 소스 파일을 읽고 콘솔에 출력하는 예제이다.
	
	// 13라인에서 cbuf 배열에 저장되어 있는 문자들을 연결해서 문자열(String 객체)로 생성하였다.
	// String 생성자의 첫 번째 매개값에는 cbuf를, 두 번째 매개값은 0 인덱스를, 세 번째 매개값은 읽은 문자 수를 지정했다.
	
			//	FileWriter
	
	// FileWriter는 텍스트 데이터를 파일에 저장할 때 사용하는 문자 기반 스트림이다. 문자 단위로 저장하기 때문에 텍스트가 아닌 그림, 오디오, 비디오 등의 데이터를 파일로 저장할 수 없다.
	// 다음은 FileWriter를 생성하는 두 가지 방법을 보여준다. 첫 번째 방법은 전체 파일의 경로를 가지고 FileWriter을 생성하지만, 
	// 저장할 파일이 File 객체로 이미 생성되어 있다면 두 번째 방법으로 좀 더 쉽게 FileWirter를 생성할 수 있다.
	
	//	// 방법1	
	//	FileWriter fw = new FileWriter("C:/Temp/file.txt");
	//
	//	// 방법2
	//	File file = new File("C:/Temp/file.txt");
	//	FileWriter fw = new FileWriter(file);
	
	// 위와 같이 FileWriter를 생성하면 지정된 파일이 이미 존재할 경우 그 파일을 덮어쓰게 되므로, 기존의 파일 내용은 사라지게 된다.
	// 기존의 파일 내용 끝에 데이터를 추가할 경우에는 FileWriter 생성자에 두 번째 매개값으로 true를 주면 된다.
	
	//	FileWriter fw = new FileWriter("C:/Temp/file.txt", true);
	//	FileWriter fw = new FileWriter(file, true);
	
	// FileWriter는 Writer의 하위 클래스이기 때문에 사용 방법이 Writer와 동일하다. 한 문자를 저장하기 위해서 write() 메소드를 사용하고 문자열을 저장하기 위해서 write(String str) 메소드를 사용한다.
	
	//	FileWriter fw = new FileWriter("C:/Temp/file.txt");
	//	String data = "저장할 문자열";
	//	fw.write(data);
	//	fw.flush();
	//	fw.close();
	
	// write() 메소드를 호출한 이후에 flush() 메소드로 출력 버퍼에 있는 데이터를 파일로 완전히 출력하도록 하고, close() 메소드를 호출해서 파일을 닫아준다.
	// 다음 예제는 문자열 데이터를 C:\Temp\file.txt 파일에 저장한다.
	
	//	실행결과
	//
	//	┌───────────────┐───────────┐	┌───────────────────────────┐
	//	│	:			│ ■ file.txt│	│file.txt - 메모장			│
	//	│	■ Temp		│			│	├───────────────────────────┤
	//	│	■ Windows	│			│	│FileWriter는 한글로 된			│
	//	│	■ 사용자		│			│	│문자열을 바로 출력할 수 있다.			│
	//	│	:			│			│	│							│
	//	└───────────────┘───────────┘	└───────────────────────────┘
	
	// 10라인과 11라인의 \r\n은 캐리지리턴(\r)과 라인피드(\n)로 Enter키와 동일한 역할을 하기 때문에 행을 바꾸는 역할을 한다.
}
