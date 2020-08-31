package 챕터16_스트림_병렬처리;

public class ㅊ_CustomAggregate {
	// 스트림은 기본 집계 메소드인 sum(), average(), count(), max(), min()을 제공하지만, 프로그램화해서 다양한 집계 결과물을 만들 수 있도록 reduce() 메소드도 제공한다.
	
	//	인터페이스			리턴 타입				메소드
	//
	//	Stream			Optional<T>			reduce(BinaryOperator<T> accumulator)
	//					T					reduce(T identity, BinaryOperator<T> accumulator)
	//
	//	IntStream		OptionalInt			reduce(IntBinaryOperator op)
	//					int					reduce(int identity, IntBinaryOperator p[)
	//
	//	LongStream		OptionalLong		reduce(LongBinaryOperator op)
	//					long				reduce(long identity, LongBinaryOperator op)
	//
	//	DoubleStream	OptionalDouble		reduce(DoubleBinaryOperator p[)
	//					double				reduce(double identity, DoubleBinaryOperator op)
	
	// 각 인터페이스에는 매개 타입으로 XXXOperator, 리턴 타입으로 OptionalXXX, int, long, double을 가지는 reduce() 메소드가 오버로딩 되어 있다.
	// 스트림에 요소가 전혀 없을 경우 디폴트값인 identity 매개값이 리턴된다.
	// XXXOperator 매개값은 집계 처리를 위한 람다식을 대입하는 데, 에를 들어 성적 총점은 학생 스트림에서 점수 스트림으로 매핑해서 다음과 같이 얻을 수 있다.
	
	//	int sum = studentList.stream()	|	int sum = studentList.stream()
	//		.map(Student :: getScore)	|		.map(Student :: getScore)
	//		.reduce( (a, b) -> a + b )	|		.reduce(0, (a, b) -> a + b );
	//		.get()						|
	
	// 왼쪽 코드는 스트림에 요소가 없을 경우 NotSuchElementException이 발생하지만, 오른쪽 코드는 디폴트 값(identity)인 0을 리턴한다.
	// 스트림에 요소가 있을 경우에는 두 코드는 모두 동일한 결과를 산출한다.
	
}
