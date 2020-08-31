package 챕터17_JavaFX;

public class ㄷ_JavaFX_Layout {
	// 장면(Scene)에는 다양한 컨트롤이 포함되는데 이들을 배치하는 것이 레이아웃(Layout)이다.
	// 레이아웃을 작성하는 방법은 두 가지가 있다. 하나는 자바 코드로 작성하는 프로그램적 레이아웃이고, 다른 하나는 FXML로 작성하는 선언적 레이아웃이다.
	
			//	Program Layout		프로그램적 레이아웃
	
	// 프로그램적 레이아웃이란 자바 코드로 UI 컨트롤을 배치하는 것을 말한다. 자바 코드에 익숙한 개발자들이 선호하는 방식으로 컨트롤 배치, 스타일 지정, 이벤트 처리 등을 모두 자바 코드로 작성한다.
	// 레이아웃이 복잡해지면 프로그램적 방법은 코드까지 복잡해져 난해한 프로그램이 될 확률이 높아진다. 또한 모든 것을 개발자가 직접 작생해야 하므로 디자이너와 협력해서 개발하는 것도 어렵다.
	// 개발을 완료한 후, 간단한 레이아웃 변경이나 스타일 변경이 필요하면 자바 소스를 수정하고 재컴파일해야 한다는 단점도 있다.
	// 다음 예제는 다음과 같은 레이아웃을 프로그램적 방법으로 작성한 것이다. 
	// 텍스트를 입력할 수 있는 TextField 컨트롤과 클릭할 수 있는 Button 컨트롤이 수평으로 나란히 배치되어 있기 때문에 Parent 루트 컨테이너로 HBox를 사용하였다.
	
	//		AppMain
	//		┌───────────────────────────────┐
	//		│ㅣ								│	확인
	//		└───────────────────────────────┘
	
			//	FXML Layout		FXML 레이아웃
	
	// FXML은 XML 기반의 마크업 언어로, JavaFX 애플리케이션의 UI 레이아웃을 자바 코드에서 분리해서 태그로 선언하는 방법을 제공한다.
	// 이 방법은 안드로이드(Android) 앱을 개발하는 방법과 유사한데, 안드로이드는 XML로 레이아웃을 작성하고, 자바로 이벤트 처리 및 애플리케이션 로직을 작성한다.
	
	// FXML 태그로 레이아웃을 정의하기 때문에 태그에 익숙한 디자이너와 협업이 가능하다. 또한 개발 완료 후 간단한 레이아웃 변경이나 스타일 변경이 필요할 경우에는 자바 소스를 수정할 필요없이 FXML 태그만 수정하면 된다.
	// 그리고 레이아웃이 비슷한 장면(Scene)들 간에 재사용이 가능하기 때문에 개발 기간을 단축시시킬 수도 있다. 다음은 프로그램적 레이아웃에서 살펴보았던 동일한 레이아웃을 FXML로 작성한 코드이다.
	
	// 루트 컨테이너인 HBox는 <HBox> 태그로 작성되고, fx 접두사에 대한 네임스페이스 선언 (xmls:fx="http://javafx.com/fxml")이 추가되어 있는 것을 볼 수 있다.
	// 이것은 FXML 파일에 <fx:XXX> 형태의 태그 및 fx:xxx="값" 형태의 속성을 작성할 수 있다는 뜻인데, 이러한 태그와 속성은 컨트롤 배치보다는 FXML 파일의 내부 처리에 사용된다.
	
			//	Layout Blank: Padding And Margin	레이아웃 여백: 페딩과 마진
	
	// 컨트롤을 보기 좋게 배치하기 위해서 여백이 거의 필수적으로 들어간다. 여백은 패딩(padding)과 마진(margin)이 있는데, 패딩은 안쪽 여백을 말하고 마진은 바깥 여백을 말한다.
	// 패딩은 해당 컨테이너의 setPadding() 메소드를 사용해서 설정하는 반면, 마진은 바깥 컨테이너의 setMargin() 메소드를 사용해야 한다.
	// 예를 들어 Button이 HBox에 포함되어 있을 때 HBox에서 패딩을 50으로 주는 것과 Button에서 마진을 50으로 주는 것은 동일한 결과를 얻지만 코드는 다르다.
	
