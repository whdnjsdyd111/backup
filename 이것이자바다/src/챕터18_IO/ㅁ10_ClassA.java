package 챕터18_IO;

import java.io.Serializable;

public class ㅁ10_ClassA implements Serializable {
	int field1;									//	┐
	ㅁ10_ClassB field2 = new ㅁ10_ClassB();		//	┴ 직렬화에 포함
	
	static int field3;		//	┐
	transient int field4;	//	┴ 직렬화에서 제외
}
