package 챕터05_참조타입;

import java.util.Scanner;

public class Question02_Students_Scores {
	public static void main(String[] args) {
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("----------------------------------------");
			System.out.println("1.학생수ㅣ2.점수입력ㅣ3.점수리스트ㅣ4.분석ㅣ5.종료");
			System.out.println("----------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				
				System.out.print("학생수> ");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
				
			} else if(selectNo == 2) {
				
				if(scores == null) {
					System.out.println("학생수를 입력하고 선택하시오.");
					continue;
				}
				
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "]: ");
					scores[i] = sc.nextInt();
				}
				
			} else if(selectNo == 3) {
				
				if(scores == null) {
					System.out.println("학생수를 입력하고 선택하시오.");
					continue;
				}
				
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]: " + scores[i]);
				}
				
			} else if(selectNo == 4) {
				
				if(scores == null) {
					System.out.println("학생수를 입력하고 선택하시오.");
					continue;
				}
				
				int max = 0;
				int sum = 0;
				double avg = 0.0;
				
				for(int score : scores) {
					if(score >= max) {
						max = score;
					}
					sum += score;
				}
				
				avg = (double) sum / scores.length;
				
				System.out.println("최고 점수: " + max);
				System.out.println("평균 점수: " + avg);
				
			} else if(selectNo == 5) {
				System.out.println("프로그램 종료");
				run = false;
			} else {
				System.out.println("잘못 입력 하셨습니다. 다시 입력하시오.");
			}
		}
	}
}
