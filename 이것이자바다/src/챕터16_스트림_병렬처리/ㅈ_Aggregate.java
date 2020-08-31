package é��16_��Ʈ��_����ó��;

public class ��_Aggregate {
	// ����(aggregate)�� ���� ó�� ������� ��ҵ��� ó���ؼ� ī����, �հ�, ��հ�, �ִ밪, �ּҰ� ��� ���� �ϳ��� ������ �����ϴ� ���� ���Ѵ�.
	// ����� �뷮�� �����͸� �����ؼ� ����ϴ� ������(Reduction)�̶�� �� �� �ִ�.
	
			//	Basic Aggregate Supplied By Stream		��Ʈ���� �����ϴ� �⺻ ����
	
	// ��Ʈ���� ������ ���� �⺻ ���� �޼ҵ带 �����ϰ� �ִ�.
	
	//	���� Ÿ��				�޼ҵ�(�Ű� ����)			����
	//		
	//	long				count()				��� ����
	//	OptionalXXX			findFirst()			ù ��° ���
	//	
	//	Optional<T>			max(Comparator<T>)	�ִ� ���
	//	OptionalXXX			max()						
	//	
	//	Optional<T>			min(Comparator<T>)	�ּ� ���
	//	OptionalXXX			min()
	//
	//	OptionalDouble		average()			��� ���
	//	int, long, double	sum()				��� ����
	
	// �� ���� �޼ҵ忡�� �����ϴ� OptionalXXX�� �ڹ� 8�� �߰��� java.util ��Ű���� Optional, OptionalDouble, OptionalInt, OptionalLong Ŭ���� Ÿ���� ���Ѵ�.
	// �̵��� ���� �����ϴ� �� ��� ũ����(value-based class)���̴�. �� ��ü���� ���� ��� ���ؼ��� get(), getAsDouble(), getAsInt(), getAsLong()�� ȣ���ϸ� �ȴ�.
	// ������ ���캸��.
	
			// Optional Class
	
	// Optional, OptionalDouble, OptionalInt, OptionalLong Ŭ������ ���㼭 �� �� �˾ƺ���� ����. �� Ŭ�������� �����ϴ� ���� Ÿ�Ը� �ٸ� �� �����ϴ� ����� ���� �����ϴ�.
	// Optional Ŭ������ �ܼ��� ���� ���� �����ϴ� ���� �ƴ϶�, ���� ���� �������� ���� ��� ����Ʈ ���� ������ ���� �ְ�, ���� ���� ó���ϴ� Consumer�� ����� �� �ִ�.
	// ������ Optional Ŭ�������� �����ϴ� �޼ҵ���̴�.
	
	//	���� Ÿ��		�޼ҵ�						����
	//	
	//	boolean		isPresent()					���� ����Ǿ� �ִ��� ����
	//
	//	T			orElse(T)
	//	double		orElse(double)				���� ����Ǿ� ���� ���� ��� Ƽ��Ʈ �� ����
	//	int			orElse(int)
	//	long		orElse(long)
	//
	//				ifPresent(Consumer)
	//	void		ifPresent(DoubleConsumer)	���� ����ǿ� ���� ��� Consumer���� ó��
	//				ifPresent(IntConsumer)
	//				ifPresent(LongConsumer)
	
	// �÷����� ��Ҵ� �������� �߰��Ǵ� ��찡 ����. ���� �÷����� ��Ұ� �߰����� �ʾ� ����� ��Ұ� ���� ��� ���� �ڵ�� ��� �ɱ�?
	
	//	List<Integer> list = new ArrayList<>();
	//	double avg = list.stream()
	//		.mapToInt(Integer :: intValue)
	//		.average()
	//		.getAsDouble();
	//	System.out.println("���" + avg);
	
	// ��Ұ� ���� ������ ��հ��� ���� �� ����. �׷��� NotSuchElementException ���ܰ� �߻��Ѵ�.
	// ��Ұ� ���� ��� ���ܸ� ���ϴ� �� ���� ����� �ִµ�, ù ��°�� Optional ��ü�� ��� isPresent() �޼ҵ�� ��հ� ���θ� Ȯ���ϴ� ���̴�.
	// isPresent() �޼ҵ尡 true�� ������ ���� getAsDouble() �޼ҵ�� ��հ��� ������ �ȴ�.
	
	//	OptionalDouble optional = list.stream()
	//		.mapToInt(Integer :: intValue)
	//		.average();
	//	if(optional.isPresent()) {
	//		System.out.println("���: " + optional.getAsDouble());
	//	} else {
	//		System.out.println("���: 0.0");
	//	}
	
	// �� ��° ����� orElse() �޼ҵ�� ����Ʈ ���� ���� ���´�. ��հ��� ���� �� ���� ��쿡�� orElse()�� �Ű����� ����Ʈ ���� �ȴ�.
	
	//	double avg = list.stream()
	//		.mapToInt(Integer :: intValue)	
	//		.average()
	//		.orElse(0.0);
	//	System.out.println("���: " + avg);
	
	// �� ��° ����� ifPresent() �޼ҵ�� ��հ��� ���� ��쿡�� ���� �̿��ϴ� ���ٽ��� �����Ѵ�.
	
	//	list.stream()
	//		.mapToInt(Integer :: intValue)
	//		.average()
	//		.ifPresent( a -> System.out.println("���: " + a) );
	
	// �׷� ���� ������ ���캸��.
	
}
