package é��17_JavaFX;

public class ��_JavaFX_Layout {
	// ���(Scene)���� �پ��� ��Ʈ���� ���ԵǴµ� �̵��� ��ġ�ϴ� ���� ���̾ƿ�(Layout)�̴�.
	// ���̾ƿ��� �ۼ��ϴ� ����� �� ������ �ִ�. �ϳ��� �ڹ� �ڵ�� �ۼ��ϴ� ���α׷��� ���̾ƿ��̰�, �ٸ� �ϳ��� FXML�� �ۼ��ϴ� ������ ���̾ƿ��̴�.
	
			//	Program Layout		���α׷��� ���̾ƿ�
	
	// ���α׷��� ���̾ƿ��̶� �ڹ� �ڵ�� UI ��Ʈ���� ��ġ�ϴ� ���� ���Ѵ�. �ڹ� �ڵ忡 �ͼ��� �����ڵ��� ��ȣ�ϴ� ������� ��Ʈ�� ��ġ, ��Ÿ�� ����, �̺�Ʈ ó�� ���� ��� �ڹ� �ڵ�� �ۼ��Ѵ�.
	// ���̾ƿ��� ���������� ���α׷��� ����� �ڵ���� �������� ������ ���α׷��� �� Ȯ���� ��������. ���� ��� ���� �����ڰ� ���� �ۻ��ؾ� �ϹǷ� �����̳ʿ� �����ؼ� �����ϴ� �͵� ��ƴ�.
	// ������ �Ϸ��� ��, ������ ���̾ƿ� �����̳� ��Ÿ�� ������ �ʿ��ϸ� �ڹ� �ҽ��� �����ϰ� ���������ؾ� �Ѵٴ� ������ �ִ�.
	// ���� ������ ������ ���� ���̾ƿ��� ���α׷��� ������� �ۼ��� ���̴�. 
	// �ؽ�Ʈ�� �Է��� �� �ִ� TextField ��Ʈ�Ѱ� Ŭ���� �� �ִ� Button ��Ʈ���� �������� ������ ��ġ�Ǿ� �ֱ� ������ Parent ��Ʈ �����̳ʷ� HBox�� ����Ͽ���.
	
	//		AppMain
	//		������������������������������������������������������������������
	//		����								��	Ȯ��
	//		������������������������������������������������������������������
	
			//	FXML Layout		FXML ���̾ƿ�
	
	// FXML�� XML ����� ��ũ�� ����, JavaFX ���ø����̼��� UI ���̾ƿ��� �ڹ� �ڵ忡�� �и��ؼ� �±׷� �����ϴ� ����� �����Ѵ�.
	// �� ����� �ȵ���̵�(Android) ���� �����ϴ� ����� �����ѵ�, �ȵ���̵�� XML�� ���̾ƿ��� �ۼ��ϰ�, �ڹٷ� �̺�Ʈ ó�� �� ���ø����̼� ������ �ۼ��Ѵ�.
	
	// FXML �±׷� ���̾ƿ��� �����ϱ� ������ �±׿� �ͼ��� �����̳ʿ� ������ �����ϴ�. ���� ���� �Ϸ� �� ������ ���̾ƿ� �����̳� ��Ÿ�� ������ �ʿ��� ��쿡�� �ڹ� �ҽ��� ������ �ʿ���� FXML �±׸� �����ϸ� �ȴ�.
	// �׸��� ���̾ƿ��� ����� ���(Scene)�� ���� ������ �����ϱ� ������ ���� �Ⱓ�� ����ý�ų ���� �ִ�. ������ ���α׷��� ���̾ƿ����� ���캸�Ҵ� ������ ���̾ƿ��� FXML�� �ۼ��� �ڵ��̴�.
	
	// ��Ʈ �����̳��� HBox�� <HBox> �±׷� �ۼ��ǰ�, fx ���λ翡 ���� ���ӽ����̽� ���� (xmls:fx="http://javafx.com/fxml")�� �߰��Ǿ� �ִ� ���� �� �� �ִ�.
	// �̰��� FXML ���Ͽ� <fx:XXX> ������ �±� �� fx:xxx="��" ������ �Ӽ��� �ۼ��� �� �ִٴ� ���ε�, �̷��� �±׿� �Ӽ��� ��Ʈ�� ��ġ���ٴ� FXML ������ ���� ó���� ���ȴ�.
	
			//	Layout Blank: Padding And Margin	���̾ƿ� ����: ����� ����
	
