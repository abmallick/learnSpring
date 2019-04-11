package com.cruds.service;

import java.util.List;

import com.cruds.beans.PatientBean;
import com.cruds.dao.PatientDAO;


public class PatientService {

	private static PatientDAO patientDAO;
	
	public PatientService() {
		patientDAO = new PatientDAO();
	}
	
	public void persist(PatientBean entity) {
		patientDAO.openCurrentSessionwithTransaction();
		patientDAO.persist(entity);
		patientDAO.closeCurrentSessionwithTransaction();
	}
	
	public void update(PatientBean entity) {
		patientDAO.openCurrentSessionwithTransaction();
		patientDAO.update(entity);
		patientDAO.closeCurrentSessionwithTransaction();
	}
	
	public PatientBean findById(String id) {
		patientDAO.openCurrentSession();
		PatientBean user = patientDAO.findById(id);
		return user;
	}
	
	public void delete(String Id) {
		patientDAO.openCurrentSessionwithTransaction();
		PatientBean doctor = patientDAO.findById(Id);
		patientDAO.delete(doctor);
		patientDAO.closeCurrentSessionwithTransaction();
	}
	
	public List<PatientBean> listAll(){
		patientDAO.openCurrentSession();
		List<PatientBean> doctors = patientDAO.listAll();
		patientDAO.closeCurrentSession();
		return doctors;
	}
	
}
