package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question07 {
	public static void main(String[] args) {
		
		List<Member> list = Arrays.asList(
			new Member("ȫ�浿", "������"),
			new Member("�質��", "�����̳�"),
			new Member("�ſ��", "������")
		);
		
		List<Member> developer = list.stream()
				.filter( s -> s.getJob() == "������")
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
