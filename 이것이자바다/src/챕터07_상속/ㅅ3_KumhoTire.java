package 챕터07_상속;

public class ㅅ3_KumhoTire extends ㅅ3_Tire {
	// 필드
	
	// 생성자
	public ㅅ3_KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	// 메소드
	@Override
	public boolean roll() {
		++accumulatedRotation;	// 누적 회전수 1증가
		
		if(accumulatedRotation < maxRotation) {
			
			System.out.println(location + " KumhoTire 수명: " + 
					(maxRotation - accumulatedRotation) + "회");
			
			return true;
			
		} else {
			System.out.println("*** " + location + " KumhoTire 펑크 ***");
			return false;
		}
	}		// 출력 내용을 달리하기 위한 재정의 메소드
}
