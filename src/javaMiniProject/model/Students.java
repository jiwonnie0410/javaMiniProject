package javaMiniProject.model;

public class Students {
	int studentNumber;
	String studentName;
	String status; // 재적상태 재학 휴학 졸업
	int complete; // 수료한 학기
	String identification; // 주민번호
	String phone;
	String address;
	int majorNumber;
	String gender;
	String degree;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMajorNumber() {
		return majorNumber;
	}
	public void setMajorNumber(int majorNumber) {
		this.majorNumber = majorNumber;
	}

}
