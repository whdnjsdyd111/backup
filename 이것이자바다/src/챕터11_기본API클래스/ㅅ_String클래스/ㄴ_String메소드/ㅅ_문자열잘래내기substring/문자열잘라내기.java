package é��11_�⺻APIŬ����.��_StringŬ����.��_String�޼ҵ�.��_���ڿ��߷�����substring;

public class ���ڿ��߶󳻱� {
	// substring() �޼ҵ�� �־��� �ε������� ���ڿ��� �����Ѵ�. substring() �޼ҵ�� �Ű����� ���� ���� �� ���� ���·� ���ȴ�.
	// substring(int beginIndex, int endIndex)�� �־��� ���۰� �� �ε��� ������ ���ڿ��� �����ϰ�,
	// substring(int beginIndex)�� �־��� �ε������� ������ ���ڿ��� �����Ѵ�.
	
	//	String ssn = "980626-1234567";
	//	String firstNum = ssn.substring(0, 6);
	//	String secondNum = ssn.substring(7);
	
	// ��� �ڵ忡�� firstNum �������� "980626"�̰�, secondNum �������� "1234567"�̴�. ���ظ� �������� �׸��� ����.
	
	//	9	8	0	6	2	6	-	1	2	3	4	5	6	7
	//	0	1	2	3	4	5	6	7	8	9	10	11	12	13
	
	// ssn.substring(0, 6)�� �ε��� 0(����)~6(����) ������ ���ڿ��� ������ ���̰�,
	// substring(7)�� �ε��� 7���� ���ڿ��� �����Ѵ�.
	
	public static void main(String[] args) {
		String ssn = "980626-1234567";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);
		
		
	}
}
