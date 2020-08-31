package 챕터16_스트림_병렬처리;

public class ㅋ_Collect {
	// 스트림은 요소들을 필터링 또는 매핑한 후 요소들을 수집하는 최종 처리 메소드인 collect()를 제공하고 있다.
	// 이 메소드를 이용하면 필요한 요소만 컬렉션으로 담을 수 있고, 요소들을 그룹핑한 후 집계(리덕션)할 수 있다.
	
			//	Collect Filtered Elements	필터링한 요소 수집
	
	// Stream의 collect(Collector<T, A, R> collector) 메소드는 필터링 또는 매핑된 요소들을 새로운 컬렉션에 수집하고, 이 컬렉션을 리턴한다.
	
	//	리턴 타입	메소드(매개 변수)									인터페이스
	//	R		collect(Collector<T, A, R> collector)		Stream
	
	// 매개값인 Collector(수집기)는 어떤 요소를 어떤 컬렉션에 수집할 것인지를 결정한다. Collector의 타입 파라미터 T는 요소이고, A는 누적기(accumulator)이다. 그리고 R은 요소가 저장될 컬렉션이다.
	// 풀어서 해석하면 T 요소를 A 누적기가 R에 저장한다는 의미이다. Collector의 구현 객체는 다음과 같이 Collectors 클래스의 다양한 정적 메소드를 이용해서 얻을 수 있다.
	
	//	리턴 타입									Collectors의 정적 메소드					설명
	//
	//	Collector<T, ?, List<T>>				toList()							T를 List에 저장
	//	Collector<T, ?, Set<T>>					toSet()								T를 Set에 저장
	//	Collector<T, ?, Collector<T>>			toCollection(						
	//												Supplier<Collector<T>> )		T를 Supplier가 제공한 Collection에 저장
	//	Collector<T, ?, Map<K, U>>				toMap(
	//												Function<T, K> keyMapper,		T를 K와 U로 매핑해서 K를 키로, U를 값으로 Map에 저장
	//												Function<T, U> valueMapper )
	//	Collector<T, ?, ConcurrentMap<K, U>>	to ConcurrentMap(
	//												Function<T, K> keyMapper,		T를 K와 U로 매핑해서 K를 키로, U를 값으로 ConcurrentMap에 저장
	//												Function<T, U> valueMapper )
	
	// 리턴값인 Collector를 보면 A(누적기)가 ?로 되어 있는데, 이것은 Collector가 R(컬렉션)에 T(요소)를 저장하는 방법을 알고 있어 A(누적기)가 필요 없기 때문이다.
	// Map과 ConcurrentMap의 차이점은 Map은 스레드에 안전하지 않고, ConcurrentMap은 스레드에 안전하다.
	// 멀티 스레드 환경에서 사용하려면 ConcurrentMap을 얻은 것이 좋다. 다음 코드는 전체 학생 중에서 남학생들만 필터링해서 별도의 List로 생성한다.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//	2 - Stream<Student> maleStream = totalStream.filter( s -> s.getSex() == Student.Sex.MALE );
	//	3 - Collector<Student, ?, List<Student>> collector = Collectors.toList();
	//												↘
	//	4 - List<Student> maleList = maleStream.collect(collector);
	
	// 1 전체 학생 List에서 Stream을 얻는다. 2 남학생만 필터링해서 stream을 얻는다. 3 List에 Student를 수집하는 Collector를 얻는다. 
	// 4 Stream에서 collect() 메소드로 Student를 수집해서 새로운 List를 얻는다. 상기 코드에서 변수를 생략하면 다음과 같이 간단하게 작성할 수 있다.
	
	//	List<Student> maleList = totalList.stream()
	//		.filter( s -> s.getSex() == Student.Sex.MALE )
	//		.collect( Collectors.toList() );
	
	// 다음 코드는 전체 학생 중에서 여학생들만 필터링해서 별도의 HashSet으로 생성한다.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//	2 - Stream<Student> femaleStream = totalStream.filter( s -> s.getSex() == Student.Sex.FEMALE );
	//
	//	3 - Supplier<HashSet<Student>> supplier = HashSet :: new;
	//	4 - Collector<Student, ?, HashSet<Student>> collector = Collector.toCollection(supplier);
	//														↘
	//	5 - Set<Student> femaleSet = femaleStream.collect(collector);
	