	//	구분		HBox의 패딩										Button의 마진
	//
	//			HBox											HBox
	//	개녕		┌───────────────┐								┌───────────────┐
	//			│		↓		│								│		↑		│
	//			│	→ Button ←	│								│	← Button →	│
	//			│		↑		│								│		↓		│
	//			└───────────────┘								└───────────────┘
	//
	//	자바		HBox hbox = new HBox();							Button button = new Button();
	//	코드		hbox.setPadding(new Insets(50));				HBox.setMargin(button, new Insets(50));
	//
	//	FXML	<Hbox>											<Button>
	//	태그			<padding>										<HBox.margin>
	//					<Insets topRightBottomLeft="50"/>				<Insets topRightBottomLeft="50"/>
	//				</padding>										</HBox.margin>
	//			</HBox>											</Button>
	
	// 마진과 패딩은 적용하는 위치에 따라 top, right, bottom, left로 구분된다.
	
	//	컨테이너A
	//	
	//	┌───────────────────────────┐			┌───────────────────────────┐	
	//	│			│ 컨테이너A의		│컨테이너A의	│			 컨테이너A의 right	│
	//	│			↓ top padding	│	right	│				내용 ←───────	│
	//	│			내용				│─────────→	│					padding	│
	//	└───────────────────────────┘	margin	└───────────────────────────┘
	
	// 마진과 패딩값은 javafx.geometry.Insets 객체로 제공해야 하는데 다음과 같이 생성한다.
	
	//	// top, right, bottom, left를 모두 동일한 값으로 설정할 때
	//	new Insets(double topRightBottomLeft);
	//
	//	// top, right, bottom, left를 다른 값으로 설정할 때
	//	new Insets(double top, double right, double bottom, double left)
	
	// 매개값의 순서는 top으로 시작해서 시계방향으로 나열되어 있어 쉽게 기억할 수 있을 것이다.
	// 다음 예제를 보면 라인은 HBox의 안쪽 여백 패딩으로 top과 left는 50, right와 bottom은 10으로 설정했다. 그리고 라인은 Button의 바깥 여백 마진으로 top과 right는 10, bottom과 left는 50으로 설정했다.
	// 한쪽을 주석으로 처리해놓고 각각 실행해보자.
	
			//	FXML Writing Rule		FXML 작성 규칙
	
	// FXML로 선언된 태그는 자바 코드로 변환되어 실행되기 때문에 자바 코드와 매핑 관계가 존재한다. 이 매핑 관계만 잘 이해하면 JavaFX API 도큐먼트를 참조해서 FXML 태그를 쉽게 작성할 수 있다.
	// 다음은 프로그램적 레이아웃 자바 코드와 FXML 레이아웃 태그를 매핑시킨 표이다.
	
	//	프로그램적 레이아웃 자바 코드								FXML 레이아웃 태그
	//	────────────────────────────────────────────────────────────────────────────────────────
	//	HBox hbox = new HBox();							<HBox xmlns:fx="http://javafx.com/fxml">
	//	hbox.setPadding(new Insets(10, 10, 10, 10));		<padding>
	//	hbox.setSpacing(10);									<Insets top="10" right="10"
	//																	bottom="10" left="10"/>
	//														</padding>
	//														<spacing>10</spacing>
	//													</HBox>
	//	────────────────────────────────────────────────────────────────────────────────────────
	//	TextField textField = new TextField();			<TextField>
	//	textField.setPrefWidth(200);						<prefWidth>200</prefWidth>
	//													</TextField>
	//	────────────────────────────────────────────────────────────────────────────────────────
	//	Button button = new Button();					<Button>
	//	button.setText("확인");								<Text>확인</Text>
	//													<Button>
	//	────────────────────────────────────────────────────────────────────────────────────────
	//	ObservableList list = hbox.getChildren();		<children>
	//	list.add(textField);								<TextField>...</TextField>
	//	list.add(button);									<Button>...<Button>
	//													</children>
	//	────────────────────────────────────────────────────────────────────────────────────────
	
	// FXML은 XML 기반의 마크업 언어이기 때문에 XML 작성 규칙을 잘 지켜서 작성해야 한다.
	// FXML 태그를 무조건 외우기보다는 자바 코드와 매핑되는 FXML 작성 규칙을 이해하면 FXML을 빨리 익힐 수 있다.
	// 그럼 FXML 작성 규칙을 자세히 살펴보기로 하자.
	
			/*	Package Declaration		패키지 선언		*/
	
	// 자바 코드의 패키지 선언과 매핑되는 FXML 태그는 <?import?>이다. 클래스 하나를 import하는 방법과 같은 패키지의 모든 클래스를 import하는 방법은 다음과 같다.
	
	//	자바 코드									FXML 태그
	//	
	//	import javafx.scene.layout.HBox;		<?import javafx.scene.layout.HBox?>
	//	import javafx.scene.control.*;			<?import javafx.scene.control.*?>
	
