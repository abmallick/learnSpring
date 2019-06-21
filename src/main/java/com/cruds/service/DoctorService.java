package com.cruds.service;

import java.util.List;

import com.cruds.beans.DoctorBean;
import com.cruds.dao.DoctorDAO;

public class DoctorService {
	private static DoctorDAO doctorDAO;
	
	public DoctorService() {
		doctorDAO = new DoctorDAO();
	}
	
	public void persist(DoctorBean entity) {
		doctorDAO.openCurrentSessionwithTransaction();
		doctorDAO.persist(entity);
		doctorDAO.closeCurrentSessionwithTransaction();
	}
	
	public void update(DoctorBean entity) {
		doctorDAO.openCurrentSessionwithTransaction();
		doctorDAO.update(entity);
		doctorDAO.closeCurrentSessionwithTransaction();
	}
	
	public DoctorBean findById(String id) {
		doctorDAO.openCurrentSession();
		DoctorBean doctor = doctorDAO.findById(id);
		return doctor;
	}
	
	public void delete(String Id) {
		doctorDAO.openCurrentSessionwithTransaction();
		DoctorBean doctor = doctorDAO.findById(Id);
		doctorDAO.delete(doctor);
		doctorDAO.closeCurrentSessionwithTransaction();
	}
	
	public List<DoctorBean> listAll(){
		doctorDAO.openCurrentSession();
		List<DoctorBean> doctors = doctorDAO.listAll();
		doctorDAO.closeCurrentSession();
		return doctors;
	}
	
	public boolean authenticate(String id, String pwd) {
		doctorDAO.openCurrentSession();
		boolean val = doctorDAO.authenticate(id, pwd);
		doctorDAO.closeCurrentSession();
		return val;
	}
}
