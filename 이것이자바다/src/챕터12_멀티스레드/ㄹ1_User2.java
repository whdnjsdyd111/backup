package é��12_��Ƽ������;

public class ��1_User2 extends Thread {
	private ��1_Calculator calculator;
	
	public void setCalculator(��1_Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}
	
	public void run() {
		calculator.setMemory(50);
	}
}
