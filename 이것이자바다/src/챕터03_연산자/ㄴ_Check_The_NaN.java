package 챕터03_연산자;

public class ㄴ_Check_The_NaN {
	public static void main(String[] args) {
		
		// double a = 5 / 0.0	Infinity
		// double a = 5 % 0.0	NaN
		// 다음 두 Infinity와 NaN 은 나오면 데이터가 엉망이되어 체크할 필요가 있다.
		
		String userInput = "NaN";
		double val = Double.valueOf(userInput);
		
		if(Double.isNaN(val)) {
			System.out.println("NaN이 입력되어 처리할 수 없습니다.");
			val = 0.0;
		}
		
		double currentBalance = 10000.0;
		currentBalance += val;
		System.out.println(currentBalance);
	}
}
