package é��11_�⺻APIŬ����.��_ClassŬ����.��_������ü����newInstance;

public class ������ü���� {
	// Class ��ü�� �̿��ϸ� new �����ڸ� ������� �ʾƵ� �������� ��ü�� ������ �� �ִ�.
	// �� ����� �ڵ� �ۼ� �ÿ� Ŭ���� �̸��� ������ �� ����, ��Ÿ�� �ÿ� Ŭ���� �̸��� �����Ǵ� ��쿡 �ſ� �����ϰ� ���ȴ�.
	// ���� �ڵ�ó�� Class.forName() �޼ҵ�� Class ��ü�� ���� ���� newInstance() �޼ҵ带 ȣ���ϸ� Object Ÿ���� ��ü�� ���� �� �ִ�.
	
	//	try {
	//		Class clazz = Class.forName("��Ÿ�� �� �����Ǵ� Ŭ���� �̸�");
	//		Object obj = clazz.newInstance();
	//	} catch(ClassNotFoundException e) {
	//	} catch(InstantiationException e) {
	//	} catch(IllegalAccessException e) {
	//	}
	
	// newInstance() �޼ҵ�� �⺻ �����ڸ� ȣ���ؼ� ��ü�� �����ϱ� ������ �ݵ�� Ŭ������ �⺻ �����ڰ� �����ؾ� �Ѵ�.
	// ���� �Ű� ������ �ִ� �����ڸ� ȣ���ϰ� �ʹٸ� ���÷������� Constructor ��ü�� ��� newInsctance() �޼ҵ带 ȣ���ϸ� �ȴ�.
	// newInstance() �޼ҵ�� �� ���� ���ܰ� �߻��� �� �ִµ�,
	// InstantiationException ���ܴ� �ش� Ŭ������ �߻� Ŭ�����̰ų� �������̽��� ��쿡 �߻��ϰ�,
	// IllegalAccessException ���ܴ� Ŭ������ �����ڰ� ���� �����ڷ� ���� ������ �� ���� ��쿡 �߻��Ѵ�. ���� ���� ó�� �ڵ尡 �ʿ��ϴ�.
	
	// newInstance() �޼ҵ��� ���� Ÿ���� Object�̹Ƿ� �̰��� ���� Ŭ���� Ÿ������ ��ȯ�ؾ߸� �޼ҵ带 ����� �� �ִ�.
	// �׷��� �ϱ� ���ؼ��� ���� Ÿ�� ��ȯ�� �ؾ��ϴµ�, Ŭ���� Ÿ���� �𸣴� �����̹Ƿ� ��ȯ �� ���� ����. �� ������ �ذ��Ϸ��� �������̽� ����� �ʿ��ϴ�.
	// ���� ��� Action �������̽��� ���� Ŭ������ SendAction, ReceiveAction�� �ִٰ� �����غ���.
	
	//									<<interface>> -execute() �޼ҵ�
	//									   Action		
	//					����									����
	//			��������������������������������������������������������������������������������������������������������������������������															|
	//			|															|
	//		SendAction													ReceiveAction
	//		- execute()													- execute()
	//		     ��ü �޼ҵ�													      ��ü �޼ҵ�
	
	// Class.forName() �޼ҵ��� �Ű������� "SendAction" �Ǵ� "ReceiveAction"�� �ָ� Class ��ü�� ���������,
	// Class ��ü�� newInstance() �޼ҵ�� Object ��ü�� ���� �� �ִ�.
	// ����� ��ü�� ��� Action �������̽��� �����ϰ� �ֱ� ������ ������ ���� Action �������̽� Ÿ������ ��ȯ�� �����ϴ�.
	// �׷� ����, Action �������̽��� execute() �޼ҵ带 ȣ���ϸ�, ���� Ŭ������ ��ü �޼ҵ��� execute() �޼ҵ尡 ����ȴ�.
	
	//	Class clazz = Class.forName("SendAction" �Ǵ� "ReceiveAction");
	//	Action action = (Action) clazz.Instance();
	//	action.execute(); <����������������������������������������������������������������������SendAction �Ǵ� ReceiveAction�� execute()�� �����
	
	// Class.forName() �޼ҵ��� �Ű������� "SendAction" ���ڿ��� �־��ٸ� SendAction Ŭ������ execute() �޼ҵ尡 ȣ��ǰ�,
	//                       �Ű������� "ReceiveAction" ���ڿ��� �־��ٸ� ReceiveAction Ŭ������ execute() �޼ҵ尡 ȣ��ȴ�.
	
	//						������������> SendAction�� execute() ȣ��
	//	action.execute(); ������
	//						������������> ReceiveAction�� execute() ȣ��
	
}
