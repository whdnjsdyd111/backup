package é��11_�⺻APIŬ����.��_Date��CalendarŬ����.��_CalendarŬ����;

import java.util.TimeZone;

public class PrintTimeZone {
	// �ٸ� �ð��뿡 �ش��ϴ� ��¥�� �ð��� ����ϱ� ���ؼ��� ��� �ؾ��ұ�?
	// ���� ��� �̱�/�ν����������� ���� ��¥�� �ð��� ����ϱ� ���ؼ��� ��� �ؾ� �ұ�?
	// �ü���� �ð��븦 �ٸ� �ð���� �ٲٴ� �͵� �� ���� ����� �� ������, 
	// Calendar Ŭ������ �����ε��� �ٸ� getInstance() �޼ҵ带 �̿��ϸ� �����ϰ� �ٸ� �ð����� Calendar�� ���� �� �ִ�.
	// �˰���� �ð����� java.util.TimeZone ��ü�� ��� Calendar.getInstance() �޼ҵ��� �Ű������� �Ѱ��ָ� �ȴ�.
	
	//	TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
	//	Calendar now = Calendar.getInstance( timeZone );
	
	// TimeZone.getInstance() �޼ҵ��� �Ű����� TimeZone Ŭ������ ���� �޼ҵ���
	// getAvailableIDs()�� ȣ���Ͽ� ���� �ð��� ���ڿ� �� �ϳ��� ����ϸ� �ȴ�.
	// getAvailableIDs() �޼ҵ��� ���� Ÿ���� String �迭�̱� ������ ���� ���α׷��� �̿��ؼ� �ð��� ���ڿ� ����� �� �� �ִ�.
	
	public static void main(String[] args) {
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id : availableIDs) {
			System.out.println(id);
		}
	}
}
