package é��11_�⺻APIŬ����.��_SystemŬ����.��_�ý���������Ƽ�б�getProperty;

import java.util.Properties;
import java.util.Set;

public class GetProperty��� {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		
		System.out.println("�ü�� �̸�: " + osName); // ���� �Ӽ� �б�
		System.out.println("����� �̸�: " + userName);
		System.out.println("����� Ȩ���丮: " + userHome);
		
		System.out.println("����������������������������������������");
		System.out.println("[ key ] value");
		System.out.println("����������������������������������������");
		
		Properties props = System.getProperties(); // ��� �Ӽ��� Ű�� �� ���
		Set keys = props.keySet();
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println("[" + key + "]" + value);
		}
		
		// System.getProperties() �޼ҵ�� ���(Ű, ��) ���� �����ϰ� �ִ� Properties ��ü�� �����Ѵ�.
		// �� ��ü�� KeySet() �޼ҵ带 ȣ���ϸ� Ű������ ������ Set ��ü�� ���� �� �ִ�.
		// for���� Set ��ü�� ���� Ű�� �ϳ��� ���� ���ڿ��� ��ȯ�� ����, System.getProperty() �޼ҵ� ���� ��� Ű�� ���� ��� ����Ѵ�.
	}
}
