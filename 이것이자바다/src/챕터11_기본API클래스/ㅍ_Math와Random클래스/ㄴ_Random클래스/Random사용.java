package é��11_�⺻APIŬ����.��_Math��RandomŬ����.��_RandomŬ����;

import java.util.Arrays;
import java.util.Random;

public class Random��� {
	public static void main(String[] args) {
		// ���� ��ȣ
		int[] selectNumber = new int[6]; // ���� ��ȣ 6���� ����� �迭 ����
		Random random = new Random(3);	 // ���� ��ȣ�� ��� ���� Random ��ü ����
		
		System.out.println("���� ��ȣ: ");
		for(int i=0; i<6; i++) {
			selectNumber[i] = random.nextInt(45) + 1; // ���� ��ȣ�� ��� �迭�� ����
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		
		// ��÷ ��ȣ
		int[] winningNumber = new int[6]; // ��÷ ��ȣ 6���� ����� �迭 ����
		random = new Random(5);			  // ��÷ ��ȣ�� ��� ���� Random ��ü ����
		
		System.out.print("��÷ ��ȣ: ");
		for(int i=0; i<6; i++) {
			winningNumber[i] = random.nextInt(45) + 1; // ��÷ ��ȣ�� ��� �迭�� ����
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();
		
		// ��÷ ����
		Arrays.sort(selectNumber);	// ��
		Arrays.sort(winningNumber);	// �� �� ���� ���� ���ѳ���
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("��÷ ����: ");
		if(result) {
			System.out.println("1� ��÷�Ǽ̽��ϴ�.");
		} else {
			System.out.println("��÷���� �ʾҽ��ϴ�.");
		}
		
		// ���ڰ��� ���� �ٸ��� �־� �ٸ� �� �ۿ� ����. ���ڰ��� ������ ��÷�Ǵ� ���� �� �� �ִ�.
	}
}
