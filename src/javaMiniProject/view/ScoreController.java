package javaMiniProject.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javaMiniProject.model.ScoreSemesterTable;
import javaMiniProject.model.ScoreTable;
import javaMiniProject.model.TotalScore;
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
import javafx.scene.control.TextField;


public class ScoreController implements Initializable{
	
	@FXML
	private TableView<ScoreTable> tvScore;
	@FXML
	private TableColumn<ScoreTable, Integer> columnNumber;
	@FXML
	private TableColumn<ScoreTable, Integer> columnYear;
//	@FXML
//	private TableColumn<ScoreTable, Integer> columnStudentGrade;
	@FXML
	private TableColumn<ScoreTable, Integer> columnCourseCode;
	@FXML
	private TableColumn<ScoreTable, String> columnCourseName;
	@FXML
	private TableColumn<ScoreTable, Integer> columnCoursePoint;
	@FXML
	private TableColumn<ScoreTable, String> columnGrade;
	
	@FXML
	private TableView<ScoreSemesterTable> tvScoreSemester;
	@FXML
	private TableColumn<ScoreSemesterTable, Integer> columnNumber2;
	@FXML
	private TableColumn<ScoreSemesterTable, Integer> columnYear2;
	@FXML
	private TableColumn<ScoreSemesterTable, Integer> columnSemester;
	@FXML
	private TableColumn<ScoreSemesterTable, Integer> columnSumCPSemester;
	@FXML
	private TableColumn<ScoreSemesterTable, Double> columnAvgCPSemester;
	@FXML
	private TextField txtAllScoreSum;
	@FXML
	private TextField txtSemesterCPSum;
	@FXML
	private TextField txtSemesterScoreSum;
	@FXML
	private TextField txtSemesterScoreAvg;

	// 쓰레드풀 지정
	private Executor exec;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//
		columnNumber.setCellValueFactory(cellData -> cellData.getValue().numberProperty().asObject());
		columnYear.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
//		columnStudentGrade.setCellValueFactory(cellData -> cellData.getValue().studentGradeProperty().asObject());
		columnCourseCode.setCellValueFactory(cellData -> cellData.getValue().courseCodeProperty().asObject());
		columnCourseName.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
		columnCoursePoint.setCellValueFactory(cellData -> cellData.getValue().coursePointProperty().asObject());
		columnGrade.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());
		
		
		columnNumber2.setCellValueFactory(cellData -> cellData.getValue().number2Property().asObject());
		columnYear2.setCellValueFactory(cellData -> cellData.getValue().year2Property().asObject());
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
				System.out.println(task.toString());
//			});
		});
//		tvDept.setItems(obsList);
		task.setOnFailed(e->{System.out.println("error");});
		exec.execute(task);
		
		
		Task<ObservableList<ScoreSemesterTable>> task2 = new Task<ObservableList<ScoreSemesterTable>>() {

			@Override
			protected ObservableList<ScoreSemesterTable> call() throws Exception {
				List<ScoreSemesterTable> list = ScoreServiceImpl.getInstance().selectSemesterTable();
				ObservableList<ScoreSemesterTable> obsList = FXCollections.observableArrayList(list);

				return obsList;
			}

		};
		task2.setOnSucceeded(e -> {
//			Platform.runLater(() ->{
				tvScoreSemester.setItems((ObservableList<ScoreSemesterTable>) task2.getValue());
				System.out.println(task2.toString());
//			});
		});
//		tvDept.setItems(obsList);
		task.setOnFailed(e->{System.out.println("error");});
		exec.execute(task2);
		
//		TotalScore score = new TotalScore();
//		score.setAllScoreSum(In);
	}
	
//	@FXML
//	private void ShowAllScore(ActionEvent actionEvent) {
//		Task<ObservableList<ScoreTable>> task = new Task<ObservableList<ScoreTable>>() {
//
//			@Override
//			protected ObservableList<ScoreTable> call() throws Exception {
//				List<ScoreTable> list = ScoreServiceImpl.getInstance().selectAllTable();
//				ObservableList<ScoreTable> obsList = FXCollections.observableArrayList(list);
//
//				return obsList;
//			}
//
//		};
//		task.setOnSucceeded(e -> tvScore.setItems((ObservableList<ScoreTable>) task.getValue()));
////		tvDept.setItems(obsList);
//		exec.execute(task);
//	}
	
}
