package Ã©ÅÍ17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ¤¼1_RootController implements Initializable {
	@FXML private Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction( event -> handleBtnLogin(event) );
	}
	
	public void handleBtnLogin(ActionEvent event) {
		try {
			Parent login = FXMLLoader.load(getClass().getResource("¤¼1_login.fxml"));
			StackPane root = (StackPane) btnLogin.getScene().getRoot();
			root.getChildren().add(login);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
