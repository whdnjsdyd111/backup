package é��12_��Ƽ������;

public class ��1_ThreadStateExample {
	public static void main(String[] args) {
		��1_StatePrintThread statePrintThread = new ��1_StatePrintThread(new ��1_TargetThread());
		statePrintThread.start();
	}
}
