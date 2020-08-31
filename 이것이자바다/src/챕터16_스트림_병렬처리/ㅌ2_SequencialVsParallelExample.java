package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;

public class ��2_SequencialVsParallelExample {
	
	// ��� ó��
	public static void work(int value) {
		try {
			Thread.sleep( 100 ); // ���� �������� ó���� ����
		} catch(InterruptedException e) {
			
		}
	}
	
	// ���� ó��
	public static long testSequencial(List<Integer> list) {
		long start = System.nanoTime();
		list.stream().forEach( ��2_SequencialVsParallelExample :: work);
		
		long end = System.nanoTime();
		long runTime = end - start;
		
		return runTime;
	}
	
	public static long testParellel(List<Integer> list) {
		long start = System.nanoTime();
		list.stream().parallel().forEach( ��2_SequencialVsParallelExample :: work);
		
		long end = System.nanoTime();
		long runTime = end - start;
		
		return runTime;
	}
	
	public static void main(String[] args) {
		
		// �ҽ� �÷���
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		// ���� ��Ʈ�� ó�� �ð� ���ϱ�
		long timeSequencial = testSequencial(list);
		
		// ���� ��Ʈ�� ó�� �ð� ���ϱ�
		long timeParallel = testParellel(list);
		
		if(timeSequencial < timeParallel) {
			System.out.println("���� �׽�Ʈ ���: ���� ó���� �� ����");
		} else {
			System.out.println("���� �׽�Ʈ ���: ���� ó���� �� ����");
		}
	}
}
