package javaMiniProject.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TimeScheduleTable {
	
	private IntegerProperty start;
	private IntegerProperty end;
	private StringProperty day;

	public TimeScheduleTable() {
		start = new SimpleIntegerProperty();
		end = new SimpleIntegerProperty();
		day = new SimpleStringProperty();
	}
	
	public IntegerProperty startTimeProperty() {
		return start;
	}
	
	public IntegerProperty endTimeProperty() {
		return end;
	}
	
	public StringProperty dayProperty() {
		return day;
	}
	
	// 접근 메서드
	public Integer getStart() {
		return start.get();
	}

	public void setStart(Integer start) {
		this.start.set(start);
	}

	public Integer getEnd() {
		return end.get();
	}

	public void setEnd(Integer end) {
		this.end.set(end);
	}

	public String getDay() {
		return day.get();
	}

	public void setDay(String day) {
		this.day.set(day);
	}
	
}
