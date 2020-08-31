package é��14_���ٽ�;

public class ��_FunctionalInterfaceOfAPI {
	// �ڹٿ��� �����Ǵ� ǥ�� API���� �� ���� �߻� �޼ҵ带 ������ �������̽����� ��� ���ٽ��� �̿��ؼ� �͸� ���� ��ü�� ǥ���� �����ϴ�.
	// ���� ��� �������� �۾��� �����ϴ� Runnable �������̽��� �Ű� �����Ϳ� ���ϰ��� ���� run() �޼ҵ常 �����ϱ� ������ ���� ������ ���� ���ٽ��� �̿��ؼ� Runnable �ν��Ͻ��� ������ �� �ִ�.
	
	// Thread �����ڸ� ȣ���� �� ������ ���� ���ٽ��� �Ű������� �����ص� �ȴ�.
	
	//	Thread thread = new Thread( () -> {
	//		for(int i = 0; i < 10; i++) {
	//			System.out.println(i);
	//		}
	//	});
	
	// �ڹ� 8 ���ʹ� ����ϰ� ���Ǵ� �Լ��� �������̽�(functional interface)�� java.function ǥ�� API ��Ű���� �����Ѵ�.
	// �� ��Ű������ �����ϴ� �Լ��� �������̽��� ������ �޼ҵ� �Ǵ� �������� �Ű� Ÿ������ ���Ǿ� ���ٽ��� ������ �� �ֵ��� �ϱ� ���ؼ��̴�.
	// �ڹ� 8 ���� �߰��ǰų� ����� API���� �� �Լ��� �������̽����� �Ű� Ÿ������ ���� ����Ѵ�. ���� �츮�� �����ϴ� �޼ҵ忡�� �� �Լ��� �������̽����� �Ű� Ÿ������ ����� �� �ִ�.
	// java.util.function ��Ű���� �Լ��� �������̽��� ũ�� Consumer, Supplier, Function, Operator, Predicate�� ���еȴ�.
	// ���� ������ �������̽��� ����� �߻� �޼ҵ��� �Ű����� ���ϰ��� �����̴�.
	
	//	����				�߻� �޼ҵ� Ư¡							
	//														
	//	Consumer		- �Ű����� �ְ�, ���ϰ��� ����				�Ű��� -> Consumer
	//														
	//	Supplier		- �Ű����� ����, ���ϰ��� ����						Supplier -> ���ϰ�
	//																					
	//	Function		- �Ű����� �ְ�, ���ϰ��� ����				�Ű��� -> Function -> ���ϰ�									
	//					- �ַ� �Ű����� ���ϰ����� ����(Ÿ�� ��ȯ)											
	//															
	//	Operator		- �Ű����� �ְ�, ���ϰ��� ����				�Ű��� -> Operator -> ���ϰ�						
	//					- �ַ� �Ű����� �����ϰ� ����� ����								
	//																
	//	Predicate		- �Ű����� �ְ�, ���� Ÿ���� boolean			�Ű��� -> Predicate -> ���ϰ�		
	//					- �Ű����� �����ؼ� true/false�� ����	
	
			//	Consumer Functional Interface	Consumer �Լ��� �������̽�
	
	// Consumer �Լ��� �������̽��� Ư¡�� ���ϰ��� ���� accept() �޼ҵ带 ������ �ִ�. accept() �޼ҵ�� ���� �Ű����� �Һ��ϴ� ���Ҹ� �Ѵ�. ���⼭ �Һ��Ѵٴ� ���� ��븸 �� �� ���ϰ��� ���ٴ� ���̴�.
	
	//					�Ű��� -> Consumer
	
	// �Ű� ������ Ÿ�԰� ���� ���� �Ʒ��� ���� Consumer���� �ִ�.
	
	//	�������̽���			�߻� �޼ҵ�								����
	//
	//	Consumer<T>			void accept(T t)					��ü T�� �޾� �Һ�
	//	BiConsumer<T, U>	void accept(T t, U u)				��ü T�� U�� �޾� �Һ�
	//	DoubleConsumer		void accept(double value)			double ���� �޾� �Һ�
	//	IntConsumer			void accept(int value)				int ���� �޾� �Һ�
	//	LongConsumer		void accept(long value)				long ���� �޾� �Һ�
	//	ObjIntConsumer		void accept(T t, double value)		��ü T�� double ���� �޾� �Һ�
	//	ObjIntConsumer		void accept(T t, int value)			��ü T�� int ���� �޾� �Һ�
	//	ObjLongConsumer		void accept(T t, long value)		��ü T�� long ���� �޾� �Һ�
	
