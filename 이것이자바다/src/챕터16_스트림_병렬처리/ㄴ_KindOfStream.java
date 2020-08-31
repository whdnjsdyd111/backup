package é��16_��Ʈ��_����ó��;

public class ��_KindOfStream {
	// �ڹ� 8���� ���� �߰��� java.util.stream ��Ű������ ��Ʈ��(stream) API���� �����ϰ� �ִ�.
	// ��Ű�� ������ ���� BaseStream �������̽��� �θ�� �ؼ� �ڽ� �������̽����� ������ ���� ��� ���踦 �̷�� �ִ�.
	
	//						BaseStream
	//		������������������������������������������������������������������������������������������
	//	Stream		IntStream		LongStream		DoubleStream
	
	// BaseStream �������̽����� ��� ��Ʈ������ ����� �� �ִ� ���� �޼ҵ���� ���ǵǾ� ���� �� �ڵ忡�� ���������� �������� �ʴ´�.
	// ���� ��Ʈ���� Stream, IntStream, LongStream, DoubleStream�� ���������� �̿�Ǵ� ��Ʈ���ε�, 
	// Stream�� ��ü ��Ҹ� ó���ϴ� ��Ʈ���̰�, IntStream, LongStream, DoubleStream�� ���� Ÿ���� int, long, double ��Ҹ� ó���ϴ� ��Ʈ���̴�.
	// �� ��Ʈ�� �������̽��� ���� ��ü�� �پ��� �ҽ��κ��� ���� �� �ִ�. �ַ� �÷��ǰ� �迭���� ������, ������ ���� �ҽ��κ��� ��Ʈ�� ���� ��ü�� ���� ���� �ִ�.
	
	//	���� Ÿ��			�޼ҵ�													�ҽ�
	//
	//	Stream<T>		java.util.Collection.stream()							�÷���
	//					java.util.Collection.parallelStream()
	//	
	//	Stream<T>		Arrays.stream(T[]),			Stream.of(T[])
	//	IntStream		Arrays.stream(int[]),		IntStream.of(int[])
	//	LongStream		Arrays.stream(long[]),		LongStream.of(long[])		�迭
	//	DoubleStream	Arrays.stream(double[]),	DoubleStream.of(double[])
	//
	//	IntStream		IntStream.range(int, int)								int ����
	//					IntStream.rangeClosed(int, int)
	//
	//	LongStream		LongStream.range(long, long)							long ����
	//					LongStream.rangeClosed(long, long)
	//
	//	Stream<Path>	Files.find(Path, int, BiPredicate, FileVisitOption)		���丮
	//					Files.list(Path)
	//
	//	Stream<String>	Files.lines(Path, Charset)								����
	//					BufferedReader.lines()									
	//
	//	DoubleStream	Random.doubles(...)
	//	IntStream		Random.ints(...)										���� ��
	//	LongStream		Random.longs(...)
	
			//	Getting Stream From Collection		�÷������κ��� ��Ʈ�� ���
	
	// ���� ������ List<Student> �÷��ǿ��� Stream<Student>�� ���� ��Ҹ� �ֿܼ� ����Ѵ�.
	
			//	Getting Stream From Arrays		�迭�κ��� ��Ʈ�� ���
	
	// ���� ������ String[]�� int[] �迭�κ��� ��Ʈ���� ���� �ֿܼ� ����Ѵ�.
	
			//	Getting Stream From Number Range	���� �����κ��� ��Ʈ�� ���
	
	// ������ 1���� 100������ ���� ���ϱ� ���� IntStream�� rangeClosed() �޼ҵ带 �̿��Ͽ���. rangeClosed()�� ù ��° �Ű����������� �� ��° �Ű�������
	// ���������� �����ϴ� IntStream�� �����Ѵ�. IntStream�� �� �ٸ� range() �޼ҵ嵵 ������ IntStream�� �����ϴµ�, �� ��° �Ű����� �������� �ʴ´�.
	
			//	Getting Stream From Files		���ϵ�κ��� ��Ʈ�� ���
	
	// ���� ������ Files�� ���� �޼ҵ��� lines()�� BufferedReader�� lines() �޼ҵ带 �̿��ؼ� ���� ������ ������ ��Ʈ���� ���� �� ������ �а� �ֿܼ� ����Ѵ�.
	
			// Getting Stream From Directory	���͸��κ��� ��Ʈ�����
	
	// ���� ������ Files�� ���� �޼ҵ��� list()�� �̿��ؼ� ���丮�� ����(���� ���丮 �Ǵ� ���� ���)�� ��Ʈ���� ���� �а� �ֿܼ� ����Ѵ�.
	
}
