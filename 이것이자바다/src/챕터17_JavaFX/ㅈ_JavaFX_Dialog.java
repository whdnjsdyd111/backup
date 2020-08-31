package 챕터17_JavaFX;

public class ㅈ_JavaFX_Dialog {
	// 다이얼로그(Dialog)는 주 윈도우에서 알림 또는 사용자의 입력을 위해서 실행되는 서브 윈도우라고 볼 수 있다. 다이얼로그는 자체적으로 실행될 수 없고. 주 윈도우에 의해서 실행되는데,
	// 다이얼로그를 띄우는 주 윈도우를 다이얼로그의 소유자(owner) 윈도우라고 한다. 다이얼로그는 모달(modal)과 모달리스(modaless) 두 가지 종류가 있다.
	// 모달 다이얼로그는 다이얼로그를 닫기 전까지 소유자 윈도우를 사용할 수 없고, 모달리스 다이얼로그는 소유자 윈도우를 계속 사용할 수 있다.
	// JavaFX에서 제공하는 다이얼로그 종류에는 파일을 선택하는 FileChooser, 디렉토리를 선택하는 DirectoryChooser, 팝업창을 띄우는 Popup이 있다.
	// 이 다이얼로그들은 javafx.stage 패키지에 모두 포함되어 있다. 다이얼로그도 윈도우이므로 Stage로 생성된다.
	
			//	FileChooser, DirectoryChooser
	
	// FileChooser는 로컬 PC의 파일을 선택할 수 있는 다이얼로그이다. 열기 또는 저장 옵션으로 실행할 수 있고, 파일 확장명을 필터링해서 원하는 파일만 볼 수 있다.
	// FileChooser는 컨트롤이 아니기 때문에 FXML에서 선언할 수 없다. 버튼이나 메뉴 아이템의 ActionEvent를 처리할 때 자바 코드로 FileChooser를 생성하고, 
	// showOpenDialog() 또는 showSaveDialog()를 호출해야 한다. 다음은 열기 옵션으로 FileChooser를 실행한 코드이다.
	
	//	FileChooser fileChooser = new FileChooser();		// 객체 생성
	//	fileChooser.getExtensionFilters().addAll(
	//		new ExtensionFilter("Text Files", "*.txt"),
	//		new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),		// 파일 확장명으로 필터링 정보 추가
	//		new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
	//		new ExtensionFilter("All Files", "*.*"));
	//	File selectedFile = fileChooser.showOpenDialog(primaryStage);		// 다이얼로그 띄우기
	//	String selectedFilePath = selectedFile.getPath()					// 선택된 파일 경로 얻기
	
	// 파일 확장명으로 파일 이름을 필터링하려면 ExtensionFilter를 생성해서 추가하면 된다. showOpenDialog() 또는 showSaveDialog()를 호출할 때에는 소유자 윈도우(Stage)를 매개값으로 제공해야 한다.
	// 왜냐하면 다이얼로그는 자체적으로 실행할 수 없고, 소유자 윈도우가 있어야 하기 떼문이다. FileChooser는 모달 다이얼로그이므로 [열기] 또는 [저장] 버튼을 클릭하거나, [취소] 버튼을 클릭하기 전까지
	// 소유자 윈도우를 사용할 수 없다. 파일을 선택하고 [열기] 또는 [저장] 버튼을 클릭하면, showOpenDialog() 또는 showSaveDialog()가 File 객체를 리턴한다.
	// 선택된 파일의 전체 경로를 문자열로 얻고 싶다면 File의 getPath()를 호출하면 된다. 파일이 아니라 디렉토리(폴더)를 선택하고 싶다면 FileChooser 대신 DirectoryChooser를 사용하면 된다.
	// 사용 방법은 FileChooser와 비슷하다.
	
	//	DirectoryChooser directoryChooser = new DirectoryChooser();
	//	File selectedDir = directoryChooser.showDialog(primaryStage);
	//	String selectedDirPath = selectedDir.getPath();
	
			//	Popup
	
	// Popup은 투명한 컨테이너를 제공하는 모달리스 다이얼로그이다. 따라서 소유자 윈도우는 계속 사용될 수 있다. Popup은 컨트롤의 툴팁(tooltip), 메세지 통지(notification),
	// 드롭다운 박스(drop down boxes), 마우스 오른쪽 버튼을 클릭했을 때 나타나는 메뉴 등을 만들 때 사용될 수 있다. 예를 들어 다음은 메세지 통지를 알려주는 Popup이다.
	
	//		┌─┐─────────────┐
	//		│!│ 메세지가 왔습니다  │
	//		└─┘─────────────┘
	
	// Popup은 윈도우의 기본 장식(아이콘, 제목, 최소화 및 복원 버튼, 닫기 버튼)을 가지고 있지 않다. Popup의 내용은 자바 코드로 작성하거나, FXML 파일로 작성할 수 있다.
	// 다음은 FXML 파일을 로딩해서 Popup의 내용으로 추가하는 코드이다.
	
