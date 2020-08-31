package 챕터14_람다식;

public class ㄹ1_UsingThis {
	public int outterField = 10;
	
	class Inner {
		int innerField = 20;
		
		void method() {
			
			// 람다식
			ㄹ1_MyFunctionalInterface fi = () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + ㄹ1_UsingThis.this.outterField);	// 바깥 객체의 참조를 얻기 위해서는 클래스명.this를 사용
				
				System.out.println("innerField: " + innerField);
				System.out.println("innerField: " + this.innerField);					// 람다식 내부에서 this는 Inner 객체를 참조
			};
			
			fi.method();
		}
	}
}
