package 챕터17_JavaFX;

public class ㅂ_JavaFX_PropertyObservation_Binding {
	// JavaFX는 컨트롤의 속성(property)을 감시하는 리스너를 설정할 수 있다.
	// 예를 들어 Slider의 value 속성값을 감시하는 리스너를 설정해서, value 속성값이 변경되면 리스너가 다른 컨트롤러의 폰트나 이미지의 크기를 변경할 수 있다.
	
			//	Property Observation	속성 감시
	
	// JavaFX 컨트롤 속성은 세 가지 메소드로 구성된다. Getter와 Setter 그리고 Property 객체를 리턴하는 메소드이다.
	// 예를 들어 text 속성은 getText(), setText(String newValue) 그리고 StringProperty를 리턴하는 textProperty()를 가지고 있다.
	
	//	private StringProperty text = new SimpleStringProperty();		// 값이 저장될 필드
	//	public void setText(String newValue) { text.set(newValue); }	┐
	//	public String getText() { return text.get(); }					┘ Setter와 Getter
	//	public StringProperty textProperty() { return text; }			// Property 메소드
	
	// StringProperty는 get()과 set() 메소드 이외에 리스너를 관리하는 메소드를 가지고 있다. 따라서 text 속성을 감시하는 리스너는 textProperty()가 리턴하는 StringProperty에서 설정한다.
	// 다음은 text 속성값을 감시하는 ChangeListener를 설정하는 코드이다.
	
	//	textProperty().addListener(new ChangeListener<String>() {
	//		@Override
	//		public void change(ObservableValue<? extends String> observable,
	//							String oldValue, String newValue) {
	//		}
	//	});
	
	// addListener() 메소드가 ChangeListener를 Property 객체에 설정하면, text 속성이 변경되었을 때 ChangeListener의 changed() 메소드가 자동으로 실행된다.
	// 속성의 이전 값은 oldValue에, 새로운 값은 newValue에 매개값으로 전달된다. ChageListener는 제네릭 타입인데, 타입 파라미터는 속성의 타입이 된다.
	// 예를 들어 textProperty()가 리턴하는 StringProperty는 Property<String>을 구현하고 있기 때문에 타입 파라미터는 String이 된다.
	// 따라서 oldValue와 newValue의 타입은 String이 된다. 다른 예를 보자. Slider의 value 속성에 리스너를 설정하려면 다음과 같이 작성하면 된다.
	
	//	Slider slider = new Slider();
	//	slider.valueProperty().addListener( new ChangeListener<Number>() {
	//		@Override
	//		public void change(ObservableValue<? extends Number> observable,
	//							Number oldValue, Number newValue) {
	//		}
	//	});
	
	// valueProperty()가 리턴하는 DoubleProperty가 Property<Number>를 구현하고 있기 때문에 ChangeListener의 타입 파라미터는 Number가 된다.
	// JavaFX API 도큐먼트를 보면 java.beans.property 패키지에는 StringProperty, DoubleProperty 이외에도 다양한 Property 구현 클래스가 존재하는 것을 알 수 있다.
	// 다음 예제는 Slider의 value 속성을 감시해서 value 속성값이 변경되면 Label의 폰트 크기를 변경하도록 리스너를 설정했다.
	
			//	Property Binding	속성 바인딩
	
	// JavaFX 속성은 다른 속성과 바인딩될 수 있다. 바인딩된 속성들은 하나가 변경되면  자동적으로 다른 하나도 변경된다.
	// 예를 들어 두 개의 TextArea 컨트롤이 있고 text 속성들은 바인딩하면 사용자가 한쪽의 TextArea에 내용을 입력했을 때 다른쪽 TextArea도 동일한 내용으로 자동 입력된다.
	// 속성을 바인딩하기 위해서는 xxxProperty() 메소드가 리턴하는 Property 구현 객체의 bind() 메소드를 이용하면 된다.
	// 예를 들어 textArea1에서 입력된 내용이 textArea2에 자동으로 입력되도록 하려면 다음과 같이 작성하면 된다.
	
	//	TextArea textArea1 = new TextArea();
	//	TextArea textArea2 = new TExtArea();
	//	textArea2.textProperty().bind(textArea1.textProperty());
	
