package 챕터11_기본API클래스.햐_java.time클래스.ㄷ_날짜와시간을조작하기;

public class ㄴ_변경하기 {
	// 다음은 날짜와 시간을 변경하는 메소드들이다.
	
	//	클래스				리턴 타입				메소드								설명
	//
	//											withYear(int)						년 변경
	//	LocalDate			LocalDate			withMonth(int)						월 변경
	//	LocalDateTime		LocalDtaTime		withDayOfMonth(int)					월의 일 변경
	//	ZonedDateTime		ZonedDateTime		withDayOfYear(int)					년의 일 변경
	//											with(TemporalAdjuster adjuster)		상대 변경
	//
	//	LocalTime			LocalDate			withHour(int)						시간 변경
	//	LocalDateTime		LocalDateTime		withMinute(int)						분 변경
	//	ZonedDateTime		ZonedDateTime		withSecond(int)						초 변경
	//											withNano(int)						나노초 변경
	
	// with(temporalAdjuster adjuster) 메소드를 제외한 나머지는 메소드 이름만 보면 어떤 정보를 수정하는지 알 수 있다.
	// with() 메소드는 상대 변경이라고 설명되어 있는데, 이것은 현재 날짜를 기준으로 해의 첫 번째 일 또는 마지막일, 달의 첫 번째 일 또는 마지막 일, 
	// 달의 첫번째 요일, 지난 요일 및 돌아오는 요일 등 상대적인 날짜를 리턴한다. 매개값은 TemporalAdjuster 타입으로 다음표에 있는
	// TemporalAdjuster의 정적 메소드를 호출하면 얻을 수 있다.
	
	//	리턴 타입				메소드(매개 변수)								설명
	//						
	//						firstDayOfYear()						이번 해의 첫번째 일
	//						lastDayOfYear()							이번 해의 마지막 일
	//						firstDayOfNextYear()					다음 해의 첫 번째 일
	//						firstDayOfMonth()						이번 달의 첫 번째 일
	//						lastDayOfMonth()						이번 달의 마지막 일
	//	TemporalAdjuster	firstDayOfNextMonth						다음 달의 첫 번째 일
	//						firstlnMonth(DayOfWeek dayOfWeek)		이번 달의 첫 번째 요일
	//						lastlnMonth(DayOfWeek dayOfWeek)		이번 달의 마지막 요일
	//						next(DAyOfWeek dayOfWeek)				돌아오는 요일
	//						nextOrSame(DayOfWeek dayOfWeek)			돌아오는 요일(오늘 포함)
	//						previous(DayOfWeek dayOfWeek)			지난 요일
	//						previousOrSame(DayOfWeek dayOfWeek)		지난 요일(오늘 포함)
	
}
