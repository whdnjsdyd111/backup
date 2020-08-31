package 챕터11_기본API클래스.햐_java.time클래스.ㄷ_날짜와시간을조작하기;

import java.time.LocalDateTime;

public class ㄱ_빼기와더하기사용 {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("현재시:" + now);
		
		LocalDateTime targetDateTime = now
				.plusYears(1)
				.minusMonths(2)
				.plusDays(3)
				.plusHours(4)
				.minusMinutes(5)
				.plusSeconds(6);
		System.out.println("연산 후: " + targetDateTime);
	}
}
