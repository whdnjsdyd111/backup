package é��11_�⺻APIŬ����.��_java.timeŬ����.��_��¥�ͽð��������ϱ�;

public class ��_�����ϱ� {
	// ������ ��¥�� �ð��� �����ϴ� �޼ҵ���̴�.
	
	//	Ŭ����				���� Ÿ��				�޼ҵ�								����
	//
	//											withYear(int)						�� ����
	//	LocalDate			LocalDate			withMonth(int)						�� ����
	//	LocalDateTime		LocalDtaTime		withDayOfMonth(int)					���� �� ����
	//	ZonedDateTime		ZonedDateTime		withDayOfYear(int)					���� �� ����
	//											with(TemporalAdjuster adjuster)		��� ����
	//
	//	LocalTime			LocalDate			withHour(int)						�ð� ����
	//	LocalDateTime		LocalDateTime		withMinute(int)						�� ����
	//	ZonedDateTime		ZonedDateTime		withSecond(int)						�� ����
	//											withNano(int)						������ ����
	
	// with(temporalAdjuster adjuster) �޼ҵ带 ������ �������� �޼ҵ� �̸��� ���� � ������ �����ϴ��� �� �� �ִ�.
	// with() �޼ҵ�� ��� �����̶�� ����Ǿ� �ִµ�, �̰��� ���� ��¥�� �������� ���� ù ��° �� �Ǵ� ��������, ���� ù ��° �� �Ǵ� ������ ��, 
	// ���� ù��° ����, ���� ���� �� ���ƿ��� ���� �� ������� ��¥�� �����Ѵ�. �Ű����� TemporalAdjuster Ÿ������ ����ǥ�� �ִ�
	// TemporalAdjuster�� ���� �޼ҵ带 ȣ���ϸ� ���� �� �ִ�.
	
	//	���� Ÿ��				�޼ҵ�(�Ű� ����)								����
	//						
	//						firstDayOfYear()						�̹� ���� ù��° ��
	//						lastDayOfYear()							�̹� ���� ������ ��
	//						firstDayOfNextYear()					���� ���� ù ��° ��
	//						firstDayOfMonth()						�̹� ���� ù ��° ��
	//						lastDayOfMonth()						�̹� ���� ������ ��
	//	TemporalAdjuster	firstDayOfNextMonth						���� ���� ù ��° ��
	//						firstlnMonth(DayOfWeek dayOfWeek)		�̹� ���� ù ��° ����
	//						lastlnMonth(DayOfWeek dayOfWeek)		�̹� ���� ������ ����
	//						next(DAyOfWeek dayOfWeek)				���ƿ��� ����
	//						nextOrSame(DayOfWeek dayOfWeek)			���ƿ��� ����(���� ����)
	//						previous(DayOfWeek dayOfWeek)			���� ����
	//						previousOrSame(DayOfWeek dayOfWeek)		���� ����(���� ����)
	
}
