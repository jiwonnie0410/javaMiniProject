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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class BreakApplyController implements Initializable {
	@FXML	private AnchorPane anchorPane;
	@FXML	private ComboBox<String> comboOption;
	@FXML	private ComboBox<String> comboSemester;
	@FXML	private TextField txtReason;
	@FXML	private Button btnApply;

	@FXML
	public void handleApply(ActionEvent actionEvent) {
		int semester = 0;
		String reason = null;

		if (comboSemester.getValue().equals("1학기")) {
			semester = 1;
		} else {
			semester = 2;
			if (txtReason.getText() != null)
				reason = txtReason.getText();
		}
		
		if(comboOption.getValue().equals("휴학")) {
			InformationServiceImpl.getInstance().breakApply(semester, reason);
		}
		else
			InformationServiceImpl.getInstance().backApply(semester);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 콤보 박스 되는지 확인
		ObservableList<String> option = FXCollections.observableArrayList("휴학", "복학");
		comboOption.setItems(option);

		ObservableList<String> semester = FXCollections.observableArrayList("1학기", "2학기");
		comboSemester.setItems(semester);

	}

}
