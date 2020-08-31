package 챕터13_제네릭;

public class ㄷ_MultiTypeParameter {
	// 제네릭 타입은 두 개 이상의 멀티 타입 파라미터를 사용할 수 있는데, 이 경우 각 타입 파라미터를 콤마로 구분한다.
	// 다음 예제는 Product<T,M> 제네릭 타입을 정의하고 ProductExample 클래스에서 Product<Tv, String> 객체와 Product<Car, String> 객체를 생성한다.
	// 그리고 Getter와 Setter를 호출하는 방법을 보여준다.
	
	// 제네릭 타입 변수 선언과 객체 생성을 동시에 할 때 타입 피라미터 자리에 구체적인 타입을 지정하는 코드가 중복해서 나와 다소 복잡해질 수 있다.
	// 자바 7 부터 제네릭 타입 파라미터의 중복 기술을 줄이기 위해 다이아몬드 연산자 <>를 제공한다. 자바 컴파일러는 타입 파라미터 부분에 <> 연산자를 사용하면 타입 파라미터를 유추해서 자동으로 설정해준다.
	// 예를 들어 다음은 자바 6 이전 버전에서 사용한 제네릭 타입 변수 선언과 객체 생성 코드이다.
	
	//	Product<Tv, String> product = new Product<Tv, String>();
	
	// 자바 7 부터는 다이아몬드 연산자를 사용해서 다음과 같이 간단하게 작성할 수 있다.
	
	//	Product<Tv, String> product = new Product<>();
}
