package 챕터11_기본API클래스.햐_java.time클래스.ㄹ_날짜와시간을비교하기;

public class ㄷ_날짜와시간을비교하기 {
	// 날짜와 시간 클래스 들은 다음과 같이 비교하거나 차이를 구하느 메소드들을 가지고 있다.
	
	//	클래스				리턴 타입		메소드(매개 변수)								설명
	
	//	LocalDate						isAfter(ChronoLocalDate other)			이후 날짜인지 비교
	//	LocalDateTime		boolean		isBefore(ChronoLocalDate other)			이전 날짜인지 비교
	//									isEqual(ChronoLocalDate other)			동일 날짜인지 비교
	
	//	LocalTime						isAfter(LocalTime other)				이후 시간인지 비교
	//	LocalDateTime		boolean		isBefore(LocalTime other)				이전 시간인지 ㅂ교
	
	//	LocalDate			Period		until(ChronoLocalDate endDateExclusive)	날짜 차이
	
	//	LocalDate						until(									
	//	LocalTime			long			Temporal endExclusive,				시간 차이
	//	LocalDateTime						TemporalUnit unit
	//									)
	
	//									between(
	//										LocalDate startDateInclusive,		날짜 차이
	//	Period				Period			LocalDate endDateExclusive
	//									)
	
	//									between(
	//										Temporal startInclusive,			시간 차이
	//	Duration			Duration		Temporal endExclusive
	//									)
	
	//	ChronoUnit.YEARS														전체 년 차이
	//	ChronoUnit.MONTHS														전체 달 차이
	//	ChronoUnit.WEEKS				between(								전체 주 차이
	//	ChronoUnit.DAYS		long			Temporal temporal1Inclusive,		전체 일 차이
	//	ChronoUnit.HOURS					Temporal temporal2Exclusive			전체 시간 차이
	//	ChronoUnit.SECONDS				)										전체 초 차이
	//	ChronoUnit.MILLIS														전체 밀리초 차이
	//	ChronoUnit.NANOS														전체 나노초 차이
	
	// Period와 Duration은 날짜와 시간의 양을 나타내는 클래스이다.
	// Period는 년, 달, 일의양을 나타내는 클래스이고, Duration은 시, 분, 초, 나노초의 양을 나타내는 클래스이다.
	// 이 클래스들은 D-day나 D-time을 구할 때 사용될 수 있다. 다음은 Period와 Duration에서 제공하는 메소드들이다.
	
	//	클래스		리턴 타입	메소드(매개 변수)		설명
		
	//				int		getYears()		년의 차이
	//	Period		int		getMonths()		달의 차이
	//				int		getDays()		일의 차이
	
	//				int		getSeconds()	초의 차이
	//	Duration	int		getNano()		나노초의 차이
	
	// between() 메소드는 Period와 Duration 클래스, 그리고 ChronoUnit 열거 타입에도 있다.
	// Period와 Duration의 between()은 년, 달, 일, 초의 단순 차이를 리턴하고, 
	// ChronoUnit 열거 타입의 between()은 전체 시간을 기준으로 차이를 리턴한다.
	// 예를 들어 2023년 1월과 2024년 3월의 달의 차이를 구할 때 Period의 between()은 2가 되고, ChronoUnit.MONTHS.between()은 14가 된다.
}
