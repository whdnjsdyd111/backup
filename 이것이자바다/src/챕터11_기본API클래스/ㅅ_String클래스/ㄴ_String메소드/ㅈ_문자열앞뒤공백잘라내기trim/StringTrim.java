package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㅈ_문자열앞뒤공백잘라내기trim;

public class StringTrim {
	public static void main(String[] args) {
		String tel1 = "   02";
		String tel2 = "123   ";
		String tel3 = "   1234   ";
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);
	}
}
