package javaMiniProject.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javaMiniProject.service.impl.InformationServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class SchoolInformController implements Initializable{
	@FXML private TextField txtStudentNumber;
	@FXML private TextField txtStudentName;
	@FXML private TextField txtComplete;
	@FXML private TextField txtMajorName;
	@FXML private TextField txtDegree;
	@FXML private TextField txtStatus;
	@FXML private TextField txtCollege;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<>();
		list = InformationServiceImpl.getInstance().schoolInform();
		txtStudentNumber.setText(list.get(0).get("studentNumber").toString());
		txtStudentName.setText(list.get(0).get("studentName").toString());
		txtMajorName.setText(list.get(0).get("majorName").toString());
		txtComplete.setText(list.get(0).get("complete").toString());
		txtDegree.setText(list.get(0).get("degree").toString());
		txtStatus.setText(list.get(0).get("status").toString());
//		txtCollege.setText(list.get(0).get("college").toString());
	}

	
}
