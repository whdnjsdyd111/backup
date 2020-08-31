package 챕터11_기본API클래스.ㅌ_Wrapper클래스.ㄱ_박싱Boxing과언박싱UnBoxing;

public class 박싱과언박싱 {
	// 기본 타입의 값을 포장 객체로 만드는 과정을 박싱(Boxing)이라고 하고, 반대로 포장 객체에서 기본 타입의 값을 얻어내는 과정을 언박싱(UnBoxing)이라고 한다.
	// 다음은 8개의 기본 타입의 값을 박싱하는 방법을 보여주고 있다. 간단하게 포장 클래스의 생성자 매개값으로 기본 타입의 값 또는 문자열을 넘겨주면 된다.
	
	//	기본 타입의 값을 줄 경우							문자열을 줄 경우
	//
	//	Byte obj = new Byte(10);				Byte obj = new Byte("10");
	//	Character obj = new Character('가');		없음
	//	Short obj = new Short(100);				Short obj = new Short("100");
	//	Integer obj = new Integer(1000);		Integer obj = new Integer("1000");			
	//	Long obj = new Long(10000);				Long obj = new Long("10000");
	//	Float obj = new Float(2.5F);			Float obj = new Float("2.5F");
	//	Double obj = new Double(3.5);			Double obj = new Double("3.5");
	//	Boolean obj = new Boolean(true);		Boolean obj = new Boolean("true");
	
	// 생성자를 이용하지 않아도 다음과 같이 각 포장 클래스마다 가지고 있는 정적 valueOf() 메소드를 사용할 수도 있다.
	
	//	Integer obj = Integer.valueOf(1000);
	//	Integer obj = Integer.valueOf("1000");
	
	// 이렇게 박싱된 포장 객체에서 다시 기본 타입의 값을 얻어 내기 위해서는(언박싱하기 위해서는) 각 포장 클래스마다 가지고있는
	// "기본타입명+ValueOf()" 메소드를 호출하면 된다.
	
	// 	기본타입의 값을 이용
	//
	//	byte		num = obj.byteValueOf();
	//	char		ch  = obj.charValueOf()
	//	short		num = obj.shortValueOf()
	//	int			num = obj.intValueOf()
	//	long		num = obj.longValueOf()
	//	float		num = obj.floatValueOf()
	//	double		num = obj.doubleValueOf()
	//	boolean		bool= obj.booleanValueOf()
}
