package 챕터17_JavaFX;

public class ㅁ_JavaFX_Event {
	// UI 애플리케이션은 사용자와 상호작용을 하면서 코드를 실행한다. 사용자가 UI 컨트롤을 사용하면 이벤트(event)가 발생하고 프로그램은 이벤트를 처리하기 위해 코드를 실행한다.
	
			//	EventHandler
	
	// JavaFX는 이벤트 발생 컨트롤과 이벤트 핸들러(EventHandler)를 분리하는 위임형(Delegation) 방식을 사용한다.
	// 위임형 방식이란 컨트롤에서 이벤트가 발생하면, 컨트롤이 직접 처리하지 않고 이벤트 핸들러에게 이벤트 처리를 위임하는 방식이다.
	// 예를 들어 사용자가 Button을 클릭하면 ActionEvent가 발생하고, Button에 등록된 EventHandler가 ActionEvent를 처리한다.
	
	//			┌───────────────────────┐						┌───────────────────────────┐
	//			│				  - ㅁ x	│						│		이벤트 핸들러			│
	//			│	 					│──	2	ActionEvent ──→	│		(EventHandler)		│
	//			│	     이벤트 발생 컨트롤		│		이벤트 발생			│							│	
	//			│		(Button)		│						│		이벤트 처리 메소드			│
	//			│			1			│						│			실행				│
	//			│						│						│							│
	//			│						│	4 이벤트 처리 효과			│	public void handle(..) {│
	//			│					   ←│───────────────────────│─	←	↓ 3 이벤트 처리			│
	//			└───────────────────────┘	1.윈도우 닫기			│	}						│
	//										2.컨트롤 내용 변경		└───────────────────────────┘
	//										3.다이얼로그 띄우기
	
	// EventHandler는 컨트롤에서 이벤트가 발생하면, 자신의 handle() 메소드를 실행시킨다. handle() 메소드에는 윈도우 닫기, 컨트롤 내용 변경, 다이얼로그 띄우기 등의 다양한 코드를 작성할 수 있다.
	// EventHandler는 제네릭 타입이기 때문에 타입 파라미터는 발생된 이벤트의 타입이 된다. 예를들어 ActionEvent를 처리하는 핸들러는 EventHander<ActionEvent>가 되고,
	// MouseEvent를 처리하는 핸들러는 EventHandler<MouseEvent>가 된다.
	
	// EventHandler가 컨트롤에서 발생된 이벤트를 처리하려면 먼저 컨트롤에 EventHandler를 등록해야 한다.
	// 컨트롤은 발생되는 이벤트에 따라서 EventHandler를 등록하는 다양한 메소드가 있는데, 이 메소드들은 setOnXXX() 이름을 가지고 있다. XXX는 보통 이벤트 이름과 동일하다. 몇 가지 예를 들어보자.
	// Button을 클릭할 때 발생하는 ActionEvent를 처리하는 EventHandler<ActionEvent>를 등록하려면 다음과 같이 setOnAction() 메소드를 사용한다.
	
	//	Button button = new Button();
	//	button.setOnAction(new EventHadler<ActionEvent>() {
	//		@Override
	//		public void handle(ActionEvent event) {...}
	//	});
	
	// TableView의 행을 클릭할 때 발생하는 MouseEvent를 처리하는 EventHandler<MouseEvent>를 등록하려면 다음과 같이 setOnMouseClicked() 메소드를 사용한다.
	
	//	TableView tableView = new TalbeView();
	//	tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
	//		@Override
	//		public void handle(MouseEvent even) {...}
	//	});
	
	// 윈도우(Stage)의 우측 상단 닫기(x) 버튼을 클릭했을 때 발생하는 WindowEvent를 처리하는 EventHandler<WindowEvent>를 등록하려면 다음과 같이 setOnCloseRequest() 메소드를 사용한다.
	
	//	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	//		@Override
	//		public void handle(WindowEvent event) {...}
	//	});
	
	// EventHandler는 하나의 메소드를 가진 함수적 인터페이스이므로 람다식을 이용하면 보다 적은 코드로 EventHandler를 등록할 수 있다.
	
	//	button.setOnAction( event -> {...} );
	//	tableView.setOnMouseClicked( event -> {...} );
	//	stage.setOnCloseRequest( event -> {...} );
	
