package é��17_JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;

public class ��2_AppMain extends Application {
	public ��2_AppMain() {
		System.out.println(Thread.currentThread().getName() + ": Appmain() ȣ��");
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": init() ȣ��");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + ": start() ȣ��");
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + ": stop() ȣ��");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + ": main() ȣ��");
		launch(args);
	}
}
