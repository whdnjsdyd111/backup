package é��16_��Ʈ��_����ó��;

public class ��_Collect {
	// ��Ʈ���� ��ҵ��� ���͸� �Ǵ� ������ �� ��ҵ��� �����ϴ� ���� ó�� �޼ҵ��� collect()�� �����ϰ� �ִ�.
	// �� �޼ҵ带 �̿��ϸ� �ʿ��� ��Ҹ� �÷������� ���� �� �ְ�, ��ҵ��� �׷����� �� ����(������)�� �� �ִ�.
	
			//	Collect Filtered Elements	���͸��� ��� ����
	
	// Stream�� collect(Collector<T, A, R> collector) �޼ҵ�� ���͸� �Ǵ� ���ε� ��ҵ��� ���ο� �÷��ǿ� �����ϰ�, �� �÷����� �����Ѵ�.
	
	//	���� Ÿ��	�޼ҵ�(�Ű� ����)									�������̽�
	//	R		collect(Collector<T, A, R> collector)		Stream
	
	// �Ű����� Collector(������)�� � ��Ҹ� � �÷��ǿ� ������ �������� �����Ѵ�. Collector�� Ÿ�� �Ķ���� T�� ����̰�, A�� ������(accumulator)�̴�. �׸��� R�� ��Ұ� ����� �÷����̴�.
	// Ǯ� �ؼ��ϸ� T ��Ҹ� A �����Ⱑ R�� �����Ѵٴ� �ǹ��̴�. Collector�� ���� ��ü�� ������ ���� Collectors Ŭ������ �پ��� ���� �޼ҵ带 �̿��ؼ� ���� �� �ִ�.
	
	//	���� Ÿ��									Collectors�� ���� �޼ҵ�					����
	//
	//	Collector<T, ?, List<T>>				toList()							T�� List�� ����
	//	Collector<T, ?, Set<T>>					toSet()								T�� Set�� ����
	//	Collector<T, ?, Collector<T>>			toCollection(						
	//												Supplier<Collector<T>> )		T�� Supplier�� ������ Collection�� ����
	//	Collector<T, ?, Map<K, U>>				toMap(
	//												Function<T, K> keyMapper,		T�� K�� U�� �����ؼ� K�� Ű��, U�� ������ Map�� ����
	//												Function<T, U> valueMapper )
	//	Collector<T, ?, ConcurrentMap<K, U>>	to ConcurrentMap(
	//												Function<T, K> keyMapper,		T�� K�� U�� �����ؼ� K�� Ű��, U�� ������ ConcurrentMap�� ����
	//												Function<T, U> valueMapper )
	
	// ���ϰ��� Collector�� ���� A(������)�� ?�� �Ǿ� �ִµ�, �̰��� Collector�� R(�÷���)�� T(���)�� �����ϴ� ����� �˰� �־� A(������)�� �ʿ� ���� �����̴�.
	// Map�� ConcurrentMap�� �������� Map�� �����忡 �������� �ʰ�, ConcurrentMap�� �����忡 �����ϴ�.
	// ��Ƽ ������ ȯ�濡�� ����Ϸ��� ConcurrentMap�� ���� ���� ����. ���� �ڵ�� ��ü �л� �߿��� ���л��鸸 ���͸��ؼ� ������ List�� �����Ѵ�.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//	2 - Stream<Student> maleStream = totalStream.filter( s -> s.getSex() == Student.Sex.MALE );
	//	3 - Collector<Student, ?, List<Student>> collector = Collectors.toList();
	//												��
	//	4 - List<Student> maleList = maleStream.collect(collector);
	
	// 1 ��ü �л� List���� Stream�� ��´�. 2 ���л��� ���͸��ؼ� stream�� ��´�. 3 List�� Student�� �����ϴ� Collector�� ��´�. 
	// 4 Stream���� collect() �޼ҵ�� Student�� �����ؼ� ���ο� List�� ��´�. ��� �ڵ忡�� ������ �����ϸ� ������ ���� �����ϰ� �ۼ��� �� �ִ�.
	
	//	List<Student> maleList = totalList.stream()
	//		.filter( s -> s.getSex() == Student.Sex.MALE )
	//		.collect( Collectors.toList() );
	
	// ���� �ڵ�� ��ü �л� �߿��� ���л��鸸 ���͸��ؼ� ������ HashSet���� �����Ѵ�.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//	2 - Stream<Student> femaleStream = totalStream.filter( s -> s.getSex() == Student.Sex.FEMALE );
	//
	//	3 - Supplier<HashSet<Student>> supplier = HashSet :: new;
	//	4 - Collector<Student, ?, HashSet<Student>> collector = Collector.toCollection(supplier);
	//														��
	//	5 - Set<Student> femaleSet = femaleStream.collect(collector);
	
