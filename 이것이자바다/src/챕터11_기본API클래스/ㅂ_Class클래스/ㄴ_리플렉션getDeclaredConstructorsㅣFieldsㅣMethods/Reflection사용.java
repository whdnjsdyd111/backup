package 챕터11_기본API클래스.ㅂ_Class클래스.ㄴ_리플렉션getDeclaredConstructorsㅣFieldsㅣMethods;

// 다음은 Car 클래스에서 선언된 생성자, 필드, 메소드의 정보를 얻고 출력한다.

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection사용 {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("chap11.기본API클래스.ㅂ_Class클래스.ㄱ_Class객체얻기getClass와forName.Car");
		
		System.out.println("[클래스 이름]");
		System.out.println(clazz.getName());
		System.out.println();
		
		System.out.println("[생성자 정보 ]");
		Constructor[] constructors = clazz.getDeclaredConstructors(); // 해당 클래스의 여러 생성자들을 배열로 리턴한다.
		for(Constructor constructor : constructors) {
			System.out.print(constructor.getName() + "(");
			Class[] parameters = constructor.getParameterTypes(); // getParameters는 매개변수를 Class 타입으로 리턴
			printParameters(parameters);
			System.out.println(")");
		}
		System.out.println();
		
		System.out.println("[필드 정보]");
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field.getType().getSimpleName() + // getType은 타입을 가져오고, setSimpleName은 
					" " + field.getName());						 // 클래스의 패키지 이름은 제외하고 간단하게 이름만 가져옴
		}
		System.out.println();
		
		System.out.println("[메소드 정보 ]");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.print(method.getReturnType().getSimpleName()+" ");
			System.out.print(method.getName() + "(");
			Class[] parameters = method.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
		System.out.println();
		
		// 실행 결과는 Car 클래스가 자체적으로 가지고 있는 전체 멤버들이 모두 출력된다.
	}
	
	private static void printParameters(Class[] parameters) {
		for(int i=0; i<parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if(i<(parameters.length-1)) { // 매개 변수를 구분하기 위해 끝을 제외하고 , 로 구분 해주기
				System.out.print(",");
			}
		}
	}
}
