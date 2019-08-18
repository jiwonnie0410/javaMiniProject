package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.common.DAO;
import javaMiniProject.model.PayHistoryTable;

public class PayHistoryService {

	private static PayHistoryService instance = new PayHistoryService();

	public static PayHistoryService getInstance() {
		return instance;
	}
	
	public List<PayHistoryTable> payHistoryTable() {
		Connection conn = DAO.getConnect();
		List<PayHistoryTable> pList = new ArrayList<PayHistoryTable>();
		try {
			pList = PayHistoryDAO.getInstance().payHistoryTable(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return pList;
	}
	
}
