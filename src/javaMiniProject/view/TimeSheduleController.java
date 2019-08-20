package javaMiniProject.view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javaMiniProject.model.TimeSchedule;
import javaMiniProject.service.impl.TimeScheduleServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class TimeSheduleController implements Initializable {

	@FXML
	GridPane gridTable;
	@FXML
	ColumnConstraints cl1;
	@FXML
	ColumnConstraints cl2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<TimeSchedule> timeList = new ArrayList<>();
		timeList = TimeScheduleServiceImpl.getInstance().getTimeSchedule();

		for (int i = 0; i < timeList.size(); i++) {
			String day = timeList.get(i).getDay();
			int start = (timeList.get(i).getStart()) - 8;
			int end = (timeList.get(i).getEnd()) - 9;

			Integer random = (int) (Math.random() * 16);
			Integer random2 = (int) (Math.random() * 16);
			Integer random3 = (int) (Math.random() * 16);

			switch (day) {
			case "월":
				for (int j = start; j < end; j++) {
					Label label = new Label();
					label.setMinWidth(105);
					label.setMinHeight(42);
					label.setText(timeList.get(i).getCourse());
					label.setStyle("-fx-background-color: #" + Integer.toHexString(random) + Integer.toHexString(random2)
							+ Integer.toHexString(random3));
					gridTable.add(label, 0, j);
				}
				break;
			case "화":
				for (int j = start; j < end; j++) {
					Label label = new Label();
					label.setMinWidth(105);
					label.setMinHeight(42);
					label.setText(timeList.get(i).getCourse());
					label.setStyle("-fx-background-color: #" + Integer.toHexString(random) + Integer.toHexString(random2)
							+ Integer.toHexString(random3));
					gridTable.add(label, 1, j);
				}
				break;
			case "수":
				for (int j = start; j < end; j++) {
					Label label = new Label();
					label.setMinWidth(105);
					label.setMinHeight(42);
					label.setText(timeList.get(i).getCourse());
					label.setStyle("-fx-background-color: #" + Integer.toHexString(random) + Integer.toHexString(random2)
							+ Integer.toHexString(random3));
					gridTable.add(label, 2, j);
				}
				break;
			case "목":
				for (int j = start; j < end; j++) {
					Label label = new Label();
					label.setMinWidth(105);
					label.setMinHeight(42);
					label.setText(timeList.get(i).getCourse());
					label.setStyle("-fx-background-color: #" + Integer.toHexString(random) + Integer.toHexString(random2)
							+ Integer.toHexString(random3));
					gridTable.add(label, 3, j);
				}
				break;
			case "금":
				for (int j = start; j < end; j++) {
					Label label = new Label();
					label.setMinWidth(105);
					label.setMinHeight(42);
					label.setText(timeList.get(i).getCourse());
					label.setStyle("-fx-background-color: #" + Integer.toHexString(random) + Integer.toHexString(random2)
							+ Integer.toHexString(random3));
					gridTable.add(label, 4, j);
				}
				break;
			}

		}
	}

}
