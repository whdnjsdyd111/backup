package é��11_�⺻APIŬ����.��_StringTokenizerŬ����.��_StringTokenizer�޼ҵ�;

public class ��Ʈ����ũ���� {
	// ���ڿ��� �� ������ �����ڷ� ����Ǿ� ���� ���, StringTokenizer Ŭ������ ����ϸ� �ս��� ���ڿ�(��ū: token)�� �и��� �� �� �ִ�.
	// StringTokenizer ��ü�� ������ �� ù ��° �Ű������� ��ü ���ڿ��� �ְ�, �� ��° �Ű������� �����ڸ� �ָ� �ȴ�.
	
	//	StringTokenizer st = new StringTokenizer("���ڿ�", "������");
	
	// ���� �����ڸ� �����ϸ� ����(space)�� �⺻ �����ڰ� �ȴ�. 
	// ���� ��� ���ڿ��� "/"�� ���еǾ� ���� ���, ������ ���� StringTokenizer ��ü�� ������ �� �ִ�.
	
	//	String text = "ȫ�浿/�̼�ȫ/�ڿ���";
	//	StringTokenizer st = new StringTokenizer(text, "/");
	
	// StringTokenizer ��ü�� �����Ǹ� �κ� ���ڿ��� �и��� �� �� �ִµ�, 
	// ���� �޼ҵ���� �̿��ؼ� ��ü ��ū ��, ���� �ִ� ��ū ���θ� Ȯ���� ���� ��ū�� ������ �ȴ�.
	
	//	�޼ҵ�							����
	
	//	int			countTokens()		������ �ʰ� ���� �ִ� ��ū�� ��
	
	//	boolean		hasMoreTokens()		���� �ִ� ��ū�� �ִ��� ����
	
	//	String		nextToken()			��ū�� �ϳ��� ������
	
	// nextToken() �޼ҵ�� ��ū�� �ϳ��� �������� StringTokenizer ��ü���� �ش� ��ū�� ��������.
	// ���� StringTokenizer ��ü���� �� �̻� ������ ��ū�� ���ٸ� nextToken() �޼ҵ�� java.util.NosuchElementException ���ܸ� �߻���Ų��
	// �׷��� nextToken() �޼ҵ带 ����ϱ� ���� hasMoreTokens() �޼ҵ�� ������ ��ū�� �ִ��� ������ �� nextToken() �޼ҵ带 ȣ���ϴ� ���� ���� ���
	
}
