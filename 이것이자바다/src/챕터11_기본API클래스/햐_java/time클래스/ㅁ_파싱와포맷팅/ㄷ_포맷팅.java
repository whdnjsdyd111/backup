package 챕터11_기본API클래스.햐_java.time클래스.ㅁ_파싱와포맷팅;

public class ㄷ_포맷팅 {
	// 다음은 날짜와 시간을 포맷팅된 문자열로 변환시키는 format() 메소드이다.
	
	//	클래스			리턴 타입			메소드(매개 변수)
	
	//	LocalDate		
	//	LocalTime
	//	LocalDateTime	String			format(DateTimeFormatter formatter)
	//	ZonedDateTime
	
	// format()의 매개값은 DateTimeFormatter인데 해당 형식대로 문자열을 리턴한다.
	// 다음은 LocalDateTime으로부터 "2024년 5월 21일 오후 6시 30분"과 같은 문자열을 얻는 코드이다.
	
	//	LocalDateTime now = LocalDateTime.now();
	//	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
	//	String nowString = now.format(dateTimeFormatter);
	
}
