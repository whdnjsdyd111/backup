package 챕터11_기본API클래스.ㅌ_Wrapper클래스.ㄷ_문자열을기본타입값으로변환;

public class StringToPrimitiveValue사용 {
	public static void main(String[] args) {
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		System.out.println("value1: " + value1);
		System.out.println("value2: " + value2);
		System.out.println("value3: " + value3);
	}
}
