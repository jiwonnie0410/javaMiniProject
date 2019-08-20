package javaMiniProject.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class RootController{

	@FXML	BorderPane borderPane;
	@FXML	MenuBar menuBar;
	@FXML	Button btnLogInOut;
	@FXML	ImageView imgLogo;
	
	@FXML
	public void clickLogo(MouseEvent mouseEvent) {
		try {
			AnchorPane homeView = FXMLLoader.load(getClass().getResource("HomeView.fxml"));
			borderPane.setCenter(homeView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@FXML
	public void handlePageBasicInform(ActionEvent actionEvent) {
		try {
			AnchorPane stuInform = FXMLLoader.load(getClass().getResource("BasicInform.fxml"));
			borderPane.setCenter(stuInform);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	@FXML
	public void handlePageSchoolInform(ActionEvent actionEvent) {
		try {
			AnchorPane schoolInform = FXMLLoader.load(getClass().getResource("SchoolInform.fxml"));
			borderPane.setCenter(schoolInform);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	@FXML
	public void handlePageBreak(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("BreakApply.fxml"));
			borderPane.setCenter(breakApply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	@FXML
	public void handleLoginPage(ActionEvent actionEvent) {
		try {
			AnchorPane loginView = FXMLLoader.load(getClass().getResource("LoginView.fxml"));
			borderPane.setCenter(loginView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@FXML
	public void logoutAlert(ActionEvent actionEvent) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Logout");
		alert.setHeaderText("Logout");
		alert.setContentText("로그아웃 하셨습니다.");
		alert.show();
	}
	

	@FXML // 수강 신청
	public void handlePageSugang(ActionEvent actionEvent) {
		try {
			AnchorPane sugang = FXMLLoader.load(getClass().getResource("SugangView.fxml"));
			borderPane.setCenter(sugang);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	@FXML // 등록금 납부 내역 조회
	public void handlePagePaymentHistory(ActionEvent actionEvent) {
		try {
			AnchorPane historyView = FXMLLoader.load(getClass().getResource("PayHistoryView.fxml"));
			borderPane.setCenter(historyView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			AnchorPane scoreView = FXMLLoader.load(getClass().getResource("ScoreView.fxml"));
			borderPane.setCenter(scoreView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML // 고지서
	public void handlePageBill(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("BackApply.fxml"));
			borderPane.setCenter(breakApply);
		} catch (IOException e) {
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
		}
	}

	
}
