package 챕터16_스트림_병렬처리;

public class ㅇ_Matching {
	// 스트림 클래스는 최종 처리 단계에서 요소들이 특정 조건에 만족하는지 조사할 수 있도록 세 가지 매칭 메소드를 제공하고 있다.
	// allMatch() 메소드는 모든 요소들이 매개값으로 주어진 Predicate의 조건을 만족하는지 조사하고, anyMatch() 메소드는 최소한 한 개의 요소가 매개값으로 주어진
	// Predicate의 조건을 만족하는지 조사한다. 그리고 noneMatch()는 모든 요소들이 매개값으로 주어진 Predicate의 조건을 만족하지 않는지 조사한다.
	
	//	리턴 타입		메소드(매개 변수)							제공 인터페이스
	//	
	//				allMatch(Predicate<T> predicate)	
	//	boolean		anyMatch(Predicate<T> predicate)	Stream
	//				noneMatch(Predicate<T> predicate)
	//
	//				allMatch(IntPredicate predicate)
	//	boolean		anyMatch(IntPredicate predicate)	IntStream	
	//				noneMatch(IntPredicate predicate)
	//
	//				allMatch(LongPredicate predicate)
	//	boolean		anyMatch(LongPredicate predicate)	LongStream
	//				nonMatch(LongPredicate predicate)
	//
	//				allMatch(DoublePredicate predicate)
	//	boolean		anyMatch(DoublePredicate predicate)	DoubleStream
	//				noneMatch(DoublePredicate predicate)
	
	// 다음 예제는 int[] 배열로부터 스트림을 생성하고, 모든 요소가 2의 배수인지, 하나라도 3의 배수가 존재하는지, 모든 요소가 3의 배수가 아닌지를 조사한다.
	
}
