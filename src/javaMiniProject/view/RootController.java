package javaMiniProject.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class RootController {

	@FXML BorderPane borderPane;
	@FXML MenuBar menuBar;
	
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
	
	
//============================================================================================================

	@FXML // 시간표
	public void handlePageTimeSchedule(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("BackApply.fxml"));
			borderPane.setCenter(breakApply);
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
	
	@FXML // 수강 신청
	public void handlePageSugang(ActionEvent actionEvent) {
		try {
			AnchorPane breakApply = FXMLLoader.load(getClass().getResource("SugangView.fxml"));
			borderPane.setCenter(breakApply);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML // 등록금 납부 내역 조회
	public void handlePagePaymentHistory(ActionEvent actionEvent) {
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
