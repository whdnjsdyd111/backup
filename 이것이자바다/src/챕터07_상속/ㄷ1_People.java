package 챕터07_상속;

public class ㄷ1_People {
	public String name;
	public String ssn;
	
	public ㄷ1_People(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	// People 클래스에 기본 생성자가 아닌 매개값을 받는 생성자만 있다.
	// 그렇다면 People을 상속하는 Student 클래스에서는 super(name, ssn)으로 People 클래스의 생성자를 호출해야 한다.
}
