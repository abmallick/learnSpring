package com.cruds.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Schedule")
public class ScheduleBean {
	@Id
	@Column(name="scheduleId")
	String scheduleId;
	@Column(name="date")
	String date;
	@Column(name="time")
	String time;
	@Column(name="doctorId")
	String doctorId;
	@Column(name="patientId")
	String patientId;
	@Column(name="ailmentDetails")
	String ailmentDetails;
	public ScheduleBean(String scheduleId, String date, String time, String doctorId, String patientId,
			String ailmentDetails) {
		super();
		this.scheduleId = scheduleId;
		this.date = date;
		this.time = time;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.ailmentDetails = ailmentDetails;
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
	public String getDoctorId() {
		return doctorId;
	}
	public String getPatientId() {
		return patientId;
	}
	public String getAilmentDetails() {
		return ailmentDetails;
	}
	@Override
	public String toString() {
		return "ScheduleBean [scheduleId=" + scheduleId + ", date=" + date + ", time=" + time + ", doctorId=" + doctorId
				+ ", patientId=" + patientId + ", ailmentDetails=" + ailmentDetails + "]";
	}
	
	
}
