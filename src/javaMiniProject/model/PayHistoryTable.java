package javaMiniProject.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PayHistoryTable {

	// 학번, 수료학기, 연도, 납부여부, 납부한 날짜
	private IntegerProperty studentNumber;
	private IntegerProperty completeSemester;
	private IntegerProperty completeYear;
	private StringProperty didPay;
	private StringProperty payDate;
	
	public PayHistoryTable() {
		studentNumber = new SimpleIntegerProperty();
		completeSemester = new SimpleIntegerProperty();
		completeYear = new SimpleIntegerProperty();
		didPay = new SimpleStringProperty();
		payDate = new SimpleStringProperty();
	}
	
	public IntegerProperty studentNumberProperty() {
		return studentNumber;
	}
	
	public IntegerProperty completeSemesterProperty() {
		return completeSemester;
	}
	
	public IntegerProperty completeYearProperty() {
		return completeYear;
	}
	
	public StringProperty didPayProperty() {
		return didPay;
	}
	
	public StringProperty payDateProperty() {
		return payDate;
	}
	
	// 접근 메서드
	public Integer getStudentNumber() {
		return studentNumber.get();
	}

	public void setStudentNumber(Integer studentNumber) {
		this.studentNumber.set(studentNumber);
	}

	public Integer getCompleteSemester() {
		return completeSemester.get();
	}

	public void setCompleteSemester(Integer completeSemester) {
		this.completeSemester.set(completeSemester);
	}

	public Integer getCompleteYear() {
		return completeYear.get();
	}

	public void setCompleteYear(Integer completeYear) {
		this.completeYear.set(completeYear);
	}

	public String getDidPay() {
		return didPay.get();
	}

	public void setDidPay(String didPay) {
		this.didPay.set(didPay);
	}

	public String getPayDate() {
		return payDate.get();
	}

	public void setPayDate(String payDate) {
		this.payDate.set(payDate);
	}

	@Override
	public String toString() {
		return "PayHistoryTable [studentNumber=" + studentNumber + ", completeSemester=" + completeSemester
				+ ", completeYear=" + completeYear + ", didPay=" + didPay + ", payDate=" + payDate + "]";
	}
	
	
}
