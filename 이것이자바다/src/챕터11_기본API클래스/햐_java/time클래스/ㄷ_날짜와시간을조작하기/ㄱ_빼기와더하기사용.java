package é��11_�⺻APIŬ����.��_java.timeŬ����.��_��¥�ͽð��������ϱ�;

import java.time.LocalDateTime;

public class ��_����ʹ��ϱ��� {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("�����:" + now);
		
		LocalDateTime targetDateTime = now
				.plusYears(1)
				.minusMonths(2)
				.plusDays(3)
				.plusHours(4)
				.minusMinutes(5)
				.plusSeconds(6);
		System.out.println("���� ��: " + targetDateTime);
	}
}
