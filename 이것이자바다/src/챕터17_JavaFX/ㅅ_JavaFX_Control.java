package é��17_JavaFX;

public class ��_JavaFX_Control {
	// JavaFX�� �پ��� UI ��Ʈ���� �����ϰ� �ִ�. �̹� ������ ��� �󵵰� ���� ��ư ��Ʈ��, �Է� ��Ʈ��, �� ��Ʈ��, �̵�� ��Ʈ��, íƮ ��Ʈ�ѿ� ���ؼ� ���캼 ���̴�.
	
			//	Button Control
	
	// ��ư ��Ʈ���� ���콺�� Ŭ���� �� �ִ� ��Ʈ�ѷ� ButtonBase�� ����ϴ� ���� ��Ʈ���� ���Ѵ�. Button, CheckBox, RadioButton, ToggleButton, Hyperlink ���� �ִ�.
	
	//		Button			CheckBox			RadioButton		ToggleButton
	//
	//	���������� ��������������		�� Security			�� Home			��������������������������������������������
	//	����ư	�� ��  v	��		�� Project			�� Calendar		��Minor��Major��Critical��
	//	���������� ��������������											��������������������������������������������
	
	// �⺻ Button�� �ܼ��� ���ڷ� �����ȴ�. ������ ImageView�� �Ű������� �ؼ� setGraphic() �޼ҵ带 ȣ���ϸ� �������� ���� �� �ִ�. ������ ������ ��ư�� FXML�� �ۼ��ϴ� ����� �����ش�.
	
	//	<Button text="�����ܹ�ư">
	//		<graphic>
	//			<ImageView>
	//				<Image url="@images/history_view.gif"/>
	//			</ImageView>
	//		</graphic>
	//	</Button>
	
	// CheckBox, RadioButton, ToggleButton ��Ʈ���� ���ð� �̼��� �� ���� ���¸� ���� �� �ִ�. selected �Ӽ��� ���� true�̸� �����̰�, false�̸� �̼����̴�.
	// ������ checkBox ��Ʈ���� FXML�� ������ ���̴�. text �Ӽ��� ����ڿ��� �����ִ� ���ڿ��̰� userData �Ӽ��� ���α׷����� ó���ϴ� �������̴�.
	
	//	<CheckBox text="��1" userData="��1" />
	//	<CheckBox text="��2" userDate="��2" selected="true" />
	
	// RadioButton, ToggleButton���� toggleGroup �Ӽ��� �ִµ�, ���� ToggleGroup�� ������ ��� �ϳ��� �׷����� ���̸�, ���� �׷� �������� �ϳ��� ��Ʈ�Ѹ� ���õǴ� ȿ���� �ִ�.
	// ������ ToggleGroup ��ü�� <fx:define> �±׸� ����ؼ� <ToggleGroup fx:id"groupName" /> �ۼ��ϰ�,
	// RadioButton�� toggleGroup �Ӽ����� $groupName���� �����Ѵ�. ������ 2���� RadioButton�� �ϳ��� �׷����� ��� ������ ���̴�.
	
	//	<fx:define>
	//		<ToggleGroup fx:id="groupName" />
	//	</fx:define>
	
	//	<RadioButton text="��1" userData="��1" toggleGroup="$groupName" />
	//	<RadioButton text="��2" userData="��1" toggleGroup="$groupName" selected="true" />
	
	// CheckBox, RadioButton, ToggleButton ��Ʈ���� ����ڰ� Ŭ���ϸ� 
	// ActionEvent�� �߻��ϱ� ������ EventHandler�� ó���� �����ϰ�, onAction �Ӽ��� �ۼ��ؼ� ��Ʈ�ѷ��� �̺�Ʈ ó�� �޼ҵ�� ������ ���� �ִ�.
	
	//	<CheckBox ...onAction="#handleChkAction" />
	
	// ���� RadioButton �Ǵ� ToggleButton �׷� ������ ���� ������ �����ϰ� �ʹٸ� ToggleGroup�� selectedToggle �Ӽ��� ������ ���� �ۼ��ϸ� �ȴ�.
	
	//	groupName.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	//		@Override
	//		public void changed(ObservableValue<? extends Toggle> observable,
	//							Toggle oldValue, Toggle newValue) {...}
	//	});
	
	// ���� ������ �Ǹ� changed() �޼ҵ尡 ����ǰ� �� ��° �Ű����� newValue�� ���������� ���õ� ��Ʈ���� ���Եȴ�.
	// ���� ������ CheckBox�� RadioButton�� �̺�Ʈ ó���� ��� �ϴ��� �����ش�.
	
