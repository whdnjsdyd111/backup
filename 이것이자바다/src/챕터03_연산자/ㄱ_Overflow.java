package 챕터03_연산자;

public class ㄱ_Overflow {
	public static void main(String[] args) {
		int x1 = 1000000;
		int y1 = 1000000;
		int z1 = x1 * y1;
		System.out.println(z1);
		
		// 범위를 초과한 값은 쓰레기 값이 나오기 때문에 올바른 타입을 이용해여 한다.
		
		long x2 = 1000000;
		long y2 = 1000000;
		long z2 = x2 * y2;
		System.out.println(z2);
		
		/*
		
		byte		0 0 0 0 0 0 0 0		2 8
		short		
		char
		int			2 32
		long		
		float
		double
		boolean
		
		 */
	}
}
