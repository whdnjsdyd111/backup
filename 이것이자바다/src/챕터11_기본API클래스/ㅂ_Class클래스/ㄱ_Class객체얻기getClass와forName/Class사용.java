package é��11_�⺻APIŬ����.��_ClassŬ����.��_Class��ü���getClass��forName;

// ������ �� ���� ������� Car Ŭ������ Class ��ü�� ���, Class�� �޼ҵ带 �̿��� Ŭ������ ��ü �̸��� ������ �̸� �׸��� ��Ű�� �̸��� ��� ����Ѵ�.

public class Class��� {
	public static void main(String[] args) {
		Car car = new Car();
		Class clazz1 = car.getClass();
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName());
		System.out.println();
		
		try {
			Class clazz2 = Class.forName("chap11.�⺻APIŬ����.��_ClassŬ����.��_Class��ü���getClass��forName.Car");
			System.out.println(clazz2.getName());
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Car{
	String field1;
	String field2;
	
	public Car() { }
	
	public Car(String field1, String field2) {
		this.field1 = field1;
		this.field2 = field2;
	}
	
	public void method1() { }
	public void method2(String name) { }
}