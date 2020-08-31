package 챕터04_조건문_반복문;

public class ㄴ_Random_Numbers_Switch {
	public static void main(String[] args) {
		int num = (int) (Math.random() * 6) + 1;
		
		switch (num) {
		case 1:
			System.out.println("1이 나왔습니다");
			break;
		case 2:
			System.out.println("2가 나왔습니다");
			break;
		case 3:
			System.out.println("3이 나왔습니다");
			break;
		case 4:
			System.out.println("4가 나왔습니다");
			break;
		case 5:
			System.out.println("5가 나왔습니다");
			break;
		case 6:
			System.out.println("6이 나왔습니다");
		}
		
	}
}
