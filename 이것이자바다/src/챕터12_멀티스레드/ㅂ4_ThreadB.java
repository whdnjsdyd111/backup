package 챕터12_멀티스레드;

public class ㅂ4_ThreadB extends Thread {
	private ㅂ4_WorkObject workObject;
	
	public ㅂ4_ThreadB(ㅂ4_WorkObject workObject) {
		this.workObject = workObject;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObject.methodB();
		}
	}
}
