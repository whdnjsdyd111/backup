package é��05_����Ÿ��;

import java.util.Calendar;

public class ��1_Using_Enum {
	public static void main(String[] args) {
		
		// ���� Ÿ���� �����ϴ� ���
		
		// ����Ÿ�� ����;
		
		��_Week today;
		
		// ���� Ÿ�� ������ �����ߴٸ� ������ ���� ���� ����� ������ �� �ִ�.
		// ���� ����� �ܵ����� ����� ���� ���� �ݵ�� ����Ÿ��.���Ż���� ���ȴ�.
		
		// ����Ÿ�� ���� = ����Ÿ��.���Ż��;
		// ���� tomorrow�� ���� ����� SUNDAY�� ������ �� �ִ�.
		
		��_Week tomorrow = ��_Week.SUNDAY;
		
		// ���� Ÿ�� ������ null ���� ������ �� �ִµ� ���� Ÿ�Ե� ���� Ÿ���̱� �����̴�.
		
		��_Week birthday = null;
		
		// �׷� �޼ҵ忡 ������ ���� ����� ���? �� 7���� ����� Week�� ��ü�� �����ǰ� �޼ҵ� ������ ������ ���� ����� �ش� Week ��ü�� ���� �����ϰ� �ȴ�.
		
		System.out.println(tomorrow == ��_Week.SUNDAY);	// true
		
		// tomorrow�� ���ÿ�����  �����ȴ�. tomorrow�� ����� ���� Week.SUNDAY ���� ����� �����ϴ� �����̹Ƿ� ���� ���� ������ �����ϰ� �ȴ�.
		
		��_Week tomorrow1 = ��_Week.SUNDAY;
		
		System.out.println(tomorrow == tomorrow1); // true
		
	}
}
