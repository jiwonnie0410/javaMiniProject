package javaMiniProject.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreTable {
	private IntegerProperty number;
	private IntegerProperty year;
//	private IntegerProperty studentGrade;
	private IntegerProperty courseCode; // CTRL SHIFT (X, Y) -> 대소문자 변경
	private StringProperty courseName;
	private IntegerProperty coursePoint;
	private StringProperty grade;
	
	
	
	

	

	// 생성자(=필드초기화)
	public ScoreTable() {
		number = new SimpleIntegerProperty();
		year = new SimpleIntegerProperty();
//		studentGrade = new SimpleIntegerProperty();
		courseCode = new SimpleIntegerProperty();
		courseName = new SimpleStringProperty();
		coursePoint = new SimpleIntegerProperty();
		grade = new SimpleStringProperty();
		

	}

	public IntegerProperty numberProperty() {
		return number;
	}

	public IntegerProperty yearProperty() {
		return year;
	}

//	public IntegerProperty studentGradeProperty() {
//		return studentGrade;
//	}

	public IntegerProperty courseCodeProperty() {
		return courseCode;
	}

	public StringProperty courseNameProperty() {
		return courseName;
	}

	public IntegerProperty coursePointProperty() {
		return coursePoint;
	}

	public StringProperty gradeProperty() {
		return grade;
	}
	
	
	
	

	public Integer getNumber() {
		return number.get();
	}

	public void setNumber(Integer number) {
		this.number.set(number);
		;
	}

	public Integer getYear() {
		return year.get();
	}

	public void setYear(Integer year) {
		this.year.set(year);
	}

//	public Integer getStudentGrade() {
//		return studentGrade.get();
//	}
//
//	public void setStudentGrade(Integer studentGrade) {
//		this.studentGrade.set(studentGrade);
//	}

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

	public String getGrade() {
		return grade.get();
	}

	public void setGrade(String grade) {
		this.grade.set(grade);
	}

	@Override
	public String toString() {
		return "ScoreTable [number=" + number.get();
	}

}
