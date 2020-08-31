package 챕터16_스트림_병렬처리;

public class ㅂ1_Student implements Comparable<ㅂ1_Student> {
	private String name;
	private int score;
	
	public ㅂ1_Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() { return name; }
	public int getScore() { return score; }
	
	@Override
	public int compareTo(ㅂ1_Student o) {			// score < o.score	: 음수 리턴
		return Integer.compare(score, o.score);		// score == o.score	: 0 리턴
	}												// score > o.score 	: 양수 리턴
}
