package 챕터13_제네릭;

public class ㅂ_WildcardType {
	// 코드에서 >를 일반적으로 와일드카드(wildcard)라고 부른다. 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 구체적인 타입 대신에 와일드카드를 다음과 같이 세가지 형태로 사용할 수 있다.
	
	//	- 제네릭타입<?> : Unbounded Wildcards(제한 없음)
	//			타입 파라미터를 대치하는 구체적인 타입으로 모든 클래스나 인터페이스 타입이 올 수 있다.
	//	- 제네릭타입<? exnteds 상위타입> : Upper Bounded Wildcards(상위 클래스 제한)
	//			타입 파라미터를 대치하는 구체적인 타입으로 상위 타입이나 하위 타입만 올 수 있다.
	//	- 제네릭타입<> super 하위타입> : Lower Bounded Wildcards(하위 클래스 제한)
	//			타입 파라미터를 대치하는 구체적인 타입으로 하위 타입이나 상위 타입이 올 수 있다.
	
	// 다음 예제를 보며 이해하자. 제네릭 타입 Course는 과정 클래스로 과정 이름과 수강생을 저장할 수 있는 배열을 가지고 있다. 타입 파라미터 T가 적용된 곳은 수강생 타입 부분이다.
	
	// 수강생이 될 수 있는 타입은 다음 4 가지 클래스라고 가정하자. Person의 하위 클래스로 Worker와 Student가 있고, Student의 하위 클래스로 HighStudent가 있다.
	
	//				Person
	//			↙			↘
	//		Worker		Student
	//						↓
	//					HighStudent
	
	//	- Course<?>
	//			수강생은 모든 타입(Person, Worker, Student, HighStudent)이 될 수 있다.
	//	- Course<? extends Student>
	//			수강생은 Student와 HighStudent만 될 수 있다.
	//	- Course<? super Worker>
	//			수강생은 Worker와 Person만 될 수 있다.
	
	// 다음 예제는 registerCourseXXX() 메소드의 매개값으로 와일드카드 타입을 사용하였다.
	// registerCourse()는 모든 수강생이 들을 수 있는 과정을 등록하고, registerCourseStudent()는 학생만 들을 수 있는 과정을 등록한다. 
	// 그리고 registerCourseWorker는 직장인만 들을 수 있는 과정을 등록한다.
}
