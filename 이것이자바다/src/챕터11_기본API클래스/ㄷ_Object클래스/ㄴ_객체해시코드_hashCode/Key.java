package 챕터11_기본API클래스.ㄷ_Object클래스.ㄴ_객체해시코드_hashCode;

// 다음 예제를 보면 Key 클래스는 equals() 메소드를 재정의해서 number 필드값이 같으면 true를 리턴하도록 했다.
// 그러나 hashCode() 메소드는 재정의하지 않았기 때문에 Object의 hashCode() 메소드가 사용된다.

public class Key {
	public int number;
	
	public Key(int number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key compareKey = (Key) obj;
			if(this.number == compareKey.number) {
				return true;
			}
		}
		return false;
	}
	
	// 이런 경우 HashMap의 식별키로 Key 객체를 사용하면 저장된 값을 찾아오지 못한다.
	// 왜냐면 number 필드값이 같더라도 hashCode() 메소드에서 리턴하는 해시코드가 다르기 때문에 다른 식별키로 인식하기 때문이다.
	// Key사용 클래스에서 "new Key(1)" 객체로 "홍길동"을 저장하고, 다시 "new Key(1)" 객체로 저장된 "홍길동"을 읽으려고 했지만 결과는 null이 나온다.
	
	// 의도한 대로 "홍길동"을 읽으려면 다음과 같이 재정의한 hashCode() 메소드를 Key 클래스에 추가하면 된다.
	// hashCode()의 리턴값을 number 필드값으로 했기 때문에 저장할 때의 "new Key(1)"과 읽을 때의 "new Key(1)"은 같은 해시코드가 리턴된다.
	
	@Override
	public int hashCode() {
		return number;
	}
	
	
}