	// Consumer<T> �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�. accept() �޼ҵ�� �Ű������� T ��ü �ϳ��� �����Ƿ� ���ٽĵ� �� ���� �Ű� ������ ����Ѵ�.
	// Ÿ�� �Ķ���� T�� String�� ���ԵǾ��� ������ ���ٽ��� t �Ű� ���� Ÿ���� String�� �ȴ�.
	
	//	Consumer<String> consumer = t -> { t�� �Һ��ϴ� ���๮; };
	
	// BiConsumer<T, U> �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�.
	// accept() �޼ҵ�� �Ű������� T�� U �� ���� ��ü�� �����Ƿ� ���ٽĵ� �� ���� �Ű� ������ ����Ѵ�. Ÿ�� �Ķ���� T�� U�� String�� ���ԵǾ��� ������ ���ٽ��� t�� u �Ű� ���� Ÿ���� ���� String�� �ȴ�.
	
	//	BiConsumer<String, String> biConsumer = (t, u) -> { t�� u�� �Һ��ϴ� ���๮; };
	
	// DoubleConsumer �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�.
	// accept() �޼ҵ�� �Ű������� double �ϳ��� �����Ƿ� ���ٽĵ� �� ���� �Ű� ������ ����Ѵ�. d�� ���������� double Ÿ���� �ȴ�.
	
	//	DoubleConsumer consumer = d -> { d�� �Һ��ϴ� ���๮; };
	
	// OnjIntConsumer<T> �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�.
	// accept() �޼ҵ�� �Ű������� T ��ü�� int �� �� ���� ������ ������ ���ٽĵ� �� ���� �Ű� ������ ����Ѵ�. T�� String Ÿ������ ���ٽ��� t �Ű� ���� Ÿ���� String�� �ǰ�, i�� ���������� int Ÿ���� �ȴ�.
	
	//	ObjIntConsumer<String> consumer = (t, i) -> { t�� i�� �Һ��ϴ� ���๮; };
	
			//	Supplier �Լ��� �������̽�
	
	// Supplier �Լ��� �������̽��� Ư¡�� �Ű� ������ ���� ���ϰ��� �ִ� getXXX() �޼ҵ带 ������ �ִ�. �� �޼ҵ���� ���� �� ȣ���� ������ �����͸� ����(����)�ϴ� ������ �Ѵ�.
	
	//					Supplier -> ���ϰ�
	
	// ���� Ÿ�Կ� ���� �Ʒ��� ���� Supplier �Լ��� �������̽����� �ִ�.
	
	//	�������̽���			�߻� �޼ҵ�						����
	//	
	//	Supplier<T>			T get()						T ��ü�� ����
	//	BooleanSupplier		boolean getAsBoolean()		boolean ���� ����
	//	DoubleSupplier		double getAsDouble()		double ���� ����
	//	IntSupplier			int getAsInt()				int ���� ����
	//	LongSupplier		long getAsLong()			long ���� ����
	
	// Supplier<T> �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�. get() �޼ҵ尡 �Ű����� ������ �����Ƿ� ���ٽĵ� ()�� ����Ѵ�.
	// ���ٽ��� �߰�ȣ {}�� �ݵ�� �� ���� T ��ü�� �����ϵ��� �ؾ� �Ѵ�. T�� String Ÿ���̹Ƿ� ���ٽ��� �߰�ȣ {}�� ���ڿ��� �����ϵ��� �ؾ� �Ѵ�.
	
	//	Supplier<String> supplier = () -> { ...; return "���ڿ�"; }
	
	// IntSupplier �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�. getAsInt() �޼ҵ尡 �Ű����� ������ �����Ƿ� ���ٽĵ� ()�� ����Ѵ�.
	// ���ٽ��� �߰�ȣ {}�� �ݵ�� int ���� �����ϵ��� �ؾ� �Ѵ�.
	
