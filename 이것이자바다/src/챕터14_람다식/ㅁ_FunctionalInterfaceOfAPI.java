package 챕터14_람다식;

public class ㅁ_FunctionalInterfaceOfAPI {
	// 자바에서 제공되는 표준 API에서 한 개의 추상 메소드를 가지는 인터페이스들은 모두 람다식을 이용해서 익명 구현 객체로 표현이 가능하다.
	// 예를 들어 스레드의 작업을 정의하는 Runnable 인터페이스는 매개 변수와와 리턴값이 없는 run() 메소드만 존재하기 때문에 다음 예제와 같이 람다식을 이용해서 Runnable 인스턴스를 생성할 수 있다.
	
	// Thread 생성자를 호출할 때 예제와 같이 람다식을 매개값으로 대입해도 된다.
	
	//	Thread thread = new Thread( () -> {
	//		for(int i = 0; i < 10; i++) {
	//			System.out.println(i);
	//		}
	//	});
	
	// 자바 8 부터는 빈번하게 사용되는 함수적 인터페이스(functional interface)는 java.function 표준 API 패키지로 제공한다.
	// 이 패키지에서 제공하는 함수적 인터페이스의 목적은 메소드 또는 생성자의 매개 타입으로 사용되어 람다식을 대입할 수 있도록 하기 위해서이다.
	// 자바 8 부터 추가되거나 변경된 API에서 이 함수적 인터페이스들을 매개 타입으로 많이 사용한다. 물론 우리가 개발하는 메소드에도 이 함수적 인터페이스들을 매개 타입으로 사용할 수 있다.
	// java.util.function 패키지의 함수적 인터페이스는 크게 Consumer, Supplier, Function, Operator, Predicate로 구분된다.
	// 구분 기준은 인터페이스에 선언된 추상 메소드의 매개값과 리턴값의 유무이다.
	
	//	종류				추상 메소드 특징							
	//														
	//	Consumer		- 매개값은 있고, 리턴값은 없음				매개값 -> Consumer
	//														
	//	Supplier		- 매개값은 없고, 리턴값은 있음						Supplier -> 리턴값
	//																					
	//	Function		- 매개값도 있고, 리턴값도 있음				매개값 -> Function -> 리턴값									
	//					- 주로 매개값을 리턴값으로 매핑(타입 변환)											
	//															
	//	Operator		- 매개값도 있고, 리턴값도 있음				매개값 -> Operator -> 리턴값						
	//					- 주로 매개값을 연산하고 결과를 리턴								
	//																
	//	Predicate		- 매개값은 있고, 리턴 타입은 boolean			매개값 -> Predicate -> 리턴값		
	//					- 매개값을 조사해서 true/false를 리턴	
	
			//	Consumer Functional Interface	Consumer 함수적 인터페이스
	
	// Consumer 함수적 인터페이스의 특징은 리턴값이 없는 accept() 메소드를 가지고 있다. accept() 메소드는 단지 매개값을 소비하는 역할만 한다. 여기서 소비한다는 말은 사용만 할 뿐 리턴값이 없다는 뜻이다.
	
	//					매개값 -> Consumer
	
	// 매개 변수의 타입과 수에 따라서 아래와 같은 Consumer들이 있다.
	
	//	인터페이스명			추상 메소드								설명
	//
	//	Consumer<T>			void accept(T t)					객체 T를 받아 소비
	//	BiConsumer<T, U>	void accept(T t, U u)				객체 T와 U를 받아 소비
	//	DoubleConsumer		void accept(double value)			double 값을 받아 소비
	//	IntConsumer			void accept(int value)				int 값을 받아 소비
	//	LongConsumer		void accept(long value)				long 값을 받아 소비
	//	ObjIntConsumer		void accept(T t, double value)		객체 T와 double 값을 받아 소비
	//	ObjIntConsumer		void accept(T t, int value)			객체 T와 int 값을 받아 소비
	//	ObjLongConsumer		void accept(T t, long value)		객체 T와 long 값을 받아 소비
	
	// Consumer<T> 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다. accept() 메소드는 매개값으로 T 객체 하나를 가지므로 람다식도 한 개의 매개 변수를 사용한다.
	// 타입 파라미터 T에 String이 대입되었기 때문에 람다식의 t 매개 변수 타입은 String이 된다.
	
	//	Consumer<String> consumer = t -> { t를 소비하는 실행문; };
	
