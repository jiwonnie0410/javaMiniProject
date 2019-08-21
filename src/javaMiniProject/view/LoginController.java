package javaMiniProject.view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;

import javaMiniProject.ProjectMain;
import javaMiniProject.service.impl.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController {

	@FXML	private AnchorPane anchorPane;
	@FXML	private TextField txtId;
	@FXML	private TextField txtPassword;
	@FXML	private Button btnLogin;
	@FXML	private Label lbId;

	@FXML
	public void handleLogin(ActionEvent actionEvent) throws SQLException {
		try {
			int id = Integer.parseInt(txtId.getText());
			int password = Integer.parseInt(txtPassword.getText());
			boolean success = LoginServiceImpl.getInstance().login(id, password);
			if (success == true) {
				// 루트뷰로 들어가게 만들어야 함
				System.out.println("로그인 성공");
				ProjectMain.ID = id;

				try {
					AnchorPane homeView = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
					anchorPane.getChildren().setAll(homeView);
				} catch (IOException e) {
				}
			} else {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Login Failed");
				alert.setHeaderText("로그인 실패");
				alert.setContentText("Try Again! Check your Id and Password.");
				alert.show();
			}
		} catch (InputMismatchException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Login Failed");
			alert.setHeaderText("로그인 실패");
			alert.setContentText("학번과 비밀번호는 숫자로 이루어져있습니다.");
			alert.show();
		}

	}
}
