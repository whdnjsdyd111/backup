package 챕터11_기본API클래스.ㅍ_Math와Random클래스.ㄴ_Random클래스;

import java.util.Arrays;
import java.util.Random;

public class Random사용 {
	public static void main(String[] args) {
		// 선택 번호
		int[] selectNumber = new int[6]; // 선택 번호 6개가 저장될 배열 생성
		Random random = new Random(3);	 // 선택 번호를 얻기 위한 Random 객체 생성
		
		System.out.println("선택 번호: ");
		for(int i=0; i<6; i++) {
			selectNumber[i] = random.nextInt(45) + 1; // 선택 번호를 얻어 배열에 저장
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		// 당첨 번호
		int[] winningNumber = new int[6]; // 당첨 번호 6개가 저장될 배열 생성
		random = new Random(5);			  // 당첨 번호를 얻기 위한 Random 객체 생성
		
		System.out.print("당첨 번호: ");
		for(int i=0; i<6; i++) {
			winningNumber[i] = random.nextInt(45) + 1; // 당첨 번호를 얻어 배열에 저장
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
		// 당첨 여부
		Arrays.sort(selectNumber);	// ┐
		Arrays.sort(winningNumber);	// ┘ 비교 전에 정렬 시켜놓기
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨 여부: ");
		if(result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
		
		// 종자값을 서로 다르게 주어 다를 수 밖에 없다. 종자값이 같으면 당첨되는 것을 볼 수 있다.
	}
}
