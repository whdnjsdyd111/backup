package 챕터10_예외처리;

public class ㅁ_ClosingAutomicResource {
	// 자바 7 에서 새로 추가된 try - with - resources를 사용하면 예외 발생 여부와 상관없이 
	// 사용했던 리소스 객체(각종 입출력 스트림, 서버 소켓, 소켓, 각종 채널)의 close() 메소드를 호출해서 안전하게 리소스를 닫아준다.
	// 리소스라는 말이 생소하게 들릴지도 모르겠다. 리소스란 여러 가지 의미가 있지만 여기서는 데이터를 읽고 쓰는 객체라고 생각하면 된다.
	// 예를 들어 파일의 데이터를 읽는 FileInputStream 객체와 파일에 쓰는 FileOutputStream은 리소스 객체라고 보면 된다.
	// 다음은 리소스 객체를 안전하게 닫기 위해 자바 6 이전까지 사용했던 코드이다.
	
	//	FileInputStream fis = null;
	//	try {
	//		fis = new FileInputStream("file.txt");
	//		...
	//	} catch(IOException e) {
	//		...
	//	} finally {
	//		if(fis != null) {
	//			try { 
	//				fis.close();
	//			} catch (IOException e) {}
	//		}
	//	}
	
	// finally 블록에서 다시 try - catch를 사용해서 close() 메소드를 예외 처리해야 하므로 다소 복잡하게 보인다. 자바 7 에서 추가된 try - with - resources를 사용하면 다음과 같이 간단해진다.
	// 어디를 봐도 close()를 명시적으로 호출한 곳이 없다.
	
	//	try(FileInputStream fis = new FileInputStream("file.txt")) {
	//		...
	//	} catch(IOException e) {
	//		...
	//	}
	
	// try 블록이 정상적으로 실행을 완료했거나 도중에 예외가 발생하게 되면 자동으로 FileInputStream의 close() 메소드가 호출된다.
	// try{}에서 예외가 발생하면 우선 close()로 리소스를 닫고 catch 블록을 실행한다. 만약 복수 개의 리소스를 사용해야 한다면 다음과 같이 작성할 수 있다.
	
	//	try(
	//		FileInputStream fis = new FileInputStream("file1.txt");
	//		FileOutputStream fos = new FileOutputStream(file2.txt");
	//	){
	//		...
	//	} catch(IOException e) {
	//		...
	//	}
	
	// try - with - resources를 사용하기 위해서는 조건이 있는데, 리소스 객체는 java.lang.AutoCloseable 인터페이스를 구현하고 있어야 한다.
	// AutoCloseable에는 close() 메소드가 정의되어 있는데 try - with - resources는 바로 이 close() 메소드를 자동 호출한다.
	// API 도큐먼트에서 AutoCloseable 인터페이스를 찾아 "All Known Implements Classes:"를 보면 try - with - resources와 함께 사용할 수 있는 리소스가 어떤 것이 있는지 알 수 있다.
	// 다음 예제는 직접 AutoCloseable을 구현해서 FileInputStream 클래스를 작성했다. TryWithResourceExample 클래스의 main() 메소드가
	// try - with - resources를 사용하면 예외가  발생하는 즉시 자동으로 FileInputStream의 close()가 호출되는 것을 볼 수 있다.
}
