package é��12_��Ƽ������;

public class ��1_User1 extends Thread {
	private ��1_Calculator calculator;
	
	public void setCalculator(��1_Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}
	
	public void run() {
		calculator.setMemory(100);
	}
}
