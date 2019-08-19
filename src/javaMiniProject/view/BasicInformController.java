package javaMiniProject.view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javaMiniProject.service.impl.InformationServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BasicInformController implements Initializable {
	@FXML	private AnchorPane achorPane;
	@FXML	private Button btnDelete;
	@FXML	private Button btnUpdate;
	@FXML	private TextField txtStudentNumber;
	@FXML	private TextField txtMajorName;
	@FXML	private TextField txtStudentName;
	@FXML	private TextField txtCollegeName;
	@FXML	private TextField txtAddress;
	@FXML	private TextField txtPhone;
	@FXML	private TextField txtIdentification;
	@FXML	private TextField txtGender;
	@FXML 	private ImageView ivStudent;
//	@FXML private ComboBox comboGender;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		// 학번 이름 폰번호 주소 전공 주민번호 성별
		List<Map<String, Object>> list = new ArrayList<>();
		list = InformationServiceImpl.getInstance().basicInform();
		
		File file = new File("image/1001.jpg");
	    Image image = new Image(file.toURI().toString());
		ivStudent.setImage(image);

		txtStudentNumber.setText(list.get(0).get("studentNumber").toString());
		txtStudentName.setText(list.get(0).get("studentName").toString());
		txtPhone.setText(list.get(0).get("phone").toString());
		txtAddress.setText(list.get(0).get("address").toString());
		txtMajorName.setText(list.get(0).get("majorName").toString());
		txtIdentification.setText(list.get(0).get("identification").toString());
		txtGender.setText(list.get(0).get("gender").toString());
//	comboGender.setItem(list.get(6).get("gender").toString());

	}

}
