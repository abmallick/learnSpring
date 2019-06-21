package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.beans.PatientBean;
@Repository
public class PatientDAO implements PatientDAOInterface<PatientBean, String>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(PatientBean entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
		
	}

	public void update(PatientBean entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();		
		
	}

	public void delete(String patientId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		PatientBean pb =  session.load(PatientBean.class, patientId);
		session.delete(pb);
		tx.commit();
		session.close();		
		
	}
	
	public void delete(PatientBean entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();		
		
	}	

	@SuppressWarnings("unchecked")
	public List<PatientBean> listAll() {
		Session session = sessionFactory.openSession();

		List<PatientBean> patient = (List<PatientBean>) session.createQuery("from PatientBean").getResultList();
		return patient;
	}

	public PatientBean findById(String id) {
		Session session = sessionFactory.openSession();

		PatientBean patient = (PatientBean) session.get(PatientBean.class, id);
		return patient;
	}

}
