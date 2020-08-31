package 챕터11_기본API클래스.ㄷ_Object클래스.ㄱ_객체비교_equals;

// 다음 예제는 Member 클래스에서 equals() 메소드를 재정의 한것이다.
// Member 타입이면서 id 필드값이 같을 경우 true를 리턴, 그렇지 않으면 false를 리턴하도록 했다.

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) { // 매개값이 Member 타입인지 확인
			Member member = (Member) obj; // Member타입으로 강제 타입 변환하고
			if(id.equals(member.id)) {	  // id 필드값이 동일한지 검하한 후,
				return true;			  // 동일하다면 true 리턴
			}
		}
		return false; // 매개값이 Member 타입이 아니거나 id 필드값이 다른 경우 false 리턴
	}
}
