package 챕터11_기본API클래스.ㄱ_자바API도큐먼트;

public class 자바API도큐먼트 {
	// API는 라이브러리라고도 부르기도 하는데, 플그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음을 말한다.
	// 우리가 사용해 왔던 String 클래스와 System 클래스도 모두 API에 속하는 클래스들이다.
	// 이 API들은 <JDK 설치 경로> \jre\lib\rt.jar 라는 압축 파일에 저장되어 있다.
	
	// API 도큐먼트는 쉽게 API를 찾아 이용할수 있도록 문서화한 것을 말한다. 
	// API 도큐먼트는 HTML 페이지로 작성되어 있기 때문에 웹 브라우저를 열고 오라클에서 제공하는 다음 URL을 방문하면 볼수 있다.
	// http://docs.oracle.com/javase/8/docs/api 즐겨찾기에 추가해서 쉽게 열어 볼 수 있도록 해놓자
	
	// API 도큐먼트는 세 개의 프레임으로 나뉘어져 있다. 
	// 좌측 상단의 프레임에는 패키지 전체 목록을 보여준다. 
	// 좌측 하단 프레임에는 패키지에 속하는 클래스와 인터페이스 목록을 보여준다.
	// 중앙 프레임에는 좌측 하단 프레임에서 선택한 클래스나 인터페이스에 대한 상세 설명을 보여준다.
	// 예를 들어 String 클래스의 상세 설명을 보고 싶다면, 좌측 상단 프레임에서 java.lang을 클릭하고,
	// 좌측 하단 프레임에서 String을 클릭하면 중앙 프레임에서 String 클래스에 대한 상세 설명을 볼 수 있다.
	
	// 중앙 프레임의 내용은 크게 세부분으로 구분된다. 상단 부분은 클래스가 포함된 패키지 정보, 상속 정보, 인터페이스 구현 정보를 표시한다.
	// 중앙 부분은 클래스의 설명과 사용 방법을 간략하게 보여준다. 하단 부분은 필드, 생성자, 메소드의 목록을 보여준다.
	// 클래스가 가지고 있는 중첩 클래스, 필드, 생성자, 메소드의 목록으로 바로 가고 싶다면 
	// 상단의 Summary 부분에 있는 Nested|Field|Method 링크를 바로 클릭하면 된다.
	// 다음은 String 클래스의 Field Summary 내용을 보여준다. 필드에 대한 상세한 설명을 읽고 싶다면 필드 이름을 클릭하면 된다.
	
	// Field Summary
	//	 Fields
	//	Modifier and Type			Field and Description
	//	static Comparator<String>	CASE_INSENSITIVE_ORDER
	//								A Comparator that orders String objects as by compareToIgnoreCase.
	
	// 다음은 String 클래스의 Constructor Summary 내용을 보여준다.
	// 생성자 이름과 매개 변수 타입 그리고 간단한 설명이 기술되어 있다. 생성자에 대한 상세한 설명을 읽고 싶다면 생성자를 클릭하면 된다.
	
	// Constructor Summary
	//	 Constructors
	//	Constructor and Description
	//	String()
	//	Initializes a newly created String object so that it represents an empty character sequence.
	//	String(byte[] bytes)
	// Constructs a new String by decoding the specified array of bytes using the platform's default charset.
	
	// 다음은 String 클래스의 Method Summary 내용을 보여준다. 메소드의 접근 제한자와 리턴 타입 그리고 메소드 이름과 매개 변수에 대한 정보를 볼 수 있다.
	// 메소드에 대한 상세한 설명을 읽고 싶다면 메소드의 이름을 클릭하면 된다.
	
	//	Method Summary
	//	 All Methods	 Static Methods	 Instance Methods	 Concrete Methods	 Deprecated Methods
	//	Modifier and Type	Method and Description
	//	char				charAt(int index)
	//						Returns the char value at the specified index
	//	int					codePointAt(int index)
	//						Returns the character (Unicode code point) at the specified index
	
	// 이클립스에서는 좀 더 편한 방법으로 API 도큐먼트를 볼 수 있다. 자바 에디터에서 클래스를 마우스로 선택한 다음 F1 키를 누르면 자동으로 API 도큐먼트를 보여준다.
	// Help 뷰에서 해당 클래스를 클릭하면 API 도큐먼트를 보여준다.
	
	public static void main(String[] args) {
		String name = "홍길동";
		System.out.println(name);
	}
	
	// 지금까지 자바 API 도큐먼트를 읽는 방법에 대해 살펴보았다. 영문으로 되어 있어 다소 읽기가 힘들다. 
	// 한글로 기계번역한 사이트도 있지만 영문으로 보는 것을 권장한다. 정확한 영문 용어를 알아두는 것이 프로그램 작성에 도움이 되기 때문이다.
}
