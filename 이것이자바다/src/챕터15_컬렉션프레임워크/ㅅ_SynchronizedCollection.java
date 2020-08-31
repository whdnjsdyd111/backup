package 챕터15_컬렉션프레임워크;

public class ㅅ_SynchronizedCollection {
	// 컬렉션 프레임워크의 대부분의 클래스들은 싱글 스레드 환경에서 사용할 수 있도록 설계되었다. 그렇기 때문에 어러 스레드가 동시에 컬렉션에 접근한다면 의도하지 않게 요소가 변경될 수 있는 불안전한 상태가 된다.
	// Vector와 Hashtable은 동기화된(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드 환경에서 안전하게 요소를 처리할 수 있지만, 
	// ArrayList와 HashSet, HashMap은 동기화된 메소드로 구성되어 있지 않아 멀티 스레드 환경에서 안전하지 않다.
	// 경우에 따라서는 ArrayList, HashSet, HashMap을 싱글 스레드 환경에서 사용하다가 멀티 스레드 환경으로 전달할 필요도 있을 것이다.
	// 이런 경우를 대비해서 컬렉션 프레임워크는 비동기화된 메소드를 동기화된 메소드로 래핑하는 Collection의 synchronizedXXX() 메소드를 제공하고 있다.
	// 매개값으로 동기화된 컬렉션을 대입하면 동기화된 컬렉션을 리턴한다.
	
	//	리턴 타입			메소드(매개 변수)							설명
	//
	//	List<T>			synchronizedList(List<T> list)		List를 동기화된 List로 리턴
	//	Map<K, V>		synchronizedMap(Map<K, V> m)		Map을 동기화된 Map으로 리턴
	//	Set<T>			synchronizedSet(Set<T> s)			Set을 동기화된 Set으로 리턴
	
	// 다음 코드는 ArrayList를 Collection.synchronizedList() 메소드를 사용해서 동기화된 List로 변환한다.
	
	//	List<T> list = Collection.synchronized(new ArrayList<T>());
	//			│
	//			└────────────────────────────────┐
	//											 ↓
	//	(멀티 스레드에 안전하지 않음)						List
	//												(멀티 스레드에 안전)
	//	ArrayList								ArrayList
	//					<- 스레드1 o								<- 스레드1 o
	//	0	..	n-1								0	..	n-1
	//	■	■	■		<- 스레드2 o				■	■	■		<- 스레드2 x
	
	// 다음 코드는 HashSet을 Collection.synchronizedSet() 메소드를 사용해서 동기화된 Set으로 변환한다.
	
	//	Set<E> set = Collection.synchronizedSet(new HashSet<E>());
	//			│
	//			└────────────────────────────────┐
	//											 ↓
	//	(멀티 스레드에 안전하지 않음)						Set
	//												(멀티 스레드에 안전)
	//	HashSet									HashSet
	//	○	○		<- 스레드1 o					○	○		<- 스레드1 o
	//	
	//	○	○		<- 스레드2 o					○	○		<- 스레드2 x
	
	// 다음 코드는 HashMap을 Collection.synchronizedMap() 메소드를 사용해서 동기화된 Map으로 변환한다.
	
	//	Map<K, V> map = Collection.synchronizedMap(new HashMap<K, V>());
	//				│
	//			 	└────────────────────────────┐
	//											 ↓
	//	(멀티 스레드에 안전하지 않음)						List
	//												(멀티 스레드에 안전)
	//	HashMap									HashMap
	//					<- 스레드1 o								<- 스레드1 o
	//	키	..	키								키	..	키
	//	값	..	값		<- 스레드2 o				값	..	값		<- 스레드2 x
}
