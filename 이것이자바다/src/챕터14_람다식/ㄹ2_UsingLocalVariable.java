package é��14_���ٽ�;

public class ��2_UsingLocalVariable {
	void method(int arg) {	// arg�� final Ư���� ����
		int localVar = 40;	// localVar�� final Ư���� ����
		
		// arg = 31;		// final Ư�� ������ ���� �Ұ�
		// localVar = 41;	// final Ư�� ������ ���� �Ұ�
		
		// ���ٽ�
		��2_MyFunctionalInterface fi = () -> {
			// ���� ���� �б�
			System.out.println("arg: " + arg);
			System.out.println("localVar: " + localVar);
		};
		
		fi.method();
	}
}
