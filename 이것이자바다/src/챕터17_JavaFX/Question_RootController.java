package 챕터17_JavaFX;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Question_RootController implements Initializable {
	@FXML private Button addBtn;
	@FXML private Button graphBtn;
	@FXML private TableView<Question_Student> tableView;
	
	ObservableList<Question_Student> list;
	
	private Stage graphDialog;
	private Stage addDialog;
	private Stage primaryStage;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addBtn.setOnAction( event -> {
			try { handleAddBtn(event); } catch (Exception e) { e.printStackTrace(); }
		});
		
		graphBtn.setOnAction( event -> {
			try { handleGraphBtn(event); } catch (Exception e) { e.printStackTrace(); }
		});
			
		list = FXCollections.observableArrayList();
		
		TableColumn<Question_Student, ?> tcName = tableView.getColumns().get(0);
		tcName.setCellValueFactory(new PropertyValueFactory("name"));
		tcName.setStyle("-fx-alignment : CENTER;");
		
		TableColumn<Question_Student, ?> tcLanguage = tableView.getColumns().get(1);
		tcLanguage.setCellValueFactory(new PropertyValueFactory("language"));
		tcLanguage.setStyle("-fx-alignment : CENTER;");
		
		TableColumn<Question_Student, ?> tcMath = tableView.getColumns().get(2);
		tcMath.setCellValueFactory(new PropertyValueFactory("math"));
		tcMath.setStyle("-fx-alignment : CENTER;");
		
		TableColumn<Question_Student, ?> tcEnglish = tableView.getColumns().get(3);
		tcEnglish.setCellValueFactory(new PropertyValueFactory("english"));
		tcEnglish.setStyle("-fx-alignment : CENTER;");
		
		tableView.setItems(list);
		
		tableView.setOnMouseClicked( event -> {
			try {
				handleTableViewClicked(event); } catch (Exception e) { e.printStackTrace(); }
		});
	}
	
	public void handleAddBtn(ActionEvent e) throws Exception {
		addDialog = new Stage(StageStyle.UTILITY);
		
		addDialog.setTitle("추가");
		addDialog.initModality(Modality.WINDOW_MODAL);
		addDialog.initOwner(primaryStage);
		
		Parent parent = FXMLLoader.load(getClass().getResource("Question_form.fxml"));
		
		Button dialogAddBtn = (Button) parent.lookup("#dialogAddBtn");
		Button cancel = (Button) parent.lookup("#cancel");
		
		dialogAddBtn.setOnAction( event -> {
			TextField name = (TextField) parent.lookup("#StName");
			TextField language = (TextField) parent.lookup("#StLanguage");
			TextField math = (TextField) parent.lookup("#StMath");
			TextField english = (TextField) parent.lookup("#StEnglish");
		
			Question_Student student = new Question_Student(
				name.getText(), Integer.parseInt(language.getText()),
						Integer.parseInt(math.getText()), Integer.parseInt(english.getText())
			);
			
			list.add(student);
			
			addDialog.close();
		});
		
		cancel.setOnAction( event -> handleCancel(event) );
		
		Scene scene = new Scene(parent);
		
		addDialog.setScene(scene);
		addDialog.setResizable(false);
		addDialog.show();
	}
	
	public void handleCancel(ActionEvent e) {
		addDialog.close();
	}
	
	@SuppressWarnings("unchecked")
	public void handleGraphBtn(ActionEvent e) throws Exception {
		graphDialog = new Stage(StageStyle.UTILITY);
		
		graphDialog.setTitle("막대 그래프");
		graphDialog.initModality(Modality.WINDOW_MODAL);
		graphDialog.initOwner(primaryStage);
		
		Parent parent = FXMLLoader.load(getClass().getResource("Question_barchart.fxml"));
		
		BarChart<String, Integer> barchart = (BarChart<String, Integer>) parent.lookup("#barchart");
		Button cancelBtn = (Button) parent.lookup("#cencel1");
		
		XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
		XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();
		XYChart.Series<String, Integer> series3 = new XYChart.Series<String, Integer>();
		
		series1.setName("국어");
		series2.setName("수학");
		series3.setName("영어");
		
		for(int i = 0; i < list.size(); i++) {
			series1.getData().add(new XYChart.Data<String, Integer>(list.get(i).getName(), list.get(i).getLanguage()));
			series2.getData().add(new XYChart.Data<String, Integer>(list.get(i).getName(), list.get(i).getMath()));
			series3.getData().add(new XYChart.Data<String, Integer>(list.get(i).getName(), list.get(i).getEnglish()));
		}
		
		
		barchart.getData().add(series1);
		barchart.getData().add(series2);
		barchart.getData().add(series3);
		
		
		cancelBtn.setOnAction( event -> graphDialog.close() );
		
		Scene scene = new Scene(parent);
		
		graphDialog.setScene(scene);
		graphDialog.setResizable(false);
		graphDialog.setX(1300.0);
		graphDialog.setY(250.0);
		graphDialog.show();
		
	}
	
	public void handleTableViewClicked(MouseEvent event) throws Exception {
		
		if(event.getClickCount() != 2 || tableView.getItems().isEmpty()
				|| tableView.getSelectionModel().isEmpty()) {
			return;
		}
		
		Stage pieDialog = new Stage(StageStyle.UTILITY);
			
		pieDialog.setTitle("파이 그래프");
		pieDialog.initModality(Modality.WINDOW_MODAL);
		pieDialog.initOwner(primaryStage);
		
		Parent parent = FXMLLoader.load(getClass().getResource("Question_piechart.fxml"));
				
		Button button = (Button) parent.lookup("#cancel2");
		PieChart pieChart = (PieChart) parent.lookup("#pieChart");
		Question_Student student = tableView.getSelectionModel().getSelectedItem();
		
		pieChart.setData(FXCollections.observableArrayList(
			new PieChart.Data("국어", student.getLanguage()),
			new PieChart.Data("수학", student.getMath()),
			new PieChart.Data("영어", student.getEnglish())
		));
		
		
		Scene scene = new Scene(parent);
		
		button.setOnAction( e1 -> pieDialog.close() );		
		
		pieDialog.setScene(scene);
		pieDialog.setResizable(false);
		pieDialog.setX(1300.0);
		pieDialog.setY(250.0);
		pieDialog.show();

	}
}