	// ��Ʈ���� ���� ���� ��ġ�ϱ� ���ؼ� ������ ���� �ʼ������� ����. ������ �е�(padding)�� ����(margin)�� �ִµ�, �е��� ���� ������ ���ϰ� ������ �ٱ� ������ ���Ѵ�.
	// �е��� �ش� �����̳��� setPadding() �޼ҵ带 ����ؼ� �����ϴ� �ݸ�, ������ �ٱ� �����̳��� setMargin() �޼ҵ带 ����ؾ� �Ѵ�.
	// ���� ��� Button�� HBox�� ���ԵǾ� ���� �� HBox���� �е��� 50���� �ִ� �Ͱ� Button���� ������ 50���� �ִ� ���� ������ ����� ������ �ڵ�� �ٸ���.
	
	//	����		HBox�� �е�										Button�� ����
	//
	//			HBox											HBox
	//	����		����������������������������������								����������������������������������
	//			��		��		��								��		��		��
	//			��	�� Button ��	��								��	�� Button ��	��
	//			��		��		��								��		��		��
	//			����������������������������������								����������������������������������
	//
	//	�ڹ�		HBox hbox = new HBox();							Button button = new Button();
	//	�ڵ�		hbox.setPadding(new Insets(50));				HBox.setMargin(button, new Insets(50));
	//
	//	FXML	<Hbox>											<Button>
	//	�±�			<padding>										<HBox.margin>
	//					<Insets topRightBottomLeft="50"/>				<Insets topRightBottomLeft="50"/>
	//				</padding>										</HBox.margin>
	//			</HBox>											</Button>
	
	// ������ �е��� �����ϴ� ��ġ�� ���� top, right, bottom, left�� ���еȴ�.
	
	//	�����̳�A
	//	
	//	����������������������������������������������������������			����������������������������������������������������������	
	//	��			�� �����̳�A��		�������̳�A��	��			 �����̳�A�� right	��
	//	��			�� top padding	��	right	��				���� �禡������������	��
	//	��			����				����������������������	��					padding	��
	//	����������������������������������������������������������	margin	����������������������������������������������������������
	
	// ������ �е����� javafx.geometry.Insets ��ü�� �����ؾ� �ϴµ� ������ ���� �����Ѵ�.
	
	//	// top, right, bottom, left�� ��� ������ ������ ������ ��
	//	new Insets(double topRightBottomLeft);
	//
	//	// top, right, bottom, left�� �ٸ� ������ ������ ��
	//	new Insets(double top, double right, double bottom, double left)
	
	// �Ű����� ������ top���� �����ؼ� �ð�������� �����Ǿ� �־� ���� ����� �� ���� ���̴�.
	// ���� ������ ���� ������ HBox�� ���� ���� �е����� top�� left�� 50, right�� bottom�� 10���� �����ߴ�. �׸��� ������ Button�� �ٱ� ���� �������� top�� right�� 10, bottom�� left�� 50���� �����ߴ�.
	// ������ �ּ����� ó���س��� ���� �����غ���.
	
			//	FXML Writing Rule		FXML �ۼ� ��Ģ
	
	// FXML�� ����� �±״� �ڹ� �ڵ�� ��ȯ�Ǿ� ����Ǳ� ������ �ڹ� �ڵ�� ���� ���谡 �����Ѵ�. �� ���� ���踸 �� �����ϸ� JavaFX API ��ť��Ʈ�� �����ؼ� FXML �±׸� ���� �ۼ��� �� �ִ�.
	// ������ ���α׷��� ���̾ƿ� �ڹ� �ڵ�� FXML ���̾ƿ� �±׸� ���ν�Ų ǥ�̴�.
	
	//	���α׷��� ���̾ƿ� �ڹ� �ڵ�								FXML ���̾ƿ� �±�
	//	��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//	HBox hbox = new HBox();							<HBox xmlns:fx="http://javafx.com/fxml">
	//	hbox.setPadding(new Insets(10, 10, 10, 10));		<padding>
	//	hbox.setSpacing(10);									<Insets top="10" right="10"
	//																	bottom="10" left="10"/>
	//														</padding>
	//														<spacing>10</spacing>
	//													</HBox>
	//	��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//	TextField textField = new TextField();			<TextField>
	//	textField.setPrefWidth(200);						<prefWidth>200</prefWidth>
	//													</TextField>
	//	��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//	Button button = new Button();					<Button>
	//	button.setText("Ȯ��");								<Text>Ȯ��</Text>
	//													<Button>
	//	��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	//	ObservableList list = hbox.getChildren();		<children>
	//	list.add(textField);								<TextField>...</TextField>
	//	list.add(button);									<Button>...<Button>
	//													</children>
	//	��������������������������������������������������������������������������������������������������������������������������������������������������������������������������������
	
