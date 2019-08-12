package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

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
	public Students basicInform(int stuNum) {
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
		return stu;
	}

	@Override
	public Students schoolInform(int stuNum) {
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
