package 챕터17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class ㅂ3_RootController implements Initializable {
	@FXML private AnchorPane root;
	@FXML private Circle circle;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		circle.centerXProperty().bind(Bindings.divide(root.widthProperty(), 2));
		circle.centerYProperty().bind(Bindings.divide(root.heightProperty(), 2));
//		Circle의 중심 center 속성 객체			속성 연산			루트컨테이너의 속성 객체		나누는값
	}
}
