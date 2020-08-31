package 챕터04_조건문_반복문;

public class ㅅ1_Sum_01To1_Float {
	public static void main(String[] args) {
		for (float x = 0.1f; x <= 1.0f; x += 0.1f) {
			System.out.println(x);
		}
		
		// 0.1은 float타입으로 정확하게 표현할 수 없기 때문에 x에 더해지는 실제값은 0.1보다 약간 크다.
	}
}
