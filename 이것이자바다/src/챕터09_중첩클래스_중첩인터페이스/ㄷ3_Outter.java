package é��09_��øŬ����_��ø�������̽�;

public class ��3_Outter {

	// �ڹ� 7 ����
	
	public void method1(final int arg) {
		final int localVariable = 1;
		
		class Inner {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
	
	// �ڹ� 8 ����
	
	public void method2(int arg) {
		int localVariable = 1;
		
		class Inner {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
}
