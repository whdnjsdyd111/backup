package 챕터17_JavaFX;

public class ㅅ_JavaFX_Control {
	// JavaFX는 다양한 UI 컨트롤을 제공하고 있다. 이번 절에는 사용 빈도가 높은 버튼 컨트롤, 입력 컨트롤, 뷰 컨트롤, 미디어 컨트롤, 챠트 컨트롤에 대해서 살펴볼 것이다.
	
			//	Button Control
	
	// 버튼 컨트롤은 마우스로 클릭할 수 있는 컨트롤로 ButtonBase를 상속하는 하위 컨트롤을 말한다. Button, CheckBox, RadioButton, ToggleButton, Hyperlink 등이 있다.
	
	//		Button			CheckBox			RadioButton		ToggleButton
	//
	//	┌───┐ ┌─────┐		□ Security			◎ Home			┌─────┬─────┬────────┐
	//	│버튼	│ │  v	│		□ Project			○ Calendar		│Minor│Major│Critical│
	//	└───┘ └─────┘											└─────┴─────┴────────┘
	
	// 기본 Button은 단순한 글자로 구성된다. 하지만 ImageView를 매개값으로 해서 setGraphic() 메소드를 호출하면 아이콘을 넣을 수 있다. 다음은 아이콘 버튼을 FXML로 작성하는 방법을 보여준다.
	
	//	<Button text="아이콘버튼">
	//		<graphic>
	//			<ImageView>
	//				<Image url="@images/history_view.gif"/>
	//			</ImageView>
	//		</graphic>
	//	</Button>
	
	// CheckBox, RadioButton, ToggleButton 컨트롤은 선택과 미선택 두 가지 상태를 가질 수 있다. selected 속성의 값이 true이면 선택이고, false이면 미선택이다.
	// 다음은 checkBox 컨트롤을 FXML로 선언한 것이다. text 속성은 사용자에게 보여주는 문자열이고 userData 속성은 프로그램에서 처리하는 데이터이다.
	
	//	<CheckBox text="라벨1" userData="값1" />
	//	<CheckBox text="라벨2" userDate="값2" selected="true" />
	
	// RadioButton, ToggleButton에는 toggleGroup 속성이 있는데, 같은 ToggleGroup을 참조할 경우 하나의 그룹으로 묶이며, 같은 그룹 내에서는 하나의 컨트롤만 선택되는 효과가 있다.
	// 참조할 ToggleGroup 객체는 <fx:define> 태그를 사용해서 <ToggleGroup fx:id"groupName" /> 작성하고,
	// RadioButton의 toggleGroup 속성에서 $groupName으로 참조한다. 다음은 2개의 RadioButton을 하나의 그룹으로 묶어서 선언한 것이다.
	
	//	<fx:define>
	//		<ToggleGroup fx:id="groupName" />
	//	</fx:define>
	
	//	<RadioButton text="라벨1" userData="값1" toggleGroup="$groupName" />
	//	<RadioButton text="라벨2" userData="값1" toggleGroup="$groupName" selected="true" />
	
	// CheckBox, RadioButton, ToggleButton 컨트롤은 사용자가 클릭하면 
	// ActionEvent가 발생하기 때문에 EventHandler로 처리가 가능하고, onAction 속성을 작성해서 컨트롤러의 이벤트 처리 메소드로 연결할 수도 있다.
	
	//	<CheckBox ...onAction="#handleChkAction" />
	
	// 만약 RadioButton 또는 ToggleButton 그룹 내에서 선택 변경을 감시하고 싶다면 ToggleGroup의 selectedToggle 속성을 다음과 같이 작성하면 된다.
	
	//	groupName.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
	//		@Override
	//		public void changed(ObservableValue<? extends Toggle> observable,
	//							Toggle oldValue, Toggle newValue) {...}
	//	});
	
	// 선택 변경이 되면 changed() 메소드가 실행되고 세 번째 매개값인 newValue에 마지막으로 선택된 컨트롤이 대입된다.
	// 다음 예제는 CheckBox와 RadioButton의 이벤트 처리를 어떻게 하는지 보여준다.
	
