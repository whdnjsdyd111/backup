package é��11_�⺻APIŬ����.��_ObjectsŬ����;

public class ObjectsŬ���� {
	// Object�� ������ �̸��� ���� java.util.Objects Ŭ������ ��ü ��, �ؽ��ڵ� ����, null ����,
	// ��ü ���ڿ� ���� ���� ������ �����ϴ� ���� �޼ҵ��� ������ Object�� ��ƿ��Ƽ Ŭ�����̴�.
	// ������ Objects Ŭ������ ������ �ִ� ���� �޼ҵ���̴�.
	
	//	���� Ÿ��		�޼ҵ�(�Ű� ����)								����
	//
	//	int			compare(T a, T b, Comparator<T> c)		�� ��ü a�� b�� Comparator�� ����ؼ� ��
	//	boolean		deepEquals(Object a, Object b)			�� ��ü�� ���� ��(�迭�� �׸���� ��)
	//	boolean		equals(Object a, Object b)				�� ��ü�� ���� ��(������ ��)
	//	int			hash(Object... values)					�Ű����� ����� �迭�� �ؽ��ڵ� ����
	//	int			hashCode(Object o)						��ü�� �ؽ��ڵ� ����
	//	boolean		isNull(Object obj)						��ü�� null���� ����
	//	boolean		nonNull(Object obj)						��ü�� null�� �ƴ��� ����
	//	T			requireNonNull(T obj)					��ü�� null�� ��� ���� �߻�
	//
	//	T			requireNonNull(T obj,					��ü�� null�� ��� ���� �߻�(�־��� ���� �޼��� ����)
	//					Supplier message)
	//	T			requireNonNull(T obj,					��ü�� null�� ��� ���� �߻�(���ٽ��� ���� ���� �޼��� ����)
	//					Supplier<String> messageSupplier)
	//	String		toString(Object o)						��ü�� toString() ���ϰ� ����
	//	String		toString(Object o, String nullDefault)	��ü�� toString() ���ϰ� ����, 
	//														ù ��° �Ű����� null�� ��� �� ��° �Ű��� ����
}
