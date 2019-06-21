package com.cruds.service;

import java.util.List;

import com.cruds.beans.UserBean;
import com.cruds.dao.UserDAO;

public class UserService {
	
	private static UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public void persist(UserBean entity) {
		userDAO.openCurrentSessionwithTransaction();
		userDAO.persist(entity);
		userDAO.closeCurrentSessionwithTransaction();
	}
	
	public void update(UserBean entity) {
		userDAO.openCurrentSessionwithTransaction();
		userDAO.update(entity);
		userDAO.closeCurrentSessionwithTransaction();
	}
	
	public UserBean findById(String id) {
		userDAO.openCurrentSession();
		UserBean user = userDAO.findById(id);
		return user;
	}
	
	public void delete(String Id) {
		userDAO.openCurrentSessionwithTransaction();
		UserBean doctor = userDAO.findById(Id);
		userDAO.delete(doctor);
		userDAO.closeCurrentSessionwithTransaction();
	}
	
	public List<UserBean> listAll(){
		userDAO.openCurrentSession();
		List<UserBean> doctors = userDAO.listAll();
		userDAO.closeCurrentSession();
		return doctors;
	}
	
	public String authenticate(String id, String pwd) {
		userDAO.openCurrentSession();
		String val = userDAO.authenticate(id, pwd);
		userDAO.closeCurrentSession();
		return val;
	}
}
