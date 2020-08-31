package é��17_JavaFX;

public class ��_JavaFX_Dialog {
	// ���̾�α�(Dialog)�� �� �����쿡�� �˸� �Ǵ� ������� �Է��� ���ؼ� ����Ǵ� ���� �������� �� �� �ִ�. ���̾�α״� ��ü������ ����� �� ����. �� �����쿡 ���ؼ� ����Ǵµ�,
	// ���̾�α׸� ���� �� �����츦 ���̾�α��� ������(owner) �������� �Ѵ�. ���̾�α״� ���(modal)�� ��޸���(modaless) �� ���� ������ �ִ�.
	// ��� ���̾�α״� ���̾�α׸� �ݱ� ������ ������ �����츦 ����� �� ����, ��޸��� ���̾�α״� ������ �����츦 ��� ����� �� �ִ�.
	// JavaFX���� �����ϴ� ���̾�α� �������� ������ �����ϴ� FileChooser, ���丮�� �����ϴ� DirectoryChooser, �˾�â�� ���� Popup�� �ִ�.
	// �� ���̾�α׵��� javafx.stage ��Ű���� ��� ���ԵǾ� �ִ�. ���̾�α׵� �������̹Ƿ� Stage�� �����ȴ�.
	
			//	FileChooser, DirectoryChooser
	
	// FileChooser�� ���� PC�� ������ ������ �� �ִ� ���̾�α��̴�. ���� �Ǵ� ���� �ɼ����� ������ �� �ְ�, ���� Ȯ����� ���͸��ؼ� ���ϴ� ���ϸ� �� �� �ִ�.
	// FileChooser�� ��Ʈ���� �ƴϱ� ������ FXML���� ������ �� ����. ��ư�̳� �޴� �������� ActionEvent�� ó���� �� �ڹ� �ڵ�� FileChooser�� �����ϰ�, 
	// showOpenDialog() �Ǵ� showSaveDialog()�� ȣ���ؾ� �Ѵ�. ������ ���� �ɼ����� FileChooser�� ������ �ڵ��̴�.
	
	//	FileChooser fileChooser = new FileChooser();		// ��ü ����
	//	fileChooser.getExtensionFilters().addAll(
	//		new ExtensionFilter("Text Files", "*.txt"),
	//		new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),		// ���� Ȯ������� ���͸� ���� �߰�
	//		new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
	//		new ExtensionFilter("All Files", "*.*"));
	//	File selectedFile = fileChooser.showOpenDialog(primaryStage);		// ���̾�α� ����
	//	String selectedFilePath = selectedFile.getPath()					// ���õ� ���� ��� ���
	
	// ���� Ȯ������� ���� �̸��� ���͸��Ϸ��� ExtensionFilter�� �����ؼ� �߰��ϸ� �ȴ�. showOpenDialog() �Ǵ� showSaveDialog()�� ȣ���� ������ ������ ������(Stage)�� �Ű������� �����ؾ� �Ѵ�.
	// �ֳ��ϸ� ���̾�α״� ��ü������ ������ �� ����, ������ �����찡 �־�� �ϱ� �����̴�. FileChooser�� ��� ���̾�α��̹Ƿ� [����] �Ǵ� [����] ��ư�� Ŭ���ϰų�, [���] ��ư�� Ŭ���ϱ� ������
	// ������ �����츦 ����� �� ����. ������ �����ϰ� [����] �Ǵ� [����] ��ư�� Ŭ���ϸ�, showOpenDialog() �Ǵ� showSaveDialog()�� File ��ü�� �����Ѵ�.
	// ���õ� ������ ��ü ��θ� ���ڿ��� ��� �ʹٸ� File�� getPath()�� ȣ���ϸ� �ȴ�. ������ �ƴ϶� ���丮(����)�� �����ϰ� �ʹٸ� FileChooser ��� DirectoryChooser�� ����ϸ� �ȴ�.
	// ��� ����� FileChooser�� ����ϴ�.
	
	//	DirectoryChooser directoryChooser = new DirectoryChooser();
	//	File selectedDir = directoryChooser.showDialog(primaryStage);
	//	String selectedDirPath = selectedDir.getPath();
	
			//	Popup
	
