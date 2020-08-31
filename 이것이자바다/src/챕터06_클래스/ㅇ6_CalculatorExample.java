package 챕터06_클래스;

public class ㅇ6_CalculatorExample {
	public static void main(String[] args) {
		ㅇ6_Calculator cal = new ㅇ6_Calculator();

		// 정사각형 넓이 구하기
		double result1 = cal.areaRectangle(10);
		
		// 직사각형 넓이 구하기
		double result2 = cal.areaRectangle(10, 20);
		
		// 결과
		System.out.println("정사각형 넓이: " + result1);
		System.out.println("직사각형 넓이: " + result2);
		
	}
}
