package 챕터11_기본API클래스.ㄷ_Object클래스.ㄷ_객체문자정보_toString;

public class SmartPhone사용 {
	public static void main(String[] args) {
		SmartPhone smartPhone = new SmartPhone("구글", "안드로이드");
		
		String strObj = smartPhone.toString();
		System.out.println(strObj);
		System.out.println(smartPhone); // smartPhone.toString()을 자동 호출해서 리턴값을 얻은 후 출력
		
		// 지금까지 콘솔에 출력하기 위해 System.out.println() 메소드를 사용해왔다.
		// 이 메소드의 매개값은 콘솔에 출력할 내용인데, 매개값이 기본 타입(byte, short, int, long, float, double, boolean)일 경우,
		// 해당 값을 그대로 출력한다. 만약 매개값으로 객체를 주면 객체의 toString() 메소드를 호출해서 리턴값을 받아 출력하도록 되어 있다.
	}
}