			//	Input Control	입력 컨트롤
	
	// 입력 컨트롤에는 한 줄 입력을 위한 TextField, 다중 행 입력을 위한 TextArea, 패스워드 입력을 위한 PasswordField, 제한된 항목에서 선택하는 ComboBox가 있다.
	// 또한 날짜를 선택할 수 있는 DatePicker, 색상을 선택할 수 있는 ColorPicker, HTML을 입력하기 위한 HTMLEditor도 입력 컨트롤이라고 볼 수 있다.
	// Label은 입력 컨트롤은 아니지만 입력 컨트롤의 제목을 표시할 때 사용된다.
	
	//	Label & TextField			PasswordField			TextArea
	//
	//		 ┌───────┐				┌───────────┐			┌───────────────────────┐
	//	Name:│Michael│				│●●●●●●●	│			│abc					│
	//		 └───────┘				└───────────┘			│가나다					│
	//														└───────────────────────┘
	//
	//		ComboBox				DatePicker				ColorPicker
	//
	//	┌───────────┐				┌───────────────┐		┌───────┐
	//	│		   ▼│				│<02월 >	  <2020>│		│□ White│
	//	└───────────┘				│일 월  화 수  목  금 토	│		└───────┘───────┐
	//	│Option 1	│				│1 2 3 4 5 6 7	│		│□	■	...		│
	//	└───────────┘				│8 9 ...		│		│				│
	//	│Option2	│				└───────────────┘		└───────────────┘
	//	└───────────┘
	//
	//							HTMLEditor
	//
	//	┌───────────────────────────────────────────────────────────────────────┐
	//	│□	□	□	□	□	■	■	■ A▼										│
	//	│┌──────┐	┌──────┐	┌─────────────┐		B	I	U					│
	//	│└──────┘	└──────┘	└─────────────┘									│
	//	│───────────────────────────────────────────────────────────────────────│
	//	│This is HTML Page!														│
	//	│																		│
	//	└───────────────────────────────────────────────────────────────────────┘
	
	// 다음은 입력 컨트롤을 FXML로 선언하는 방법을 보여준다.
	
	//	<Label prefWidth="폭" prefHeight="높이" text="제목" />
	//	<TextField prefWidth="폭" prefHeight="높이" promptText="힌트문자열" />
	//	<PasswordField preWidth="폭" prefHeight="높이" promptText="힌트문자열" />
	//
	//	<ComboBox prefWidth="폭" prefHeight="높이" promptText="힌트문자열" >
	//		<items>
	//			<FXCollections fx:factory="observableArrayList" >
	//				<String fx:value="공개" />
	//				<String fx:value="비공개" />
	//			</FXCollections>
	//		</item>
	//	</ComboBox>
	//
	//	<DatePicker prefWidth="폭" prefHeight="높이" promptText="힌트문자열" />
	//	<TextArea prefWidth="폭" prefHeight="높이" promptText="힌트문자열" />
	
	// prefWidth와 prefHeight는 각각 폭과 높이를 설정하고,promptText는 힌트 문자열로 컨트롤이 포커스를 얻게 되면 사라진다.
	
	// 다음 예제는 입력 컨트롤로 구성된 폼을 제공한다. 제목은 TextField, 비밀번호는 PasswordField, 공개는 ComboBox, 게시종료는 DataPicker, 내용은 TextArea로 구성했다.
	// [등록] 버튼을 클릭하면 모든 입력된 내용이 콘솔에 출력된다.
	
			//	View Control
	
	// 뷰 컨트롤은 텍스트 또는 이미지 등을 보여주는데 목록 형태로 보여주는 ListView, 테이블 형태로 보여주는 TableView, 이미지를 보여주는 ImageView가 있다.
	
