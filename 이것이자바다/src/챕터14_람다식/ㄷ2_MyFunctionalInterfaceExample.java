package 챕터14_람다식;

public class ㄷ2_MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		
		ㄷ2_MyFunctionalInterface fi;
		
		fi = (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		fi.method(2);
		
		fi = (x) -> {
			System.out.println((x * 5));
		};
		fi.method(2);
		
		fi = x -> System.out.println((x * 5));
		fi.method(2);							// 매개 변수가 하나일 경우에 괄호 ()를 생략할 수 있다.
		
	}
}
