package é��08_�������̽�;

public class ��_DefaultMethod_InterfaceExtension {
	// ����Ʈ �޼ҵ��� �������̽��� ����� �ν��Ͻ� �޼ҵ��̱� ������ ���� ��ü�� �־�� ����� �� �ִ�.
	// ������ �������̽����� �ϰ�, ����� ���� ��ü�� ���� �Ѵٴ� ���� ����� ���δ�.
	// ����Ʈ �޼ҵ�� ��� ���� ��ü���� �����ϴ� �⺻ �޼ҵ�ó�� ��������, ����� �������̽� ���� ����Ʈ �޼ҵ带 ����� �ٸ� ������ �ִ�.
	
			// 	Necessity Of Default Method		����Ʈ �޼ҵ��� �ʿ伺
	
	// �������̽����� ����Ʈ �޼ҵ带 ����� ������ ���� �������̽��� Ȯ���ؼ� ���ο� ����� �߰��ϱ� ���ؼ��̴�.
	// ���� �������̽��� �̸��� �߻� �޼ҵ��� ���� ���� ����Ʈ �޼ҵ常 �߰��� �� �ֱ� ������ ������ ������ ���� Ŭ������ �״�� ����� �� �����鼭 ���Ӱ� �����ϴ� Ŭ������ ����Ʈ �޼ҵ带 Ȱ���� �� �ִ�.
	
	// �Ʒ��� ���� ��������. ������ myInterface��� �������̽��� �̸� ������ ClassA��� Ŭ������ �ִ�. �ð��� �귯 MyInterface�� ����� �߰��ؾ��� �ʿ伺�� �����.
	// �׷��� MyInterface�� �߻� �޼ҵ带 �߰��ߴµ�, ClassA�� ������ �߻��Ѵ�. �� ������ �߰��� �߻� �޼ҵ忡 ���� ��ü �޼ҵ尡 ClassA�� ���� �����̴�.
	// ClassA�� ������ ������ �ȵȴٸ� �ᱹ MyInterface�� �߻� �޼ҵ带 �߰��� �� ����. �׷��� MyInterface�� ����Ʈ �޼ҵ带 �����Ѵ�.
	// ����Ʈ �޼ҵ�� �߻� �޼ҵ尡 �ƴϱ� ������ ���� Ŭ�������� ��ü �޼ҵ带 �ۼ��� �ʿ䰡 ����. ���� ClassA�� �ƹ��� �������� ��� ����� �����ϴ�.
	
	//					MyInterface		-	method1()					// ���� �߻� �޼ҵ�
	//						��			-	default method2() {...}		// ����Ʈ �޼ҵ� �߰�
	//			��					��
	//	���� ���� Ŭ����				���ο� ���� Ŭ����
	//	(�״�� ��� ����)			(����Ʈ �޼ҵ带 Ȱ��)
	//
	//	ClassA					ClassB
	//	- method1() {...}		- method1() {...}
	//							- method2() {...}

	// ������ MyInterface�� ������ ���ο� Ŭ������ ClassB�� method1()�� ������ �ݵ�� ä���� ������, ����Ʈ �޼ҵ��� method2()�� yInterface�� ���ǵ� ���� ����ص� �ǰ�,
	// �ʿ信 ���� �������ؼ� ����� ���� �ִ�. ���� ������ ���ݱ��� ������ ���� �ڵ�� ǥ���ߴ�.
	
			//	Interface Inheritance Having Default Method		����Ʈ �޼ҵ尡 �ִ� �������̽� ���
	
	// �������̽� ������ ����� �ִٴ� ���� �̹� �н��߾���. �θ� �������̽��� ����Ʈ �޼ҵ尡 ���ǵǾ� ���� ���, �ڽ� �������̽����� ����Ʈ �޼ҵ带 Ȱ���ϴ� ����� ���� �� ������ �ִ�.
	
	//	-	����Ʈ �޼ҵ带 �ܼ��� ��Ӹ� �޴´�.
	//	-	����Ʈ �޼ҵ带 ������(Overriding)�ؼ� ���� ������ �����Ѵ�.
	//	-	����Ʈ �޼ҵ带 �߻� �޼ҵ�� �缱���Ѵ�.
	
	// ���� �������� �ٷ� ���캸��.�߻� �޼ҵ�� ����Ʈ �޼ҵ尡 ����� ParentInterface�� �ִٰ� ��������.
	// �׸��� ChildInterface1�� ParentInterface�� ����ϰ� �ڽ��� �߻� �޼ҵ��� method3()�� �����Ѵ�.
	// �̷� ��� ChildInterface1 �������̽��� �����ϴ� Ŭ������ method1()�� method3()�� ��ü �޼ҵ带 ������ �־�� �ϸ� ParentInterface�� method2()�� ȣ���� �� �ִ�.
	
	//	ChildInterface1 ci1 = new ChildInterface1() {
	//		@Override
	//		public void method1() { // ���๮ }
	//		@Override
	//		public void method3() { // ���๮ }
	//	};
	//
	//	ci1.method1();
	//	ci1.method2();		// ParentInterface�� method2() ȣ��
	//	ci1.method3();
	
	// ���� ChildInterface2�� ParentInterface�� ����ϰ� ParentInterface�� ����Ʈ �޼ҵ��� method2()�� �������Ѵ�. �׸��� �ڽ��� �߻� �޼ҵ��� method3()�� �����Ѵ�.
	// �� ��쵵 ChildInterface2 �������̽��� �����ϴ� Ŭ������ method1()�� method3()�� ��ü �޼ҵ带 ������ �־���ϸ�, ChildInterface2���� �������� method2()�� ȣ���� �� �ִ�.
	
	//	ChildInterface2 ci2 = new ChildInterface2() {
	//		@Override
	//		public void method1() { // ���๮ }
	//		@Override
	//		public void method3() { // ���๮ }
	//	};
	//
	//	ci2.method1();
	//	ci2.method2();		// ChildInterface2�� method2() ȣ��
	//	ci2.method3();
	
	// ������ ChildInterface3�� ParentInterface�� ����ϰ� ParentInterface�� ����Ʈ �޼ҵ��� method2()�� �߻� �޼ҵ�� �缱���Ѵ�. �׸��� �ڽ��� �߻� �޼ҵ��� method3()�� �����Ѵ�.
	// �� ��� ChildInterface3 �������̽��� �����ϴ� Ŭ������ method1()�� method2(), method3()�� ��ü �޼ҵ带 ��� ������ �־�� �Ѵ�.
	
	//	ChildInterface3 ci3 = new ChildInterface3() {
	//		@Override
	//		public void method1() { /* ���๮ */ }
	//		@Override
	//		public void method2() { /* ���๮ */ }
	//		@Override
	//		public void method3() { /* ���๮ */ }
	//	};
	//
	//	ci3.method1();
	//	ci3.method2();		// ChildInterface3�� method2() ȣ��
	//	ci3.method3();
}
