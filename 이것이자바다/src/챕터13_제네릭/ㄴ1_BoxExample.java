package é��13_���׸�;

public class ��1_BoxExample {
	public static void main(String[] args) {
		��1_Box box = new ��1_Box();
		box.set("ȫ�浿");					// String -> Object ( �ڵ� Ÿ�� ��ȯ )
		String name = (String) box.get();	// Object -> String	( ���� Ÿ�� ��ȯ )
		
		box.set(new ��1_Apple());				// Apple -> Object ( �ڵ� Ÿ�� ��ȯ )
		��1_Apple apple = (��1_Apple) box.get();	// Object -> Apple ( ���� Ÿ�� ��ȯ )
	}
}
