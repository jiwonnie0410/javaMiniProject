package javaMiniProject.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javaMiniProject.model.PayHistoryTable;
import javaMiniProject.service.impl.PayHistoryService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PayHistoryController implements Initializable {
	@FXML Button btnSearch;
	@FXML TableView<PayHistoryTable> tvHistory;
	@FXML TableColumn<PayHistoryTable, Integer> clStudentNumber;
	@FXML TableColumn<PayHistoryTable, Integer> clCompleteSemester;
	@FXML TableColumn<PayHistoryTable, Integer> clCompleteYear;
	@FXML TableColumn<PayHistoryTable, String> clDidPay;
	@FXML TableColumn<PayHistoryTable, String> clPayDate;
	
	private Executor exec;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		clStudentNumber.setCellValueFactory(cellData -> cellData.getValue().studentNumberProperty().asObject());
		clCompleteSemester.setCellValueFactory(cellData -> cellData.getValue().completeSemesterProperty().asObject());
		clCompleteYear.setCellValueFactory(cellData -> cellData.getValue().completeYearProperty().asObject());
		clDidPay.setCellValueFactory(cellData -> cellData.getValue().didPayProperty());
		clPayDate.setCellValueFactory(cellData -> cellData.getValue().payDateProperty());
		
		
		Task<ObservableList<PayHistoryTable>> task = new Task<ObservableList<PayHistoryTable>>() {

			@Override
			protected ObservableList<PayHistoryTable> call() throws Exception {
				List<PayHistoryTable> list = PayHistoryService.getInstance().payHistoryTable();
				ObservableList<PayHistoryTable> obsList = FXCollections.observableArrayList(list);

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
		task.setOnSucceeded(e -> tvHistory.setItems((ObservableList<PayHistoryTable>) task.getValue()));
		// 작업 실행 시작
		exec.execute(task);
	}

}
