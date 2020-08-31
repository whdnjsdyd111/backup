package ц╘ем17_JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Question_AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Question_root.fxml"));
		Parent parent = loader.load();
		Question_RootController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
	
		Scene scene = new Scene(parent);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("AppMain");
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