	// FXML�� XML ����� ��ũ�� ����̱� ������ XML �ۼ� ��Ģ�� �� ���Ѽ� �ۼ��ؾ� �Ѵ�.
	// FXML �±׸� ������ �ܿ�⺸�ٴ� �ڹ� �ڵ�� ���εǴ� FXML �ۼ� ��Ģ�� �����ϸ� FXML�� ���� ���� �� �ִ�.
	// �׷� FXML �ۼ� ��Ģ�� �ڼ��� ���캸��� ����.
	
			/*	Package Declaration		��Ű�� ����		*/
	
	// �ڹ� �ڵ��� ��Ű�� ����� ���εǴ� FXML �±״� <?import?>�̴�. Ŭ���� �ϳ��� import�ϴ� ����� ���� ��Ű���� ��� Ŭ������ import�ϴ� ����� ������ ����.
	
	//	�ڹ� �ڵ�									FXML �±�
	//	
	//	import javafx.scene.layout.HBox;		<?import javafx.scene.layout.HBox?>
	//	import javafx.scene.control.*;			<?import javafx.scene.control.*?>
	
	// <?import?> �±׸� �ۼ��ϴ� ��ġ�� ������ �ִµ�, XML ���� �±��� <?xml version="1.0" encoding="UTF-8"?>�� ��Ʈ �����̳� �±� ���̴�.
	
	//	<?xml version="1.0" encoding="UTF-8"?>
	//
	//	<?import javafx.scene.layout.HBox?>
	//	<?import javafx.scene.control.*?>
	//
	//	<��Ʈ�����̳� xmlns:fx="http://javafx.com/fxml">
	//		...
	//	</��Ʈ�����̳�>
	
	// FXML �±��� �̸��� �ϳ��� JavaFX API Ŭ���� �̸��� ���εǱ� ������ �ش� Ŭ������ �����ϴ� ��Ű���� �ݵ�� <?import?> �±׷� �����ؾ� �ȴ�.
	// �׷��� ������ FXML�� �ε��� �� not a valid type�̶�� �޼����� �԰� javafx.fxml.LoadException�� �߻��Ѵ�.
	
			/*	Tag Declaration		�±� ����		*/
	
	// FXML �±״� < �� > ���̿� �±� �̸��� �ۼ��ϴ� ���ε�, �ݵ�� ���� �±װ� ������ �� �±׵� �־�� �Ѵ�.
	// �׷��� ������ javax.xml.stream.XMLStreamException ���ܰ� �߻��Ѵ�.
	
	//	<�±��̸�>	...	</�±��̸�>
	
	// ���� �±׿� �� �±� ���̿��� �±� ������ �ۼ��Ǵµ�, �±� ������ ���� ��쿡�� ������ ���� ���� �±׿� />�� ���̰� �� �±׸� ������ �� �ִ�.
	
	//	<�±��̸�/>
	
	// �±� �̸��� JavaFX�� Ŭ�������̰ų�, Setter�� �޼ҵ���� �� �� �ִ�. ���� ǥ���� Button ��Ʈ���� �ڹ� �ڵ�� �ۼ��� �Ͱ� FXML �±׷� �ۼ��� ���� ���غ��� ���� ���ذ� �� ���̴�.
	
	//	�ڹ� �ڵ�								FXML
	//
	//	Button button = new Button();		<Button>
	//	button.setText("Ȯ��");					<text>Ȯ��</text>
	//										</Button>
	
			/*	Properties Declaration		�Ӽ� ����	*/
	
	// FXML �±״� ������ ���� �Ӽ��� ���� �� �ִ�. �Ӽ����� ū����ǥ(") �Ǵ� ��������ǥ(')�� �ݵ�� ���ξ� �Ѵ�. �׷��� ������ javax.xml.stream.XMLStreamExceotion ���ܰ� �߻��Ѵ�.
	
	//	<�±��̸�	�Ӽ���="��"	�Ӽ���="��"> ... </�±��̸�>
	
