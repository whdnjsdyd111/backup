package é��15_�÷��������ӿ�ũ;

import java.util.List;

public class Question07_ListExample {
	public static void main(String[] args) {
		
		Question07_BoardDao dao = new Question07_BoardDao();
		List<Question07_Board> list = dao.getBoardList();
		for(Question07_Board board : list) {
			System.out.println(board.getTitle() + " - " + board.getContent());
		}
		
	}
}
