package é��12_��Ƽ������;

public class ��4_ThreadB extends Thread {
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(getName() + "�� ����� ����");
		}
	}
}
