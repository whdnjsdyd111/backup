package 챕터06_클래스;

public class ㅅ3_CarExample {
	public static void main(String[] args) {
		ㅅ3_Car car1 = new ㅅ3_Car();
		System.out.println(car1.company);
		System.out.println();
		
		ㅅ3_Car car2 = new ㅅ3_Car("자가용");
		System.out.println(car2.company + "\t" + car2.model);
		System.out.println();
		
		ㅅ3_Car car3 = new ㅅ3_Car("자가용", "빨강");
		System.out.println(car3.company + "\t" + car3.model + "\t" + car3.color);
		System.out.println();
		
		ㅅ3_Car car4 = new ㅅ3_Car("택시", "검정", 200);
		System.out.println(car4.company + "\t" + car4.model + "\t" + car4.color + "\t" + car4.maxSpeed);
	}
}
