package 챕터11_기본API클래스.ㄷ_Object클래스.ㄷ_객체문자정보_toString;

import java.util.Date;

// 다음은 Object 클래스와 Date 클래스의 toString() 메소드의 리턴값을 출력해본 것이다.

public class ToString사용 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Date obj2 = new Date();
		
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
	}
}
