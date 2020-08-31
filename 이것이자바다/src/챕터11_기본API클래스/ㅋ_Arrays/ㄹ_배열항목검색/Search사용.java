package 챕터11_기본API클래스.ㅋ_Arrays.ㄹ_배열항목검색;

import java.util.Arrays;

import 챕터11_기본API클래스.ㅋ_Arrays.ㄷ_배열항목정렬.Member;

// 배열 항목에서 특정 값이 위치한 인덱스를 얻는 것을 배열 검색이라고 한다. 배열 항목을 검색하려면 먼저 Arrays.sort() 메소드로 항목들을 오름차순으로 정렬한 후,
// Arrays.binarySearch() 메소드로 항목을 찾아야 한다. 다음 예제는 배열 항목을 검색하는 방법을 보여준다.

public class Search사용 {
	public static void main(String[] args) {
		// 기본 타입값 검색
		int[] scores = { 99, 97, 98 };
		Arrays.sort(scores);
		int index = Arrays.binarySearch(scores, 99);
		System.out.println("찾은 인덱스: " + index);
		
		String[] names = { "홍길동", "박동수", "김민수" };
		Arrays.sort(names);
		index = Arrays.binarySearch(names, "홍길동");
		System.out.println("찾은 인덱스: " + index);
		
		Member m1 = new Member("홍길동");
		Member m2 = new Member("김민수");
		Member m3 = new Member("박동수");
		Member[] members = { m1, m2, m3 };
		Arrays.sort(members);
		index = Arrays.binarySearch(members, m1);
		System.out.println("찾은 인덱스: " + index);
		
		// scores 배열이 정렬되면 99는 맨 마지막에 위치(인덱스:2)되므로 Arrays.binarySearch(score, 99)의 리턴값은 2가 된다.
		// names 배열이 정렬되면 홍길동은 맨 마지막에 위치(인덱스:2)되므로 Arrays.binarySearch(names, "홍길동")의 리턴값은 2가 된다.
		// members 배열이 정렬되면 name 필드값이 홍길동인 Member 객체가 맨 마지막에 위치(인덱스:2)되므로
		// Arrays.binarySearch(names, m1)의 리턴값은 2가 된다.
	}
}
