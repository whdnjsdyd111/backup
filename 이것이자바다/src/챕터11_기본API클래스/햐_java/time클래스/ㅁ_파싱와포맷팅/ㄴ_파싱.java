package é��11_�⺻APIŬ����.��_java.timeŬ����.��_�Ľ̿�������;

public class ��_�Ľ� {
	// ������ ��¥�� �ð� ������ ���Ե� ���ڿ��� �Ľ��ؼ� ��¥�� �ð��� �����ϴ� �� ���� parse() ���� �޼ҵ��̴�.
	
	//	Ŭ����			���� Ÿ��			�޼ҵ�(�Ű� ����)
	
	//	LocalDate		LocalDate
	//	LocalTime		LocalTime		parse(CharSequence)
	//	LocalDateTime	LocalDateTime
	//	ZonedDateTime	ZonedDateTime	parse(CharSequence, DateTimeFormatter)
	
	// LocalDate�� parse(CharSequence) �޼ҵ�� �⺻������ ISO_LOCAL_DATE �����͸� ����ؼ� ���ڿ��� �Ľ��Ѵ�.
	// ISO_LOCAL_DATE�� DateTimeFormatter�� ����� ���ǵǾ� �ִµ�, "2024-05-03" ������ �������̴�.
	
	//	LocalDate localDate = LocalDate.parse("2024-05-03");
	
	// ���� �ٸ� �����͸� �̿��ؼ� ���ڿ��� �Ľ��ϰ� �ʹٸ� parse(CharSequence, DateTimeFormatter) �޼ҵ带 ����� �� �ִ�.
	// DateTimeFormatter�� ofPattern() �޼ҵ�� ������ ���� �ִµ�,
	// ���� �ڵ�� "2024.05.21"������ DateTimeFormatter�� �����ϰ� ���ڿ��� �Ľ��ߴ�.
	
	// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
	// LocalDate localDate = LocalDate.parse("2024.05.21", formatter);
	
	// ofPattern() �޼ҵ��� �Ű������� ���Ǵ� ���� ��ȣ�� ���� ������ API ��ť��Ʈ�� java.time.format.DateTimeFormatter Ŭ���� ���� �κп�
	// "Pattern for Formatting and Parsing"�̶� �������� �� ���� �ִ�.
	// DateTimeFormatter���� ǥ��ȭ�� �����͵��� ������ ���� ����� �̸� ���ǵǾ� �ֱ� ������ ofPattern() �޼ҵ带 ������� �ʰ� �ٷ� �̿��� �� �ִ�.
	
	//	���						����									��
	
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
	
	// ���� ��� parse(CharSequence)�� �����ϰ� "2024-05-21"�̶�� ���ڿ��� �Ľ��ؼ� LocalDate ��ü�� ��� �ʹٸ� �����ڵ带 �ۼ��ϸ� �ȴ�.
	
	//	LocalDate localDate = LocalDate.parse("2024-05-21", DateTimeFormatter.ISO_LOCAL_DATE);
	
	// ���� �������� ���İ� �ٸ� ���ڿ��� �Ľ��ϰ� �Ǹ� DateTiomeParseException�� �߻��Ѵ�.
	
	//	ISO_WEEK_DATE
	
	//	ISO_INSTANT
	
	//	RFC_1123_DATE_TIME
	
}
