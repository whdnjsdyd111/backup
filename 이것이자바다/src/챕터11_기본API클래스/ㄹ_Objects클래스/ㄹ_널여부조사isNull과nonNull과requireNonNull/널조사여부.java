package é��11_�⺻APIŬ����.��_ObjectsŬ����.��_�ο�������isNull��nonNull��requireNonNull;

public class �����翩�� {
	// Objects.isNull(Object obj)�� �Ű����� null�� ��� true�� �����Ѵ�.
	// �ݴ�� nonNull(Object obj)�� �Ű����� not null�� ��� true�� �����Ѵ�.
	// requireNonNull()�� ���� �� ������ �����ε� �Ǿ� �ִ�.
	
	//	����Ÿ��	�޼ҵ�(�Ű� ����)							����
	//	T		requireNonNull(T obj)				not null -> obj
	//												null -> NullPointerException
	//
	//	T		requireNonNull(T obj,				not null -> obj
	//				String message)					null -> NullPointerException(message)
	//
	//	T		requireNonNull(T obj,				not null -> obj
	//				Supplier<String> msgSupplier)	null -> NullPointerException(msgSupplier.get())
	
	// ù ��° �Ű����� not null�̸� ù ��° �Ű����� �����ϰ�, null �̸� ��� NullPointerException�� �߻���Ų��.
	// �ι�° �Ű����� NullPointerException�� ���� �޼����� �����Ѵ�.
	
}