	// �Ӽ����� Setter �޼ҵ���� ���µ�, ��� Setter�� ���� �� �ִ� ���� �ƴϰ�, �⺻ Ÿ��(boolean, byte, short, char, int, long, float, double)�� ���� �����ϰų�,
	// String(���ڿ�)�� �����ϴ� Setter�� �� �� �ִ�. ���� ��� Button�� ���ڸ� ������ �� setText() �żҵ带 ����ϴµ�, �Ű����� ���ڿ��̹Ƿ� ������ ���� text �Ӽ����� �ۼ��� �� �ִ�.
	
	//	�ڹ� �ڵ�								FXML						FXML (Setter �Ӽ�)
	//
	//	Button button = new Button();		<Button>					<Button text="Ȯ��"/>
	//	button.setText("Ȯ��");					<text>Ȯ��</text>
	//										</Button>
	
			/*	Object Declaration		��ü ����		*/
	
	// Setter �޼ҵ尡 �⺻ Ÿ�԰� String Ÿ���� �ƴ� �ٸ� Ÿ���� ��ü�� �Ű������� ���´ٸ� �Ӽ����� �ۼ��� �� ����, �±׷� �ۼ��ؾ� �Ѵ�.
	// �̶� �Ű����� ��ü�� �±׷� �����ϴ� ����� �˾ƺ���.
	
			/*	|	<Ŭ���� �Ӽ�="��"/>	|	*/
	
	// �Ϲ������� ������ ���� Ŭ���������� �±׸� �ۼ��ϸ� new �����ڷ� �⺻ �����ڸ� ȣ���ؼ� ��ü�� �����Ѵ�.
	
	//	<Ŭ����>
	
	// ���� �����ڿ� �Ű� ������ �ְ�, �Ű� ������ @NamedArg(javafx.beans.NamedArg) ������̼��� ����Ǿ� �ִٸ� �Ӽ����̳� �ڽ� �±׷� �ۼ��� �� �ִ�.
	
	//	<Ŭ���� �Ű�����="��">		|	<Ŭ����>
	//	</Ŭ����>					|		<�Ű�����>��</�Ű�����>
	//							|	</Ŭ����>
	
	// ���� ��� HBox�� �е��� ������ �� setPadding(Insets value) �޼ҵ带 ����ϴµ�, Insets�� �⺻ �����ڰ� ����, Insets(double topRightBottomLeft) �Ǵ�
	// Insets(double top, double right, double bottom, double left)�� �ִ�. �� ��� Insets ��ü�� FXML�� �����ϸ� ������ ����.
	
	//	�ڹ� �ڵ�												FXML
	//
	//	HBox hbox = new HBox();								<HBox>
	//	hbox.setPadding(new Insets(10, 10, 10, 10));			<padding>
	//																<Insets top="10" right="10"
	//																		bottom="10" left="10"/>
	//															</padding>
	//														</HBox>
	
			/*	|	<Ŭ���� fx:value="��">	|	*/
	
	// Ŭ������ valueOf(String) �޼ҵ带 �����ؼ� ��ü�� �����ϴ� ��찡 �ִ�.
	// ���� ���, String, Integer, Double, Boolean Ŭ������ valueOf(String)�� ȣ���ؼ� ��ü�� �����Ѵ�. �� ��� ������ ���� FXML �±׸� �ۼ��� �� �ִ�.

	//	<Ŭ���� fx:value="��" />
	
	// ���� ��� String, Integer, Double, Boolean ��ü�� FXML�� �����ϸ� ������ ����.
	
	//	�ڹ� �ڵ�									FXML
	//
	//	String.valueOf("Hello, World!");		<String fx:value="Hello, World!"/>
	//	Integer.valueOf("1");					<Integer fx:value="1"/>
	//	Double.valueOf("1.0");					<Double fx:value="1.0"/>
	//	Boolean.valueOf("false");				<Boolean fx:value="false"/>
	
			/*	|	<Ŭ���� fx:constant="���"/>	|	*/
	
	// Ŭ������ ���ǵ� ������� ��� ���� ��쿡�� ������ ���� FXML �±׸� �ۼ��� �� �ִ�.
	
	//	<Ŭ���� fx:constant="���"/>
	
	// ���� ��� Double.MAX_VALUE ������� Button ��Ʈ���� maxWidth �Ӽ������� ������ ��� ������ ���� FXML�� ������ �� �ִ�.
	
