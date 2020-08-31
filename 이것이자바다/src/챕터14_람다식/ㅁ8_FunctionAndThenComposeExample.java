package é��14_���ٽ�;

import java.util.function.Function;

public class ��8_FunctionAndThenComposeExample {
	public static void main(String[] args) {
		
		Function<��7_Member, ��7_Address> functionA;
		Function<��7_Address, String> functionB;
		Function<��7_Member, String> functionAB;
		String city;
		
		functionA = (m) -> m.getAddress();
		functionB = (a) -> a.getCity();
		
		functionAB = functionA.andThen(functionB);
		
		city = functionAB.apply(
			new ��7_Member("ȫ�浿", "hong", new ��7_Address("�ѱ�", "����"))	
		);
		System.out.println("���� ����: " + city);
		
		functionAB = functionB.compose(functionA);
		
		city = functionAB.apply(
			new ��7_Member("ȫ�浿", "hong", new ��7_Address("�ѱ�", "����"))	
		);
		System.out.println("���� ����: " + city);
		
	}
}
