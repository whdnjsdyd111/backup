package é��07_���;

public class ��4_CarExample {
	public static void main(String[] args) {
		��4_Car car = new ��4_Car();
		
		for (int i = 1; i <= 5; i++) {
			int problemLocation = car.run();
			
			if(problemLocation != 0) {
				
				System.out.println(car.tires[ problemLocation - 1 ].location + " HankookTire�� ��ü");
				
				car.tires[ problemLocation - 1 ] = 
						new ��3_HankookTire(car.tires[ problemLocation - 1 ].location, 15);
			}
			
			System.out.println("------------------------");
			
		}
	}
}
