package 챕터11_기본API클래스.ㅅ_String클래스.ㄱ_String생성자;

public class String생성자 {
	// 자바의 문자열은 java.lang 패키지의 String 클래스의 인스턴스로 관리된다.
	// 소스상에서 문자열 리터럴은 String 객체로 자동 생성되지만, String 클래스의 다양한 생성자를 이용해서 직접 String 객체를 생성할 수도 있다.
	// String 클래스는 Deprecated(비권장)된 생성자를 제외하고 약 13개의 생성자를 제공한다.
	// Deprecated는 예전 자바 버전에서는 사용되었으나, 현재 버전과 차후 버전에서는 사용하지 말라는 뜻이다.
	// 어떤 생성자를 이용해서 String 객체를 생성할지는 제공되는 매개값의 타입에 달려있다.
	// 다음은 사용 빈도수가 높은 생성자들이다. 파일의 내용을 읽거나, 네트워크를 통해 받은 데이터는 보통 byte[] 배열이므로 이것을 문자열로 변환하기 위해 사용된다.
	
	// 배열전체를 String 객체로 생성
	//	String str = new String(byte[] bytes);
	// 지정한 문자셋으로 디코딩
	//	String str = new String(byte[] bytes, String charseName);
	
	// 배열의 offset 인덱스 위치부터 length 만큼 String 객체로 생성
	//	String str = new String(byte[] bytes, int offset, int length);
	// 지정한 문자셋으로 디코딩
	//	String str = new String(byte[] bytes, int offset, int length, String charseName)
}
