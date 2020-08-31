package 챕터15_컬렉션프레임워크;

public class ㅁ_Tree {
	// 컬렉션 프레임워크는 검색 기능을 강화시킨 TreeSet과 TreeMap을 제공하고 있다. 이름에서 알수 있듯이 TreeSet은 Set 컬렉션이고, TreeMap은 Map 컬렉션이다.
	// 이 컬렉션들은 이진 트리(binary tree)를 이용해서 계층적 구조(Tree 구조)를 가지면서 객체를 저장한다.
	
			//	Binary Tree		이진 트리 구조
	
	// 이진 트리 ( binary tree )는 여러 개의 노드 ( node )가 트리 형태로 연결된 구조로,												↙	■ (루트 노드)	↘
	// 루트 노드 ( root node )라고 불리는 하나의 노드에서부터 시작해서 각 노드에 최대 2개의 노드를 연결할 수 있는 구조를 가지고 있다.		(부모 노드) ■ (A)					■		
	// 위아래로 연결된 두 노드를 부모-자식관계에 있다고 하며 위의 노드를 부모 노드, 아래의 노드를 자식 노드라고 한다.								↙	↘
	// 하나의 부모 노드는 최대 두 개의 자식 노드와 연결될 수 있다. 다음을 보면 A노드는 B, C노드의 부모 노드이고,					(자식 노드) ■ (B)	(C) ■ (자식 노드)
	// B, C노드는 A노드의 자식 노드이다. 이진 트리는 부모 노드의 값보다 작은 노드는 왼쪽에 위치시키고, 							
	// 부모 노드의 값보다 큰 노드는 오른쪽에 위치시킨다. 예를 들어 6, 3, 9, 2, 5의 순서로 값을 저장하면 다음과 같은 순서로 진행된다.
	
	//		(1) 저장		→		(1) 비교(6>3)			→		(1) 비교(6<9)
	//		6			|				6			|				6
	//					|	(2) 저장	↙				|			↙		↘		(2) 저장
	//					|		3					|		3				9
	//
	//
	//		→		(1) 비교(6>2)				→				(1) 비교(6>5)
	//						6				|						6
	//	(2) 비교(3>2)		↙		↘			|		(2) 비교(3<5)	↙
	//				3				9		|				3
	//	(3) 저장	↙							|			↙		↘	(3) 저장
	//		2								|		2				5
	
	// 첫 번째로 저장되는 값은 루트 노드가 되고, 두 번째 값은 루트 노드부터 시작해서 값의 크기를 비교하면서 트리를 따라 내려간다. 작은 값은 왼쪽, 큰 값은 오른쪽에 저장한다.
	// 숫자가 아닌 문자를 저장할 경우에는 문자의 유니코드 값으로 비교한다. 이렇게 트리를 구성하면, 왼쪽 마지막 노드가 제일 작은 값이 되고 오른쪽 마지막 노드가 가장 큰 값이 된다.
	// 왼쪽 마지막 노드에서부터 오른쪽 마지막 노드까지 [왼쪽 노드 -> 부모 노드 -> 오른쪽 노드] 순으로 값을 읽으면 오름차순으로 정렬된 값을 얻을 수 있고,
	// 반대로 오른쪽 마지막 노드에서부터 왼쪽 마지막 노드까지 [오른쪽 노드 -> 부모 노드 -> 왼쪽 노드] 순으로 값을 읽으면 내림차순으로 정렬된 값을 얻을 수 있다.
	// 이진 트리가 범위 검색을 쉽게 할 수 있는 이유는 아래와 같이 값들이 정렬되어 있어 그룹핑이 쉽기 때문이다.
	
	//					6
	//				↙		↘
	//			3 (6 미만인 값들)	9 (6 이상인 값들)
	//		↙		↘
	//	2				5
	
			//	TreeSet
	
	// TreeSet은 이진 트리 ( binary tree )를 기반으로한 Set 컬렉션이다. 하나의 노드는 노드값인 value와 왼쪽과 오른쪽 자식 노드를 참조하기 위한 두 개의 변수로 구성된다.
	// TreeSet에 객체를 저장하면 자동으로 정렬되는데 부모값과 비교해서 낮은 것은 왼쪽 자식 노드에, 높은 것은 오른쪽 자식 노드에 저장한다.
	
	//					부모 노드 객체
	//				left	value	right
	//				↙					↘
	//			자식 노드 객체					자식 노드 객체
	//		left	value	right		left	value	right
	
	// TreeSet을 생성하기 위해서는 저장할 객체 타입을 파라미터로 표기하고 기본 생성자를 호출하면된다.
	
