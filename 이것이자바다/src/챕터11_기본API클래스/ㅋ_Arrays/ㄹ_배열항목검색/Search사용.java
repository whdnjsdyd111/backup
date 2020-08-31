package é��11_�⺻APIŬ����.��_Arrays.��_�迭�׸�˻�;

import java.util.Arrays;

import é��11_�⺻APIŬ����.��_Arrays.��_�迭�׸�����.Member;

// �迭 �׸񿡼� Ư�� ���� ��ġ�� �ε����� ��� ���� �迭 �˻��̶�� �Ѵ�. �迭 �׸��� �˻��Ϸ��� ���� Arrays.sort() �޼ҵ�� �׸���� ������������ ������ ��,
// Arrays.binarySearch() �޼ҵ�� �׸��� ã�ƾ� �Ѵ�. ���� ������ �迭 �׸��� �˻��ϴ� ����� �����ش�.

public class Search��� {
	public static void main(String[] args) {
		// �⺻ Ÿ�԰� �˻�
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
		System.out.println("ã�� �ε���: " + index);
		
		String[] names = { "ȫ�浿", "�ڵ���", "��μ�" };
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "ȫ�浿");
		System.out.println("ã�� �ε���: " + index);
		
		Member m1 = new Member("ȫ�浿");
		Member m2 = new Member("��μ�");
		Member m3 = new Member("�ڵ���");
		Member[] members = { m1, m2, m3 };
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("ã�� �ε���: " + index);
		
		// scores �迭�� ���ĵǸ� 99�� �� �������� ��ġ(�ε���:2)�ǹǷ� Arrays.binarySearch(score, 99)�� ���ϰ��� 2�� �ȴ�.
		// names �迭�� ���ĵǸ� ȫ�浿�� �� �������� ��ġ(�ε���:2)�ǹǷ� Arrays.binarySearch(names, "ȫ�浿")�� ���ϰ��� 2�� �ȴ�.
		// members �迭�� ���ĵǸ� name �ʵ尪�� ȫ�浿�� Member ��ü�� �� �������� ��ġ(�ε���:2)�ǹǷ�
		// Arrays.binarySearch(names, m1)�� ���ϰ��� 2�� �ȴ�.
	}
}
