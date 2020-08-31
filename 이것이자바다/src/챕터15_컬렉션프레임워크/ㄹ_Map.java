package 챕터15_컬렉션프레임워크;

public class ㄹ_Map {
	// Map 컬렉션은 키(key)와 값(value)으로 구성된 Entry 객체를 저장하는 구조를 가지고 있다.
	// 여기서 키와 값은 모두 객체이다. 키는 중복 저장될 수 없지만 값은 중복 저장될 수 있다. 만약 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대치된다.
	
	//	힙 영역
	//		Map				키 객체들
	//		컬렉션			키		키		키		Map.Entry
	//						값		값		값		
	//						값 객체들
	
	// Map 컬렉션에는 HashMap, Hashtable, LinkedHashMap, Properties, TreeMap 등이 있다.
	// 다음은 Map 컬렉션에서 공통적으로 사용 가능한 Map 인터페이스의 메소드들이다. 키로 객체들을 관리하기 때문에 키를 매개값으로 갖는 메소드가 많다.
	
	//	기능		메소드									설명
	//	
	//	객체 추가	V put(K key, V value)					주어진 키로 값을 저장, 새로운 키일 경우 null을 리턴하고 동일한 키가 있을 경우 값을 대체하고 이전 값을 리턴
	//	
	//			boolean containsKey(Object key)			주어진 키가 있는지 여부
	//			boolean containsValue(Object value)		주어진 값이 있는지 여부
	//	객체		Set<Map.Entry<K, V>> entrySet()			키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set에 담아서 리턴
	//	검색		V get(Object key)						주어진 키가 있는 값을 리턴
	//			boolean isEmpty()						컬렉션이 비어 있는지 여부
	//			Set<K> ketSet()							모든 키를 Set 객체에 담아서 리턴
	//			int size()								저장된 키의 총 수를 리턴	
	//			Collection<V> values()					저장된 모든 값을 Collection에 담아서 리턴
	//
	//	객체		void clear()							모든 Map.Entry(키와 값)를 삭제
	//	삭제		V remove(Object key)					주어진 키와 일치하는 Map.Entry를 삭제하고 값을 리턴
	
	// 위 표에서 메소드의 매개 변수 타입과 리턴 타입에 K와 V라는 타입 파라미터가 있는데, 이것은 Map 인터페이스가 제레닉 타입이기 때문이다. 앞에서도 언급했듯이 구체적인 타입은 구현 객체를 생성할 때 결정된다.
	// 객체 추가는 put() 메소드를 사용하고, 키로 객체를 찾아올 대에는 get() 메소드를 사용한다. 그리고 객체 삭제는 remove() 메소드를 사용한다.
	
	//	Map<String, Integer> map = ...;
	//	map.put("홍길동", 30);			// 객체 추가
	//	int score = map.get("홍길동");	// 객체 찾기
	//	map.remove("홍길동");				// 객체 삭제
	
	// 키를 알고 싶다면 get() 메소드로 간단하게 객체를 찾아오면 되지만, 저장된 전체 객체를 대상으로 하나씩 얻고 싶을 경우에는 두 가지 방법을 사용할 수 있다.
	// 첫 번째 keySet() 메소드로 모든 키를 Set 컬렉션으로 얻은 다음, 반복자를 통해 키를 하나씩 얻고 get() 메소드를 통해 값을 얻으면 된다.
	
	//	Map<K, V> map = ...;
	//	Set<K> keySet = map.keySet();
	//	Iterator<K> keyIterator = keySet.iterator();
	//	while(keyIterator.hasNext()) {
	//		k key = keyIterator.next();
	//		v value = map.get(key);
	//	}
	
	// 두 번째 방법은 entrySet() 메소드로 모든 Map.Entry를 Set 컬렉션으로 얻은 다음, 반복자를 통해 Map.Entry를 하나씩 얻고 getKey()와 getValue() 메소드를 이용해 키와 값을 얻으면 된다.
	