	//		ListView		TableView						ImageView
	//
	//	┌───────────┐		┌───────────────────────┐		┌───────────────────────┐
	//	│Single		│		│First Name	│Last Name	│		│						│
	//	┌───────────┐		┌───────────────────────┐		│						│
	//	│Double		│		│Jacob		│Smith		│		│						│
	//	┌───────────┐		┌───────────────────────┐		│		이미지			│
	//	│Suite		│		│Isabella	│William	│		│						│
	//	┌───────────┐		┌───────────────────────┐		│						│
	//	│Family App	│		│Ethan		│Jones		│		│						│
	//	└───────────┘		└───────────────────────┘		└───────────────────────┘
	
			/*	ImageView Control	*/
	
	//	<ImageView fitWidth="폭" fitHeight="높이" preserveRatio="true" />
	
	// fitWidth와 fitHeight는 ImageView의 폭과 높이를 지정한다. preserveRatio 속성은 이미지의 종횡비를 유지할 것인지를 지정한다.
	// false를 주면 종횡비와 상관없이 fitWidth와 fitHeight에 맞게 ImageView 크기가 고정되고, true를 주면 이미지의 종횡비를 유지하기 위해 ImageView 크기가 조정된다.
	// ImageView에 보여줄 이미지는 두 가지 방법으로 설정할 수 있는데, 첫 번째 방법은 ImageView의 생성자 매개값으로 Image 객체를 설정하는 것이다.
	
	//	<ImageView preserveRatio="true" >
	//		<Image url="@images/flower.png" />
	//	</ImageView>
	
	// 두 번째 방법은 ImageView의 setImage() 메소드로 설정하는데, 역시 매개값은 Image 객체이다.
	
	//	<ImageView fitWidth="200" fitHeight="150" preserveRatio=true" >
	//		<image>
	//			<ImageView url="@images/flower.png" />
	//		<image>
	//	</ImageView>
	
	// Image는 url 속성(생성자 매개 변수)을 가지고 있는데 FXML 파일 위치에서 상대 경로로"@이미지 경로"를 값으로 주면 된다.
	
			/*	ListView Control	*/
	
	// ListView는 항목들을 목록으로 보여주는 컨트롤이다. FXML로 선언하는 방법은 다음과 같다.
	
	//	<ListView prefWidth="폭" prefHeight="높이" />
	
	// ListView에 항목을 추가하려면 setItems(ObservableList<T> value) 메소드를 사용한다.
	// ObservableList 구현 객체는 FXCollections.observableArrayList(E ... items) 정적 메소드로 생성하면 된다.
	
	//	listView.setItems(FXCollections.observableArrayList("Swing", "JavaFX"));
	
	//	<ListView fx:id="listView" prefHeight="100" prefWidth="100" >
	//		<item>
	//			<FXCollections fx:factory="observableArrayList" >
	//				<String fx:value="Swing" />
	//				<String fx:value="JavaFX" />
	//			</FXCollections>
	//		</item>
	//	</ListView>
	
	// LastView에서 선택된 인덱스와 항목을 얻으려면 속성 감시를 이용할 수 있다. getSelectionModel() 메소드로 MultipleSelectionModel을 얻고 나서,
	// selectedIndexProperty 또는 selectedItemProperty에 리스너를 설정하면 된다. selectedIndexProperty는 선택된 인덱스이고, selectedItemProperty는 선택된 항목이다.
	// 다음은 selectedItemProperty에 리스너를 설정하는 코드이다.
	
	//	listView.getSelectionModel().selectedItemProperty().addListener(
	//		new ChangeListener<String>() {
	//			@Override
	//			public void changed(ObservableValue<? extends String> observable,
	//								String oldValue, String newValue) {...}
	//		}
	//	);
	
			/*	TableView Control	*/
	
	// TableView를 FXML로 선언하는 방법은 다음과 같다. <column> 태그 안에 만들고자 하는 컬럼의 개수만큼 <TableColumn> 태그를 선언하면 된다.
	
	//	<TableView prefHeight="100" prefWidth="300" >
	//		<column>
	//			<TableColumn prefWidth="150" text="스마트폰" />
	//			<TableColumn prefWidth="150" text="이미지" />
	//		</column>
	//	</TableView>
	
