package javaMiniProject.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreSemesterTable {

	private IntegerProperty number2;
	private IntegerProperty year2;
	private IntegerProperty semester;
	private IntegerProperty sumCPSemester;
	private DoubleProperty avgCPSemester;

	// 생성자(=필드초기화)
	public ScoreSemesterTable() {

		number2 = new SimpleIntegerProperty();
		year2 = new SimpleIntegerProperty();
		semester = new SimpleIntegerProperty();
		sumCPSemester = new SimpleIntegerProperty();
		avgCPSemester = new SimpleDoubleProperty();

	}

	public Integer getNumber2() {
		return number2.get();
	}

	public void setNumber2(Integer number2) {
		this.number2.set(number2);
	}

	public Integer getYear2() {
		return year2.get();
	}

	public void setYear2(Integer year2) {
		this.year2.set(year2);
	}

	public Integer getSemester() {
		return semester.get();
	}

	public void setSemester(Integer semester) {
		this.semester.set(semester);
	}

	public Integer getSumCPSemester() {
		return sumCPSemester.get();
	}

	public void setSumCPSemester(Integer sumCPSemester) {
		this.sumCPSemester.set(sumCPSemester);
	}

	public Double getAvgCPSemester() {
		return avgCPSemester.get();
	}

	public void setAvgCPSemester(Double avgCPSemester) {
		this.avgCPSemester.set(avgCPSemester);
	}


	public IntegerProperty number2Property() {
		return number2;
	}

	public IntegerProperty year2Property() {
		return year2;
	}

	public IntegerProperty semesterProperty() {
		return semester;
	}

	public IntegerProperty sumCPSemesterProperty() {
		return sumCPSemester;
	}

	public DoubleProperty avgCPSemesterProperty() {
		return avgCPSemester;
	}

	@Override
	public String toString() {
		return "ScoreSemesterTable [number2=" + number2 + ", year2=" + year2 + ", semester=" + semester
				+ ", sumCPSemester=" + sumCPSemester + ", avgCPSemester=" + avgCPSemester + "]";
	}

}
