package é��05_����Ÿ��;

public class ��5_Values {
	public static void main(String[] args) {
		
		// values() �޼ҵ�� ���� Ÿ���� ��� ���� ��ü���� �迭�� ����� �����Ѵ�.
		// ������ Week ���� Ÿ���� ��� ���� ��ü�� �迭�� ����� ���� for���� �̿��ؼ� �ݺ��ϴ� �ڵ��.
		
		��_Week[] days = ��_Week.values();
		
		for(��_Week day : days) {
			System.out.println(day);
		}
		
		// Week �迭�� ���� ���� �����ȴ�. �迭�� �ε����� ���� ��ü�� ������ ���� �� �ε��� ���� �ش� ������ ���� ��ü �����̴�.
	}
}
