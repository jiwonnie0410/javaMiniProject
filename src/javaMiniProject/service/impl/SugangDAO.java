package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javaMiniProject.ProjectMain;
import javaMiniProject.model.CoursesTable;

public class SugangDAO {

	// singletone
	private static SugangDAO instance = new SugangDAO();

	public static SugangDAO getInstance() {
		return instance;
	}
	
	public List<CoursesTable> onlyCollege(Connection conn, String collegeName) throws SQLException {
		List<CoursesTable> courseList = new ArrayList<>();
		String sql = "SELECT C.COURSE_CODE, C.COURSE_NAME, C.TIME_SCHEDULE, P.P_NAME, C.COURSE_POINT, C.LIMIT_STUDENT" + 
				" FROM COURSES C, PROFESSORS P" + 
				" WHERE C.P_NUMBER = P.P_NUMBER AND (C.MAJOR_NUMBER IN (SELECT MAJOR_NUMBER" + 
				"                                                    FROM MAJORS" + 
				"                                                    WHERE COLLEGE_NUMBER = (SELECT COLLEGE_NUMBER" + 
				"                                                                            FROM COLLEGES" + 
				"                                                                            WHERE COLLEGE_NAME LIKE ?))" + 
				"                                                        OR C.MAJOR_NUMBER IS NULL)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, collegeName);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			CoursesTable cTable = new CoursesTable();
			cTable.setCourseCode(rs.getInt("course_code"));
			cTable.setCourseName(rs.getString("course_name"));
			cTable.setCoursePoint(rs.getInt("course_point"));
			cTable.setProfessorName(rs.getString("p_name"));
			cTable.setTimeSchedule(rs.getString("time_schedule"));
			cTable.setLimitNumber(rs.getInt("limit_student"));
			courseList.add(cTable);
		}
		return courseList;
	}
	
	public ArrayList<String> majorFromCollege(Connection conn, String collegeName) throws SQLException{
		ArrayList<String> mList = new ArrayList<>();
		String sql = "SELECT MAJOR" + 
				" FROM MAJORS" + 
				" WHERE MAJOR_NUMBER IN (SELECT MAJOR_NUMBER" + 
				"                       FROM MAJORS" + 
				"                       WHERE COLLEGE_NUMBER = (SELECT COLLEGE_NUMBER" + 
				"                                               FROM COLLEGES" + 
				"                                               WHERE COLLEGE_NAME LIKE ?))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, collegeName);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			mList.add(rs.getString("major"));
		}
		return mList;
	}

	public void sugangApply(Connection conn, int courseCode, int semester) throws SQLException {
		// 학번, 과목코드, 학기, 연도, 시퀀스, 스코어
		String sql = "INSERT INTO SUGANG VALUES(?, ?, ?, TO_CHAR(sysdate, 'yyyy'), SUGANG_SEQ.NEXTVAL, NULL)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		pstmt.setInt(2, courseCode);
		pstmt.setInt(3, semester);
		int rs = pstmt.executeUpdate();
		System.out.println(rs + "건 신청 완료");
	}

	public List<CoursesTable> showAllCourses(Connection conn) throws SQLException {
		List<CoursesTable> courseList = new ArrayList<>();
		String sql = "SELECT C.COURSE_CODE, C.COURSE_NAME, C.COURSE_POINT,"
				+ "        P.P_NAME, C.TIME_SCHEDULE, C.LIMIT_STUDENT" + " FROM COURSES C, PROFESSORS P"
				+ " WHERE C.P_NUMBER = P.P_NUMBER ORDER BY 1";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			CoursesTable cTable = new CoursesTable();
			cTable.setCourseCode(rs.getInt("course_code"));
			cTable.setCourseName(rs.getString("course_name"));
			cTable.setCoursePoint(rs.getInt("course_point"));
			cTable.setProfessorName(rs.getString("p_name"));
			cTable.setTimeSchedule(rs.getString("time_schedule"));
			cTable.setLimitNumber(rs.getInt("limit_student"));
			courseList.add(cTable);
		}
		return courseList;
	}
	
	public List<CoursesTable> collegeMajorSelected(Connection conn, String majorName) throws SQLException {
		List<CoursesTable> courseList = new ArrayList<>();
		String sql = "SELECT C.COURSE_CODE, C.COURSE_NAME, C.TIME_SCHEDULE, C.SEMESTER, P.P_NAME, C.COURSE_POINT, C.LIMIT_STUDENT" + 
				" FROM COURSES C, PROFESSORS P" + 
				" WHERE C.P_NUMBER = P.P_NUMBER AND" + 
				"        C.MAJOR_NUMBER = (SELECT MAJOR_NUMBER" + 
				"                        FROM MAJORS" + 
				"                        WHERE MAJOR LIKE ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, majorName);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			CoursesTable cTable = new CoursesTable();
			cTable.setCourseCode(rs.getInt("course_code"));
			cTable.setCourseName(rs.getString("course_name"));
			cTable.setCoursePoint(rs.getInt("course_point"));
			cTable.setProfessorName(rs.getString("p_name"));
			cTable.setTimeSchedule(rs.getString("time_schedule"));
			cTable.setLimitNumber(rs.getInt("limit_student"));
			courseList.add(cTable);
		}
		return courseList;
	}

	public List<CoursesTable> showOneCourse(Connection conn, int semester, String major) throws SQLException {
		List<CoursesTable> courseList = new ArrayList<>();
		String sql = "SELECT C.COURSE_CODE, C.COURSE_NAME, C.COURSE_POINT," + 
				"        P.P_NAME, C.TIME_SCHEDULE, C.LIMIT_STUDENT" + 
				" FROM COURSES C, PROFESSORS P" + 
				" WHERE C.P_NUMBER = P.P_NUMBER" + 
				"        AND C.SEMESTER = ?" + 
				"        AND C.MAJOR_NUMBER = (SELECT MAJOR_NUMBER" + 
				"                                FROM MAJORS" + 
				"                                WHERE MAJOR LIKE ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, semester);
		pstmt.setString(2, major);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			CoursesTable cTable = new CoursesTable();
			cTable.setCourseCode(rs.getInt("course_code"));
			cTable.setCourseName(rs.getString("course_name"));
			cTable.setCoursePoint(rs.getInt("course_point"));
			cTable.setProfessorName(rs.getString("p_name"));
			cTable.setTimeSchedule(rs.getString("time_schedule"));
			cTable.setLimitNumber(rs.getInt("limit_student"));
			courseList.add(cTable);
		}
		return courseList;

	}
}
