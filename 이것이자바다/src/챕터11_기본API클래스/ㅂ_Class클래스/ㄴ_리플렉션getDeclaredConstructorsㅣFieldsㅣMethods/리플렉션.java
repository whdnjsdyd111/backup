package 챕터11_기본API클래스.ㅂ_Class클래스.ㄴ_리플렉션getDeclaredConstructorsㅣFieldsㅣMethods;

public class 리플렉션 {
	// Class 객체를 이용하면 클래스의 생성자, 필드, 메소드 정보를 알아낼 수 있다. 이것을 리플렉션(Reflection)이라고 한다.
	// Class 객체는 리플렉션을 위해 getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods()를 제공하고 있다.
	
	//	Constructor[] constructors = clazz.getDeclaredConstructors();
	//	Field[] fields = clazz.getDeclaredFields();
	//	Method[] methods = clazz.getDeclaredMethods();
	
	// 메소드 이름에서 알 수 있듯이 세 메소드 각각 Constructor 배열, Field 배열, Method 배열을 리턴한다.
	// Constructor, Field, Method 클래스 모두 java.lang.reflect 페키지에 소속되어 있다.
	// getDeclaredFields(), getDeclaredMethods()는 클래스에 선언된 멤버만 가져오고 상속된 멤버는 가져오지 않는다.
	// 만약 상속된 멤버도 얻고 싶다면 getField(), getMethods()를 이용해야 한다. 단 getFields(), getMethods()는 public 멤버만 가져온다.
	// 
}