	// 다음은 프로그램적 레이아웃을 작성하고, 버튼의 ActionEvent를 처리한 것이다. 첫 번째 버튼은 직접 EventHandler 객체를 생성한 후 등록했고, 두 번째 버튼은 람다식을 이용해서 EventHandler를 등록했다.
	
			//	FXML Controller
	
	// 프로그램적 레이아웃은 레이아웃 코드와 이벤트 처리 코드를 모두 자바 코드로 작성해야 하므로 코드가 복잡해지고, 유지보수도 힘들어지며, 디자이너와 협력해서 개발하는 것도 쉽지 않다.
	// FXML 페이아웃은 FXML 파일당 별도의 컨트롤러를 지정해서 이벤트를 처리할 수 있기 때문에 FXML 레이아웃과 이벤트 처리 코드를 완전히 분리할 수 있다.
	
			/*	fx:controller Properties And Controller Class		fx:controller 속성과 컨트롤러 클래스	*/
	
	// FXML 파일의 루트 태그에서 fx:controller 속성으로 컨트롤러를 지정하면 UI 컨트롤에서 발생하는 이벤트를 컨트롤러가 처리한다.
	
	//	<루트컨테이너 xmlns:fx="http://javafx.com/fxml"
	//		fx:controller="packageName.ControllerName" >
	//		...
	//	</루트컨테이너>
	
	// 컨트롤러는 다음과 같이 Initializable 인터페이스를 구현한 클래스로 작성하면 된다.
	
	//	public class ControllerName implements Initializable {
	//		@Override
	//		public void initialize(URL location, ResourceBundle resources) { }
	//	}
	
	// initialize() 메소드는 컨트롤러 객체가 생성되고 나서 호출되는데, 주로 UI 컨트롤의 초기화, 이벤트 핸들러 등록, 속성 감시 등의 코드가 작성된다.
	
			/*	fx:id Properties And @FXML Control Infuse		fx:id 속성과 @FXML 컨트롤 주입		*/
	
	// 컨트롤러는 이벤트 핸들러를 등록하기 위해서, 그리고 이벤트 처리 시 UI를 변경하기 위해서 FXML 파일에 포함된 컨테이너 및 컨트롤의 참조가 필요하다.
	// 이를 위해서 FXML 파일에 포함된 컨트롤들은 fx:id 속성을 가질 필요가 있다.
	
	// fx:id 속성을 가진 컨트롤들은 컨트롤러의 @FXML 어노테이션이 적용된 필드에 자동 주입된다. 주의할 점은 fx:id 속성값과 필드명은 동일해야 한다.
	
	//	public class controllerName implements Initializeable {
	//		@FXML private Button btn1;
	//		@FXML private Button btn2;
	//		@FXML private Button btn3;
	//		@Override
	//		public void initialize(URL location, ResourceBundle resources) { }
	//	}
	
	// FXMLLoader가 FXML 파일을 로딩할 때, 태그로 선언된 컨트롤 객체가 생성되고, 아울러 컨트롤러 객체도 함께 생성된다.
	// 그리고 나서 @FXML 어노테이션이 적용된 필드에 컨트롤 객체가 자동 주입된다. 주입이 완료되면 비로소 initialize() 메소드가 호출되기 때문에 initialize() 내부에서 필드를 안전하게 사용할 수 있다.
	
			/*	EventHandler Registration	EventHandler 등록		*/
	
	// 컨트롤에서 발생하는 이벤트를 처리하려면 컨트롤러의 initialize() 메소드에서 EventHandler를 생성하고 등록해야 한다.
	// 다음은 세 개의 Button에서 발생하는 ActionEvent를 처리하는 방법을 보여준다.
	
			/*	Event Handling Method Mapping		이벤트 처리 메소드 매핑		*/
	
	// 컨트롤러에서 EventHandler를 생성하지 않고도 바로 이벤트 처리 메소드와 연결할 수 있는 방법이 있다. Button 컨트롤을 작성할 때 다음과 같이 onAction 속성값으로 "#메소드명"을 주면
	// 내부적으로 EventHandler 객체가 생성되기 때문에 컨트롤러에서는 해당 메소드만 작성하면 된다.
	
	//	[FXML 파일]
	//	<Button fx:id="btn" text="버튼" onAction="#handleBtnAction" />
	
	//	[Controller 클래스]
	//	<public void handleBtnActon(ActonEvent event) {...}
}
