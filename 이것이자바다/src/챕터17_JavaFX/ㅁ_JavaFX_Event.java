package é��17_JavaFX;

public class ��_JavaFX_Event {
	// UI ���ø����̼��� ����ڿ� ��ȣ�ۿ��� �ϸ鼭 �ڵ带 �����Ѵ�. ����ڰ� UI ��Ʈ���� ����ϸ� �̺�Ʈ(event)�� �߻��ϰ� ���α׷��� �̺�Ʈ�� ó���ϱ� ���� �ڵ带 �����Ѵ�.
	
			//	EventHandler
	
	// JavaFX�� �̺�Ʈ �߻� ��Ʈ�Ѱ� �̺�Ʈ �ڵ鷯(EventHandler)�� �и��ϴ� ������(Delegation) ����� ����Ѵ�.
	// ������ ����̶� ��Ʈ�ѿ��� �̺�Ʈ�� �߻��ϸ�, ��Ʈ���� ���� ó������ �ʰ� �̺�Ʈ �ڵ鷯���� �̺�Ʈ ó���� �����ϴ� ����̴�.
	// ���� ��� ����ڰ� Button�� Ŭ���ϸ� ActionEvent�� �߻��ϰ�, Button�� ��ϵ� EventHandler�� ActionEvent�� ó���Ѵ�.
	
	//			��������������������������������������������������						����������������������������������������������������������
	//			��				  - �� x	��						��		�̺�Ʈ �ڵ鷯			��
	//			��	 					������	2	ActionEvent ������	��		(EventHandler)		��
	//			��	     �̺�Ʈ �߻� ��Ʈ��		��		�̺�Ʈ �߻�			��							��	
	//			��		(Button)		��						��		�̺�Ʈ ó�� �޼ҵ�			��
	//			��			1			��						��			����				��
	//			��						��						��							��
	//			��						��	4 �̺�Ʈ ó�� ȿ��			��	public void handle(..) {��
	//			��					   �禢��������������������������������������������������	��	�� 3 �̺�Ʈ ó��			��
	//			��������������������������������������������������	1.������ �ݱ�			��	}						��
	//										2.��Ʈ�� ���� ����		����������������������������������������������������������
	//										3.���̾�α� ����
	
	// EventHandler�� ��Ʈ�ѿ��� �̺�Ʈ�� �߻��ϸ�, �ڽ��� handle() �޼ҵ带 �����Ų��. handle() �޼ҵ忡�� ������ �ݱ�, ��Ʈ�� ���� ����, ���̾�α� ���� ���� �پ��� �ڵ带 �ۼ��� �� �ִ�.
	// EventHandler�� ���׸� Ÿ���̱� ������ Ÿ�� �Ķ���ʹ� �߻��� �̺�Ʈ�� Ÿ���� �ȴ�. ������� ActionEvent�� ó���ϴ� �ڵ鷯�� EventHander<ActionEvent>�� �ǰ�,
	// MouseEvent�� ó���ϴ� �ڵ鷯�� EventHandler<MouseEvent>�� �ȴ�.
	
	// EventHandler�� ��Ʈ�ѿ��� �߻��� �̺�Ʈ�� ó���Ϸ��� ���� ��Ʈ�ѿ� EventHandler�� ����ؾ� �Ѵ�.
	// ��Ʈ���� �߻��Ǵ� �̺�Ʈ�� ���� EventHandler�� ����ϴ� �پ��� �޼ҵ尡 �ִµ�, �� �޼ҵ���� setOnXXX() �̸��� ������ �ִ�. XXX�� ���� �̺�Ʈ �̸��� �����ϴ�. �� ���� ���� ����.
	// Button�� Ŭ���� �� �߻��ϴ� ActionEvent�� ó���ϴ� EventHandler<ActionEvent>�� ����Ϸ��� ������ ���� setOnAction() �޼ҵ带 ����Ѵ�.
	
	//	Button button = new Button();
	//	button.setOnAction(new EventHadler<ActionEvent>() {
	//		@Override
	//		public void handle(ActionEvent event) {...}
	//	});
	
	// TableView�� ���� Ŭ���� �� �߻��ϴ� MouseEvent�� ó���ϴ� EventHandler<MouseEvent>�� ����Ϸ��� ������ ���� setOnMouseClicked() �޼ҵ带 ����Ѵ�.
	
	//	TableView tableView = new TalbeView();
	//	tableView.setOnMouseClicked(new EventHandler<MouseEvent>() {
	//		@Override
	//		public void handle(MouseEvent even) {...}
	//	});
	
	// ������(Stage)�� ���� ��� �ݱ�(x) ��ư�� Ŭ������ �� �߻��ϴ� WindowEvent�� ó���ϴ� EventHandler<WindowEvent>�� ����Ϸ��� ������ ���� setOnCloseRequest() �޼ҵ带 ����Ѵ�.
	
	//	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	//		@Override
	//		public void handle(WindowEvent event) {...}
	//	});
	
	// EventHandler�� �ϳ��� �޼ҵ带 ���� �Լ��� �������̽��̹Ƿ� ���ٽ��� �̿��ϸ� ���� ���� �ڵ�� EventHandler�� ����� �� �ִ�.
	
	//	button.setOnAction( event -> {...} );
	//	tableView.setOnMouseClicked( event -> {...} );
	//	stage.setOnCloseRequest( event -> {...} );
	
