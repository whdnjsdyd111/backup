package 챕터11_기본API클래스.ㅍ_Math와Random클래스.ㄴ_Random클래스;

public class Random클래스 {
	// java.util.Random 클래스는 나수를 얻어내기 위해 다양한 메소드를 제공한다.
	// Math.random() 메소드는 0.0에서 1 사이의 double 난수를 얻는 데만 사용한다면, 
	// Random 클래스는 boolean, int, long, float, double 난수를 얻을 수 있다.
	// 또 다른 차이점은 Random 클래스는 종자값(seed)을 설정할 수 있다.
	// 종자값은 난수를 만드는 알고리즘에 사용되는 값으로 종자값이 같으면 같은 난수를 얻는다.
	// Random 클래스로부터 Random 객체를 생성하는 방법은 다음 두 가지가 있다.
	
	//	생성자				설명
	//	Random()			호출 시마다 다른 종자값(현재시간 이용)이 자동 설정된다.
	//	Random(long seed)	매개값으로 주어진 종자값이 설정된다.
	
	// 다음은 Random 클래스가 제공하는 메소드이다.
	
	//	리턴값		메소드(매개 변수)			설명
	//
	//	boolean		nextBoolean()		boolean 타입의 난수를 리턴
	//
	//	double		nextDouble()		double 타입의 난수를 리턴(0.0 <= ~ < 1.0)
	//
	//	int			nextInt()			int 타입의 난수를 리턴(-2 31제곱 <= ~ <= 2 31제곱 -1)
	//
	//	int			nextInt(int n)		int 타입의 난수를 리턴(0 <= ~ < n) 

}
