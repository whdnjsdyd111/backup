package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü��_equals;

// ���� ������ Member Ŭ�������� equals() �޼ҵ带 ������ �Ѱ��̴�.
// Member Ÿ���̸鼭 id �ʵ尪�� ���� ��� true�� ����, �׷��� ������ false�� �����ϵ��� �ߴ�.

public class Member {
	public String id;
	
	public Member(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) { // �Ű����� Member Ÿ������ Ȯ��
			Member member = (Member) obj; // MemberŸ������ ���� Ÿ�� ��ȯ�ϰ�
			if(id.equals(member.id)) {	  // id �ʵ尪�� �������� ������ ��,
				return true;			  // �����ϴٸ� true ����
			}
		}
		return false; // �Ű����� Member Ÿ���� �ƴϰų� id �ʵ尪�� �ٸ� ��� false ����
	}
}
