package 챕터06_클래스;

public class ㅋ1_PersonExample {
	public static void main(String[] args) {
		ㅋ1_Person p = new ㅋ1_Person("123456-1234567", "계백");
		
		System.out.println(p.nation);
		System.out.println(p.ssn);
		System.out.println(p.name);
		
		// p.nation = "usa"					// 변경 불가
		// p.ssn = "654321 - 7654321";		// 변경 불가
		p.name = "을지문덕";
		System.out.println(p.name);
	}
}
