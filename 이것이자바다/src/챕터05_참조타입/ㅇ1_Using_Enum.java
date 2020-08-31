package 챕터05_참조타입;

import java.util.Calendar;

public class ㅇ1_Using_Enum {
	public static void main(String[] args) {
		
		// 열거 타입을 선언하는 방법
		
		// 열거타입 변수;
		
		ㅇ_Week today;
		
		// 열거 타입 변수를 선언했다면 다음과 같이 열거 상수를 저장할 수 있다.
		// 열거 상수는 단독으로 사용할 수는 없고 반드시 열거타입.열거상수로 사용된다.
		
		// 열거타입 변수 = 열거타입.열거상수;
		// 예로 tomorrow에 열거 상수인 SUNDAY를 저장할 수 있다.
		
		ㅇ_Week tomorrow = ㅇ_Week.SUNDAY;
		
		// 열거 타입 변수는 null 값을 저장할 수 있는데 열거 타입도 참조 타입이기 때문이다.
		
		ㅇ_Week birthday = null;
		
		// 그럼 메소드에 생성된 열거 상수는 어떨까? 총 7개의 상수는 Week의 객체로 생성되고 메소드 영역에 생성된 열거 상수가 해당 Week 객체를 각각 참조하게 된다.
		
		System.out.println(tomorrow == ㅇ_Week.SUNDAY);	// true
		
		// tomorrow는 스택영역에  생성된다. tomorrow에 저장된 겂운 Week.SUNDAY 열거 상수가 참조하는 번지이므로 둘은 같은 번지를 참조하게 된다.
		
		ㅇ_Week tomorrow1 = ㅇ_Week.SUNDAY;
		
		System.out.println(tomorrow == tomorrow1); // true
		
	}
}
