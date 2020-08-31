package 챕터07_상속;

public class ㄷ1_StudentExample {
	public static void main(String[] args) {
		ㄷ1_Student student = new ㄷ1_Student("홍실동", "123456-1234567", 1);
		
		System.out.println("name: " + student.name);
		System.out.println("ssn: " + student.ssn);		// 부모 클래스에서 물려받은 필드 출력
		
		System.out.println("studentNo: " + student.studentNo);	// 자식 클래스의 필드
	}
}
