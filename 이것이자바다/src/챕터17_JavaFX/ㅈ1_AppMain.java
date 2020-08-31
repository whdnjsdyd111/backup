package é��17_JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class ��1_AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Popup popup = new Popup();
			
		Parent parent = FXMLLoader.load(getClass().getResource("��1_popup.fxml"));
		ImageView imageView = (ImageView) parent.lookup("#imgMessage");
		imageView.setImage(new Image(getClass().getResource("images6/dialog-info.png").toString()));		// �޼������� �������� �ٸ��� �����ϱ� ���� �ڵ�� �̹��� ����
		imageView.setOnMouseClicked( event -> popup.hide() );	// popup �ݱ�
		Label lblMessage = (Label) parent.lookup("#lblMessage");
		lblMessage.setText("�޼����� �Խ��ϴ�.");						// Label �޼��� ����
			
		popup.getContent().add(parent);
		popup.setAutoHide(true);		// �ٸ� ������� ��Ŀ���� �̵��ϸ�(���콺�� Ŭ���ϸ�) �ڵ� ���� ����
		primaryStage.show();
		popup.show(primaryStage);		// popup ����
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
