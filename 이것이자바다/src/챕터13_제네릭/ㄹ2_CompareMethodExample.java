package 챕터13_제네릭;

public class ㄹ2_CompareMethodExample {
	public static void main(String[] args) {
		ㄹ2_Pair<Integer, String> p1 = new ㄹ2_Pair<Integer, String>(1, "사과");
		ㄹ2_Pair<Integer, String> p2 = new ㄹ2_Pair<Integer, String>(1, "사과");
		boolean result1 = ㄹ2_Util.<Integer, String>compare(p1, p2);		// 구체적인 타입을 명시적으로 지정
		
		if(result1) {
			System.out.println("논리적으로 동등한 객체");
		} else {
			System.out.println("논리적으로 동등하지 않은 객체");
		}
		
		ㄹ2_Pair<String, String> p3 = new ㄹ2_Pair<String, String>("user1", "홍길동");
		ㄹ2_Pair<String, String> p4 = new ㄹ2_Pair<String, String>("user2", "홍길동");
		boolean result2 = ㄹ2_Util.compare(p3, p4);						// 구체적인 타입을 추정
		
		if(result2) {
			System.out.println("논리적으로 동등한 객체");
		} else {
			System.out.println("논리적으로 동등하지 않은 객체");
		}
	}
}
