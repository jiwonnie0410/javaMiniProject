package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javaMiniProject.ProjectMain;

public class InformationDAO {

	// singletone
	private static InformationDAO instance = new InformationDAO();

	public static InformationDAO getInstance() {
		return instance;
	}
	
	// 기본 정보
	public List<Map<String, Object>> basicInform(Connection conn) throws SQLException {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		String sql = "SELECT S.S_NUMBER, S.S_NAME, S.PHONE, S.ADDRESS, M.MAJOR, IDENTIFICATION, S.GENDER, PICTURE" + 
				" FROM STUDENTS S, MAJORS M" + 
				" WHERE S.MAJOR_NUMBER = M.MAJOR_NUMBER AND S.S_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("studentNumber", ProjectMain.ID);
			map.put("studentName", rs.getString("S_NAME"));
			map.put("phone", rs.getString("PHONE"));
			map.put("address", rs.getString("ADDRESS"));
			map.put("majorName", rs.getString("MAJOR"));
			map.put("identification", rs.getString("IDENTIFICATION"));
			map.put("gender", rs.getString("GENDER"));
			map.put("studentPicture", rs.getString("PICTURE"));
			list.add(map);
			return list;
		}
		else
			return null;
	}
	
	// 학적 정보
	public List<Map<String, Object>> schoolInform(Connection conn) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
		String sql = "SELECT S.S_NUMBER, S.S_NAME, S.COMPLETE, M.MAJOR, S.DEGREE, \r\n" + 
				"(SELECT C.COLLEGE_NAME \r\n" + 
				"FROM COLLEGES C, MAJORS M\r\n" + 
				"WHERE C.COLLEGE_NUMBER = M.COLLEGE_NUMBER\r\n" + 
				"AND M.MAJOR_NUMBER = 10) AS 단대,\r\n" + 
				"(SELECT STATUS\r\n" + 
				"FROM STATUS\r\n" + 
				"WHERE S_NUMBER = ? AND\r\n" + 
				"INDEX_NUMBER=(SELECT MAX(INDEX_NUMBER) FROM STATUS where s_number = ?)) AS STATUS\r\n" + 
				"FROM STUDENTS S, MAJORS M\r\n" + 
				"WHERE S.MAJOR_NUMBER = M.MAJOR_NUMBER AND S.S_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		pstmt.setInt(2, ProjectMain.ID);
		pstmt.setInt(3, ProjectMain.ID);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("studentNumber", ProjectMain.ID);
			map.put("studentName", rs.getString("S_NAME"));
			map.put("status", rs.getString("STATUS"));
			map.put("complete", rs.getString("COMPLETE"));
			map.put("majorName", rs.getString("MAJOR"));
			map.put("degree", rs.getString("DEGREE"));
			map.put("college", rs.getString("단대"));
			list.add(map);
			return list;
		}
		else
			return null;
	}
	
	// 휴학 신청
	public void breakApply(Connection conn, int semester, String reason) throws SQLException {
		String sql = "INSERT INTO STATUS VALUES(?, '휴학', ?, TO_CHAR(SYSDATE, 'YYYY'), ?, BREAK_INDEX.NEXTVAL)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		pstmt.setInt(3, semester);
		pstmt.setString(2, reason);
		
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 휴학 업데이트 완료\n");
	}
	
	// 복학 신청
	public void backApply(Connection conn, int semester) throws SQLException {
		String sql = "INSERT INTO STATUS VALUES(?, '복학', NULL, TO_CHAR(SYSDATE, 'YYYY'), ?, BREAK_INDEX.NEXTVAL)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		pstmt.setInt(2, semester);
		
		int r = pstmt.executeUpdate();
		System.out.println(r + "건 복학 업데이트 완료\n");
	}
}




// 지금 재적 상태 알아보는 방법
//select s_number, status, year, semester
//from status
//where index_number = (select max(index_number)
//        from status) and s_number = 1001;