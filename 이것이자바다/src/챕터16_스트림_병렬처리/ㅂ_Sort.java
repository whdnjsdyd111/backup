package 챕터16_스트림_병렬처리;

public class ㅂ_Sort {
	// 스트림은 요소가 최종 처리되기 전에 중간 단계에서 요소를 정렬해서 최종 처리 순서를 변경할 수 있다. 요소를 정렬하는 메소드는 다음과 같다.
	
	//	리턴 타입			메소드						설명
	//
	//	Stream<T>		sorted()					객체를 Comparable 구현 방법에 따라 정렬
	//	Stream<T>		sorted(Comparator<T>)		객체를 주어진 Comparator에 따라 정렬
	//	DoubleStream	sotred()					double 요소를 오름차순으로 정렬
	//	IntStream		sorted()					int 요소를 오름차순으로 정렬
	//	LongStream		sorted()					long 요소를 오름차순으로 정렬
	
	// 객체 요소일 경우에는 클래스가 Comparable을 구현하지 않으면 sorted() 메소드를 호출했을 때 ClassCaastException이 발생하기 때문에 Comparable을 구현한 요소에만 sorted() 메소드를 호출해야 한다.
	// 다음은 점수를 기준으로 Student 요소를 오름차순으로 정렬하기 위해 Comparable을 구현했다.
	
	// 객체 요소가 Comparable을 구현한 상태에서 기본 비교(Comparable) 방법으로 정렬하고 싶다면 다음 세 가지 방법 중 하나를 선택해서 sorted()를 호출하면 된다
	
	//	sorted();
	//	sorted( (a, b) -> a.compareTo(b) );
	//	sorted( Comparator.naturalOrder() );
	
	// 만약 객체 요소가 Comparable을 구현하고 있지만, 기본 비교 방법과 정반대 방법으로 정렬하고 싶면 다음과 같이 sorted()를 호출하면 된다.
	
	//	sorted( (a, b) -> b.compareTo(a) );
	//	sorted( Comparator.reverseOrder() );
	
	// 객체 요소가 Comparable를 구현하지 않았다면 Comparator를 매개값으로 갖는 sorted() 메소드를 사용하면 된다.
	// Comparator는 함수적 인터페이스이므로 다음과 같이 람다식으로 매개값을 작성할 수 있다.
	
	//	sorted( (a, b) -> { ... } );
	
	// 중괄호 {} 안에는 a와 b를 비교해서 a가 작으면 음수, 같으면 0, a가 크면 양수를 리턴하는 코드를 작성하면 된다.
	
	// 다음 예제를 보면 숫자 요소일 경우에는 오름차순으로 정렬한 후 출력했다. Student 요소일 경우에는 Student의 기본 비교(Comparable) 방법을 이용해서 점수를 기준으로 오름차순으로 정렬한 후 출력했다.
	// 그리고 Comparator를 제공해서 점수를 기준으로 내림차순으로 정렬한 후 출력했다.
}	
	