	//	IntSupplier supplier = () -> { ...; return int ��; }
	
	// ���� ������ �ֻ����� ���ڸ� �����ϰ� �����ϴ� IntSupplier �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��̴�.
	
			//	Function Functional interface		Function �Լ��� �������̽�
	
	// Function �Լ��� �������̽��� Ư¡�� �Ű����� ���ϰ��� �ִ� applyXXX() �޼ҵ带 ������ �ִ�. �� �޼ҵ���� �Ű����� ���ϰ����� ����(Ÿ�� ��ȯ)�ϴ� ������ �Ѵ�.
	
	//					�Ű��� -> Funtion -> ���ϰ�
	
	// �Ű� ���� Ÿ�԰� ���� Ÿ�Կ� ���� �Ʒ��� ���� Function �Լ��� �������̽����� �ִ�.
		
	//	�������̽���					�߻� �޼ҵ�								����
	//
	//	Function<T, R>				R apply(T t)						��ü T�� ��ü R�� ����
	//	BiFunction<T, U, R>			R apply(T t, U u)					��ü T�� U�� ��ü R�� ����
	//	DoubleFunction<R>			R apply(double value)				double�� ��ü R�� ����
	//	IntFunction<R>				R apply(int value)					int�� ��ü R�� ����
	//	IntToDoubleFunction			double applyAsDouble(int value)		int�� double�� ����
	//	IntToLongFunction			long applyAsLong(int value)			int�� long���� ����
	//	LongToDoubleFunction		double applyAsDouble(long value)	long�� double�� ����
	//	LongToIntFunction			int applyAsInt(long value)			long�� int�� ����
	//	ToDoubleBiFunction<T, U>	double applyAsDouble(T t, U u)		��ü T�� U�� double�� ����
	//	ToDoubleFunction<T>			double applyAsDouble(T t)			��ü T�� double�� ����
	//	ToIntBiFunction<T, U>		int applyAsInt(T t, U u)			��ü T�� U�� int�� ����
	//	ToIntFunction<T>			int applyAsInt(T t)					��ü T�� int�� ����
	//	ToLongBiFunction<T, U>		long applyAsLong(T t, U u)			��ü T�� U�� long���� ����
	//	ToLongFunction<T>			long applyAsLong(T t)				��ü T�� long���� ����
	
	// Function<T, R> �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�. apply() �޼ҵ�� �Ű������� T ��ü �ϳ��� �����Ƿ� ���ٽĵ� �� ���� �Ű� ������ ����Ѵ�.
	// �׸��� apply() �޼ҵ��� ���� Ÿ���� R�̹Ƿ� ���ٽ� �߰�ȣ {}�� ���ϰ��� R ��ü�� �ȴ�.
	// T�� student Ÿ���̰� R�� String Ÿ���̹Ƿ� t �Ű� ���� Ÿ���� Student�� �ǰ�, ���ٽ��� �߰�ȣ {}�� String�� �����ؾ� �Ѵ�.
	// t.getName()�� Student ��ü�� getName() �޼ҵ带 ȣ���ؼ� �л� �̸�(String)�� ��´�. return���� ���� ��� �߰�ȣ {}�� return���� ������ �� �ִ�.
	// ���� �ڵ�� Student ��ü�� �л� �̸�(String)���� �����ϴ� ���̴�.
	
	//	Function<Student, String> function = t -> { return t.getName(); }		�Ǵ�
	//	Function<Student, String> function = t -> t.getName();				
	
	// ToIntFunction<T> �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�. applyAsInt() �޼ҵ�� �Ű������� T ��ü �ϳ��� �����Ƿ� ���ٽĵ� �� ���� �Ű� ������ ����Ѵ�.
	// �׸��� applyAsInt() �޼ҵ��� ���� Ÿ���� int�̹Ƿ� ���ٽ� �߰�ȣ {}�� ���ϰ��� int�� �ȴ�. T�� Student Ÿ���̹Ƿ� t �Ű� ���� Ÿ���� Student�� �ȴ�.
	// t.getScore()�� Student ��ü�� getScore() �޼ҵ带 ȣ���ؼ� �л� ����(int)�� ��´�. ���� �ڵ�� Student ��ü�� �л� ����(int)�� �����ϴ� ���̶�� �� �� �ִ�.
	
