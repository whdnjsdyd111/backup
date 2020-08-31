package 챕터12_멀티스레드;

public class ㄹ1_Calculator {
	private int memory;
	
	public int getMemory() {
		return memory;
	}
	
	public void setMemory(int memory) {
		this.memory = memory;
		
		try {
			Thread.sleep(2000);		// 2초간 일시 정지
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println(Thread.currentThread().getName() + ": " + this.memory);
	}
}