	// TableView에 행(row)을 추가하려면 행의 데이터를 가지고 있는 모델(model) 객체가 필요하다. 위 코드를 보면 스마트폰과 이미지 컬럼이 있는데, 이 두 값을 속성으로 갖는 모델 객체를 생성해서 행의 데이터로 제공해야 한다.
	// 다음은  Phone 모델 클래스를 생성하는 방법을 보여준다.
	
	// 모델의 속성 타입은 컬럽 값의 데이터 타입에 따라서 javafx.beans.property 패키지의 SimpleXXXProperty를 사용하면 된다.
	// 모델 클래스를 작성하였다면 이제 모델 속성과 TableColumn을 연결시키는 코드를 작성해야 한다. TableColumn은 TableView의 getColumn().get(인덱스)로 얻어 내는데, 첫 번째 컬럼의 인덱스는 0이다. 
	// TableColumn의 setCellValueFactory() 메소드는 매개값으로 제공되는 PropertyValueFactory("모델속성명")을 이용해서 모델 속성값을 TableColumn 값으로 세팅한다.
	// 다음은 첫 번째 TableColumn을 모델 클래스의 smartPhone 속성과 연결시키는 코드이다.
	
	//	TableColumn tcSmartPhone = tableView.getColumn().get(0);
	//	tcSmartPhone.setCellValueFactory( new PropertyValueFactory("smartPhone") );
	
	// 셀(cell) 내에서 정렬이 필요한 경우에는 다음과 같이 TableColumn의 setStyle() 메소드로 CSS를 적용하면 된다. CSS 17.10 JavaFX CSS 스타일에서 학습한다.
	
	//	tcSmartPhone.setStyle("-fx-alignment: CENTER;");
	
	// 마지막으로 행의 데이터를 주기 위해 ObservableList에 모델 객체들을 다음과 같이 저장하고, ObservableList를 매개값으로 해서 TableView의 setItems() 메소드를 호출하여 행들을 추가한다.
	
	//	ObservableList phoneList = FXCollections.observableArrayList(
	//		new Phone("갤럭시S1", "phone01.png"),
	//		new Phone("갤럭시S2", "phone02.png"),
	//		new Phone("갤럭시S3", "phone03.png"),
	//	);
	//	tableView.setItems(phoneList);
	
	// TableView에서 선택된 행의 인덱스와 모델 객체를 얻으려면 속성 감시를 이용할 수 있다. getSelectionModel() 메소드로 TableViewSelectionModel을 얻고 나서,
	// selectedIndexProperty 또는 selectedItemProperty에 리스너를 설정하면 된다. selectedIndexProperty는 선택된 행의 인덱스이고, selectedItemProperty는 선택된 행의 모델 객체이다.
	// 다음은 selectedItemProperty에 리스너를 설정하는 코드이다.
	
	//	tableView.getSelectionModel().selectedItemProperty().addListener(
	//		new ChangeListener<Phone>() {
	//			@Override
	//			public void changed(ObservableValue<? extends Phone> observable,
	//								Phone oldValue, Phone newValue) {...}
	//		}
	//	);
	
	// 다음 예제는 ListView의 항목을 선택하면 같은 인덱스를 가지는 TableView의 행이 자동 선택되도록 한다.
	// 그리고 TableView에서 행이 선택되면 이미지 컬럼 값을 읽고 ImageView에 이미지를 보여준다. 하단의 [확인] 버튼을 클릭하면 ListView와 TableView에 선택된 정보를 콘솔에 출력한다.
	
			//	Media Control
	
	// 미디어 컨트롤에는 비디오를 재생할 수 있는 MediaView 컨트롤과 볼륨 조절 및 재생 위치 조절을 위한 Slider 컨트롤 그리고 현재 진행 상태를 보여주는 ProgressBar, ProgressIndicator 컨트롤이 있다.
	// Slider와 ProgressBar, ProgressIndicator는 미디어와는 상관없이 다른 용도로 사용할 수 있다.
	// 예를 들어 ProgressBar와 ProgressIndicator는 네트워크 데이터 송수신 정도를 표시할 때에도 사용할 수 있다.
	