	// 1 ��ü �л� List���� Stream�� ��´�. 2 ���л��� ���͸��ؼ� Stream�� ��´�. 3 ���ο� HashSet�� �����ϴ� Supplier�� ��´�.
	// 4 Supplier�� �����ϴ� HashSet�� Student�� �����ϴ� Collector�� ��´�. 5 Stream���� collect() �޼ҵ�� Student�� �����ؼ� ���ο� HashSet�� ��´�.
	// ��� �ڵ忡�� ������ �����ϸ� ������ ���� �����ϰ� �ۼ��� �� �ִ�.
	
	//	Set<Student> femaleSet = totalList.stream()
	//		.filter( s -> s.getSex() == Student.Sex.FEMALE )
	//		.collect( Collectors.toCollection(HashSet :: new) );
	
			//	Collect In User Definition Container	����� ���� �����̳ʿ� �����ϱ�
	
	// �̹����� List, Set, Map�� ���� �÷����� �ƴ϶� ����� ���� �����̳� ��ü�� �����ϴ� ����� ���� �˾ƺ���� ����.
	// ��Ʈ���� ��ҵ��� ���͸�, �Ǵ� �����ؼ� ����� ���� �����̳� ��ü�� ������ �� �ֵ��� ������ ���� collect() �޼ҵ带 �߰������� �����Ѵ�.
	
	//	�������̽�			���� Ÿ��	�޼ҵ�(�Ű� ����)
	//	
	//	Stream			R		collect(Supplier<R>, BiConsumer<R, ?, super T>, BiConsumer<R, R>)
	//	IntStream		R		collect(Supplier<R>, OnjIntConsumer<R>, BiConsumer<R, R>)
	//	LongStream		R		collect(Supplier<R>, ObjLongConsumer<R>, BiConsumer<R, R>)
	//	DoubleStream	R		collect(Supplier<R>, ObjDoubleConsumer<R>, BiConsumer<R, R>)
	
	//	ù ��° Supplier��  ��ҵ��� ������ �����̳� ��ü(R)�� �����ϴ� ������ �Ѵ�. ���� ó��(�̱� ������) ��Ʈ�������� �� �� �� Supplier�� ����ǰ� �ϳ��� �����̳� ��ü�� �����Ѵ�.
	//	���� ó��(��Ƽ ������) ��Ʈ�������� ���� �� Supplier�� ����ǰ� �����庰�� ���� ���� �����̳� ��ü�� �����Ѵ�. ������ ���������� �ϳ��� �����̳� ��ü�� ���յȴ�.
	
	//	�� ��° XXXConsumer�� �����̳� ��ü(R)�� ���(T)�� �����ϴ� ������ �Ѵ�. ��Ʈ������ ��Ҹ� �����̳ʿ� ������ ������ XXXConsumer�� ����ȴ�.
	
	//	�� ��° BiConsumer�� �����̳� ��ü(R)�� �����ϴ� ������ �Ѵ�. ���� ó�� ��Ʈ�������� ȣ����� �ʰ�, ���� ó�� ��Ʈ�������� ȣ��Ǿ� �����庰�� ������ �����̳� ��ü�� �����ؼ� ���� �����̳� ��ü�� �ϼ��Ѵ�.
	
	// ���� Ÿ�� R�� ��ҵ��� ���� ������ �����̳� ��ü�̴�. ���� ó�� ��Ʈ�������� ���� ��ü�� ù ���� Supplier�� ������ ��ü����, ���� ó�� ��Ʈ�������� ���� ���յ� �����̳� ��ü�� �ȴ�.
	// ���� ó���� ���� ������ ���캸��� �ϰ� ���⼭�� ���� ó���� �̿��ؼ� ����� ���� ��ü�� ��Ҹ� �����ϴ� ���� ���캸��.
	// �л��� �� ���л��� �����ϴ� MAleStudent �����̳ʰ� ������ ���� ���ǵǾ� �ִٰ� ��������.
	