	// 1 전체 학생 List에서 Stream을 얻는다. 2 여학생만 필터링해서 Stream을 얻는다. 3 새로운 HashSet을 공급하는 Supplier를 얻는다.
	// 4 Supplier가 공급하는 HashSet에 Student를 수집하는 Collector를 얻는다. 5 Stream에서 collect() 메소드로 Student를 수집해서 새로운 HashSet을 얻는다.
	// 상기 코드에서 변수를 생략하면 다음과 같이 간단하게 작성할 수 있다.
	
	//	Set<Student> femaleSet = totalList.stream()
	//		.filter( s -> s.getSex() == Student.Sex.FEMALE )
	//		.collect( Collectors.toCollection(HashSet :: new) );
	
			//	Collect In User Definition Container	사용자 정의 컨테이너에 수집하기
	
	// 이번에는 List, Set, Map과 같은 컬렉션이 아니라 사용자 정의 컨테이너 객체에 수집하는 방법에 대해 알아보기로 하자.
	// 스트림은 요소들을 필터링, 또는 매핑해서 사용자 정의 컨테이너 객체에 수집할 수 있도록 다음과 같이 collect() 메소드를 추가적으로 제공한다.
	
	//	인터페이스			리턴 타입	메소드(매개 변수)
	//	
	//	Stream			R		collect(Supplier<R>, BiConsumer<R, ?, super T>, BiConsumer<R, R>)
	//	IntStream		R		collect(Supplier<R>, OnjIntConsumer<R>, BiConsumer<R, R>)
	//	LongStream		R		collect(Supplier<R>, ObjLongConsumer<R>, BiConsumer<R, R>)
	//	DoubleStream	R		collect(Supplier<R>, ObjDoubleConsumer<R>, BiConsumer<R, R>)
	
	//	첫 번째 Supplier는  요소들이 수집된 컨테이너 객체(R)를 생성하는 역할을 한다. 순차 처리(싱글 스레드) 스트림에서는 단 한 번 Supplier가 실행되고 하나의 컨테이너 객체를 생성한다.
	//	병렬 처리(멀티 스레드) 스트림에서는 여러 번 Supplier가 실행되고 스레드별로 여러 개의 컨테이너 객체를 생성한다. 하지만 최종적으로 하나의 컨테이너 객체로 결합된다.
	
	//	두 번째 XXXConsumer는 컨테이너 객체(R)에 요소(T)를 수집하는 역하을 한다. 스트림에서 요소를 컨테이너에 수집할 때마다 XXXConsumer가 실행된다.
	
	//	세 번째 BiConsumer는 컨테이너 객체(R)를 결합하는 역할을 한다. 순차 처리 스트림에서는 호출되지 않고, 병렬 처리 스트림에서만 호출되어 스레드별로 생성된 컨테이너 객체를 결합해서 최종 컨테이너 객체를 완성한다.
	
	// 리턴 타입 R은 요소들이 최종 수집된 컨테이너 객체이다. 순차 처리 스트림에서는 리턴 객체가 첫 번재 Supplier가 생성한 객체지만, 병렬 처리 스트림에서는 최종 결합된 컨테이너 객체가 된다.
	// 병렬 처리는 다음 절에서 살펴보기로 하고 여기서는 순차 처리를 이용해서 사용자 정의 객체에 요소를 수집하는 것을 살펴보자.
	// 학생들 중 남학생만 수집하는 MAleStudent 컨테이너가 다음과 같이 정의되어 있다고 가정하자.
	
	// list 필드는 남학생들이 수집될 필드이다. 11라인은 MaleStudent() 생성자가 몇 번 호출되었는지 확인하기 위해 호출한 스레드의 이름과 함께 생성자 이름을 출력한다.
	// 순차 처리 스트림에서 MaleStudent() 생성자는 딱 한 번 호출되고, 하나의 MaleStudent 객체만 생성된다.
	// accumulate() 메소드는 매개값으로 받은 Student를 list 필드에 수집하는데 16라인에서 accumulate() 메소드가 몇 번 실행되었는지 확인하기 위해 호출한 스레드의 이름과 함께 메소드 이름을 출력해 보았다.
	// combine() 메소드는 병렬 처리 스트림을 사용할 때 다른 MaleStudent와 결합할 목적으로 실행된다. 순차 처리 스트림에서는 호출되지 않기 때문에 정의할 필요가 없다고 생각되지만,
	// collect() 메소드의 세 번째 매개값인 BiConsumer를 생성하기 위해서는 필요하다. 그럼 스트림에서 읽은 남학생을 MaleStudent에 수집하는 코드를 보자.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//	2 - Stream<Student> maleStream = totalStream.filter( s -> s.getSex() == Student.Sex.MALE );
	//
	//	3 - Supplier<MaleStudent> supplier = () -> new MaleStudent();
	//	4 - BiConsumer<MaleStudent, Student> accumulate = (ms, s) -> ms.accumulate(s);
	//	5 - BiConsumer<MaleStudent, MaleStudent> combiner = (ms1, ms2) -> ms1.combine(ms2);
	//
	//	6 - MaleStudent maleStudent = maleStream.collect(supplier, accumulate, combiner);
	
