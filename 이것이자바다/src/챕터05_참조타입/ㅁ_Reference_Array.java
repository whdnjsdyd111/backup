package 챕터05_참조타입;

public class ㅁ_Reference_Array {
	public static void main(String[] args) {

		String[] str = new String[3];

		str[0] = "Java";
		str[1] = "Java";
		str[2] = new String("Java");

		System.out.println(str[0] == str[1]); // 0과 1 인덱스는 서로 같은 참조를 하고 있다.
		System.out.println(str[0] == str[2]); // 그러나 0,1 과 2는 서로 다른 참조를 하고 있다.
		System.out.println(str[0].equals(str[1])); // 하지만 문자열은 같다.

	}
}
