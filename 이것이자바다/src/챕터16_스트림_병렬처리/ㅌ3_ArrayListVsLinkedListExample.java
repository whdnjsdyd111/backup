package é��16_��Ʈ��_����ó��;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ��3_ArrayListVsLinkedListExample {
	// ��� ó��
	public static void work(int value) {}
	
	// ���� ó��
	public static long testParellel(List<Integer> list) {
		long start = System.nanoTime();
		list.stream().parallel().forEach( ��3_ArrayListVsLinkedListExample :: work );
		
		long end = System.nanoTime();
		long runTime = end - start;
		
		return runTime;
	}
	
	public static void main(String[] args) {
		//�ҽ� �÷���
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		
		for (int i = 0; i < 1000000; i++) {
			arrayList.add(i);
			linkedList.add(i);
		}
		
		// ���־�
		long arrayListListParallel = testParellel(arrayList);
		long linkedListParallel= testParellel(linkedList);
		
		// ���� ��Ʈ�� ó�� �ð� ���ϱ�
		arrayListListParallel = testParellel(arrayList);
		linkedListParallel = testParellel(linkedList);
		
		if(arrayListListParallel < linkedListParallel) {
			System.out.println("���� �׽�Ʈ ��� : ArrayList ó���� �� ����");
		} else {
			System.out.println("���� �׽�Ʈ ��� : LinkedList ó���� �� ����");
		}
	}
}
