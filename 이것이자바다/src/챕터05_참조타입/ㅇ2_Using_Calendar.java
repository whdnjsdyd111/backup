package 챕터05_참조타입;

import java.util.Calendar;

public class ㅇ2_Using_Calendar {
	public static void main(String[] args) {
		
		// 자바는 컴퓨터의 날짜 및 요일, 시간을 프로그램에서 사용할 수 있도록 하기 위해 Date, Calendar, LocalDateTime 등의 클래스를 제공한다.
		// LocalDateTime은 자바8 부터 지원하는 API이다. 그래서 이전 버전들과도 호환성을 위해 Calendar를 이용해서 날짜와 시간을 얻는 방법을 알아보자.
		// Calendar를 사용하기 위해서는 import문이 필요하다.
				
		// 우선 Calendar 변수를 선언하고 Calendar.getInstance() 메소드가 리턴하는 Calendar 객체를 얻는다.
				
		Calendar now = Calendar.getInstance();
				
		// Calendar 객체를 얻었다면 get() 메소드를 이용해서 년, 월, 일, 요일, 시간, 분, 초를 다음과 같이 얻을 수 있다.
				
		int year = now.get(Calendar.YEAR);			// 년
		int month = now.get(Calendar.MONDAY);		// 월 (1 ~ 12)
		int day = now.get(Calendar.DAY_OF_MONTH);	// 일
		int week = now.get(Calendar.DAY_OF_WEEK);	// 요일 (1 ~ 7)
		int hour = now.get(Calendar.HOUR);			// 시간
		int minute = now.get(Calendar.MINUTE);		// 분
		int second = now.get(Calendar.SECOND);		// 초
		
		// 이제 Calendar과 Week을 사용해보자.
		
		ㅇ_Week today = null;
		
		switch(week) {
		case 1:
			today = ㅇ_Week.SUNDAY;
			break;
		case 2:
			today = ㅇ_Week.MONDAY;
			break;
		case 3:
			today = ㅇ_Week.TUESDAY;
			break;
		case 4:
			today = ㅇ_Week.WEDNESDAY;
			break;
		case 5:
			today = ㅇ_Week.THURSDAY;
			break;
		case 6:
			today = ㅇ_Week.FRIDAY;
			break;
		case 7:
			today = ㅇ_Week.SATURDAY;
		}
		
		System.out.println("오늘 요일: " + today);
	}
}
