package 챕터11_기본API클래스.햐_java.time클래스.ㄴ_날짜와시간에대한정보얻기;

public class 날짜와시간에대한정보얻기 {
	// LocalDate와 LocalTime은 프로그램에서 날짜와 시간 정보를 이용할 수 있도록 다음과 같은 메소드를 제공하고 있다.
	
	//	클래스		리턴 타입		메소드(매개 변수)			설명
	
	//				int			getYear()			년
	//				Month		getMonth()			Month 열거값
	//				int			getMonthValue()		월
	//	LocalDate	int			getDayOfYear		일년의 몇 번째 일
	//				int			getDayOfMonth()		월의 몇 번째 일
	//				DayOfWeek	getDayOfWeek()		요일
	//				boolean		isLeapYear()		윤년 여부
	
	//				int			getHour()			시간
	//	LocalTime	int			getMinute()			분
	//				int			getSecond()			초
	//				int			getNano()			나노초 리턴
	
	// LocalDateTime과 ZonedDateTime은 날짜와 시간 정보를 모두 갖고 있기 때문에 위 표에 나와 있는 대부분의 메소드를 가지고 있다.
	// 단, isLeapYear()는 LocalDate에만 있기 때문에 toLocalDate() 메소드로 LocalDate로 변환 후에 사용할 수 있다.
	// ZonedDateTime은 시간존에 대한 정보를 제공하는 다음 메소드들을 추가적으로 가지고 있다.
	
	//	클래스			리턴 타입			메소드(매개 변수)		설명
	
	//	ZonedDateTime	ZoneId			getZone()		존아이디를 리턴(예: Asia/Seoul)
	//					ZoneOffset		getOffset		존오프셋(시차)을 리턴
}