	// BiConsumer<T, U> 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다.
	// accept() 메소드는 매개값으로 T와 U 두 개의 객체를 가지므로 람다식도 두 개의 매개 변수를 사용한다. 타입 파라미터 T와 U에 String이 대입되었기 때문에 람다식의 t와 u 매개 변수 타입은 각각 String이 된다.
	
	//	BiConsumer<String, String> biConsumer = (t, u) -> { t와 u를 소비하는 실행문; };
	
	// DoubleConsumer 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다.
	// accept() 메소드는 매개값으로 double 하나를 가지므로 람다식도 한 개의 매개 변수를 사용한다. d는 고정적으로 double 타입이 된다.
	
	//	DoubleConsumer consumer = d -> { d를 소비하는 실행문; };
	
	// OnjIntConsumer<T> 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다.
	// accept() 메소드는 매개값으로 T 객체와 int 값 두 개를 가지기 때문에 람다식도 두 개의 매개 변수를 사용한다. T가 String 타입으로 람다식의 t 매개 변수 타입은 String이 되고, i는 고정적으로 int 타입이 된다.
	
	//	ObjIntConsumer<String> consumer = (t, i) -> { t와 i를 소비하는 실행문; };
	
			//	Supplier 함수적 인터페이스
	
	// Supplier 함수적 인터페이스의 특징은 매개 변수가 없고 리턴값이 있는 getXXX() 메소드를 가지고 있다. 이 메소드들은 실행 후 호출한 곳으로 데이터를 리턴(공급)하는 역할을 한다.
	
	//					Supplier -> 리턴값
	
	// 리턴 타입에 따라서 아래와 같은 Supplier 함수적 인터페이스들이 있다.
	
	//	인터페이스명			추상 메소드						설명
	//	
	//	Supplier<T>			T get()						T 객체를 리턴
	//	BooleanSupplier		boolean getAsBoolean()		boolean 값을 리턴
	//	DoubleSupplier		double getAsDouble()		double 값을 리턴
	//	IntSupplier			int getAsInt()				int 값을 리턴
	//	LongSupplier		long getAsLong()			long 값을 리턴
	
	// Supplier<T> 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다. get() 메소드가 매개값을 가지지 않으므로 람다식도 ()를 사용한다.
	// 람다식의 중괄호 {}는 반드시 한 개의 T 객체를 리턴하도록 해야 한다. T가 String 타입이므로 람다식의 중괄호 {}는 문자열을 리턴하도록 해야 한다.
	
	//	Supplier<String> supplier = () -> { ...; return "문자열"; }
	
	// IntSupplier 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다. getAsInt() 메소드가 매개값을 가지지 않으므로 람다식도 ()를 사용한다.
	// 람다식의 중과호 {}는 반드시 int 값을 리턴하도록 해야 한다.
	
	//	IntSupplier supplier = () -> { ...; return int 값; }
	
	// 다음 예제는 주사위의 숫자를 랜덤하게 공급하는 IntSupplier 인터페이스를 타겟 타입으로 하는 람다식이다.
	
			//	Function Functional interface		Function 함수적 인터페이스
	
	// Function 함수적 인터페이스의 특징은 매개값과 리턴값이 있는 applyXXX() 메소드를 가지고 있다. 이 메소드들은 매개값을 리턴값으로 매핑(타입 변환)하는 역할을 한다.
	
	//					매개값 -> Funtion -> 리턴값
	
	// 매개 변수 타입과 리턴 타입에 따라서 아래와 같은 Function 함수적 인터페이스들이 있다.
		
	//	인터페이스명					추상 메소드								설명
	//
	//	Function<T, R>				R apply(T t)						객체 T를 객체 R로 매핑
	//	BiFunction<T, U, R>			R apply(T t, U u)					객체 T와 U를 객체 R로 매핑
	//	DoubleFunction<R>			R apply(double value)				double을 객체 R로 매핑
	//	IntFunction<R>				R apply(int value)					int를 객체 R로 매핑
	//	IntToDoubleFunction			double applyAsDouble(int value)		int를 double로 매핑
	//	IntToLongFunction			long applyAsLong(int value)			int룰 long으로 매핑
	//	LongToDoubleFunction		double applyAsDouble(long value)	long을 double로 매핑
	//	LongToIntFunction			int applyAsInt(long value)			long을 int로 매핑
	//	ToDoubleBiFunction<T, U>	double applyAsDouble(T t, U u)		객체 T와 U를 double로 매핑
	//	ToDoubleFunction<T>			double applyAsDouble(T t)			객체 T를 double로 매핑
	//	ToIntBiFunction<T, U>		int applyAsInt(T t, U u)			객체 T와 U를 int로 매핑
	//	ToIntFunction<T>			int applyAsInt(T t)					객체 T를 int로 매핑
	//	ToLongBiFunction<T, U>		long applyAsLong(T t, U u)			객체 T와 U를 long으로 매핑
	//	ToLongFunction<T>			long applyAsLong(T t)				객체 T를 long으로 매핑
	
