package 챕터17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class ㅌ2_RootController implements Initializable {
	@FXML private Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction( event -> handleBtnLogin(event) );
	}
	
	public void handleBtnLogin(ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("ㅌ1_login.fxml"));
			StackPane root = (StackPane) btnLogin.getScene().getRoot();
			root.getChildren().add(login);
			
			login.setTranslateX(350);		// 시작값을 350으로 설정(로그인 화면의 폭)
			
			Timeline timeline = new Timeline();
			KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
			KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
			timeline.getKeyFrames().add(keyFrame);
			timeline.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
