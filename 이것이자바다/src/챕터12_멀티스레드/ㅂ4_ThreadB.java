package é��12_��Ƽ������;

public class ��4_ThreadB extends Thread {
	private ��4_WorkObject workObject;
	
	public ��4_ThreadB(��4_WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}
}