	//								MediaView
	//			┌───────────────────────────────────────────────┐
	//			│												│
	//			│	 											│
	//			│					동영상						│
	//			│												│
	//			│												│
	//			│												│
	//			└───────────────────────────────────────────────┘
	//
	//				Slider											ProgressBar와 ProgressIndicator
	//						
	//	Track		Thumb	Block increment							progress: 0.0 □□□□□□□□□□	0%
	//	↓			↓	  	 │ ↔│	
	//	┌───────────●───────────┐									progress: 0.6 ■■■■■■□□□□	60%
	//	└───────────────────────┘
	//	┌──┬──┬──┬──┬──┬──┬──┬──┐									progress: 1.0 ■■■■■■■■■■	100%
	//	0			50.0		100
	//			Tick marks		↑ Tick Label
	
			/*	MediaPlayer And MediaView Control	*/
	
	// MediaView 컨트롤은 비디오를 보여주는 용도로만 사용되기 때문에 특별한 UI를 가지고 있지 않다. 단지, 레이아웃상에서 비디오가 위치할 영역을 표시한다. 
	// FXML로 MediaView 컨트롤을 선언하는 방법은 다음과 같다.
	
	//	<MediaView fitHeight="200.0" fitWidth="300.0" preserveRatio="false" />
	
	// fitWidth와 fitHeight는 MediaView의 폭과 높이를 지정한다. preserveRatio 속성은 비디오의 가로-세로비를 유지할 것인지를 지정하는데, false를 주면 비디오의 가로-세로비와 상관없이
	// fitWidth와 fitHeight에 맞게 MediaView의 크기가 조정되고, true를 주면 비디오의 가로비와 세로비를 유지하기 위해 MediaView 크기가 조정된다.
	// MediaView 컨트롤은 비디오를 재생하는 기능이 없기 때문에 미디어를 재생하는 MediaPlayer가 있어야 한다.
	// MediaPlayer는 비디오뿐만 아니라 오디오도 재생하는 기능을 가지고 있는데, 미디어 소스 경로를 Media 객체 형태로 전달해서 다음과 같이 생성한다.
	
	//	Media media = new Media("미디어 소스 경로");
	//	MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	// 만약 비디오와 오디오 파일이 클래스 경로에 있다면 Media를 생성할 때 다음과 같이 상대 경로를 사용하는 것이 좋다.
	
	//	Media media = new Media(getClass().getResource("media/bigbuck.m4v").toString());
	//	MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	// 미디어 소스가 비디오라면 MediaView의 setMediaPlayer() 메소드로 mediaPlayer 객체를 등록할 수 있다. 오디오 소스로부터 MediaPlayer가 생성되었다면 MediaView는 필요 없다.
	
	//	mediaView.setMediaPlayer(mediaPlayer);
	
	// MediaPlayer를 생성했다고 해서 바로 재생할 수는 없고, 재생할 상태(READY)가 될 때까지 기다려야 한다.
	// 다음은 MediaPlayer가 가질 수 있는 상태와 상태를 변경하는 메소드가 무엇인지 보여준다.
	
	//	현재 상태\다음 상태		READY		PAUSED						PLAYING			STALLED			STOPPED
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
	
	// UNKNOWN은 Mediaplayer가 생성된 직후의 상태인데, 미디어 소스를 재생할 준비가 되면 READY 상태로 자동 변경된다.
	// READY 상태에서 setAutoPlay(true) 또는 play()를 호출하면 PLAYING이 된다. PLAYING 상태가 되고, stop()을 호출하면 STOPPED이 된다.
	// 만약 PLAYING 상태에서 재생 버퍼에 충분한 데이터가 없을 경우 STALLED 상태가 된다. 주로 네트워크상에서 미디어 소스를 받아 재생할 때, 네트워크 속도가 느리면 STALLED 상태가 된다.
	// 이 상태들은 MediaPlayer.Status 열거 타입으로 모두 정의되어 있는데, 코드에서 MediaPlayer의 상태를 알고 싶다면 getStatus()의 리턴값을 확인하면 된다.
	
