package 챕터04_조건문_반복문;

public class ㅁ_StringType_Switch {
	public static void main(String[] args) {
		String position = "과장";

		switch (position) {
		case "부장":
			System.out.println("월급 700만원");
			break;
		case "과장":
			System.out.println("월급 500만원");
			break;
		default:
			System.out.println("월급 300만원");
		}
	}
}
