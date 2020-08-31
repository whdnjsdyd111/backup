package 챕터16_스트림_병렬처리;

public class ㅅ_Looping {
	// 루핑(looping)은 요소 전체를 반복하는 것을 말한다. 루핑하는 메소드에는 peek(), forEach()가 있다.
	// 이 두 메소드는 루핑한다는 기능에서는 동일하지만, 동작 방식은 다르다. peek()는 중간 처리 메소드이고, forEach()는 최종 처리 메소드이다.
	
	// peek()는 중간 처리 단꼐에서 전체 요소를 루핑하면서 추가적인 작업을 하기 위해 사용한다. 최종 처리 메소드가 실행되지 않으면 지연되기 때문에 반드시 최종 처리 메소드가 호출되어야 동작한다.
	// 예를 들어 필터링 후 어던 요소만 남았는지 확인하기 위해 다음과 같이 peek()를 자미막에서 호출할 경우, 스트림은 전혀 동작하지 않는다.
		
	//	intStream
	//		.filter( a -> a % 2 == 0 )
	//		.peek( a -> System.out.println(a) )
	
	// 요소 처리의 최종 단계가 합을 구하는 것이라면, peek() 메소드 호출 후 sum()을 호출해야만 peek()가 정상적으로 동작한다.
	
	//	intStream
	//		.filter( a -> a % 2 == 0 )
	//		.peek( a -> System.out.println(a) )
	//		.sum()
	
	// 하지만 forEach()는 최종 처리 메소드이기 때문에 파이프라인 마지막에 루핑하면서 요소를 하나씩 처리한다.
	// forEach()는 요소를 소비하는 최종 처리 메소드이므로 이후에 sum()과 같은 다른 최종 메소드를 호출하면 안 된다.
	
}
