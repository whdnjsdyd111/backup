package 챕터11_기본API클래스.ㅅ_String클래스.ㄱ_String생성자;

// 다음 예제는 키보드로부터 읽은 바이트 배열을 문자열로 변환하는 방법을 보여준다.
// System.in.read() 메소드는 키보드에서 입력한 내용을 매개값으로 주어진 바이트 배열에 저장하고 읽은 바이트 수를 리턴한다.
// 예를 들어 Hello를 입력하고 Enter키를 눌렀다면 Hello + 캐리지리턴(\r) + 라인피드(\n)의 코드값이 바이트 배열에 저장되고
// 총 7개의 바이트를 읽었기 때문에 7을 리턴한다.

//	입력 내용:		H	e	l	l	o	\r	\n	
//	바이트 배열 내용:	72	101	108	108	111	13	10
//				└─────────────────┘ └────┘
//					 실제 입력된 내용		Enter키

// 영어는 알파벳 한 자가 1바이트로 표현되지만, 한글과 기타 다른 나라 언어는 2바이트로 표현되기 때문에 입력된 문자 수와 읽은 바이트 수가 다를 수 있다.
// 바이트 배열을 문자열로 변환하기 위해 다음 예제는 String(byte[] bytes, int offset, int length)를 사용하였는데,
// length 매개값으로 배열 길이에서 2를 빼주는 이유는 캐리지턴(\r) + 라인피드(\n) 부분은 문자열로 만들 필요가 없기 때문이다.

import java.io.IOException;

public class KeyboardToString {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100]; // 읽은 바이트를 저장하기 위한 배열 생성
		
		System.out.print("입력: ");
		int readByteNo = System.in.read(bytes); // 배열에 읽은 바이트를 저장하고 읽은 바이트수를 리턴
		
		String str = new String(bytes, 0, readByteNo-2);
		System.out.println(str);
	}
}
