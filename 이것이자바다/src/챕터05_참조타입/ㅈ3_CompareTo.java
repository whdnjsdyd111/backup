package é��05_����Ÿ��;

public class ��3_CompareTo {
	public static void main(String[] args) {
		
		// compareTo() �޼ҵ�� �Ű������� �־��� ���� ��ü�� �������� ���ķ� �� ��° ��ġ�ϴ� ���� ���Ѵ�.
		// ���� ���� ��ü�� �Ű����� ���� ��ü���� ������ �����ٸ� ������, ������ �ʴ´ٸ� ����� ���ϵȴ�.
		
		��_Week day1 = ��_Week.MONDAY;
		��_Week day2 = ��_Week.WEDNESDAY;
		
		int result1 = day1.compareTo(day2);	// -2
		int result2 = day2.compareTo(day1);	// 2
		
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
	}
}
