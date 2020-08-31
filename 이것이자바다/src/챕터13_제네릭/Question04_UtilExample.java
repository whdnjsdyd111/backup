package 챕터13_제네릭;

public class Question04_UtilExample {
	public static void main(String[] args) {
		Question04_Pair<String, Integer> pair = new Question04_Pair<String, Integer>("홍길동", 35);
		Integer age = Question04_Util.getvalue(pair, "홍길동");				// 일치
		System.out.println(age);
		
		Question04_ChildPair<String, Integer> childPair = new Question04_ChildPair<String, Integer>("홍삼원", 20);
		Integer childAge = Question04_Util.getvalue(childPair, "홍삼순");		// 일치하지 않음
		System.out.println(childAge);
		
		/*
		Question04_OtherPair<String, Integer> otherPair = new Question04_OtherPair<String, Integer>("홍삼원", 20);
		Integer otherAge = Question04_Util.getvalue(otherPair, "홍삼원");
		System.out.println(otherAge);*/
		
		// OtherPair는 Pair를 상속하지 않으므로 예외가 발생
	}
}
