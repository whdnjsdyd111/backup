package 챕터16_스트림_병렬처리;

public class ㄱ_Stream {
	// 스트림 (stream)은 자바 8부터 추가된 컬렉션(배열 포함)의 저장 요소를 하나씩 참조해서 람다식 (함수적-스타일(functional style))으로 처리할 수 있도록 해주는 반복자이다.
	
			//	Iterator Stream		반복자 스트림
	
	// 자바 7 이전까지는 List<String> 컬렉션에서 요소를 순차적으로 처리하기 위해 Iterator 반복자를 다음과 같이 사용해왔다.
	
	//	List<String> list = Arrays.asList("홍길동", "신용권", "김자바");
	//	Iterator<String> iterator = list.iterator();
	//	while(iterator.hasNext()) {
	//		String name = iterator.next();
	//		System.out.println(name);
	//	}
	
	// 이 코드를 Stream을 사용해서 변경하면 다음과 같다.
	
	//	List<String> list = Arrays.asList("홍길동", "신용권", "김자바");
	//	Stream<String> stream = list.stream();
	//	stream.forEach( name -> System.out.println(name) );
	
	// 컬렉션 (java.util.Collection)의 stream() 메소드로 스트림 객체를 얻고 나서 stream.forEach( name -> System.out.println(name) ); 메소드를 통해 컬렉션의 요소를 하나씩 콘솔에 출력한다.
	// forEach() 메소드는 다음과 같이 Consumer 함수적 인터페이스 타입의 매개값을 가지므로 컬렉션의 요소를 소비할 코드를 람다식으로 기술할 수 있다.
	
	//	void forEach(Consumer<T> action)
	
	// Iterator를 사용한 코드와 Stream을 사용한 코드를 비교해보면 Stream을 사용하는 것이 훨씬 단순해 보인다.
	// 다음 예제는 List<String> 컬렉션의 String 요소를 Iterator와 Stream을 이용해서 순차적으로 콘솔에 출력한다.
	
			//	Characteristic Of Stream		스트림의 특징
	
	// Stream은 Iterator와 비슷한 역할을 하는 반복자이지만, 람다식으로 요소 처리 코드를 제공하는 점과 내부 반복자를 사용하므로 병렬 처리가 쉽다는 점
	// 그리고 중간 처리와 최종 처리 작업을 수행하는 점에서 많은 차이를 가지고 있다. 이 특징에 대해서 자세히 살펴보기로 하자.
	
			/*	It Supplies Element Handling Code in Lambda		람다식으로 요소 처리 코드를 제공한다		*/
	
	// Stream이 제공하는 대부분의 요소 처리 메소드는 함수적 인터페이스 매개 타입을 가지기 때문에 람다식 또는 메소드 참조를 이용해서 요소 처리 내용을 매개값으로 전달할 수 있다.
	// 다음 예제는 컬렉션에 저장된 Student를 하나씩 가져와 학생 이름과 성적을 콘솔에 출력하도록 forEach() 메소드의 매개값으로 람다식을 주었다.
	
			/*	It Can Parallel Handle Easily Because Of Using Internal Iterator	내부 반복자를 사용하므로 병렬 처리가 쉽다	*/
	
	// 외부 반복자 (external iterator)란 개발자가 코드로 직접 컬렉션의 요소를 반복해서 가져오는 코드 패턴을 말한다. 
	// index를 이용하는 for문 그리고 Iterator를 이용하는 while문은 모두 외부 반복자를 이용하는 것이다.
	// 반면에 내부 반복자 (internal iterator)는 컬렉션 내부에서 요소들을 반복시키고, 개발자는 요소당 처리해야 할 코드만 제공하는 코드 패턴을 말한다.
	// 다음을 보면서 외부 반복자와 내부 반복자를 이해해보자.
	
	//		[외부 반복자]				[내부 반복자]
	//
	//	개발자 코드			컬렉션	개발자 코드			     컬렉션
	//		↓	next() → o			↓	  →		  	o
	//	처리	o			 ←				처리코드  	처리  ↓
	//		↓	next() → o				   제공		o
	//	처리	o			 ←					 	처리  ↓
	//		↓	next() → o							o
	//		o			 ←						처리  ↓
	//		.										.
	//		.										.
	
