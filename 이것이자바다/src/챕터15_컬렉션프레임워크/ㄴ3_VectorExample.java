package é��15_�÷��������ӿ�ũ;

import java.util.List;
import java.util.Vector;

public class ��3_VectorExample {
	public static void main(String[] args) {
		List<��3_Board> list = new Vector<��3_Board>();
		
		list.add(new ��3_Board("����1", "����1", "�۾���1"));
		list.add(new ��3_Board("����2", "����2", "�۾���2"));
		list.add(new ��3_Board("����3", "����3", "�۾���3"));
		list.add(new ��3_Board("����4", "����4", "�۾���4"));
		list.add(new ��3_Board("����5", "����5", "�۾���5"));
		
		list.remove(2);		// 2�� �ε��� ��ü( ����3 ) ���� 
		list.remove(3);		// 3�� �ε��� ��ü( ����5 ) ����
		
		for (int i = 0; i < list.size(); i++) {
			��3_Board board = list.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
		}
	}
}