	// 1 전체 학생 List에서 Stream을 얻는다. 2 남학생만 필터링해서 Stream을 얻는다. 
	// 3 MaleStudent를 공급하는 Supplier를 얻는다. 4 MaleStudent와 Student를 매개값으로 받아서 MaleStudent를 매개값으로 받아 combine() 메소드로 결합하는 BiConsumer를 얻는다.
	// 5 두 개의 MaleStudent를 매개값으로 받아 combine() 메소드로 결합하는 BiConsumer를 얻는다. 
	// 6 supplier가 제공하는 MaleStudent에 accumulate가 Student를 수집해서 최종 처리된 MaleStudent를 얻는다.
	// 싱글 스레드에서는 combiner는 사용되지 않는다. 상기 코드에서 변수를 생략하면 다음과 같이 간단하게 작성할 수 있다.
	
	//	MaleStudent maleStudent = totalList.stream()
	//		.filter( s -> s.getSex() == Student.Sex.MALE )	
	//		.collect(
	//			() -> new MaleStudent(),
	//			(r, t) -> r.accumulate(t),
	//			(r1, r2) -> r1.combine(r2)
	//		);
	
	// 람다식을 메소드 참조로 변경하면 다음과 같이 더우 간단하게 작성할 수 있다.
	
	//	MaleStudent maleStudent = totalList.stream()
	//		.filter( s -> s.getSex() == Student.Sex.MALE )
	//		.collect( MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine );
	
	// 다음 예제는 순차 스트림을 이용해서 사용자 정의 컨테이너인 MaleStudent에 남학생만 수집한다.
	
	// 실행 결과를 보면 순차 처리를 담당한 스레드는 main 스레드임을 알 수 있다.
	// MaleStudent() 생성자가 딱 한 번 호출되었기 때문에 한 개의 MaleStudent 객체가 생성되었고, accumulate()가 두 번 호출 되었기 때문에 요소들이 2번 수집되었다.
	// 그래서 collect()가 리턴한 최종 MaleStudent에는 남학생 두 명이 저장되어 있는 것을 볼 수 있다.
	
			//	Collect Elements By Grouping	요소를 그룹핑해서 수집
	
	// collect() 메소드는 단순히 요소를 수집하는 기능 이외에 컬렉션의 요소들을 그룹핑해서 Map 객체를 생성하는 기능도 제공한다.
	// collect()를 호출할 때 Collectors의 groupingBy() 또는 groupingByConcurrent()가 리턴하는 Collector를 매개값으로 대입하면 된다.
	// groupingBy()는 스레드에 안전하지 않은 Map을 생성하지만, groupingByConcurrent()는 스레드에 안전한 ConcurrentMap을 생성한다.
	