	// Function<T, R> 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다. apply() 메소드는 매개값으로 T 객체 하나를 가지므로 람다식도 한 개의 매개 변수를 사용한다.
	// 그리고 apply() 메소드의 리턴 타입이 R이므로 람다식 중괄호 {}의 리턴값은 R 객체가 된다.
	// T가 student 타입이고 R이 String 타입이므로 t 매개 변수 타입은 Student가 되고, 람다식의 중괄호 {}는 String을 리턴해야 한다.
	// t.getName()은 Student 객체의 getName() 메소드를 호출해서 학생 이름(String)을 얻는다. return문만 있을 경우 중괄호 {}와 return문은 생략할 수 있다.
	// 다음 코드는 Student 객체를 학생 이름(String)으로 매핑하는 것이다.
	
	//	Function<Student, String> function = t -> { return t.getName(); }		또는
	//	Function<Student, String> function = t -> t.getName();				
	
	// ToIntFunction<T> 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다. applyAsInt() 메소드는 매개값으로 T 객체 하나를 가지므로 람다식도 한 개의 매개 변수를 사용한다.
	// 그리고 applyAsInt() 메소드의 리턴 타입이 int이므로 람다식 중괄호 {}의 리턴값은 int가 된다. T가 Student 타입이므로 t 매개 변수 타입은 Student가 된다.
	// t.getScore()는 Student 객체의 getScore() 메소드를 호출해서 학생 점수(int)를 얻는다. 다음 코드는 Student 객체를 학생 점수(int)로 매핑하는 것이라고 볼 수 있다.
	
	//	ToIntFunction<Student> function = t -> { return t.getScore(); }			또는
	//	ToIntFunction<Student> function = t -> t.getScore();
	
	// 다음 예제는 List에 저장된 학생 객체를 하나씩 꺼내서 이름과 점수를 출력한다. FunctionExample1의 printString() 메소드는 Function<Student, String> 매개 변수를 가지고 있고,
	// printInt() 메소드는 ToIntFunction<Student> 매개 변수를 가지고 있으므로 이 메소드들은 호출할 때 매개값으로 람다식을 사용할 수 있다.
	
	// 이 다음 예제는 List에 저장된 학생 객체를 하나씩 꺼내서 영어 점수와 수학 점수의 평균값을 산출한다.  FunctionExample2의 avg() 메소드는 ToIntFunction<Student> 매개 변수를 가지고 있다.
	// 따라서 avg() 메소드를 호출할 때 매개값으로 람다식을 사용할 수 있다. 람다식은 getEnglishScore()와 getMathScore()를 호출해서 영어 점수와 수학 점수로 Student 객체를 매핑(변환) 시킨다.
	
			//	Operator Functional Interface		Operator 함수적 인터페이스
	
	// Operator 함수적 인터페이스는 Function과 동일하게 매개 변수와 리턴값이 있는 applyXXX() 메소드를 가지고 있다.
	// 하지만 이 메소드들은 매개값을 리턴값으로 매핑(타입 변환)하는 역할보다는 매개값을 이용해서 연산을 수행한 후 동일한 타입으로 리턴값을 제공하는 역할을 한다.
	
	//					매개값 -> Operator -> 리턴값
	
	// 매개 변수의 타입과 수에 따라서 아래와 같은 Operator 함수적 인터페이스들이 있다.
	
