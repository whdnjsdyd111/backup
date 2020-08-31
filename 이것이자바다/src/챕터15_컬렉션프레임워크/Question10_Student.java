package 챕터15_컬렉션프레임워크;

public class Question10_Student implements Comparable<Question10_Student>{
	public String id;
	public int score;
	
	public Question10_Student(String id, int score) {
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(Question10_Student o) {
		if(o.score < score) return 1;
		else if(o.score == score) return 0;
		else return -1;
	}
}
