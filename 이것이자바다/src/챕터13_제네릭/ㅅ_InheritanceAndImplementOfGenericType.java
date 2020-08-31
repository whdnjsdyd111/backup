package 챕터13_제네릭;

public class ㅅ_InheritanceAndImplementOfGenericType {
	// 제네릭 타입도 다른 타입과 마찬가지로 부모 클래스가 될 수 있다. 다음은 Product<T,M> 제네릭 타입을 상속해서 ChildProduct<T,M> 타입을 정의한다.
	
	//	public class ChildProduct<T,M> extends Product<T,M> {...}
	
	// 자식 제네릭 타입은 추가적으로 타입 파라미터를 가질 수 있다. 다음은 세 가지 타입 파라미터를 가진 자식 제네릭 타입을 선언한 것이다.
	
	//	public class ChildProduct<T, M, C> extends Product<T, M> { ... }
	
	// 예제를 살펴보자.
}
