package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.common.DAO;
import javaMiniProject.model.ScoreSemesterTable;
import javaMiniProject.model.ScoreTable;
import javaMiniProject.model.TotalScore;



public class ScoreServiceImpl {
	
	ScoreDAO scoreDAO = ScoreDAO.getInstance();
	
	// 싱글톤
		private static ScoreServiceImpl instance = new ScoreServiceImpl();
	
	public static ScoreServiceImpl getInstance() {
		return instance;
	}

	//전체성적조회
	public List<ScoreTable> selectAllTable() {
		Connection conn = DAO.getConnect();
		List<ScoreTable> list = null;
		try {
			list = scoreDAO.selectTotalScore(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	//학기별성적조회
	public List<ScoreSemesterTable> selectSemesterTable() {
		Connection conn = DAO.getConnect();
		List<ScoreSemesterTable> list = null;
		try {
			list = scoreDAO.selectSemesterScore(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	
	//성적집계
	public List<TotalScore> justTotalScore() {
		Connection conn = DAO.getConnect();
		List<TotalScore> list = null;
		try {
			list = scoreDAO.justTotalScore(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	
}
