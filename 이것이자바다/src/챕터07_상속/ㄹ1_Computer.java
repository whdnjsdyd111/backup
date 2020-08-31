package 챕터07_상속;

public class ㄹ1_Computer extends ㄹ1_Calculator {
	@Override
	double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;
	}
	
	// 좀 더 정밀한 계산을 위해 Computer의 메소드에선 Math.PI 상수를 이용했다.
	// 사실 @Override 어노테이션은 생략해도 되지만 이것을 붙여줌으로써 정확히 오버라이딩된 것인지 컴파일러가 체크하기 때문에 개발자의 실수를 줄여준다.
	// 예로 개발자가 실수로 areaCircl() 처럼 끝에 e를 빼먹게 되면 컴파일 에러가 발생한다.
}
