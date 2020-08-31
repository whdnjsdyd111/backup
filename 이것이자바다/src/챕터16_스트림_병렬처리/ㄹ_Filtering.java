package 챕터16_스트림_병렬처리;

public class ㄹ_Filtering {
	// 필터링은 중간 처리 기능으로 요소를 걸러내는 역할을 한다. 필터링 메소드인 distinct()와 filter() 메소드는 모든 스트림이 가지고 있는 공통 메소드이다.
	
	//	리턴 타입			메소드(매개 변수)					설명
	//
	//					distinct()					중복자 제거
	//
	//	공통				filter(Predicate)
	//					filter(IntPredicate)		조건 필터링
	//					filter(LongPredicate)
	//					filter(DoublePredicate)
	
	// distinct() 메소드는 중복을 제거하는데, Stream의 경우 Object.equals(Object)가 true이면 동일한 객체로 판단하고 중복을 제거한다.
	// IntStream, LongStream, DoubleStream은 동일값일 경우 중복을 제거 한다.
	
	//		원래 스트림									새로 생성된 스트림
	//	────────────────						────────────────
	//	→	B A B A			── distinct() →			B A			→
	//	────────────────						────────────────
	
	// filter() 메소드는 매개값으로 주어진 Predicate가 true를 리턴하는 요소만 필터링한다.
	
	//		원래 스트림									새로 생성된 스트림
	//	────────────────	  → A → true   ┐	────────────────
	//	→	C B A			──┤ B → false  ├ →		C A			→
	//	────────────────	  → C → true   ┘	────────────────
	
	// 다음 예제는 이름 List에서 중복된 이름을 제거하고 출력한다. 그리고 성이 "신"인 이름만 필터링해서 출력한다.
}
