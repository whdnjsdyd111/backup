package 챕터04_조건문_반복문;

public class ㄹ_CharType_Switch {
	public static void main(String[] args) {
		char grade = 'B';

		switch (grade) {
		case 'A':
		case 'a':
			System.out.println("우수 사원");
			break;
		case 'B':
		case 'b':
			System.out.println("일반 사원");
			break;
		default:
			System.out.println("비정규직");
		}

	}
}
