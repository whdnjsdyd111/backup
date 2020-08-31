package 챕터17_JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;

public class ㄴ2_AppMain extends Application {
	public ㄴ2_AppMain() {
		System.out.println(Thread.currentThread().getName() + ": Appmain() 호출");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": init() 호출");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + ": start() 호출");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": stop() 호출");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + ": main() 호출");
		launch(args);
	}
}