	//	인터페이스명				추상 메소드										설명
	//
	//	BinaryOperator<T>		T apply(Tt, Tt)								T와 T를 연산한 후 T 리턴
	//	UnaryOperator<T>		T apply(Tt)									T를 연산한 후 T 리턴
	//	DoubleBinaryOperator	double applyAsDouble(double, double)		두 개의 double 연산
	//	DoubleUnaryOperator		double applyAsDouble(double)				한 개의 double 연산
	//	IntBinaryOperator		int applyAsInt(int, int)					두 개의 int 연산
	//	IntUnaryOperator		int applyAsInt(int)							한 개의 int 연산
	//	LongBinaryOperator		long applyAsLong(long, long)				두 개의 long 연산
	//	LongUnaryOperator		long applyAsLong(long)						한 개의 long 연산
	
	// IntBinaryOperator 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다.
	// applyAsInt() 메소드는 매개값으로 두 개의  int를 가지므로 람다식도 두 개의 int 매개 변수 a와 b를 사용한다. 그리고 applyAsInt() 메소드의 리턴 타입이 int이므로 람다식의 중괄호 {}의 리턴값은 int가 된다.
	// 다음 코드는 두 개의 int를 연산해서 결과값으로 int를 리턴한다.
	
	// IntBinaryOperator operator = (a, b) -> {...; return int값; }
	
	// 다음 예제는 int[] 배열에서 최대값과 최소값을 얻는다. maxOrMin() 메소드는 IntBinaryOperator 매개 변수를 가지고 있다. 따라서 maxOrMin() 메소드를 호출할 때 람다식을 사용할 수 있다.
	
			//	Predicate Functional Interface		Predicate 함수적 인터페이스
	
	// Predicate 함수적 인터페이스는 매개 변수와 boolean 리턴값이 있는 testXXX() 메소드를 가지고 있다.
	// 이 메소드들은 매개값을 조서해서 true 또는 false를 리턴하는 역할을 한다.
	
	//					매개값 -> Predicate -> 리턴값
	
	// 매개 변수 타입과 수에 따라서 아래와 같은 Predicate 함수적 인터페이스들이 있다.
	
	//	인터페이스명			추상 메소드						설명
	//
	//	Predicate<T>		boolean test(T t)			객체 T를 조사
	//	BiPredicate<T, U>	boolean test(T t, U u)		객체 T와 U를 조사
	//	DoublePredicate		boolean test(double value)	double 값을 조사
	//	IntPredicate		boolean test(int value)		int 값을 조사
	//	LongPredicate		boolean test(long value)	long 값을 조사
	
	// Predicate<T> 인터페이스를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다. test() 메소드는 매개값으로 T 객체 하나를 가지므로 람다식도 한 개의 매개 변수를 사용한다.
	// 그리고  test() 메소드의 리턴 타입이 boolean이므로 람다식 중괄호 {}의 리턴값은 boolean이 된다. T가 Student 타입이므로 t 매개 변수 타입은 Student가 된다.
	// t.getSex()는 Student 객체의 getSex() 메소드를 호출해서 "남자" 또는 "여자"를 얻는다. 결국 다음 코드는 String의 equals() 메소드를 이용해서 남학생만 true를 얻는다.
	
	//	Predicate<Student> predicate = t -> { return t.getSex().equals("남자"); }		또는
	//	Predicate<Student> predicate = t -> t.getSex().equals("남자");
	
	// 다음 예제는 List에 저장된 남자 또는 여자 학생들의 평균 점수를 출력한다. avg() 메소드는 Predicate<Student> 매개 변수를 가지고 있다. 따라서 avg() 메소드를 호출할 때 매개값으로 람다식을 사용할 수 있다.
	
			//	andThen() And compose() Default Method		andThen()과 compose() 디폴트 메소드
	
	// 디폴트 및 정적 메소드는 추상 메소드가 아니기 때문에 함수적 인터페이스에 선언되어도 여전히 함수적 인터페이스의 성질을 잃지 않는다
	// 여기서 함수적 인터페이스의 성질이란 하나의 추상 메소드를 가지고 있고, 람다식으로 익명 구현 객체를 생성할 수 있는것을 말한다.
	// java.util.function 패키지의 함수적 인터페이는 하나 이상의 디폴트 및 정적 메소드를 가지고 있다.
	
	// Consumer, Function, Operator 종류의 함수적 인터페이스는 andThen()과 compose() 디폴트 메소드를 가지고 있다.
	// andThen()과 compose() 디폴트 메소드는 두 개의 함수적 인터페이스를 순차적으로 연결하고, 첫 번째 처리 결과를 두 번째 매개값으로 제공해서 최종 결과값을 얻을 때 사용한다.
	// andThen()과 compose()의 차이점은 어떤 함수적 인터페이스부터 먼저 처리하느냐이다. 먼저 다음 코드를 보면서 andThen()부터 살펴보자.
	
