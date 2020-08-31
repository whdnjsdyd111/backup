package é��17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ��4_RootController implements Initializable {
	@FXML
	private MediaView mediaView;
	@FXML
	private ImageView imageView;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnPause;
	@FXML
	private Button btnStop;

	private boolean endOfMedia; // ��� �ϷḦ Ȯ���ϴ� �÷��� �ʵ�

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// �̵�� ��ü ����
		Media media = new Media(getClass().getResource("media/video.m4v").toString());
		// Media media = new
		// Media(getClass().getResource("media/audio.wav").toString());

		// �̵�� �÷��̾� ���� �� �̵�� �信 ����
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);

		// �ش� ���°� �Ǹ� ������ Runnable ����
		mediaPlayer.setOnReady(new Runnable() { // Ready ���°� �ɶ� ����
			@Override
			public void run() {
				mediaPlayer.setAutoPlay(true);
			}
		});

		// Playing ���°� �� �� ����
		mediaPlayer.setOnPlaying(() -> {
			btnPlay.setDisable(true);
			btnPause.setDisable(false);
			btnStop.setDisable(false);
		});

		// Paused ���°� �� �� ����
		mediaPlayer.setOnPaused(() -> {
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});

		// EndOfMedia ���°� �� �� ����
		mediaPlayer.setOnEndOfMedia(() -> {
			endOfMedia = true;
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});

		// Stopped ���°� �� �� ����
		mediaPlayer.setOnStopped(() -> {
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});

		// ��ư ActionEvent ó��
		btnPlay.setOnAction(event -> {
			if (endOfMedia) { // EndOfMedia ������ ���
				mediaPlayer.stop(); // ��� ����
				mediaPlayer.seek(mediaPlayer.getStartTime()); // ��� �ð��� ó������ ����
			}
			mediaPlayer.play();
			endOfMedia = false;
		});

		btnPause.setOnAction(event -> mediaPlayer.pause()); // �̵�� �Ͻ� ����
		btnStop.setOnAction(event -> mediaPlayer.stop()); // �̵�� ����
	}
}
