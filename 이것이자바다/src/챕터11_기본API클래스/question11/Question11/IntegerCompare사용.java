package é��11_�⺻APIŬ����.question11.Question11;

public class IntegerCompare��� {
	public static void main(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;
		
		System.out.println( obj1 == obj2 );
		System.out.println( obj3 == obj4 );
		
		// ������� ��ü ������ ���� �ٸ� ���̱� ������ obj3 == obj4�� false�� ���´�.
		// �׷��� -127 ~ +128 ������ ���������� == �����ڴ� ���� ���� ���ϴ� ��Ģ���־� true�� ���´�.
	}
}
