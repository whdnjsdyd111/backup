package 챕터04_조건문_반복문;

public class ㅊ_Break {
	public static void main(String[] args) {

		while(true) {
			
			int num = (int)(Math.random() * 6) + 1;
			System.out.println(num);
			
			if(num == 6)
				break;
			
		}

		System.out.println("종료 되었습니다.");
	}
}
