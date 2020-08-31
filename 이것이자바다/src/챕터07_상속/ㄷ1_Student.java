package 챕터07_상속;

public class ㄷ1_Student extends ㄷ1_People{
	public int studentNo;
	
	public ㄷ1_Student(String name, String ssn, int studentNo) {
		super(name, ssn);	// 부모 생성자 호출
		this.name = "d";
	}
	
	// Student 클래스의 생성자는 name, ssn, studentNo를 매개값으로 받아 name, ssn은 다시 부모 생성자를 호출하기 위해 매개값을 넘겨준다.
	// 7행의 super() 메소드를 주석 처리한다면 에러가 발생한다. 이것은 부모의 기본 생성자가 없으니 다른 생성자를 명시적으로 호출하라는 것이다.
}
