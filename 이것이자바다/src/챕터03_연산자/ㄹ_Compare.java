package 챕터03_연산자;

public class ㄹ_Compare {
	public static void main(String[] args) {
		float v1 = 0.1f;
		double v2 = 0.1;

		System.out.println(v1 == v2);
		System.out.println(v1 == (float) v2);

		System.out.println((int) (v1 * 10) == (int) (v2 * 10));

		// float 의 0.1은 근삿값이기 때문에 float을 다른 타입으로 변환시켜 비교하거나 같은 float으로 변환할 필요가 있다.
	}
}
