package é��14_���ٽ�;

public class ��2_MyFunctionalInterfaceExample {
	public static void main(String[] args) {
		
		��2_MyFunctionalInterface fi;
		
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
		fi.method(2);							// �Ű� ������ �ϳ��� ��쿡 ��ȣ ()�� ������ �� �ִ�.
		
	}
}
