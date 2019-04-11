package com.cruds.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Patient")
public class PatientBean {
	@Id
	@Column(name="patientId")
	String patientId;
	@Column(name="patientName")
	String patientName;
	@Column(name="ailmentDetails")
	String ailmentDetails;
	public PatientBean() {
	}
	public PatientBean(String patientId, String patientName, String ailmentDetails) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.ailmentDetails = ailmentDetails;
	}
	public String getPatientId() {
		return patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public String getAilmentDetails() {
		return ailmentDetails;
	}
	
	
}
