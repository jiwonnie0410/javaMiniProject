package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javaMiniProject.common.DAO;
import javaMiniProject.service.StudentInformService;

public class InformationServiceImpl implements StudentInformService {
	InformationDAO informDAO = InformationDAO.getInstance();

	// singletone
	private static InformationServiceImpl instance = new InformationServiceImpl();

	public static InformationServiceImpl getInstance() {
		return instance;
	}

	@Override
	public List<Map<String, Object>> basicInform() {
		Connection conn = DAO.getConnect();
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			list = informDAO.basicInform(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> schoolInform() {

		Connection conn = DAO.getConnect();
		List<Map<String, Object>> list = new ArrayList<>();

		try {
			list = informDAO.schoolInform(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	@Override
	public void breakApply(int semester, String reason) {
		Connection conn = DAO.getConnect();
		try {
			informDAO.breakApply(conn, semester, reason);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}

	}

	@Override
	public void backApply(int semester) {

		Connection conn = DAO.getConnect();
		try {
			informDAO.backApply(conn, semester);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
	}

}
