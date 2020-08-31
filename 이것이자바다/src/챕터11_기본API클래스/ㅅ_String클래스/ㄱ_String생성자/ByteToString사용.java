package 챕터11_기본API클래스.ㅅ_String클래스.ㄱ_String생성자;

// 다음은 바이트 배열을 문자열로 변환하는 예제이다.

public class ByteToString사용 {
	public static void main(String[] args) {
		byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		//				         배열의 74 위치 ──┐  ┌───── 4개
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);
	}
}