	// Popup�� ������ �����̳ʸ� �����ϴ� ��޸��� ���̾�α��̴�. ���� ������ ������� ��� ���� �� �ִ�. Popup�� ��Ʈ���� ����(tooltip), �޼��� ����(notification),
	// ��Ӵٿ� �ڽ�(drop down boxes), ���콺 ������ ��ư�� Ŭ������ �� ��Ÿ���� �޴� ���� ���� �� ���� �� �ִ�. ���� ��� ������ �޼��� ������ �˷��ִ� Popup�̴�.
	
	//		����������������������������������
	//		��!�� �޼����� �Խ��ϴ�  ��
	//		����������������������������������
	
	// Popup�� �������� �⺻ ���(������, ����, �ּ�ȭ �� ���� ��ư, �ݱ� ��ư)�� ������ ���� �ʴ�. Popup�� ������ �ڹ� �ڵ�� �ۼ��ϰų�, FXML ���Ϸ� �ۼ��� �� �ִ�.
	// ������ FXML ������ �ε��ؼ� Popup�� �������� �߰��ϴ� �ڵ��̴�.
	
	//	Popup popup = new Popup();
	//	popup.getContent().add(FXMLLoader.load(getClass().getResource("popup.fxml")));
	
	// Popup�� �����Ϸ��� ������ ���� show() �޼ҵ带 ȣ���ϸ� �ȴ�.
	
	//	popup.show(primaryStage);							// PC ȭ�� ���߾ӿ��� ����
	//	popup.show(primaryStage, anchorX, anchorY);			// ������ ��ǥ���� ����
	
	// anchorX�� anchorY�� �������� ������ PC ȭ���� ���߾ӿ� Popup�� ����ȴ�. �ٸ� ��ġ���� �����ϰ� �ʹٸ�  PC ȭ���� �»��(0, 0)�� �������� anchorX, anchorY�� �����ϸ� �ȴ�.
	// Popup�� �ٸ� �����캸�� �ֻ��� ��ġ�� ���̰� �ȴ�. Popup�� ����Ǹ� � �����츦 �����ص� Popup�� �׻� ���� ���� �´�. Popup�� �ݱ� ���ؼ��� �� �����츦 �ݰų�, 
	// Popup�ȿ� �߰��� ��Ʈ���� �̺�Ʈ�� ó���ؼ� hide() �޼ҵ带 ȣ���ؾ� �Ѵ�. ���� ������ ����� setAutoHide(true)�� �����ϴ� ���ε�, �ٸ� ������� ��Ŀ���� �̵��ϸ� Popup�� �ڵ����� ������.
	
	//	popup.setAutoHide(true);
	
	// ������ �޼��� ������ Popup�� ����� �����̴�. �켱 Popup ������ ������ FXML ������ ����. 9������ ���� HBox�� CSS�� �����ؼ� ����� ����������, �𼭸��� �ձ۰� �����ߴ�.
	// 12������ Label�� ���ڻ��� ������� �����ϱ� ���� CSS�� �����ߴ�.
	
	// ������ Popup�� �����ϴ� �ڵ��̴�. ImageView�� ���콺�� Ŭ���ϸ� �˾��� �������� �ߴ�. ���콺 Ŭ�� �̺�Ʈ�� ó���Ϸ��� ImageView ��ü�� �ʿ��ѵ�, 
	// FXML ���Ͽ��� �ε��� Parent�� lookup() �޼ҵ带 �̿��ؼ� ImageView�� ã�Ҵ�. lookup() �޼ҵ�� id �Ӽ������� ���� ��ü�� ã�ƿ� �� �����ϰ� ���ȴ�.
	
	//	Popup popup = new Popup();
	//
	//	Parent parent = FXMLLoader.load(getClass().GetResource("popup.fxml"));
	//	ImageView imageView = (ImageView) parent.lookup("#imgMessage");
	//	imageView.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));		// �޼������� �������� �ٸ��� �����ϱ� ���� �ڵ�� �̹��� ����
	//	imageView.setOnMouseClicked( event -> popup.hide() );	// popup �ݱ�
	//	Label lblMessage = (Label) parent.lookup("#lblMessage");
	//	lblMessage.setText("�޼����� �Խ��ϴ�.");						// Label �޼��� ����
	//
	//	popup.getContent().add(parent);
	//	popup.setAutoHide(true);		// �ٸ� ������� ��Ŀ���� �̵��ϸ�(���콺�� Ŭ���ϸ�) �ڵ� ���� ����
	//	popup.show(primaryStage);		// popup ����
	
