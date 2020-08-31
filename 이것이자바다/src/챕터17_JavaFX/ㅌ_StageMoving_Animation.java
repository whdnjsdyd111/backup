package 챕터17_JavaFX;

public class ㅌ_StageMoving_Animation {
	// 애플리케이션은 다양한 화면을 가지고 있다. 메인 화면에서 시작해서 사용자의 선택에 따라 가입 화면, 로그인 화면, 목록 화면 등으로 이동된다.
	// 화면이 이동될 때 애니메이션을 적용하면 눈을 즐겁게 만들어준다. 같은 화면에서도 마우스의 위치에 따라 컨트롤의 속성을 변화시켜 다이나믹한 애니메이션을 만들어 낼 수 있다.
	// 이번 절에서는 화면을 이동시키는 방법과 슬라이드(slide)와 페이드(fade) 애니메이션을 적용하는 방법을 알아보자.
	
			//	Stage Moving	화면 이동
	
	// 화면을 이동하는 가장 쉬운 방법은 Stage에 새로운 Scene을 세팅하는 것이다. 
	// 애플리케이션이 실행되면 start() 메소드는 메인 화면인 Scene을 생성하고, primaryStage의 setScene() 메소드로 Scene을 설정한다.
	// 다음은 메인 클래스의 start() 메소드를 보여준다.
	
	//	@Override
	//	public void start(Stage primaryStage) throws Exception {
	//		primaryStage.setTitle("AppMain");
	//		Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
	//		Scene scene = new Scene(root);
	//		primaryStage.setScene(scene);	// 메인 화면 설정
	//		primaryStage.show();
	//	}
	
	// 메인 화면에서 로그인 화면으로 이동하기 위해 버튼을 클릭했다고 가정해보자. 컨트롤러의 이벤트 처리 메소드는 로그인 Scene을 생성하고, 
	// primaryStage의 setScene() 메소드로 메인 Scene을 로그인 Scene으로 변경할 수 있다.
	
	//	public void handleBtnLogin(ActionEvent event) {
	//		try {
	//			Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));
	//			Scene scene = new Scene(login);
	//			Stage primaryStage = (Stage) btnLogin.getScene().getWindow();
	//			primaryStage.setScene(scene);
	//		} catch(Exception e) {
	//			e.printStackTrace();
	//		}
	//	}
	
	// 애니메이션을 적용하려면 이전 화면과 다음 화면이 일시적으로 공존해야 한다. 그러나 setScene() 메소드로 화면을 이동하게 되면, 이전 Scene은 Stage에서 제거되므로 애니메이션을 적용할 수 없다.
	// 따라서 화면 이동을 위한 다른 방법이 필요한데, StackPane을 이용하면 화면 이동 효과와 함께 애니메이션을 적용할 수 있다. 다음과 같이 Scene은 하나만 생성하고,
	// StackPane을 루트 컨테이너로 해서 메인 화면과 로그인 화면을 추가하는 것이다.
	
	//			┌───────────────────────────────────────────────┐
	//			│StackPane										│
	//			│	 		/──────────────────────────/ 인덱스 1	│	
	//			│		   /		로그인 화면			  /			│
	//			│		  /──────────────────────────/──/ 인덱스 0	│
	//			│			/			메인 화면		   /		│
	//			│		   /──────────────────────────/			│
	//			└───────────────────────────────────────────────┘

	// 메인 화면만 StackPane에 추가되어 있는 상테에서 메인 화면의 [로그인] 버튼을 클릭하면 로그인 화면이 생성되고 StackPane에 추가된다. 
	// StackPane은 나중에 추가된 로그인 화면만 사용자에게 보여주고 메인 화면은 뒤로 숨긴다. 반대로 로그인 화면의 [메인] 버튼을 클릭하면 StackPane에서 로그인 화면을 제거함으로써 밑에 있는 메인 화면이 보여진다.
	// 이와 같은 방법으로 화면을 이동하게 되면 이전 화면과 다음 화면이 일시적으로 공존하게 되고 애니메이션을 적용할 수 있게 된다. 다음은 메인 화면을 정의한 FXML 파일의 내용을 일시적으로 보여준다.
	
