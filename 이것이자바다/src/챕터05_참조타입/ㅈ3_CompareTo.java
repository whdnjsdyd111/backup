package 챕터05_참조타입;

public class ㅈ3_CompareTo {
	public static void main(String[] args) {
		
		// compareTo() 메소드는 매개값으로 주어진 열거 객체를 기준으로 전후로 몇 번째 위치하는 지를 비교한다.
		// 만약 열거 객체가 매개값의 열거 객체보다 순번이 빠르다면 음수가, 순번이 늦는다면 양수가 리턴된다.
		
		ㅇ_Week day1 = ㅇ_Week.MONDAY;
		ㅇ_Week day2 = ㅇ_Week.WEDNESDAY;
		
		int result1 = day1.compareTo(day2);	// -2
		int result2 = day2.compareTo(day1);	// 2
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
	}
}
