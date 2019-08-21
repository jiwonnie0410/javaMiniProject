package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.ProjectMain;
import javaMiniProject.model.ScoreSemesterTable;
import javaMiniProject.model.ScoreTable;
import javaMiniProject.model.TotalScore;

public class ScoreDAO {

	private static ScoreDAO instance = new ScoreDAO();

	public static ScoreDAO getInstance() {
		return instance;
	}
	
	public List<ScoreTable> selectTotalScore(Connection conn) throws SQLException {

//		String sql = "select rownum as No, su.year, c.course_code, c.course_name, c.course_point, su.score\r\n" + 
//				"from sugang su, students st, courses c\r\n" + 
//				"where st.s_number = ? AND su.s_number = st.s_number AND su.course_code = c.course_code AND su.score IS NOT NULL \r\n" + 
//				"order by 1"; // 리스트에 넣을땐 오더바이!
		
		String sql ="select rownum as No, a.* from\r\n" + 
				"(select su.year, c.course_code, c.course_name, c.course_point, su.score\r\n" + 
				"from sugang su, students st, courses c\r\n" + 
				"where st.s_number = ? AND su.s_number = st.s_number AND su.course_code = c.course_code AND su.score IS NOT NULL \r\n" + 
				"order by su.year)a" ;
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		
		ScoreTable score = null;
		List<ScoreTable> list = new ArrayList<>();

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			score = new ScoreTable();
			score.setNumber(rs.getInt("No"));
			score.setYear(rs.getInt("year"));
//			score.setStudentGrade(rs.getInt("grade"));
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
	
	public List<ScoreSemesterTable> selectSemesterScore(Connection conn) throws SQLException {

		String sql = "select rownum as No, a.* from\r\n" + 
				"(select su.year, su.semester, sum(c.course_point) as score_sum, avg(g.score) as score_avg\r\n" + 
				"from sugang su, grades g, courses c\r\n" + 
				"where g.grade = su.score AND c.course_code = su.course_code AND s_number=?\r\n" + 
				"group by su.s_number, su.semester, su.year\r\n" + 
				"order by su.s_number ASC, su.year ASC)a";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		
		ScoreSemesterTable score = null;
		List<ScoreSemesterTable> list = new ArrayList<>();

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			score = new ScoreSemesterTable();
			score.setNumber2((rs.getInt("No")));
			score.setYear2((rs.getInt("year")));
			score.setSemester((rs.getInt("semester")));
			score.setSumCPSemester((rs.getInt("score_sum")));
			score.setAvgCPSemester((rs.getDouble("score_avg")));
			
			list.add(score);

		}

		return list;

	}
	
//	public List<TotalScore> justTotalScore(Connection conn) throws SQLException {
//
//		String sql = ;
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, ProjectMain.ID);
//		
//		TotalScore score = null;
//		List<TotalScore> list = new ArrayList<>();
//
//		ResultSet rs = pstmt.executeQuery();
//		while (rs.next()) {
////			score = new ScoreSemesterTable();
////			score.setNumber2((rs.getInt("No")));
////			score.setYear2((rs.getInt("year")));
////			score.setSemester((rs.getInt("semester")));
////			score.setSumCPSemester((rs.getInt("score_sum")));
////			score.setAvgCPSemester((rs.getDouble("score_avg")));
//			
//			list.add(score);
//
//		}
//
//		return list;
//
//	}
	
}
