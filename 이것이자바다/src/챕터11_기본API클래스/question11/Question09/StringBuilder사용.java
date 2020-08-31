package 챕터11_기본API클래스.question11.Question09;

public class StringBuilder사용 {
	public static void main(String[] args) {
		String str = "";
		for(int i=1; i<=100; i++) {
			str += i;
		}
		System.out.println(str); // 100개 이상의 String 객체가 생겨 좋은 코드가 아님
		
		// 개선 코드
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=100; i++) {
			sb.append(i);
		}
		System.out.println(sb.toString());
	}
}
