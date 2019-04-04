package com.cruds.beans;

public class PatientBean {
	String patientId;
	String patientName;
	String ailmentDetails;
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
