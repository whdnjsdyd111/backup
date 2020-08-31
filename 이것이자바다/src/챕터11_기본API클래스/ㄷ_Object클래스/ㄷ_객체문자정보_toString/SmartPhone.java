package 챕터11_기본API클래스.ㄷ_Object클래스.ㄷ_객체문자정보_toString;

// 우리가 만든 클래스도 toString() 메소드를 재정의해서 좀 더 유용한 정보를 리턴하도록 할 수 있다.
// SmartPhone 클래스에서 toString() 메소드를 오버라이딩하여 제작회사와 운영체제를 리턴하도록 만들어보자.

public class SmartPhone {
	private String company;
	private String os;
	
	public SmartPhone(String company, String os) {
		this.company = company;
		this.os = os;
	}
	
	@Override
	public String toString() { // toString() 재정의
		return company + ", " + os;
	}
}
