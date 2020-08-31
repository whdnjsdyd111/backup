package é��11_�⺻APIŬ����.��_�ڹ�API��ť��Ʈ;

public class �ڹ�API��ť��Ʈ {
	// API�� ���̺귯����� �θ��⵵ �ϴµ�, �ñ׷� ���߿� ���� ���Ǵ� Ŭ���� �� �������̽��� ������ ���Ѵ�.
	// �츮�� ����� �Դ� String Ŭ������ System Ŭ������ ��� API�� ���ϴ� Ŭ�������̴�.
	// �� API���� <JDK ��ġ ���> \jre\lib\rt.jar ��� ���� ���Ͽ� ����Ǿ� �ִ�.
	
	// API ��ť��Ʈ�� ���� API�� ã�� �̿��Ҽ� �ֵ��� ����ȭ�� ���� ���Ѵ�. 
	// API ��ť��Ʈ�� HTML �������� �ۼ��Ǿ� �ֱ� ������ �� �������� ���� ����Ŭ���� �����ϴ� ���� URL�� �湮�ϸ� ���� �ִ�.
	// http://docs.oracle.com/javase/8/docs/api ���ã�⿡ �߰��ؼ� ���� ���� �� �� �ֵ��� �س���
	
	// API ��ť��Ʈ�� �� ���� ���������� �������� �ִ�. 
	// ���� ����� �����ӿ��� ��Ű�� ��ü ����� �����ش�. 
	// ���� �ϴ� �����ӿ��� ��Ű���� ���ϴ� Ŭ������ �������̽� ����� �����ش�.
	// �߾� �����ӿ��� ���� �ϴ� �����ӿ��� ������ Ŭ������ �������̽��� ���� �� ������ �����ش�.
	// ���� ��� String Ŭ������ �� ������ ���� �ʹٸ�, ���� ��� �����ӿ��� java.lang�� Ŭ���ϰ�,
	// ���� �ϴ� �����ӿ��� String�� Ŭ���ϸ� �߾� �����ӿ��� String Ŭ������ ���� �� ������ �� �� �ִ�.
	
	// �߾� �������� ������ ũ�� ���κ����� ���еȴ�. ��� �κ��� Ŭ������ ���Ե� ��Ű�� ����, ��� ����, �������̽� ���� ������ ǥ���Ѵ�.
	// �߾� �κ��� Ŭ������ ����� ��� ����� �����ϰ� �����ش�. �ϴ� �κ��� �ʵ�, ������, �޼ҵ��� ����� �����ش�.
	// Ŭ������ ������ �ִ� ��ø Ŭ����, �ʵ�, ������, �޼ҵ��� ������� �ٷ� ���� �ʹٸ� 
	// ����� Summary �κп� �ִ� Nested|Field|Method ��ũ�� �ٷ� Ŭ���ϸ� �ȴ�.
	// ������ String Ŭ������ Field Summary ������ �����ش�. �ʵ忡 ���� ���� ������ �а� �ʹٸ� �ʵ� �̸��� Ŭ���ϸ� �ȴ�.
	
	// Field Summary
	//	 Fields
	//	Modifier and Type			Field and Description
	//	static Comparator<String>	CASE_INSENSITIVE_ORDER
	//								A Comparator that orders String objects as by compareToIgnoreCase.
	
	// ������ String Ŭ������ Constructor Summary ������ �����ش�.
	// ������ �̸��� �Ű� ���� Ÿ�� �׸��� ������ ������ ����Ǿ� �ִ�. �����ڿ� ���� ���� ������ �а� �ʹٸ� �����ڸ� Ŭ���ϸ� �ȴ�.
	
	// Constructor Summary
	//	 Constructors
	//	Constructor and Description
	//	String()
	//	Initializes a newly created String object so that it represents an empty character sequence.
	//	String(byte[] bytes)
	// Constructs a new String by decoding the specified array of bytes using the platform's default charset.
	
	// ������ String Ŭ������ Method Summary ������ �����ش�. �޼ҵ��� ���� �����ڿ� ���� Ÿ�� �׸��� �޼ҵ� �̸��� �Ű� ������ ���� ������ �� �� �ִ�.
	// �޼ҵ忡 ���� ���� ������ �а� �ʹٸ� �޼ҵ��� �̸��� Ŭ���ϸ� �ȴ�.
	
	//	Method Summary
	//	 All Methods	 Static Methods	 Instance Methods	 Concrete Methods	 Deprecated Methods
	//	Modifier and Type	Method and Description
	//	char				charAt(int index)
	//						Returns the char value at the specified index
	//	int					codePointAt(int index)
	//						Returns the character (Unicode code point) at the specified index
	
	// ��Ŭ���������� �� �� ���� ������� API ��ť��Ʈ�� �� �� �ִ�. �ڹ� �����Ϳ��� Ŭ������ ���콺�� ������ ���� F1 Ű�� ������ �ڵ����� API ��ť��Ʈ�� �����ش�.
	// Help �信�� �ش� Ŭ������ Ŭ���ϸ� API ��ť��Ʈ�� �����ش�.
	
	public static void main(String[] args) {
		String name = "ȫ�浿";
		System.out.println(name);
	}
	
	// ���ݱ��� �ڹ� API ��ť��Ʈ�� �д� ����� ���� ���캸�Ҵ�. �������� �Ǿ� �־� �ټ� �бⰡ �����. 
	// �ѱ۷� �������� ����Ʈ�� ������ �������� ���� ���� �����Ѵ�. ��Ȯ�� ���� �� �˾Ƶδ� ���� ���α׷� �ۼ��� ������ �Ǳ� �����̴�.
}
