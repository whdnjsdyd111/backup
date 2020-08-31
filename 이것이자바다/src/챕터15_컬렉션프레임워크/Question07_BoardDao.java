package 챕터15_컬렉션프레임워크;

import java.util.ArrayList;
import java.util.List;

public class Question07_BoardDao {
	private List<Question07_Board> list = new ArrayList<Question07_Board>();
	
	public Question07_BoardDao() {
		for (int i = 0; i < 3; i++) {
			list.add(new Question07_Board("제목" + (i + 1), "내용" + (i + 1)));
		}
	}
	
	public List<Question07_Board> getBoardList() {
		return list;
	}
}
