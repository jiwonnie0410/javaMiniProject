package javaMiniProject.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CoursesTable {

	// 과목코드, 과목명, 학점, 담당교수, 시간표, 수강여석 --
	private IntegerProperty courseCode;
	private StringProperty courseName;
	private IntegerProperty coursePoint;
	private StringProperty professorName;
	private StringProperty timeSchedule;
	private IntegerProperty limitNumber;

	public CoursesTable() {
		courseCode = new SimpleIntegerProperty();
		courseName = new SimpleStringProperty();
		coursePoint = new SimpleIntegerProperty();
		professorName = new SimpleStringProperty();
		timeSchedule = new SimpleStringProperty();
		limitNumber = new SimpleIntegerProperty();
	}

	public IntegerProperty courseCodeProperty() {
		return courseCode;
	}

	public StringProperty courseNameProperty() {
		return courseName;
	}

	public IntegerProperty coursePointProperty() {
		return coursePoint;
	}

	public StringProperty professorNameProperty() {
		return professorName;
	}

	public StringProperty timeScheduleProperty() {
		return timeSchedule;
	}

	public IntegerProperty limitNumberProperty() {
		return limitNumber;
	}

	// 접근 메서드
	public Integer getCourseCode() {
		return courseCode.get();
	}

	public void setCourseCode(Integer courseCode) {
		this.courseCode.set(courseCode);
	}

	public String getCourseName() {
		return courseName.get();
	}

	public void setCourseName(String courseName) {
		this.courseName.set(courseName);
	}

	public Integer getCoursePoint() {
		return coursePoint.get();
	}

	public void setCoursePoint(Integer coursePoint) {
		this.coursePoint.set(coursePoint);
	}

	public String getProfessorName() {
		return professorName.get();
	}

	public void setProfessorName(String professorName) {
		this.professorName.set(professorName);
	}

	public String getTimeSchedule() {
		return timeSchedule.get();
	}

	public void setTimeSchedule(String timeSchedule) {
		this.timeSchedule.set(timeSchedule);
	}

	public Integer getLimitNumber() {
		return limitNumber.get();
	}

	public void setLimitNumber(Integer limitNumber) {
		this.limitNumber.set(limitNumber);
	}

	@Override
	public String toString() {
		return "CoursesTable [courseCode=" + courseCode + ", courseName=" + courseName + ", coursePoint=" + coursePoint
				+ ", professorName=" + professorName + ", timeSchedule=" + timeSchedule + ", limitNumber=" + limitNumber
				+ "]";
	}

}
