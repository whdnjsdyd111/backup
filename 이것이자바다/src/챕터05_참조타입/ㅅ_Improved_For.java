package é��05_����Ÿ��;

public class ��_Improved_For {
	public static void main(String[] args) {
		
		// ���� for ���� ī���� ������ �������� ������� �ʴ´�. �迭 �� �÷��� �׸��� ������ŭ �ݺ��ϰ� �ڵ����� ����������.
		// ������ for���� �����̴�.
		
		//	for( Ÿ�� ���� : �迭 ) {
		//		���๮
		//	}
		
		// �迭�� �ִ� ������ ���ʷ� Ÿ�Ժ����� ���� �ְ� ������ �ݺ��Ѵ�.
		
		int[] scores = { 95, 60, 88, 78, 93 };
		int sum = 0;
		
		for(int score : scores) {
			sum += score;
		}
		
		System.out.println("���� ����: " + sum);
		
		double avg = (double) sum / scores.length;
		
		System.out.println("���� ���: " + avg);
		
		
	}
}