	//	ToIntFunction<Student> function = t -> { return t.getScore(); }			�Ǵ�
	//	ToIntFunction<Student> function = t -> t.getScore();
	
	// ���� ������ List�� ����� �л� ��ü�� �ϳ��� ������ �̸��� ������ ����Ѵ�. FunctionExample1�� printString() �޼ҵ�� Function<Student, String> �Ű� ������ ������ �ְ�,
	// printInt() �޼ҵ�� ToIntFunction<Student> �Ű� ������ ������ �����Ƿ� �� �޼ҵ���� ȣ���� �� �Ű������� ���ٽ��� ����� �� �ִ�.
	
	// �� ���� ������ List�� ����� �л� ��ü�� �ϳ��� ������ ���� ������ ���� ������ ��հ��� �����Ѵ�.  FunctionExample2�� avg() �޼ҵ�� ToIntFunction<Student> �Ű� ������ ������ �ִ�.
	// ���� avg() �޼ҵ带 ȣ���� �� �Ű������� ���ٽ��� ����� �� �ִ�. ���ٽ��� getEnglishScore()�� getMathScore()�� ȣ���ؼ� ���� ������ ���� ������ Student ��ü�� ����(��ȯ) ��Ų��.
	
			//	Operator Functional Interface		Operator �Լ��� �������̽�
	
	// Operator �Լ��� �������̽��� Function�� �����ϰ� �Ű� ������ ���ϰ��� �ִ� applyXXX() �޼ҵ带 ������ �ִ�.
	// ������ �� �޼ҵ���� �Ű����� ���ϰ����� ����(Ÿ�� ��ȯ)�ϴ� ���Һ��ٴ� �Ű����� �̿��ؼ� ������ ������ �� ������ Ÿ������ ���ϰ��� �����ϴ� ������ �Ѵ�.
	
	//					�Ű��� -> Operator -> ���ϰ�
	
	// �Ű� ������ Ÿ�԰� ���� ���� �Ʒ��� ���� Operator �Լ��� �������̽����� �ִ�.
	
	//	�������̽���				�߻� �޼ҵ�										����
	//
	//	BinaryOperator<T>		T apply(Tt, Tt)								T�� T�� ������ �� T ����
	//	UnaryOperator<T>		T apply(Tt)									T�� ������ �� T ����
	//	DoubleBinaryOperator	double applyAsDouble(double, double)		�� ���� double ����
	//	DoubleUnaryOperator		double applyAsDouble(double)				�� ���� double ����
	//	IntBinaryOperator		int applyAsInt(int, int)					�� ���� int ����
	//	IntUnaryOperator		int applyAsInt(int)							�� ���� int ����
	//	LongBinaryOperator		long applyAsLong(long, long)				�� ���� long ����
	//	LongUnaryOperator		long applyAsLong(long)						�� ���� long ����
	
	// IntBinaryOperator �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�.
	// applyAsInt() �޼ҵ�� �Ű������� �� ����  int�� �����Ƿ� ���ٽĵ� �� ���� int �Ű� ���� a�� b�� ����Ѵ�. �׸��� applyAsInt() �޼ҵ��� ���� Ÿ���� int�̹Ƿ� ���ٽ��� �߰�ȣ {}�� ���ϰ��� int�� �ȴ�.
	// ���� �ڵ�� �� ���� int�� �����ؼ� ��������� int�� �����Ѵ�.
	
	// IntBinaryOperator operator = (a, b) -> {...; return int��; }
	
	// ���� ������ int[] �迭���� �ִ밪�� �ּҰ��� ��´�. maxOrMin() �޼ҵ�� IntBinaryOperator �Ű� ������ ������ �ִ�. ���� maxOrMin() �޼ҵ带 ȣ���� �� ���ٽ��� ����� �� �ִ�.
	
			//	Predicate Functional Interface		Predicate �Լ��� �������̽�
	
	// Predicate �Լ��� �������̽��� �Ű� ������ boolean ���ϰ��� �ִ� testXXX() �޼ҵ带 ������ �ִ�.
	// �� �޼ҵ���� �Ű����� �����ؼ� true �Ǵ� false�� �����ϴ� ������ �Ѵ�.
	
