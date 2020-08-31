package 챕터03_연산자;

public class Question02_NaN {
	public static void main(String[] args) {
		
		double x = 5.0;
		double y = 0.0;
		
		double z = x % y;
		
		if(Double.isNaN(z)) {
			System.out.println("z는 NaN이므로 나눌 수 없습니다.");
		} else {
			double result = z + 10.0;
			System.out.println(result);
		}
	}
}
