package javaMiniProject.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javaMiniProject.common.DAO;
import javaMiniProject.model.TimeSchedule;

public class TimeScheduleServiceImpl {

	private static TimeScheduleServiceImpl instance = new TimeScheduleServiceImpl();

	public static TimeScheduleServiceImpl getInstance() {
		return instance;
	}

	public ArrayList<TimeSchedule> getTimeSchedule() {
		Connection conn = DAO.getConnect();
		ArrayList<TimeSchedule> timeList = new ArrayList<>();
		try {
			timeList = TimeScheduleDAO.getInstance().getTimeSchedule(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timeList;
	}

}
