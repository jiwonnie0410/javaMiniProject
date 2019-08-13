package javaMiniProject.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javaMiniProject.service.impl.StudentsInformServiceImpl;
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
	@FXML private TextField txtIdentification;
//	@FXML private ComboBox comboGender;
	
	
	@FXML
	private void selectBasicInform(ActionEvent actionEvent) {
		// 학번 이름 폰번호 주소 전공 주민번호 성별
		List<Map<String, Object>> list = new ArrayList<>();
		list = StudentsInformServiceImpl.getInstance().basicInform(1001);
		txtStudentNumber.setText(list.get(0).get("studentNumber").toString());
		txtStudentName.setText(list.get(1).get("studentName").toString());
		txtPhone.setText(list.get(2).get("phone").toString());
		txtAddress.setText(list.get(3).get("address").toString());
		txtMajorName.setText(list.get(4).get("majorName").toString());
		txtIdentification.setText(list.get(5).get("identification").toString());
		System.out.println(list.get(5).get("identification").toString());
//		comboGender.setItem(list.get(6).get("gender").toString());
	}

}





