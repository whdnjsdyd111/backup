package é��14_���ٽ�;

public class ��1_UsingThis {
	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		
		void method() {
			
			// ���ٽ�
			��1_MyFunctionalInterface fi = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + ��1_UsingThis.this.outterField);	// �ٱ� ��ü�� ������ ��� ���ؼ��� Ŭ������.this�� ���
				
				System.out.println("innerField: " + innerField);
				System.out.println("innerField: " + this.innerField);					// ���ٽ� ���ο��� this�� Inner ��ü�� ����
			};
			
			fi.method();
		}
	}
}
