package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü�ؽ��ڵ�_hashCode;

// ������ ����� Member Ŭ������ �����ϴ� ���鿡�� hashCode() �޼ҵ带 ������ �Ѱ��̴�.
// id �ʵ尪�� ���� ��� ���� �ؽ��ڵ带 �����ϵ��� �ϱ� ���� String�� hashCode() �޼ҵ��� ���ϰ��� Ȱ���ߴ�.
// String�� hashCode()�� ���� ���ڿ��� ��� ������ �ؽ��ڵ带 �����Ѵ�.

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if(id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() { // id�� ������ ���ڿ��� ��� ���� �ؽ��ڵ带 ����
		return id.hashCode();
	}
}
