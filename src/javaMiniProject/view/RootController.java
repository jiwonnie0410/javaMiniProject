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
	
	
	
	
	
}
