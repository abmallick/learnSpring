package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cruds.beans.DoctorBean;

public class DoctorDAO implements DoctorDAOInterface<DoctorBean, String> {
	private Session currentSession;
    private Transaction currentTransaction;
    
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(DoctorBean.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
	public void persist(DoctorBean entity) {
		getCurrentSession().save(entity);
		
	}

	public void update(DoctorBean entity) {
		getCurrentSession().update(entity);
		
	}

	public void delete(DoctorBean entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	public List<DoctorBean> listAll() {
		List<DoctorBean> doctors = (List<DoctorBean>) getCurrentSession().createQuery("from DoctorBean").getResultList();
		return doctors;
	}

	public DoctorBean findById(String id) {
		DoctorBean doctor = (DoctorBean) getCurrentSession().get(DoctorBean.class, id);
		return doctor;
	}

	public boolean authenticate(String id, String pwd) {
		String sql = "from Users where userId = "+id+" and password = "+pwd;
		String name = String.valueOf(getCurrentSession().createQuery(sql));
		if(name.isEmpty())
			return false;
		return true;
	}

}
