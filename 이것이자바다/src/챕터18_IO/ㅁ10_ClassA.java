package é��18_IO;

import java.io.Serializable;

public class ��10_ClassA implements Serializable {
	int field1;									//	��
	��10_ClassB field2 = new ��10_ClassB();		//	�� ����ȭ�� ����
	
	static int field3;		//	��
	transient int field4;	//	�� ����ȭ���� ����
}
