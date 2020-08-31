package 챕터12_멀티스레드;

public class ㅁ1_ThreadStateExample {
	public static void main(String[] args) {
		ㅁ1_StatePrintThread statePrintThread = new ㅁ1_StatePrintThread(new ㅁ1_TargetThread());
		statePrintThread.start();
	}
}
