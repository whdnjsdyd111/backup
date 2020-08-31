package 챕터07_상속;

public class ㅇ1_SmartPhone extends ㅇ1_Phone{
	// 생성자
	public ㅇ1_SmartPhone(String owner) {
		super(owner);
	}
	
	// 메소드
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}
}
