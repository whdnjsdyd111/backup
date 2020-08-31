package 챕터15_컬렉션프레임워크;

public class ㅇ_CollectionForParallelProcessing {
	// 동기화된(synchronized) 컬렉션은 멀티 스레드 환경에서 하나의 스레드가 요소를 안전하게 처리하도록 도와주지만, 전체 요소를 빠르게 처리하지는 못한다.
	// 하나의 스레드가 요소를 처리할 때 전체 잠금이 발생하여 다른 스레드는 대기 상태가 된다. 그렇기 때문에 멀티 스레드가 병렬적으로 컬렉션의 요소들을 처리할 수 없다.
	// 자바는 멀티 스레드가 컬렉션의 요소를 병렬적으로 처리할 수 있도록 특별한 컬렉션을 제공하고 있다.
	// java.util.concurrent 패키지의 ConcurrentHashMap과 ConcurrentLinkedQueue이다.
	// ConcurrentHashMap은 Map 구현 클래스이고, ConcurrentLinkedQueue는 Queue 구현 크래스이다.
	
	// ConcurrentHashMap을 사용하면 스레드에 안전하면서도 멀티 스레드가 요소를 병렬적으로 처리할 수 있다.
	// 이것이 가능한 이유는 ConcurrentHashMap은 부분(segment) 잠금을 사용하기 때문이다.
	// 컬렉션에 10개의 요소가 저장되어 있을 경우, 1개를 처리할 동안 전체 10개의 요소를 다른 스레드가 처리하지 못하도록 하는 것이 부분 잠금이다.
	// 다음은 ConcurrentHashMap 객체를 생성하는 코드이더. 사용하는 방법은 다른 Map 구현 객체와 마찬가지로 Map 인터페이스의 메소드를 호출하면 된다.
	
	//	Map<K, V> map = new ConcurrentHashMap<K, V>();
	
	// ConcurrentLinkedQueue는 락-프리(lock-free) 알고리즘을 구현한 컬렉션이다.
	// 락-프리 알고리즘은 여러 개의 스레드가 동시에 접근할 경우, 잠금을 사용허지 않고도 최소한 하나의 스레드가 안전하게 요소를 저장하거나 얻도록 해준다.
	// 다음은 ConcurrentLinkedQueue를 생성하는 코드이다.
	
	//	Queue<E> queue = new ConcurrentLinkedQueue<E>();
	
	// 사용하는 방법은 다른 Queue 구현 객체와 마찬가지로 Queue 인터페이스의 메소드를 호출하면 된다.
}
