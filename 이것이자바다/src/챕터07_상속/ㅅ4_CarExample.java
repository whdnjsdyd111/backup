package 챕터07_상속;

public class ㅅ4_CarExample {
	public static void main(String[] args) {
		ㅅ4_Car car = new ㅅ4_Car();
		
		for (int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			
			if(problemLocation != 0) {
				
				System.out.println(car.tires[ problemLocation - 1 ].location + " HankookTire로 교체");
				
				car.tires[ problemLocation - 1 ] = 
						new ㅅ3_HankookTire(car.tires[ problemLocation - 1 ].location, 15);
			}
			
			System.out.println("------------------------");
			
		}
	}
}