	//				UNKNOWN
	//				   ↓
	//				READY
	//				   ↓
	//		┌─────→	PLAYING ←───────┐
	//		↓		   ↓			↓
	//	STALLED	 →	PAUSED	 →	STOPPED
	
	// 위의 표에는 나와 있지 않지만 한 가지 상태를 더 알아둘 필요가 있다. 바로 EndOfMedia이다. EndOfMedia는 MediaPlayer가 미디어 소스를 모두 재생했을 때의 상태를 말한다.
	// EndOfMedia 상태에서 play()를 호출하면 다시 PLAYING 상태가 될 수 있는데, 먼저 seek() 메소드로 재생 위치를 처음으로 되돌려야 한다.
	
	// 상태가 변경되면 자동 실행해야 할 코드들이 있을 수 있다. 이런 코드들은 Runnable의 run() 메소드에 작성하고, setOnXXX() 메소드로 등록하면 된다.
	// 그러면 해당 상태가 되었을 때 Runnable의 run() 메소드가 자동 실행된다. 다음은 각 상태로 변경될 때 실행하는 Runnable을 설정하는 메소드이다.
	
	//	상태			자동 실행 Runnable 설정 메소드		Runnable에 포함될 수 있는 코드
	//
	//	READY		setOnReady(Runnable r)		- currentTime 속성을 감시
	//											- 재생 시간을 표시하는 리스너 등록
	//											- 재생 버튼 활성화
	//
	//	PLAYING		setOnPlaying(Runnable r)	- 멈춤 및 정지 버튼 활성화
	//
	//	PAUSED		setOnPlaying(Runnable r)	- 재생 및 정지 버튼 활성화
	//
	//	STOPPED		setOnStopped(Runnable r)	- 재생 버튼 활성화
	//
	//	EndOfMedia	setOnEndOfMedia(Runnable r)	- 재생 버튼 활성화
	
	// 다음은 setOnReady() 메소드를 작성하는 방법을 보여준다. MediaPlayer에서 currentTime 속성을 감시하는 ChangeListener를 등록했는데, 
	// changed() 메소드에는 재생 시간을 표시하는 코드들이 작성될 수 있다. 필요하다면 READY 상태에서 PLAYING 상태로 변경하기 위해 재생 버튼을 활성화하는 코드를 작성해야 한다.
	// 만약 재생 버튼을 사용하지 않고 자동 실행을 하고 싶다면 setAutoPlay(true)를 호출해야 한다.
	
	//	mediaPlayer.setOnReady(new Runnable() {
	//		@Override
	//		public void run() {
	//			mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
	//				@Override
	//				public void changed(ObservableValue<? extends Duration> observable, 
	//									Duration oldValue, Duration newValue) {
	//					// 재생 시간을 표시하는 코드
	//				}
	//			});
	//			// 재생 버튼을 활성화 코드 코드 setAutoPlay(true);
	//		}
	//	});
	
	// 다음은 비디오와 오디오를 재생하는 간단한 플레이어를 만들어 보았다. RootController의 라인과 라인을 번갈아가며 주석을 해제하고 실행시켜보자.
	
			/*	Slider Control	*/
	
	//				Slider									
	//						
	//	Track		Thumb	Block increment		
	//	↓			↓	  	 │ ↔│	
	//	┌───────────●───────────┐	
	//	└───────────────────────┘
	//	┌──┬──┬──┬──┬──┬──┬──┬──┐	
	//	0			50.0		100
	//			Tick marks		↑ Tick Label
	
