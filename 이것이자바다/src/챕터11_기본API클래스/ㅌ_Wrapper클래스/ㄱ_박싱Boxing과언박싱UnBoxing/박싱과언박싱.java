package é��11_�⺻APIŬ����.��_WrapperŬ����.��_�ڽ�Boxing����ڽ�UnBoxing;

public class �ڽ̰���ڽ� {
	// �⺻ Ÿ���� ���� ���� ��ü�� ����� ������ �ڽ�(Boxing)�̶�� �ϰ�, �ݴ�� ���� ��ü���� �⺻ Ÿ���� ���� ���� ������ ��ڽ�(UnBoxing)�̶�� �Ѵ�.
	// ������ 8���� �⺻ Ÿ���� ���� �ڽ��ϴ� ����� �����ְ� �ִ�. �����ϰ� ���� Ŭ������ ������ �Ű������� �⺻ Ÿ���� �� �Ǵ� ���ڿ��� �Ѱ��ָ� �ȴ�.
	
	//	�⺻ Ÿ���� ���� �� ���							���ڿ��� �� ���
	//
	//	Byte obj = new Byte(10);				Byte obj = new Byte("10");
	//	Character obj = new Character('��');		����
	//	Short obj = new Short(100);				Short obj = new Short("100");
	//	Integer obj = new Integer(1000);		Integer obj = new Integer("1000");			
	//	Long obj = new Long(10000);				Long obj = new Long("10000");
	//	Float obj = new Float(2.5F);			Float obj = new Float("2.5F");
	//	Double obj = new Double(3.5);			Double obj = new Double("3.5");
	//	Boolean obj = new Boolean(true);		Boolean obj = new Boolean("true");
	
	// �����ڸ� �̿����� �ʾƵ� ������ ���� �� ���� Ŭ�������� ������ �ִ� ���� valueOf() �޼ҵ带 ����� ���� �ִ�.
	
	//	Integer obj = Integer.valueOf(1000);
	//	Integer obj = Integer.valueOf("1000");
	
	// �̷��� �ڽ̵� ���� ��ü���� �ٽ� �⺻ Ÿ���� ���� ��� ���� ���ؼ���(��ڽ��ϱ� ���ؼ���) �� ���� Ŭ�������� �������ִ�
	// "�⺻Ÿ�Ը�+ValueOf()" �޼ҵ带 ȣ���ϸ� �ȴ�.
	
	// 	�⺻Ÿ���� ���� �̿�
	//
	//	byte		num = obj.byteValueOf();
	//	char		ch  = obj.charValueOf()
	//	short		num = obj.shortValueOf()
	//	int			num = obj.intValueOf()
	//	long		num = obj.longValueOf()
	//	float		num = obj.floatValueOf()
	//	double		num = obj.doubleValueOf()
	//	boolean		bool= obj.booleanValueOf()
}
