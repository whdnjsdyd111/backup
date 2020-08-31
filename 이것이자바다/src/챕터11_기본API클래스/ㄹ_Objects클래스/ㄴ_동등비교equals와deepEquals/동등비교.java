package 챕터11_기본API클래스.ㄹ_Objects클래스.ㄴ_동등비교equals와deepEquals;

public class 동등비교 {
	// Object.equals(Object a, Object b)는 두 객체의 동등을 비교하는데 다음과 같은 결과를 리턴한다.
	// 특이한 점은 a와 b가 모두 null일 경우 true를 리턴한다는 점이다. a와 b가 null이 아닌 경우는 e.quals(b)의 결과를 리턴한다.
	
	//	a			b			Objects.equals(a,b)
	//	not null	not null	e.equals(b)의 리턴값
	//	null		not null	false
	//	not null	null		false
	//	null		null		true
	
	// Object.deepEquals(Object a, Object b) 역시 두 객체의 동등을 비교하는데, a와 b가 서로 다른 배열일 경우,
	// 항목 값이 모두 값다면 true를 리턴한다. 이것은 Arrays.deepEquals(Object[] a, Object[] b)와 동일하다.
	
	//	a						b						Objects.equals(a, b)
	//	not null(not array)		not null(not array)		a.equals(b)의 리턴값
	//	not null(array)			not null(array)			Arrays.deepEquals(a, b)의 리턴값
	// 	not null				null					false
	//	null					not null				false
	//	null					null					true
}