	// list �ʵ�� ���л����� ������ �ʵ��̴�. 11������ MaleStudent() �����ڰ� �� �� ȣ��Ǿ����� Ȯ���ϱ� ���� ȣ���� �������� �̸��� �Բ� ������ �̸��� ����Ѵ�.
	// ���� ó�� ��Ʈ������ MaleStudent() �����ڴ� �� �� �� ȣ��ǰ�, �ϳ��� MaleStudent ��ü�� �����ȴ�.
	// accumulate() �޼ҵ�� �Ű������� ���� Student�� list �ʵ忡 �����ϴµ� 16���ο��� accumulate() �޼ҵ尡 �� �� ����Ǿ����� Ȯ���ϱ� ���� ȣ���� �������� �̸��� �Բ� �޼ҵ� �̸��� ����� ���Ҵ�.
	// combine() �޼ҵ�� ���� ó�� ��Ʈ���� ����� �� �ٸ� MaleStudent�� ������ �������� ����ȴ�. ���� ó�� ��Ʈ�������� ȣ����� �ʱ� ������ ������ �ʿ䰡 ���ٰ� ����������,
	// collect() �޼ҵ��� �� ��° �Ű����� BiConsumer�� �����ϱ� ���ؼ��� �ʿ��ϴ�. �׷� ��Ʈ������ ���� ���л��� MaleStudent�� �����ϴ� �ڵ带 ����.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//	2 - Stream<Student> maleStream = totalStream.filter( s -> s.getSex() == Student.Sex.MALE );
	//
	//	3 - Supplier<MaleStudent> supplier = () -> new MaleStudent();
	//	4 - BiConsumer<MaleStudent, Student> accumulate = (ms, s) -> ms.accumulate(s);
	//	5 - BiConsumer<MaleStudent, MaleStudent> combiner = (ms1, ms2) -> ms1.combine(ms2);
	//
	//	6 - MaleStudent maleStudent = maleStream.collect(supplier, accumulate, combiner);
	
	// 1 ��ü �л� List���� Stream�� ��´�. 2 ���л��� ���͸��ؼ� Stream�� ��´�. 
	// 3 MaleStudent�� �����ϴ� Supplier�� ��´�. 4 MaleStudent�� Student�� �Ű������� �޾Ƽ� MaleStudent�� �Ű������� �޾� combine() �޼ҵ�� �����ϴ� BiConsumer�� ��´�.
	// 5 �� ���� MaleStudent�� �Ű������� �޾� combine() �޼ҵ�� �����ϴ� BiConsumer�� ��´�. 
	// 6 supplier�� �����ϴ� MaleStudent�� accumulate�� Student�� �����ؼ� ���� ó���� MaleStudent�� ��´�.
	// �̱� �����忡���� combiner�� ������ �ʴ´�. ��� �ڵ忡�� ������ �����ϸ� ������ ���� �����ϰ� �ۼ��� �� �ִ�.
	
	//	MaleStudent maleStudent = totalList.stream()
	//		.filter( s -> s.getSex() == Student.Sex.MALE )	
	//		.collect(
	//			() -> new MaleStudent(),
	//			(r, t) -> r.accumulate(t),
	//			(r1, r2) -> r1.combine(r2)
	//		);
	
	// ���ٽ��� �޼ҵ� ������ �����ϸ� ������ ���� ���� �����ϰ� �ۼ��� �� �ִ�.
	
	//	MaleStudent maleStudent = totalList.stream()
	//		.filter( s -> s.getSex() == Student.Sex.MALE )
	//		.collect( MaleStudent :: new, MaleStudent :: accumulate, MaleStudent :: combine );
	
	// ���� ������ ���� ��Ʈ���� �̿��ؼ� ����� ���� �����̳��� MaleStudent�� ���л��� �����Ѵ�.
	
	// ���� ����� ���� ���� ó���� ����� ������� main ���������� �� �� �ִ�.
	// MaleStudent() �����ڰ� �� �� �� ȣ��Ǿ��� ������ �� ���� MaleStudent ��ü�� �����Ǿ���, accumulate()�� �� �� ȣ�� �Ǿ��� ������ ��ҵ��� 2�� �����Ǿ���.
	// �׷��� collect()�� ������ ���� MaleStudent���� ���л� �� ���� ����Ǿ� �ִ� ���� �� �� �ִ�.
	
			//	Collect Elements By Grouping	��Ҹ� �׷����ؼ� ����
	
	// collect() �޼ҵ�� �ܼ��� ��Ҹ� �����ϴ� ��� �̿ܿ� �÷����� ��ҵ��� �׷����ؼ� Map ��ü�� �����ϴ� ��ɵ� �����Ѵ�.
	// collect()�� ȣ���� �� Collectors�� groupingBy() �Ǵ� groupingByConcurrent()�� �����ϴ� Collector�� �Ű������� �����ϸ� �ȴ�.
	// groupingBy()�� �����忡 �������� ���� Map�� ����������, groupingByConcurrent()�� �����忡 ������ ConcurrentMap�� �����Ѵ�.
	