	//	인터페이스AB = 인터페이스A.andThen(인터페이스B);
	//	최종결과 = 인터페이스AB.method();
	
	// 인터페이스AB의 method()를 호출하면 우선 인터페이스A부터 처리하고 결과를 인터페이스B의 매개값을 제공한다. 인터페이스B는 제공받은 매개값을 가지고 처리한 후 최종 결과를 리턴한다.
	
	//		인터페이스A			→		인터페이스B
	//		(람다식)		andThen		(람다식)
	//			↑						↓
	//		인터페이스AB				최종 결과
	//		method()
	
	// 이번에는 compose()를 살펴보자. 인터페이스AB의 method()를 호출하면 우선 인터페이스B부터 처리하고 결과를 인터페이스A의 매개값으로 제공한다. 
	// 인터페이스A는 제공받은 매개값을 가지고 처리한 후 최종 결과를 리턴한다.
	
	//	인터페이스AB = 인터페이스A.compose(인터페이스B);
	//	최종결과 = 인터페이스AB.method();
	
	//		인터페이스A			←		인터페이스B
	//		(람다식)		compose		(람다식)
	//			↓						↑
	//		인터페이스AB				최종 결과
	//		method()
	
	// 다음은 andThen()과 compose() 디폴트 메소드를 제공하는 java.util.function 패키지의 함수적 인터페이스들이다.
	
	//	종류			함수적 인터페이스				andThen()	compose()
	//
	//				Consumer<T>					o
	//				BiConsumer<T, U>			o
	//	Consumer	DoubleConsumer				o
	//				IntConsumer					o
	//				LongConsumer				o
	//
	//	Function	Function<T, R>				o			o
	//				BiFunction<T, U, R>			o
	//
	//				BinaryOperator<T>			o
	//	Operator	DoubleUnaryOperator			o			o
	//				IntUnaryOperator			o			o
	//				LongUnaryOperator			o			o
	
			/*	Sequential Connection Of Consumer		Consumer의 순차적 연결	*/
	
	// Consumer 종류의 함수적 인터페이스는 처리 결과를 리턴하지 않기 때문에 andThen() 디폴트 메소드는 함수적 인터페이스의 호출 순서만 정한다.
	// 다음 예제는 Consumer<Member> 함수적 인터페이스 두 개를 순차적으로 연결해서 실행한다. 첫 번째 Consumer<Member>는 이름을 출력하고, 두 번째 Consumer<Member>는 아이디를 출력한다.
	
			/*	Sequential Connection Of Function		Function의 순차적 연결	*/
	
	// Function과 Operator 종류의 함수적 인터페이스는 먼저 실행한 함수적 인터페이스의 결과를 다음 함수적 인터페이스의 매개값으로 넘겨주고, 최종 처리 결과를 리턴한다.
	// 예를 들어 Function<Member, Address>와 Function<Address, String>을 순차적으로 연결해서 Function<Member, String>을 생성한다고 가정해보자.
	// Function<Member, Address>는 매개값으로 제공되는 Member로부터 Address를 리턴한다. Function<Address, String>은 매개값으로 제공되는 Address로부터 String을 리턴한다.
	// 이 둘을 andThen()이나 compose()로 연결하면 Function<Member, Address>에서 리턴한 Address를 Function<Address, String>의 매개값으로 넘겨서 
	// 최종 String 타입을 리턴하는 Function<Member, String>을 생성해 낸다. 다음을 보며 이해하자.
	
	//							┌────────────────────────┐
	//							│						 │
	//		Function<Member, Address>	+	Function<Address, String>
	//													ㅣㅣ
	//										Function<Member, String>
	
	// Address는 두 함수적 인터페이스 간의 전달 데이터이다. Address는 내부적으로 전달되기 때문에 최종 함수적 인터페이스의 형태는 
	// 입력 데이터가 Member, 출력 데이터가 String이 되는 Function<Member, String>이 된다.
	// 다음 예제는 Member 객체의 필드인 Address에서 city 정보를 얻어내기 위해 두 Function 함수적 인터페이스를 andThen()과 compose()를 이용해서 순차적으로 연결했다.
	// 예제 코드에서 andThen() 메소드를 호출한 함수적 인터페이스는 functionA이고, compose() 메소드를 호출한 함수적 인터페이스는 functionB이다. 
	// 모두 functionA부터 실행하고 functionB를 나중에 실행한다.
	
