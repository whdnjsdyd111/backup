package é��03_������;

public class ��_Check_The_NaN {
	public static void main(String[] args) {
		
		// double a = 5 / 0.0	Infinity
		// double a = 5 % 0.0	NaN
		// ���� �� Infinity�� NaN �� ������ �����Ͱ� �����̵Ǿ� üũ�� �ʿ䰡 �ִ�.
		
		String userInput = "NaN";
		double val = Double.valueOf(userInput);
		
		if(Double.isNaN(val)) {
			System.out.println("NaN�� �ԷµǾ� ó���� �� �����ϴ�.");
			val = 0.0;
		}
		
		double currentBalance = 10000.0;
		currentBalance += val;
		System.out.println(currentBalance);
	}
}
