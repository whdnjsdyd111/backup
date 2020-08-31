package 챕터15_컬렉션프레임워크;

import java.util.List;
import java.util.Vector;

public class ㄴ3_VectorExample {
	public static void main(String[] args) {
		List<ㄴ3_Board> list = new Vector<ㄴ3_Board>();
		
		list.add(new ㄴ3_Board("제목1", "내용1", "글쓴이1"));
		list.add(new ㄴ3_Board("제목2", "내용2", "글쓴이2"));
		list.add(new ㄴ3_Board("제목3", "내용3", "글쓴이3"));
		list.add(new ㄴ3_Board("제목4", "내용4", "글쓴이4"));
		list.add(new ㄴ3_Board("제목5", "내용5", "글쓴이5"));
		
		list.remove(2);		// 2번 인덱스 객체( 제목3 ) 삭제 
		list.remove(3);		// 3번 인덱스 객체( 제목5 ) 삭제
		
		for (int i = 0; i < list.size(); i++) {
			ㄴ3_Board board = list.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
		}
	}
}
