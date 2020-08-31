package 챕터11_기본API클래스.ㅂ_Class클래스.ㄷ_동적객체생성newInstance;

// 8항과 9항을 번갈아 가며 주석을 달아보자.

public class NewInstance사용 {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("chap11.기본API클래스.ㅂ_Class클래스.ㄷ_동적객체생성newInstance.SendAction");
			//Class clazz = Class.forName("chap11.기본API클래스.ㅂ_Class클래스.ㄷ_동적객체생성newInstance.ReceiveAction");
			Action action = (Action) clazz.newInstance();
			action.execute();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