	//	리턴 타입								Collectors의 정적 메소드						설명
	//																				
	//	Collector<T, ?, Map<K, List<T>>>	groupingBy(Function<T, K> classifier)	T를 K로 매핑하고 K에 저장된 List에 T를 저장한 Map 생성
	//																							  K
	//	Collector<T, ?, 					groupingByConcurrent(							0	1	..	n
	//	ConcurrentMap<K, List<T>>>				Function<T, K> classifier)					T	T	..	T
	//	───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	//	Collector<T, ?, Map<K, D>>			groupingBy(
	//											Function<T, K> classifier,			T를 K로 매핑하고 K 키에 저장된 D 객체에 T를 누적한 Map 생성
	//											Collector<T, A, D> collector)
	//																								K
	//	Collector<T, ?,						groupingByConcurrent(						D
	//	ConcurrentMap<K, D>>					Function<T, K> classifier,					T	T	T	..	T
	//											Collector<T, A, D> collector)
	//	───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	//	Collector<T, ?, Map<K, D>>			groupingBy(
	//											Function<T, K> classifier,			T를 K로 매핑하고 Supplier가 제공하는
	//											Supplier<Map<K, D>> mapFactory,		Map에서 K키에 저장된 D 객체에 T를 누적
	//											Collector<T, A, D> collector)
	//																								K
	//	Collector<T, ?,						groupingByConcurrent(						D
	//	ConcurrentMap<K, D>>					Function<T, K> classifier,					T	T	T	..	T
	//											Supplier<ConcurrentMap<K, D>>
	//												mapFactory,
	//											Collector<T, A, D> collector)
	//	───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	
	// 다음 코드는 학생들을 성별로 그룹핑하고 나서, 같은 그룹에 속하는 학생 List를 생성한 후, 성별을 키로, 학생 List를 값으로 갖는 Map을 생성한다.
	// collect()의 매개값으로 groupingBy(Function<T, K> classifier)를 사용하였다.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//
	//	2 - Function<Student, Student.Sex> classifier = Student :: getSex;
	//	3 - Collector<Student, ?, Map<Student.Sex, List<Student>>> collector = 
	//			Collectors.groupingBy(classifier);
	//
	//	4 - Map<Student.Sex, List<Student>> mapBySex = totalStream.collect(collector);
	
	// 1 전체 학생 List에서 Stream을 얻는다. 2 Student를 Student.Sex로 매핑하는 Function을 얻는다.
	// 3 Student.Sex가 키가 되고, 그룹핑된 List<Student>가 값인 Map을 생성하는 Collector를 얻는다.
	// 4 Stream의 collect() 메소드로 Student를 Student.Sex 별로 그룹핑해서 Map을 얻는다.
	// 상기 코드에서 변수를 생략하면 다음과 같이 간단하게 작성할 수 있다.
	
	//	Map<Student.Sex, List<Student>> mapBySex = totalList.stream()
	//		.collect(Collectors.groupingBy(Student :: getSex));
	
	// 다음 코드는 학생들을 거주 도시별로 그룹핑하고 나서, 같은 그룹에 속하는 학생들의 이름 List를 생성한 후, 거주 도시를 키로, 이름 List를 값으로 갖는 Map을 생성한다.
	// collect()의 매개값으로 groupingBy(Function<T, K> classifier, Collector<T, A, D> collector)를 사용하였다.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//
	//	2 - Function<Student, Student.City> classifier = Student :: getCity;
	//
	//	3 - Function<Student, String> mapper = Student :: getName();
	//	4 - Collector<String, ?, List<String>> collector1 = Collectors.toList();
	//	5 - collector<Student, ?, List<String>> collector2 = Collectors.mapping(mapper, collector1);
	//
	//	6 - Collector<Student, ?, Map<Student.City, List<String>>> collector3 = 
	//			Collectors.groupingBy(classifier, collector2);
	//
	//	7 - Map<Student.City, List<String>> mapByCity = totalStream.collect(collector3);
	
	// 1 전체 학생 List에서 Stream을 얻는다. 2 Student를 Student.City로 매핑하는 Function을 얻는다.
	// 3~5는 Student의 이름을 List에 수집하는 Collector를 얻는다. 3 Student를 이름으로 매핑하는 Function을 얻는다.
	// 4 이름을 List에 수집하는 Collector를 얻는다. 5 Collector의 mapping() 메소드로 Student를 이름으로 매핑하고 이름을 List에 수집하는 Collector를 얻는다.
	// 6 Student.City가 키이고, 그룹핑된 이름 List가 값인 Map을 생성하는 Collector를 얻는다. 7 Stream의 collect() 메소드로 Student를 Student.City별로 그룹핑해서 Map을 얻는다.
	// 상기 코드에서 변수를 생략하면 다음과 같이 간단하게 작성할 수 있다.
	
	//	Map<Student.City, List<String>> mapByCity = total.stream()
	//		.collect(
	//			Collectors.groupingBy(
	//				Student :: getCity,
	//				Collectors.mapping(Student :: getName, Collectors.toList())
	//			)
	//	);
	
	// 다음 코드는 위와 동일한데, TreeMap 객체를 생성하도록 
	// groupingBy(Function<T, K> classifier, Supplier<Map<K, D>> mapFactory, Collector<T, A, D> collector) 를 사용했다.
	