	//	TreeSet<E> treeSet = new TreeSet<E>();
	
	// String 객체를 저장하는 TreeSet은 다음과 같이 생성할 수 있다.
	
	//	TreeSet<String> treeSet = new TreeSet<String>();
	
	// Set 인터페이스 타입 변수에 대입해도 되지만 TreeSet 클래스 타입으로 대입한 이유는 객체를 찾거나 범위 검색과 관련된 메소드를 사용하기 위해서이다.
	// 다음은 TreeSet이 가지고 있는 검색 관련 메소드들이다.
	
	//	리턴 타입	메소드			설명
	//
	//	E		first()			제일 낮은 객체를 리턴
	//	E		last()			제일 높은 객체를 리턴
	//	E		lower(E e)		주어진 객체보다 바로 아래 객체를 리턴
	//	E		higher(E e)		주어진 객체보다 바로 위 객체를 리턴
	//	E		floor(E e)		주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체의 바로 아래의 객체를 리턴
	//	E		ceiling(E e)	주어진 객체와 동등한 객체가 있으면 리턴, 만약 없다면 주어진 객체의 바로 위의 객체를 리턴
	//	E		pollFirst()		제일 낮은 객체를 꺼내오고 컬렉션에서 제거함
	//	E		pollLast()		제일 높은 객체를 꺼내오고 컬렉션에서 제거함
	
	// 다음 예제는 점수를 무작위로 저장하고 특정 점수를 찾는 방법을 보여준다.
	
	// 다음은 TreeSet이 가지고 있는 정렬과 관련된 메소드들이다.
	
	//	리턴 타입				메소드					설명
	//	Iterator<E>			descendingIterator()	내림차순으로 정렬된 Iterator를 리턴
	//	NavigableSet<E>		descendingSet()			내림차순으로 정렬된 NavigableSet을 반환
	
	// descendingIterator() 메소드는 내림차순으로 정렬된 Iterator 객체를 리턴하는데 Iterator는 이미 Set 컬렉션에서 사용 방법을 살펴보았다.
	// descendingSet() 메소드는 내림차순으로 정렬된 NavigableSet 객체를 리턴하는데 NavigableSet은 TreeSet과 마찬가지로
	// first(), last(), lower(), higher(), floor(), ceiling() 메소드를 제공하고, 정렬 순서를 바꾸는 descendingSet() 메소드도 제공한다.
	// 오름차순으로 정렬하고 싶다면 다음과 같이 descendingSet() 메소드를 두 번 호출하면 된다.
	
	//	NavigableSet<E> descendingSet = treeSet.descendingSet();
	//	NavigableSet<E> ascendingSet = descendingSet.descendingSet();
	
	// 다음은 TreeSet이 가지고 있는 범위 검색과 관련된 메소드들이다.
	
	//	리턴 타입					메소드						설명
	//
	//	NavigableSet<E>		headSet(E toElement,			주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴,
	//								boolean inclusive)		주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
	//
	//	NavigableSet<E>		tailSet(E fromElement,			주어진 객체보다 높은 객체들을 NavigableSet으로 리턴,
	//								boolean inclusive)		주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
	//
	//	NavigableSet<E>		subSet(	E fromElement,			시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet
	//								boolean fromInclusive,	으로 리턴, 시작과 끝 객체의 포함 여부는 두 번째, 네 번째 매개값에 따라
	//								E toElement,			달라짐
	//								boolean toInclusive)
	
	// 세 가지 메소드 중에서 subSet() 메소드의 사용 방법을 자세히 살펴보기로 하자. subSet() 메소드는 네 개의 매개 변수가 있는데,
	// 시작 객체와 끝 객체, 그리고 이 객체들을 포함할지 여부의 boolean 값을 받는다.
	
	//	시작 객체 < 찾는 객체 < 끝 객체
	//	시작 객체 <= 찾는 객체 <= 끝 객체
	//											시작 객체			시작 객체의 포함 여부
	//	NavigableSet<E> set = treeSet.subSet( 	E fromElement, boolean fromInclusive,
	//											E toElement, boolean toInclusive)
	//											끝 객체			끝 객체의 포함 여부
	
	// 다음은 영어 단어를 무작위로 TreeSet에 저장한 후 알파벳 c~f 사이의 단어를 검색해보는 예제이다.
	
			//	TreeMap
	
