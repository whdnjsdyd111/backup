package 챕터05_참조타입;

public class ㅅ_Improved_For {
	public static void main(String[] args) {
		
		// 향상된 for 문은 카운터 변수와 증감식을 사용하지 않는다. 배열 및 컬렉션 항목의 개수만큼 반복하고 자동으로 빠져나간다.
		// 다음은 for문의 형식이다.
		
		//	for( 타입 변수 : 배열 ) {
		//		실행문
		//	}
		
		// 배열에 있는 값들을 차례로 타입변수에 집어 넣고 실행을 반복한다.
		
		int[] scores = { 95, 60, 88, 78, 93 };
		int sum = 0;
		
		for(int score : scores) {
			sum += score;
		}
		
		System.out.println("점수 총합: " + sum);
		
		double avg = (double) sum / scores.length;
		
		System.out.println("점수 평균: " + avg);
		
		
	}
}
