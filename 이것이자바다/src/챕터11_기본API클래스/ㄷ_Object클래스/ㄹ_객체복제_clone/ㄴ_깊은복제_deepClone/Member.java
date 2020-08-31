package 챕터11_기본API클래스.ㄷ_Object클래스.ㄹ_객체복제_clone.ㄴ_깊은복제_deepClone;

import java.util.Arrays;

// 다음 예제를 보면 Member 클래스에 int[] 배열과 Car 타입의 필드가 있다.
// 이 필드들은 모두 참조 타입이므로 깊은 복제 대상이 된다.
// Member 클래스는 Object의 clone() 메소드를 재정의해서 int[] 배열과 Car 객체를 복제한다.

public class Member implements Cloneable {
	public String name;
	public int age;
	public int[] scores;
	public Car car;
	
	public Member(String name, int age, int[] scores, Car car) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 먼저 얕은 복사를 해서 name, age를 복제한다.
		Member cloned = (Member) super.clone(); // super.clone() <--- Object의 clone() 호출
		
		// scores를 깊은 복제한다.
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
		
		// car를 깊은 복제한다.
		cloned.car = new Car(this.car.model);
		
		// 깊은 복제된 Member 객체를 리턴
		return cloned;
	}
	
	public Member getMember() {
		Member cloned = null;
		try {
			cloned = (Member) clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
}
