package é��11_�⺻APIŬ����.��_ClassŬ����.��_���÷���getDeclaredConstructors��Fields��Methods;

// ������ Car Ŭ�������� ����� ������, �ʵ�, �޼ҵ��� ������ ��� ����Ѵ�.

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection��� {
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("chap11.�⺻APIŬ����.��_ClassŬ����.��_Class��ü���getClass��forName.Car");
		
		System.out.println("[Ŭ���� �̸�]");
		System.out.println(clazz.getName());
		System.out.println();
		
		System.out.println("[������ ���� ]");
		Constructor[] constructors = clazz.getDeclaredConstructors(); // �ش� Ŭ������ ���� �����ڵ��� �迭�� �����Ѵ�.
		for(Constructor constructor : constructors) {
			System.out.print(constructor.getName() + "(");
			Class[] parameters = constructor.getParameterTypes(); // getParameters�� �Ű������� Class Ÿ������ ����
			printParameters(parameters);
			System.out.println(")");
		}
		System.out.println();
		
		System.out.println("[�ʵ� ����]");
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field.getType().getSimpleName() + // getType�� Ÿ���� ��������, setSimpleName�� 
					" " + field.getName());						 // Ŭ������ ��Ű�� �̸��� �����ϰ� �����ϰ� �̸��� ������
		}
		System.out.println();
		
		System.out.println("[�޼ҵ� ���� ]");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.print(method.getReturnType().getSimpleName()+" ");
			System.out.print(method.getName() + "(");
			Class[] parameters = method.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
		System.out.println();
		
		// ���� ����� Car Ŭ������ ��ü������ ������ �ִ� ��ü ������� ��� ��µȴ�.
	}
	
	private static void printParameters(Class[] parameters) {
		for(int i=0; i<parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if(i<(parameters.length-1)) { // �Ű� ������ �����ϱ� ���� ���� �����ϰ� , �� ���� ���ֱ�
				System.out.print(",");
			}
		}
	}
}
