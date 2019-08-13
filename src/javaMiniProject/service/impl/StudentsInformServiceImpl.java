package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javaMiniProject.common.DAO;
import javaMiniProject.model.Students;
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
		Students stu = new Students();
		try {
			stu = informDAO.basicInform(conn, stuNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return null;
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
