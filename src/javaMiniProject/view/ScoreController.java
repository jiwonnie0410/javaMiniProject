package javaMiniProject.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javaMiniProject.model.ScoreTable;
import javaMiniProject.service.impl.ScoreServiceImpl;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ScoreController implements Initializable{
	
	@FXML
	private TableView<ScoreTable> tvScore;
	@FXML
	private TableColumn<ScoreTable, Integer> columnNumber;
	@FXML
	private TableColumn<ScoreTable, Integer> columnYear;
	@FXML
	private TableColumn<ScoreTable, Integer> columnStudentGrade;
	@FXML
	private TableColumn<ScoreTable, Integer> columnCourseCode;
	@FXML
	private TableColumn<ScoreTable, String> columnCourseName;
	@FXML
	private TableColumn<ScoreTable, Integer> columnCoursePoint;
	@FXML
	private TableColumn<ScoreTable, String> columnGrade;
	@FXML
	private TableView<ScoreTable> tvScoreSemester;
	@FXML
	private TableColumn<ScoreTable, Integer> columnSemester;
	@FXML
	private TableColumn<ScoreTable, Integer> columnSumCPSemester;
	@FXML
	private TableColumn<ScoreTable, Integer> columnAvgCPSemester;

	// 쓰레드풀 지정
	private Executor exec;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//
		columnNumber.setCellValueFactory(cellData -> cellData.getValue().numberProperty().asObject());
		columnYear.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
		columnStudentGrade.setCellValueFactory(cellData -> cellData.getValue().studentGradeProperty().asObject());
		columnCourseCode.setCellValueFactory(cellData -> cellData.getValue().courseCodeProperty().asObject());
		columnCourseName.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
		columnCoursePoint.setCellValueFactory(cellData -> cellData.getValue().coursePointProperty().asObject());
		columnGrade.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());
		columnSemester.setCellValueFactory(cellData -> cellData.getValue().semesterProperty().asObject());
		columnSumCPSemester.setCellValueFactory(cellData -> cellData.getValue().sumCPSemesterProperty().asObject());
		columnAvgCPSemester.setCellValueFactory(cellData -> cellData.getValue().avgCPSemesterProperty().asObject());
		
		
		exec = Executors.newCachedThreadPool((runnable) -> {
			Thread t = new Thread(runnable);
			t.setDaemon(true);
			return t;
		});
		
		Task<ObservableList<ScoreTable>> task = new Task<ObservableList<ScoreTable>>() {

			@Override
			protected ObservableList<ScoreTable> call() throws Exception {
				List<ScoreTable> list = ScoreServiceImpl.getInstance().selectAllTable();
				ObservableList<ScoreTable> obsList = FXCollections.observableArrayList(list);

				return obsList;
			}

		};
		task.setOnSucceeded(e -> {
//			Platform.runLater(() ->{
				tvScore.setItems((ObservableList<ScoreTable>) task.getValue());
//			});
		});
//		tvDept.setItems(obsList);
		task.setOnFailed(e->{System.out.println("error");});
		exec.execute(task);
	}
	
	@FXML
	private void ShowAllScore(ActionEvent actionEvent) {
		Task<ObservableList<ScoreTable>> task = new Task<ObservableList<ScoreTable>>() {

			@Override
			protected ObservableList<ScoreTable> call() throws Exception {
				List<ScoreTable> list = ScoreServiceImpl.getInstance().selectAllTable();
				ObservableList<ScoreTable> obsList = FXCollections.observableArrayList(list);

				return obsList;
			}

		};
		task.setOnSucceeded(e -> tvScore.setItems((ObservableList<ScoreTable>) task.getValue()));
//		tvDept.setItems(obsList);
		exec.execute(task);
	}
	
}
