package com.cruds.beans;


public class ScheduleBean {
	String scheduleId;
	String date;
	String time;
	public ScheduleBean(String scheduleId, String date, String time) {
		super();
		this.scheduleId = scheduleId;
		this.date = date;
		this.time = time;
	}
	public String getScheduleId() {
		return scheduleId;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	
}
