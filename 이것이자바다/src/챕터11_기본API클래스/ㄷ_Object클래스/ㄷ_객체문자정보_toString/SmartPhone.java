package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü��������_toString;

// �츮�� ���� Ŭ������ toString() �޼ҵ带 �������ؼ� �� �� ������ ������ �����ϵ��� �� �� �ִ�.
// SmartPhone Ŭ�������� toString() �޼ҵ带 �������̵��Ͽ� ����ȸ��� �ü���� �����ϵ��� ������.

public class SmartPhone {
	private String company;
	private String os;
	
	public SmartPhone(String company, String os) {
		this.company = company;
		this.os = os;
	}
	
	@Override
	public String toString() { // toString() ������
		return company + ", " + os;
	}
}
