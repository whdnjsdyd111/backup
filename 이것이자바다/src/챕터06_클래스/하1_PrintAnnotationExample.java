package é��06_Ŭ����;

import java.lang.reflect.*;

public class ��1_PrintAnnotationExample {
	public static void main(String[] args) {
		// Service Ŭ�����κ��� �޼ҵ� ������ ����
		Method[] declaredMethods = ��1_Service.class.getDeclaredMethods();	// Service Ŭ������ ����� �޼ҵ�� ���(���÷���)
		
		// Method ��ü�� �ϳ��� ó��
		for(Method method : declaredMethods) {
			
			// PrintAnnotation�� ����Ǿ����� Ȯ��
			if(method.isAnnotationPresent(��1_PrintAnnotation.class)){
				
				// PrintAnnotation ��ü ���
				��1_PrintAnnotation printAnnotation = method.getAnnotation(��1_PrintAnnotation.class);
				
				// �޼ҵ� �̸� ���
				System.out.println("[" + method.getName() + "]");
				
				// ���м� ���
				for(int i = 0; i < printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				
				System.out.println();
				
				try {
					// �޼ҵ� ȣ��
					method.invoke(new ��1_Service());
				} catch (Exception e) {}
					System.out.println();
				
			}
			
		}
	}
}