	//					�Ű��� -> Predicate -> ���ϰ�
	
	// �Ű� ���� Ÿ�԰� ���� ���� �Ʒ��� ���� Predicate �Լ��� �������̽����� �ִ�.
	
	//	�������̽���			�߻� �޼ҵ�						����
	//
	//	Predicate<T>		boolean test(T t)			��ü T�� ����
	//	BiPredicate<T, U>	boolean test(T t, U u)		��ü T�� U�� ����
	//	DoublePredicate		boolean test(double value)	double ���� ����
	//	IntPredicate		boolean test(int value)		int ���� ����
	//	LongPredicate		boolean test(long value)	long ���� ����
	
	// Predicate<T> �������̽��� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�. test() �޼ҵ�� �Ű������� T ��ü �ϳ��� �����Ƿ� ���ٽĵ� �� ���� �Ű� ������ ����Ѵ�.
	// �׸���  test() �޼ҵ��� ���� Ÿ���� boolean�̹Ƿ� ���ٽ� �߰�ȣ {}�� ���ϰ��� boolean�� �ȴ�. T�� Student Ÿ���̹Ƿ� t �Ű� ���� Ÿ���� Student�� �ȴ�.
	// t.getSex()�� Student ��ü�� getSex() �޼ҵ带 ȣ���ؼ� "����" �Ǵ� "����"�� ��´�. �ᱹ ���� �ڵ�� String�� equals() �޼ҵ带 �̿��ؼ� ���л��� true�� ��´�.
	
	//	Predicate<Student> predicate = t -> { return t.getSex().equals("����"); }		�Ǵ�
	//	Predicate<Student> predicate = t -> t.getSex().equals("����");
	
	// ���� ������ List�� ����� ���� �Ǵ� ���� �л����� ��� ������ ����Ѵ�. avg() �޼ҵ�� Predicate<Student> �Ű� ������ ������ �ִ�. ���� avg() �޼ҵ带 ȣ���� �� �Ű������� ���ٽ��� ����� �� �ִ�.
	
			//	andThen() And compose() Default Method		andThen()�� compose() ����Ʈ �޼ҵ�
	
	// ����Ʈ �� ���� �޼ҵ�� �߻� �޼ҵ尡 �ƴϱ� ������ �Լ��� �������̽��� ����Ǿ ������ �Լ��� �������̽��� ������ ���� �ʴ´�
	// ���⼭ �Լ��� �������̽��� �����̶� �ϳ��� �߻� �޼ҵ带 ������ �ְ�, ���ٽ����� �͸� ���� ��ü�� ������ �� �ִ°��� ���Ѵ�.
	// java.util.function ��Ű���� �Լ��� �������̴� �ϳ� �̻��� ����Ʈ �� ���� �޼ҵ带 ������ �ִ�.
	
	// Consumer, Function, Operator ������ �Լ��� �������̽��� andThen()�� compose() ����Ʈ �޼ҵ带 ������ �ִ�.
	// andThen()�� compose() ����Ʈ �޼ҵ�� �� ���� �Լ��� �������̽��� ���������� �����ϰ�, ù ��° ó�� ����� �� ��° �Ű������� �����ؼ� ���� ������� ���� �� ����Ѵ�.
	// andThen()�� compose()�� �������� � �Լ��� �������̽����� ���� ó���ϴ����̴�. ���� ���� �ڵ带 ���鼭 andThen()���� ���캸��.
	
	//	�������̽�AB = �������̽�A.andThen(�������̽�B);
	//	������� = �������̽�AB.method();
	
	// �������̽�AB�� method()�� ȣ���ϸ� �켱 �������̽�A���� ó���ϰ� ����� �������̽�B�� �Ű����� �����Ѵ�. �������̽�B�� �������� �Ű����� ������ ó���� �� ���� ����� �����Ѵ�.
	
	//		�������̽�A			��		�������̽�B
	//		(���ٽ�)		andThen		(���ٽ�)
	//			��						��
	//		�������̽�AB				���� ���
	//		method()
	
	// �̹����� compose()�� ���캸��. �������̽�AB�� method()�� ȣ���ϸ� �켱 �������̽�B���� ó���ϰ� ����� �������̽�A�� �Ű������� �����Ѵ�. 
	// �������̽�A�� �������� �Ű����� ������ ó���� �� ���� ����� �����Ѵ�.
	
