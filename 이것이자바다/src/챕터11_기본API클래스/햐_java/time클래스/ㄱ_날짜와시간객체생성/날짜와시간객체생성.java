package 챕터11_기본API클래스.햐_java.time클래스.ㄱ_날짜와시간객체생성;

public class 날짜와시간객체생성 {
	// java.time 패키지에는 다음과 같이 날짜와 시간을 표현하는 5개의 클래스가 있다.
	
	//	클래스명			설명
	
	//	LocalDate		로컬 날짜 클래스
	
	//	LocalTime		로컬 시간 클래스
	
	//	LocalDateTime	로컬 날짜 및 시간 클래스(LocalDate + LocalTime)
	
	//	ZonedDateTime	특정 타임존(TimeZone)의 날짜와 시간 클래스
	
	//	Instant			특정 시점의 Time-Stamp 클래스
	
	
	
	//			LocalDate
	// LocalDate는 로컬 날짜 클래스로 날짜 정보만 저장할 수 있다. LocalDate 객체는 두 가지 정적 메소드를 얻을 수 있는데,
	// now()는 컴퓨터의 현재 날짜 정보를 저장한 LocalDate 객체를 리턴하고 of()는 매개값으로 주어진 날짜 정보를 정보를 저장한 LocalDate 객체를 리턴한다.
	
	//	LocalDate currDate = LocalDate.now();
	//	LocalDate targetDate = LocalDate.of(int year, int month, int dayOfMonth);
	
	//			LocalTime
	// LocalTime은 로컬 시간 클래스로 시간 정보만을 저장할 수 있다. LocalTime 객체도 마찬가지로 두 가지 정적 메소드로 얻을 수 있는데,
	// now()는 컴퓨터의 현재 시간 정보를 저장한 LocalTime 객체를 리턴하고 of()는 매개값으로 주어진 시간 정보를 저장한 LocalTime 객체를 리턴한다.
	
	//	LocalTime currTime = LocalTime.now();
	//	LocalTime target = LocalTime.of(int hour, int minute, int second, int nanoOfSecond);
	
	//			LocalDateTime
	// LocalDateTime은 LocalDate와 LocalTime을 결합한 클래스라고 보면 되는데, 날짜와 시간 정보를 모두 저장할 수 있다.
	// LocalDateTime 객체도 마찬가지로 두 가지 정적 메소드로 얻을 수 있는데, now()는 컴퓨터의 현재 날짜와 시간 정보를 저장한 LocalDateTime
	// 객체를 리턴하고 of()는 매개값으로 주어진 날짜와 시간 정보를 저장한 LocalDateTime 객체를 리턴한다.
	
	//	LocalDateTime currDateTime = LocalDateTime.now();
	//	LocalDateTime targetTime = LocalDateTime.of(int year, int month, int dayOfMonth,
	//		int hour, int minute, int second, int nanoOfSecond);
	
	//			ZonedDateTime
	// ZonedDateTime은 ISO-6801 달력 시스템에서 정의하고 있는 타임존(time-zone)의 날짜와 시간을 저장하는 클래스이다.
	// 저장 형태는 2014-04-21T07:50:24.017+09:00[Asia/Seoul]와 같이 맨 뒤에서 타임존에 대한 정보(±존오프셋[존아이디])가 추가적으로 붙는다.
	// 존오프셋(ZoneOffset)은 협정세계시 (UTC: Universal Time Coordinated)와 차이 나는 시간(시차)을 말한다.
	// ZonedDateTime은 now() 정적 메소드에 ZoneId를 매개값으로 주고 얻을 수 있다. ZoneId는 of() 메소드로 얻을 수 있는데,
	// of()의 매개값은 java.util.TimeZone의 getAvailableDs() 메소드가 리턴하는 유효한 값 중 하나이다.
	
	//	ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
	//	ZonedDateTime londonDateTime = ZonedDateTime.now(ZoneId.of("Europe/London");
	// 	ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul");
	
	//			Instant
	// Instant 클래스는 날짜와 시간의 정보를 얻거나 조작하는데 사용되지 않고, 특정 시점의 타임스탬프(Time-Stamp)로 사용된다.
	// 주로 특정한 두 시점 간의 시간적 우선순위를 따질 때 사용한다. java.util.Date와 가장 유사한 클래스이지만,
	// 차이점은 Date는 로컬 컴퓨터의 현재 날짜와 시간 정보를 기준으로 하지만 Instant는 협정세계시(UTC)를 기준으로 한다.
	
	//	Instant instant1 = Instant.now();
	//	Instant instant2 = Instant.now();
	//	if(instant1.isBefore(instant2)) { System.out.println("instant1이 빠릅니다."); }
	//	else if(instant1.isAfter(instant2)) { System.out.println("instant1이 늦습니다."); }
	//	else { System.out.println("동일한 시간입니다."); }
	//	System.out.println("차이(nanos): " + instant1.until(instant2, ChronoUnit.NANOS));
	
	// 위 코드에서 isBefore(), isAfter()는 시간의 앞뒤 여부를 확인하는 메소드이고, until() 메소드는
	// 두 시점 간의 차이를 리턴한다. 이 메소드들에 대한 자세한 설명은 11.16.4 날짜와 시간을 비교에서 살펴 볼 것이다.
	
}
