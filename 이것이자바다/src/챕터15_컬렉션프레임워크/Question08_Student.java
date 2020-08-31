package 챕터15_컬렉션프레임워크;

public class Question08_Student {
	public int studentNum;
	public String name;
	
	public Question08_Student(int studentNum, String name) {
		this.studentNum = studentNum;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return studentNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Question08_Student) {
			Question08_Student student = (Question08_Student) obj;
			if(student.studentNum == studentNum)
				return true;
			else
				return false;
		} else
			return false;
	}
}
