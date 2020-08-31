package 챕터11_기본API클래스.ㅌ_Wrapper클래스;

public class Wrapper클래스 {
	// 자바는 기본타입(byte, char, short, int, long, float, double, boolean)의 값을 갖는 객체를 생성할 수 있다.
	// 이런 객체를 포장(Wrapper)객체라고 하는데, 그 이유는 기본 타입의 값을 내부에 두고 포장하기 때문이다.
	// 포장 객체의 특징은 포장하고 있는 기본 타입 값은 외부에서 변경할 수 없다. 만약 내부의 값을 변경하고 싶다면 새로운 포장 객체를 만들어야 한다.
	
	//	포장 객체
	//	┌─┐ <────true
	//	└─┘ <──10
	//	 └─────────────3.12
	
	// 포장 클래스는 java.lang 패키지에 포함되어 있는데, 다음과 같이 기본 타입에 대응되는 클래스들이 있다.
	// char 타입과 int 타입이 각각 Character와 Integer로 변경되고, 기본 타입의 첫 문자를 대문자로 바꾼 이름을 가지고 있다.
	
	//	기본 타입	포장 클래스
	//
	//	byte	Byte
	//	char	Character
	//	short	Short
	//	int		Integer
	//	long	Long
	//	float	Float
	//	double	Double
	//	boolean	Boolean
}
