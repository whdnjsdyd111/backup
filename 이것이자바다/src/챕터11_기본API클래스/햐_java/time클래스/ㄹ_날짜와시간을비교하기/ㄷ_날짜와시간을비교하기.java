package é��11_�⺻APIŬ����.��_java.timeŬ����.��_��¥�ͽð������ϱ�;

public class ��_��¥�ͽð������ϱ� {
	// ��¥�� �ð� Ŭ���� ���� ������ ���� ���ϰų� ���̸� ���ϴ� �޼ҵ���� ������ �ִ�.
	
	//	Ŭ����				���� Ÿ��		�޼ҵ�(�Ű� ����)								����
	
	//	LocalDate						isAfter(ChronoLocalDate other)			���� ��¥���� ��
	//	LocalDateTime		boolean		isBefore(ChronoLocalDate other)			���� ��¥���� ��
	//									isEqual(ChronoLocalDate other)			���� ��¥���� ��
	
	//	LocalTime						isAfter(LocalTime other)				���� �ð����� ��
	//	LocalDateTime		boolean		isBefore(LocalTime other)				���� �ð����� ����
	
	//	LocalDate			Period		until(ChronoLocalDate endDateExclusive)	��¥ ����
	
	//	LocalDate						until(									
	//	LocalTime			long			Temporal endExclusive,				�ð� ����
	//	LocalDateTime						TemporalUnit unit
	//									)
	
	//									between(
	//										LocalDate startDateInclusive,		��¥ ����
	//	Period				Period			LocalDate endDateExclusive
	//									)
	
	//									between(
	//										Temporal startInclusive,			�ð� ����
	//	Duration			Duration		Temporal endExclusive
	//									)
	
	//	ChronoUnit.YEARS														��ü �� ����
	//	ChronoUnit.MONTHS														��ü �� ����
	//	ChronoUnit.WEEKS				between(								��ü �� ����
	//	ChronoUnit.DAYS		long			Temporal temporal1Inclusive,		��ü �� ����
	//	ChronoUnit.HOURS					Temporal temporal2Exclusive			��ü �ð� ����
	//	ChronoUnit.SECONDS				)										��ü �� ����
	//	ChronoUnit.MILLIS														��ü �и��� ����
	//	ChronoUnit.NANOS														��ü ������ ����
	
	// Period�� Duration�� ��¥�� �ð��� ���� ��Ÿ���� Ŭ�����̴�.
	// Period�� ��, ��, ���Ǿ��� ��Ÿ���� Ŭ�����̰�, Duration�� ��, ��, ��, �������� ���� ��Ÿ���� Ŭ�����̴�.
	// �� Ŭ�������� D-day�� D-time�� ���� �� ���� �� �ִ�. ������ Period�� Duration���� �����ϴ� �޼ҵ���̴�.
	
	//	Ŭ����		���� Ÿ��	�޼ҵ�(�Ű� ����)		����
		
	//				int		getYears()		���� ����
	//	Period		int		getMonths()		���� ����
	//				int		getDays()		���� ����
	
	//				int		getSeconds()	���� ����
	//	Duration	int		getNano()		�������� ����
	
	// between() �޼ҵ�� Period�� Duration Ŭ����, �׸��� ChronoUnit ���� Ÿ�Կ��� �ִ�.
	// Period�� Duration�� between()�� ��, ��, ��, ���� �ܼ� ���̸� �����ϰ�, 
	// ChronoUnit ���� Ÿ���� between()�� ��ü �ð��� �������� ���̸� �����Ѵ�.
	// ���� ��� 2023�� 1���� 2024�� 3���� ���� ���̸� ���� �� Period�� between()�� 2�� �ǰ�, ChronoUnit.MONTHS.between()�� 14�� �ȴ�.
}
