package 챕터11_기본API클래스.ㄹ_Objects클래스;

public class Objects클래스 {
	// Object와 유사한 이름을 가진 java.util.Objects 클래스는 객체 비교, 해시코드 생성, null 여부,
	// 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성된 Object의 유틸리티 클래스이다.
	// 다음은 Objects 클래스가 가지고 있는 정적 메소드들이다.
	
	//	리턴 타입		메소드(매개 변수)								설명
	//
	//	int			compare(T a, T b, Comparator<T> c)		두 객체 a와 b를 Comparator를 사용해서 비교
	//	boolean		deepEquals(Object a, Object b)			두 객체의 깊은 비교(배열의 항목까지 비교)
	//	boolean		equals(Object a, Object b)				두 객체의 얕은 비교(번지만 비교)
	//	int			hash(Object... values)					매개값이 저장된 배열의 해시코드 생성
	//	int			hashCode(Object o)						객체의 해시코드 생성
	//	boolean		isNull(Object obj)						객체가 null인지 조사
	//	boolean		nonNull(Object obj)						객체가 null이 아닌지 조사
	//	T			requireNonNull(T obj)					객체가 null인 경우 예외 발생
	//
	//	T			requireNonNull(T obj,					객체가 null인 경우 예외 발생(주어진 예외 메세지 포함)
	//					Supplier message)
	//	T			requireNonNull(T obj,					객체가 null인 경우 예외 발생(람다식이 만든 예외 메세지 포함)
	//					Supplier<String> messageSupplier)
	//	String		toString(Object o)						객체의 toString() 리턴값 리턴
	//	String		toString(Object o, String nullDefault)	객체의 toString() 리턴값 리턴, 
	//														첫 번째 매개값이 null일 경우 두 번째 매개값 리턴
}
