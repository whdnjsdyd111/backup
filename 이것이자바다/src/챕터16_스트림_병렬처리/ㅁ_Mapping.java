package 챕터16_스트림_병렬처리;

public class ㅁ_Mapping {
	// 매핑(mapping)은 중간 처리 기능으로 스트림의 요소들 다른 요소로 대체하는 작업을 말한다.
	// 스트림에서 제공하는 매핑 메소드는 flatXXX()와 mapXXX(), 그리고 asDoubleStream(), asLongStream, boxed()가 있다.
	
			//	flatMapXXX() Method
	
	// flatMapXXX() 메소드는 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림을 리턴한다.
	// 다음을 보고 이해하자. 스트림에서 A라는 요소는 A1, A2 요소로 대체되고, B라는 요소는 B1, B2로 대체된다고 가정했을 경우, A1, A2, B1, B2 요소를 가지는 새로운 스트림이 생성된다.
	
	//		원래 스트림								새로 생성된 스트림
	//	────────────────	┌ → A → A2 A1 ┐	────────────────
	//	→	B A			────┤			  ├ →	B1 B2 A1 A2 →
	//	────────────────	└ → B → B2 B1 ┘	────────────────
	
	// flatMapXXX() 메소드의 종류는 다음과 같다.
	
	//	리턴 타입			메소드(매개 변수)									요소
	//
	//	Stream<R>		flatMap(Function<T, Stream<R>>)				T -> Stream<R>
	//	DoubleStream	flatMap(DoubleFunction<DoubleStrea>)		double -> DoubleStream
	//	IntStream		flatMap(IntFunction<IntStream>)				int -> IntStream
	//	LongStream		flatMap(LongFunction<LongStream>)			long -> LongStream
	//	DoubleStream	flatMapToDouble(Function<T, DoubleStream>)	T -> DoubleStream
	//	IntStream		flatMapToInt(Function<T, IntStream>)		T -> IntStream
	//	LongStream		flatMapToLong(Function<T, LongStream>)		T -> LongStream
	
	// 다음 예제는 입력된 데이터(요소)들이 List<String>에 저장되오 있다고 가정하고, 요소별로 단어를 뽑아 단어 스트림으로 재생성한다.
	// 만약 입력된 데이터들이 숫자라면 숫자를 뽑아 숫자 스트림으로 재생성한다.
	
			//	mapXXX() Method
	
	// mapXXX() 메소드는 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴한다. 다음을 보면서 이해하자.
	// 스트림에서 A 요소는 C 요소로 대체되고, B 요소는 D 요소로 데체된다고 했을 경우 C, D 요소를 가지는 새로운 스트림이 생성된다.
	
	//		원래 스트림						새로 생성된 스트림
	//	────────────────	┌ → A → C ┐	────────────────
	//	→	B A			────┤		  ├ →	D C			→
	//	────────────────	└ → B → D ┘	────────────────
	
	// mapXXX() 메소드의 종류는 다음과 같다.
	
	//	리턴 타입			메소드(매개 변수)							요소 -> 대체 요소
	//
	//	Stream<R>		map(Function<T, R>)					T -> R
	//	DoubleStream	mapToDouble(ToDoubleFunction<T>)	T -> double
	//	IntStream		mapToInt(ToIntFunction<T>)			T -> int	
	//	LongStream		mapToLong(ToLongFunction<T>)		T -> long
	//	DoubleStream	map(DoubleUnaryOperator)			double -> double
	//	IntStream		mapToInt(DoubleToIntFunction)		double -> int
	//	LongStream		mapToLong(DoubleToLongFunction)		double -> long
	//	Stream<U>		mapToObj(DoubleFunction<U>)			double -> U
	//	IntStream		map(IntUnaryOperator)				int -> int
	//	DoubleStream	mapToDouble(IntToDoubleFunction)	int -> double
	//	LongStream		mapToLong(IntToLongFunction)		int -> long
	//	Stream<U>		mapToObj(IntFunction<U>)			int -> U
	//	LongStream		map(LongUnaryOperator)				long -> long
	//	DoubleStream	mapToDouble(LongToDoubleFunction)	long -> double
	//	IntStream		mapToInt(LongToIntFunction)			long -> int
	//	Stream<U>		mapToObj(LongFunction<U>)			long -> U
	
	// 다음 예제는 학생 List에서 학생의 점수를 요소로 하는 새로운 스트림을 생성하고, 점수를 순차적으로 콘솔에 출력한다.
	
			//	asDoubleStream(), asLongStream(), boxed() Method
	
	// asDoubleStream() 메소드는 IntStream의 int 요소 또는 LongStream의 long 요소를 double 요소로 타입 변환해서 DoubleStream을 생성한다.
	// 마찬가지로 asLongStream() 메소드는 IntStream의 int 요소를 long 요소로 타입 변환헤서 LongStream을 생성한다.
	// boxed() 메소드는 int, long, double 요소를 Integer, Long, Double 요소로 박싱해서 Stream
	
	//	리턴 타입			메소드(매개 변수)			설명
	//
	//	DoubleStream	asDoubleStream()	int -> double
	//										long -> double
	//	
	//	LongStream		asLongStream()		int -> long
	//
	//	Stream<Integer>						int -> Integer
	//	Stream<Long>	boxed()				long -> Long
	//	Stream<Double>						double -> Double
	
	// 다음 예제는 int[] 배열로부터 IntStream을 얻고 난 다음 int 요소를 double 요소로 타입 변환해서 DoubleStream을 생성한다. 또한 int 요소를 Integer 객체로 박싱해서 Stream<Integer>를 생성한다.
}
