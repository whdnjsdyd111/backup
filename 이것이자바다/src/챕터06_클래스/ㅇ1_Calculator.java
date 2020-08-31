package 챕터06_클래스;

public class ㅇ1_Calculator {
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double devide(int x, int y) {
		double result = (double) x / (double) y;
		return result;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
}
