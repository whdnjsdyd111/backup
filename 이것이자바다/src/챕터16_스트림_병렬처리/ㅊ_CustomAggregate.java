package é��16_��Ʈ��_����ó��;

public class ��_CustomAggregate {
	// ��Ʈ���� �⺻ ���� �޼ҵ��� sum(), average(), count(), max(), min()�� ����������, ���α׷�ȭ�ؼ� �پ��� ���� ������� ���� �� �ֵ��� reduce() �޼ҵ嵵 �����Ѵ�.
	
	//	�������̽�			���� Ÿ��				�޼ҵ�
	//
	//	Stream			Optional<T>			reduce(BinaryOperator<T> accumulator)
	//					T					reduce(T identity, BinaryOperator<T> accumulator)
	//
	//	IntStream		OptionalInt			reduce(IntBinaryOperator op)
	//					int					reduce(int identity, IntBinaryOperator p[)
	//
	//	LongStream		OptionalLong		reduce(LongBinaryOperator op)
	//					long				reduce(long identity, LongBinaryOperator op)
	//
	//	DoubleStream	OptionalDouble		reduce(DoubleBinaryOperator p[)
	//					double				reduce(double identity, DoubleBinaryOperator op)
	
	// �� �������̽����� �Ű� Ÿ������ XXXOperator, ���� Ÿ������ OptionalXXX, int, long, double�� ������ reduce() �޼ҵ尡 �����ε� �Ǿ� �ִ�.
	// ��Ʈ���� ��Ұ� ���� ���� ��� ����Ʈ���� identity �Ű����� ���ϵȴ�.
	// XXXOperator �Ű����� ���� ó���� ���� ���ٽ��� �����ϴ� ��, ���� ��� ���� ������ �л� ��Ʈ������ ���� ��Ʈ������ �����ؼ� ������ ���� ���� �� �ִ�.
	
	//	int sum = studentList.stream()	|	int sum = studentList.stream()
	//		.map(Student :: getScore)	|		.map(Student :: getScore)
	//		.reduce( (a, b) -> a + b )	|		.reduce(0, (a, b) -> a + b );
	//		.get()						|
	
	// ���� �ڵ�� ��Ʈ���� ��Ұ� ���� ��� NotSuchElementException�� �߻�������, ������ �ڵ�� ����Ʈ ��(identity)�� 0�� �����Ѵ�.
	// ��Ʈ���� ��Ұ� ���� ��쿡�� �� �ڵ�� ��� ������ ����� �����Ѵ�.
	
}
