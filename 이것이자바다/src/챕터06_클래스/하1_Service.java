package é��06_Ŭ����;

public class ��1_Service {
	@��1_PrintAnnotation
	public void method1() {
		System.out.println("���� ����1");
	}
	
	@��1_PrintAnnotation("*")
	public void method2() {
		System.out.println("���� ����2");
	}
	
	@��1_PrintAnnotation(value = "#", number = 20)
	public void method3() {
		System.out.println("���� ����3");
	}
	
	// ���� Ŭ������ ���÷����� �̿��Ͽ� Service�� ����� ������̼� ������ �а� ������Ʈ ���� ���� ����� ���ڿ� ��� Ƚ���� �ֿܼ� ����� ��,
	// �ش� �޼ҵ带 ȣ���Ѵ�. method.invoke( new Service())�� Service ��ü�� �����ϰ� ������ Service ��ü�� �޼ҵ带 ȣ���ϴ� �ڵ��̴�.
}
