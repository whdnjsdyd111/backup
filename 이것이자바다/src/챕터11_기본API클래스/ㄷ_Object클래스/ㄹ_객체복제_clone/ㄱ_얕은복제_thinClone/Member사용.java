package 챕터11_기본API클래스.ㄷ_Object클래스.ㄹ_객체복제_clone.ㄱ_얕은복제_thinClone;

// 다음 예제를 보면 원본 Member를 복제한 후, 복제 Member의 password 필드값을 변경하더라도 원본 Member의 password 필드값은 변경되지 않음을 보여준다.

public class Member사용 {
	public static void main(String[] args) {
		// 원본 객체 생성
		Member original = new Member("blue", "홍길동", "12345", 25, true);
		
		// 복제 객체를 얻은 후에 패스워드 변경
		Member cloned = original.getMember();
		cloned.password = "67890"; // 복제 객체에서 패스워드 변경
		

		System.out.println("[복제 객체의 필드값]");
		System.out.println("id: "+cloned.id);
		System.out.println("name: "+cloned.name);
		System.out.println("password: "+cloned.password);
		System.out.println("age: "+cloned.age);
		System.out.println("adult: "+cloned.adult);
		
		System.out.println("[원본 객체의 필드값]");
		System.out.println("id: "+original.id);
		System.out.println("name: "+original.name);
		System.out.println("password: "+original.password); // 원본 객체의 패스워드는 변함 없음
		System.out.println("age: "+original.age);
		System.out.println("adult: "+original.adult);
	}
}
