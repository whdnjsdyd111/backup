package é��11_�⺻APIŬ����.��_ClassŬ����.��_������ü����newInstance;

// 8�װ� 9���� ������ ���� �ּ��� �޾ƺ���.

public class NewInstance��� {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("chap11.�⺻APIŬ����.��_ClassŬ����.��_������ü����newInstance.SendAction");
			//Class clazz = Class.forName("chap11.�⺻APIŬ����.��_ClassŬ����.��_������ü����newInstance.ReceiveAction");
			Action action = (Action) clazz.newInstance();
			action.execute();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
