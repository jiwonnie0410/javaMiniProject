package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javaMiniProject.common.DAO;

public class LoginServiceImpl {
	
	private static LoginServiceImpl instance = new LoginServiceImpl();

	public static LoginServiceImpl getInstance() {
		return instance;
	}
	
	public boolean login(int id, int password) {
		Connection conn = DAO.getConnect();
		boolean success = false;
		try {
			success = LoginDAO.getInstance().Login(conn, id, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return success;
	}
	
}
