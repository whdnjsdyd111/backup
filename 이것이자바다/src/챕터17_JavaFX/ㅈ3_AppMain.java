package √©≈Õ17_JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class §∏3_AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("§∏3_root.fxml"));
		Parent root = loader.load();
		§∏3_RootController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
