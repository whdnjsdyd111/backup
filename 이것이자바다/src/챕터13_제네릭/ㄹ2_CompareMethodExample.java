package é��13_���׸�;

public class ��2_CompareMethodExample {
	public static void main(String[] args) {
		��2_Pair<Integer, String> p1 = new ��2_Pair<Integer, String>(1, "���");
		��2_Pair<Integer, String> p2 = new ��2_Pair<Integer, String>(1, "���");
		boolean result1 = ��2_Util.<Integer, String>compare(p1, p2);		// ��ü���� Ÿ���� ��������� ����
		
		if(result1) {
			System.out.println("�������� ������ ��ü");
		} else {
			System.out.println("�������� �������� ���� ��ü");
		}
		
		��2_Pair<String, String> p3 = new ��2_Pair<String, String>("user1", "ȫ�浿");
		��2_Pair<String, String> p4 = new ��2_Pair<String, String>("user2", "ȫ�浿");
		boolean result2 = ��2_Util.compare(p3, p4);						// ��ü���� Ÿ���� ����
		
		if(result2) {
			System.out.println("�������� ������ ��ü");
		} else {
			System.out.println("�������� �������� ���� ��ü");
		}
	}
}
