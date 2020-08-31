package 챕터10_예외처리;

public class ㄴ3_NumberFormatException {
	public static void main(String[] args) {
		String data1 = "100";
		String data2 = "a100";
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);	// NumberFormatException 발생
		
		int result = value1 + value2;
		System.out.println(data1 + " + " + data2 + " = " + result);
		
	}
}
