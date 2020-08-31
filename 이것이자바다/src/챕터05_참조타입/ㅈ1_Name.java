package 챕터05_참조타입;

public class ㅈ1_Name {
	public static void main(String[] args) {
		
		// name() 메소드는 열거 객체가 가지고 있는 문자열을 리턴한다.
		// 아래 코드는 today가 참조하는 열거 객체에서 name() 메소드를 호출하여 문자열을 얻어낸다.
		// name() 메소드는 열거 객체 내부의 문자열인 "SUNDAY"를 리턴하고 name 변수에 저장한다.
		
		ㅇ_Week today = ㅇ_Week.SUNDAY;
		String name = today.name();
		
		System.out.println(name);
		
	}
}
