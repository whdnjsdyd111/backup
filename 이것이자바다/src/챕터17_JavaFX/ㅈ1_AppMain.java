package 챕터17_JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class ㅈ1_AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Popup popup = new Popup();
			
		Parent parent = FXMLLoader.load(getClass().getResource("ㅈ1_popup.fxml"));
		ImageView imageView = (ImageView) parent.lookup("#imgMessage");
		imageView.setImage(new Image(getClass().getResource("images6/dialog-info.png").toString()));		// 메세지별로 아이콘을 다르게 지정하기 위해 코드로 이미지 지정
		imageView.setOnMouseClicked( event -> popup.hide() );	// popup 닫기
		Label lblMessage = (Label) parent.lookup("#lblMessage");
		lblMessage.setText("메세지가 왔습니다.");						// Label 메세지 지정
			
		popup.getContent().add(parent);
		popup.setAutoHide(true);		// 다른 윈도우로 포커스를 이동하면(마우스를 클릭하면) 자동 닫힘 설정
		primaryStage.show();
		popup.show(primaryStage);		// popup 띄우기
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
