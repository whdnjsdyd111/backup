package 챕터11_기본API클래스.ㄷ_Object클래스.ㄹ_객체복제_clone.ㄱ_얕은복제_thinClone;

public class 얕은복제 {
	// 얕은 복제(thin clone)란 단순히 필드값을 복사해서 객체를 복제하는 것을 말한다.
	// 필드값만 복제하기 때문에 필드가 기본 타입일 경우 값 복사가 일어나고, 필드가 참조 타입일 경우에는 객체의 번지가 복사된다.
	// 예를 들어 원본 객체에 int 타입의 필드와 배열 타입의 필드가 있을 경우, 얕은 복제된 객체의 필드값은 다음과 같다.
	
	//					얕은 복제
	//	원본 객체 -------------------------->복제 객체
	//	int f1 = 3						int f1 = 3
	//	int[] f2 = □					int[] f2 - □
	//             └------┬------------------------┘
	//					배열 객체
	//					1, 5, 8
	
	// Object의 clone() 메소드는 자신과 동일한 필드값을 가진 얕은 복제된 객체를 리턴한다.
	// 이 메소드로 객체를 복제하려면 원본 객체는 반드시 java.lang.Cloneable 인터페이스를 구현하고 있어야 한다.
	// 메소드 선언이 없음에도 불구하고 Cloneable 인터페이스를 명시적으로 구현하는 이유는
	// 클래스 설계자가 복제를 허용한다는 의도적인 표시를 하기 위해서이다.
	// 클래스 설계자가 복제를 허용하지 않는다면 Cloneable 인터페이스를 구현하지 않으면 된다.
	// Clonealbe 인터페이스를 구현하지 않으면 clone() 메소드를 호출할 때 CloneNotSupportedException 예외가 발생하여 복제가 실패한다.
	// clone()은 CloneNotSupportedExcption 예외 처리가 필요한 메소드이기 때문에 try-catch 구문이 필요하다.
	
	//	try {
	//		Object obj = clone();
	//	} catch(CloneNotSupportedException e) {}
}
