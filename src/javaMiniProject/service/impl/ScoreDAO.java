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
	
	public List<ScoreTable> selectAllTable(Connection conn) throws SQLException {

		String sql = "SELECT * FROM departments order by 1"; // 리스트에 넣을땐 오더바이!
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ScoreTable score = null;
		List<ScoreTable> list = new ArrayList<>();

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			score = new ScoreTable();
//			dept.setDepartmentId(rs.getInt("department_id"));
//			dept.setDepartmentName(rs.getString("department_name"));
//			dept.setManagerId(rs.getInt("manager_id"));
//			dept.setLocationId(rs.getInt("location_id"));
//			list.add(dept);

		}

		return list;

	}
	
}
