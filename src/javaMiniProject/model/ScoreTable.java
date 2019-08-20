package javaMiniProject.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreTable {
	private IntegerProperty number;
	private IntegerProperty year;
	private IntegerProperty studentGrade;
	private IntegerProperty courseCode; // CTRL SHIFT (X, Y) -> 대소문자 변경
	private StringProperty courseName;
	private IntegerProperty coursePoint;
	private StringProperty grade;
//	private IntegerProperty semester;
//	private IntegerProperty sumCPSemester;
//	private IntegerProperty avgCPSemester;

//	public Integer getSemester() {
//		return semester.get();
//	}
//
//	public void setSemester(Integer semester) {
//		this.semester.set(semester);
//	}
//
//	public Integer getSumCPSemester() {
//		return sumCPSemester.get();
//	}
//
//	public void setSumCPSemester(Integer sumCPSemester) {
//		this.sumCPSemester.set(sumCPSemester);
//	}
//
//	public Integer getAvgCPSemester() {
//		return avgCPSemester.get();
//	}
//
//	public void setAvgCPSemester(Integer avgCPSemester) {
//		this.avgCPSemester.set(avgCPSemester);
//	}

	// 생성자(=필드초기화)
	public ScoreTable() {
		number = new SimpleIntegerProperty();
		year = new SimpleIntegerProperty();
		studentGrade = new SimpleIntegerProperty();
		courseCode = new SimpleIntegerProperty();
		courseName = new SimpleStringProperty();
		coursePoint = new SimpleIntegerProperty();
		grade = new SimpleStringProperty();
//		semester = new SimpleIntegerProperty();
//		sumCPSemester = new SimpleIntegerProperty();
//		avgCPSemester = new SimpleIntegerProperty();

	}

	public IntegerProperty numberProperty() {
		return number;
	}

	public IntegerProperty yearProperty() {
		return year;
	}

	public IntegerProperty studentGradeProperty() {
		return studentGrade;
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

	public StringProperty gradeProperty() {
		return grade;
	}
	
//	public IntegerProperty semesterProperty() {
//		return semester;
//	}
//	
//	public IntegerProperty sumCPSemesterProperty() {
//		return sumCPSemester;
//	}
//	
//	public IntegerProperty avgCPSemesterProperty() {
//		return avgCPSemester;
//	}
	
	

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

	public Integer getStudentGrade() {
		return studentGrade.get();
	}

	public void setStudentGrade(Integer studentGrade) {
		this.studentGrade.set(studentGrade);
	}

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
