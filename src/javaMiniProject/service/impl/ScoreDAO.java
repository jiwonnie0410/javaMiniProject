package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.ProjectMain;
import javaMiniProject.model.ScoreTable;

public class ScoreDAO {

	private static ScoreDAO instance = new ScoreDAO();

	public static ScoreDAO getInstance() {
		return instance;
	}
	
	public List<ScoreTable> selectTotalScore(Connection conn) throws SQLException {

		String sql = "select rownum as No , su.year, TRUNC(st.complete/2) as grade, c.course_code, c.course_name, c.course_point, su.score\r\n" + 
				"from sugang su, students st, courses c, seq n\r\n" + 
				"where st.s_number = ? AND su.s_number = st.s_number AND su.course_code = c.course_code AND su.score IS NOT NULL AND su.sugang_number=n.seq\r\n" + 
				"order by 1"; // 리스트에 넣을땐 오더바이!
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		
		ScoreTable score = null;
		List<ScoreTable> list = new ArrayList<>();

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			score = new ScoreTable();
			score.setNumber(rs.getInt("No"));
			score.setYear(rs.getInt("year"));
			score.setStudentGrade(rs.getInt("grade"));
			score.setCourseCode(rs.getInt("course_code"));
			score.setCourseName(rs.getString("course_name"));
			score.setCoursePoint(rs.getInt("course_point"));
			score.setGrade(rs.getString("score"));
			
			list.add(score);

//			dept.setDepartmentId(rs.getInt("department_id"));
//			dept.setDepartmentName(rs.getString("department_name"));
//			dept.setManagerId(rs.getInt("manager_id"));
//			dept.setLocationId(rs.getInt("location_id"));
//			list.add(dept);

		}

		return list;

	}
	
	public List<ScoreTable> selectSemesterScore(Connection conn) throws SQLException {

		String sql = "select rownum as No , su.year, TRUNC(st.complete/2) as grade, c.course_code, c.course_name, c.course_point, su.score\r\n" + 
				"from sugang su, students st, courses c, seq n\r\n" + 
				"where st.s_number = ? AND su.s_number = st.s_number AND su.course_code = c.course_code AND su.score IS NOT NULL AND su.sugang_number=n.seq\r\n" + 
				"order by 1"; // sql수정요망
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		
		ScoreTable score = null;
		List<ScoreTable> list = new ArrayList<>();

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			score = new ScoreTable();
			score.setNumber(rs.getInt("No"));
			score.setYear(rs.getInt("year"));
			score.setStudentGrade(rs.getInt("grade"));
			score.setCourseCode(rs.getInt("course_code"));
			score.setCourseName(rs.getString("course_name"));
			score.setCoursePoint(rs.getInt("course_point"));
			score.setGrade(rs.getString("score"));
			
			list.add(score);

		}

		return list;

	}
	
}