			//	Input Control	�Է� ��Ʈ��
	
	// �Է� ��Ʈ�ѿ��� �� �� �Է��� ���� TextField, ���� �� �Է��� ���� TextArea, �н����� �Է��� ���� PasswordField, ���ѵ� �׸񿡼� �����ϴ� ComboBox�� �ִ�.
	// ���� ��¥�� ������ �� �ִ� DatePicker, ������ ������ �� �ִ� ColorPicker, HTML�� �Է��ϱ� ���� HTMLEditor�� �Է� ��Ʈ���̶�� �� �� �ִ�.
	// Label�� �Է� ��Ʈ���� �ƴ����� �Է� ��Ʈ���� ������ ǥ���� �� ���ȴ�.
	
	//	Label & TextField			PasswordField			TextArea
	//
	//		 ������������������				��������������������������			��������������������������������������������������
	//	Name:��Michael��				���ܡܡܡܡܡܡ�	��			��abc					��
	//		 ������������������				��������������������������			��������					��
	//														��������������������������������������������������
	//
	//		ComboBox				DatePicker				ColorPicker
	//
	//	��������������������������				����������������������������������		������������������
	//	��		   �妢				��<02�� >	  <2020>��		���� White��
	//	��������������������������				���� ��  ȭ ��  ��  �� ��	��		����������������������������������
	//	��Option 1	��				��1 2 3 4 5 6 7	��		����	��	...		��
	//	��������������������������				��8 9 ...		��		��				��
	//	��Option2	��				����������������������������������		����������������������������������
	//	��������������������������
	//
	//							HTMLEditor
	//
	//	��������������������������������������������������������������������������������������������������������������������������������������������������
	//	����	��	��	��	��	��	��	�� A��										��
	//	������������������	����������������	������������������������������		B	I	U					��
	//	������������������	����������������	������������������������������									��
	//	��������������������������������������������������������������������������������������������������������������������������������������������������
	//	��This is HTML Page!														��
	//	��																		��
	//	��������������������������������������������������������������������������������������������������������������������������������������������������
	
	// ������ �Է� ��Ʈ���� FXML�� �����ϴ� ����� �����ش�.
	
	//	<Label prefWidth="��" prefHeight="����" text="����" />
	//	<TextField prefWidth="��" prefHeight="����" promptText="��Ʈ���ڿ�" />
	//	<PasswordField preWidth="��" prefHeight="����" promptText="��Ʈ���ڿ�" />
	//
	//	<ComboBox prefWidth="��" prefHeight="����" promptText="��Ʈ���ڿ�" >
	//		<items>
	//			<FXCollections fx:factory="observableArrayList" >
	//				<String fx:value="����" />
	//				<String fx:value="�����" />
	//			</FXCollections>
	//		</item>
	//	</ComboBox>
	//
	//	<DatePicker prefWidth="��" prefHeight="����" promptText="��Ʈ���ڿ�" />
	//	<TextArea prefWidth="��" prefHeight="����" promptText="��Ʈ���ڿ�" />
	
	// prefWidth�� prefHeight�� ���� ���� ���̸� �����ϰ�,promptText�� ��Ʈ ���ڿ��� ��Ʈ���� ��Ŀ���� ��� �Ǹ� �������.
	
	// ���� ������ �Է� ��Ʈ�ѷ� ������ ���� �����Ѵ�. ������ TextField, ��й�ȣ�� PasswordField, ������ ComboBox, �Խ������ DataPicker, ������ TextArea�� �����ߴ�.
	// [���] ��ư�� Ŭ���ϸ� ��� �Էµ� ������ �ֿܼ� ��µȴ�.
	
			//	View Control
	
	// �� ��Ʈ���� �ؽ�Ʈ �Ǵ� �̹��� ���� �����ִµ� ��� ���·� �����ִ� ListView, ���̺� ���·� �����ִ� TableView, �̹����� �����ִ� ImageView�� �ִ�.
	
	//		ListView		TableView						ImageView
	//
	//	��������������������������		��������������������������������������������������		��������������������������������������������������
	//	��Single		��		��First Name	��Last Name	��		��						��
	//	��������������������������		��������������������������������������������������		��						��
	//	��Double		��		��Jacob		��Smith		��		��						��
	//	��������������������������		��������������������������������������������������		��		�̹���			��
	//	��Suite		��		��Isabella	��William	��		��						��
	//	��������������������������		��������������������������������������������������		��						��
	//	��Family App	��		��Ethan		��Jones		��		��						��
	//	��������������������������		��������������������������������������������������		��������������������������������������������������
	
