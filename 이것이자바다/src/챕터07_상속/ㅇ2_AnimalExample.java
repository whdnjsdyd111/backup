package é��07_���;

public class ��2_AnimalExample {
	public static void main(String[] args) {
		
		// ��ü ����
		
		��2_Dog dog = new ��2_Dog();
		��2_Cat cat = new ��2_Cat();
		dog.sound();
		cat.sound();
		
		System.out.println("---------------");
		
		// ������ �ڵ� Ÿ�� ��ȯ
		
		��2_Animal animal = null;
		
		animal = new ��2_Dog();
		animal.sound();
		animal = new ��2_Cat();
		animal.sound();
		
		System.out.println("---------------");
		
		// �޼ҵ��� ������
		animalSound(new ��2_Dog());		// �ڵ� Ÿ�� ��ȯ
		animalSound(new ��2_Cat());		// �ڵ� Ÿ�� ��ȯ
	}									//	��
	
	public static void animalSound(��2_Animal animal) {
		animal.sound();		// �����ǵ� �޼ҵ� ȣ��
	}
}
