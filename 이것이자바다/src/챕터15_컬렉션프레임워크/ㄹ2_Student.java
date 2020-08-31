package 챕터15_컬렉션프레임워크;

public class ㄹ2_Student {
	private int sno;
	public String name;
	
	public ㄹ2_Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ㄹ2_Student) {
			ㄹ2_Student student = (ㄹ2_Student) obj;
			return (sno == student.sno) && (name.equals(student.name));
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return sno + name.hashCode();
	}
}