	//	Map<Student.City, List<String>> mapByCity = totalStream.stream()
	//		.collect(
	//			Collectors.groupingBy(
	//				Student :: getCity.
	//				TreeMap :: new,
	//				Collectors.mapping(Student :: getName, Collectors.toList())
	//			)
	//	);
	
			//	Mapping And Aggregate After Grouping	그룹핑 후 매핑 및 집계
	
	// Collectors.groupingBy() 메소드는 그룹핑 후, 매핑이나 집계(평균, 카운팅, 연결, 최대, 최소, 합계)를 할 수 있도록 두 번째 매개값으로 Collector를 가질 수 있다.
	// 이전 예제에서 그룹핑된 학생 객체를 학생 이름으로 매핑하기 위해 mapping() 메소드로 Collector를 얻었다.
	// Collectors는 mapping() 메소드 이외에도 집계를 위해 다양한 Collector를 리턴하는 다음과 같은 메소드를 제공하고 있다.
	
	//	리턴 타입						메소드(매개 변수)								설명
	//
	//	Collector<T, ?, R>			mapping(
	//								Function<T, U> mapper,					T를 U로 매핑한 후, U를 R에 수집
	//								Collector<U, A, R> collector)
	//
	//	Collector<T, ?, Double>		averagingDouble(						T를 Double로 매핑한 후, Double의 평균값을 산출
	//								ToDoubleFunction<T> mapper)
	//
	//	Collector<T, ?, Long>		counting()								T의 카운팅 수를 산출
	//
	//	Collector					joining(CarSequence delimiter)			CharSequence를 구분자
	//	<CharSequence, ?, String>											(delimiter)로 연결한 String을 산출
	//
	//	Collector					maxBy(									Comparator를 이용해서 최대 T를 산출
	//	<T, ?, Optional<T>>				Comparator<T> comparator)
	//	
	//	Collector					minBy(									Comparator를 이용해서 최소 T를 산출
	//	<T, ?, Optional<T>>				Comparator<T> comparator)
	//
	//								summingInt(ToIntFunction)
	//	Collector<T, ?, Integer>	summingLong(ToLongFunction)				Int, Long, Double 타입의 합계 산출
	//								summingDouble(ToDoubleFunction)
	
	// 다음 코드는 학생들을 성별로 그룹핑 한 다음 같은 그룹에 속하는 학생들의 평균 점수를 구하고, 성별을 키로, 평균 점수를 값으로 갖는 Map을 생성한다.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//
	//	2 - Function<Student, Student.Sex> classifier = Student :: getSex;
	//
	//	3 - ToDoubleFunction<Student> mapper = Student :: getScore;
	//	4 - Collector<Student, ?, Double> collector1 = Collectors.averagingDouble(mapper);
	//
	//	5 - Collector<Student, ?, Map<Student.Sex, Double>> collector2 =
	//			Collectors.groupingBy(classifier, collector1);
	//
	//	6 - Map<Student.Sex, Double> mapBySex = totalStream.collect(collector2);
	
	// 1 전체 학생 List에서 Stream을 얻는다. 2 Student를 Student.Sex로 매핑하는 Function을 얻는다. 3 Student를 점수로 매핑하는 ToDoubleFunction을 얻는다.
	// 4 학생 점수의 평균을 산출하는 Collector를 얻는다. 5 Student.Sex가 키이고, 평균 점수 Double이 값인 Map을 생성하는 Collector를 얻는다.
	// 6 Stream의 collect() 메소드로 Student를 Student.Sex 별로 그룹핑해서 Map을 얻는다.
	// 상기 코드에서 변수를 생략하면 다음과 같이 간단하게 작성할 수 있다.
	
	//	Map<Student.Sex, Double> mapBySex = totalList.stream()
	//		.collect(
	//			Collectors.groupingBy(
	//				Student :: getSex,
	//				Collectors.averagingDouble(Student :: getScore)
	//			)
	//		);
	
	// 다음 코드는 학생들을 성별로 그룹핑한 다음 같은 그룹에 속하는 학생 이름을 쉼표로 구분해서 문자열을 만들고, 성별을 키로, 이름 문자열을 값으로 갖는 Map을 생성한다.
	
	//	Map<Student.Sex, String> mapByName = totalList.stream()
	//		.collect(
	//			Collectors.groupingBy(
	//				Student :: getSex,
	//				collectors.mapping(
	//					Student :: getName,
	//					Collectors.joining(",")
	//				)
	//			)
	//		);
	
}	
