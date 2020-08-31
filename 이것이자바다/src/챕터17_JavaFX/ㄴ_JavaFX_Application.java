package 챕터17_JavaFX;

public class ㄴ_JavaFX_Application {
	// JavaFX 애플리케이션을 개발하려면 제일 먼저 메인 클래스를 작성해야 한다. 메인 클래스는 JavaFX 애플리케이션을 시작하는 관문이다.
	
			//	Main Class		메인 클래스
	
	// JavaFX 애플리케이션을 시작시키는 메인 클래스는 추상 클래스인 javafx.application.Application을 상속받고, start() 메소드를 재정의해야 한다.
	// 그리고 main() 메소드에서 Application의 launch() 메소드를 호출해야 한다. launch() 메소드는 메인 클래스의 객체를 생성하고, 메인 윈도우를 생성한 다음 start() 메소드를 호출하는 역할을 한다.
	// 예제를 살펴보자.
	
	// JavaFX는 윈도우 무대(javafx.stage.Stage)로 표현한다. launch()에서 생성된 메인 윈도우를 start()의 primaryStage 매개값으로 제공하는데,
	// start() 메소드의 맨 마지막에서 primaryStage.show() 메소드를 호출함으로써 메인 윈도우가 보여진다.
	
			//	JavaFX 라이프사이클
	
	// JavaFX 애플리케이션은 Application.launch() 메소드부터 시작해서, 다음과 같은 순서로 진행한다.
	
	//		Application			Platform.exit() 호출
	//			↓						또는
	//		기본 생성자				마지막 Stage 닫힘
	//			↓						↓
	//		  init()				  stop()
	//			↓						↓
	//		  start()					종료
	//			↓
	//			사용
	
	// 메인 클래스의 기본 생성자를 호출해서 객체를 생성하고, 이어서 init() 메소드를 호출한다. init() 메소드는 메인 클래스의 실행 매개값을 얻어 애플리케이션이 이용할 수 있도록 해준다.
	// init()이 끝나고 나면, start() 메소드를 호출해서 메인 윈도우를 실행시킨다. JavaFX 애플리케이션이 종료되는 경우는 다음과 같이 세 가지가 있다.
	
	//	마우스로 마지막 윈도우(Stage)의 우측 상단 닫기 버튼을 클릭했을 때
	//	자바 코드로 마지막 윈도우(Stage)의 close() 메소드를 호출했을 때
	//	자바 코드로 Platform.exit() 또는 System.exit(0)을 호출했을 때
	
	// JavaFX 애플리케이션은 종료되기 직전에 stop() 메소드를 호출하는데, stop() 메소드는 애플리케이션이 종료되기 전에 자원을 정리(파일 닫기, 네트워크 끊기)할 기회를 준다.
	// init()과 stop() 메소드는 옵션으로 필요한 경우에 재정의해서 사용하면 된다.
	// 주목할 점은 라이프사이클의 각 단계에서 호출되는 메소드는 서로 다른 스레드상에서 실행된다는 것이다. 
	// JVM이 생성한 main 스레드가 Application.launch()를 실행하면 launch() 메소드는 다음과 같은 이름을 가진 두 가지 스레드를 생성하고 시작시킨다.
	
	//	JavaFX - Launcher : init() 실행
	//	JavaFX Application Thread : 메인 클래스 기본 생성자, start() 및 stop() 실행
	
	// JavaFX 애플리케이션에서 윈도우(Stage)를 비롯한 UI 생성 및 수정 작업, 입력 이벤트 처리 등은 모두 JavaFX Application Thread가 관장한다. 
	// 그 이유는 JavaFX API는 스레드에 안전하지 않아서 멀티 스레드가 동시에 UI를 생성하거나 수정하게 되면 문제가 발생하기 때문이다.
	// 그래서 JavaFX Application Thread만 UI를 생성하거나 수정할 수 있도록 되어 있고, 다른 스레드가 UI에 접근하게 되면 예외를 발생한다.
	// init() 메소드에서 UI를 생성하는 코드를 작성하면 안되는데, 그 이유는 init() 메소드가 JavaFX-Launcher 스레드에서 실행되기 때문이다.
	// 다음 예제는 기본 생성자, init(), start(), stop() 메소드가 어떤 스레드상에서 실행되는지 보여준다.
	
