package é��11_�⺻APIŬ����.��_java.timeŬ����.��_�Ľ̿�������;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ��_DateTimeFormat��� {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy�� M�� d�� a h�� m��");
		String nowString = now.format(dateTimeFormatter);
		System.out.println(nowString);
	}
}
