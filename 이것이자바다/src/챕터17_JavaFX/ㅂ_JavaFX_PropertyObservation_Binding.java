package é��17_JavaFX;

public class ��_JavaFX_PropertyObservation_Binding {
	// JavaFX�� ��Ʈ���� �Ӽ�(property)�� �����ϴ� �����ʸ� ������ �� �ִ�.
	// ���� ��� Slider�� value �Ӽ����� �����ϴ� �����ʸ� �����ؼ�, value �Ӽ����� ����Ǹ� �����ʰ� �ٸ� ��Ʈ�ѷ��� ��Ʈ�� �̹����� ũ�⸦ ������ �� �ִ�.
	
			//	Property Observation	�Ӽ� ����
	
	// JavaFX ��Ʈ�� �Ӽ��� �� ���� �޼ҵ�� �����ȴ�. Getter�� Setter �׸��� Property ��ü�� �����ϴ� �޼ҵ��̴�.
	// ���� ��� text �Ӽ��� getText(), setText(String newValue) �׸��� StringProperty�� �����ϴ� textProperty()�� ������ �ִ�.
	
	//	private StringProperty text = new SimpleStringProperty();		// ���� ����� �ʵ�
	//	public void setText(String newValue) { text.set(newValue); }	��
	//	public String getText() { return text.get(); }					�� Setter�� Getter
	//	public StringProperty textProperty() { return text; }			// Property �޼ҵ�
	
	// StringProperty�� get()�� set() �޼ҵ� �̿ܿ� �����ʸ� �����ϴ� �޼ҵ带 ������ �ִ�. ���� text �Ӽ��� �����ϴ� �����ʴ� textProperty()�� �����ϴ� StringProperty���� �����Ѵ�.
	// ������ text �Ӽ����� �����ϴ� ChangeListener�� �����ϴ� �ڵ��̴�.
	
	//	textProperty().addListener(new ChangeListener<String>() {
	//		@Override
	//		public void change(ObservableValue<? extends String> observable,
	//							String oldValue, String newValue) {
	//		}
	//	});
	
	// addListener() �޼ҵ尡 ChangeListener�� Property ��ü�� �����ϸ�, text �Ӽ��� ����Ǿ��� �� ChangeListener�� changed() �޼ҵ尡 �ڵ����� ����ȴ�.
	// �Ӽ��� ���� ���� oldValue��, ���ο� ���� newValue�� �Ű������� ���޵ȴ�. ChageListener�� ���׸� Ÿ���ε�, Ÿ�� �Ķ���ʹ� �Ӽ��� Ÿ���� �ȴ�.
	// ���� ��� textProperty()�� �����ϴ� StringProperty�� Property<String>�� �����ϰ� �ֱ� ������ Ÿ�� �Ķ���ʹ� String�� �ȴ�.
	// ���� oldValue�� newValue�� Ÿ���� String�� �ȴ�. �ٸ� ���� ����. Slider�� value �Ӽ��� �����ʸ� �����Ϸ��� ������ ���� �ۼ��ϸ� �ȴ�.
	
	//	Slider slider = new Slider();
	//	slider.valueProperty().addListener( new ChangeListener<Number>() {
	//		@Override
	//		public void change(ObservableValue<? extends Number> observable,
	//							Number oldValue, Number newValue) {
	//		}
	//	});
	
	// valueProperty()�� �����ϴ� DoubleProperty�� Property<Number>�� �����ϰ� �ֱ� ������ ChangeListener�� Ÿ�� �Ķ���ʹ� Number�� �ȴ�.
	// JavaFX API ��ť��Ʈ�� ���� java.beans.property ��Ű������ StringProperty, DoubleProperty �̿ܿ��� �پ��� Property ���� Ŭ������ �����ϴ� ���� �� �� �ִ�.
	// ���� ������ Slider�� value �Ӽ��� �����ؼ� value �Ӽ����� ����Ǹ� Label�� ��Ʈ ũ�⸦ �����ϵ��� �����ʸ� �����ߴ�.
	
			//	Property Binding	�Ӽ� ���ε�
	
	// JavaFX �Ӽ��� �ٸ� �Ӽ��� ���ε��� �� �ִ�. ���ε��� �Ӽ����� �ϳ��� ����Ǹ�  �ڵ������� �ٸ� �ϳ��� ����ȴ�.
	// ���� ��� �� ���� TextArea ��Ʈ���� �ְ� text �Ӽ����� ���ε��ϸ� ����ڰ� ������ TextArea�� ������ �Է����� �� �ٸ��� TextArea�� ������ �������� �ڵ� �Էµȴ�.
	// �Ӽ��� ���ε��ϱ� ���ؼ��� xxxProperty() �޼ҵ尡 �����ϴ� Property ���� ��ü�� bind() �޼ҵ带 �̿��ϸ� �ȴ�.
	// ���� ��� textArea1���� �Էµ� ������ textArea2�� �ڵ����� �Էµǵ��� �Ϸ��� ������ ���� �ۼ��ϸ� �ȴ�.
	
	//	TextArea textArea1 = new TextArea();
	//	TextArea textArea2 = new TExtArea();
	//	textArea2.textProperty().bind(textArea1.textProperty());
	
