package 챕터11_기본API클래스.햐_java.time클래스.ㅁ_파싱와포맷팅;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ㄷ_DateTimeFormat사용 {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 a h시 m분");
		String nowString = now.format(dateTimeFormatter);
		System.out.println(nowString);
	}
}
