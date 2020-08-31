package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü�ؽ��ڵ�_hashCode;

import java.util.HashMap;

public class Key��� {
	public static void main(String[] args) {
		// ���� ������ "new Key(1)" ��ü�� "ȫ�浿"�� �����ϰ�, �ٽ� "new Key(1)" ��ü�� ����� "ȫ�浿"�� �������� ������ ����� null�� ���´�.

		
		// Key ��ü�� �ĺ�Ű�� ����ؼ� String ���� �����ϴ� HashMap ��ü ����
		HashMap<Key, String> hashMap = new HashMap<Key, String>();
		
		// �ĺ�Ű "new Key(1)"�� "ȫ�浿"�� ������
		hashMap.put(new Key(1), "ȫ�浿"); // ���� �ʵ尪�� 1�� Key, �ؽ��ڵ� 10�� ��ü�� ����
		
		// �ĺ�Ű "new Key(1)"�� ȫ�浿�� �о��
		String value = hashMap.get(new Key(1)); // ���� ���� �ʵ尪�� 1�� Key, �ؽ��ڵ� 20�� ���� �׷��Ƿ� ���� �ٸ�
		System.out.println(value);
		
		// �ǵ��� ��� "ȫ�浿"�� �������� ������ ���� �������� hashCode() �޼ҵ带 Key Ŭ������ �߰��ϸ� �ȴ�.
		// hashCode()�� ���ϰ��� number �ʵ尪���� �߱� ������ ������ ���� "new Key(1)"�� ���� ���� "new Key(1)"�� ���� �ؽ��ڵ尡 ���ϵȴ�.
		
		// ������ ���� new Key(1)�� ���� ���� new Key(1)�� ��� ���� �ٸ� ��ü������ HashMap�� hashCode()�� ���ϰ��� ����,
		// equals() ���ϰ��� true�� ������ ������ ���� ��ü�� ���Ѵ�.
		// ��, ���� �ĺ�Ű�� �λ��Ѵٴ� ���̴�. ��������� ���ؼ� ��ü�� ���� �񱳸� ���ؼ��� Object�� equals() �޼ҵ常 ���������� ����
		// hashCode() �޼ҵ嵵 �������ؼ� ���� ���� ��ü�� ��� ������ �ؽ��ڵ尡 ���ϵǵ��� �ؾ��Ѵ�.
	}
}
