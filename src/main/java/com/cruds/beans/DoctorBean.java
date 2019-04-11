package com.cruds.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Doctor")
public class DoctorBean {
	@Id
	@Column(name = "doctorId")
	String doctorId;
	
	@Column(name = "doctorName")
	String doctorName;
	
	@Column(name = "specialization")
	String specialization;
	public DoctorBean() {
	}
	public DoctorBean(String doctorId, String doctorName, String specialization) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	
}