	// <?import?> 태그를 작성하는 위치는 정해져 있는데, XML 선언 태그인 <?xml version="1.0" encoding="UTF-8"?>과 루트 컨테이너 태그 사이다.
	
	//	<?xml version="1.0" encoding="UTF-8"?>
	//
	//	<?import javafx.scene.layout.HBox?>
	//	<?import javafx.scene.control.*?>
	//
	//	<루트컨테이너 xmlns:fx="http://javafx.com/fxml">
	//		...
	//	</루트컨테이너>
	
	// FXML 태그의 이름은 하나의 JavaFX API 클래스 이름과 매핑되기 때문에 해당 클래스가 존재하는 패키지를 반드시 <?import?> 태그로 선언해야 된다.
	// 그렇지 않으면 FXML을 로딩할 때 not a valid type이라는 메세지와 함계 javafx.fxml.LoadException이 발생한다.
	
			/*	Tag Declaration		태그 선언		*/
	
	// FXML 태그는 < 와 > 사이에 태그 이름을 작성하는 것인데, 반드시 시작 태그가 있으면 끝 태그도 있어야 한다.
	// 그렇지 않으면 javax.xml.stream.XMLStreamException 예외가 발생한다.
	
	//	<태그이름>	...	</태그이름>
	
	// 시작 태그와 끝 태그 사이에는 태그 내용이 작성되는데, 태그 내용이 없을 경우에는 다음과 같이 시작 태그에 />를 붙이고 끝 태그를 생략할 수 있다.
	
	//	<태그이름/>
	
	// 태그 이름은 JavaFX의 클래스명이거나, Setter의 메소드명이 될 수 있다. 다음 표에서 Button 컨트롤을 자바 코드로 작성한 것과 FXML 태그로 작성한 것을 비교해보면 쉽게 이해가 될 것이다.
	
	//	자바 코드								FXML
	//
	//	Button button = new Button();		<Button>
	//	button.setText("확인");					<text>확인</text>
	//										</Button>
	
			/*	Properties Declaration		속성 선언	*/
	
	// FXML 태그는 다음과 같은 속성을 가질 수 있다. 속성값은 큰따옴표(") 또는 작은따옴표(')로 반드시 감싸야 한다. 그렇지 않으면 javax.xml.stream.XMLStreamExceotion 예외가 발생한다.
	
	//	<태그이름	속성명="값"	속성명="값"> ... </태그이름>
	
	// 속성명은 Setter 메소드명이 오는데, 모든 Setter가 사용될 수 있는 것은 아니고, 기본 타입(boolean, byte, short, char, int, long, float, double)의 값을 세팅하거나,
	// String(문자열)을 세팅하는 Setter만 올 수 있다. 예를 들어 Button의 글자를 설정할 때 setText() 매소드를 사용하는데, 매개값이 문자열이므로 다음과 같이 text 속성으로 작성할 수 있다.
	
	//	자바 코드								FXML						FXML (Setter 속성)
	//
	//	Button button = new Button();		<Button>					<Button text="확인"/>
	//	button.setText("확인");					<text>확인</text>
	//										</Button>
	
			/*	Object Declaration		객체 선언		*/
	
	// Setter 메소드가 기본 타입과 String 타입이 아닌 다른 타입의 객체를 매개값으로 갖는다면 속성으로 작성할 수 없고, 태그로 작성해야 한다.
	// 이때 매개값인 객체를 태그로 선언하는 방법을 알아보자.
	
			/*	|	<클래스 속성="값"/>	|	*/
	
	// 일반적으로 다음과 같이 클래스명으로 태그를 작성하면 new 연산자로 기본 생성자를 호출해서 객체를 생성한다.
	
	//	<클래스>
	
	// 만약 생성자에 매개 변수가 있고, 매개 변수에 @NamedArg(javafx.beans.NamedArg) 어노테이션이 적용되어 있다면 속성명이나 자식 태그로 작성할 수 있다.
	
	//	<클래스 매개변수="값">		|	<클래스>
	//	</클래스>					|		<매개변수>값</매개변수>
	//							|	</클래스>
	
	// 예를 들어 HBox의 패딩을 설정할 때 setPadding(Insets value) 메소드를 사용하는데, Insets는 기본 생성자가 없고, Insets(double topRightBottomLeft) 또는
	// Insets(double top, double right, double bottom, double left)만 있다. 이 경우 Insets 객체를 FXML로 선언하면 다음과 같다.
	
	//	자바 코드												FXML
	//
	//	HBox hbox = new HBox();								<HBox>
	//	hbox.setPadding(new Insets(10, 10, 10, 10));			<padding>
	//																<Insets top="10" right="10"
	//																		bottom="10" left="10"/>
	//															</padding>
	//														</HBox>
	
