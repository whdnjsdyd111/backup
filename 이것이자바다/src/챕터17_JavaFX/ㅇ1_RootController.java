package √©≈Õ17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class §∑1_RootController implements Initializable {
	@FXML private TextArea textArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void handleNew(ActionEvent e) {
		textArea.appendText("New\n");
	}
	
	public void handleOpen(ActionEvent e) {
		textArea.appendText("Open\n");
	}
	
	public void handleSave(ActionEvent e) {
		textArea.appendText("Save\n");
	}
	
	public void handleExit(ActionEvent e) {
		Platform.exit();
	}
}