			//	and(), or(), negate() Default Method And isEqual() Static Method	and(), or(), negate() 디폴트 메소드와 isEqual() 정적 메소드
	
	// Predicate 종류의 함수적 인터페이스는 and(), or(), negate() 디폴트 메소드를 가지고 있다. 이 메소드들은 각각 논리 연산자인 &&, ||, !과 대응된다고 볼 수 있다.
	// and() 메소드는 두 Predicate가 모두 true를 리턴하면 최종적으로 true를 리턴하는 Predicate를 생성한다.
	// negate()는 원래 Predicate의 결과가 true이면 false로, false이면 true를 리턴하는 새로운 Predicate를 생성한다.
	// 다음은 and(), or(), negate() 디폴트 메소드를 제공하는 Predicate 함수적 인터페이스들이다.
	
	//	종류			함수적 인터페이스			and()	or()	negate()
	//
	//				Predicate<T>		o		o			o
	//				BiPredicate<T, U>	o		o			o
	//	Predicate	DoublePredicate		o		o			o
	//				IntPredicate		o		o			o
	//				LongPredicate		o		o			o
	
	// 다음 예제는 2의 배수와 3의 배수를 조사하는 두 Predicate를 논리 연산한 새로운 Predicate를 생성한다.
	
	// Predicate<T> 함수적 인터페이스는 and(), or(), negate() 디폴트 메소드 이외에 isEqual() 정적 메소드를 추가로 제공한다.
	// isEqual() 메소드는 test() 매개값인 sourceObject와 isEqual()의 매개값인 targetObject를 java.util.Object 클래스의 equal()의 매개값으로 제공하고,
	// Objects.equal(sourceObject, targetObject)의 리턴값을 얻어 새로운 Predicate<T>를 생성한다.
	
	//	Predicate<Object> predicate = Predicate.isEqual(targetObject);
	//	boolean result = predicate.test(sourceObject);		↑
	//											↓→	동등 비교	↑	Object.equals(sourceObject, targetObject) 실행
	
	// Object.equals(sourceObject, targetObject)는 다음과 같은 리턴값을 제공한다.
	
	//	sourceObject	targetObject	리턴값
	//
	//	null			null			true
	//	not null		null			false
	//	null			not null		false
	//	not null		not null		sourceObject.equals(targetObject)의 리턴값
	
	// 다음 예제는 두 문자열을 비교하기 위해 Predicate의 isEqual() 정적 메소드를 사용하였다.
	
			//	minBy(), maxBy() Static Method		minBy(), maxBy() 정적 메소드
	
	// BinaryOperator<T> 함수적 인터페이스는 minBy()와 maxBy() 정적 메소드를 제공한다. 
	// 이 두 메소드는 매개값으로 제공되는 Comparator를 이용해서 최대 T와 최소 T를 얻는 BinaryOperator<T>를 리턴한다.
	
	//	리턴 타입					정적 메소드
	//
	//	BinaryOperator<T>		minBy(Comparator<? super T> comparator)
	//	BinaryOperator<T>		maxBy(Comparator<? super T> comparator)
	
	// Comparator<T>는 다음과 같이 선언된 함수적 인터페이스이다. o1과 o2를 비교해서 o1이 작으면 음수를, o1과 o2가 동일하면 0을, o1이 크면 양수를 리턴하는 compare() 메소드가 선언되어 있다.
	
	//	@FunctionalInterface
	//	public interface Comparator<T> {
	//		public int comparator(T o1, T o2);
	//	}
	
	// Comparator<T>를 타겟 타입으로 하는 람다식은 다음과 같이 작성할 수 있다.
	
	//	(o1, o2) -> { ...; return int값; }
	
	// 만약 o1과 o2가 int 타입이라면 다음과 같이 Integer.comparator(int, int) 메소드를 이용할 수 있다.
	// Integer.comparator()는 첫 번째 매개값이 두 번째 매개값보다 작으면 음수, 같으면 0, 크면 양수를 리턴한다.
	
	//	(o1, o2) -> Integer.comparator(o1, o2)
	
	// 다음 예제는 두 과일의 값을 비교해서 값이 낮거나 높은 과일을 얻어낸다.
}
