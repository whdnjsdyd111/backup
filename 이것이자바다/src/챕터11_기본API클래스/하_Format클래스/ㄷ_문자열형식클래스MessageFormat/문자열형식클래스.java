package 챕터11_기본API클래스.하_Format클래스.ㄷ_문자열형식클래스MessageFormat;

public class 문자열형식클래스 {
	// 데이터를 파일에 저장하거나, 네크워크로 전송할 때, 그리고 데이터베이스 SQL문을 작성할 때 등 많은 부분에서 일정한 형식의 문자열을 사용한다.
	// MessageFormat 클래스를 사용하면 문자열에 데이터가 들어갈 자리를 표시해 두고, 프로그램이 실행하면서 동적으로 데이터를 삽입해 문자열을 완성시킬 수 있따.
	// 예를 들어 다음과 같이 회원 정보를 출력한다고 가정해보자.
	
	//	회원 ID: blue
	//	회원 이름: 신용권
	//	회원 전화: 010-123-1234
	
	// 만약 id, name, tel이라는 변수에 회원 정보가 저장되어 있을 경우 다음과 같이 문자열 연결 연산자(+)로 출력할 문자열을 생성할 수 있을 것이다.
	
	//	String result = "회원 ID: " + id + "\n회원 이름: " + name + "\n회원 전화: " + tel;
	
	// 이 방법도 나쁘진 않지만, + 연산자로 인해 복잡해 보이고, 전체 문자열을 파악하기 힘들다.
	// 다음과 같이 MessageFormat 클래스를 사용하면 좀 더 깔끔하게 데이터를 삽입시켜주고 전체 문자열을 쉽게 예측할 수 있다.
	
	//	String message = "회원 ID: {0} \n회원 이름: {1} \n회원 전화: {2}";
	//	String result = MessageFormat.format(message, id, name, tel);
	
	// MessageFormat은 정적 format() 메소드를 호출해서 완성된 문자열을 리턴시킨다.
	// format() 메소드의 첫 번째 매개값은 매개 변수화된 문자열을 지정하고, 두 번째 이후의 매개값은 인덱스 순서에 맞게 값을 나열하면 된다.
	// 값을 나열하는 대신, 다음과 같이 배열을 대입해도 좋다.
	
	//	String text = "회원 ID: {0} \n회원 이름: {1} \n회원 전화: {2}";
	//	Object[] arguments = { id, name, tel };
	//	String result = MessageFormat.format(text, arguments};
}
