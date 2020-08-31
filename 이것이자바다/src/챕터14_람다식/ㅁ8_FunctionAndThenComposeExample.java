package 챕터14_람다식;

import java.util.function.Function;

public class ㅁ8_FunctionAndThenComposeExample {
	public static void main(String[] args) {
		
		Function<ㅁ7_Member, ㅁ7_Address> functionA;
		Function<ㅁ7_Address, String> functionB;
		Function<ㅁ7_Member, String> functionAB;
		String city;
		
		functionA = (m) -> m.getAddress();
		functionB = (a) -> a.getCity();
		
		functionAB = functionA.andThen(functionB);
		
		city = functionAB.apply(
			new ㅁ7_Member("홍길동", "hong", new ㅁ7_Address("한국", "서울"))	
		);
		System.out.println("거주 도시: " + city);
		
		functionAB = functionB.compose(functionA);
		
		city = functionAB.apply(
			new ㅁ7_Member("홍길동", "hong", new ㅁ7_Address("한국", "서울"))	
		);
		System.out.println("거주 도시: " + city);
		
	}
}
