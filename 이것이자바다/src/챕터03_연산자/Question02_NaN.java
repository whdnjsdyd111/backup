package é��03_������;

public class Question02_NaN {
	public static void main(String[] args) {
		
		double x = 5.0;
		double y = 0.0;
		
		double z = x % y;
		
		if(Double.isNaN(z)) {
			System.out.println("z�� NaN�̹Ƿ� ���� �� �����ϴ�.");
		} else {
			double result = z + 10.0;
			System.out.println(result);
		}
	}
}
