package 챕터12_멀티스레드;

public class ㅅ1_AutoSaveThread extends Thread {
	public void save() {
		System.out.println("작업 내용을 저장함.");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
			save();
		}
	}
}
