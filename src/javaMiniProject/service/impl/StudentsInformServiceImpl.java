package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javaMiniProject.common.DAO;
import javaMiniProject.service.StudentInformService;

public class StudentsInformServiceImpl implements StudentInformService {
	StudentInformDAO informDAO = StudentInformDAO.getInstance();

	// singletone
	private static StudentsInformServiceImpl instance = new StudentsInformServiceImpl();

	public static StudentsInformServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<Map<String, Object>> basicInform(int stuNum) {
		Connection conn = DAO.getConnect();
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			 list = informDAO.basicInform(conn, stuNum);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> schoolInform(int stuNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void breakApply(int stuNum) {
		// TODO Auto-generated method stub

	}

	@Override
	public void backApply(int stuNum) {
		// TODO Auto-generated method stub

	}

}
