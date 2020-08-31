package é��05_����Ÿ��;

import java.util.Scanner;

public class Question02_Students_Scores {
	public static void main(String[] args) {
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("----------------------------------------");
			System.out.println("1.�л�����2.�����Է¤�3.��������Ʈ��4.�м���5.����");
			System.out.println("----------------------------------------");
			System.out.print("����> ");
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				
				System.out.print("�л���> ");
				studentNum = sc.nextInt();
				scores = new int[studentNum];
				
			} else if(selectNo == 2) {
				
				if(scores == null) {
					System.out.println("�л����� �Է��ϰ� �����Ͻÿ�.");
					continue;
				}
				
				for (int i = 0; i < scores.length; i++) {
					System.out.print("scores[" + i + "]: ");
					scores[i] = sc.nextInt();
				}
				
			} else if(selectNo == 3) {
				
				if(scores == null) {
					System.out.println("�л����� �Է��ϰ� �����Ͻÿ�.");
					continue;
				}
				
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores[" + i + "]: " + scores[i]);
				}
				
			} else if(selectNo == 4) {
				
				if(scores == null) {
					System.out.println("�л����� �Է��ϰ� �����Ͻÿ�.");
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
				
				System.out.println("�ְ� ����: " + max);
				System.out.println("��� ����: " + avg);
				
			} else if(selectNo == 5) {
				System.out.println("���α׷� ����");
				run = false;
			} else {
				System.out.println("�߸� �Է� �ϼ̽��ϴ�. �ٽ� �Է��Ͻÿ�.");
			}
		}
	}
}
