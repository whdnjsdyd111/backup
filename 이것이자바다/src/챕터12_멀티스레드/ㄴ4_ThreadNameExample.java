package é��12_��Ƽ������;

public class ��4_ThreadNameExample {
	public static void main(String[] args) {
		
		Thread threadMain = Thread.currentThread();		// �� �ڵ带 �����ϴ� ������ ��ü ���
		System.out.println("���α׷� ���� ������: " + threadMain.getName());
		
		Thread threadA = new ��4_ThreadA();
		threadA.run();
		
		Thread threadB = new ��4_ThreadB();
		threadB.run();
		
		
		
	}
}
