package 챕터17_JavaFX;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ㄴ3_AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();				// Parent 하위 객체인 VBox 생성
		root.setPrefWidth(350);				// VBox의 폭 설정
		root.setPrefHeight(150);			// VBox의 높이 설정
		root.setAlignment(Pos.CENTER);		// 컨트롤을 중앙으로 정렬
		root.setSpacing(20);				// 컨트롤의 수직 간격
		
		Label label = new Label();			// Label 컨트롤 생성
		label.setText("Hello, JavaFX");		// text 속성 설정
		label.setFont(new Font(50));		// font 속성 설정
		
		Button button = new Button();		// Button 컨트롤 생성
		button.setText("확인");				// text 속성 설정
		button.setOnAction( event -> Platform.exit() );	// 클릭 이벤트 처리
		
		root.getChildren().add(label);		// VBox의 자식으로 Label 컨트롤 추가
		root.getChildren().add(button);		// VBox의 자식으로 button 컨트롤 추가
		
		Scene scene = new Scene(root);		// VBox를 루트 컨테이너로 해서 Scene 생성
		
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
