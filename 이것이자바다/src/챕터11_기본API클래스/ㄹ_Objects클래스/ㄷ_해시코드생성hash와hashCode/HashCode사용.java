package 챕터11_기본API클래스.ㄹ_Objects클래스.ㄷ_해시코드생성hash와hashCode;

// 다음 예제는 Student 객체의 해시코드를 생성하기 위해 Student의 필드인 sno(학생 번호)와 name(학생 이름)을 매개값으로 해서
// Objects.hash() 메소드를 호출했다. 학생 번호와 이름이 동일하다면 같은 해시코드를 얻을 수 있다는 것을 보여준다.

import java.util.Objects;

public class HashCode사용 {
	public static void main(String[] args) {
		Student s1 = new Student(1, "홍길동");
		Student s2 = new Student(1, "홍길동");
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