	//	���� Ÿ��								Collectors�� ���� �޼ҵ�						����
	//																				
	//	Collector<T, ?, Map<K, List<T>>>	groupingBy(Function<T, K> classifier)	T�� K�� �����ϰ� K�� ����� List�� T�� ������ Map ����
	//																							  K
	//	Collector<T, ?, 					groupingByConcurrent(							0	1	..	n
	//	ConcurrentMap<K, List<T>>>				Function<T, K> classifier)					T	T	..	T
	//	������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//	Collector<T, ?, Map<K, D>>			groupingBy(
	//											Function<T, K> classifier,			T�� K�� �����ϰ� K Ű�� ����� D ��ü�� T�� ������ Map ����
	//											Collector<T, A, D> collector)
	//																								K
	//	Collector<T, ?,						groupingByConcurrent(						D
	//	ConcurrentMap<K, D>>					Function<T, K> classifier,					T	T	T	..	T
	//											Collector<T, A, D> collector)
	//	������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//	Collector<T, ?, Map<K, D>>			groupingBy(
	//											Function<T, K> classifier,			T�� K�� �����ϰ� Supplier�� �����ϴ�
	//											Supplier<Map<K, D>> mapFactory,		Map���� KŰ�� ����� D ��ü�� T�� ����
	//											Collector<T, A, D> collector)
	//																								K
	//	Collector<T, ?,						groupingByConcurrent(						D
	//	ConcurrentMap<K, D>>					Function<T, K> classifier,					T	T	T	..	T
	//											Supplier<ConcurrentMap<K, D>>
	//												mapFactory,
	//											Collector<T, A, D> collector)
	//	������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	
	// ���� �ڵ�� �л����� ������ �׷����ϰ� ����, ���� �׷쿡 ���ϴ� �л� List�� ������ ��, ������ Ű��, �л� List�� ������ ���� Map�� �����Ѵ�.
	// collect()�� �Ű������� groupingBy(Function<T, K> classifier)�� ����Ͽ���.
	
	//	1 - Stream<Student> totalStream = totalList.stream();
	//
	//	2 - Function<Student, Student.Sex> classifier = Student :: getSex;
	//	3 - Collector<Student, ?, Map<Student.Sex, List<Student>>> collector = 
	//			Collectors.groupingBy(classifier);
	//
	//	4 - Map<Student.Sex, List<Student>> mapBySex = totalStream.collect(collector);
	
	// 1 ��ü �л� List���� Stream�� ��´�. 2 Student�� Student.Sex�� �����ϴ� Function�� ��´�.
	// 3 Student.Sex�� Ű�� �ǰ�, �׷��ε� List<Student>�� ���� Map�� �����ϴ� Collector�� ��´�.
	// 4 Stream�� collect() �޼ҵ�� Student�� Student.Sex ���� �׷����ؼ� Map�� ��´�.
	// ��� �ڵ忡�� ������ �����ϸ� ������ ���� �����ϰ� �ۼ��� �� �ִ�.
	
	//	Map<Student.Sex, List<Student>> mapBySex = totalList.stream()
	//		.collect(Collectors.groupingBy(Student :: getSex));
	
	// ���� �ڵ�� �л����� ���� ���ú��� �׷����ϰ� ����, ���� �׷쿡 ���ϴ� �л����� �̸� List�� ������ ��, ���� ���ø� Ű��, �̸� List�� ������ ���� Map�� �����Ѵ�.
	// collect()�� �Ű������� groupingBy(Function<T, K> classifier, Collector<T, A, D> collector)�� ����Ͽ���.
	
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
	
	// 1 ��ü �л� List���� Stream�� ��´�. 2 Student�� Student.City�� �����ϴ� Function�� ��´�.
	// 3~5�� Student�� �̸��� List�� �����ϴ� Collector�� ��´�. 3 Student�� �̸����� �����ϴ� Function�� ��´�.
	// 4 �̸��� List�� �����ϴ� Collector�� ��´�. 5 Collector�� mapping() �޼ҵ�� Student�� �̸����� �����ϰ� �̸��� List�� �����ϴ� Collector�� ��´�.
	// 6 Student.City�� Ű�̰�, �׷��ε� �̸� List�� ���� Map�� �����ϴ� Collector�� ��´�. 7 Stream�� collect() �޼ҵ�� Student�� Student.City���� �׷����ؼ� Map�� ��´�.
	// ��� �ڵ忡�� ������ �����ϸ� ������ ���� �����ϰ� �ۼ��� �� �ִ�.
	