	// Slider 컨트롤은 Track과 Thumb로 구성되어 있다. Slider의 value 속성에는 현재 Thumb의 위치값이 저장되는데, 최소값은 0, 최대값은 100이다.
	// 기본적으로 Tick marks와 Tick label이 숨겨져 있는데, setShowTickMarks(true)와 setShowTickLabel(true)를 호출하면 볼 수 있다.
	// Block increment 간격은 setBlockIncrement()로 설정할 수 있다
	// 다음은 FXML로 Slider 컨트롤을 선언하는 방법을 보여준다.
	
	//	<Slider prefHeight="높이" prefWidth="폭" showTickLabels="true" showTickMarks="true" />
	
	// 다음은 MediaPlayer의 볼륨을 조정하기 위해 Slider 컨트롤의 value 속성을 감시하는 ChangeListener를 등록한다.
	// MediaPlayer의 volume 속성은 0.0 ~ 1.0 값을 가지는데, Slider value 속성은 0.0 ~ 100.0 값을 가지므로 Slider의 value 속성값을 100.0으로 나누어서
	// MediaPlayer의 value 속성값으로 설정해야 한다.
	
	//	sliderVolume.valueProperty().addListener(new ChangeListener<Number>() {
	//		@Override
	//		public void changed(ObservableValue<? extends Number> observable,
	//								Number oldValue, Number newValue) {
	//			mediaPlayer.setVolume(sliderVolume.getValue() / 100.0);
	//		}
	//	});
	
			/*	ProgressBar And ProgressIndicator Control	*/
	
	//		ProgressBar와 ProgressIndicator
	//						
	//	progress: 0.0 □□□□□□□□□□	0%
	//	
	//	progress: 0.6 ■■■■■■□□□□	60%
	//
	//	progress: 1.0 ■■■■■■■■■■	100%
	
	// ProgressBar는 수평 막대 모양의 컨트롤이고, ProgressIndicator는 원형 모양의 컨트롤이다. 
	// 둘 다 작업의 진행 정도를 표시하는데, 미디어 재생 시간을 표시하거나, 저장소의 사용량 및 네트워크 통신량을 표시할 때도 사용할 수 있다.
	// 다음은 FXML로 선언하는 방법을 보여준다.
	
	//	<ProgressBar prefHeight="15" prefWidth="100" progress="0.0" />
	//	<ProgressIndicator prefHeight="47.0" prefWidth="31.0" progress="0.0" />
	
	// ProgressBar는 ProgressIndicator를 상속한 하위 컨트롤이기 때문에 사용하는 속성들이 모두 동일하다. progress 속성은 진행 정도를 설정하는데, 최소값은 0.0이고 최대값은 1.0이다.
	// 진행 정도는 자바 코드로 다음과 같이 변경할 수 있다.
	
	//	progressBar.setProgress(0.0 ~ 1.0);
	//	progressIndicator.setProgress(0.0 ~ 1.0);
	
	// MediaPlayer의 재생 시간을 나타내기 위해서는 현재 재생 시간을 전체 재생 시간으로 나눈값을 progress 속성값으로 설정하면 된다.
	
	//	double progress = 
	//	mediaPlayer.getCurrentTime().toSeconds()	// mediaPlayer.getTotalDuration().toSeconds();
	//	progressBar.setProgress(progress);
	//	progressIndicator.setProgress(progress);
	
	// 주의할 점은 마지막 재생 시간과 전체 재생 시간이 정확히 일치하지 않기 때문에 마지막 값이 1.0이 되지 않을 수도 있다. 
	// 그래서 MediaPlayer가 EndOfMedia 상태가 되었을 때 progress 속성을 강제로 1.0으로 설정하는 것이 좋다.
	
	//	MediaPlayer.setOnEndOfMedia( () -> {
	//		progressBar.setProgress(1, 0);
	//		progressIndicator.setProgress(1, 0);
	//	}
	
	// 다음은 이전 예제의 미디어 플레이어를 개선해서 재생 시간을 표시하도록 ProgressBar와 ProgressIndicator 컨트롤을 추가하고, 볼륨을 조정하기 위해 Slider 컨트롤을 추가한다.
	
			/*	Chart Control	*/
	
