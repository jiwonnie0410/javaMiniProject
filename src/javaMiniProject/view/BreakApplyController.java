package javaMiniProject.view;

import java.net.URL;
import java.util.ResourceBundle;

import javaMiniProject.service.impl.InformationServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class BreakApplyController implements Initializable {
	@FXML private AnchorPane anchorPane;
//	@FXML private MenuItem itemFirst;
//	@FXML private MenuItem itemSecond;
	@FXML private ComboBox<String> comboOption;
	@FXML private ComboBox<String> comboSemester;
	@FXML private RadioButton radioBreak;
	@FXML private RadioButton radioBack;
	@FXML private RadioButton radioFirst;
	@FXML private RadioButton radioSecond;
	@FXML private TextField txtReason;
	@FXML private Button btnApply;
	
//	ObservableList<String> list = FXCollections.observableArrayList("1학기", "2학기");

	@FXML
	public void handleApply(ActionEvent actionEvent) {
		int semester = 0;
		String reason = null;
		
		if(radioBreak.isSelected()) {
			if(radioFirst.isSelected())
				semester = 1;
			else
				semester = 2;
			reason = txtReason.getText();
			InformationServiceImpl.getInstance().breakApply(semester, reason);
		}
		else if(radioBack.isSelected()) {
			if(radioFirst.isSelected())
				semester = 1;
			else
				semester = 2;
			InformationServiceImpl.getInstance().backApply(semester);
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 콤보 박스 되는지 확인
		ObservableList<String> option = FXCollections.observableArrayList("휴학", "복학");
		comboOption.setItems(option);
		ObservableList<String> semester = FXCollections.observableArrayList("1학기", "2학기");
		comboSemester.setItems(semester);
		
//		comboBox.setItems(list);
		ToggleGroup tg = new ToggleGroup();
		radioBreak.setToggleGroup(tg);
		radioBack.setToggleGroup(tg);
		ToggleGroup tg2 = new ToggleGroup();
		radioFirst.setToggleGroup(tg2);
		radioSecond.setToggleGroup(tg2);
	}

}
