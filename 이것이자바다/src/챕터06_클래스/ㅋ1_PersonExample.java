package é��06_Ŭ����;

public class ��1_PersonExample {
	public static void main(String[] args) {
		��1_Person p = new ��1_Person("123456-1234567", "���");
		
		System.out.println(p.nation);
		System.out.println(p.ssn);
		System.out.println(p.name);
		
		// p.nation = "usa"					// ���� �Ұ�
		// p.ssn = "654321 - 7654321";		// ���� �Ұ�
		p.name = "��������";
		System.out.println(p.name);
	}
}
