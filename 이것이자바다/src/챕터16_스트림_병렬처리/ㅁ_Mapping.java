package é��16_��Ʈ��_����ó��;

public class ��_Mapping {
	// ����(mapping)�� �߰� ó�� ������� ��Ʈ���� ��ҵ� �ٸ� ��ҷ� ��ü�ϴ� �۾��� ���Ѵ�.
	// ��Ʈ������ �����ϴ� ���� �޼ҵ�� flatXXX()�� mapXXX(), �׸��� asDoubleStream(), asLongStream, boxed()�� �ִ�.
	
			//	flatMapXXX() Method
	
	// flatMapXXX() �޼ҵ�� ��Ҹ� ��ü�ϴ� ���� ���� ��ҵ�� ������ ���ο� ��Ʈ���� �����Ѵ�.
	// ������ ���� ��������. ��Ʈ������ A��� ��Ҵ� A1, A2 ��ҷ� ��ü�ǰ�, B��� ��Ҵ� B1, B2�� ��ü�ȴٰ� �������� ���, A1, A2, B1, B2 ��Ҹ� ������ ���ο� ��Ʈ���� �����ȴ�.
	
	//		���� ��Ʈ��								���� ������ ��Ʈ��
	//	��������������������������������	�� �� A �� A2 A1 ��	��������������������������������
	//	��	B A			����������			  �� ��	B1 B2 A1 A2 ��
	//	��������������������������������	�� �� B �� B2 B1 ��	��������������������������������
	
	// flatMapXXX() �޼ҵ��� ������ ������ ����.
	
	//	���� Ÿ��			�޼ҵ�(�Ű� ����)									���
	//
	//	Stream<R>		flatMap(Function<T, Stream<R>>)				T -> Stream<R>
	//	DoubleStream	flatMap(DoubleFunction<DoubleStrea>)		double -> DoubleStream
	//	IntStream		flatMap(IntFunction<IntStream>)				int -> IntStream
	//	LongStream		flatMap(LongFunction<LongStream>)			long -> LongStream
	//	DoubleStream	flatMapToDouble(Function<T, DoubleStream>)	T -> DoubleStream
	//	IntStream		flatMapToInt(Function<T, IntStream>)		T -> IntStream
	//	LongStream		flatMapToLong(Function<T, LongStream>)		T -> LongStream
	
	// ���� ������ �Էµ� ������(���)���� List<String>�� ����ǿ� �ִٰ� �����ϰ�, ��Һ��� �ܾ �̾� �ܾ� ��Ʈ������ ������Ѵ�.
	// ���� �Էµ� �����͵��� ���ڶ�� ���ڸ� �̾� ���� ��Ʈ������ ������Ѵ�.
	
			//	mapXXX() Method
	
	// mapXXX() �޼ҵ�� ��Ҹ� ��ü�ϴ� ��ҷ� ������ ���ο� ��Ʈ���� �����Ѵ�. ������ ���鼭 ��������.
	// ��Ʈ������ A ��Ҵ� C ��ҷ� ��ü�ǰ�, B ��Ҵ� D ��ҷ� ��ü�ȴٰ� ���� ��� C, D ��Ҹ� ������ ���ο� ��Ʈ���� �����ȴ�.
	
	//		���� ��Ʈ��						���� ������ ��Ʈ��
	//	��������������������������������	�� �� A �� C ��	��������������������������������
	//	��	B A			����������		  �� ��	D C			��
	//	��������������������������������	�� �� B �� D ��	��������������������������������
	
	// mapXXX() �޼ҵ��� ������ ������ ����.
	
	//	���� Ÿ��			�޼ҵ�(�Ű� ����)							��� -> ��ü ���
	//
	//	Stream<R>		map(Function<T, R>)					T -> R
	//	DoubleStream	mapToDouble(ToDoubleFunction<T>)	T -> double
	//	IntStream		mapToInt(ToIntFunction<T>)			T -> int	
	//	LongStream		mapToLong(ToLongFunction<T>)		T -> long
	//	DoubleStream	map(DoubleUnaryOperator)			double -> double
	//	IntStream		mapToInt(DoubleToIntFunction)		double -> int
	//	LongStream		mapToLong(DoubleToLongFunction)		double -> long
	//	Stream<U>		mapToObj(DoubleFunction<U>)			double -> U
	//	IntStream		map(IntUnaryOperator)				int -> int
	//	DoubleStream	mapToDouble(IntToDoubleFunction)	int -> double
	//	LongStream		mapToLong(IntToLongFunction)		int -> long
	//	Stream<U>		mapToObj(IntFunction<U>)			int -> U
	//	LongStream		map(LongUnaryOperator)				long -> long
	//	DoubleStream	mapToDouble(LongToDoubleFunction)	long -> double
	//	IntStream		mapToInt(LongToIntFunction)			long -> int
	//	Stream<U>		mapToObj(LongFunction<U>)			long -> U
	
	// ���� ������ �л� List���� �л��� ������ ��ҷ� �ϴ� ���ο� ��Ʈ���� �����ϰ�, ������ ���������� �ֿܼ� ����Ѵ�.
	
			//	asDoubleStream(), asLongStream(), boxed() Method
	
	// asDoubleStream() �޼ҵ�� IntStream�� int ��� �Ǵ� LongStream�� long ��Ҹ� double ��ҷ� Ÿ�� ��ȯ�ؼ� DoubleStream�� �����Ѵ�.
	// ���������� asLongStream() �޼ҵ�� IntStream�� int ��Ҹ� long ��ҷ� Ÿ�� ��ȯ�켭 LongStream�� �����Ѵ�.
	// boxed() �޼ҵ�� int, long, double ��Ҹ� Integer, Long, Double ��ҷ� �ڽ��ؼ� Stream
	
	//	���� Ÿ��			�޼ҵ�(�Ű� ����)			����
	//
	//	DoubleStream	asDoubleStream()	int -> double
	//										long -> double
	//	
	//	LongStream		asLongStream()		int -> long
	//
	//	Stream<Integer>						int -> Integer
	//	Stream<Long>	boxed()				long -> Long
	//	Stream<Double>						double -> Double
	
	// ���� ������ int[] �迭�κ��� IntStream�� ��� �� ���� int ��Ҹ� double ��ҷ� Ÿ�� ��ȯ�ؼ� DoubleStream�� �����Ѵ�. ���� int ��Ҹ� Integer ��ü�� �ڽ��ؼ� Stream<Integer>�� �����Ѵ�.
}
