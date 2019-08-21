package javaMiniProject.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import javaMiniProject.common.DAO;

public class LoginServiceImpl {
	
	private static LoginServiceImpl instance = new LoginServiceImpl();

	public static LoginServiceImpl getInstance() {
		return instance;
	}
	
	public boolean login(int id, int password) throws FileNotFoundException {
		File file = new File("d:/log.txt");
		PrintStream printStream = new PrintStream(new FileOutputStream(file));
		System.setOut(printStream);
		
		Connection conn = DAO.getConnect();
		boolean success = false;
		try {
			success = LoginDAO.getInstance().Login(conn, id, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			DAO.close(conn);
		}
		return success;
	}
	
}