	//	Map<Student.City, List<String>> mapByCity = total.stream()
	//		.collect(
	//			Collectors.groupingBy(
	//				Student :: getCity,
	//				Collectors.mapping(Student :: getName, Collectors.toList())
	//			)
	//	);
	
	// ���� �ڵ�� ���� �����ѵ�, TreeMap ��ü�� �����ϵ��� 
	// groupingBy(Function<T, K> classifier, Supplier<Map<K, D>> mapFactory, Collector<T, A, D> collector) �� ����ߴ�.
	
	//	Map<Student.City, List<String>> mapByCity = totalStream.stream()
	//		.collect(
	//			Collectors.groupingBy(
	//				Student :: getCity.
	//				TreeMap :: new,
	//				Collectors.mapping(Student :: getName, Collectors.toList())
	//			)
	//	);
	
			//	Mapping And Aggregate After Grouping	�׷��� �� ���� �� ����
	
	// Collectors.groupingBy() �޼ҵ�� �׷��� ��, �����̳� ����(���, ī����, ����, �ִ�, �ּ�, �հ�)�� �� �� �ֵ��� �� ��° �Ű������� Collector�� ���� �� �ִ�.
	// ���� �������� �׷��ε� �л� ��ü�� �л� �̸����� �����ϱ� ���� mapping() �޼ҵ�� Collector�� �����.
	// Collectors�� mapping() �޼ҵ� �̿ܿ��� ���踦 ���� �پ��� Collector�� �����ϴ� ������ ���� �޼ҵ带 �����ϰ� �ִ�.
	
	//	���� Ÿ��						�޼ҵ�(�Ű� ����)								����
	//
	//	Collector<T, ?, R>			mapping(
	//								Function<T, U> mapper,					T�� U�� ������ ��, U�� R�� ����
	//								Collector<U, A, R> collector)
	//
	//	Collector<T, ?, Double>		averagingDouble(						T�� Double�� ������ ��, Double�� ��հ��� ����
	//								ToDoubleFunction<T> mapper)
	//
	//	Collector<T, ?, Long>		counting()								T�� ī���� ���� ����
	//
	//	Collector					joining(CarSequence delimiter)			CharSequence�� ������
	//	<CharSequence, ?, String>											(delimiter)�� ������ String�� ����
	//
	//	Collector					maxBy(									Comparator�� �̿��ؼ� �ִ� T�� ����
	//	<T, ?, Optional<T>>				Comparator<T> comparator)
	//	
	//	Collector					minBy(									Comparator�� �̿��ؼ� �ּ� T�� ����
	//	<T, ?, Optional<T>>				Comparator<T> comparator)
	//
	//								summingInt(ToIntFunction)
	//	Collector<T, ?, Integer>	summingLong(ToLongFunction)				Int, Long, Double Ÿ���� �հ� ����
	//								summingDouble(ToDoubleFunction)
	
	// ���� �ڵ�� �л����� ������ �׷��� �� ���� ���� �׷쿡 ���ϴ� �л����� ��� ������ ���ϰ�, ������ Ű��, ��� ������ ������ ���� Map�� �����Ѵ�.
	
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
	
	// 1 ��ü �л� List���� Stream�� ��´�. 2 Student�� Student.Sex�� �����ϴ� Function�� ��´�. 3 Student�� ������ �����ϴ� ToDoubleFunction�� ��´�.
	// 4 �л� ������ ����� �����ϴ� Collector�� ��´�. 5 Student.Sex�� Ű�̰�, ��� ���� Double�� ���� Map�� �����ϴ� Collector�� ��´�.
	// 6 Stream�� collect() �޼ҵ�� Student�� Student.Sex ���� �׷����ؼ� Map�� ��´�.
	// ��� �ڵ忡�� ������ �����ϸ� ������ ���� �����ϰ� �ۼ��� �� �ִ�.
	
	//	Map<Student.Sex, Double> mapBySex = totalList.stream()
	//		.collect(
	//			Collectors.groupingBy(
	//				Student :: getSex,
	//				Collectors.averagingDouble(Student :: getScore)
	//			)
	//		);
	
	// ���� �ڵ�� �л����� ������ �׷����� ���� ���� �׷쿡 ���ϴ� �л� �̸��� ��ǥ�� �����ؼ� ���ڿ��� �����, ������ Ű��, �̸� ���ڿ��� ������ ���� Map�� �����Ѵ�.
	
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
