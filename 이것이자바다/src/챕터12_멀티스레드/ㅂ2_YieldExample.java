package 챕터12_멀티스레드;

public class ㅂ2_YieldExample {
	public static void main(String[] args) {
		ㅂ2_ThreadA threadA = new ㅂ2_ThreadA();
		ㅂ2_ThreadB threadB = new ㅂ2_ThreadB();
		
		threadA.start();
		threadB.start();
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		threadA.work = false;
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		threadA.work = true;
		
		try { Thread.sleep(3000); } catch (InterruptedException e) {}
		threadA.stop = true;
		threadB.stop = true;
	}
}
