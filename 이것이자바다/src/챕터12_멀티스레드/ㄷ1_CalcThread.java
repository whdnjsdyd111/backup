package é��12_��Ƽ������;

public class ��1_CalcThread extends Thread {
	public ��1_CalcThread(String name) {
		setName(name);
	}
	
	public void run() {
		
		for (long i = 0; i < 2147483647; i++) {
		}
		
		System.out.println(getName());
		
	}
}
