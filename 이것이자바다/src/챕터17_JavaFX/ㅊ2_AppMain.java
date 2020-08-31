package √©≈Õ17_JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class §∫2_AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = (Parent) FXMLLoader.load(getClass().getResource("§∫8_root.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("§∫8_app.css").toString());
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
