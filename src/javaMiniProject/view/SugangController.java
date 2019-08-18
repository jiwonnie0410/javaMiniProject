package javaMiniProject.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javaMiniProject.model.CoursesTable;
import javaMiniProject.service.impl.SugangServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SugangController implements Initializable {
	@FXML	AnchorPane anchorPane;
	@FXML	ListView<String> listSemester;
	@FXML	ListView<String> listCollege;
	@FXML	ListView<String> listMajor;
	@FXML	Button btnSearch;
	@FXML	Button btnSugang;
	@FXML	TableView<CoursesTable> tvCoures;
	@FXML	TextField txtCode;
	@FXML	TextField txtName;
	@FXML	Button btnShowAll;
	@FXML	TableColumn<CoursesTable, Integer> clCode;
	@FXML	TableColumn<CoursesTable, String> clCourseName;
	@FXML	TableColumn<CoursesTable, Integer> clPoint;
	@FXML	TableColumn<CoursesTable, String> clProfessor;
	@FXML	TableColumn<CoursesTable, String> clTime;
	@FXML	TableColumn<CoursesTable, Integer> clLimit;
	@FXML 	ComboBox<String> comboCollege;
	@FXML	ComboBox<String> comboMajor;
	@FXML	ComboBox<String> comboSemester;

	private Executor exec;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		// 콤보 박스 되는지 한번 확인...
		ObservableList<String> cbsemester = FXCollections.observableArrayList("1학기", "2학기");
		comboSemester.setItems(cbsemester);
		ObservableList<String> cbmajor = FXCollections.observableArrayList("컴퓨터공학과", "법학과", "기타등등ㅎㅎ");
		comboSemester.setItems(cbmajor);
		ObservableList<String> cbcollege = FXCollections.observableArrayList("공과대학", "인문대학");
		comboSemester.setItems(cbcollege);
		

		// 리스트뷰 값 초기화
		ObservableList<String> semester = FXCollections.observableArrayList("1", "2");
		listSemester.setItems(semester);
		ObservableList<String> college = FXCollections.observableArrayList("공과대학", "인문대학", "국제대학");
		listCollege.setItems(college);
		ObservableList<String> major = FXCollections.observableArrayList("컴퓨터공학과", "생물학과", "전기전자학과", "국어국문학과", "중어중문학과",
				"불어불문학과");
		listMajor.setItems(major);

		clCode.setCellValueFactory(cellData -> cellData.getValue().courseCodeProperty().asObject());
		clCourseName.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
		clPoint.setCellValueFactory(cellData -> cellData.getValue().coursePointProperty().asObject());
		clProfessor.setCellValueFactory(cellData -> cellData.getValue().professorNameProperty());
		clTime.setCellValueFactory(cellData -> cellData.getValue().timeScheduleProperty());
		clLimit.setCellValueFactory(cellData -> cellData.getValue().limitNumberProperty().asObject());

		// 쓰레드풀 생성
		exec = Executors.newCachedThreadPool((runnable) -> {
			Thread t = new Thread(runnable);
			t.setDaemon(true);
			return t;
		});

	}

	@FXML
	public void btnShowAllClicked(ActionEvent actionEvent) {
		Task<ObservableList<CoursesTable>> task = new Task<ObservableList<CoursesTable>>() {

			@Override
			protected ObservableList<CoursesTable> call() throws Exception {
				List<CoursesTable> list = SugangServiceImpl.getInstance().selectAllTable();
				ObservableList<CoursesTable> obsList = FXCollections.observableArrayList(list);

				return obsList;
			}

		};
		// 작업 실행 완료 후 호출
		task.setOnSucceeded(e -> tvCoures.setItems((ObservableList<CoursesTable>) task.getValue()));
		// 작업 실행 시작
		exec.execute(task);

	}

	@FXML
	public void btnShowClicked(ActionEvent actionEvent) {
		// 리스트뷰 다 선택한 다음에 클릭
		int semester = Integer.parseInt(listSemester.getSelectionModel().getSelectedItem().toString());
		String major = listMajor.getSelectionModel().getSelectedItem().toString();
		
		Task<ObservableList<CoursesTable>> task = new Task<ObservableList<CoursesTable>>() {

			@Override
			protected ObservableList<CoursesTable> call() throws Exception {
				List<CoursesTable> list = SugangServiceImpl.getInstance().selectOneTable(semester, major);
				ObservableList<CoursesTable> obsList = FXCollections.observableArrayList(list);

				return obsList;
			}

		};
		// 작업 실행 완료 후 호출
		task.setOnSucceeded(e -> tvCoures.setItems((ObservableList<CoursesTable>) task.getValue()));
		// 작업 실행 시작
		exec.execute(task);
		
		
	}

	@FXML
	public void btnSugangClicked(ActionEvent actionEvent) {
		// 수강신청
		int courseCode = Integer.parseInt(txtCode.getText());
		int semester = Integer.parseInt(listSemester.getSelectionModel().getSelectedItem().toString());
		SugangServiceImpl.getInstance().sugangApply(courseCode, semester);
		
	}

	@FXML
	protected void setTextFeildInformation(MouseEvent event) {
		txtCode.setText(Integer.toString(tvCoures.getSelectionModel().getSelectedItem().getCourseCode()));
		txtName.setText(tvCoures.getSelectionModel().getSelectedItem().getCourseName());
	}

}

/*
 * 
 * lv1.getSelectionModel().selectedItemProperty().addListener(
 * (ObservableValue<? extends String> ov, String old_val, String new_val) -> {
 * System.out.println("old val: " + old_val); System.out.println("new val: " +
 * new_val); int selIndex = lv1.getSelectionModel().getSelectedIndex(); String
 * selString = lv1.getSelectionModel().getSelectedItem();
 * System.out.println("선택된 인덱스 번호: " + selIndex + ", 선택된 값: " + selString); });
 * 
 */