			/*	ImageView Control	*/
	
	//	<ImageView fitWidth="��" fitHeight="����" preserveRatio="true" />
	
	// fitWidth�� fitHeight�� ImageView�� ���� ���̸� �����Ѵ�. preserveRatio �Ӽ��� �̹����� ��Ⱦ�� ������ �������� �����Ѵ�.
	// false�� �ָ� ��Ⱦ��� ������� fitWidth�� fitHeight�� �°� ImageView ũ�Ⱑ �����ǰ�, true�� �ָ� �̹����� ��Ⱦ�� �����ϱ� ���� ImageView ũ�Ⱑ �����ȴ�.
	// ImageView�� ������ �̹����� �� ���� ������� ������ �� �ִµ�, ù ��° ����� ImageView�� ������ �Ű������� Image ��ü�� �����ϴ� ���̴�.
	
	//	<ImageView preserveRatio="true" >
	//		<Image url="@images/flower.png" />
	//	</ImageView>
	
	// �� ��° ����� ImageView�� setImage() �޼ҵ�� �����ϴµ�, ���� �Ű����� Image ��ü�̴�.
	
	//	<ImageView fitWidth="200" fitHeight="150" preserveRatio=true" >
	//		<image>
	//			<ImageView url="@images/flower.png" />
	//		<image>
	//	</ImageView>
	
	// Image�� url �Ӽ�(������ �Ű� ����)�� ������ �ִµ� FXML ���� ��ġ���� ��� ��η�"@�̹��� ���"�� ������ �ָ� �ȴ�.
	
			/*	ListView Control	*/
	
	// ListView�� �׸���� ������� �����ִ� ��Ʈ���̴�. FXML�� �����ϴ� ����� ������ ����.
	
	//	<ListView prefWidth="��" prefHeight="����" />
	
	// ListView�� �׸��� �߰��Ϸ��� setItems(ObservableList<T> value) �޼ҵ带 ����Ѵ�.
	// ObservableList ���� ��ü�� FXCollections.observableArrayList(E ... items) ���� �޼ҵ�� �����ϸ� �ȴ�.
	
	//	listView.setItems(FXCollections.observableArrayList("Swing", "JavaFX"));
	
	//	<ListView fx:id="listView" prefHeight="100" prefWidth="100" >
	//		<item>
	//			<FXCollections fx:factory="observableArrayList" >
	//				<String fx:value="Swing" />
	//				<String fx:value="JavaFX" />
	//			</FXCollections>
	//		</item>
	//	</ListView>
	
	// LastView���� ���õ� �ε����� �׸��� �������� �Ӽ� ���ø� �̿��� �� �ִ�. getSelectionModel() �޼ҵ�� MultipleSelectionModel�� ��� ����,
	// selectedIndexProperty �Ǵ� selectedItemProperty�� �����ʸ� �����ϸ� �ȴ�. selectedIndexProperty�� ���õ� �ε����̰�, selectedItemProperty�� ���õ� �׸��̴�.
	// ������ selectedItemProperty�� �����ʸ� �����ϴ� �ڵ��̴�.
	
	//	listView.getSelectionModel().selectedItemProperty().addListener(
	//		new ChangeListener<String>() {
	//			@Override
	//			public void changed(ObservableValue<? extends String> observable,
	//								String oldValue, String newValue) {...}
	//		}
	//	);
	
			/*	TableView Control	*/
	
	// TableView�� FXML�� �����ϴ� ����� ������ ����. <column> �±� �ȿ� ������� �ϴ� �÷��� ������ŭ <TableColumn> �±׸� �����ϸ� �ȴ�.
	
	//	<TableView prefHeight="100" prefWidth="300" >
	//		<column>
	//			<TableColumn prefWidth="150" text="����Ʈ��" />
	//			<TableColumn prefWidth="150" text="�̹���" />
	//		</column>
	//	</TableView>
	
	// TableView�� ��(row)�� �߰��Ϸ��� ���� �����͸� ������ �ִ� ��(model) ��ü�� �ʿ��ϴ�. �� �ڵ带 ���� ����Ʈ���� �̹��� �÷��� �ִµ�, �� �� ���� �Ӽ����� ���� �� ��ü�� �����ؼ� ���� �����ͷ� �����ؾ� �Ѵ�.
	// ������  Phone �� Ŭ������ �����ϴ� ����� �����ش�.
	
