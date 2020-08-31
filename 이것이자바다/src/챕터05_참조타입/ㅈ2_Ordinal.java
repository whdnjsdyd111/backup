package 챕터05_참조타입;

public class ㅈ2_Ordinal {
	public static void main(String[] args) {
		
		// ordinal 메소드는 전체 열거 객체 중 몇 번째 열거 객체인지 알려준다.
		// 열거 객체의 순번은 열거 타입을 정의할 때 주어진 순번을 말하는데, 0번 부터 시작한다.
		// 아래 코드는 today가 참조하는 열거 객체가 전체 열거 객체에서 몇 번째 순번인지 알아내는 코드이다.
		
		ㅇ_Week today = ㅇ_Week.MONDAY;
		int ordinal = today.ordinal();
		
		System.out.println("오늘은 " + (ordinal + 1) + "번째 날입니다.");
		
	}
}
