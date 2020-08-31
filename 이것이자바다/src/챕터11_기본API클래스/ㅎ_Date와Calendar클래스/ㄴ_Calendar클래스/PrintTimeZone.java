package 챕터11_기본API클래스.ㅎ_Date와Calendar클래스.ㄴ_Calendar클래스;

import java.util.TimeZone;

public class PrintTimeZone {
	// 다른 시간대에 해당하는 날짜와 시간을 출력하기 위해서는 어떻게 해야할까?
	// 예를 들어 미국/로스엔젤리스의 현재 날짜와 시간을 출력하기 위해서는 어떻게 해야 할까?
	// 운영체제의 시간대를 다른 시간대로 바꾸는 것도 한 가지 방법일 수 있지만, 
	// Calendar 클래스의 오버로딩된 다른 getInstance() 메소드를 이용하면 간단하게 다른 시간대의 Calendar를 얻을 수 있다.
	// 알고싶은 시간대의 java.util.TimeZone 객체를 얻어 Calendar.getInstance() 메소드의 매개값으로 넘겨주면 된다.
	
	//	TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
	//	Calendar now = Calendar.getInstance( timeZone );
	
	// TimeZone.getInstance() 메소드의 매개값은 TimeZone 클래스의 정적 메소드인
	// getAvailableIDs()를 호출하여 얻은 시간대 문자열 중 하나를 사용하면 된다.
	// getAvailableIDs() 메소드의 리턴 타입은 String 배열이기 때문에 다음 프로그램을 이용해서 시간대 문자열 목록을 볼 수 있다.
	
	public static void main(String[] args) {
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id : availableIDs) {
			System.out.println(id);
		}
	}
}
