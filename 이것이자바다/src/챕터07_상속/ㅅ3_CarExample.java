package 챕터07_상속;

public class ㅅ3_CarExample {
	public static void main(String[] args) {
		ㅅ3_Car car = new ㅅ3_Car();
		
		for (int i = 0; i <= 5; i++) {
			int problemLocation = car.run();
			
			switch(problemLocation) {
			
			case 1:
				System.out.println("앞왼쪽 HankookTire로 교체");
				car.frontLeftTire = new ㅅ3_HankookTire("앞왼쪽", 15);
				break;
				
			case 2:
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.frontRightTire = new ㅅ3_KumhoTire("앞오른쪽", 13);
				break;
				
			case 3:
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLeftTire = new ㅅ3_HankookTire("뒤왼쪽", 14);
				break;
				
			case 4:
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.backRightTire = new ㅅ3_KumhoTire("뒤오른쪽", 17);
				break;
			}
			
			System.out.println("-------------------------");
		}
	}
}
