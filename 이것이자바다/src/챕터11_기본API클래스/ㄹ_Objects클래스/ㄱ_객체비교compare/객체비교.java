package é��11_�⺻APIŬ����.��_ObjectsŬ����.��_��ü��compare;

import java.util.Comparator;

public class ��ü�� {
	// Objects.compare(T a, T b, Comparator<T>c) �޼ҵ�� �� ��ü�� ����(Comparator)�� ���ؼ� int ���� �����Ѵ�.
	// java.util.Comparator<T>�� ���׸� �������̽� Ÿ������ �� ��ü�� ���ϴ� compare(T a, T b) �޼ҵ尡 ���ǵǾ� �ִ�.
	// ���׸��� 13�忡�� �н��ϴµ�, ���⼭�� T�� ���� ��ü Ÿ���̶�� �͸� �˾Ƶθ� �ȴ�.
	// compare() �޼ҵ��� ���� Ÿ���� int�ε�, a�� b���� ������ ����, ������ 0, ũ�� ����� �����ϵ��� ���� Ŭ������ ������ �Ѵ�.
	
	//	public interface Comparator<T> {
	//		int compare(T a, T b);
	//	}

	// ������ �л� ��ü���� �л� ��ȣ�� ���ϴ� StudentComparator ���� Ŭ������ �ۼ��� ���̴�.
	// a�� sno�� ������ -1, ������ 0, ũ�� 1�� �����ϵ��� �ߴ�.
	
	/*
	public class StudentComparator implements Comparator<Student> {
		@Override
		public int compare(Student a, Student b) {
			if(a.sno < b.sno) { // �����ϰ� ���� �ڵ�� ��ü �� �� �ִ�. return Integer.compare(a.sno, b.sno);
				return -1;
			} else if(a.sno == b.sno) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	*/
}
