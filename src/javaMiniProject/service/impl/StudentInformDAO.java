package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javaMiniProject.model.Colleges;
import javaMiniProject.model.Majors;
import javaMiniProject.model.Students;

public class StudentInformDAO {

	// singletone
	private static StudentInformDAO instance = new StudentInformDAO();

	public static StudentInformDAO getInstance() {
		return instance;
	}
	
	// 기본 정보
	public List<Map<String, Object>> basicInform(Connection conn, int stuNumber) throws SQLException {
		Students stu = new Students();
		Majors major = new Majors();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		String sql = "SELECT S.S_NUMBER, S.S_NAME, S.PHONE, S.ADDRESS, M.MAJOR, IDENTIFICATION S.GENDER" + 
				" FROM STUDENTS S, MAJORS M" + 
				" WHERE S.MAJOR_NUMBER = M.MAJOR_NUMBER AND S.S_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stuNumber);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("studentNumber", stuNumber);
			map.put("studentName", rs.getString("S.S_NAME"));
			map.put("phone", rs.getString("S.PHONE"));
			map.put(key, value)
			
			
			
			
			stu.setStudentNumber(stuNumber); // 학번
			stu.setStudentName(rs.getString("S.S_NAME")); // 이름
			stu.setPhone(rs.getString("S.PHONE")); // 폰번호
			stu.setAddress(rs.getString("S.ADDRESS")); // 주소
			major.setMajorName(rs.getString("M.MAJOR")); // 전공 이름
			stu.setIdentification(rs.getString("IDENTIFICATION")); // 주민번호
			stu.setGender(rs.getString("S.GENDER")); // 성별
			arrayList.add(stu);
			arrayList.add(major);
			return arrayList;
		}
		else
			return null;
	}
	
	// 학적 정보
	public Students schoolInform(Connection conn, int stuNumber) throws SQLException {
		Students stu = new Students();
		Colleges coll = new Colleges();
		Majors major = new Majors();
		
		String sql = "SELECT S.S_NUMBER, S.S_NAME, S.STATUS, S.COMPLETE, M.MAJOR, S.DEGREE," + 
				"        (select c.college_name" + 
				"        from colleges c, majors m" + 
				"        where c.college_number = m.college_number " + 
				"            and m.major_number = 10) as 단대" + 
				" FROM STUDENTS S, MAJORS M\r\n" + 
				" WHERE S.MAJOR_NUMBER = M.MAJOR_NUMBER AND S.S_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stuNumber);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			stu.setStudentNumber(stuNumber); // 학번
			stu.setStudentName(rs.getString("S.S_NAME")); // 이름
			stu.setStatus(rs.getString("S.STATUS")); // 재적상태: 재학 휴학 졸업
			stu.setComplete(rs.getInt("S.COMPLETE")); // 수료학기: 1~8학기
			major.setMajorName(rs.getString("M.MAJOR")); // 전공이름
			stu.setDegree(rs.getString("S.DEGREE")); // 학사 석사 박사
			coll.setCollegeName(rs.getString("단대"));
			return stu;
		}
		else
			return null;
	}
	
	// 휴학 신청
	public void breakApply(Connection conn, int stuNumber) throws SQLException {
		String sql = "UPDATE STUDENTS SET STATUS = '휴학' WHERE S_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stuNumber);
		
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 업데이트 완료~!\n");
	}
	
	// 복학 신청
	public void backApply(Connection conn, int stuNumber) throws SQLException {
		String sql = "UPDATE STUDENTS SET STATUS = '복학' WHERE S_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, stuNumber);
		
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 업데이트 완료~!\n");
	}
	
}