	// bind() 메소드는 단방향인데, textArea1에서 입력된 내용만 textArea2로 자동 입력되고, 반대로 textArea2에서 입력된 내용은 textArea1로 자동 압력되지 않는다.
	// 아예 textArea2는 입력조차 할 수 없다. 만약 양방향으로 바인딩하고 싶다면 bind() 메소드 대신 bindBidirectional() 메소드를 이용하거나 Bindings.bindBidirectional() 메소드를 이용하면 된다.
	
	//	textArea2.textProperty().bindBidirectional(textArea1.textProperty());
	//	Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
	
	// 바인딩된 속성을 언바이드하려면 다음 메소드를 이용하면 된다.
	
	//	textArea2.textProperty().unbind();		// 단방향 헤제
	//	textArea2.textProperty().unbindBidirectional(textArea1.textProperty());		// 양방향 해제
	//	Bindings.unbindBidirectional(textArea1.textProperty(), textArea2.textProperty());	// 양방향 해제
	
	// 다음 예제는 text 속성으로 두 개의 TextArea 컨트롤을 양방향으로 바인딩하였다.
	
			//	Bindings Class
	
	// 두 속성이 항상 동일한 값과 타입을 가질 수는 없다. 한쪽 속성값이 다른쪽 속성값과 동일해지기 위해서는 연산 작업이 필요할 수도 있다.
	// 예를 들어 윈도우의 크기에 상관없이 항상 화면 정중앙에 원을 그린다고 가정해보자. 루트 컨테이너 폭의 1/2이 원의 X좌표가 되고, 루트 컨테이너 높이의 1/2이 원의 Y좌표가 될 것이다.
	// 따라서 루트 컨테이너의 폭과 높이를 원의 중심과 바인딩하기 위해서는 1/2라는 연산이 필요하다. 이때 사용할 수 있는 것이 Bindings 클래스가 제공하는 정적 메소드들이다.
	// Bindings의 정적 메소드는 속성을 연산하거나, 다른 타입으로 변환 후 바인딩하는 기능을 제공한다. 다음은 Bindings 클래스가 제공하는 정적 메소드들을 설명한 표이다.
	
	//	메소드						설명		
	//
	//	add, substract,				속성값에 덧셈, 뺄셈, 곱셈, 나눗셈 연산을 수행하고 바인딩함
	//	multiply, divide
	//
	//	max, min					속성값과 어떤 수를 비교해서 최대, 최소값을 얻고 바인딩함
	//
	//	greaterThan,				속성값이 어떤 값보다 큰지, 같거나 큰지를 조사해서 true/false로 변환하여 바인딩함
	//	greaterThanOrEqual
	//	
	//	lessThan, lessThanOrEqual	속성값이 어떤 값보다 작거나, 같거나 작은지를 조사해서 true/false로 변환하여 바인딩함
	//
	//	equal, notEquals			속성값이 어떤 값과 같은지, 다른지를 조사해서 true/false로 변환하여 바인딩함
	//
	//	equalIgnoreCase,			대문자와 상관없이 속성값이 어떤 문자열과 같은지, 다른지를 조사해서 true/false로 변환하여 바인딩함
	//	notEqualIgnoreCase
	//
	//	isEmpty, isNotEmpty			속성값이 비어있는지, 아닌지를 조사해서 true/false로 변환하여 바인딩함
	//
	//	isNull, isNotNull			속성값이 null 또는 not null인지를 조사해서 true/false로 변환하여 바인딩함
	//
	//	length						속성값이 문자열일 경우 문자 수를 얻어 바인딩함
	//
	//	size						속성 타입이 배열, List, Map, Set일 경우 요소 수를 얻어 바인딩함
	//
	//	and, or						속성값이 boolean일 경우, 논리곱, 논리합을 얻어 바인딩함
	//
	//	not							속성값이 boolean일 경우, 반대값으로 바인딩함
	//
	//	convent						속성값을 문자열로 변환해서 바인딩함
	//
	//	valueAt						속성이 List, Map일 경우 해당 인덱스 또는 키의 값을 얻어 바인딩함
	
	// 다음은 윈도우 창의 크기가 변경되더라도 항상 화면 정중앙에 원을 그리는 예제이다. 루트 컨테이너의 폭과 높이를 원의 중심과 바인딩하기 위해 1/2 연산을 해야 하므로 Bindings.divide() 메소드를 이용하였다.
	
}	
