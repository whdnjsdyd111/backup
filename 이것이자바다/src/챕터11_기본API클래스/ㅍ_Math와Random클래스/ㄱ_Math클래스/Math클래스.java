package 챕터11_기본API클래스.ㅍ_Math와Random클래스.ㄱ_Math클래스;

public class Math클래스 {
	// java.lang.Math 클래스는 수학 계산에 사용할 수 있는 메소드를 제공하고 있다.
	// Math 클래스가 제공하는 메소드는 모두 정적이므로 Math 클래스로 바로 이용이 가능하다.
	// 다음은 Math 클래스가 제공하는 메소드를 설명한 표이다.
	
	//	메소드							설명			예제 코드								리턴값
	
	//	int able(int a)					절대값		int v1 = Math.abs(-5);				v1 = 5
	//	double abs(double a)						double v2 = Math.abs(-3.14);		v2 = 3.14
	
	//	double ceil(double a)			올림값		double v3 = Math.ceil(5.3);			v3 = 6
	//												double v4 = Math.ceil(-5.3);		v4 = -5
	
	//	double floor(double a)			버림값		double v5 = Math.floor(5.3);		v5 = 5.0
	//												double v6 = Math.floor(-5.3);		v6 = -6.0
	
	//	int max(int a, int b)			최대값		int v7 = Math.max(5, 9);			v7 = 9
	//	double max(double a, double b)				double v8 = Math.max(5.3, 2.5);		v8 = 5.3
	
	//	int min(int a, int b)			최솟값		int v9 = Math.min(5, 9);			v9 = 5
	//	double min(double a, double b)				double v10 = Math.min(5.3, 2.5);	v10 = 2.5
	
	//	double random()					랜덤값		double v11 = Math.random();			0.0<= v11 <1.0
	
	//	double rint(double a)			가까운 정수의	double v12 = Math.rint(5.3);		v12 = 5.0
	//									실수값		double v13 = Math.rint(5.7);		v13 = 6.0
	
	//	long round(double a)			반올림값		long v14 = Math.round(5.3);			v14 = 5
	//												long v15 = Math.round(5.7);			v15 = 6
}