	// JavaFX에는 다음과 같이 다양한 차트를 생성하는 컨트롤을 제공해준다. 이 차트의 컨트롤들은 javafx.scene.chart 패키지에 포함되어 있다.
	
	//		PieChart				LineChart			AreaChart
	//
	//	Apple ←	◑ → Orange		│━━━━━━━┓			│
	//	○ Apple	● Orange		│───┐	┗━━━━━		│────────
	//							│	└─────			│■■■■■■■■
	//							└──────────────		└─────────
	//
	//		BarChart				BubbleChart			ScatterChart
	//
	//	│┌┐						│	●				│●		●		●
	//	│││┌┐					│●					│	●	●	●●
	//	│││││					│		●			│●	●●●	●		●
	//	└────────────			└──────────────		└────────────────
	
	// FXML로 차트 컨트롤을 배치하는 방법은 매우 쉬운데, PieChart일 경우 다음과 같이 작성하면 된다. PieChart는 X축과 Y축이 없으므로 축으로 정의할 필요가 없다
	
	//	<PieChart/>
	
	// LineChart, AreaChart, BarChart일 경우 X축과 Y축이 필요하므로 축 정의가 필요하다. 다음은 BarChart를 선언하는 방법을 보여준다.
	// <xAxis>와 <yAxis>는 각각 X축, Y축을 말한다. X축은 위쪽, 아래쪽이 있고, Y축은 왼쪽과 오른쪽이 있기 때문에 눈금이 나타날 위치를 지정해야 한다.
	// <CategoryAxis side="BOTTOM" />은 분류 눈금을 아래쪽 축에 나타낸다. <NumberAxis side="LEFT" />는 숫자 눈금을 왼쪽 축에 나타낸다.
	
	//	<BarChart>
	//		<xAxis>
	//			<CategoryAxis side="BOTTOME" />
	//		</xAxis>
	//		<yAxis>
	//			<NumberAxis side="LEFT" />
	//		</yAxis>
	//	</BarChart>
	
	// 컨트롤러는 차트의 데이터를 데이터베이스나 네트워크에서 전달받아서 차트 컨트롤에 추가해야 하는데, 다음은 PieChart에 데이터를 추가하는 방법을 보여준다.
	// 각각의 데이터는 PieChart.Data 객체로 생성하고, 이것을 ObservableList에 저장한 다음 PieChart의 setData() 매개값으로 제공하면 된다.
	
	// 	pieChart.setData(FXCollections.observableArrayList(
	//		new PireChart.Data("AWT", 10),
	//		new PireChart.Data("Swing", 30),
	//		new PireChart.Data("SWT", 25),
	//		new PireChart.Data("JavaFX", 35)
	//	)};
	
	// X축과 Y축이 필요한 LineChart, AreaChart, BarChart는 데이터를 추가하는 방법이 모두 동일하다.
	// 다음은 BarChart에 데이터를 추가하는 방법을 보여준다.
	
	//	XYChart.Series series1 = new XYChart.Series();		// 시리즈 생성
	//	series1.setName("남자");
	//	series1.setData(FXCollections.observableArrayList(
	//		new XYChart.Data("2015", 70),
	//		new XYChart.Data("2016", 40),
	//		new XYChart.Data("2017", 50),
	//		new XYChart.Data("2018", 30)
	//	));
	//	barChart.getData().add(series1);
	
	// XYChart.Series는 하나의 그래프를 의미한다. 여러 개의 그래프를 겹쳐 보이게 하려면 XYChart.Series를 그래프의 수에 맞게 생성해서 추가하면 된다.
	// 축의 데이터는 XYChart.Data 객체로 생성하고, 이것을 ObservableList에 저장한 다음 XYChart.Series의 setData() 매개값으로 제공하면 된다.
	// XYChart.Series가 완성되면 차트의 getData()를 호출해서 얻은 ObservableList에 추가함으로써 하나의 그래프가 생성된다.
	// 다음 예제는 PieChart, BarChart, AreaChart를 생성하는 방법을 보여준다.
	//
	//
}