	// ���� �Ӽ� Ÿ���� �÷� ���� ������ Ÿ�Կ� ���� javafx.beans.property ��Ű���� SimpleXXXProperty�� ����ϸ� �ȴ�.
	// �� Ŭ������ �ۼ��Ͽ��ٸ� ���� �� �Ӽ��� TableColumn�� �����Ű�� �ڵ带 �ۼ��ؾ� �Ѵ�. TableColumn�� TableView�� getColumn().get(�ε���)�� ��� ���µ�, ù ��° �÷��� �ε����� 0�̴�. 
	// TableColumn�� setCellValueFactory() �޼ҵ�� �Ű������� �����Ǵ� PropertyValueFactory("�𵨼Ӽ���")�� �̿��ؼ� �� �Ӽ����� TableColumn ������ �����Ѵ�.
	// ������ ù ��° TableColumn�� �� Ŭ������ smartPhone �Ӽ��� �����Ű�� �ڵ��̴�.
	
	//	TableColumn tcSmartPhone = tableView.getColumn().get(0);
	//	tcSmartPhone.setCellValueFactory( new PropertyValueFactory("smartPhone") );
	
	// ��(cell) ������ ������ �ʿ��� ��쿡�� ������ ���� TableColumn�� setStyle() �޼ҵ�� CSS�� �����ϸ� �ȴ�. CSS 17.10 JavaFX CSS ��Ÿ�Ͽ��� �н��Ѵ�.
	
	//	tcSmartPhone.setStyle("-fx-alignment: CENTER;");
	
	// ���������� ���� �����͸� �ֱ� ���� ObservableList�� �� ��ü���� ������ ���� �����ϰ�, ObservableList�� �Ű������� �ؼ� TableView�� setItems() �޼ҵ带 ȣ���Ͽ� ����� �߰��Ѵ�.
	
	//	ObservableList phoneList = FXCollections.observableArrayList(
	//		new Phone("������S1", "phone01.png"),
	//		new Phone("������S2", "phone02.png"),
	//		new Phone("������S3", "phone03.png"),
	//	);
	//	tableView.setItems(phoneList);
	
	// TableView���� ���õ� ���� �ε����� �� ��ü�� �������� �Ӽ� ���ø� �̿��� �� �ִ�. getSelectionModel() �޼ҵ�� TableViewSelectionModel�� ��� ����,
	// selectedIndexProperty �Ǵ� selectedItemProperty�� �����ʸ� �����ϸ� �ȴ�. selectedIndexProperty�� ���õ� ���� �ε����̰�, selectedItemProperty�� ���õ� ���� �� ��ü�̴�.
	// ������ selectedItemProperty�� �����ʸ� �����ϴ� �ڵ��̴�.
	
	//	tableView.getSelectionModel().selectedItemProperty().addListener(
	//		new ChangeListener<Phone>() {
	//			@Override
	//			public void changed(ObservableValue<? extends Phone> observable,
	//								Phone oldValue, Phone newValue) {...}
	//		}
	//	);
	
	// ���� ������ ListView�� �׸��� �����ϸ� ���� �ε����� ������ TableView�� ���� �ڵ� ���õǵ��� �Ѵ�.
	// �׸��� TableView���� ���� ���õǸ� �̹��� �÷� ���� �а� ImageView�� �̹����� �����ش�. �ϴ��� [Ȯ��] ��ư�� Ŭ���ϸ� ListView�� TableView�� ���õ� ������ �ֿܼ� ����Ѵ�.
	
			//	Media Control
	
	// �̵�� ��Ʈ�ѿ��� ������ ����� �� �ִ� MediaView ��Ʈ�Ѱ� ���� ���� �� ��� ��ġ ������ ���� Slider ��Ʈ�� �׸��� ���� ���� ���¸� �����ִ� ProgressBar, ProgressIndicator ��Ʈ���� �ִ�.
	// Slider�� ProgressBar, ProgressIndicator�� �̵��ʹ� ������� �ٸ� �뵵�� ����� �� �ִ�.
	// ���� ��� ProgressBar�� ProgressIndicator�� ��Ʈ��ũ ������ �ۼ��� ������ ǥ���� ������ ����� �� �ִ�.
	
