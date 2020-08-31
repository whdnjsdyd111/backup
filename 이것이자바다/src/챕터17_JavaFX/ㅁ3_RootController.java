package 챕터17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ㅁ3_RootController implements Initializable {
	@FXML private Button btn1;		// btn 객체들 주입
	@FXML private Button btn2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtn1Action(event);
			}
		});
		
		btn2.setOnAction( ㅁ3_RootController :: handleBtn2Action);
	}
	
	public static void handleBtn1Action(ActionEvent event) {
		System.out.println("버튼 1 클릭");
	}
	
	public static void handleBtn2Action(ActionEvent event) {
		System.out.println("버튼 2 클릭");
	}
	
	public void handleBtn3Action(ActionEvent event) {
		System.out.println("버튼 3 클릭");
	}
}
