package é��05_����Ÿ��;

public class ��4_ValueOf {
	public static void main(String[] args) {
		
		// valueOf() �޼ҵ�� �Ű������� �־����� ���ڿ��� ������ ���ڿ��� ������ ���� ��ü�� �����Ѵ�.
		// �� �޼ҵ�� �ܺηκ��� ���ڿ��� �Է¹޾� ���� ��ü�� ��ȯ�� �� �����ϰ� ����� �� �ִ�.
		// ���� �ڵ忡�� weekDay ������ Week.SATURDAY ���� ��ü�� �����ϰ� �ȴ�.
		
		String today = "SATURDAY";
		��_Week weekDay = ��_Week.valueOf(today);
		System.out.println(weekDay);
		
	}
}
