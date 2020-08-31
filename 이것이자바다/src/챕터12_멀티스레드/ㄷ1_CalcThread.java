package 챕터12_멀티스레드;

public class ㄷ1_CalcThread extends Thread {
	public ㄷ1_CalcThread(String name) {
		setName(name);
	}
	
	public void run() {
		
		for (long i = 0; i < 2147483647; i++) {
		}
		
		System.out.println(getName());
		
	}
}
