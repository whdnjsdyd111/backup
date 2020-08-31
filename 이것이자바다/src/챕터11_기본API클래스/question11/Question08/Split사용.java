package 챕터11_기본API클래스.question11.Question08;

import java.util.StringTokenizer;

public class Split사용 {
	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		
		// 방법1 (split() 메소드 이용)
		String[] strSplit = str.split(",");
		
		for(String Split : strSplit) {
			System.out.println(Split);
		}
		
		System.out.println();
		
		// 방법2 (StringTokenizer 이용)
		StringTokenizer st = new StringTokenizer(str, ",");
		int countTokens = st.countTokens();
		for(int i=0; i<countTokens; i++) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
