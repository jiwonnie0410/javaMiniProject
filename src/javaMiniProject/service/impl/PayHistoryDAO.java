package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.model.PayHistoryTable;

public class PayHistoryDAO {

	// singletone
	private static PayHistoryDAO instance = new PayHistoryDAO();

	public static PayHistoryDAO getInstance() {
		return instance;
	}

	public List<PayHistoryTable> payHistoryTable (Connection conn) throws SQLException {
		List<PayHistoryTable> historyList = new ArrayList<>();
		String sql = "SELECT S_NUMBER, COMPLETE, YEAR, PAYMENT, PAY_DATE" + 
					" FROM MONEY" + 
					" WHERE PAYMENT LIKE '납부'";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			PayHistoryTable pTable = new PayHistoryTable();
			pTable.setStudentNumber(rs.getInt("s_number"));
			pTable.setCompleteSemester(rs.getInt("complete"));
			pTable.setCompleteYear(rs.getInt("year"));
			pTable.setDidPay(rs.getString("payment"));
			pTable.setPayDate(rs.getString("pay_date"));
			historyList.add(pTable);
		}
		return historyList;

	}
}
