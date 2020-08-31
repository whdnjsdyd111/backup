package 챕터16_스트림_병렬처리;

public class ㅈ_Aggregate {
	// 집계(aggregate)는 최종 처리 기능으로 요소들을 처리해서 카운팅, 합계, 평균값, 최대값, 최소값 등과 같이 하나의 값으로 산출하는 것을 말한다.
	// 집계는 대량의 데이터를 가공해서 축소하는 리덕션(Reduction)이라고 볼 수 있다.
	
			//	Basic Aggregate Supplied By Stream		스트림이 제공하는 기본 집계
	
	// 스트림은 다음과 같은 기본 집계 메소드를 제공하고 있다.
	
	//	리턴 타입				메소드(매개 변수)			설명
	//		
	//	long				count()				요소 개수
	//	OptionalXXX			findFirst()			첫 번째 요소
	//	
	//	Optional<T>			max(Comparator<T>)	최대 요소
	//	OptionalXXX			max()						
	//	
	//	Optional<T>			min(Comparator<T>)	최소 요소
	//	OptionalXXX			min()
	//
	//	OptionalDouble		average()			요소 평균
	//	int, long, double	sum()				요소 총합
	
	// 이 집계 메소드에서 리턴하는 OptionalXXX는 자바 8에 추가한 java.util 패키지의 Optional, OptionalDouble, OptionalInt, OptionalLong 클래스 타입을 말한다.
	// 이들은 값을 저장하는 값 기반 크래스(value-based class)들이다. 이 객체에서 값을 얻기 위해서는 get(), getAsDouble(), getAsInt(), getAsLong()을 호출하면 된다.
	// 예제를 살펴보자.
	
			// Optional Class
	
	// Optional, OptionalDouble, OptionalInt, OptionalLong 클래스에 대허서 좀 더 알아보기로 하자. 이 클래스들은 저장하는 값의 타입만 다를 뿐 제공하는 기능은 거의 동일하다.
	// Optional 클래스는 단순히 집계 값만 저장하는 것이 아니라, 집계 값이 존재하지 않을 경우 디폴트 값을 설정할 수도 있고, 집계 값을 처리하는 Consumer도 등록할 수 있다.
	// 다음은 Optional 클래스들이 제공하는 메소드들이다.
	
	//	리턴 타입		메소드						설명
	//	
	//	boolean		isPresent()					값이 저장되어 있는지 여부
	//
	//	T			orElse(T)
	//	double		orElse(double)				값이 저장되어 있지 않을 경우 티폴트 값 지정
	//	int			orElse(int)
	//	long		orElse(long)
	//
	//				ifPresent(Consumer)
	//	void		ifPresent(DoubleConsumer)	값이 저장되오 있을 경우 Consumer에서 처리
	//				ifPresent(IntConsumer)
	//				ifPresent(LongConsumer)
	
	// 컬렉션의 요소는 동적으로 추가되는 경우가 많다. 만약 컬렉션의 요소가 추가되지 않아 저장된 요소가 없을 경우 다음 코드는 어떻게 될까?
	
	//	List<Integer> list = new ArrayList<>();
	//	double avg = list.stream()
	//		.mapToInt(Integer :: intValue)
	//		.average()
	//		.getAsDouble();
	//	System.out.println("평균" + avg);
	
	// 요소가 없기 때문에 평균값도 있을 수 없다. 그래서 NotSuchElementException 예외가 발생한다.
	// 요소가 없을 경우 예외를 피하는 세 가지 방법이 있는데, 첫 번째는 Optional 객체를 얻어 isPresent() 메소드로 평균값 여부를 확인하는 것이다.
	// isPresent() 메소드가 true를 리턴할 때만 getAsDouble() 메소드로 평균값을 얻으면 된다.
	
	//	OptionalDouble optional = list.stream()
	//		.mapToInt(Integer :: intValue)
	//		.average();
	//	if(optional.isPresent()) {
	//		System.out.println("평균: " + optional.getAsDouble());
	//	} else {
	//		System.out.println("평균: 0.0");
	//	}
	
	// 두 번째 방법은 orElse() 메소드로 디폴트 값을 정해 놓는다. 평균값을 구할 수 없는 경우에는 orElse()의 매개값이 디폴트 값이 된다.
	
	//	double avg = list.stream()
	//		.mapToInt(Integer :: intValue)	
	//		.average()
	//		.orElse(0.0);
	//	System.out.println("평균: " + avg);
	
	// 세 번째 방법은 ifPresent() 메소드로 평균값이 있을 경우에만 값을 이용하는 람다식을 실행한다.
	
	//	list.stream()
	//		.mapToInt(Integer :: intValue)
	//		.average()
	//		.ifPresent( a -> System.out.println("평균: " + a) );
	
	// 그럼 이제 예제를 살펴보자.
	
}
