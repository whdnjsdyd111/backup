package é��14_���ٽ�;

public class ��3_Member {
	private String name;
	private String id;
	
	public ��3_Member() {}
	public ��3_Member(String id) {
		System.out.println("Member(String id) ����");
		this.id = id;
	}
	public ��3_Member(String name, String id) { 
		System.out.println("Member(String name, String id) ����");
		this.name = name; 
		this.id = id; 
	}
	
	public String getId() { return id; }
}
