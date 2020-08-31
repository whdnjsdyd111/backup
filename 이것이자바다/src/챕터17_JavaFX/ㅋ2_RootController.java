package 챕터17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ㅋ2_RootController implements Initializable {
	@FXML private ProgressBar progressBar;
	@FXML private Label lblWorkDone;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	
	private Task<Void> task;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction( event -> handleBtnStart(event) );
		btnStop.setOnAction( event -> handleBtnStop(event) );
	}
	
	public void handleBtnStart(ActionEvent e) {
		task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				for (int i = 1; i <= 100; i++) {
					if(isCancelled()) {
						updateMessage("취소됨");
						break;
					}
					updateProgress(i, 100);
					updateMessage(String.valueOf(i));
					try { Thread.sleep(100); } catch(InterruptedException e) {
						if(isCancelled()) {
							updateMessage("취소됨");
							break;
						}
					}
				}
				return null;
			}
		};
		
		progressBar.progressProperty().bind(task.progressProperty());
		lblWorkDone.textProperty().bind(task.messageProperty());			// 속성 바인딩
		
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	
	public void handleBtnStop(ActionEvent e) {
		task.cancel();		// 작업 취소
	}
}