	//	Popup popup = new Popup();
	//	popup.getContent().add(FXMLLoader.load(getClass().getResource("popup.fxml")));
	
	// Popup을 실행하러면 다음과 같이 show() 메소드를 호출하면 된다.
	
	//	popup.show(primaryStage);							// PC 화면 정중앙에서 실행
	//	popup.show(primaryStage, anchorX, anchorY);			// 지정된 좌표에서 실행
	
	// anchorX외 anchorY를 지정하지 않으면 PC 화면의 정중앙에 Popup이 실행된다. 다른 위치에서 실행하고 싶다면  PC 화면의 좌상단(0, 0)을 기준으로 anchorX, anchorY를 지정하면 된다.
	// Popup은 다른 윈도우보다 최상위 위치에 놓이게 된다. Popup이 실행되면 어떤 윈도우를 실행해도 Popup이 항상 제일 위에 온다. Popup을 닫기 위해서는 주 윈도우를 닫거나, 
	// Popup안에 추가된 컨트롤의 이벤트를 처리해서 hide() 메소드를 호출해야 한다. 가장 간단한 방법은 setAutoHide(true)를 설정하는 것인데, 다른 윈도우로 포커스를 이동하면 Popup은 자동으로 닫힌다.
	
	//	popup.setAutoHide(true);
	
	// 다음은 메세지 통지용 Popup을 만드는 예제이다. 우선 Popup 내용을 정의한 FXML 파일을 보자. 9라인을 보면 HBox에 CSS를 적용해서 배경을 검은색으로, 모서리는 둥글게 변경했다.
	// 12라인은 Label의 글자색을 흰색으로 변경하기 위해 CSS를 적용했다.
	
	// 다음은 Popup을 실행하는 코드이다. ImageView를 마우스로 클릭하면 팝업이 닫히도록 했다. 마우스 클릭 이벤트를 처리하려면 ImageView 객체가 필요한데, 
	// FXML 파일에서 로딩된 Parent의 lookup() 메소드를 이용해서 ImageView를 찾았다. lookup() 메소드는 id 속성값으로 내부 객체를 찾아올 때 유용하게 사용된다.
	
	//	Popup popup = new Popup();
	//
	//	Parent parent = FXMLLoader.load(getClass().GetResource("popup.fxml"));
	//	ImageView imageView = (ImageView) parent.lookup("#imgMessage");
	//	imageView.setImage(new Image(getClass().getResource("images/dialog-info.png").toString()));		// 메세지별로 아이콘을 다르게 지정하기 위해 코드로 이미지 지정
	//	imageView.setOnMouseClicked( event -> popup.hide() );	// popup 닫기
	//	Label lblMessage = (Label) parent.lookup("#lblMessage");
	//	lblMessage.setText("메세지가 왔습니다.");						// Label 메세지 지정
	//
	//	popup.getContent().add(parent);
	//	popup.setAutoHide(true);		// 다른 윈도우로 포커스를 이동하면(마우스를 클릭하면) 자동 닫힘 설정
	//	popup.show(primaryStage);		// popup 띄우기
	
	// Popup도 다이얼로그이므로 소유자 윈도우가 필요하다. 그렇기 때문에 show() 메소드를 호출할 때 매개값으로 소유자 윈도우인 Stage가 필요하다.
	
			//	Custom Dialog
	
	// 다양한 내용의 다이얼로그를 만들고 싶다면 Stage로 직접 생성하면 된다. Stage로 다이얼로그를 만들려면 다음과 같은 설정이 필요하다.
	
	//	Stage dialog = new Stage(StageStyle.UTILITY);
	//	dialog.initModality(Modality.WINDOW_MODAL);
	//	dialog.initOwner(primaryStage);
	
	// Stage 생성자 매개값에는 윈도우 스타일을 결정짓는 StageStyle 열거 상수가 온다. 다음은 StageStyle 열거 상수와 윈도우 스타일을 설명한 표이다.
	
	//	StageStyle 열거 상수	설명
	//
	//	DECORATED			일반적인 윈도우 스타일, 배경이 흰색, 제목줄에 장식(아이콘, 타이틀, 축소, 복원, 닫기 버튼 장식)이 있음
	//
	//	UNDECORATED			배경이 흰색, 제목줄 없음
	//
	//	TRANSPARENT			배경이 투명, 제목줄 없음
	//
	//	UNIFIED				DECORATED와 동일하나, 내용물의 경계선이 없음
	//
	//	UTILITY				배경이 흰색이고, 제목줄에 타이틀, 종료 버튼만 있음
	
	// 만약 매개값이 없는 기본 생성자로 Stage를 생성했다면 DECORATED 윈도우가 생성된다. initModality(Modality.WINDOW_MODAL)은 모달 다이얼로그로 설정한다.
	// 이 설정을 하지 않으면 기본적으로 모달리스가 된다. initOwner(primaryStage)는 소유자 윈도우(Stage)를 설정한다.
	// 다음은 확인 다이얼로그의 내용을 정의한 FXML 파일이다.
	
