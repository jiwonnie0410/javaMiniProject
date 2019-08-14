package javaMiniProject.view;

import java.io.IOException;
import java.sql.SQLException;

import javaMiniProject.ProjectMain;
import javaMiniProject.service.impl.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginController {

	@FXML	private AnchorPane anchorPane;
	@FXML	private TextField txtId;
	@FXML	private TextField txtPassword;
	@FXML	private BorderPane borderPane;
	@FXML	private Stage nextStage;
	@FXML 	private Button btnLogin;

	@FXML
	public void handleLogin(ActionEvent actionEvent) throws SQLException {
		int id = Integer.parseInt(txtId.getText());
		int password = Integer.parseInt(txtPassword.getText());
		boolean success;
		success = LoginServiceImpl.getInstance().login(id, password);
//		int rId = LoginServiceImpl.getInstance().login(id, password);

		if (success = true) {
			// 루트뷰로 들어가게 만들어야 함
			System.out.println("로그인 성공");
			try {
				ProjectMain.ID = id;
				Stage nextStage = (Stage) btnLogin.getScene().getWindow();
				borderPane = FXMLLoader.load(getClass().getResource("RootView.fxml"));
				Scene scene = new Scene(borderPane, 650, 450);
				nextStage.setScene(scene);
				nextStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("로그아웃 실패함");
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Login Failed");
			alert.setHeaderText("로그인 실패");
			alert.setContentText("Try Again! Check your Id and Password.");
			alert.show();
		}
	}
}
