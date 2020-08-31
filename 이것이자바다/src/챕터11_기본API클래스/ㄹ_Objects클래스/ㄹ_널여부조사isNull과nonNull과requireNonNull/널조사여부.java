package 챕터11_기본API클래스.ㄹ_Objects클래스.ㄹ_널여부조사isNull과nonNull과requireNonNull;

public class 널조사여부 {
	// Objects.isNull(Object obj)는 매개값이 null일 경우 true를 리턴한다.
	// 반대로 nonNull(Object obj)는 매개값이 not null일 경우 true를 리턴한다.
	// requireNonNull()는 다음 세 가지로 오버로딩 되어 있다.
	
	//	리턴타입	메소드(매개 변수)							설명
	//	T		requireNonNull(T obj)				not null -> obj
	//												null -> NullPointerException
	//
	//	T		requireNonNull(T obj,				not null -> obj
	//				String message)					null -> NullPointerException(message)
	//
	//	T		requireNonNull(T obj,				not null -> obj
	//				Supplier<String> msgSupplier)	null -> NullPointerException(msgSupplier.get())
	
	// 첫 번째 매개값이 not null이면 첫 번째 매개값을 리턴하고, null 이면 모두 NullPointerException을 발생시킨다.
	// 두번째 매개값은 NullPointerException의 예외 메세지를 제공한다.
	
}