	//	�ڹ� �ڵ�								FXML
	//	
	//	Button button = new Button();		<Button>
	//	button.setMaxWidth(						<maxWidth>
	//		Double.MAX_VALUE						<Double fx:constant="MAX_VALUE"/>
	//	);										</maxWidth>
	//										</Button>
	
			/*	|	<Ŭ���� fx:factory="�����޼ҵ�">	|	*/
	
	// � Ŭ������ new �����ڷ� ��ü�� ������ �� ����, ���� �޼ҵ�� ��ü�� ���� �ϴ� ��쵵 �ִ�. �� ��� ������ ���� FXML �±׷� �ۼ��� �� �ִ�.
	
	// <Ŭ���� fx:factory="�����޼ҵ�">
	
	// ���� ��� ComboBox�� setItems(ObservableList<T> value) �޼ҵ�� javafx.collecttions.ObservableList �������̽� Ÿ���� ���� ��ü�� �Ű������� �����µ�,
	// ObservableList�� ���� ��ü�� javafx.collections.FXCollections�� ���� �޼ҵ��� observableArrayList(E... items) �޼ҵ�� ���� �� �ִ�.
	// �׷��� ������ ���� FXML�� �ۼ��ؾ� �Ѵ�.
	
	//	�ڹ� �ڵ�											FXML
	//
	//	ComboBox combo = new ComboBox();				<ComboBox>
	//	combo.setItems(										<items>
	//		FXCollections. observableArrayList(					<FXCollections fx:factory="observableArrayList">
	//			"����", "�����"										<String fx:value="����"/>
	//		)														<String fx:value="�����"/>
	//	);														</FXCollections>
	//														</items>
	//													</ComboBox>
	
			//	FXML Loading And Scene Creation		FXML �ε��� Scene ����
	
	// FXML ������ �����ߴٸ�, FXML ������ �о��� ����� ������ ��üȭ�ؾ� �Ѵ�. �̰��� FXML �ε��̶�� �Ѵ�.
	// FXML ������ �ε��ϱ� ���ؼ��� javafx.fxml.FXMLLoader�� ����ؾ� �ϴµ�, FXMLLoader�� �� ���� ������ �ε� �޼ҵ带 ������ �ִ�. 
	// �ϳ��� ���� �޼ҵ��� load()�̰�, �ٸ� �ϳ��� �ν��Ͻ� �޼ҵ��� load()�̴�. 
	// ������ FXML ������ Ŭ������ ������ ��Ű���� ���� ��� ���� load() �޼ҵ�� FXML ������ �ε��ϴ� �ڵ��̴�.
	
	//	Parent root = FXMLLoader.load(getClass().getResource("xxx.fxml"));
	
	// getClass()�� ���� Ŭ������ �����ϰ�, getResource()�� Ŭ������ ��ġ�ϴ� ������ ��� ��η� ���ҽ��� URL�� �����Ѵ�.
	// ������ �ν��Ͻ� load() �޼ҵ�� FXML ������ �ε��ϴ� �ڵ��̴�.
	
	//	FXMLLoader loader = new FXMLLoader(getClass().getResource("xxx.fxml"));
	//	Parent root = (Parent) loader.load();
	
	// load() �޼ҵ尡 �����ϴ� Ÿ���� Parent Ÿ���ε�, ���� ��ü�� FXML ���Ͽ��� ��Ʈ �±׷� ����� �����̳��̴�.
	// ���� FXML ���Ͽ��� ��Ʈ �±װ� <HBox>��� ������ ���� Ÿ�� ��ȯ�� �����ϴ�.
	
	//	HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("xxx.fxml"));
	
	// FXML ���Ϸ� �ε��ؼ� Parent ��ü�� ����ٸ� �̰��� ������ ������ ���� ���(Scene) ��ü�� �����ϸ� �ȴ�.
	
	//	Scene scene = new Scene(root);
	
	// ������ ���캸��.
	
			//	JavaFX Scene Builder
	
	// �ڹ� �ڵ忡 �ͼ��� �����ڵ��� �ڹ� �ڵ�� �и��� FXML ������ ������ �����ؼ� �ۼ��ؾ� �ϹǷ� ó������ �������� ������. 
	// ����Ŭ�� FXML�� �ͼ����� ���� �����ڵ��� ���� FXML�� �ڵ����� �������ִ� JavaFX Scene Builder�� �����ϰ� �ִ�.
	// UI ��Ʈ�� ��Ͽ��� �巡���ؼ� ������ ������ ����ϸ� JavaFX Scene Builder�� �ڵ����� FXML�� �����س���.
	
