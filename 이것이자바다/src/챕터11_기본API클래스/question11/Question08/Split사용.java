package é��11_�⺻APIŬ����.question11.Question08;

import java.util.StringTokenizer;

public class Split��� {
	public static void main(String[] args) {
		String str = "���̵�,�̸�,�н�����";
		
		// ���1 (split() �޼ҵ� �̿�)
		String[] strSplit = str.split(",");
		
		for(String Split : strSplit) {
			System.out.println(Split);
		}
		
		System.out.println();
		
		// ���2 (StringTokenizer �̿�)
		StringTokenizer st = new StringTokenizer(str, ",");
		int countTokens = st.countTokens();
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
