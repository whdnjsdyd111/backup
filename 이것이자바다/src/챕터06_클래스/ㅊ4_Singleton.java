package é��06_Ŭ����;

public class ��4_Singleton {
	private static ��4_Singleton singleton = new ��4_Singleton();
	
	private ��4_Singleton() {}
	
	static ��4_Singleton getInstance() {
		return singleton;
	}
}
