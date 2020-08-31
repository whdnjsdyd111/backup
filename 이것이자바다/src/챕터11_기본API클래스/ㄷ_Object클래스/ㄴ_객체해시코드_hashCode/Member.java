package 챕터11_기본API클래스.ㄷ_Object클래스.ㄴ_객체해시코드_hashCode;

// 이전에 사용한 Member 클래스를 보완하는 측면에서 hashCode() 메소드를 재정의 한것이다.
// id 필드값이 같을 경우 같은 해시코드를 리턴하도록 하기 위해 String의 hashCode() 메소드의 리턴값을 활용했다.
// String의 hashCode()는 같은 문자열일 경우 동일한 해시코드를 리턴한다.

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() { // id가 동일한 문자열일 경우 같은 해시코드를 리턴
		return id.hashCode();
	}
}
