package 챕터11_기본API클래스.ㄷ_Object클래스.ㄹ_객체복제_clone.ㄴ_깊은복제_deepClone;

// 다음 예제는 Member 클래스의 getMember() 메소드를 호출해서 복제된 Member 객체를 얻은 후에 scores 배열 항목값과 car 객체의 모델을 변경한다.
// 하지만 원본 Member 객체의 scores 배열 항목값과 car 객체의 모델은 변함이 없는 것을 볼 수 있다.
// 원본과 복제본이 각각 참조하는 scores 배열과 car 객체는 서로 다르기 때문이다.

public class Member사용 {
	public static void main(String[] args) {
		// 원본 객체 생성
		Member original = new Member("홍길동", 25, new int[] {90, 90}, new Car("소나타"));
		
		// 복제 객체를 얻은 후에 참조 객체의 값을 변경
		Member cloned = original.getMember();
		cloned.scores[0] = 100;
		cloned.car.model = "그랜저";
		
		System.out.println("[복제 객체의 필드값]");
		System.out.println("name: "+cloned.name);
		System.out.println("age: "+cloned.age);
		System.out.print("scores: {");
		for(int i=0; i<cloned.scores.length; i++) {
			System.out.print(cloned.scores[i]);
			System.out.print((i == (cloned.scores.length-1)) ? " " : ",");
		}
		System.out.println("}");
		System.out.println("car: "+cloned.car.model);
		
		System.out.println();
		
		System.out.println("[원본 객체의 필드값]");
		System.out.println("name: "+original.name);
		System.out.println("age: "+original.age);
		System.out.print("scores: {");
		for(int i=0; i<original.scores.length; i++) {
			System.out.print(original.scores[i]);
			System.out.print((i == (original.scores.length-1)) ? "" : ",");
		}
		System.out.println("}");
		System.out.println("car: "+original.car.model);
	}
}
