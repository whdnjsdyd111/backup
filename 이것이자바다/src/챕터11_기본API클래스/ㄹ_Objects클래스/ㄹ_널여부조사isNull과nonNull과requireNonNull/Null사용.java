package 챕터11_기본API클래스.ㄹ_Objects클래스.ㄹ_널여부조사isNull과nonNull과requireNonNull;

import java.util.Objects;

public class Null사용 {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = null;
		
		System.out.println(Objects.requireNonNull(str1));
		
		try {
			String name = Objects.requireNonNull(str2);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String name = Objects.requireNonNull(str2, "이름이 없습니다.");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			String name = Objects.requireNonNull(str2, ()->"이름이 없다니깐요");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		// 21라인을 보면 두 번째 매개값으로 람다식을 주었다. 람다식은 14장에서 학습한다.
		// 람다식은 인터페이스의 구현 객체이므로 Supplier 구현 객체로 람다식을 대입했다.
		
		
	}
}
