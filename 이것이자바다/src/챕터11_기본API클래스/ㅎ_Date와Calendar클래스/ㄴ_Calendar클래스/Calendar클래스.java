package 챕터11_기본API클래스.ㅎ_Date와Calendar클래스.ㄴ_Calendar클래스;

public class Calendar클래스 {
	// Calendar 클래스는 달력을 표현하는 클래스이다. Calendar 클래스는 추상(abstract) 클래스이므로 new 연산자를 사용해서 인스턴스를 생성할 수 없다.
	// 그 이유는 날짜와 시간을 계산하는 방법이 지역과 문화, 나라에 따라 다르기 때문이다. 우리나라만 해도 양력과 음력이 동시에 사용되고 있다.
	// 그래서 Calendar 클래스에는 날짜와 시간을 계산하는데 꼭 필요한 메소드들만 선언되어 있고,
	// 특정한 역볍(날짜와 시간을 매기는 방법)을 따르는 계산 로직은 하위 클래스에서 구현하도록 되어 있다.
	// 특별한 역법을 사용하는 경우가 아니라면 직접 하위 클래스를 만들 필요는 없고 
	// Calendar 클래스의 정적 메소드인 getInstance() 메소드를 이용하면 
	// 현재 운영체제에 설정되어 있는 시간대(TimeZone)를 기준으로 한 Calendar 하위 객체를 얻을 수 있다.
	
	//	Calendar now = Calendar.getInstance();
	
	// Calendar 객체를 얻었다면 get() 메소드를 이용해서 날짜와 시간에 대한 정보를 얻을 수 있다.
	
	//	int year = now.get(Calendar.YEAR);
	//	int month = now.get(Calendar.MONTH) + 1;
	// 	int day = now.get(Calendar.DAY);
	//	int week = now.get(Calendar.WEEK);
	//	int amPm = now.get(Calendar.AM_PM);
	//	int hour = now.get(Calendar.HOUR);
	//	int minute = now.get(Calendar.MINUTE);
	//	int second = now.get(Calendar.SECOND);
}
