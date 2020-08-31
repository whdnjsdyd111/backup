package é��10_����ó��;

public class ��_RuntimeException {
	// ���� ���ܴ� �ڹ� �����Ϸ��� üũ�� ���� �ʱ� ������ ������ �������� ���迡 ���ؼ� ���� ó�� �ڵ带 �����ؾ� �Ѵ�.
	// ���� �����ڰ� ���� ���ܿ� ���� ���� ó�� �ڵ带 ���� �ʾ��� ���, �ش� ���ܰ� �߻��ϸ� ���α׷��� ��ٷ� ����ȴ�.
	// �ڹ� ���α׷� ���� ����� ǳ���ϴٸ� ����, � ���� ���ܰ� �߻��ϴ��� ���� �� �� ������, ���� �����ϴ� �����ڶ�� ���ݺ��� �����ϴ� �� ���� ���� ���ܸ� �� �����α� �ٶ���.
	// �ڹ� ���α׷����� ���� �߻��Ǵ� ���� �����̹Ƿ� ���� �߻��ǰ�, � ���� �޼����� ��µǴ��� �� �˾Ƶ� �ʿ䰡 �ִ�.
	
			//	NullPointerException
	
	// �ڹ� ���α׷����� ���� ����ϰ� �߻��ϴ� ���� ���ܴ� java.lang.NullPointerException�� ���̴�.
	// �̰��� ��ü ������ ���� ����, �� null ���� �۴� ���� ������ ��ü ���� �������� ��Ʈ(.)�� ������� �� �߻��Ѵ�.
	// ��ü�� ���� ���¿��� ��ü�� ����Ϸ� ������ ���ܰ� �߻��ϴ� ���̴�.
	
	// ���α׷����� ���ܰ� �߻��ϸ� ���� �޼����� Console �信 ��µǸ鼭 ���α׷��� ����ȴ�. Console �信 ��µǴ� ���뿡�� � ���ܰ� � �ҽ��� �� ��° �ڵ忡�� �߻��ߴ����� ���� ������ ����ִ�.
	// �� ������ ��� NullPointerXceptionExample.java �ҽ��� 4��° �ڵ忡�� �߻������� �� �� �ִ�.
	// Console �信�� ���� ó���� NullPointerExceptionExample.jvava:4�� ����н��� Ŭ���ϸ� �ҽ� ������� ��Ȯ�� NullPointerException.java�� 4��° ���� ���̶��������ش�.
	
			//	ArrayIndexOutOfBoundsException
	
	// �迭���� �ε��� ������ �ʰ��Ͽ� ����� ��� ���� ������ java.lang.ArrayIndexOutOfBoundsException�� �߻��Ѵ�.
	// ���� ��� ���̰� 3�� int[] arr = new int[3] �迭�� �����ߴٸ�, �迭 �׸��� �����ϱ� ���� arr[0] ~ arr[2]�� ����� �� �ִ�.
	// ������ arr[3]�� ����ϸ� �ε��� ������ �ʰ��߱� ������ ArrayIndexOutOfBoundsException�� �߻��Ѵ�.
	
	// ������ �����ϸ� 3���ο��� ArrayIndexOutOfBoundsException�� �߻��Ѵ�. �� ������ �� ���� ���� �Ű����� ���� �ʾұ� ������ args[0], args[1]�� ���� �ε����� ����� �� ����.
	
	// ��� ������Ʈ���� args�� ���� �شٸ� ArrayIndexOutOfBoundsException�� �߻����� �ʴ� ���� ���α׷��� �ȴ�.
	// �迭���� �б� ���� �迭�� ���̸� ���� �����ϴ� ���̴�. ���� �Ű����� �����ϰų� ���� ��� ���ǹ��� �̿��ؼ� ����ڿ��� ���� ����� �˷��ش�.
	
			//	NumberFormatException
	
