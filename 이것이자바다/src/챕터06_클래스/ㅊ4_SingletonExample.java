package é��06_Ŭ����;

public class ��4_SingletonExample {
	public static void main(String[] args) {
		/*
		��4_Singleton obj1 = new ��4_Singleton();		// ������ ����
		��4_Singleton obj2 = new ��4_Singleton();		// ������ ����
		 */
		
		��4_Singleton obj1 = ��4_Singleton.getInstance();
		��4_Singleton obj2 = ��4_Singleton.getInstance();
		
		System.out.println(obj1 == obj2);
	}
}
