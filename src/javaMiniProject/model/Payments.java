package javaMiniProject.model;

public class Payments {

	int studentNumber;
	int complete; // 납부한 학기
	String payStatus; // 납부했는지 여부
	int payYear; // 납부한 연도
	String payDate; // 납부한 날짜
	
	public int getStudentName() {
		return studentNumber;
	}
	public void setStudentName(int studentName) {
		this.studentNumber = studentName;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public int getPayYear() {
		return payYear;
	}
	public void setPayYear(int payYear) {
		this.payYear = payYear;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	
}
