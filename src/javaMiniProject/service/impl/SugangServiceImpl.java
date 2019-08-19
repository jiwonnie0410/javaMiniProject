package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javaMiniProject.common.DAO;
import javaMiniProject.model.CoursesTable;

public class SugangServiceImpl {

	SugangDAO sugangDAO = SugangDAO.getInstance();

	private static SugangServiceImpl instance = new SugangServiceImpl();

	public static SugangServiceImpl getInstance() {
		return instance;
	}

	public List<CoursesTable> selectAllTable() {
		Connection conn = DAO.getConnect();
		List<CoursesTable> list = new ArrayList<>();
		try {
			list = sugangDAO.showAllCourses(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	public void sugangApply(int courseCode, int semester) {
		Connection conn = DAO.getConnect();
		try {
			sugangDAO.sugangApply(conn, courseCode, semester);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
	}

	public List<CoursesTable> selectOneTable(int semester, String major) {
		Connection conn = DAO.getConnect();
		List<CoursesTable> list = new ArrayList<>();
		try {
			list = sugangDAO.showOneCourse(conn, semester, major);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	public List<CoursesTable> CollegeSelected(String collegeName) {
		Connection conn = DAO.getConnect();
		List<CoursesTable> list = new ArrayList<>();
		try {
			list = sugangDAO.onlyCollege(conn, collegeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	public ArrayList<String> majorsFromCollege(String collegeName) {
		Connection conn = DAO.getConnect();
		ArrayList<String> list = new ArrayList<>();
		try {
			list = sugangDAO.majorFromCollege(conn, collegeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}

	public List<CoursesTable> collegeMajor(String majorName) {
		Connection conn = DAO.getConnect();
		List<CoursesTable> list = new ArrayList<>();
		try {
			list = sugangDAO.collegeMajorSelected(conn, majorName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	public List<CoursesTable> allSelect(int semester, String majorName) {
		Connection conn = DAO.getConnect();
		List<CoursesTable> list = new ArrayList<>();
		try {
			list = sugangDAO.getInstance().allSelected(conn, semester, majorName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}
	
	public List<CoursesTable> collegesSemester(int semester, String collegeName) {
		Connection conn = DAO.getConnect();
		List<CoursesTable> list = new ArrayList<>();
		try {
			list = sugangDAO.getInstance().collegeSemester(conn, semester, collegeName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DAO.close(conn);
		}
		return list;
	}
}