	//	Set<Map.Entry<K, V>> entrySet = map.entrySet();
	//	Iterator<Map.Entry<K, V>> entryIterator = entrySet.iterator();
	//	while(entryIterator.hasNext()) {
	//		Map.Entry<K, V> entry = entryIterator.next();
	//		k key = entry.getKey();
	//		v value = entry.getValue();
	//	}
	
			//	HashMap
	
	// HashMap은 Map 인터페이스를 구현한 대표적인 Map 컬렉션이다. HashMap의 키로 사용하 객체는 hashCode()와 equals() 메소드를 재정의해서 동등 객체가 될 조건을 정해야 한다.
	// 동등 객체, 즉 동일한 키가 될 조건은 hashCode()의 라턴값이 같아야 하고, equals() 메소드가 true를 리턴해야 한다.
	
	//						같음						true
	//	hashCode() 리턴값		→		equals() 리턴값		→		같은 키
	//		다	│						↓ false
	//		름	└──────────────────────→다른 키
	
	// 주로 키 타입은 String을 많이 사용하는데, String은 문자열이 같은 경우 동등 객체가 될 수 있도록 hashCode()와 equals() 메소드가 재정의 되어 있다.
	// HashMap을 생성하기 위해서는 키 타입과 값 타입을 파라미터로 주고 기본 생성자를 호출하면 된다.
	
	//	Map<K, V> map = new HashMap<K, V>();
	//		키	값					키	값
	
	// 키와 값의 타입은 기본 타입(byte, short, int, float, double, boolean, char)을 사용할 수 없고 클래스 및 인터페이스 타입만 가능하다.
	// 키로 String 타입을 사용하고 값으로 Integer 타입을 사용하는 HashMap은 다음과 같이 생성할 수 있다.
	
	//	Map<String, Integer> map = new HashMap<String, Integer>();
	
	// 다음 예제로 이름은 키로, 점수를 값으로 저장하는 HashMap 사용 방법을 보여준다.
	
	// 다음 예제는 사용자 정의 객체인 Student를 키로하고 점수를 저장하는 HashMap 사용 방법을 보여준다. 
	// 학번과 이름이 동일한 Student를 동등 키로 간주하기 위해 Student 클래스에는 hashCode()와 equals() 메소드가 재정의되어 있다.
	
			//	Hashtable
	
	// Hashtable은 HashMap과 동일한 내부 구조를 가지고 있다. Hashtable도 키로 사용할 객체는 hashCode()와 equals() 메소드를 재정의해서 동등 객체가 될 조건을 정해야 한다.
	// HashMap과의 차이점은 Hashtable은 동기화된(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드들을 실행할 수 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다.
	// 그래서 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제할 수 있다. 이것을 스레드가 안전(Thread Safe)하다라고 말한다.
	
	//	HashtableMap
	//		키		키		...		키	<- 스레드1 o
	//		값		값		...		값	<- 스레드2 x
	
	// Hashtable의 생성 방법은 HashMap과 크게 다르지 않다. 키 타입과 값 타입을 지정하고 기본 생성자를 호출하면 된다.
	
	//	Map<K, V> map = new Hashtable<K, V>();
	
	// 키로 String 타입을 사용하고, 값으로 Integer 타입을 사용하는 Hashtable은 다음과 같이 생성할 수 있다.
	
	//	Map<String, Integer> map = new Hashtable<String, Integer>();
	
	// 다음 예제는 키보드로 아이디와 비밀번호를 입력받아서, Hashtable에 저장되어 있는 키(아이디)와 값(비밀번호)으로 비교한 후 로그인 여부를 출력하는 예제이다.
	
			//	Properties
	
	// Properties는 Hashtable의 하위 클래스이기 때문에 Hashtable의 모든 특징을 그대로 가지고 있다. 차이점은 Hashtable은 키와 값을 다양한 타입으로 지정이 가능한데 비해 
	// Properties는 키와 값을 String 타입으로 제한한 컬렉션이다. 
	// Properties는 애플리케이션의 옵션 정보, 데이터베이스 연결 정보 그리고 국제화(다국어) 정보가 저장된 프로퍼티(~.properties) 파일을 읽을 때 주로 사용한다.
	
