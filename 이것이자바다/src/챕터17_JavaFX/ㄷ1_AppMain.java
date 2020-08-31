package é��17_JavaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ��1_AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox();							// HBox �����̳� ����				
		hbox.setPadding(new Insets(10));				// ���� ���� ����
		hbox.setSpacing(10);							// ��Ʈ�� ���� ���� ���� ����
		
		TextField textField = new TextField();			// TextField ��Ʈ�� ����
		textField.setPrefWidth(200);					// TextField�� �� ����
		
		Button button = new Button();					// Button ��Ʈ�� ����
		button.setText("Ȯ��");							// Button ���� ����
		button.setOnAction( event -> Platform.exit() );
		
		ObservableList<Node> list = hbox.getChildren();	// HBox�� ObservableList ���
		list.add(textField);							// TextField ��Ʈ�� ��ġ
		list.add(button);								// Button�� ��Ʈ�� ��ġ
		
		Scene scene = new Scene(hbox);					// ��� ����
			
		primaryStage.setTitle("AppMain");				// ������ â ���� ����
		primaryStage.setScene(scene);					// ������ â�� ��� ����
		primaryStage.show();							// ������ â �����ֱ�
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
