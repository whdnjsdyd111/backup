package é��13_���׸�;

public class Question02_ContainerExample {
	public static void main(String[] args) {
		Question02_Container<String> container1 = new Question02_Container<String>();
		container1.set("ȫ�浿");
		String str = container1.get();
		System.out.println(str);
		
		Question02_Container<Integer> container2 = new Question02_Container<Integer>();
		container2.set(6);
		int value = container2.get();
		System.out.println(value);
	}
}
