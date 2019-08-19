package javaMiniProject.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class RootController implements Initializable {

	@FXML	BorderPane borderPane;
	@FXML	MenuBar menuBar;
	@FXML	Button btnLogInOut;
	@FXML	Label labelName;
	@FXML	Label labelNim;
	@FXML	Label labelHello;
	@FXML	ImageView imgLogo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		labelHello.setLayoutX(719.0); labelHello.setLayoutY(14.0); labelHello.setPrefHeight(23.0); labelHello.setPrefWidth(73.0);
//		labelHello.setText("안녕하세요!"); labelHello.setVisible(false);
		
//		<Label fx:id="labelHello" layoutX="719.0" layoutY="14.0" prefHeight="23.0" prefWidth="73.0" text="안녕하세요!" visible="false" />
//        <Label fx:id="labelNim" layoutX="871.0" layoutY="14.0" prefHeight="23.0" prefWidth="21.0" text="님" visible="false" />
//        <Label fx:id="labelName" layoutX="792.0" layoutY="14.0" prefHeight="23.0" prefWidth="73.0" visible="false" />
	}
	
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
		}
	}

	@FXML // 성적조회
	public void handlePageShowScore(ActionEvent actionEvent) {
		try {
			AnchorPane scoreView = FXMLLoader.load(getClass().getResource("ScoreView.fxml"));
			borderPane.setCenter(scoreView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	@FXML // 고지서
	public void handlePageBill(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("BackApply.fxml"));
			borderPane.setCenter(breakApply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
