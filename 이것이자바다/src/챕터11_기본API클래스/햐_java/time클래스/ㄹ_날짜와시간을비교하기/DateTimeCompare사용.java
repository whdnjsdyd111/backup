package é��11_�⺻APIŬ����.��_java.timeŬ����.��_��¥�ͽð������ϱ�;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTimeCompare��� {
	public static void main(String[] args) {
		LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 9, 0);
		System.out.println("������: " + startDateTime);
		
		LocalDateTime endDateTime = LocalDateTime.of(2024, 3, 31, 18, 0, 0);
		System.out.println("������: " + endDateTime);
		//��������������������������������������������������������������������������������������������������������
		if(startDateTime.isBefore(endDateTime)) {
			System.out.println("���� ���Դϴ�." + "\n");
		} else if(startDateTime.isEqual(endDateTime)) {
			System.out.println("�����մϴ�." + "\n");
		} else if(startDateTime.isAfter(endDateTime)) {
			System.out.println("�����߽��ϴ�." + "\n");
		}
		//��������������������������������������������������������������������������������������������������������
		System.out.println("[������� ���� �ð�]");
		
		// ��� 1
		long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
		long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
		long reaminMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
		long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
		
		// ���2
		remainYear = ChronoUnit.YEARS.between(startDateTime, endDateTime);
		remainMonth = ChronoUnit.MONTHS.between(startDateTime, endDateTime);
		remainDay = ChronoUnit.DAYS.between(startDateTime, endDateTime);
		remainHour = ChronoUnit.HOURS.between(startDateTime, endDateTime);
		reaminMinute = ChronoUnit.MINUTES.between(startDateTime, endDateTime);
		remainSecond = ChronoUnit.SECONDS.between(startDateTime, endDateTime);
		
		System.out.println("���� ��: " + remainYear);
		System.out.println("���� ��: " + remainMonth);
		System.out.println("���� ��: " + remainDay);
		System.out.println("���� �ð�: " + remainHour);
		System.out.println("���� ��: " + reaminMinute);
		System.out.println("���� ��: " + remainSecond);
		//��������������������������������������������������������������������������������������������������������
		System.out.println("[������� ���� �ð�]");
		Period period = Period.between(startDateTime.toLocalDate(), endDateTime.toLocalDate());
		System.out.print("���� �Ⱓ: " + period.getYears() + "��" );
		System.out.print(period.getMonths() + "�� ");
		System.out.println(period.getDays() + "��\n");
		//��������������������������������������������������������������������������������������������������������
		Duration duration = Duration.between(startDateTime.toLocalTime(), endDateTime.toLocalTime());
		System.out.println("���� �ð�: " + duration.toHours());
		System.out.println("���� ��: " + duration.toMinutes());
		System.out.println("���� ��: " + duration.getSeconds());
	}
}
