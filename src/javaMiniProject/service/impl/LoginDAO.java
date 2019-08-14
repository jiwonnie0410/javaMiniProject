package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	// singletone
	private static LoginDAO instance = new LoginDAO();

	public static LoginDAO getInstance() {
		return instance;
	}
	
	public int Login(Connection conn, int id, int passwd) throws SQLException {
		String sql = "select * from login where id=? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.setInt(2, passwd);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			return id;
		}
		else
			return 0;
	}
	
	
}
