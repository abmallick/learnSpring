package com.cruds.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Doctor")
public class DoctorBean {
	@Id @GeneratedValue
	@Column(name = "doctorId")
	String doctorId;
	
	@Column(name = "doctorName")
	String doctorName;
	
	@Column(name = "specialization")
	String specialization;
	public DoctorBean(String doctorName, String specialization) {
		super();
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