	//								MediaView
	//			��������������������������������������������������������������������������������������������������
	//			��												��
	//			��	 											��
	//			��					������						��
	//			��												��
	//			��												��
	//			��												��
	//			��������������������������������������������������������������������������������������������������
	//
	//				Slider											ProgressBar�� ProgressIndicator
	//						
	//	Track		Thumb	Block increment							progress: 0.0 �����������	0%
	//	��			��	  	 �� �ꦢ	
	//	�������������������������ܦ�����������������������									progress: 0.6 �����������	60%
	//	��������������������������������������������������
	//	��������������������������������������������������									progress: 1.0 �����������	100%
	//	0			50.0		100
	//			Tick marks		�� Tick Label
	
			/*	MediaPlayer And MediaView Control	*/
	
	// MediaView ��Ʈ���� ������ �����ִ� �뵵�θ� ���Ǳ� ������ Ư���� UI�� ������ ���� �ʴ�. ����, ���̾ƿ��󿡼� ������ ��ġ�� ������ ǥ���Ѵ�. 
	// FXML�� MediaView ��Ʈ���� �����ϴ� ����� ������ ����.
	
	//	<MediaView fitHeight="200.0" fitWidth="300.0" preserveRatio="false" />
	
	// fitWidth�� fitHeight�� MediaView�� ���� ���̸� �����Ѵ�. preserveRatio �Ӽ��� ������ ����-���κ� ������ �������� �����ϴµ�, false�� �ָ� ������ ����-���κ�� �������
	// fitWidth�� fitHeight�� �°� MediaView�� ũ�Ⱑ �����ǰ�, true�� �ָ� ������ ���κ�� ���κ� �����ϱ� ���� MediaView ũ�Ⱑ �����ȴ�.
	// MediaView ��Ʈ���� ������ ����ϴ� ����� ���� ������ �̵� ����ϴ� MediaPlayer�� �־�� �Ѵ�.
	// MediaPlayer�� �����Ӹ� �ƴ϶� ������� ����ϴ� ����� ������ �ִµ�, �̵�� �ҽ� ��θ� Media ��ü ���·� �����ؼ� ������ ���� �����Ѵ�.
	
	//	Media media = new Media("�̵�� �ҽ� ���");
	//	MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	// ���� ������ ����� ������ Ŭ���� ��ο� �ִٸ� Media�� ������ �� ������ ���� ��� ��θ� ����ϴ� ���� ����.
	
	//	Media media = new Media(getClass().getResource("media/bigbuck.m4v").toString());
	//	MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	// �̵�� �ҽ��� ������� MediaView�� setMediaPlayer() �޼ҵ�� mediaPlayer ��ü�� ����� �� �ִ�. ����� �ҽ��κ��� MediaPlayer�� �����Ǿ��ٸ� MediaView�� �ʿ� ����.
	
	//	mediaView.setMediaPlayer(mediaPlayer);
	
	// MediaPlayer�� �����ߴٰ� �ؼ� �ٷ� ����� ���� ����, ����� ����(READY)�� �� ������ ��ٷ��� �Ѵ�.
	// ������ MediaPlayer�� ���� �� �ִ� ���¿� ���¸� �����ϴ� �޼ҵ尡 �������� �����ش�.
	
	//	���� ����\���� ����		READY		PAUSED						PLAYING			STALLED			STOPPED
	//	
	//	UNKNOWN			
	//	
	//	READY							setAutoPlay(true).play()
	//	
	//	PAUSED							play()														stop()
	//	
	//	PLAYING							paused()									buffering data	stop()
	//
	//	STALLED							paused()					buffering data					stop()
	//
	//	STOPPED							paused()					play()
	
	// UNKNOWN�� Mediaplayer�� ������ ������ �����ε�, �̵�� �ҽ��� ����� �غ� �Ǹ� READY ���·� �ڵ� ����ȴ�.
	// READY ���¿��� setAutoPlay(true) �Ǵ� play()�� ȣ���ϸ� PLAYING�� �ȴ�. PLAYING ���°� �ǰ�, stop()�� ȣ���ϸ� STOPPED�� �ȴ�.
	// ���� PLAYING ���¿��� ��� ���ۿ� ����� �����Ͱ� ���� ��� STALLED ���°� �ȴ�. �ַ� ��Ʈ��ũ�󿡼� �̵�� �ҽ��� �޾� ����� ��, ��Ʈ��ũ �ӵ��� ������ STALLED ���°� �ȴ�.
	// �� ���µ��� MediaPlayer.Status ���� Ÿ������ ��� ���ǵǾ� �ִµ�, �ڵ忡�� MediaPlayer�� ���¸� �˰� �ʹٸ� getStatus()�� ���ϰ��� Ȯ���ϸ� �ȴ�.
	
