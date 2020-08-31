package 챕터13_제네릭;

public class ㅁ1_BoundedTypeParameterExample {
	public static void main(String[] args) {
		
		// String str = ㅁ1_Util.compare("a", "b");		( x ) String은 Number 타입이 아님
		
		int result1 = ㅁ1_Util.compare(10, 20);
		System.out.println(result1);
		
		int result2 = ㅁ1_Util.compare(3.5, 3);
		System.out.println(result2);
		
	}
}