	// TreeMap은 이진 트리를 기반으로 한 Map 컬렉션이다. TreeSet과의 차이점은 키와 값이 저장된 Map.Entry를 저장한다는 점이다.
	// TreeMap에 객체를 저장하면 자동으로 정렬되는데, 기본적으로 부모 키값과 비교해서 키 값이 낮은 것은 왼쪽 자식 노드에, 키 값이 높은 것은 오른쪽 자식 노드에 Map.Entry 객체를 저장한다.
	
	//							부모 노드 객체
	//						left	Map.Entry	right
	//					↙				키				↘
	//				자식 노드 객체			값			자식 노드 객체
	//		left	Map.Entry	right		left	Map.Entry	right
	//					키								키
	//					값								값
	
	// TreeMap을 생성하기 위해서는 키로 저장할 객체 타입과 값으로 저장할 객체 타입을 타입 파라미터로 주고 기본 생성자를 호출한다.
	
	//	TreeMap<K, V> treeMap = new TreeMap<K, V>();
	//		키 타입	값 타입				키 타입	값 타입
	
	// 키로 String 타입을 사용하고 값으로 Integer 타입을 사용하는 TreeMap은 다음과 같이 생성할 수 있다.
	
	//	TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
	
	// Map 인터페이스 타입 변수에 대입해도 되지만 TreeMap 클래스 타입으로 대입한 이유는 특정 객체를 찾거나 범위 검색과 관련된 메소드를 사용하기 위해서이다.
	// 다음은 TreeMap이 가지고 있는 검색 관련 메소드들이다.
	
	//	리턴 타입				메소드					설명
	//	
	//	Map.Entry<K, V>		firstEntry()			제일 낮은 Map.Entry를 리턴
	//	Map.Entry<K, V>		lastEntry()				제일 높은 Map.Entry를 리턴
	//	Map.Entry<K, V>		lowerEntry(K key)		주어진 키보다 바로 아래 Map.Entry를 리턴
	//	Map.Entry<K, V>		higherEntry(K key)		주어진 키보다 바로 위의 Map.Entry를 리턴
	//	Map.Entry<K, V>		floorEntry(K key)		주어진 키와 동등한 키가 있으면 Map.Entry를 리턴, 없다면 주어진 키 바로 아래의 Map.Entry를 리턴
	//	Map.Entry<K, V>		ceilingEntry(K key)		주어진 키와 동등한 키가 있으면 Map.Entry를 리턴, 없다면 주어진 키 바로 위의 Map.Entry를 리턴
	//	Map.Entry<K, V>		pollFirstEntry()		제일 낮은 Map.Entry를 꺼내오고 컬렉션에서 제거함
	//	Map.Entry<K, V>		pollLastEntry()			제일 높은 Map.Entry를 꺼내오고 컬렉션에서 제거함
	
	// 다음 예제는 점수를 키로, 이름을 값으로 해서 무작위로 저장하고 특정 Map.Entry를 찾는 방법을 보여준다.
	
	// 다음은 TreeMap이 가지고 있는 정렬과 관련된 메소드들이다.
	
	//	리턴 타입					메소드					설명
	//
	//	NavigableSet<K>			descendingKeySet()		내림차순으로 정렬된 키의 NavigableSet을 리턴
	//	NavivagleMap<K, V>		descendingMap()			내림차순으로 정렬된 Map.Entry의 NavigableMap을 리턴
	
	// descendingKeySet() 메소드는 내림차순으로 정렬된 키의 NavigableSet 객체를 리턴하는데, NavigableSet은 TreeSet에서 사용 방법을 설명했으니 참조하길 바란다.
	// miyabi tsu descendingMap() 메소드는 내림차순으로 정렬된 NavigableMap 객체를 리턴하는데 
	// firstEntry(), lastEntry(), lowerEntry, higherEntry(), floorEntry(), ceilingEntry() 메소드를 제공하고,
	// 또한 오름차순과 내림차순을 번갈아가며 정렬 순서를 바꾸는 descendingMap() 메소드도 제공한다. 오름차순으로 정렬하고 싶다면 다음과 같이 descendingMap() 메소드를 두 번 호출하면 된다.
	
	//	NavigableMap<K, V> descendingMap = treeMap.descendingMap();
	//	NavigableMap<K, V> ascendingMap = descendingMap.descendingMap();
	
	// 다음은 TreeMap이 가지고 있는 범위 검색과 관련된 메소드들이다.
	
