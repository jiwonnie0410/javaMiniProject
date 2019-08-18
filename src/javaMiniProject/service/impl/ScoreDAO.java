package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.model.ScoreTable;

public class ScoreDAO {

	private static ScoreDAO instance = new ScoreDAO();

	public static ScoreDAO getInstance() {
		return instance;
	}
	
	public List<ScoreTable> selectTotalScore(Connection conn) throws SQLException {

		String sql = "SELECT ?.no, su.year, s.semester/2+1 as grade, c.number, c.name, c.point, 성적(대응되는알파벳-테이블따로ㄱㄱ).성적 "
				+ " FROM sugang su, students s, course c, 성적 sc "
				+ "where 조건 "
				+ "order by 1"; // 리스트에 넣을땐 오더바이!
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ScoreTable score = null;
		List<ScoreTable> list = new ArrayList<>();

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			score = new ScoreTable();
			score.setCourseCode(rs.getInt("course_number"));//낼 가서 컬럼이름 맞는지 확인하기 //course codeㅎㅎㅎ
			score.setCourseName(rs.getString("course_name"));
			score.setCoursePoint(rs.getInt("course_point"));
			score.setGrade(grade);
			score.setNumber(number);
			score.setStudentGrade(rs.getInt("student_grade"));
			score.setYear(rs.getInt("sugang_year"));

//			dept.setDepartmentId(rs.getInt("department_id"));
//			dept.setDepartmentName(rs.getString("department_name"));
//			dept.setManagerId(rs.getInt("manager_id"));
//			dept.setLocationId(rs.getInt("location_id"));
//			list.add(dept);

		}

		return list;

	}
	
}
