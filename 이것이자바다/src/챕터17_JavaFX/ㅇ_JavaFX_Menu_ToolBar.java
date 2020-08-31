package é��17_JavaFX;

public class ��_JavaFX_Menu_ToolBar {
	// UI ���ø����̼ǿ��� �޴��ٿ� ���ٴ� ���� �� ���� ����̴�. JavaFX�� �޴��� ���ٸ� ������ �� �ֵ��� MenuBar�� Toolbar ��Ʈ���� �����Ѵ�.
	
			//	MenuBar Control
	
	// MenuBar ��Ʈ���� �����̳� ��ܿ� ��ġ�Ǿ�, �پ��� �۾��� ���� �����ϵ��� ���ش�. MenuBar���� Menu���� ��ġ�Ǵµ�, ������ �׸����� "����", "����"�� Menu�� �ش�ȴ�.
	// Menu���� �޴� �������� MenuItem, CheckMenuItem, RadioMenuItem, CustomMenuItem, SeparatorMenuItem�� �߰��� �� �ְ�, 
	// ���� �޴��� ���� Menu�� �߰��� �� �ִ�. 
	
	//			��������������������������
	//			������ ����		��
	//			���� ���� �����	��
	//			���� ����		��
	//			���� ����		��
	//			��������������������������
	//			��������		��
	//			��������������������������
	
	// ���� ���� "���� �����", "����", "����", "������"�� MennuItem�� �ش�ǰ�, ���� ���м��� SeparatorMenuItem�̴�.
	// CheckMenuItem, RadioMenuItem�� �� ���� ���¸� ������ �޴� ���������� CheckMenuItem�� Ŭ���ϸ� ����, �ٽ� Ŭ���ϸ� �̼����� �ȴ�.
	// ������ ToogleGroup�� �����ϴ� RadioMenuItem���� �ϳ��� Ŭ���ϸ� �ٸ� �͵��� ���� �����ȴ�.
	// ������ FXML�� MenuBar ��Ʈ���� �����ϴ� ����� �����ش�.
	
	//	<MenuBar>
	//		<menus>
	//			<Menu text="����" > ... </Menu>
	//			<Menu text="���� > ... </Menu>
	//		</menus>
	//	<MenuBar>
	
	// ������ "����" �޴��� �޴� �������� �߰��ϴ� ����� �����ش�.
	
	//	<Menu text="����" >
	//		<items>
	//			<MenuItem text="���θ����" onAction="#handleNew" >
	//				<accelerator>
	//					<KeyCodeCombination alt="DOWN" code="N" control="UP" meta="UP"
	//										shift="DOWN" shortcut="UP" />
	//				</accelerator>
	//			<graphic>
	//				<ImageView><image><Image url="@icon/new.png" /></image></ImageView>
	//			<graphic>
	//		</items>
	//	</Menu>
	
	//	MenuItem�� Button�� ���������� Ŭ���ϸ� onAction �Ӽ��� ������ ��Ʈ�ѷ��� �޼ҵ带 ȣ���ؼ� ActionEvent�� ó���Ѵ�.
	// <accelerator>�� ����⸦ �����ϴµ�, ������ KeyCodeCombination ��ü�� �����Ѵ�. AltŰ, ControlŰ, ShiftŰ, codeŰ�� �������� ������ �� �ִµ�,
	// DOWN���� ������ Ű�� codeŰ�� ���ÿ� ������ onAction �Ӽ��� ������ �޼ҵ尡 ȣ��ȴ�.
	// "���θ����" �޴� �������� ��� Alt + Shift + N �� ���ÿ� ������ handleNew() �޼ҵ尡 ����ȴ�. <graphic>�� �޴� ������ �տ� �������� �߰��Ѵ�.
	
			/*	Toolbar Control	*/
	
	// �������� �۾� ���� ����� MenuBar ��Ʈ���� ���ϳ�, ������ �۾��� �����ϰ� �ʹٸ� Toolbar ��Ʈ���� �߰��ϴ� ���� ����.
	// Toolbar ��Ʈ���� UI ��Ʈ���̸鼭 �����̳��̱⵵ �ϴ�. �ַ� Button�� �߰�������, ComboBox�� ���� �ٸ� ��Ʈ�ѵ� ��ġ�� �� �ִ�.
	// ������ FXML�� Toolbar�� �����ϴ� ����� �����ش�.
	
	//	<ToolBar>
	//		<item>
	//			<Button onAction="#hadleNew" >
	//				<graphic>
	//					<ImageView><image><Image url="@icons/new.png" /></image></ImageView>
	//				</graphic>
	//			</Button>
	//		</item>
	//	</ToolBar>
	
	// ������ ��ܿ� MenuBar�� ToolBar�� �߰��ϰ� �߾ӿ��� TextArea�� �߰��ؼ� ������ �޸����� ���� ���̴�. 
	// MenuBar�� �޴� �����۰� ToolBar�� ��ư�� ���ϸ� TextArea�� ���õ� �۾� ������ ��µȴ�.
}
