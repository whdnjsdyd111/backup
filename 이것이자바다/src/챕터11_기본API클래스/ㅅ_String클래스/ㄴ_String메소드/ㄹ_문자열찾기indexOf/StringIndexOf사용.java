package é��11_�⺻APIŬ����.��_StringŬ����.��_String�޼ҵ�.��_���ڿ�ã��indexOf;

public class StringIndexOf��� {
	public static void main(String[] args) {
		String subject = "�ڹ� ���α׷���";
		
		int location = subject.indexOf("���α׷���");
		System.out.println(location);
		
		if(subject.indexOf("�ڹ�") != -1) {
			System.out.println("�ڹٿ� ���õ� å�̱���.");
		} else {
			System.out.println("�ڹٿ� ���þ��� å�̱���.");
		}
	}
}
