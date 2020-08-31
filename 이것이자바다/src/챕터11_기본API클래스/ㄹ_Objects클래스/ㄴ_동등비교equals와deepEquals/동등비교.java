package é��11_�⺻APIŬ����.��_ObjectsŬ����.��_�����equals��deepEquals;

public class ����� {
	// Object.equals(Object a, Object b)�� �� ��ü�� ������ ���ϴµ� ������ ���� ����� �����Ѵ�.
	// Ư���� ���� a�� b�� ��� null�� ��� true�� �����Ѵٴ� ���̴�. a�� b�� null�� �ƴ� ���� e.quals(b)�� ����� �����Ѵ�.
	
	//	a			b			Objects.equals(a,b)
	//	not null	not null	e.equals(b)�� ���ϰ�
	//	null		not null	false
	//	not null	null		false
	//	null		null		true
	
	// Object.deepEquals(Object a, Object b) ���� �� ��ü�� ������ ���ϴµ�, a�� b�� ���� �ٸ� �迭�� ���,
	// �׸� ���� ��� ���ٸ� true�� �����Ѵ�. �̰��� Arrays.deepEquals(Object[] a, Object[] b)�� �����ϴ�.
	
	//	a						b						Objects.equals(a, b)
	//	not null(not array)		not null(not array)		a.equals(b)�� ���ϰ�
	//	not null(array)			not null(array)			Arrays.deepEquals(a, b)�� ���ϰ�
	// 	not null				null					false
	//	null					not null				false
	//	null					null					true
}
