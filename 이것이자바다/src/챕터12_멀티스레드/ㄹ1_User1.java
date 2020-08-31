package 챕터12_멀티스레드;

public class ㄹ1_User1 extends Thread {
	private ㄹ1_Calculator calculator;
	
	public void setCalculator(ㄹ1_Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}
	
	public void run() {
		calculator.setMemory(100);
	}
}