	// 내부 반복자를 사용해서 얻은 이점은 컬렉션 내부에서 어떻게 요소를 반복시킬 것인가는 컬렉션에 맡겨두고,, 개발자는 요소 처리 코드에만 집중할 수 있다는 것이다.
	// 내부 반복자는 요소들의 반복 순서를 변경하거나, 멀티 코어 CPU를 최대한 활용하기 위해 요소들을 분배시켜 병렬 작업을 할 수 있게 도와주기 때문에 하나씩 처리하는 순차적 외부 반복자보다는 효율적으로 요소를 반복시킬 수 있다.
	
	//		[내부 반복자]
	//
	//	개발자 코드				         컬렉션
	//			  			코어1		코어2
	//		↓	  →			o		o
	//			개발코드	처리	↓	처리	↓
	//			제공			o		o
	//					처리	↓	처리	↓
	//						o		o
	//					처리	↓	처리	↓
	//						.		.
	//						.		.
	
	// Iterator는 컬렉션의 요소를 가져오는 것에서부터 처리하는 것까지 모두 개발자가 작성해야 하지만, 스트림은 람다식으로 요소 처리 내용만 전달할 뿐, 반복은 컬렉션 내부에서 일어난다.
	// 스트림을 이용하면 코드도 간결해지지만, 무엇보다도 요소의 병렬 처리가 컬렉션 내부에서 처리되므로 일석이조의 효과를 가져온다.
	
	// 병렬 (parallel) 처리란 한 가지 작업을 서브 작업으로 나누고, 서브 작업들을 분리된 스레드에서 병렬적으로 처리하는 것을 말한다.
	// 병렬 처리 스트림을 이용하면 런타임 시 하나의 작업을 서브 작업으로 자동으로 나누고, 서브 작업의 결과를 자동으로 결합해서 최종 결과물을 생성한다.
	// 예를 들어 컬렉션의 요소 총합을 구할 때 순차 처리 스트림은 하나의 스레드가 요소들을 순차적으로 읽어 합을 구하지만, 
	// 병렬 처리 스트림을 이용하면 여러 개의 스레드가 요소들을 부분적으로 합하고 이 부분 합을 최종 결합해서 전체 합을 생성한다.
	// 다음 예제는 순차 처리 스트림과 병렬 처리 스트림을 이용할 경우, 사용된 스레드의 이름이 무엇인지 콘솔에 출력한다. 실행 결과를 보면 병렬 처리 스트림은 main 스레드를 호함해서
	// ForkJoinPool(스레드풀)의 작업 스레드들이 병렬적으로 요소를 처리하는 것을 볼 수 있다.
	
			/*	Stream Can Do Middle Handling And Final Handling	스트림은 중간 처리와 최종 처리를 할 수 있다.	*/
	
	// 스트림은 컬렉션의 요소에 대해 중간 처리와 최종 처리를 수행할 수 있는데, 중간 처리에서는 매핑, 필터링, 정렬을 수행하고 최종 처리에서는 반복, 카운팅, 평균, 총합 등의 집계 처리를 수행한다.
	
	//							|	중간 처리		|	최종 처리	|
	//	컬렉션, 배열	□ □ □		□ □ □		□ □ □		→		결과
	//
	//				오리지날		필터링 처리		매핑 처리		집계 처리
	//				스트림		중간 스트림		최종 스트림		결과물
	
	// 예를 들어 학생 객체를 요소로 가지는 컬렉션이 있다고 가정해보자. 중간 처리에서는 학생의 점수를 뽑아내고, 최종 처리에서는 점수의 평균값을 산출한다.
	
	//		Collection
	//				Student		Student		Student
	//	
	//							↘	ㅁ	↙
	//								ㅁ
	//							↓		↓
	//		Stream
	//			중간 처리 : 학생의 개별 점수를 뽑아낸다. (Student 객체를 점수로 매핑)
	//								↓
	//				최종 처리 : 점수의 평균값을 산출한다. (집계)
	
	// 다음 예제는 List에 저장되어 있는 Student 객체를 중간 처리에서 score 필드값으로 매핑하고, 최종 처리에서 score의 평균값을 산츨한다.
}