	// ���α׷��� �����ϴ� ���� ���ڿ��� �Ǿ� �ִ� �����͸� ���ڷ� �����ϴ� ��찡 ���� �߻��Ѵ�. ���ڿ��� ������ ��ȯ�ϴ� ����� ���� ������ ������ ���� ���� ���Ǵ� �ڵ�� ������ ����.
	
	//		��ȯ Ÿ��		�޼ҵ��(�Ű� ����)					����
	//		int			Integer.parseInt(String s)		�־��� ���ڿ��� ������ ��ȯ�ؼ� ����
	//		double		Double.parseDouble(String s)	�־��� ���ڿ��� �Ǽ��� ��ȯ�ؼ� ����
	
	// Integer�� Double�� ���� (Wrapper) Ŭ������� �ϴµ�, 11�忡�� �ڼ��� ����ȴ�. �� Ŭ������ ���� �޼ҵ��� parseXXX() �޼ҵ带 �̿��ϸ� ���ڿ��� ���ڷ� ��ȯ�� �� �ִ�.
	// �� �޼ҵ���� �Ű����� ���ڿ��� ���ڷ� ��ȯ�� �� �ִٸ� ���ڸ� ����������, ���ڷ� ��ȯ�� �� ���� ���ڰ� ���ԵǾ� �ִٸ� java.lang.NumberFormatException�� �߻���Ų��.
	
			//	ClassCastException
	
	// Ÿ�� ��ȯ(Casting)�� ���� Ŭ������ ���� Ŭ���� ���� �߻��ϰ� ���� Ŭ������ �������̽������� �߻��Ѵ�. �̷��� ���谡 �ƴ϶�� Ŭ������ �ٸ� Ŭ������ Ÿ�� ��ȯ�� �� ����.
	// ������ Ÿ�� ��ȯ�� �õ��� ��� ClassCastException�� �߻��Ѵ�. ���� ��� ������ ���� ��� ����� ���� ���谡 �ִٰ� �����غ���.
	
	//			Animal : �߻�Ŭ����					RemoteControl : �������̽�
	//			��������������������������						����������������������������������
	//			��			��						��				��
	//		Dog				Cat						Television		Audio
	
	// ������ �ùٸ� Ÿ�� ��ȯ�� �����ش�. Animal Ÿ�� ������ ���Ե� ��ü�� Dog�̹Ƿ� �ٽ� Dog Ÿ������ ��ȯ�ϴ� ���� �ƹ��� ������ ����.
	// ���������� RemoteControl Ÿ�� ������ ���Ե� ��ü�� Television�̹Ƿ� �ٽ� Television Ÿ������ ��ȯ�ϴ� ���� �ƹ��� ������ ����.
	
	//	Animal animal = new Dog();		|	RemoteControl rc = new Television();
	//	Dog dog = (Dog) animal;			|	Television tv = (Television) rc;
	
	// �׷��� ������ ���� Ÿ�� ��ȯ�� �ϸ� ClassCastException�� �߻��Ѵ�. ���Ե� ��ü�� �ƴ� �ٸ� Ŭ���� Ÿ������ Ÿ�� ��ȯ�߱� �����̴�.
	
	//	Animal animal = new Dog();		|	RemoteControl rc = new Television();
	//	Cat cat = (Cat) animal;			|	Audio audio = (Audio) rc;
	
	// ClassCastException�� �߻���Ű�� �������� Ÿ�� ��ȯ ���� Ÿ�� ��ȯ�� �������� instanceof �����ڷ� Ȯ���ϴ� ���� ����.
	// instanceof ������ ����� true�̸� ���� ��ü�� ���� Ÿ������ ��ȯ�� �����ϴٴ� ���̴�.
	
	//	Animal animal = new Dog();				|	Remocon rc = new Audio();
	//	if(animal instanceof Dog) {				|	if(rc instanceof Television) {
	//		Dog dog = (Dog) animal;				|		Television tv = (Television) rc;
	//	} else if(animal instanceof Cat) {		|	} else if(rc instanceof Audio) {
	//		Cat cat = (Cat) animal;				|		Audio audio = (Audio) rc;
	//	}										|	}
	
	
}
