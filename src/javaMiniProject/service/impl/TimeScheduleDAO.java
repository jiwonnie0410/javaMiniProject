package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javaMiniProject.ProjectMain;
import javaMiniProject.model.TimeSchedule;

public class TimeScheduleDAO {

	private static TimeScheduleDAO instance = new TimeScheduleDAO();

	public static TimeScheduleDAO getInstance() {
		return instance;
	}

	public ArrayList<TimeSchedule> getTimeSchedule(Connection conn) throws SQLException {
		ArrayList<TimeSchedule> timeList = new ArrayList<>();
		String sql = "SELECT C.DAY, C.START_TIME, C.END_TIME, C.COURSE_NAME" + 
						" FROM COURSES C, SUGANG S" + 
						" WHERE S.COURSE_CODE = C.COURSE_CODE" + 
						"        AND S.S_NUMBER = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ProjectMain.ID);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			TimeSchedule ts = new TimeSchedule();
			ts.setCourse(rs.getString("course_name"));
			ts.setDay(rs.getString("day"));
			ts.setStart(rs.getInt("start_time"));
			ts.setEnd(rs.getInt("end_time"));
			timeList.add(ts);
		}
		return timeList;
	}

}