			//	Getting Main Class Running Parameter	메인 클래스 실행 매개값 얻기
	
	// init() 메소드이 역할은 메인 클래스의 실행 매개값을 얻어 애플리케이션의 초기값으로 이용할 수 있도록 하는 것이다.
	// 다음과 같이 메인 클래스를 실행할 때 -- 실행 옵션을 주었다고 가정해보자.
	
	//	java appMain --ip = 192.168.0.5	--port = 50001
	
	// Application.launch()는 main() 메소드의 매개값을 그대로 넘겨 받는데, 이 매개값은 init() 메소드에서 다음과 같은 두 가지 방법으로 얻을 수 있다.
	
	//	Parameters params = getParameters()
	//	List<String> list = params.getRaw();
	//	Map<String, String> map = params.getNamed()
	
	// Parameters의 getRaw() 메소드는 "--ip=192.168.0.5"와 "--port=50001"을 요소로 갖는 List 컬렉션을 리턴하고,
	// getNamed() 메소드는 "ip"를 키로해서 "192.168.0.5"를 저장하고, "port"를 키로해서 "50001"을 저장하는 Map 컬렉션을 리턴한다.
	
			//	Stage And Scene		무대와 장면
	
	// JavaFX는 윈도우를 무대(Stage)로 표현한다. 무대는 한 번에 하나의 장면을 가질 수 있는데, JavaFX는 장면을 javafx.scene.Scene으로 표현한다.
	// 메인 윈도우는 start() 메소드의 primaryStage 매개값으로 전달되지만, 장면(Scene)은 직접 생성해야 한다. Scene을 생성하려면 UI의 루트 컨테이너인 javafx.scene.Parent가 필요하다.
	
	//	Scene scene = new Scene(Parent root);
	
	// Parent는 추상 클래스이기 때문에 하위 클래스로 객체를 생성헤서 제공해야 한다. ㅈ로 java.scene.layout 패키지의 컨테이너들이 사용된다.
	// 실제로 UI 컨트롤들이 추가되는 곳은 Parent가 되고, Parent의 폭과 높이가 장면의 폭과 높이가 된다.
	
	//		Stage(윈도우) ──────────────────────┐
	//		│	Scene(장면) ────────────────── │					
	//		│	│	Parent(루트 컨테이너)──────	│ │
	//		│	│	│	│				  │	│ │
	//		│	│	│	├ Label(UI 컨트롤)  │	│ │
	//		│	│	│	└ Button(UI 컨트롤) │	│ │
	//		│	│	└──────────────────────	│ │
	//		│	└───────────────────────────┘ │
	//		└─────────────────────────────────┘
	
	// 장면(Scene)을 생성한 후에는 윈도우(Stage)에 올려야 하는데, Stage의 getScene() 메소드를 사용한다.
	// getScene() 메소드는 매개값으로 받은 Scene을 윈도우 내용으로 설정한다.
	
	//	primaryStage.setScene(scene);
	
	// 다음 예제는 Parent의 하위 클래스인 javafx.scene.layout.VBox를 이용해서 Scene을 생성하고 메인 윈도우(primaryStage)의 장면으로 설정했다.
	// VBox에는 Label과 Button 컨트롤을 배치했다.
	
	// VBox는 수직 방향으로 자식 컨트롤을 배치하는 컨테이너로 먼저 Label을 배치하고 그 아래에 Button을 배치했다. 28라인은 Button을 클릭했을 때 발생하는 ActionEvent를 람다식으로 처리한 것이다.
	// Button을 클릭하면 Platform.exit()를 호출해서 애플리케이션을 종료하도록 했다.
}
