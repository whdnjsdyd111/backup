package é��03_������;

public class ��_Overflow {
	public static void main(String[] args) {
		int x1 = 1000000;
		int y1 = 1000000;
		int z1 = x1 * y1;
		System.out.println(z1);
		
		// ������ �ʰ��� ���� ������ ���� ������ ������ �ùٸ� Ÿ���� �̿��ؿ� �Ѵ�.
		
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