	//	�������̽�AB = �������̽�A.compose(�������̽�B);
	//	������� = �������̽�AB.method();
	
	//		�������̽�A			��		�������̽�B
	//		(���ٽ�)		compose		(���ٽ�)
	//			��						��
	//		�������̽�AB				���� ���
	//		method()
	
	// ������ andThen()�� compose() ����Ʈ �޼ҵ带 �����ϴ� java.util.function ��Ű���� �Լ��� �������̽����̴�.
	
	//	����			�Լ��� �������̽�				andThen()	compose()
	//
	//				Consumer<T>					o
	//				BiConsumer<T, U>			o
	//	Consumer	DoubleConsumer				o
	//				IntConsumer					o
	//				LongConsumer				o
	//
	//	Function	Function<T, R>				o			o
	//				BiFunction<T, U, R>			o
	//
	//				BinaryOperator<T>			o
	//	Operator	DoubleUnaryOperator			o			o
	//				IntUnaryOperator			o			o
	//				LongUnaryOperator			o			o
	
			/*	Sequential Connection Of Consumer		Consumer�� ������ ����	*/
	
	// Consumer ������ �Լ��� �������̽��� ó�� ����� �������� �ʱ� ������ andThen() ����Ʈ �޼ҵ�� �Լ��� �������̽��� ȣ�� ������ ���Ѵ�.
	// ���� ������ Consumer<Member> �Լ��� �������̽� �� ���� ���������� �����ؼ� �����Ѵ�. ù ��° Consumer<Member>�� �̸��� ����ϰ�, �� ��° Consumer<Member>�� ���̵� ����Ѵ�.
	
			/*	Sequential Connection Of Function		Function�� ������ ����	*/
	
	// Function�� Operator ������ �Լ��� �������̽��� ���� ������ �Լ��� �������̽��� ����� ���� �Լ��� �������̽��� �Ű������� �Ѱ��ְ�, ���� ó�� ����� �����Ѵ�.
	// ���� ��� Function<Member, Address>�� Function<Address, String>�� ���������� �����ؼ� Function<Member, String>�� �����Ѵٰ� �����غ���.
	// Function<Member, Address>�� �Ű������� �����Ǵ� Member�κ��� Address�� �����Ѵ�. Function<Address, String>�� �Ű������� �����Ǵ� Address�κ��� String�� �����Ѵ�.
	// �� ���� andThen()�̳� compose()�� �����ϸ� Function<Member, Address>���� ������ Address�� Function<Address, String>�� �Ű������� �Ѱܼ� 
	// ���� String Ÿ���� �����ϴ� Function<Member, String>�� ������ ����. ������ ���� ��������.
	
	//							����������������������������������������������������
	//							��						 ��
	//		Function<Member, Address>	+	Function<Address, String>
	//													�Ӥ�
	//										Function<Member, String>
	
	// Address�� �� �Լ��� �������̽� ���� ���� �������̴�. Address�� ���������� ���޵Ǳ� ������ ���� �Լ��� �������̽��� ���´� 
	// �Է� �����Ͱ� Member, ��� �����Ͱ� String�� �Ǵ� Function<Member, String>�� �ȴ�.
	// ���� ������ Member ��ü�� �ʵ��� Address���� city ������ ���� ���� �� Function �Լ��� �������̽��� andThen()�� compose()�� �̿��ؼ� ���������� �����ߴ�.
	// ���� �ڵ忡�� andThen() �޼ҵ带 ȣ���� �Լ��� �������̽��� functionA�̰�, compose() �޼ҵ带 ȣ���� �Լ��� �������̽��� functionB�̴�. 
	// ��� functionA���� �����ϰ� functionB�� ���߿� �����Ѵ�.
	
			//	and(), or(), negate() Default Method And isEqual() Static Method	and(), or(), negate() ����Ʈ �޼ҵ�� isEqual() ���� �޼ҵ�
	
