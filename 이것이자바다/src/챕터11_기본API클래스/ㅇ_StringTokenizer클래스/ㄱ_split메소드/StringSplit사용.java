package 챕터11_기본API클래스.ㅇ_StringTokenizer클래스.ㄱ_split메소드;

// String 클래스의 split() 메소드는 다음과 같이 호출되는데, 정규 표현식을 구분자로 해서 문자열을 분리한 후, 배열에 저장하고 리턴한다.

//	String[] result = "문자열".split("정규표현식");

// 예를 들어 다음과 같이 문자열이 있다고 가정해보자. &, 쉼표(,), -를 제외하고 
// 사람 이름인 "홍길동", "이수홍", "박연수", "김자바", "최명호"만 따로 뽑아내고 싶을 경우,

//	홍길동&이수홍,박연수,김자바-최명호

// &, 쉼표(,), -를 파이프(|) 기호로 연결한 정규 표현식을 매개값으로 제공하면 split() 메소드는 이 기호들을 구분자로 해서 부분 문자열을 추출한다.

//	String[] names = text.split("&|,|-");

public class StringSplit사용 {
	public static void main(String[] args) {
		String text = "홍길동&이수홍,박연수,김자바-최명호";
		
		String[] names = text.split("&|,|-");
		
		for(String name : names) {
			System.out.println(name);
		}
	}
}
