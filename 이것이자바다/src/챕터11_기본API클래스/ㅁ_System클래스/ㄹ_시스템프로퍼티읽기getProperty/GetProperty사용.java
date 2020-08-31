package 챕터11_기본API클래스.ㅁ_System클래스.ㄹ_시스템프로퍼티읽기getProperty;

import java.util.Properties;
import java.util.Set;

public class GetProperty사용 {
	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		
		System.out.println("운영체제 이름: " + osName); // 개별 속성 읽기
		System.out.println("사용자 이름: " + userName);
		System.out.println("사용자 홈디렉토리: " + userHome);
		
		System.out.println("────────────────────");
		System.out.println("[ key ] value");
		System.out.println("────────────────────");
		
		Properties props = System.getProperties(); // 모든 속성의 키와 값 출력
		Set keys = props.keySet();
		for(Object objKey : keys) {
			String key = (String) objKey;
			String value = System.getProperty(key);
			System.out.println("[" + key + "]" + value);
		}
		
		// System.getProperties() 메소드는 모든(키, 값) 쌍을 저장하고 있는 Properties 객체를 리턴한다.
		// 이 객체의 KeySet() 메소드를 호출하면 키만으로 구성된 Set 객체를 얻을 수 있다.
		// for문은 Set 객체로 부터 키를 하나씩 얻어내어 문자열로 변환한 다음, System.getProperty() 메소드 값을 얻어 키와 값을 모두 출력한다.
	}
}
