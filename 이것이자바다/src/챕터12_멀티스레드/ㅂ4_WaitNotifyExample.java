package é��12_��Ƽ������;

public class ��4_WaitNotifyExample {
	public static void main(String[] args) {
		
		��4_WorkObject sharedObject = new ��4_WorkObject();
		
		��4_ThreadA threadA = new ��4_ThreadA(sharedObject);
		��4_ThreadB threadB = new ��4_ThreadB(sharedObject);
		
		threadA.start();
		threadB.start();
	}
}
