package com.cruds.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Schedule")
public class ScheduleBean {
	@Id
	@GeneratedValue
	@Column(name="scheduleId")
	String scheduleId;
	String date;
	String time;
	String doctorId;
	String patientId;
	String ailmentDetails;
	
	
}
