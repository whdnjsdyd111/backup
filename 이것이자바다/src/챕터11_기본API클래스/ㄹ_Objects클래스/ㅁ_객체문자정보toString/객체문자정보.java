package 챕터11_기본API클래스.ㄹ_Objects클래스.ㅁ_객체문자정보toString;

public class 객체문자정보 {
	// Objects.toString()은 객체의 문자 정보를 리턴하는데, 다음 두 가지로 오버로딩되어있다.
	
	//	리턴 타입			메소드(매개 변수)								설명
	//	String			toString(Object o)						not null -> o.toString()
	//															null -> "null"
	
	//	String			toString(Object o, String nullDefault)	not null -> o.toString()
	//															null -> nullDefault
}
