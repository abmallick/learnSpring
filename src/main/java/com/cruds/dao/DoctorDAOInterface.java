package com.cruds.dao;

import java.io.Serializable;
import java.util.List;


public interface DoctorDAOInterface<T, Id extends Serializable> {
	public void persist(T entity);
	public void update(T entity);
	public void delete(T entity);
	public T findById(String id);
	public List<T> listAll();
	public boolean authenticate(String id, String pwd);
}
