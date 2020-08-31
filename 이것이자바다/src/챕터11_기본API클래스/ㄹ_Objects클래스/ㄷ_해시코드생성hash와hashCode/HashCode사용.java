package é��11_�⺻APIŬ����.��_ObjectsŬ����.��_�ؽ��ڵ����hash��hashCode;

// ���� ������ Student ��ü�� �ؽ��ڵ带 �����ϱ� ���� Student�� �ʵ��� sno(�л� ��ȣ)�� name(�л� �̸�)�� �Ű������� �ؼ�
// Objects.hash() �޼ҵ带 ȣ���ߴ�. �л� ��ȣ�� �̸��� �����ϴٸ� ���� �ؽ��ڵ带 ���� �� �ִٴ� ���� �����ش�.

import java.util.Objects;

public class HashCode��� {
	public static void main(String[] args) {
		Student s1 = new Student(1, "ȫ�浿");
		Student s2 = new Student(1, "ȫ�浿");
		System.out.println(s1.hashCode());
		System.out.println( Objects.hashCode(s2) );
	}
	
	static class Student{
		int sno;
		String name;
		Student(int sno, String name){
			this.sno = sno;
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(sno, name);
		}
	}
}