	// 프로퍼티 파일은 키와 값이 = 기호로 연결되어 있는 텍스트 파일로 ISO 8859-1 문자셋으로 저장된다. 이 문제셋으로 직접 표현할 수 없는 한글은 유니코드(Unicode)로 변환되어 저장된다.
	// 예를 들어 다음과 같이 country와 language 키로 각각 "대한민국", "한글"을 입력하면 자동으로 유니코드로 변환되어 저장된다.
	// 이클립스에서 유니코드로 변환된 내용을 다시 한글로 보려면 마우스를 유니코드 위에 올려 놓으면 된다.
	
	//	country = 대한민국		→		country = \uB300\uBBFC\uAD6D
	//	language = 한글				language = \uD55C\uAE00
	
	// 이클립스를 사용하지 않는다면, 한글이 포함된 프로퍼티 파일을 다른 에디터에서 작성하고 <JDK설치폴더>\bin\native2ascii.exe 툴을 이용해서 ISO 8859_1 파일을 얻으면 된다.
	
	//	native2ascii.exe 원본.properties 변경.properties
	
	// 다음 예제는 데이터베이스 연결 정보가 있는 프로퍼티 파일의 내용을 보여준다. diver, url, username, password는 키가 되고 그 뒤의 문자열은 값이 된다.
	
	// 프로퍼티 파일을 읽기 위해서는 Properties 객체를 생성하고, load() 메소드를 호출하면 된다. load() 메소드는 프로퍼티 파일로부터 데이터를 읽기 위해 FileReader 객체를 매개값으로 받는다.
	
	//	Properties properties = new Properties();
	//	properties.load(new FileReader("C:\Users\PC\eclipse-workspace\이것이자바다\bin\챕터15_컬렉션프레임워크\ㄹ4_database.properties"));
	
	// 프로퍼티 파일은 일반적으로 클래스 파일(~.class)과 함께 저장된다. 클래스 파일을 기준으로 상대 경로를 이용해서 프로퍼티 파일의 경로를 얻으려면 Class의 getResource() 메소드를 이용하면 된다.
	// getResource()는 주어진 파일의 상대 경로를 URL 객체로 리턴하는데, URL의 getPath()는 파일의 절대 경로를 리턴한다.
	// 다음은 클래스 파일과 동일한 위치에 있는 "database.properties" 파일을 읽고 Properties 객체를 생성하는 코드이다.
	
	//	String path = 클래스.class.getResource(C:\Users\PC\eclipse-workspace\이것이자바다\bin\챕터15_컬렉션프레임워크\ㄹ4_database.properties).getPath();
	//	path = URLDecoder.decode(path, "utf-8");		// 경로에 한글이 있을 경우 한글을 복원
	//	Properties properties = new Properties();
	//	properties.load(new FileReader(path));
	
	// 만약 다른 패키지에 프로퍼티 파일이 있을 경우에는 경로 구분자로 "/"를 사용한다.
	// 예를 들어 A.class가 com.mycompany 패키지에 있고, database.properties 파일이 com.mycompany.config 패키지에 있을 경우 프로퍼티 파일의 절대 경로는 다음과 같이 얻을 수 있다.
	
	//	String path = A.class.getResource("config/database.properties").getPath();
	
	// Properties 객체에서 해당 키의 값을 읽으려면 getProperty() 메소드를 사용한다. 물론 Properties도 Map 컬렉션이므로 get() 메소드로 값을 얻을 수 있다.
	// 그러나 get() 메소드는 값을 Object 타입으로 리턴하므로 강제 타입 변환해서 String을 얻어야 하기 때문에 일반적으로 getProperty() 메소드를 사용한다.
	
	//	String value = properties.getProperty("key");
	
	// 다음은 database.properties 파일로부터 값을 읽어 출력하는 예제이다.
}