	// JavaFX Scene Builder�� ��ġ ������ �ٿ�ε� �޾�, ��ġ �� ���������� ������ �� ������, ��Ŭ������ e(fx)clipse �÷������� ��ġ�ϸ� ���� ���ϰ� ����� �� �ִ�.
	// ��Ŭ���� �޴����� [Help -> Eclipse Marketplace]�� �����ϸ� �÷������� �˻��� �� �ִ� ��ȭ���ڰ� ��Ÿ����.
	// [Find] �Է¶��� JavaFX��� �Է��ϰ� �˻��غ��� e(fx)clipse�� ã�� �� �ִ�. ��ġ�� ���� �ϴ��� [Install] ��ư�� Ŭ���ϸ� �ȴ�.
	// ������ ���� PC�� JavaFX Scene Builder�� ���� ��ġ�� ���� e(fx)clipse �÷������� ��ġ�ؾ� �Ѵ�.
	// e(fx)clipse �÷����ο��� JavaFX Scene Builder�� ���ԵǾ� ���� �ʱ� �����̴�. e(fx)clipse �÷������� ��ġ�� �Ŀ��� ��Ŭ���� �޴�����
	// [Window -> Preferences -> JavaFX] �׸��� �����ϰ� [SceneBuilder executable]�� JavaFX Scene Builder ���� ������ ��η� �Ǿ� �ִ��� Ȯ���ؾ� �Ѵ�.
	// ���� ����ְų�, ��ΰ� �ùٸ��� ������ [Browse...] ��ư�� Ŭ���ؼ� �������ش�.
	// ��δ� ��ġ�� ���Ͽ��� JavaFX Scene Builder.exe�� �������ָ�ȴ�.
	
	// ��ġ�� ����� �Ǿ��ٸ� ��Ŭ���� �޴����� [File -> New -> Other..]�� �����ؼ� JavaFX Wizard���� �߰��Ǿ� �ִ��� Ȯ���Ѵ�.
	// 1�忡�� ������ Ǯ�ο�(full - in - one) ���� ������ C:\JavaProgramming�� �����Ͽ� ����ϰ� �ִٸ� JavaFX Scene Builder�� e(fx)clipse �÷������� ��ġ���� �ʾƵ� �̹� ��ġ�Ǿ� ���� ���̴�.
	
	// ��Ŭ�������� JavaFX Scene Builder�� �����Ϸ��� ���� FXML ������ �����ؾ� �Ѵ�. ��Ŭ���� Package Explorer���� FXML ������ ��ġ�� ��Ű���� �����ϰ� ���콺 ������ ��ư�� Ŭ���� ��,
	// [New -> Other -> JavaFX -> New FXML Document]�� �����Ѵ�. [FXML File] ��ȭ���ڿ��� [Name] �Է¶��� ������ ���ϸ��� �Է��ϰ� Root Element�� ��Ʈ �����̳ʰ� �� Ŭ������ ������ ��,
	// [Finish] ��ư�� Ŭ���ϸ� FXML ������ �����ȴ�. ������ Root Element�� HBox�� �����ϰ� ������ FXML ���� ������ �����ش�.
	
	//	<?xml version="1.0" encoding="UTF-8"?>
	//
	//	<?import javafx.scene.layout.HBox?>
	//
	//	<HBox xmlns:fx="http://javafx.com/fxml">
	//		<!-- TODO Add Nodes -->
	//	</HBox>

	// FXML ������ �����ϱ� ���� JavaFX Scene Builder�� �����Ϸ��� ��Ŭ���� Package Explorer���� FXML ������ �����ϰ� ���콺 ������ ��ư�� Ŭ���� �� [Open With SceneBuilder]�� �����ϸ� �ȴ�.
	// ���� ����� JavaFX Scene Builder�� ���ʿ� �ִ� [Containers]�� [Controls] �޴����� �׸��� �巡���ؼ� �߾��� ������ ������ ��ӽ�Ű�� ��ġ�� �Ǵµ�, ��ġ�� �׸��� �Ӽ��� �����ʿ� �ִ�
	// [Properties]�� [Layout] �޴����� �����ϸ� �ȴ�. ���̾ƿ��� �ϼ��ߴٸ� �޴����� [File -> Save]�� �����ؼ� FXML ���Ϸ� �����ϸ� �ȴ�.
}
