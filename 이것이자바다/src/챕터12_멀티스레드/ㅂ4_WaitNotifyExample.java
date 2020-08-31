package 챕터12_멀티스레드;

public class ㅂ4_WaitNotifyExample {
	public static void main(String[] args) {
		
		ㅂ4_WorkObject sharedObject = new ㅂ4_WorkObject();
		
		ㅂ4_ThreadA threadA = new ㅂ4_ThreadA(sharedObject);
		ㅂ4_ThreadB threadB = new ㅂ4_ThreadB(sharedObject);
		
		threadA.start();
		threadB.start();
	}
}