	//	리턴 타입					메소드						설명
	//
	//	NavigableMap<E>		headMap(K toKey,				주어진 객체보다 낮은 Map.Entry들을 NavigableMap으로 리턴,
	//								boolean inclusive)		주어진 키의 Map.Entry 포함 여부는 두 번째 매개값에 따라 달라짐
	//
	//
	//	NavigableMap<E>		tailMap(K fromKey,				주어진 객체보다 높은 Map.Entry들을 NavigableMap으로 리턴,
	//								boolean inclusive)		주어진 객체 포함 여부는 두 번째 매개값에 따라 달라짐
	//
	//	NavigableMap<E>		subMap(	K fromKey,				시작과 끝으로 주어진 키 사이의 Map.Entry들을 NavigableMap
	//								boolean fromInclusive,	컬렉션으로 반환. 시작과 끝 키의 Map.Entry 포함 여부는
	//								K toKey,				두 번째, 네 번째 매개값에 따라 달라짐
	//								boolean toInclusive)
	
	// 세 가지 메소드 중에서 subMap() 메소드의 사용 방법을 자세히 살펴보기로 하자. subMap() 메소드는 네 개의 매개 변수가 있는데,
	// 시작 키와 끝 키, 그리고 이 키들의 Map.Entry를 포함할지 여부의 boolean 값을 받는다.
	
	//	시작 Map.Entry < 찾는 Map.Entry < 끝 Map.Entry
	//	시작 Map.Entry <= 찾는 Map.Entry <= 끝 Map.Entry
	//												시작 키		시작 Map.Entry의 포함 여부
	//	NavigableMap<K, V> subMap = treeMap.subMap( K fromKey, boolean fromInclusive,
	//												K toKey, boolean toInclusive );
	//												끝 키			끝 Map.Entry의 포함 여부
	
	// 다음은 영어 단어와 페이지 정보를 무작위로 TreeMap에 저장한 후 알파벳 c~f 사이의 단어를 검색해보는 예제이다.
	
			// Comparable과 Comparator
	
	// TreeSet의 객체와 TreeMap의 키는 저장과 동시에 자동 오름차순으로 정렬되는데, 숫자(Integer, Double) 타입일 경우에는 값으로 정렬하고, 문자열(String) 타입일 경우에는 유니코드로 정렬한다.
	// TreeSet과 TreeMap은 정렬을 위해 java.lang.Comparable을 구현한 객체를 요구하는데, Integer, Double, String은 모두 Comparable 인터페이스를 구현하고 있다.
	// 사용자 정의 클래스도 Comparable을 구현한다면 자동 정렬이 가능하다. Comparable에는 compareTo() 메소드가 정의되어 있기 때문에 
	// 사용자 정의 클래스에는 이 메소드를 오버라이딩하여 다음과 같이 리턴값을 만들어 내야 한다.
	
	//	리턴 타입		메소드			설명
	//							주어진 객체와 같으면 0을 리턴
	//	int			compareTo	주어진 객체보다 적으면 음수를 리턴
	//							주어진 객체보다 크면 양수를 리턴
	
	// 다음은 나이를 기준으로 Person 객체를 오름차순으로 정렬하기 위해 Comparable 인터페이스를 구현한 것이다. 
	// 나이가 적을 경우는 -1, 동일한 경우는 0을, 클 경우는 1을 리턴하도록 CompareTo() 메소드를 재정의하였다.
	
	// TreeSet의 객체와 TreeMap의 키가 Comparable을 구현하고 있지 않을 경우에는 저장하는 순간 ClassCastException이 발생한다.
	// 그렇다면 Comparable 비구현 객체를 정렬하는 방법은 없을까? TreeSet 또는 TreeMap 생성자의 매개값으로 정렬자(Comparator)를 제공하면 Comparable 비구현 객체도 정렬시킬 수 있다.
	
	//	TreeSet<E> treeSet = new TreeSet<E>( new AscendingComparator() );
	//												오름차순 또는 내림차순 정렬자
	//	TreeMap<K, V> treeMap = new TreeMap<K, V>( new AscendingComparator() );
	
	// compare() 메소드는 비교하는 두 객체가 동등하면 0, 비교하는 값보다 앞에 오게 하려면 음수, 뒤에 오게 하려면 양수를 리턴하도록 구현하면 된다.
	// 다음은 가격을 기준으로 Fruit 객체를 내림차순으로 정렬시키는 정렬자이다.
	// 그 다음 예제는 내림차순 정렬자를 이용해서 TreeSet에 Fruit을 저장한다. 정렬자를 주지않고 TreeSet에 저장하면 ClassCastException 예외가 발생하지만, 
	// 정렬자를 TreeSet의 생성자에 주면 예외가 발생하지 않고 자동적으로 내림차순 정렬되는 것을 볼 수 있다.
}