	// 루트 컨테이너가 StackPane으로 되어 있고, 메인 화면은 15~35 라인까지 BorderPane으로 추가되어 있다.
	// 메인 화면의 우측 상단에는 [로그인] 버튼이 있는데, 이 버튼을 클릭하면 로그인 화면으로 이동한다. 다음은 [로그인] 버튼 이벤트를 처리하는 RootController.java이다.
	
	// 25라인은 Scene의 루트 컨테이너인 StackPane을 얻는 코드이고, 26라인은 StackPane에 로그인 화면을 추가하는 코드이다.
	// 다음은 로그인 화면을 정의한 FXML 파일의 내용을 보여준다.
	
	// 로그인 화면의 좌측 상단에는 [메인] 버튼이 있는데, 이 버튼을 클릭하면 로그인 화면을 제거하고 메인 화면을 보여준다.
	// 다음은 [메인] 버튼 이벤트를 처리하는 LoginController.java이다.
	
	// 다음은 실행을 위한 메인 클래스의 내용을 보여준다.
	
			//	Animation
	
	// JavaFX에서 내이메이션은 컨트롤 또는 컨테이너의 속성(Property) 변화를 주어진 시간 동안 진행함으로써 구현한다. 다음은 애니메이션과 관련된 클래스를 설명한 표이다.
	
	//	클래스		설명
	//
	//	Timeline	KeyFrame에 설정된 내용대로 애니메이션을 진행시키는 객체
	//	KeyValue	타겟 속성(Property)과 종료값을 설정하는 객체
	//	KeyFrame	애니메이션의 지속 시간과 KeyValue를 설정하는 객체(지속 시간 동안 타겟 속성의 값을 종료값까지 변화시킴)
	
	// 다음은 translateX 속성을 주어진 종료값까지 변화시켜 수평 방향으로 슬라이드하는 애니메이션을 구현한 코드이다.
	// 종료값은 x 좌표값인데 음수, 0, 양수 값을 모두 가질 수 있다.
	
	//	1	Timeline timeline = new Timeline();
	//	2	KeyValue keyValue = new KeyValue(parent.translateXProperty(), 종료값);
	//	3	KeyFrame keyFrame = new KeyKrame(Duration.millis(지속시간), keyValue);
	//	4	timeline.getKeyFrames().add(keyFrame);
	//	5	timeline.play();
	
	// 1 Timeline 객체를 생성한다. 2 translateXProperty() 메소드로 값을 변화시킬 translateX 속성의 Property 객체를 얻고, 종료값을 지정해서 KeyValue 객체를 생성한다.
	// 3 애니메이션 지속 시간(밀리 세컨드 단위)과 KeyValue를 지정해서 KeyFrame을 생성한다. 4 Timeline에 KeyFrame을 추가한다. 5 Timeline을 플레이한다.
	// 다음 코드는 이전 예제의 [로그인] 버튼 이벤트 처리 메소드를 수정한 것인데, 로그인 화면이 나올 때 우측에서 좌측으로 수평 애니메이션이 진행되도록 했다.
	
	// KeyFrame은 지속 시간 동안 속성을 종료값까지 변화시키고 나서 콜백 메소드를 자동 호출하는 기능을 가지고 있다. 이 기능을 이용하려면 이벤트 핸들러를 추가해야 한다.
	// 예를 들어 다음은 opacity 속성을 주어진 종료값까지 변화시켜 서서히 나타나고, 사라지는 페이드(fade) 애니메이션을 구현한 코드이다.
	// 종료값은 투명도인데, 0.0 ~ 1.0 범위의 값을 가진다. 주목할 점은 애니메이션이 종료되고 나서 콜백될 이벤트 핸들러를 추가했다.
	
	//	Timeline timeline = new Timeline();
	//	KeyValue keyValue = new KeyValue(parent.opacityProperty(), 종료값);
	//	KeyFrame keyFrame = new KeyFrame(
	//		Duration.millis(지속시간),
	//		new EventHandler<ActionEvent>() {
	//			@Override
	//			public void handle(ActionEvent event) {
	//				// 애니메이션이 종료 후 실행할 코드
	//			}
	//		},
	//		keyValue
	//	);
	
	// 다음 코드는 이전 예제의 [메인] 버튼 이벤트 처리 메소드를 수정한 것인데, 로그인 화면이 사라질 때 좌측에서 우측으로 수평 애니메이션이 진행되도록 했다.
	// 애니메이션을 종료한 후에는 StackPane에서 로그인 화면을 완전히 제거한다.
}
