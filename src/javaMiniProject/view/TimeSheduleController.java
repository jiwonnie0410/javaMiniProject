package javaMiniProject.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class TimeSheduleController implements Initializable {
	@FXML ComboBox<String> comboBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> combo = FXCollections.observableArrayList("공개", "회원공개","비공개");
		comboBox.setItems(combo);
	}

}
