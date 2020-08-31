package 챕터07_상속;

public class ㅇ1_PhoneExample {
	public static void main(String[] args) {
//		Phone phone = new Phone();	( x )
		
		ㅇ1_SmartPhone smartPhone = new ㅇ1_SmartPhone("홍길동");
		
		smartPhone.turnOn();			// Phone의 메소드
		smartPhone.internetSearch();
		smartPhone.turnOff();			// Phone의 메소드
	}
}
