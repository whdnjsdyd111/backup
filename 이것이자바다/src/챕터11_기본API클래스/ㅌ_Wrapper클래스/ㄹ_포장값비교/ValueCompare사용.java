package 챕터11_기본API클래스.ㅌ_Wrapper클래스.ㄹ_포장값비교;

public class ValueCompare사용 {
	public static void main(String[] args) {
		System.out.println("[-127 ~ 128 초과값일 경우]");
		Integer obj1 = 300;
		Integer obj2 = 300;
		System.out.println("==결과: " + (obj1 == obj2));
		System.out.println("언박싱한 ==결과: " + (obj1.intValue() == obj2.intValue()));
		System.out.println("equals() 결과: " + obj1.equals(obj2));
		System.out.println();
		
		System.out.println("[-127 ~ 128 범위값일 경우]");
		Integer obj3 = 10;
		Integer obj4 = 10;
		System.out.println("==결과: " + (obj3 == obj4));
		System.out.println("언박싱한 ==결과: " + (obj3.intValue() == obj4.intValue()));
		System.out.println("equals() 결과: " + obj3.equals(obj4));
		
	}
}
