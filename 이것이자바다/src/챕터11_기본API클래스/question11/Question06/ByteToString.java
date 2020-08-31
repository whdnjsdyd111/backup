package 챕터11_기본API클래스.question11.Question06;

public class ByteToString {
	public static void main(String[] args) {
		byte[] bytes = { 73, 32, 108, 111, 118, 101, 32, 121, 111, 117 };
		String str = new String(bytes);
		System.out.println(str);
	}
}
