package é��11_�⺻APIŬ����.��_����ǥ���İ�PatternŬ����.��_PatternŬ����;

import java.util.regex.Pattern;

// ���� ǥ�������� ���ڿ��� �����ϴ� ����� �˾ƺ���. ���ڿ��� ���� ǥ�������� �����ϴ� ����� 
// java.util.regex.Pattern Ŭ������ ���� �޼ҵ��� matches() �޼ҵ尡 �����Ѵ�.
// ù ��° �Ű����� ���� ǥ�����̰�, �� ��° �Ű����� ������ ���ڿ��̴�. ���� �� ����� boolean Ÿ������ ���ϵȴ�. ���� ������ ��ȭ��ȣ�� �̸����� �����ϴ� �ڵ��̴�

public class Pattern��� {
	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}"; // �������� \�� Ư���� �뵵�� ����Ѵٴ� �ǹ̷� \\�� �� ���� ����Ѵ�.
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("���Խİ� ��ġ�մϴ�.");
		} else {
			System.out.println("���Խİ� ��ġ���� �ʽ��ϴ�.");
		}
		
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "angel@naver.com";
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("���Խİ� ��ġ�մϴ�.");
		} else {
			System.out.println("���Խİ� ��ġ���� �ʽ��ϴ�.");
		}
	}
}