	//				UNKNOWN
	//				   ��
	//				READY
	//				   ��
	//		��������������	PLAYING �禡��������������
	//		��		   ��			��
	//	STALLED	 ��	PAUSED	 ��	STOPPED
	
	// ���� ǥ���� ���� ���� ������ �� ���� ���¸� �� �˾Ƶ� �ʿ䰡 �ִ�. �ٷ� EndOfMedia�̴�. EndOfMedia�� MediaPlayer�� �̵�� �ҽ��� ��� ������� ���� ���¸� ���Ѵ�.
	// EndOfMedia ���¿��� play()�� ȣ���ϸ� �ٽ� PLAYING ���°� �� �� �ִµ�, ���� seek() �޼ҵ�� ��� ��ġ�� ó������ �ǵ����� �Ѵ�.
	
	// ���°� ����Ǹ� �ڵ� �����ؾ� �� �ڵ���� ���� �� �ִ�. �̷� �ڵ���� Runnable�� run() �޼ҵ忡 �ۼ��ϰ�, setOnXXX() �޼ҵ�� ����ϸ� �ȴ�.
	// �׷��� �ش� ���°� �Ǿ��� �� Runnable�� run() �޼ҵ尡 �ڵ� ����ȴ�. ������ �� ���·� ����� �� �����ϴ� Runnable�� �����ϴ� �޼ҵ��̴�.
	
	//	����			�ڵ� ���� Runnable ���� �޼ҵ�		Runnable�� ���Ե� �� �ִ� �ڵ�
	//
	//	READY		setOnReady(Runnable r)		- currentTime �Ӽ��� ����
	//											- ��� �ð��� ǥ���ϴ� ������ ���
	//											- ��� ��ư Ȱ��ȭ
	//
	//	PLAYING		setOnPlaying(Runnable r)	- ���� �� ���� ��ư Ȱ��ȭ
	//
	//	PAUSED		setOnPlaying(Runnable r)	- ��� �� ���� ��ư Ȱ��ȭ
	//
	//	STOPPED		setOnStopped(Runnable r)	- ��� ��ư Ȱ��ȭ
	//
	//	EndOfMedia	setOnEndOfMedia(Runnable r)	- ��� ��ư Ȱ��ȭ
	
	// ������ setOnReady() �޼ҵ带 �ۼ��ϴ� ����� �����ش�. MediaPlayer���� currentTime �Ӽ��� �����ϴ� ChangeListener�� ����ߴµ�, 
	// changed() �޼ҵ忡�� ��� �ð��� ǥ���ϴ� �ڵ���� �ۼ��� �� �ִ�. �ʿ��ϴٸ� READY ���¿��� PLAYING ���·� �����ϱ� ���� ��� ��ư�� Ȱ��ȭ�ϴ� �ڵ带 �ۼ��ؾ� �Ѵ�.
	// ���� ��� ��ư�� ������� �ʰ� �ڵ� ������ �ϰ� �ʹٸ� setAutoPlay(true)�� ȣ���ؾ� �Ѵ�.
	
	//	mediaPlayer.setOnReady(new Runnable() {
	//		@Override
	//		public void run() {
	//			mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
	//				@Override
	//				public void changed(ObservableValue<? extends Duration> observable, 
	//									Duration oldValue, Duration newValue) {
	//					// ��� �ð��� ǥ���ϴ� �ڵ�
	//				}
	//			});
	//			// ��� ��ư�� Ȱ��ȭ �ڵ� �ڵ� setAutoPlay(true);
	//		}
	//	});
	
	// ������ ������ ������� ����ϴ� ������ �÷��̾ ����� ���Ҵ�. RootController�� ���ΰ� ������ �����ư��� �ּ��� �����ϰ� ������Ѻ���.
	
			/*	Slider Control	*/
	
	//				Slider									
	//						
	//	Track		Thumb	Block increment		
	//	��			��	  	 �� �ꦢ	
	//	�������������������������ܦ�����������������������	
	//	��������������������������������������������������
	//	��������������������������������������������������	
	//	0			50.0		100
	//			Tick marks		�� Tick Label
	
