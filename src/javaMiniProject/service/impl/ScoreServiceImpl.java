package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.common.DAO;
import javaMiniProject.model.ScoreTable;



public class ScoreServiceImpl {
	
	ScoreDAO scoreDAO = ScoreDAO.getInstance();

	
	public List<ScoreTable> selectAllTable() {
		Connection conn = DAO.getConnect();
		List<ScoreTable> list = null;
		try {
			list = scoreDAO.selectAllTable(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	

	
}