			/*	|	<클래스 fx:value="값">	|	*/
	
	// 클래스가 valueOf(String) 메소드를 제공해서 객체를 생성하는 경우가 있다.
	// 예를 들어, String, Integer, Double, Boolean 클래스는 valueOf(String)을 호출해서 객체를 생성한다. 이 경우 다음과 같이 FXML 태그를 작성할 수 있다.

	//	<클래스 fx:value="값" />
	
	// 예를 들어 String, Integer, Double, Boolean 객체를 FXML로 선언하면 다음과 같다.
	
	//	자바 코드									FXML
	//
	//	String.valueOf("Hello, World!");		<String fx:value="Hello, World!"/>
	//	Integer.valueOf("1");					<Integer fx:value="1"/>
	//	Double.valueOf("1.0");					<Double fx:value="1.0"/>
	//	Boolean.valueOf("false");				<Boolean fx:value="false"/>
	
			/*	|	<클래스 fx:constant="상수"/>	|	*/
	
	// 클래스에 정의된 상수값을 얻고 싶을 경우에는 다음과 같이 FXML 태그를 작성할 수 있다.
	
	//	<클래스 fx:constant="상수"/>
	
	// 예를 들어 Double.MAX_VALUE 상수값을 Button 컨트롤의 maxWidth 속성값으로 설정할 경우 다음과 같이 FXML로 선언할 수 있다.
	
	//	자바 코드								FXML
	//	
	//	Button button = new Button();		<Button>
	//	button.setMaxWidth(						<maxWidth>
	//		Double.MAX_VALUE						<Double fx:constant="MAX_VALUE"/>
	//	);										</maxWidth>
	//										</Button>
	
			/*	|	<클래스 fx:factory="정적메소드">	|	*/
	
	// 어떤 클래스는 new 연산자로 객체를 생성할 수 없고, 정적 메소드로 객체를 얻어야 하는 경우도 있다. 이 경우 다음과 같이 FXML 태그로 작성할 수 있다.
	
	// <클래스 fx:factory="정적메소드">
	
	// 예를 들어 ComboBox의 setItems(ObservableList<T> value) 메소드는 javafx.collecttions.ObservableList 인터페이스 타입의 구현 객체를 매개값으로 가지는데,
	// ObservableList의 구현 객체는 javafx.collections.FXCollections의 정적 메소드인 observableArrayList(E... items) 메소드로 얻을 수 있다.
	// 그래서 다음과 같이 FXML을 작성해야 한다.
	
	//	자바 코드											FXML
	//
	//	ComboBox combo = new ComboBox();				<ComboBox>
	//	combo.setItems(										<items>
	//		FXCollections. observableArrayList(					<FXCollections fx:factory="observableArrayList">
	//			"공개", "비공개"										<String fx:value="공개"/>
	//		)														<String fx:value="비공개"/>
	//	);														</FXCollections>
	//														</items>
	//													</ComboBox>
	
			//	FXML Loading And Scene Creation		FXML 로딩과 Scene 생성
	
	// FXML 파일을 저장했다면, FXML 파일을 읽어드려 선언된 내용을 객체화해야 한다. 이것을 FXML 로딩이라고 한다.
	// FXML 파일을 로딩하기 위해서는 javafx.fxml.FXMLLoader를 사용해야 하는데, FXMLLoader는 두 가지 종류의 로드 메소드를 가지고 있다. 
	// 하나는 정적 메소드인 load()이고, 다른 하나는 인스턴스 메소드인 load()이다. 
	// 다음은 FXML 파일이 클래스와 동일한 패키지에 있을 경우 정적 load() 메소드로 FXML 파일을 로딩하는 코드이다.
	
	//	Parent root = FXMLLoader.load(getClass().getResource("xxx.fxml"));
	
	// getClass()는 현재 클래스를 리턴하고, getResource()는 클래스가 위치하는 곳에서 상대 경로로 리소스의 URL을 리턴한다.
	// 다음은 인스턴스 load() 메소드로 FXML 파일을 로딩하는 코드이다.
	
	//	FXMLLoader loader = new FXMLLoader(getClass().getResource("xxx.fxml"));
	//	Parent root = (Parent) loader.load();
	
	// load() 메소드가 리턴하는 타입은 Parent 타입인데, 실제 객체는 FXML 파일에서 루트 태그로 선언된 컨테이너이다.
	// 만약 FXML 파일에서 루트 태그가 <HBox>라면 다음과 같이 타입 변환이 가능하다.
	