	// Popup�� ���̾�α��̹Ƿ� ������ �����찡 �ʿ��ϴ�. �׷��� ������ show() �޼ҵ带 ȣ���� �� �Ű������� ������ �������� Stage�� �ʿ��ϴ�.
	
			//	Custom Dialog
	
	// �پ��� ������ ���̾�α׸� ����� �ʹٸ� Stage�� ���� �����ϸ� �ȴ�. Stage�� ���̾�α׸� ������� ������ ���� ������ �ʿ��ϴ�.
	
	//	Stage dialog = new Stage(StageStyle.UTILITY);
	//	dialog.initModality(Modality.WINDOW_MODAL);
	//	dialog.initOwner(primaryStage);
	
	// Stage ������ �Ű������� ������ ��Ÿ���� �������� StageStyle ���� ����� �´�. ������ StageStyle ���� ����� ������ ��Ÿ���� ������ ǥ�̴�.
	
	//	StageStyle ���� ���	����
	//
	//	DECORATED			�Ϲ����� ������ ��Ÿ��, ����� ���, �����ٿ� ���(������, Ÿ��Ʋ, ���, ����, �ݱ� ��ư ���)�� ����
	//
	//	UNDECORATED			����� ���, ������ ����
	//
	//	TRANSPARENT			����� ����, ������ ����
	//
	//	UNIFIED				DECORATED�� �����ϳ�, ���빰�� ��輱�� ����
	//
	//	UTILITY				����� ����̰�, �����ٿ� Ÿ��Ʋ, ���� ��ư�� ����
	
	// ���� �Ű����� ���� �⺻ �����ڷ� Stage�� �����ߴٸ� DECORATED �����찡 �����ȴ�. initModality(Modality.WINDOW_MODAL)�� ��� ���̾�α׷� �����Ѵ�.
	// �� ������ ���� ������ �⺻������ ��޸����� �ȴ�. initOwner(primaryStage)�� ������ ������(Stage)�� �����Ѵ�.
	// ������ Ȯ�� ���̾�α��� ������ ������ FXML �����̴�.
	
	// ������ Ȯ�� ���̾�α׸� �����ϴ� �ڵ��̴�. FXML ������ �ε��� ��, lookup() �޼ҵ带 �̿��ؼ� id �Ӽ������� Label�� Button�� ã�� text �Ӽ����� �����ϰ�, ActionEvent�� ó���� �����ʸ� ����ߴ�.
	// Scene�� ������ �Ŀ��� Ȯ�� ���̾�α��� Stage�� ������� �����ߴ�.
	
	//	Stage dialog = new Stage(StageStyle.UTILITY);
	//	dialog.initModality(Modality.WINDOW_MODAL);
	//	dialog.initOwner(primaryStage);
	//	dialog.setTitle("Ȯ��");		// ���̾�α� ����
	//
	//	Parent parent = FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));
	//
	//	Label txtTitle = (Label) parent.lookup("#txtTitle");		// �޼��� ����
	//	txtTitle.setText("Ȯ���ϼ̽��ϱ�?");
	//	Button btnOk = (Button) parent.lookup("#btnOk);		// ��ư �̺�Ʈ ó��
	//	btnOk.setOnAction( event -> dialog.close() );
	//	Scene scene = new Scene(parent);	// Scene ����
	//
	//	dialog.setScene(scene);			// ���̾�α׿� Scene ����
	//	dialog.setResizable(false);		// ũ�⸦ �������� ���ϵ��� ����
	//	idalog.show();					// ���̾�α� ����
	
			//	Using PrimaryStage On Controller	��Ʈ�ѷ����� PrimaryStage ���
	
	// ��Ʈ�ѷ����� ���̾�α׸� ������ ���� ������ �����찡 �� primaryStage�� �ʿ��ϴ�. ��Ʈ�ѷ����� primaryStage�� ��� ����� �� ������ �ִ�.
	
			/*	The Way Sending From Main Class		���� Ŭ�������� �����ϴ� ���	*/
	
