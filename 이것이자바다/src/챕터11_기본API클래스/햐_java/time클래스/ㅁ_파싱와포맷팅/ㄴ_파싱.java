package 챕터11_기본API클래스.햐_java.time클래스.ㅁ_파싱와포맷팅;

public class ㄴ_파싱 {
	// 다음은 날짜와 시간 정보가 포함된 문자열을 파싱해서 날짜와 시간을 생성하는 두 개의 parse() 정적 메소드이다.
	
	//	클래스			리턴 타입			메소드(매개 변수)
	
	//	LocalDate		LocalDate
	//	LocalTime		LocalTime		parse(CharSequence)
	//	LocalDateTime	LocalDateTime
	//	ZonedDateTime	ZonedDateTime	parse(CharSequence, DateTimeFormatter)
	
	// LocalDate의 parse(CharSequence) 메소드는 기본적으로 ISO_LOCAL_DATE 포맷터를 사용해서 문자열을 파싱한다.
	// ISO_LOCAL_DATE는 DateTimeFormatter의 상수로 정의되어 있는데, "2024-05-03" 형식의 포맷터이다.
	
	//	LocalDate localDate = LocalDate.parse("2024-05-03");
	
	// 만약 다른 포맷터를 이용해서 문자열을 파싱하고 싶다면 parse(CharSequence, DateTimeFormatter) 메소드를 사용할 수 있다.
	// DateTimeFormatter는 ofPattern() 메소드로 정의할 수도 있는데,
	// 다음 코드는 "2024.05.21"형식의 DateTimeFormatter를 정의하고 문자열을 파싱했다.
	
	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
	// LocalDate localDate = LocalDate.parse("2024.05.21", formatter);
	
	// ofPattern() 메소드의 매개값으로 사용되는 패턴 기호에 대한 설명은 API 도큐먼트의 java.time.format.DateTimeFormatter 클래스 설명 부분에
	// "Pattern for Formatting and Parsing"이란 제목으로 잘 나와 있다.
	// DateTimeFormatter에는 표준화돈 포맷터들이 다음과 같이 상수로 미리 정의되어 있기 때문에 ofPattern() 메소드를 사용하지 않고 바로 이용할 수 있다.
	
	//	상수						설명									예
	
	//	BASIC_ISO_DATE			BASIC ISO date						"20111203"
	
	//	ISO_LOCAL_DATE			ISO Local Date						"2011-12-03"
	
	//	ISO_OFFSET_DATE			ISO Date with offset				"2011-12-03+01:00"
	
	//	ISO_DATE				ISO Date with or without offset		"2011-12-03+01:00";"2011-12-03"
	
	//	ISO_LOCAL_TIME			Time without offset					"10:15:30"
	
	//	ISO_OFFSET_TIME			Time with offset					"10:15:30+01:00"
	
	//	ISO_TIME				Time with or without offset			"10:15:30+01:00";"10:15:30"
	
	//	ISO_LOCAL_DATE_TIME		ISO Local Date and Time				"2011-12-03T10:15:30"
	
	//	ISO_OFFSET_DATE_TIME	Date Time with Offset				"2011-12:03T10:15:30+01:00"
	
	//	ISO_ZONED_DATE_TIME		Zoned Date Time						"2011-12-03T10:15:30+01:00[Europe/Paris]"
	
	//	ISO_DATE_TIME			Date and time with ZoneId			"2011-12-03T10:15:30+01:00[Europe/Paris]"
	
	//	ISO_ORDINAL_DATE		Year and day of year				"2012-337"
	
	//	ISO_WEEK_DATE			Year and Week						"2012-W48-6"
	
	//	ISO-INSTANT				Date and Time of an Instant			"2011-12-03T10:15:30Z"
	
	//	RFC_1123_DATE_TIME		RFC 1123 / RFC 822					"Tue, 3 Jun 2008 11:05:30 GMT"
	
	// 예를 들어 parse(CharSequence)와 동일하게 "2024-05-21"이라는 문자열을 파싱해서 LocalDate 객체를 얻고 싶다면 다음코드를 작성하면 된다.
	
	//	LocalDate localDate = LocalDate.parse("2024-05-21", DateTimeFormatter.ISO_LOCAL_DATE);
	
	// 만약 포맷터의 형식과 다른 문자열을 파싱하게 되면 DateTiomeParseException이 발생한다.
	
	//	ISO_WEEK_DATE
	
	//	ISO_INSTANT
	
	//	RFC_1123_DATE_TIME
	
}
