package 챕터11_기본API클래스.ㅌ_Wrapper클래스.ㄴ_자동박싱과언박싱;

public class AutoBoxingUnBoxing {
	public static void main(String[] args) {
		// 자동 Boxing
		Integer obj = 100;
		System.out.println("value: " + obj.intValue());
		
		// 대입 시 자동 UnBoxing
		int value = obj;
		System.out.println("value: " + value);
		
		// 연산 시 자동 UnBoxing
		int result = obj + 100;
		System.out.println("result: " + result);
	}
}
