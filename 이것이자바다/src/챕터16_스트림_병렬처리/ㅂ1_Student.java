package é��16_��Ʈ��_����ó��;

public class ��1_Student implements Comparable<��1_Student> {
	private String name;
	private int score;
	
	public ��1_Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() { return name; }
	public int getScore() { return score; }
	
	@Override
	public int compareTo(��1_Student o) {			// score < o.score	: ���� ����
		return Integer.compare(score, o.score);		// score == o.score	: 0 ����
	}												// score > o.score 	: ��� ����
}
