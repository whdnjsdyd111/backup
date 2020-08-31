package 챕터11_기본API클래스.ㄷ_Object클래스.ㄴ_객체해시코드_hashCode;

import java.util.HashMap;

public class Key사용 {
	public static void main(String[] args) {
		// 다음 예제는 "new Key(1)" 객체로 "홍길동"을 저장하고, 다시 "new Key(1)" 객체로 저장된 "홍길동"을 읽으려고 했지만 결과는 null이 나온다.

		
		// Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		
		// 식별키 "new Key(1)"로 "홍길동"을 저장함
		hashMap.put(new Key(1), "홍길동"); // 예로 필드값이 1인 Key, 해시코드 10인 객체가 생성
		
		// 식병키 "new Key(1)"로 홍길동을 읽어옴
		String value = hashMap.get(new Key(1)); // 위와 같이 필드값이 1인 Key, 해시코드 20이 생성 그러므로 위와 다름
		System.out.println(value);
		
		// 의도한 대로 "홍길동"을 읽으려면 다음과 같이 재정의한 hashCode() 메소드를 Key 클래스에 추가하면 된다.
		// hashCode()의 리턴값을 number 필드값으로 했기 때문에 저장할 때의 "new Key(1)"과 읽을 때의 "new Key(1)"은 같은 해시코드가 리턴된다.
		
		// 저장할 때의 new Key(1)과 읽을 때의 new Key(1)은 사실 서로 다른 객체이지만 HashMap은 hashCode()의 리턴값이 같고,
		// equals() 리턴값이 true가 나오기 때문에 동등 객체로 평가한다.
		// 즉, 같은 식별키로 인삭한다는 뜻이다. 결론적으로 말해서 객체의 동등 비교를 위해서는 Object의 equals() 메소드만 재정의하지 말고
		// hashCode() 메소드도 재정의해서 논리적 동등 객체일 경우 동일한 해시코드가 리턴되도록 해야한다.
	}
}
