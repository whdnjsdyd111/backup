package 챕터17_JavaFX;

public class ㅇ_JavaFX_Menu_ToolBar {
	// UI 애플리케이션에서 메뉴바와 툴바는 빠질 수 없는 요소이다. JavaFX도 메뉴와 툴바를 생성할 수 있도록 MenuBar와 Toolbar 컨트롤을 제공한다.
	
			//	MenuBar Control
	
	// MenuBar 컨트롤은 컨테이너 상단에 배치되어, 다양한 작업을 쉽게 선택하도록 해준다. MenuBar에는 Menu들이 배치되는데, 오른쪽 그림에서 "파일", "편집"이 Menu에 해당된다.
	// Menu에는 메뉴 아이템을 MenuItem, CheckMenuItem, RadioMenuItem, CustomMenuItem, SeparatorMenuItem을 추가할 수 있고, 
	// 서브 메뉴를 갖는 Menu도 추가할 수 있다. 
	
	//			┌───────────┐
	//			│파일 편집		│
	//			│■ 새로 만들기	│
	//			│■ 열기		│
	//			│□ 저장		│
	//			│───────────│
	//			│끝내기		│
	//			└───────────┘
	
	// 위와 같이 "새로 만들기", "열기", "저장", "끝내기"가 MennuItem에 해당되고, 가로 구분선은 SeparatorMenuItem이다.
	// CheckMenuItem, RadioMenuItem은 두 가지 상태를 가지는 메뉴 아이템으로 CheckMenuItem을 클릭하면 선택, 다시 클릭하면 미선택이 된다.
	// 동일한 ToogleGroup을 참조하는 RadioMenuItem들은 하나를 클릭하면 다른 것들이 선택 해제된다.
	// 다음은 FXML로 MenuBar 컨트롤을 선언하는 방법을 보여준다.
	
	//	<MenuBar>
	//		<menus>
	//			<Menu text="파일" > ... </Menu>
	//			<Menu text="편집 > ... </Menu>
	//		</menus>
	//	<MenuBar>
	
	// 다음은 "파일" 메뉴의 메뉴 아이템을 추가하는 방법을 보여준다.
	
	//	<Menu text="파일" >
	//		<items>
	//			<MenuItem text="새로만들기" onAction="#handleNew" >
	//				<accelerator>
	//					<KeyCodeCombination alt="DOWN" code="N" control="UP" meta="UP"
	//										shift="DOWN" shortcut="UP" />
	//				</accelerator>
	//			<graphic>
	//				<ImageView><image><Image url="@icon/new.png" /></image></ImageView>
	//			<graphic>
	//		</items>
	//	</Menu>
	
	//	MenuItem도 Button과 마찬가지로 클릭하면 onAction 속성에 지정된 컨트롤러의 메소드를 호출해서 ActionEvent를 처리한다.
	// <accelerator>는 단축기를 설정하는데, 단축기는 KeyCodeCombination 객체로 생성한다. Alt키, Control키, Shift키, code키의 조합으로 구성할 수 있는데,
	// DOWN으로 설정된 키와 code키를 동시에 누르면 onAction 속성에 지정된 메소드가 호출된다.
	// "새로만들기" 메뉴 아이템일 경우 Alt + Shift + N 을 동시에 누르면 handleNew() 메소드가 실행된다. <graphic>는 메뉴 아이템 앞에 아이콘을 추가한다.
	
			/*	Toolbar Control	*/
	
	// 계층적인 작업 선택 기능은 MenuBar 컨트롤이 편리하나, 빠르게 작업을 선택하고 싶다면 Toolbar 컨트롤을 추가하는 것이 좋다.
	// Toolbar 컨트롤은 UI 컨트롤이면서 컨테이너이기도 하다. 주로 Button이 추가되지만, ComboBox와 같은 다른 컨트롤도 배치할 수 있다.
	// 다음은 FXML로 Toolbar를 선언하는 방법을 보여준다.
	
	//	<ToolBar>
	//		<item>
	//			<Button onAction="#hadleNew" >
	//				<graphic>
	//					<ImageView><image><Image url="@icons/new.png" /></image></ImageView>
	//				</graphic>
	//			</Button>
	//		</item>
	//	</ToolBar>
	
	// 다음은 상단에 MenuBar와 ToolBar를 추가하고 중앙에는 TextArea를 추가해서 간단한 메모장을 만든 것이다. 
	// MenuBar의 메뉴 아이템과 ToolBar의 버튼을 쿨릭하면 TextArea에 선택된 작업 내용이 출력된다.
}
