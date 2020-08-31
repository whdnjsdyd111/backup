package 챕터11_기본API클래스.question11.Question11;

public class IntegerCompare사용 {
	public static void main(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;
		
		System.out.println( obj1 == obj2 );
		System.out.println( obj3 == obj4 );
		
		// 만들어진 객체 번지는 서로 다른 것이기 때문에 obj3 == obj4는 false가 나온다.
		// 그러나 -127 ~ +128 사이의 범위에서는 == 연산자는 내부 값만 비교하는 규칙이있어 true가 나온다.
	}
}
