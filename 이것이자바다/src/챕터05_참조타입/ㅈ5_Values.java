package 챕터05_참조타입;

public class ㅈ5_Values {
	public static void main(String[] args) {
		
		// values() 메소드는 열거 타입의 모든 열거 객체들을 배열로 만들어 리턴한다.
		// 다음은 Week 열거 타입의 모든 열거 객체를 배열로 만들어 향상된 for문을 이용해서 반복하는 코드다.
		
		ㅇ_Week[] days = ㅇ_Week.values();
		
		for(ㅇ_Week day : days) {
			System.out.println(day);
		}
		
		// Week 배열은 위와 같이 생성된다. 배열의 인덱스는 열거 객체의 순번과 같고 각 인덱스 값은 해당 순번의 열거 객체 번지이다.
	}
}