	//	HBox hbox = (HBox) FXMLLoader.load(getClass().getResource("xxx.fxml"));
	
	// FXML 파일로 로딩해서 Parent 객체를 얻었다면 이것을 가지고 다음과 같이 장면(Scene) 객체를 생성하면 된다.
	
	//	Scene scene = new Scene(root);
	
	// 예제로 살펴보자.
	
			//	JavaFX Scene Builder
	
	// 자바 코드에 익숙한 개발자들은 자바 코드와 분리된 FXML 파일을 별도로 생성해서 작성해야 하므로 처음에는 불편함을 느낀다. 
	// 오라클은 FXML에 익숙하지 않은 개발자들을 위해 FXML을 자동으로 생성해주는 JavaFX Scene Builder를 제공하고 있다.
	// UI 컨트롤 목록에서 드래그해서 디자인 영역에 드롭하면 JavaFX Scene Builder가 자동으로 FXML을 생성해낸다.
	
	// JavaFX Scene Builder는 설치 파일을 다운로드 받아, 설치 후 독립적으로 실행할 수 있지만, 이클립스에 e(fx)clipse 플러그인을 설치하면 보다 편리하게 사용할 수 있다.
	// 이클립스 메뉴에서 [Help -> Eclipse Marketplace]를 선택하면 플러그인을 검색할 수 있는 대화상자가 나타난다.
	// [Find] 입력란에 JavaFX라고 입력하고 검색해보면 e(fx)clipse를 찾을 수 있다. 설치는 우측 하단의 [Install] 버튼을 클릭하면 된다.
	// 주의할 점은 PC에 JavaFX Scene Builder를 먼저 설치한 다음 e(fx)clipse 플러그인을 설치해야 한다.
	// e(fx)clipse 플러그인에는 JavaFX Scene Builder가 포함되어 있지 않기 때문이다. e(fx)clipse 플러그인을 설치한 후에는 이클립스 메뉴에서
	// [Window -> Preferences -> JavaFX] 항목을 선택하고 [SceneBuilder executable]이 JavaFX Scene Builder 실행 파일의 경로로 되어 있는지 확인해야 한다.
	// 만약 비어있거나, 경로가 올바르지 않으면 [Browse...] 버튼을 클릭해서 수정해준다.
	// 경로는 설치한 파일에서 JavaFX Scene Builder.exe를 선택해주면된다.
	
	// 설치가 제대로 되었다면 이클립스 메뉴에서 [File -> New -> Other..]를 선택해서 JavaFX Wizard들이 추가되어 있는지 확인한다.
	// 1장에서 설명한 풀인원(full - in - one) 압축 파일을 C:\JavaProgramming에 해제하여 사용하고 있다면 JavaFX Scene Builder와 e(fx)clipse 플러그인을 설치하지 않아도 이미 설치되어 있을 것이다.
	
	// 이클립스에서 JavaFX Scene Builder를 실행하려면 먼저 FXML 파일을 생성해야 한다. 이클립스 Package Explorer에서 FXML 파일을 위치할 패키지를 선택하고 마우스 오른쪽 버튼을 클릭한 후,
	// [New -> Other -> JavaFX -> New FXML Document]를 선택한다. [FXML File] 대화상자에서 [Name] 입력란에 생성할 파일명을 입력하고 Root Element에 루트 컨테이너가 될 클래스를 선택한 후,
	// [Finish] 버튼을 클릭하면 FXML 파일이 생성된다. 다음은 Root Element를 HBox로 선택하고 생성한 FXML 파일 내용을 보여준다.
	
	//	<?xml version="1.0" encoding="UTF-8"?>
	//
	//	<?import javafx.scene.layout.HBox?>
	//
	//	<HBox xmlns:fx="http://javafx.com/fxml">
	//		<!-- TODO Add Nodes -->
	//	</HBox>

	// FXML 파일을 편집하기 위해 JavaFX Scene Builder를 실행하려면 이클립스 Package Explorer에서 FXML 파일을 선택하고 마우스 오른쪽 버튼을 클릭한 후 [Open With SceneBuilder]를 선택하면 된다.
	// 편집 방법은 JavaFX Scene Builder의 왼쪽에 있는 [Containers]와 [Controls] 메뉴에서 항목을 드래그해서 중앙의 디자인 영역에 드롭시키면 배치가 되는데, 배치된 항목의 속성은 오른쪽에 있는
	// [Properties]와 [Layout] 메뉴에서 설정하면 된다. 레이아웃을 완성했다면 메뉴에서 [File -> Save]를 선택해서 FXML 파일로 저장하면 된다.
}
