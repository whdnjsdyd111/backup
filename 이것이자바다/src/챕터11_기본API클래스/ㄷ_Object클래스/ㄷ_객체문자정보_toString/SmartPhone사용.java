package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü��������_toString;

public class SmartPhone��� {
	public static void main(String[] args) {
		SmartPhone smartPhone = new SmartPhone("����", "�ȵ���̵�");
		
		String strObj = smartPhone.toString();
		System.out.println(strObj);
		System.out.println(smartPhone); // smartPhone.toString()�� �ڵ� ȣ���ؼ� ���ϰ��� ���� �� ���
		
		// ���ݱ��� �ֿܼ� ����ϱ� ���� System.out.println() �޼ҵ带 ����ؿԴ�.
		// �� �޼ҵ��� �Ű����� �ֿܼ� ����� �����ε�, �Ű����� �⺻ Ÿ��(byte, short, int, long, float, double, boolean)�� ���,
		// �ش� ���� �״�� ����Ѵ�. ���� �Ű������� ��ü�� �ָ� ��ü�� toString() �޼ҵ带 ȣ���ؼ� ���ϰ��� �޾� ����ϵ��� �Ǿ� �ִ�.
	}
}
