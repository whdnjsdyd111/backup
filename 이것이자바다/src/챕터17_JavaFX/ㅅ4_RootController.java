package 챕터17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ㅅ4_RootController implements Initializable {
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

	private boolean endOfMedia; // 재생 완료를 확인하는 플래그 필드

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 미디어 객체 생성
		Media media = new Media(getClass().getResource("media/video.m4v").toString());
		// Media media = new
		// Media(getClass().getResource("media/audio.wav").toString());

		// 미디어 플레이어 생성 및 미디어 뷰에 설정
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);

		// 해당 상태가 되면 실행할 Runnable 설정
		mediaPlayer.setOnReady(new Runnable() { // Ready 상태가 될때 실행
			@Override
			public void run() {
				mediaPlayer.setAutoPlay(true);
			}
		});

		// Playing 상태가 될 때 실행
		mediaPlayer.setOnPlaying(() -> {
			btnPlay.setDisable(true);
			btnPause.setDisable(false);
			btnStop.setDisable(false);
		});

		// Paused 상태가 될 때 실행
		mediaPlayer.setOnPaused(() -> {
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});

		// EndOfMedia 상태가 될 때 실행
		mediaPlayer.setOnEndOfMedia(() -> {
			endOfMedia = true;
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});

		// Stopped 상태가 될 때 실행
		mediaPlayer.setOnStopped(() -> {
			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});

		// 버튼 ActionEvent 처리
		btnPlay.setOnAction(event -> {
			if (endOfMedia) { // EndOfMedia 상태일 경우
				mediaPlayer.stop(); // 재생 중지
				mediaPlayer.seek(mediaPlayer.getStartTime()); // 재생 시간을 처음으로 돌림
			}
			mediaPlayer.play();
			endOfMedia = false;
		});

		btnPause.setOnAction(event -> mediaPlayer.pause()); // 미디어 일시 중지
		btnStop.setOnAction(event -> mediaPlayer.stop()); // 미디어 중지
	}
}
