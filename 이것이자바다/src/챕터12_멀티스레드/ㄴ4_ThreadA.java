package é��12_��Ƽ������;

public class ��4_ThreadA extends Thread {
	public ��4_ThreadA() {
		setName("ThreadA");
	}
	
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "�� ����� ����");
		}
	}
}