	// primaryStage�� ���� Ŭ������ start() �Ű������� ���޵Ǳ� ������ start() �޼ҵ忡�� ��Ʈ�ѷ��� primaryStage�� �����ϸ� �ȴ�.
	// FXML ��Ʈ �±��� fx:controller �Ӽ��� ������ ��Ʈ�ѷ� Ŭ������ FXMLLoader�� FXML�� �ε��� �� ��ü�� �����ȴ�. FXMLLoader�� ������ ��Ʈ�ѷ��� �����ϴ� getController() �޼ҵ带 �����ϰ� �ִ�.
	// �׷��� �� �޼ҵ�� �ν��Ͻ� �޼ҵ��̱� ������ FXMLLoader ��ü�� �ʿ��ϴ�. �׷��� FXMLLoader�� ���� �޼ҵ� load() ȣ�� �ڵ�� ������ ���� �ν��Ͻ� �޼ҵ� load() ȣ�� �ڵ�� �����ؾ� �Ѵ�.
	
	//	FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));
	//	Parent root = loader.load();
	//	RootController controller = loader.getController();
	//	controller.setPrimaryStage(primaryStage);
	
	// ������ �ڵ带 ���� ��Ʈ�ѷ��� setPrimaryStage() �޼ҵ带 ȣ���ϸ鼭 primaryStage�� �Ű������� �����ϰ� �ִ�. ���� ��Ʈ�ѷ� Ŭ������ ������ ���� �ʵ�� Setter �޼ҵ带 �߰��� �ξ�� �Ѵ�.
	
	//	public class RootController implements Initializable {
	//		private Stage primaryStage;
	//		public void setPrimaryStage(Stage primaryStage) {
	//			this.primaryStage = primaryStage;
	//		}
	//		...
	//	}
	
	// ������ ������ ���� Ŭ������ �����ش�.
	
			/*	The Way Getting From Container Or Control	�����̳� �Ǵ� ��Ʈ�ѷκ��� ��� ���		*/
	
	// �����̳ʳ� ��Ʈ���� getScene() �޼ҵ�� �ڽ��� ���Ե� Scene ��ü�� �����Ѵ�. �׸��� Scene�� getWindow() �޼ҵ�� �ڽ��� �����ִ� Stage ��ü�� �����Ѵ�.
	// ���� ������ ���� �ڵ带 �̿��ϸ� ��Ʈ�ѷ����� primaryStage�� ���� �� �ִ�.
	
	//	Stage primaryStage = (Stage) ��Ʈ��.getScene().getWindow();
	
	// ������ ���� �� �ڵ�� initialize() �޼ҵ� �ȿ����� ����� �� ����. �� ������ ���� primaryStage�� �������� �ʾұ� �����̴�.
	// ���� Ŭ������ start() �޼ҵ忡�� Scene ��ü�� �����ϰ� primaryStage�� Scene�� �����ؾ߸� �� �ڵ尡 ���������� �����Ѵ�.
	// ���� �̺�Ʈ ó�� �޼ҵ� ������ �� �ڵ带 ����ؾ� �Ѵ�. ���� ��� Button�� Ŭ������ �� �����ϴ� �޼ҵ尡 handleButton()�̶�� ������ ���� handleButton() �޼ҵ忡�� primaryStage�� ���� �Ѵ�.
	
	//	public class RootController implements Initializable {
	//		@FXML private Button button;
	//
	//		@Override
	//		public void initialize(URL location, ResourceBundle resources) {
	//		}
	//
	//		public void handleButton(ActionEvent e) {
	//			Stage primaryStage = (Stage) button.getScene().getWindow();
	//			...
	//		}
	//	}
	
	// ���� ������ �ټ� ���� ��ư�� ��ġ�ϰ�, ���ݱ��� ������ ���̾�α׸� �����ϵ��� �ߴ�. ù ��° ��ư�� ���� ���� ���̾�α׸�, �� ��° ��ư�� ���� ���� ���̾�α׸�, �� ��° ��ư�� ���丮 ���� ���̾�α׸�,
	// �� ��° ��ư�� �˾���, �ټ� ��° ��ư�� Ŀ���� ���̾�α׸� �����Ѵ�.
}
