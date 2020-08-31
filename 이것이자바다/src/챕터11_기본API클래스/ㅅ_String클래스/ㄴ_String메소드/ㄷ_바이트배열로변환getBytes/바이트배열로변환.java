package 챕터11_기본API클래스.ㅅ_String클래스.ㄴ_String메소드.ㄷ_바이트배열로변환getBytes;

public class 바이트배열로변환 {
	// 종종 문자열을 바이트 배열로 변환하는 경우가 있다. 대표적인 예로 네트워크로 문자열을 전송하거나, 문자열을 암호화할 때 문자열을 바이트 배열로 변환한다.
	// 문자열을 바이트 배열로 변환하는 메소드는 다음 두 가지가 있다.
	
	//	byte[] bytes = "문자열".getBytes();
	//	byte[] bytes = "문자열".getBytes(Charset charset);
	
	// getBytes() 메소드는 시스템의 기본 문자셋으로 인코딩된 바이트 배열을 리턴한다.
	// 만약 특정 문자셋으로 인코딩된 바이트 배열을 얻으려면 두 번째 메소드를 사용하면 된다.
	// 다음은 EUC-KR과 UTE-8로 각각 인코딩된 바이트 배열을 리턴한다.
	
	//	try {
	//		byte[] bytes = "문자열".getBytes("EUC-KR");
	//		byte[] bytes = "문자열".getBytes("UTF-8");
	//	} catch(UnsupportedEncodingException e) {
	//	}
	
	// 어떤 문자셋으로 인코딩하느냐에 따라 바이트 배열의 크기가 달라지는데, EUC-KR은 getBytes()와 마찬가지로 알파벳은 1바이트, 한글은 2바이트로 변환하고,
	// UTF-8은 알파벳은 1바이트, 한글은 3바이트로 변환한다.
	// getBytes(Charset charset) 메소드는 잘못된 문자셋으로 매개값으로 줄 경우,
	// java.io.UnsupportedEncodingException 예외가 발생하므로 예외 처리가 필요하다.
	
	// 바이트 배열을 다시 문자열로 변환(디코딩)할 때에는 어떤 문자셋으로 인코딩된 바이트 배열이냐에 따라서 디코딩 방법이 다르다.
	// 단순하게 String(byte[] bytes) 생성자를 이용해서 디코딩하면 시스템의 기본 문자셋을 이용한다.
	// 시스템 기본 문자셋은 다른 문자셋으로 인코딩된 바이트 배열일 경우 다음 String 생성자를 이용해서 디코딩해야 한다.
	
	//	String str = new String(byte[] bytes, String charsetName);
	
}
