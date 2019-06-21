package com.cruds.service;

import java.util.List;

import com.cruds.beans.ScheduleBean;
import com.cruds.dao.ScheduleDAO;


public class ScheduleService {

private static ScheduleDAO scheduleDAO;
	
	public ScheduleService() {
		scheduleDAO = new ScheduleDAO();
	}
	
	public void persist(ScheduleBean entity) {
		scheduleDAO.openCurrentSessionwithTransaction();
		scheduleDAO.persist(entity);
		scheduleDAO.closeCurrentSessionwithTransaction();
	}
	
	public void update(ScheduleBean entity) {
		scheduleDAO.openCurrentSessionwithTransaction();
		scheduleDAO.update(entity);
		scheduleDAO.closeCurrentSessionwithTransaction();
	}
	
	public ScheduleBean findById(String id) {
		scheduleDAO.openCurrentSession();
		ScheduleBean user = scheduleDAO.findById(id);
		return user;
	}
	
	public void delete(String Id) {
		scheduleDAO.openCurrentSessionwithTransaction();
		ScheduleBean doctor = scheduleDAO.findById(Id);
		scheduleDAO.delete(doctor);
		scheduleDAO.closeCurrentSessionwithTransaction();
	}
	
	public List<ScheduleBean> listAll(){
		scheduleDAO.openCurrentSession();
		List<ScheduleBean> doctors = scheduleDAO.listAll();
		scheduleDAO.closeCurrentSession();
		return doctors;
	}
}
