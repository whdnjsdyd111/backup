package é��11_�⺻APIŬ����.question11.Question10;

import java.util.regex.Pattern;

public class PatternMatcher {
	public static void main(String[] args) {
		String id = "5Angel104";	
		String regExp = "[a-zA-Z][a-zA-Z0-9]{7,11}";
		boolean isMatch = Pattern.matches(regExp, id);
		
		if(isMatch) {
			System.out.println("ID�� ����� �� �ֽ��ϴ�.");
		} else {
			System.out.println("ID�� ����� �� �����ϴ�.");
		}
	}
}