	// Slider ��Ʈ���� Track�� Thumb�� �����Ǿ� �ִ�. Slider�� value �Ӽ����� ���� Thumb�� ��ġ���� ����Ǵµ�, �ּҰ��� 0, �ִ밪�� 100�̴�.
	// �⺻������ Tick marks�� Tick label�� ������ �ִµ�, setShowTickMarks(true)�� setShowTickLabel(true)�� ȣ���ϸ� �� �� �ִ�.
	// Block increment ������ setBlockIncrement()�� ������ �� �ִ�
	// ������ FXML�� Slider ��Ʈ���� �����ϴ� ����� �����ش�.
	
	//	<Slider prefHeight="����" prefWidth="��" showTickLabels="true" showTickMarks="true" />
	
	// ������ MediaPlayer�� ������ �����ϱ� ���� Slider ��Ʈ���� value �Ӽ��� �����ϴ� ChangeListener�� ����Ѵ�.
	// MediaPlayer�� volume �Ӽ��� 0.0 ~ 1.0 ���� �����µ�, Slider value �Ӽ��� 0.0 ~ 100.0 ���� �����Ƿ� Slider�� value �Ӽ����� 100.0���� �����
	// MediaPlayer�� value �Ӽ������� �����ؾ� �Ѵ�.
	
	//	sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
	//		@Override
	//		public void changed(ObservableValue<? extends Number> observable,
	//								Number oldValue, Number newValue) {
	//			mediaPlayer.setVolume(sliderVolume.getValue() / 100.0);
	//		}
	//	});
	
			/*	ProgressBar And ProgressIndicator Control	*/
	
	//		ProgressBar�� ProgressIndicator
	//						
	//	progress: 0.0 �����������	0%
	//	
	//	progress: 0.6 �����������	60%
	//
	//	progress: 1.0 �����������	100%
	
	// ProgressBar�� ���� ���� ����� ��Ʈ���̰�, ProgressIndicator�� ���� ����� ��Ʈ���̴�. 
	// �� �� �۾��� ���� ������ ǥ���ϴµ�, �̵�� ��� �ð��� ǥ���ϰų�, ������� ��뷮 �� ��Ʈ��ũ ��ŷ��� ǥ���� ���� ����� �� �ִ�.
	// ������ FXML�� �����ϴ� ����� �����ش�.
	
	//	<ProgressBar prefHeight="15" prefWidth="100" progress="0.0" />
	//	<ProgressIndicator prefHeight="47.0" prefWidth="31.0" progress="0.0" />
	
	// ProgressBar�� ProgressIndicator�� ����� ���� ��Ʈ���̱� ������ ����ϴ� �Ӽ����� ��� �����ϴ�. progress �Ӽ��� ���� ������ �����ϴµ�, �ּҰ��� 0.0�̰� �ִ밪�� 1.0�̴�.
	// ���� ������ �ڹ� �ڵ�� ������ ���� ������ �� �ִ�.
	
	//	progressBar.setProgress(0.0 ~ 1.0);
	//	progressIndicator.setProgress(0.0 ~ 1.0);
	
	// MediaPlayer�� ��� �ð��� ��Ÿ���� ���ؼ��� ���� ��� �ð��� ��ü ��� �ð����� �������� progress �Ӽ������� �����ϸ� �ȴ�.
	
	//	double progress = 
	//	mediaPlayer.getCurrentTime().toSeconds()	// mediaPlayer.getTotalDuration().toSeconds();
	//	progressBar.setProgress(progress);
	//	progressIndicator.setProgress(progress);
	
	// ������ ���� ������ ��� �ð��� ��ü ��� �ð��� ��Ȯ�� ��ġ���� �ʱ� ������ ������ ���� 1.0�� ���� ���� ���� �ִ�. 
	// �׷��� MediaPlayer�� EndOfMedia ���°� �Ǿ��� �� progress �Ӽ��� ������ 1.0���� �����ϴ� ���� ����.
	
	//	MediaPlayer.setOnEndOfMedia( () -> {
	//		progressBar.setProgress(1, 0);
	//		progressIndicator.setProgress(1, 0);
	//	}
	
	// ������ ���� ������ �̵�� �÷��̾ �����ؼ� ��� �ð��� ǥ���ϵ��� ProgressBar�� ProgressIndicator ��Ʈ���� �߰��ϰ�, ������ �����ϱ� ���� Slider ��Ʈ���� �߰��Ѵ�.
	
			/*	Chart Control	*/
	
