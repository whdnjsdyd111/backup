package 챕터11_기본API클래스.ㄹ_Objects클래스.ㄱ_객체비교compare;

import java.util.Comparator;

public class 객체비교 {
	// Objects.compare(T a, T b, Comparator<T>c) 메소드는 두 객체를 비교자(Comparator)로 비교해서 int 값을 리턴한다.
	// java.util.Comparator<T>는 제네릭 인터페이스 타입으로 두 객체를 비교하는 compare(T a, T b) 메소드가 정의되어 있다.
	// 제네릭은 13장에서 학습하는데, 여기서는 T가 비교할 객체 타입이라는 것만 알아두면 된다.
	// compare() 메소드의 리턴 타입은 int인데, a가 b보다 작으면 음수, 같으면 0, 크면 양수를 리턴하도록 구현 클래스를 만들어야 한다.
	
	//	public interface Comparator<T> {
	//		int compare(T a, T b);
	//	}

	// 다음은 학생 객체에서 학생 번호로 비교하는 StudentComparator 구현 클래스를 작성한 것이다.
	// a의 sno가 작으면 -1, 같으면 0, 크면 1을 리턴하도록 했다.
	
	/*
	public class StudentComparator implements Comparator<Student> {
		@Override
		public int compare(Student a, Student b) {
			if(a.sno < b.sno) { // 간단하게 다음 코드로 대체 할 수 있다. return Integer.compare(a.sno, b.sno);
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
