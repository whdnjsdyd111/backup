package é��12_��Ƽ������;

public class ��2_YieldExample {
	public static void main(String[] args) {
		��2_ThreadA threadA = new ��2_ThreadA();
		��2_ThreadB threadB = new ��2_ThreadB();
		
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