	// Predicate ������ �Լ��� �������̽��� and(), or(), negate() ����Ʈ �޼ҵ带 ������ �ִ�. �� �޼ҵ���� ���� �� �������� &&, ||, !�� �����ȴٰ� �� �� �ִ�.
	// and() �޼ҵ�� �� Predicate�� ��� true�� �����ϸ� ���������� true�� �����ϴ� Predicate�� �����Ѵ�.
	// negate()�� ���� Predicate�� ����� true�̸� false��, false�̸� true�� �����ϴ� ���ο� Predicate�� �����Ѵ�.
	// ������ and(), or(), negate() ����Ʈ �޼ҵ带 �����ϴ� Predicate �Լ��� �������̽����̴�.
	
	//	����			�Լ��� �������̽�			and()	or()	negate()
	//
	//				Predicate<T>		o		o			o
	//				BiPredicate<T, U>	o		o			o
	//	Predicate	DoublePredicate		o		o			o
	//				IntPredicate		o		o			o
	//				LongPredicate		o		o			o
	
	// ���� ������ 2�� ����� 3�� ����� �����ϴ� �� Predicate�� �� ������ ���ο� Predicate�� �����Ѵ�.
	
	// Predicate<T> �Լ��� �������̽��� and(), or(), negate() ����Ʈ �޼ҵ� �̿ܿ� isEqual() ���� �޼ҵ带 �߰��� �����Ѵ�.
	// isEqual() �޼ҵ�� test() �Ű����� sourceObject�� isEqual()�� �Ű����� targetObject�� java.util.Object Ŭ������ equal()�� �Ű������� �����ϰ�,
	// Objects.equal(sourceObject, targetObject)�� ���ϰ��� ��� ���ο� Predicate<T>�� �����Ѵ�.
	
	//	Predicate<Object> predicate = Predicate.isEqual(targetObject);
	//	boolean result = predicate.test(sourceObject);		��
	//											���	���� ��	��	Object.equals(sourceObject, targetObject) ����
	
	// Object.equals(sourceObject, targetObject)�� ������ ���� ���ϰ��� �����Ѵ�.
	
	//	sourceObject	targetObject	���ϰ�
	//
	//	null			null			true
	//	not null		null			false
	//	null			not null		false
	//	not null		not null		sourceObject.equals(targetObject)�� ���ϰ�
	
	// ���� ������ �� ���ڿ��� ���ϱ� ���� Predicate�� isEqual() ���� �޼ҵ带 ����Ͽ���.
	
			//	minBy(), maxBy() Static Method		minBy(), maxBy() ���� �޼ҵ�
	
	// BinaryOperator<T> �Լ��� �������̽��� minBy()�� maxBy() ���� �޼ҵ带 �����Ѵ�. 
	// �� �� �޼ҵ�� �Ű������� �����Ǵ� Comparator�� �̿��ؼ� �ִ� T�� �ּ� T�� ��� BinaryOperator<T>�� �����Ѵ�.
	
	//	���� Ÿ��					���� �޼ҵ�
	//
	//	BinaryOperator<T>		minBy(Comparator<? super T> comparator)
	//	BinaryOperator<T>		maxBy(Comparator<? super T> comparator)
	
	// Comparator<T>�� ������ ���� ����� �Լ��� �������̽��̴�. o1�� o2�� ���ؼ� o1�� ������ ������, o1�� o2�� �����ϸ� 0��, o1�� ũ�� ����� �����ϴ� compare() �޼ҵ尡 ����Ǿ� �ִ�.
	
	//	@FunctionalInterface
	//	public interface Comparator<T> {
	//		public int comparator(T o1, T o2);
	//	}
	
	// Comparator<T>�� Ÿ�� Ÿ������ �ϴ� ���ٽ��� ������ ���� �ۼ��� �� �ִ�.
	
	//	(o1, o2) -> { ...; return int��; }
	
	// ���� o1�� o2�� int Ÿ���̶�� ������ ���� Integer.comparator(int, int) �޼ҵ带 �̿��� �� �ִ�.
	// Integer.comparator()�� ù ��° �Ű����� �� ��° �Ű������� ������ ����, ������ 0, ũ�� ����� �����Ѵ�.
	
	//	(o1, o2) -> Integer.comparator(o1, o2)
	
	// ���� ������ �� ������ ���� ���ؼ� ���� ���ų� ���� ������ ����.
}
