package 챕터14_람다식;

public class ㅂ3_Member {
	private String name;
	private String id;
	
	public ㅂ3_Member() {}
	public ㅂ3_Member(String id) {
		System.out.println("Member(String id) 실행");
		this.id = id;
	}
	public ㅂ3_Member(String name, String id) { 
		System.out.println("Member(String name, String id) 실행");
		this.name = name; 
		this.id = id; 
	}
	
	public String getId() { return id; }
}
