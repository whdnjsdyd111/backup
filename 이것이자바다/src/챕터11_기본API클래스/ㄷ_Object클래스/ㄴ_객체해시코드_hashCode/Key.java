package é��11_�⺻APIŬ����.��_ObjectŬ����.��_��ü�ؽ��ڵ�_hashCode;

// ���� ������ ���� Key Ŭ������ equals() �޼ҵ带 �������ؼ� number �ʵ尪�� ������ true�� �����ϵ��� �ߴ�.
// �׷��� hashCode() �޼ҵ�� ���������� �ʾұ� ������ Object�� hashCode() �޼ҵ尡 ���ȴ�.

public class Key {
	public int number;
	
	public Key(int number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Key) {
			Key compareKey = (Key) obj;
			if(this.number == compareKey.number) {
				return true;
			}
		}
		return false;
	}
	
	// �̷� ��� HashMap�� �ĺ�Ű�� Key ��ü�� ����ϸ� ����� ���� ã�ƿ��� ���Ѵ�.
	// �ֳĸ� number �ʵ尪�� ������ hashCode() �޼ҵ忡�� �����ϴ� �ؽ��ڵ尡 �ٸ��� ������ �ٸ� �ĺ�Ű�� �ν��ϱ� �����̴�.
	// Key��� Ŭ�������� "new Key(1)" ��ü�� "ȫ�浿"�� �����ϰ�, �ٽ� "new Key(1)" ��ü�� ����� "ȫ�浿"�� �������� ������ ����� null�� ���´�.
	
	// �ǵ��� ��� "ȫ�浿"�� �������� ������ ���� �������� hashCode() �޼ҵ带 Key Ŭ������ �߰��ϸ� �ȴ�.
	// hashCode()�� ���ϰ��� number �ʵ尪���� �߱� ������ ������ ���� "new Key(1)"�� ���� ���� "new Key(1)"�� ���� �ؽ��ڵ尡 ���ϵȴ�.
	
	@Override
	public int hashCode() {
		return number;
	}
	
	
}
