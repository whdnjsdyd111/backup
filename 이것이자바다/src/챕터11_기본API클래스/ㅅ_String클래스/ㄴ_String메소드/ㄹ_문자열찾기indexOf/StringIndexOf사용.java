package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㄹ_문자열찾기indexOf;

public class StringIndexOf사용 {
	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군요.");
		} else {
			System.out.println("자바와 관련없는 책이군요.");
		}
	}
}
