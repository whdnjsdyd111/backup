package é��15_�÷��������ӿ�ũ;

import java.util.Comparator;

public class ��4_DescendingComparator implements Comparator<��4_Fruit>{
	@Override
	public int compare(��4_Fruit o1, ��4_Fruit o2) {
		if(o1.price < o2.price) return 1;	// ������ ���� ��� �ڿ� ���� ��
		else if(o1.price == o2.price) return 0;
		else return -1;						// ������ Ŭ ��� �տ� ���� ��
	}
}
