package 챕터11_기본API클래스.햐_java.time클래스.ㄷ_날짜와시간을조작하기;

public class ㄱ_빼기와더하기 {
	// 날짜와 시간 클래스들은 날짜와 시간을 조작하는 메소드와 상대 날짜를 리턴하는 메소드들을 가지고 있다.
	
	//			빼기와 더하기
	// 다음은 날짜와 시간을 빼거나 더하는 메소드들이다.
		
	//	클래스			리턴 타입			메소드(매개 변수)			설명
		
	//									minusYears(long)	년 빼기
	//	LocalDate		LocalDate		minusMonths(long)	달 빼기
	//	LocalDateTime	LocalDateTime	minusDays(long)		일 빼기
	//	ZonedDateTime	ZonedDateTime	minusWeeks(long)	주 빼기
	//									plusYears(long)		년 더하기
	//									plusMonths(long)	달 더하기
	//									plusDays(long)		일 더하기
	//									plusWeeks(long)		주 더하기
		
	//									minusHours(long)	시간 빼기
	//									minusMinutes(long)	분 빼기
	//	LocalTime		LocalTime		minusSecond(long)	초 빼기
	//	LocalDateTime	LocalDateTime	minusNanos(long)	나노초 빼기
	//	ZonedDateTime	ZonedDateTime	plusHours(long)		시간 더하기
	//									plusMinutes(long)	분 더하기
	//									plusSecond(long)	초 더하기
	//									plusNanos(long)		나노초 더하기
	
	// 각 메소드들은 수정된 LocalDate, LocalTime, LocalDateTime, ZonedDateTime을 리턴하기 때문에 
	// 도트(,) 연산자로 연결해서 순차적으로 호출할 수 있다.
}
