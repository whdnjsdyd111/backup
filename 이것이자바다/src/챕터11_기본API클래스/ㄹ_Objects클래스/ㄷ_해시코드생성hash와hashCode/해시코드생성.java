package 챕터11_기본API클래스.ㄹ_Objects클래스.ㄷ_해시코드생성hash와hashCode;

public class 해시코드생성 {
	// Objects.hash(Object... value) 메소드는 매개값으로 주어진 값들을 이용해서 해시 코드를 생성하는 역할을 하는데,
	// 주어진 매개값들로 배열을 생성하고 Arrays.hashCode(Object[])를 호출해서 해시코드를 얻고 이 값을 리턴한다.
	// 이 메소드는 클래스가 hashCode()를 재정의할 때 리턴값을 생성하기 위해 사용하면 좋다.
	// 클래스가 여러 가지 필드를 가지고 있을 때 이 필드들로부터 해시코드를 생성하게 되면 동일한 필드값을 가지는 객체는 동일한 해시코드를 가질 수 있다.
	
	//	@Override
	//	public int hashCode() {
	//		return Objects.hash(field1, field2, field3);
	//	}
	
	// Objects.hashCode(Object o)는 매개값으로 주어진 객체의 해시코드를 리턴하기 때문에 o.hashCode()의 리턴값과 동일하다.
	// 차이점은 매개값이 null이면 0을 리턴한다.
}
