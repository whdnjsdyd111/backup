package 챕터05_참조타입;

public class ㅈ4_ValueOf {
	public static void main(String[] args) {
		
		// valueOf() 메소드는 매개값으로 주어지는 문자열과 동일한 문자열을 가지는 열거 객체를 리턴한다.
		// 이 메소드는 외부로부터 문자열을 입력받아 열거 객체로 변환할 때 유용하게 사용할 수 있다.
		// 다음 코드에서 weekDay 변수는 Week.SATURDAY 열거 객체를 참조하게 된다.
		
		String today = "SATURDAY";
		ㅇ_Week weekDay = ㅇ_Week.valueOf(today);
		System.out.println(weekDay);
		
	}
}
