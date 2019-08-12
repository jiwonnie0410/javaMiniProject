package javaMiniProject.view;

import javaMiniProject.model.Students;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class InformController {
	
	@FXML private Button btnDelete;
	@FXML private Button btnUpdate;
	@FXML private TextField txtStudentNumber;
	@FXML private TextField txtMajorName;
	@FXML private TextField txtStudentName;
	@FXML private TextField txtCollegeName;
	@FXML private TextField txtAddress;
	@FXML private TextField txtPhone;
	@FXML private ComboBox comboGender;
	
	
	@FXML
	private void selectBasicInform(ActionEvent actionEvent) {
		// 학번 이름 폰번호 주소 전공 주민번호 성별
		try {
			txtStudentNumber.setText(value);
			txtStudentName.setText(value);
			txtPhone.setText(value);
			txtAddress.setText(value);
			txtMajorName.setText(value);
			comboGender.setValue(value);
			

		} catch (Exception e) {
			
		}
	}

}
