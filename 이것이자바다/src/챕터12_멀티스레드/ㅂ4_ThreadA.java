package é��12_��Ƽ������;

public class ��4_ThreadA extends Thread {
	private ��4_WorkObject workObject;
	
	public ��4_ThreadA(��4_WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodA();
		}
	}
}