	// ������ ���α׷��� ���̾ƿ��� �ۼ��ϰ�, ��ư�� ActionEvent�� ó���� ���̴�. ù ��° ��ư�� ���� EventHandler ��ü�� ������ �� ����߰�, �� ��° ��ư�� ���ٽ��� �̿��ؼ� EventHandler�� ����ߴ�.
	
			//	FXML Controller
	
	// ���α׷��� ���̾ƿ��� ���̾ƿ� �ڵ�� �̺�Ʈ ó�� �ڵ带 ��� �ڹ� �ڵ�� �ۼ��ؾ� �ϹǷ� �ڵ尡 ����������, ���������� ���������, �����̳ʿ� �����ؼ� �����ϴ� �͵� ���� �ʴ�.
	// FXML ���̾ƿ��� FXML ���ϴ� ������ ��Ʈ�ѷ��� �����ؼ� �̺�Ʈ�� ó���� �� �ֱ� ������ FXML ���̾ƿ��� �̺�Ʈ ó�� �ڵ带 ������ �и��� �� �ִ�.
	
			/*	fx:controller Properties And Controller Class		fx:controller �Ӽ��� ��Ʈ�ѷ� Ŭ����	*/
	
	// FXML ������ ��Ʈ �±׿��� fx:controller �Ӽ����� ��Ʈ�ѷ��� �����ϸ� UI ��Ʈ�ѿ��� �߻��ϴ� �̺�Ʈ�� ��Ʈ�ѷ��� ó���Ѵ�.
	
	//	<��Ʈ�����̳� xmlns:fx="http://javafx.com/fxml"
	//		fx:controller="packageName.ControllerName" >
	//		...
	//	</��Ʈ�����̳�>
	
	// ��Ʈ�ѷ��� ������ ���� Initializable �������̽��� ������ Ŭ������ �ۼ��ϸ� �ȴ�.
	
	//	public class ControllerName implements Initializable {
	//		@Override
	//		public void initialize(URL location, ResourceBundle resources) { }
	//	}
	
	// initialize() �޼ҵ�� ��Ʈ�ѷ� ��ü�� �����ǰ� ���� ȣ��Ǵµ�, �ַ� UI ��Ʈ���� �ʱ�ȭ, �̺�Ʈ �ڵ鷯 ���, �Ӽ� ���� ���� �ڵ尡 �ۼ��ȴ�.
	
			/*	fx:id Properties And @FXML Control Infuse		fx:id �Ӽ��� @FXML ��Ʈ�� ����		*/
	
	// ��Ʈ�ѷ��� �̺�Ʈ �ڵ鷯�� ����ϱ� ���ؼ�, �׸��� �̺�Ʈ ó�� �� UI�� �����ϱ� ���ؼ� FXML ���Ͽ� ���Ե� �����̳� �� ��Ʈ���� ������ �ʿ��ϴ�.
	// �̸� ���ؼ� FXML ���Ͽ� ���Ե� ��Ʈ�ѵ��� fx:id �Ӽ��� ���� �ʿ䰡 �ִ�.
	
	// fx:id �Ӽ��� ���� ��Ʈ�ѵ��� ��Ʈ�ѷ��� @FXML ������̼��� ����� �ʵ忡 �ڵ� ���Եȴ�. ������ ���� fx:id �Ӽ����� �ʵ���� �����ؾ� �Ѵ�.
	
	//	public class controllerName implements Initializeable {
	//		@FXML private Button btn1;
	//		@FXML private Button btn2;
	//		@FXML private Button btn3;
	//		@Override
	//		public void initialize(URL location, ResourceBundle resources) { }
	//	}
	
	// FXMLLoader�� FXML ������ �ε��� ��, �±׷� ����� ��Ʈ�� ��ü�� �����ǰ�, �ƿ﷯ ��Ʈ�ѷ� ��ü�� �Բ� �����ȴ�.
	// �׸��� ���� @FXML ������̼��� ����� �ʵ忡 ��Ʈ�� ��ü�� �ڵ� ���Եȴ�. ������ �Ϸ�Ǹ� ��μ� initialize() �޼ҵ尡 ȣ��Ǳ� ������ initialize() ���ο��� �ʵ带 �����ϰ� ����� �� �ִ�.
	
			/*	EventHandler Registration	EventHandler ���		*/
	
	// ��Ʈ�ѿ��� �߻��ϴ� �̺�Ʈ�� ó���Ϸ��� ��Ʈ�ѷ��� initialize() �޼ҵ忡�� EventHandler�� �����ϰ� ����ؾ� �Ѵ�.
	// ������ �� ���� Button���� �߻��ϴ� ActionEvent�� ó���ϴ� ����� �����ش�.
	
			/*	Event Handling Method Mapping		�̺�Ʈ ó�� �޼ҵ� ����		*/
	
	// ��Ʈ�ѷ����� EventHandler�� �������� �ʰ� �ٷ� �̺�Ʈ ó�� �޼ҵ�� ������ �� �ִ� ����� �ִ�. Button ��Ʈ���� �ۼ��� �� ������ ���� onAction �Ӽ������� "#�޼ҵ��"�� �ָ�
	// ���������� EventHandler ��ü�� �����Ǳ� ������ ��Ʈ�ѷ������� �ش� �޼ҵ常 �ۼ��ϸ� �ȴ�.
	
	//	[FXML ����]
	//	<Button fx:id="btn" text="��ư" onAction="#handleBtnAction" />
	
	//	[Controller Ŭ����]
	//	<public void handleBtnActon(ActonEvent event) {...}
}
