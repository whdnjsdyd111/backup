package 챕터16_스트림_병렬처리;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question07 {
	public static void main(String[] args) {
		
		List<Member> list = Arrays.asList(
			new Member("홍길동", "개발자"),
			new Member("김나리", "디자이너"),
			new Member("신용권", "개발자")
		);
		
		List<Member> developer = list.stream()
				.filter( s -> s.getJob() == "개발자")
				.collect(Collectors.toList());
				
				
		
		developer.stream().forEach( s -> System.out.println(s.getName()) );
	}

	static class Member {
		private String name;
		private String job;
		
		public Member(String name, String age) {
			this.name = name;
			this.job = age;
		}
		
		public String getName() { return name; }
		public String getJob() { return job; }
	}
}
