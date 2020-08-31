package é��05_����Ÿ��;

import java.util.Calendar;

public class ��2_Using_Calendar {
	public static void main(String[] args) {
		
		// �ڹٴ� ��ǻ���� ��¥ �� ����, �ð��� ���α׷����� ����� �� �ֵ��� �ϱ� ���� Date, Calendar, LocalDateTime ���� Ŭ������ �����Ѵ�.
		// LocalDateTime�� �ڹ�8 ���� �����ϴ� API�̴�. �׷��� ���� ��������� ȣȯ���� ���� Calendar�� �̿��ؼ� ��¥�� �ð��� ��� ����� �˾ƺ���.
		// Calendar�� ����ϱ� ���ؼ��� import���� �ʿ��ϴ�.
				
		// �켱 Calendar ������ �����ϰ� Calendar.getInstance() �޼ҵ尡 �����ϴ� Calendar ��ü�� ��´�.
				
		Calendar now = Calendar.getInstance();
				
		// Calendar ��ü�� ����ٸ� get() �޼ҵ带 �̿��ؼ� ��, ��, ��, ����, �ð�, ��, �ʸ� ������ ���� ���� �� �ִ�.
				
		int year = now.get(Calendar.YEAR);			// ��
		int month = now.get(Calendar.MONDAY);		// �� (1 ~ 12)
		int day = now.get(Calendar.DAY_OF_MONTH);	// ��
		int week = now.get(Calendar.DAY_OF_WEEK);	// ���� (1 ~ 7)
		int hour = now.get(Calendar.HOUR);			// �ð�
		int minute = now.get(Calendar.MINUTE);		// ��
		int second = now.get(Calendar.SECOND);		// ��
		
		// ���� Calendar�� Week�� ����غ���.
		
		��_Week today = null;
		
		switch(week) {
		case 1:
			today = ��_Week.SUNDAY;
			break;
		case 2:
			today = ��_Week.MONDAY;
			break;
		case 3:
			today = ��_Week.TUESDAY;
			break;
		case 4:
			today = ��_Week.WEDNESDAY;
			break;
		case 5:
			today = ��_Week.THURSDAY;
			break;
		case 6:
			today = ��_Week.FRIDAY;
			break;
		case 7:
			today = ��_Week.SATURDAY;
		}
		
		System.out.println("���� ����: " + today);
	}
}
