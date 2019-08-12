package javaMiniProject.model;

public class Courses {

	int courseCode;
	String courseName;
	String timeSchedule;
	int semester;
	int professorNumber;
	int year;
	int coursePoint; // 학점
	int majorNumber;
	int limitNumber; // 제한인원
	
	public int getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTimeSchedule() {
		return timeSchedule;
	}
	public void setTimeSchedule(String timeSchedule) {
		this.timeSchedule = timeSchedule;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public int getProfessorNumber() {
		return professorNumber;
	}
	public void setProfessorNumber(int professorNumber) {
		this.professorNumber = professorNumber;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCoursePoint() {
		return coursePoint;
	}
	public void setCoursePoint(int coursePoint) {
		this.coursePoint = coursePoint;
	}
	public int getMajorNumber() {
		return majorNumber;
	}
	public void setMajorNumber(int majorNumber) {
		this.majorNumber = majorNumber;
	}
	public int getLimitNumber() {
		return limitNumber;
	}
	public void setLimitNumber(int limitNumber) {
		this.limitNumber = limitNumber;
	}
	
}