	// bind() �޼ҵ�� �ܹ����ε�, textArea1���� �Էµ� ���븸 textArea2�� �ڵ� �Էµǰ�, �ݴ�� textArea2���� �Էµ� ������ textArea1�� �ڵ� �зµ��� �ʴ´�.
	// �ƿ� textArea2�� �Է����� �� �� ����. ���� ��������� ���ε��ϰ� �ʹٸ� bind() �޼ҵ� ��� bindBidirectional() �޼ҵ带 �̿��ϰų� Bindings.bindBidirectional() �޼ҵ带 �̿��ϸ� �ȴ�.
	
	//	textArea2.textProperty().bindBidirectional(textArea1.textProperty());
	//	Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
	
	// ���ε��� �Ӽ��� ����̵��Ϸ��� ���� �޼ҵ带 �̿��ϸ� �ȴ�.
	
	//	textArea2.textProperty().unbind();		// �ܹ��� ����
	//	textArea2.textProperty().unbindBidirectional(textArea1.textProperty());		// ����� ����
	//	Bindings.unbindBidirectional(textArea1.textProperty(), textArea2.textProperty());	// ����� ����
	
	// ���� ������ text �Ӽ����� �� ���� TextArea ��Ʈ���� ��������� ���ε��Ͽ���.
	
			//	Bindings Class
	
	// �� �Ӽ��� �׻� ������ ���� Ÿ���� ���� ���� ����. ���� �Ӽ����� �ٸ��� �Ӽ����� ���������� ���ؼ��� ���� �۾��� �ʿ��� ���� �ִ�.
	// ���� ��� �������� ũ�⿡ ������� �׻� ȭ�� ���߾ӿ� ���� �׸��ٰ� �����غ���. ��Ʈ �����̳� ���� 1/2�� ���� X��ǥ�� �ǰ�, ��Ʈ �����̳� ������ 1/2�� ���� Y��ǥ�� �� ���̴�.
	// ���� ��Ʈ �����̳��� ���� ���̸� ���� �߽ɰ� ���ε��ϱ� ���ؼ��� 1/2��� ������ �ʿ��ϴ�. �̶� ����� �� �ִ� ���� Bindings Ŭ������ �����ϴ� ���� �޼ҵ���̴�.
	// Bindings�� ���� �޼ҵ�� �Ӽ��� �����ϰų�, �ٸ� Ÿ������ ��ȯ �� ���ε��ϴ� ����� �����Ѵ�. ������ Bindings Ŭ������ �����ϴ� ���� �޼ҵ���� ������ ǥ�̴�.
	
	//	�޼ҵ�						����		
	//
	//	add, substract,				�Ӽ����� ����, ����, ����, ������ ������ �����ϰ� ���ε���
	//	multiply, divide
	//
	//	max, min					�Ӽ����� � ���� ���ؼ� �ִ�, �ּҰ��� ��� ���ε���
	//
	//	greaterThan,				�Ӽ����� � ������ ū��, ���ų� ū���� �����ؼ� true/false�� ��ȯ�Ͽ� ���ε���
	//	greaterThanOrEqual
	//	
	//	lessThan, lessThanOrEqual	�Ӽ����� � ������ �۰ų�, ���ų� �������� �����ؼ� true/false�� ��ȯ�Ͽ� ���ε���
	//
	//	equal, notEquals			�Ӽ����� � ���� ������, �ٸ����� �����ؼ� true/false�� ��ȯ�Ͽ� ���ε���
	//
	//	equalIgnoreCase,			�빮�ڿ� ������� �Ӽ����� � ���ڿ��� ������, �ٸ����� �����ؼ� true/false�� ��ȯ�Ͽ� ���ε���
	//	notEqualIgnoreCase
	//
	//	isEmpty, isNotEmpty			�Ӽ����� ����ִ���, �ƴ����� �����ؼ� true/false�� ��ȯ�Ͽ� ���ε���
	//
	//	isNull, isNotNull			�Ӽ����� null �Ǵ� not null������ �����ؼ� true/false�� ��ȯ�Ͽ� ���ε���
	//
	//	length						�Ӽ����� ���ڿ��� ��� ���� ���� ��� ���ε���
	//
	//	size						�Ӽ� Ÿ���� �迭, List, Map, Set�� ��� ��� ���� ��� ���ε���
	//
	//	and, or						�Ӽ����� boolean�� ���, ����, ������ ��� ���ε���
	//
	//	not							�Ӽ����� boolean�� ���, �ݴ밪���� ���ε���
	//
	//	convent						�Ӽ����� ���ڿ��� ��ȯ�ؼ� ���ε���
	//
	//	valueAt						�Ӽ��� List, Map�� ��� �ش� �ε��� �Ǵ� Ű�� ���� ��� ���ε���
	
	// ������ ������ â�� ũ�Ⱑ ����Ǵ��� �׻� ȭ�� ���߾ӿ� ���� �׸��� �����̴�. ��Ʈ �����̳��� ���� ���̸� ���� �߽ɰ� ���ε��ϱ� ���� 1/2 ������ �ؾ� �ϹǷ� Bindings.divide() �޼ҵ带 �̿��Ͽ���.
	
}	
