package 챕터16_스트림_병렬처리;

public class ㄷ_StreamPipeline {
	// 대량의 데이터를 가공해서 축소하는 것을 일반적으로 리덕션(Reduction)이라고 하는데, 데이터의 합계, 평균값, 카운팅, 최댓값, 최소값 등이 대표적인 리덕션의 결과물이라고 볼 수 있다.
	// 그러나 컬렉션의 요소를 리덕션의 결과물로 바로 집계할 수 없을 경우에는 집계하기 좋도록 필터링, 매핑, 정렬, 그룹핑 등의 중간 처리가 필요하다.
	
			//	Middle Handling And Final Handling		중간 처리와 최종 처리
	
	// 스트림은 데이터의 필터링, 매핑, 정렬, 그룹핑 등의 중간 처리와 합계, 평균, 카운팅, 최대값, 최소값 등의 최종 처리를 파이프라인(pipelines)으로 해결한다.
	// 파이프라인은 여러 개의 스트림이 연결되어 있는 구조를 말한다. 파이프라인에서 최종 처리를 제외하고는 모두 중간 처리 스트림이다.
	
	//							|	중간 처리		| |	최종 처리	|
	//	스트림 소스		□ □ □		□ □ □		□ □ □		→		결과
	//	(컬렉션, 배열,
	//	파일)			오리지날		필터링 처리		매핑 처리		집계 처리
	//				스트림		중간 스트림		최종 스트림		결과물
	
	// 중간 스트림이 생성될 때 요소들이 바로 중간 처리(필터링, 매핑, 절렬)되는 것이 아니라 최종 처리가 시작되기 전까지 중간 처리는 지연(lazy)된다.
	// 최종 처리가 시작되면 비로소 컬렉션의 요소가 하나씩 중간 스트림에서  처리되고 최종 처리까지 오게 된다.
	
	// Stream 인터페이스에는 필터링, 매핑, 정렬 등의 많은 중간 처리 메소드가 있는데, 이 메소드들은 중간 처리된 스트림을 리턴한다.
	// 그리고 이 스트림에서 다시 중간 처리 메소드를 호출해서 파이프라인을 형성하게 된다. 예를 들어 회원 컬렉션에서 남자만 필터링하는 중간 스트림을 연결하고,
	// 다시 남자의 나이로 매핑하는 스트림을 견결한 후, 최종 남자 평균 나이를 집계한다면 다음과 같이 파이프라인이 형성된다.
	
	//									  |					중간 처리					| 	최종 처리			|
	//	회원 컬렉션			Member(남/녀)		  |		Member(남자)		|		age			|		→				→ 평균 나이
	//	Member(남)			오리지날		  ↑			남자 요소		↑		나이 요소		↑		집계 처리
	//	Member(여)			Stream	  filter()		Stream	mapToInt()	IntStream	|		OptionDouble
	//																			average()
	
	// 파이프라인을 자바 코드로 표현하면 다음과 같다.
	
	//	Stream<Member> maleFemaleStream = list.stream();
	//	Stream<Member> maleStream = maleFemaleStream.filter( m -> m.getSex() == Member.MALE );
	//	IntStream ageStream = maleStream.mapToInt( Member :: getAge );
	//	OptionalDouble optionalDouble = ageStream.average();
	//	double ageAvg = optionalDouble.getAsDouble();
	
	// 로컬 변수를 생략하고 연결하면 다음과 같은 형태의 파이프라인 코드만 남는다.
	
	//	double ageAvg = list.stream()					// 오리지날 스트림
	//		.filter( m -> m.getSex() == Member.MALE)	// 중간처리 스트림
	//		.mapToInt( Member :: getAge)				// 중간처리 스트림
	//		.average()									// 최종 처리
	//		.getAsDouble();
	
	// filter( m -> m.getSex() == Member.MALE )는 남자 Member 객체를 요소로 하는 새로운 스트림을 생성한다.
	// mapToInt(Member :: getAge())는 Member 객체를 age 값으로 매핑해서 age를 요소로 하는 새로운 스트림을 생성한다. average() 메소드는 age 요소들의 평균을 OptionalDouble에 저장한다.
	// OptionalDouble에서 저장된 평균값을 읽으려면 getAsDouble() 메소드를 호출하면 된다.
	
			//	Middle Handling Methods And Final Handling Methods		중간 처리 메소드와 최종 처리 메소드
	
	// 스트림 파이프라인에서 중간 처리를 하는 메소드와 최종 처리를 하는 메소드의 종류를 살펴보자.
	// 다음은 스트림이 제공하는 중간 처리와 최종 처리를 하는 메소드를 설명한 것이다.
	
	//		종류				리턴타입			메소드				소속된 인터페이스
	//───────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	//	중간		필터링						distinct()				공통
	//	처리									filter()				공통
	//──────────────						─────────────────────────────────────────────────────────────────────────────									
	//			매핑							flatMap()				공통
	//										flatMapToDouble()		Stream
	//										flatMapToInt()			Stream
	//					Stream				flatMapToLong()			Stream
	//					IntStream			map()					공통
	//					LongStream			mapToDouble				Stream, IntStream, LongStream
	//					DoubleStream		mapToInt()				Stream, LongStream, DoubleStream		
	//										mapToLong()				Stream, IntStream, DoubleStream
	//										mapToObj()				IntStream, LongStream, DoubleStream
	//										asDoubleStream()		IntStream, LongStream
	//										asLongStream()			IntStream
	//										boxed()					IntStrea, LongStream, DoubleStream
	//──────────────						─────────────────────────────────────────────────────────────────────────────		
	//			정렬							sorted()				공통
	//──────────────						─────────────────────────────────────────────────────────────────────────────			
	//			루핑							peek()					공통
	//───────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	//	최종		매칭		boolean				allMatch()				공통
	//	처리				boolean				anyMatch()				공통
	//					boolean				noneMatch()				공통
	//───────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	//			집계		long				count()					공통
	//					OptionalXXX			findFirst()				공통
	//					OptionalXXX			max()					공통
	//					OptionalXXX			min()					공통
	//					OptionalDouble		average()				IntStream, LongStream, DoubleStream
	//					OptionalXXX			reduce()				공통
	//					int, long, double	sum()					IntStream, LongStream, DoubleStream
	//───────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	//			루핑		void				forEach()				공통
	//───────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	//			수집		R					collect()				공통
	//───────────────────────────────────────────────────────────────────────────────────────────────────────────────────
	
	// 중간 처리 메소드와 최종 처리 메소드를 쉽게 구분하는 방법은 리턴 타입을 보면 된다. 리턴 타입이 스트림이라면 중간 처리 메소드이고,
	// 기본 타입이거나 OptionalXXX라면 최종 처리 메소드이다. 소속된 인터페이스에서 공통의 의미는 Stream, IntStream, LongStream, DoubleStream에서 모두 제공된다는 뜻이다.
}
