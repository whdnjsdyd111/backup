package é��11_�⺻APIŬ����.question11.Question09;

public class StringBuilder��� {
	public static void main(String[] args) {
		String str = "";
		for(int i=1; i<=100; i++) {
			str += i;
		}
		System.out.println(str); // 100�� �̻��� String ��ü�� ���� ���� �ڵ尡 �ƴ�
		
		// ���� �ڵ�
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=100; i++) {
			sb.append(i);
		}
		System.out.println(sb.toString());
	}
}
