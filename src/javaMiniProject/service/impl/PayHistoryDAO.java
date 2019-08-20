package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.ProjectMain;
import javaMiniProject.model.PayHistoryTable;

public class PayHistoryDAO {

	// singletone
	private static PayHistoryDAO instance = new PayHistoryDAO();

	public static PayHistoryDAO getInstance() {
		return instance;
	}

	public List<PayHistoryTable> payHistoryTable (Connection conn) throws SQLException {
		List<PayHistoryTable> historyList = new ArrayList<>();
		String sql = "SELECT S_NUMBER, COMPLETE, PAY_YEAR, PAY_STATUS, TO_CHAR(PAY_DATE, 'yyyy/mm/dd') as pay_date" + 
					" FROM PAYMENTS" + 
					" WHERE PAY_STATUS LIKE '납부'";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			PayHistoryTable pTable = new PayHistoryTable();
			pTable.setStudentNumber(ProjectMain.ID);
			pTable.setCompleteSemester(rs.getInt("complete"));
			pTable.setCompleteYear(rs.getInt("PAY_YEAR"));
			pTable.setDidPay(rs.getString("PAY_STATUS"));
			pTable.setPayDate(rs.getString("PAY_DATE"));
			historyList.add(pTable);
		}
		return historyList;

	}
}
