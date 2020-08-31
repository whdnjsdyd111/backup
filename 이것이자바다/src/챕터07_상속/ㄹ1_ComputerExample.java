package 챕터07_상속;

public class ㄹ1_ComputerExample {
	public static void main(String[] args) {
		int r = 10;
		
		ㄹ1_Calculator calculator = new ㄹ1_Calculator();
		System.out.println("원면적: " + calculator.areaCircle(10));
		
		ㄹ1_Computer computer = new ㄹ1_Computer();
		System.out.println("원면적: " + computer.areaCircle(10));
	}
}
