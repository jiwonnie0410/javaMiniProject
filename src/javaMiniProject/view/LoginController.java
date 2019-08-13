package javaMiniProject.view;

import java.io.IOException;
import java.sql.SQLException;

import javaMiniProject.service.impl.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

	@FXML
	public void handleLogin(ActionEvent actionEvent) throws SQLException {
		int id = Integer.parseInt(txtId.getText());
		int password = Integer.parseInt(txtPassword.getText());
		boolean success = false;
		success = LoginServiceImpl.getInstance().login(id, password);

		if (success == true) {
			// 루트뷰로 들어가게 만들어야 함
			System.out.println("로그인 성공");

			try {
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
		}

	}

	private void lanch() {
		// TODO Auto-generated method stub
		
	}
}
