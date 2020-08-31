package é��17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ��3_RootController implements Initializable {
	@FXML private Button btn1;		// btn ��ü�� ����
	@FXML private Button btn2;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtn1Action(event);
			}
		});
		
		btn2.setOnAction( ��3_RootController :: handleBtn2Action);
	}
	
	public static void handleBtn1Action(ActionEvent event) {
		System.out.println("��ư 1 Ŭ��");
	}
	
	public static void handleBtn2Action(ActionEvent event) {
		System.out.println("��ư 2 Ŭ��");
	}
	
	public void handleBtn3Action(ActionEvent event) {
		System.out.println("��ư 3 Ŭ��");
	}
}
