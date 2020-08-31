package 챕터11_기본API클래스.ㅇ_StringTokenizer클래스.ㄴ_StringTokenizer메소드;

public class 스트링토크니저 {
	// 문자열이 한 종류의 구분자로 연결되어 있을 경우, StringTokenizer 클래스를 사용하면 손쉽게 문자열(토큰: token)을 분리해 낼 수 있다.
	// StringTokenizer 객체를 생성할 때 첫 번째 매개값으로 전체 문자열을 주고, 두 번째 매개값으로 구분자를 주면 된다.
	
	//	StringTokenizer st = new StringTokenizer("문자열", "구분자");
	
	// 만약 구분자를 생략하면 공백(space)이 기본 구분자가 된다. 
	// 예를 들어 문자열이 "/"로 구분되어 있을 경우, 다음과 같이 StringTokenizer 객체를 생성할 수 있다.
	
	//	String text = "홍길동/이수홍/박연수";
	//	StringTokenizer st = new StringTokenizer(text, "/");
	
	// StringTokenizer 객체가 생성되면 부분 문자열을 분리해 낼 수 있는데, 
	// 다음 메소드들을 이용해서 전체 토큰 수, 남아 있는 토큰 여부를 확인한 다음 토큰을 읽으면 된다.
	
	//	메소드							설명
	
	//	int			countTokens()		꺼내지 않고 남아 있는 토큰의 수
	
	//	boolean		hasMoreTokens()		남아 있는 토큰이 있는지 여부
	
	//	String		nextToken()			토큰을 하나씩 꺼내옴
	
	// nextToken() 메소드로 토큰을 하나씩 꺼내오면 StringTokenizer 객체에는 해당 토큰이 없어진다.
	// 만약 StringTokenizer 객체에서 더 이상 가져올 토큰이 없다면 nextToken() 메소드는 java.util.NosuchElementException 예외를 발생시킨다
	// 그래서 nextToken() 메소드를 사용하기 전에 hasMoreTokens() 메소드로 꺼내올 토큰이 있는지 조사한 후 nextToken() 메소드를 호출하는 것이 좋은 방법
	
}
