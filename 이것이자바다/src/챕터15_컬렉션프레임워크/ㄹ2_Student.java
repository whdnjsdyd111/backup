package é��15_�÷��������ӿ�ũ;

public class ��2_Student {
	private int sno;
	public String name;
	
	public ��2_Student(int sno, String name) {
		this.sno = sno;
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ��2_Student) {
			��2_Student student = (��2_Student) obj;
			return (sno == student.sno) && (name.equals(student.name));
		} else {
			return false;
		}
	}
	
	public int hashCode() {
		return sno + name.hashCode();
	}
}
