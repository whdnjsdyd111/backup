package 챕터11_기본API클래스.ㅂ_Class클래스.ㄱ_Class객체얻기getClass와forName;

// 다음은 두 가지 방법으로 Car 클래스의 Class 객체를 얻고, Class의 메소드를 이용해 클래스의 전체 이름과 간단한 이름 그리고 패키지 이름을 얻어 출력한다.

public class Class사용 {
	public static void main(String[] args) {
		Car car = new Car();
		Class clazz1 = car.getClass();
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName());
		System.out.println();
		
		try {
			Class clazz2 = Class.forName("chap11.기본API클래스.ㅂ_Class클래스.ㄱ_Class객체얻기getClass와forName.Car");
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