	// 다음은 확인 다이얼로그를 실행하는 코드이다. FXML 파일을 로딩한 후, lookup() 메소드를 이용해서 id 속성값으로 Label과 Button을 찾아 text 속성값을 변경하고, ActionEvent를 처리할 리스너를 등록했다.
	// Scene을 생성한 후에는 확인 다이얼로그인 Stage의 장면으로 세팅했다.
	
	//	Stage dialog = new Stage(StageStyle.UTILITY);
	//	dialog.initModality(Modality.WINDOW_MODAL);
	//	dialog.initOwner(primaryStage);
	//	dialog.setTitle("확인");		// 다이얼로그 제목
	//
	//	Parent parent = FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));
	//
	//	Label txtTitle = (Label) parent.lookup("#txtTitle");		// 메세지 설정
	//	txtTitle.setText("확인하셨습니까?");
	//	Button btnOk = (Button) parent.lookup("#btnOk);		// 버튼 이벤트 처리
	//	btnOk.setOnAction( event -> dialog.close() );
	//	Scene scene = new Scene(parent);	// Scene 생성
	//
	//	dialog.setScene(scene);			// 다이얼로그에 Scene 설정
	//	dialog.setResizable(false);		// 크기를 변경하지 못하도록 설정
	//	idalog.show();					// 다이얼로그 띄우기
	
			//	Using PrimaryStage On Controller	컨트롤러에서 PrimaryStage 사용
	
	// 컨트롤러에서 다이얼로그를 실행할 때는 소유자 윈도우가 될 primaryStage가 필요하다. 컨트롤러에서 primaryStage를 얻는 방법은 두 가지가 있다.
	
			/*	The Way Sending From Main Class		메인 클레스에서 전달하는 방법	*/
	
	// primaryStage는 메인 클래스의 start() 매개값으로 전달되기 때문에 start() 메소드에서 컨트롤러로 primaryStage를 전달하면 된다.
	// FXML 루트 태그의 fx:controller 속성에 지정된 컨트롤러 클래스는 FXMLLoader가 FXML을 로딩할 때 객체로 생성된다. FXMLLoader는 생성된 컨트롤러를 리턴하는 getController() 메소드를 제공하고 있다.
	// 그러나 이 메소드는 인스턴스 메소드이기 때문에 FXMLLoader 객체가 필요하다. 그래서 FXMLLoader의 정적 메소드 load() 호출 코드는 다음과 같이 인스턴스 메소드 load() 호출 코드로 변경해야 한다.
	
	//	FXMLLoader loader = new FXMLLoader(getClass().getResource("root.fxml"));
	//	Parent root = loader.load();
	//	RootController controller = loader.getController();
	//	controller.setPrimaryStage(primaryStage);
	
	// 마지막 코드를 보면 컨트롤러의 setPrimaryStage() 메소드를 호출하면서 primaryStage를 매개값으로 전달하고 있다. 따라서 컨트롤러 클래스는 다음과 같이 필드와 Setter 메소드를 추가해 두어야 한다.
	
	//	public class RootController implements Initializable {
	//		private Stage primaryStage;
	//		public void setPrimaryStage(Stage primaryStage) {
	//			this.primaryStage = primaryStage;
	//		}
	//		...
	//	}
	
	// 다음은 수정된 메인 클래스를 보여준다.
	
			/*	The Way Getting From Container Or Control	컨테이너 또는 컨트롤로부터 얻는 방법		*/
	
	// 컨테이너나 컨트롤의 getScene() 메소드는 자신이 포함된 Scene 객체를 리턴한다. 그리고 Scene의 getWindow() 메소드는 자신을 보여주는 Stage 객체를 리턴한다.
	// 따라서 다음과 같은 코드를 이용하면 컨트롤러에서 primaryStage를 얻을 수 있다.
	
	//	Stage primaryStage = (Stage) 컨트롤.getScene().getWindow();
	
	// 주의할 점은 위 코드는 initialize() 메소드 안에서는 사용할 수 없다. 그 이유는 아직 primaryStage가 생성되지 않았기 때문이다.
	// 메인 클래스의 start() 메소드에서 Scene 객체를 생성하고 primaryStage에 Scene을 설정해야만 위 코드가 정상적으로 동작한다.
	// 따라서 이벤트 처리 메소드 내에서 위 코드를 사용해야 한다. 예를 들어 Button을 클릭했을 때 실행하는 메소드가 handleButton()이라면 다음과 같이 handleButton() 메소드에서 primaryStage를 얻어야 한다.
	
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
	
	// 다음 예제는 다섯 개의 버튼을 배치하고, 지금까지 설명한 다이얼로그를 실행하도록 했다. 첫 번째 버튼은 파일 오픈 다이얼로그를, 두 번째 버튼은 파일 저장 다이얼로그를, 세 번째 버튼은 디렉토리 선택 다이얼로그를,
	// 네 번째 버튼은 팝업을, 다섯 번째 버튼은 커스텀 다이얼로그를 실행한다.
}
