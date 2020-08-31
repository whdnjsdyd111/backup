package 챕터09_중첩클래스_중첩인터페이스;

public class ㄷ3_Outter {

	// 자바 7 이전
	
	public void method1(final int arg) {
		final int localVariable = 1;
		
		class Inner {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
	
	// 자바 8 이후
	
	public void method2(int arg) {
		int localVariable = 1;
		
		class Inner {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
}
