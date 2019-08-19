package javaMiniProject.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javaMiniProject.model.CoursesTable;
import javaMiniProject.service.impl.SugangDAO;
import javaMiniProject.service.impl.SugangServiceImpl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SugangController implements Initializable {
	@FXML	AnchorPane anchorPane;
	@FXML	Button btnSugang;
	@FXML	TableView<CoursesTable> tvCoures;
	@FXML	TextField txtCode;
	@FXML	TextField txtName;
	@FXML	TextField txtSemester;
	@FXML	Button btnShowAll;
	@FXML	TableColumn<CoursesTable, Integer> clCode;
	@FXML	TableColumn<CoursesTable, String> clCourseName;
	@FXML	TableColumn<CoursesTable, Integer> clPoint;
	@FXML	TableColumn<CoursesTable, String> clProfessor;
	@FXML	TableColumn<CoursesTable, String> clTime;
	@FXML	TableColumn<CoursesTable, Integer> clLimit;
	@FXML	ComboBox<String> comboCollege;
	@FXML	ComboBox<String> comboMajor;
	@FXML	ComboBox<String> comboSemester;

	private Executor exec;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// 콤보 박스 되는지 한번 확인... 된다~~!
		ObservableList<String> cbsemester = FXCollections.observableArrayList("1학기", "2학기");
		comboSemester.setItems(cbsemester);

		ObservableList<String> cbcollege = FXCollections.observableArrayList("공과대학", "인문대학", "국제대학");
		comboCollege.setItems(cbcollege);

		clCode.setCellValueFactory(cellData -> cellData.getValue().courseCodeProperty().asObject());
		clCourseName.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
		clPoint.setCellValueFactory(cellData -> cellData.getValue().coursePointProperty().asObject());
		clProfessor.setCellValueFactory(cellData -> cellData.getValue().professorNameProperty());
		clTime.setCellValueFactory(cellData -> cellData.getValue().timeScheduleProperty());
		clLimit.setCellValueFactory(cellData -> cellData.getValue().limitNumberProperty().asObject());

		// 테이블뷰에 그냥 전체 과목 다 나오게 설정
		Task<ObservableList<CoursesTable>> task = new Task<ObservableList<CoursesTable>>() {
			@Override
			protected ObservableList<CoursesTable> call() throws Exception {
				List<CoursesTable> list = SugangServiceImpl.getInstance().selectAllTable();
				ObservableList<CoursesTable> obsList = FXCollections.observableArrayList(list);
				return obsList;
			}
		};

		// 쓰레드풀 생성
		exec = Executors.newCachedThreadPool((runnable) -> {
			Thread t = new Thread(runnable);
			t.setDaemon(true);
			return t;
		});

		// 작업 실행 완료 후 호출
		task.setOnSucceeded(e -> tvCoures.setItems((ObservableList<CoursesTable>) task.getValue()));
		// 작업 실행 시작
		exec.execute(task);
		
		
		// college combobox event 지정
		comboCollege.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				onlyCollegeSelected(newValue);
				
				ArrayList<String> mList = new ArrayList<>();
				mList = SugangServiceImpl.getInstance().majorsFromCollege(newValue);
				
				ObservableList<String> cbmajor = FXCollections.observableArrayList(mList);
				comboMajor.setItems(cbmajor);
			}
		});
		
		// major combobox event 지정
		comboMajor.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				collegeMajorSelected(newValue);
			}
		});
		
		// semester combobox event 지정
		comboSemester.valueProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				int semester;
				if(newValue.equals("1학기"))
					semester = 1;
				else
					semester = 2;
				txtSemester.setText(Integer.toString(semester));
				
				
			}
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


	public void onlyCollegeSelected(String collegeName) {
		Task<ObservableList<CoursesTable>> task = new Task<ObservableList<CoursesTable>>() {
//		String collegeName = comboCollege.getValue().toString();
			
			@Override
			protected ObservableList<CoursesTable> call() throws Exception {
				List<CoursesTable> list = SugangServiceImpl.getInstance().CollegeSelected(collegeName);
				ObservableList<CoursesTable> obsList = FXCollections.observableArrayList(list);

				return obsList;
			}

		};
		// 작업 실행 완료 후 호출
		task.setOnSucceeded(e -> tvCoures.setItems((ObservableList<CoursesTable>) task.getValue()));
		// 작업 실행 시작
		exec.execute(task);
	}
	
	public void collegeMajorSelected(String majorName) {
		Task<ObservableList<CoursesTable>> task = new Task<ObservableList<CoursesTable>>() {
//			String collegeName = comboCollege.getValue().toString();
				
				@Override
				protected ObservableList<CoursesTable> call() throws Exception {
					List<CoursesTable> list = SugangServiceImpl.getInstance().collegeMajor(majorName);
					ObservableList<CoursesTable> obsList = FXCollections.observableArrayList(list);

					return obsList;
				}

			};
			// 작업 실행 완료 후 호출
			task.setOnSucceeded(e -> tvCoures.setItems((ObservableList<CoursesTable>) task.getValue()));
			// 작업 실행 시작
			exec.execute(task);
	}
	
	public void everyOptionSelected() {
		
	}
	
	public void collegeSemester(int semester) {
		Task<ObservableList<CoursesTable>> task = new Task<ObservableList<CoursesTable>>() {
				
				@Override
				protected ObservableList<CoursesTable> call() throws Exception {
					List<CoursesTable> list = SugangServiceImpl.getInstance().collegeMajor(majorName);
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
//		int semester = Integer.parseInt(listSemester.getSelectionModel().getSelectedItem().toString());
//		String major = listMajor.getSelectionModel().getSelectedItem().toString();
//		
//		Task<ObservableList<CoursesTable>> task = new Task<ObservableList<CoursesTable>>() {
//
//			@Override
//			protected ObservableList<CoursesTable> call() throws Exception {
//				List<CoursesTable> list = SugangServiceImpl.getInstance().selectOneTable(semester, major);
//				ObservableList<CoursesTable> obsList = FXCollections.observableArrayList(list);
//
//				return obsList;
//			}
//
//		};
//		// 작업 실행 완료 후 호출
//		task.setOnSucceeded(e -> tvCoures.setItems((ObservableList<CoursesTable>) task.getValue()));
//		// 작업 실행 시작
//		exec.execute(task);
//		

	}

	@FXML
	public void btnSugangClicked(ActionEvent actionEvent) {
		// 수강신청
		int courseCode = Integer.parseInt(txtCode.getText());
		int semester = Integer.parseInt(txtSemester.getText());
		SugangServiceImpl.getInstance().sugangApply(courseCode, semester);

	}

	@FXML
	protected void setTextFeildInformation(MouseEvent event) {
		txtCode.setText(Integer.toString(tvCoures.getSelectionModel().getSelectedItem().getCourseCode()));
		txtName.setText(tvCoures.getSelectionModel().getSelectedItem().getCourseName());
		if (comboSemester.getValue() != null) {
			if (comboSemester.getValue().equals("1학기"))
				txtSemester.setText("1");
			else
				txtSemester.setText("2");
		}

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
