package é��16_��Ʈ��_����ó��;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question08 {
	public static void main(String[] args) {
		
		List<Member> list = Arrays.asList(
			new Member("ȫ�浿", "������"),
			new Member("�質��", "�����̳�"),
			new Member("�ſ��", "������")
		);
		
		Map<String, List<String>> groupingMap = list.stream()
				.collect(Collectors.groupingBy(	Member :: getJob,
												Collectors.mapping(Member :: getName,
												Collectors.toList())
												) 
						);
		
		System.out.print("[������] ");
		groupingMap.get("������").forEach(s -> System.out.print(s + " "));
		
		System.out.println();
		
		System.out.print("\n[�����̳�] ");
		groupingMap.get("�����̳�").forEach(s -> System.out.print(s + " "));
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
