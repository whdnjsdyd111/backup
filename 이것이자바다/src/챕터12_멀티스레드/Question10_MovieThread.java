package 챕터12_멀티스레드;

public class Question10_MovieThread extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println("동영상을 재생합니다.");
			try { Thread.sleep(1000); } catch (InterruptedException e) {} 
		}
	}
}
