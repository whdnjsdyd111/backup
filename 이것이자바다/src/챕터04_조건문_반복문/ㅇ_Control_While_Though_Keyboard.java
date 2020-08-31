package 챕터04_조건문_반복문;

public class ㅇ_Control_While_Though_Keyboard {
	public static void main(String[] args) throws Exception {
		
		boolean run = true;
		int speed = 0;
		int keyboard = 0;
		
		while(run) {
			
			if(keyboard !=13 && keyboard != 10) {
				System.out.println("-------------------------");
				System.out.println("1.증속 ㅣ 2.감속 ㅣ 3.중지");
				System.out.println("-------------------------");
				System.out.println("선택: ");
			}
			
			keyboard = System.in.read();
			
			if(keyboard == 49) {	// 1을 읽었을 경우
				speed++;
				System.out.println("현재속도 = " + speed);
			} else if(keyboard == 50) {	// 2를 읽었을 경우
				speed--;
				System.out.println("현재속도 = " + speed);
			} else if(keyboard == 51) { // 3을 읽었을 경우
				run = false;
			}
		}
		
		System.out.println("시스템 종료");
		
	}
}
