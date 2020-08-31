package 챕터17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ㅅ3_RootController implements Initializable {
	@FXML private ListView<String> listView;
	@FXML private TableView<ㅅ3_Phone> tableView;
	@FXML private ImageView imageView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listView.setItems(FXCollections.observableArrayList(
				"갤럭시S1", "갤럭시S2", "갤럭시S3", "갤럭시S4", "갤럭시S5", "갤럭시S6", "갤럭시S7" 
		));
		
		listView.getSelectionModel().selectedIndexProperty().addListener(
			new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					tableView.getSelectionModel().select(newValue.intValue());	// 변경된 인덱스의 행 선택
					tableView.scrollTo(newValue.intValue());					// 변경된 인덱스 위치로 스크롤 시킴
				}
			}
		);
		
		ObservableList phoneList = FXCollections.observableArrayList(
			new ㅅ3_Phone("갤럭시S1", "phone01.png"),
			new ㅅ3_Phone("갤럭시S2", "phone02.png"),
			new ㅅ3_Phone("갤럭시S3", "phone03.png"),
			new ㅅ3_Phone("갤럭시S4", "phone04.png"),
			new ㅅ3_Phone("갤럭시S5", "phone05.png"),
			new ㅅ3_Phone("갤럭시S6", "phone06.png"),
			new ㅅ3_Phone("갤럭시S7", "phone07.png")
		);
		
		TableColumn tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(new PropertyValueFactory("smartPhone"));
		tcSmartPhone.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(new PropertyValueFactory("image"));
		tcImage.setStyle("-fx-alignmnet: CENTER;");
		
		tableView.setItems(phoneList);
		
		tableView.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ㅅ3_Phone>() {
				public void changed(javafx.beans.value.ObservableValue<? extends ㅅ3_Phone> observable, ㅅ3_Phone oldValue, ㅅ3_Phone newValue) {
					if(newValue!=null) {
						imageView.setImage(new Image(
								getClass().getResource("images5/" + newValue.getImage()).toString()));
					}
				}
			}
		);
	}
	
	public void handleBtnOkAction(ActionEvent e) {
		String item = listView.getSelectionModel().getSelectedItem();	// 선택된 항목(행)의 데이터 얻기
		System.out.println("ListView 스마트폰: " + item);
		
		ㅅ3_Phone phone = tableView.getSelectionModel().getSelectedItem();
		System.out.println("TableView 스마트폰: " + phone.getSmartPhone());
		System.out.println("TableView 이미지: " + phone.getImage());
	}
	
	public void handleBtnCancelAction(ActionEvent e) {
		Platform.exit();
	}
}
