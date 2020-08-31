package é��11_�⺻APIŬ����.��_java.timeŬ����.��_��¥�ͽð���ü����;

public class ��¥�ͽð���ü���� {
	// java.time ��Ű������ ������ ���� ��¥�� �ð��� ǥ���ϴ� 5���� Ŭ������ �ִ�.
	
	//	Ŭ������			����
	
	//	LocalDate		���� ��¥ Ŭ����
	
	//	LocalTime		���� �ð� Ŭ����
	
	//	LocalDateTime	���� ��¥ �� �ð� Ŭ����(LocalDate + LocalTime)
	
	//	ZonedDateTime	Ư�� Ÿ����(TimeZone)�� ��¥�� �ð� Ŭ����
	
	//	Instant			Ư�� ������ Time-Stamp Ŭ����
	
	
	
	//			LocalDate
	// LocalDate�� ���� ��¥ Ŭ������ ��¥ ������ ������ �� �ִ�. LocalDate ��ü�� �� ���� ���� �޼ҵ带 ���� �� �ִµ�,
	// now()�� ��ǻ���� ���� ��¥ ������ ������ LocalDate ��ü�� �����ϰ� of()�� �Ű������� �־��� ��¥ ������ ������ ������ LocalDate ��ü�� �����Ѵ�.
	
	//	LocalDate currDate = LocalDate.now();
	//	LocalDate targetDate = LocalDate.of(int year, int month, int dayOfMonth);
	
	//			LocalTime
	// LocalTime�� ���� �ð� Ŭ������ �ð� �������� ������ �� �ִ�. LocalTime ��ü�� ���������� �� ���� ���� �޼ҵ�� ���� �� �ִµ�,
	// now()�� ��ǻ���� ���� �ð� ������ ������ LocalTime ��ü�� �����ϰ� of()�� �Ű������� �־��� �ð� ������ ������ LocalTime ��ü�� �����Ѵ�.
	
	//	LocalTime currTime = LocalTime.now();
	//	LocalTime target = LocalTime.of(int hour, int minute, int second, int nanoOfSecond);
	
	//			LocalDateTime
	// LocalDateTime�� LocalDate�� LocalTime�� ������ Ŭ������� ���� �Ǵµ�, ��¥�� �ð� ������ ��� ������ �� �ִ�.
	// LocalDateTime ��ü�� ���������� �� ���� ���� �޼ҵ�� ���� �� �ִµ�, now()�� ��ǻ���� ���� ��¥�� �ð� ������ ������ LocalDateTime
	// ��ü�� �����ϰ� of()�� �Ű������� �־��� ��¥�� �ð� ������ ������ LocalDateTime ��ü�� �����Ѵ�.
	
	//	LocalDateTime currDateTime = LocalDateTime.now();
	//	LocalDateTime targetTime = LocalDateTime.of(int year, int month, int dayOfMonth,
	//		int hour, int minute, int second, int nanoOfSecond);
	
	//			ZonedDateTime
	// ZonedDateTime�� ISO-6801 �޷� �ý��ۿ��� �����ϰ� �ִ� Ÿ����(time-zone)�� ��¥�� �ð��� �����ϴ� Ŭ�����̴�.
	// ���� ���´� 2014-04-21T07:50:24.017+09:00[Asia/Seoul]�� ���� �� �ڿ��� Ÿ������ ���� ����(����������[�����̵�])�� �߰������� �ٴ´�.
	// ��������(ZoneOffset)�� ��������� (UTC: Universal Time Coordinated)�� ���� ���� �ð�(����)�� ���Ѵ�.
	// ZonedDateTime�� now() ���� �޼ҵ忡 ZoneId�� �Ű������� �ְ� ���� �� �ִ�. ZoneId�� of() �޼ҵ�� ���� �� �ִµ�,
	// of()�� �Ű����� java.util.TimeZone�� getAvailableDs() �޼ҵ尡 �����ϴ� ��ȿ�� �� �� �ϳ��̴�.
	
	//	ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
	//	ZonedDateTime londonDateTime = ZonedDateTime.now(ZoneId.of("Europe/London");
	// 	ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul");
	
	//			Instant
	// Instant Ŭ������ ��¥�� �ð��� ������ ��ų� �����ϴµ� ������ �ʰ�, Ư�� ������ Ÿ�ӽ�����(Time-Stamp)�� ���ȴ�.
	// �ַ� Ư���� �� ���� ���� �ð��� �켱������ ���� �� ����Ѵ�. java.util.Date�� ���� ������ Ŭ����������,
	// �������� Date�� ���� ��ǻ���� ���� ��¥�� �ð� ������ �������� ������ Instant�� ���������(UTC)�� �������� �Ѵ�.
	
	//	Instant instant1 = Instant.now();
	//	Instant instant2 = Instant.now();
	//	if(instant1.isBefore(instant2)) { System.out.println("instant1�� �����ϴ�."); }
	//	else if(instant1.isAfter(instant2)) { System.out.println("instant1�� �ʽ��ϴ�."); }
	//	else { System.out.println("������ �ð��Դϴ�."); }
	//	System.out.println("����(nanos): " + instant1.until(instant2, ChronoUnit.NANOS));
	
	// �� �ڵ忡�� isBefore(), isAfter()�� �ð��� �յ� ���θ� Ȯ���ϴ� �޼ҵ��̰�, until() �޼ҵ��
	// �� ���� ���� ���̸� �����Ѵ�. �� �޼ҵ�鿡 ���� �ڼ��� ������ 11.16.4 ��¥�� �ð��� �񱳿��� ���� �� ���̴�.
	
}
