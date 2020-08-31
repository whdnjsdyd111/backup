package 챕터11_기본API클래스.ㅍ_Math와Random클래스.ㄱ_Math클래스;

public class Random {
	// Math.random() 메소드는 0.0과 1.0 사이의 범위에 속하는 하나의  double 타입의 값을 리턴한다.
	// 0.0은 범위에 포함되고 1.0은 포함되지 않는다.
	
	//	0.0 <= Math.random() < 1.0
	
	// Math.random()을 활용해서 1부터 10까지의 정수 난수를 얻고 싶다면 다음과 같은 순서로 연산식을 만들면 된다.
	
	//	① 각 변에 10을 곱하면 다음과 같이 0.0 <= ... < 10.0 사이의 범위에 속하는 하나의 double 타입의 값을 얻을 수 있다.
	//	0.0*10 <= Math.random()*10 < 1.0*10
	//	(0.0)						 (10.0)
	
	//	② 각 변을 int 타입으로 강제 타입 변환하면 다음과 같이 0 <= ... < 10 사이의 범위에 속하는 하나의 int 타입의 값을 얻을 수 있다.
	//	(int) (0.0*10) <= (int) (Math.random()*10) < (int) (1.0*10)
	//		  (0)		(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)		  (10)
	
	//	③ 각 변에 1을 더하면 다음과 같이 1 <= ... < 11 사이의 범위에 속하는 하나의 정수를 얻게 된다.
	//	(int) (0.0*10) +1 <= (int) (Math.random()*10) +1 < (int) (1.0*10) +1
	//		  (1)		   (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)		  (11)
	
	//	④ 이제 start <= ... < (start + n) 범위에 속하는 하나의 정수를 얻기 위한 연산식을 다음과 같이 만들면 된다.
	//	int num = (int) (Math.random() * n) + start;
	
	//	[예제1] 주사위 번호 뽑기
	//	int num = (int) (Math.random() * 6) + 1;
	
	//	[예제2] 로또 번호 뽑기
	//	int num = (int) (Math.random() * 45) + 1;
	
	// 다음 예제는 Math.random() 메소드로 주사위 눈을 얻은 방법이다.
	
	public static void main(String[] args) {
		int num = (int) (Math.random() * 6) + 1;
		System.out.println("주사위 눈: " + num);
	}
}