	// JavaFX���� ������ ���� �پ��� ��Ʈ�� �����ϴ� ��Ʈ���� �������ش�. �� ��Ʈ�� ��Ʈ�ѵ��� javafx.scene.chart ��Ű���� ���ԵǾ� �ִ�.
	
	//		PieChart				LineChart			AreaChart
	//
	//	Apple ��	�� �� Orange		������������������			��
	//	�� Apple	�� Orange		����������	������������		������������������
	//							��	������������			�����������
	//							������������������������������		��������������������
	//
	//		BarChart				BubbleChart			ScatterChart
	//
	//	������						��	��				����		��		��
	//	����������					����					��	��	��	�ܡ�
	//	����������					��		��			����	�ܡܡ�	��		��
	//	��������������������������			������������������������������		����������������������������������
	
	// FXML�� ��Ʈ ��Ʈ���� ��ġ�ϴ� ����� �ſ� ���, PieChart�� ��� ������ ���� �ۼ��ϸ� �ȴ�. PieChart�� X��� Y���� �����Ƿ� ������ ������ �ʿ䰡 ����
	
	//	<PieChart/>
	
	// LineChart, AreaChart, BarChart�� ��� X��� Y���� �ʿ��ϹǷ� �� ���ǰ� �ʿ��ϴ�. ������ BarChart�� �����ϴ� ����� �����ش�.
	// <xAxis>�� <yAxis>�� ���� X��, Y���� ���Ѵ�. X���� ����, �Ʒ����� �ְ�, Y���� ���ʰ� �������� �ֱ� ������ ������ ��Ÿ�� ��ġ�� �����ؾ� �Ѵ�.
	// <CategoryAxis side="BOTTOM" />�� �з� ������ �Ʒ��� �࿡ ��Ÿ����. <NumberAxis side="LEFT" />�� ���� ������ ���� �࿡ ��Ÿ����.
	
	//	<BarChart>
	//		<xAxis>
	//			<CategoryAxis side="BOTTOME" />
	//		</xAxis>
	//		<yAxis>
	//			<NumberAxis side="LEFT" />
	//		</yAxis>
	//	</BarChart>
	
	// ��Ʈ�ѷ��� ��Ʈ�� �����͸� �����ͺ��̽��� ��Ʈ��ũ���� ���޹޾Ƽ� ��Ʈ ��Ʈ�ѿ� �߰��ؾ� �ϴµ�, ������ PieChart�� �����͸� �߰��ϴ� ����� �����ش�.
	// ������ �����ʹ� PieChart.Data ��ü�� �����ϰ�, �̰��� ObservableList�� ������ ���� PieChart�� setData() �Ű������� �����ϸ� �ȴ�.
	
	// 	pieChart.setData(FXCollections.observableArrayList(
	//		new PireChart.Data("AWT", 10),
	//		new PireChart.Data("Swing", 30),
	//		new PireChart.Data("SWT", 25),
	//		new PireChart.Data("JavaFX", 35)
	//	)};
	
	// X��� Y���� �ʿ��� LineChart, AreaChart, BarChart�� �����͸� �߰��ϴ� ����� ��� �����ϴ�.
	// ������ BarChart�� �����͸� �߰��ϴ� ����� �����ش�.
	
	//	XYChart.Series series1 = new XYChart.Series();		// �ø��� ����
	//	series1.setName("����");
	//	series1.setData(FXCollections.observableArrayList(
	//		new XYChart.Data("2015", 70),
	//		new XYChart.Data("2016", 40),
	//		new XYChart.Data("2017", 50),
	//		new XYChart.Data("2018", 30)
	//	));
	//	barChart.getData().add(series1);
	
	// XYChart.Series�� �ϳ��� �׷����� �ǹ��Ѵ�. ���� ���� �׷����� ���� ���̰� �Ϸ��� XYChart.Series�� �׷����� ���� �°� �����ؼ� �߰��ϸ� �ȴ�.
	// ���� �����ʹ� XYChart.Data ��ü�� �����ϰ�, �̰��� ObservableList�� ������ ���� XYChart.Series�� setData() �Ű������� �����ϸ� �ȴ�.
	// XYChart.Series�� �ϼ��Ǹ� ��Ʈ�� getData()�� ȣ���ؼ� ���� ObservableList�� �߰������ν� �ϳ��� �׷����� �����ȴ�.
	// ���� ������ PieChart, BarChart, AreaChart�� �����ϴ� ����� �����ش�.
	//
	//
}
