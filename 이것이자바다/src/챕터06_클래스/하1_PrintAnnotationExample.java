package 챕터06_클래스;

import java.lang.reflect.*;

public class 하1_PrintAnnotationExample {
	public static void main(String[] args) {
		// Service 클래스로부터 메소드 정보를 얻음
		Method[] declaredMethods = 하1_Service.class.getDeclaredMethods();	// Service 클래스에 선언된 메소드들 얻기(리플렉션)
		
		// Method 객체를 하나씩 처리
		for(Method method : declaredMethods) {
			
			// PrintAnnotation이 적용되었는지 확인
			if(method.isAnnotationPresent(하1_PrintAnnotation.class)){
				
				// PrintAnnotation 객체 얻기
				하1_PrintAnnotation printAnnotation = method.getAnnotation(하1_PrintAnnotation.class);
				
				// 메소드 이름 출력
				System.out.println("[" + method.getName() + "]");
				
				// 구분선 출력
				for(int i = 0; i < printAnnotation.number(); i++) {
					System.out.print(printAnnotation.value());
				}
				
				System.out.println();
				
				try {
					// 메소드 호출
					method.invoke(new 하1_Service());
				} catch (Exception e) {}
					System.out.println();
				
			}
			
		}
	}
}
