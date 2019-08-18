package javaMiniProject.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javaMiniProject.ProjectMain;
import javaMiniProject.service.impl.LoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RootController implements Initializable {

	@FXML	BorderPane borderPane;
	@FXML	MenuBar menuBar;
	@FXML	Button btnLogInOut;
	@FXML	Label labelName;
	@FXML	Label labelNim;
	@FXML	Label labelHello;
	@FXML	ImageView imgLogo;
	@FXML	private AnchorPane anchorPane;
	@FXML	private TextField txtId;
	@FXML	private TextField txtPassword;
	@FXML	private Stage nextStage;
	@FXML 	private Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	@FXML
	public void clickLogo(MouseEvent mouseEvent) {
		try {
			AnchorPane homeView = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
			borderPane.setCenter(homeView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void handlePageBasicInform(ActionEvent actionEvent) {
		try {
			AnchorPane stuInform = FXMLLoader.load(getClass().getResource("BasicInform.fxml"));
			borderPane.setCenter(stuInform);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void handlePageSchoolInform(ActionEvent actionEvent) {
		try {
			AnchorPane schoolInform = FXMLLoader.load(getClass().getResource("SchoolInform.fxml"));
			borderPane.setCenter(schoolInform);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void handlePageBreak(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("BreakApply.fxml"));
			borderPane.setCenter(breakApply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	public void handleLoginPage(ActionEvent actionEvent) {
		try {
			AnchorPane loginView = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			borderPane.setCenter(loginView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void LoginFunction() {
		int id = Integer.parseInt(txtId.getText());
		int password = Integer.parseInt(txtPassword.getText());
		boolean success;
		success = LoginServiceImpl.getInstance().login(id, password);

		if (success == true) {
			// 로그인 성공했으니까 라벨이랑 로그아웃 버튼 보이게 하고
			// 로그인 화면 없어지고 홈 화면 보여야 함
			// 근데 안 됨 왜 안 되지??? 왜 setvisible 안 먹지??
			System.out.println("로그인 성공");
			ProjectMain.ID = id;
			
//			labelName.setVisible(true);
//			labelNim.setVisible(true);
//			labelHello.setVisible(true);
//			menuBar.setVisible(true);
//			labelName.setText("왜 안 되냐");
//			
//			try {
//				AnchorPane homeView = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
//				borderPane.setCenter(homeView);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
		} else {
			System.out.println("로그아웃 실패함");
			
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Login Failed");
			alert.setHeaderText("로그인 실패");
			alert.setContentText("Try Again! Check your Id and Password.");
			alert.show();
		}
	}

	@FXML // 수강 신청
	public void handlePageSugang(ActionEvent actionEvent) {
		try {
			AnchorPane sugang = FXMLLoader.load(getClass().getResource("SugangView.fxml"));
			borderPane.setCenter(sugang);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML // 등록금 납부 내역 조회
	public void handlePagePaymentHistory(ActionEvent actionEvent) {
		try {
			AnchorPane historyView = FXMLLoader.load(getClass().getResource("PayHistoryView.fxml"));
			borderPane.setCenter(historyView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML // 시간표
	public void handlePageTimeSchedule(ActionEvent actionEvent) {
		try {
			AnchorPane timescheduleView = FXMLLoader.load(getClass().getResource("TimeScheduleView.fxml"));
			borderPane.setCenter(timescheduleView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML // 성적조회
	public void handlePageShowScore(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("BackApply.fxml"));
			borderPane.setCenter(breakApply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML // 고지서
	public void handlePageBill(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("BackApply.fxml"));
			borderPane.setCenter(breakApply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML // 납부하기
	public void handlePagePay(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("BackApply.fxml"));
			borderPane.setCenter(breakApply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
