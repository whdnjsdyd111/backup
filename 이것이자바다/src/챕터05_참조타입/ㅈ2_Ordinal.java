package é��05_����Ÿ��;

public class ��2_Ordinal {
	public static void main(String[] args) {
		
		// ordinal �޼ҵ�� ��ü ���� ��ü �� �� ��° ���� ��ü���� �˷��ش�.
		// ���� ��ü�� ������ ���� Ÿ���� ������ �� �־��� ������ ���ϴµ�, 0�� ���� �����Ѵ�.
		// �Ʒ� �ڵ�� today�� �����ϴ� ���� ��ü�� ��ü ���� ��ü���� �� ��° �������� �˾Ƴ��� �ڵ��̴�.
		
		��_Week today = ��_Week.MONDAY;
		int ordinal = today.ordinal();
		
		System.out.println("������ " + (ordinal + 1) + "��° ���Դϴ�.");
		
	}
}
