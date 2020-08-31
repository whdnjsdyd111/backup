package é��17_JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ��2_AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("Ȯ��");
		
		Parent parent = FXMLLoader.load(getClass().getResource("��2_custom_dialog.fxml"));
		
		Label txtTitle = (Label) parent.lookup("#txtTitle");
		txtTitle.setText("Ȯ���ϼ̽��ϱ�?");
		Button btnOk = (Button) parent.lookup("#btnOk");
		btnOk.setOnAction( event -> dialog.close() );
		Scene scene = new Scene(parent);
		
		dialog.setScene(scene);
		dialog.setResizable(false);
		dialog.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
