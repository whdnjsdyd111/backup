package é��11_�⺻APIŬ����.��_WrapperŬ����.��_�ڽ�Boxing����ڽ�UnBoxing;

public class BoxingUnBoxing {
	public static void main(String[] args) {
		// Boxing
		Integer obj1 = new Integer(100);
		Integer obj2 = new Integer("200");
		Integer obj3 = Integer.valueOf("300");
		
		// UnBoxing
		int value1 = obj1.intValue();
		int value2 = obj2.intValue();
		int value3 = obj3.intValue();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
	}
}
