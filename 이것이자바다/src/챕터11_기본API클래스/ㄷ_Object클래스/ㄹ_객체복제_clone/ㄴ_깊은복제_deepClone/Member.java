package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü����_clone.��_��������_deepClone;

import java.util.Arrays;

// ���� ������ ���� Member Ŭ������ int[] �迭�� Car Ÿ���� �ʵ尡 �ִ�.
// �� �ʵ���� ��� ���� Ÿ���̹Ƿ� ���� ���� ����� �ȴ�.
// Member Ŭ������ Object�� clone() �޼ҵ带 �������ؼ� int[] �迭�� Car ��ü�� �����Ѵ�.

public class Member implements Cloneable {
	public String name;
	public int age;
	public int[] scores;
	public Car car;
	
	public Member(String name, int age, int[] scores, Car car) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.car = car;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// ���� ���� ���縦 �ؼ� name, age�� �����Ѵ�.
		Member cloned = (Member) super.clone(); // super.clone() <--- Object�� clone() ȣ��
		
		// scores�� ���� �����Ѵ�.
		cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
		
		// car�� ���� �����Ѵ�.
		cloned.car = new Car(this.car.model);
		
		// ���� ������ Member ��ü�� ����
		return cloned;
	}
	
	public Member getMember() {
		Member cloned = null;
		try {
			cloned = (Member) clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
}
