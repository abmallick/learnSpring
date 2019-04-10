package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cruds.beans.PatientBean;
import com.cruds.beans.UserBean;

public class PatientDAO implements PatientDAOInterface<PatientBean, String>{

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
        Configuration configuration = new Configuration().configure().addAnnotatedClass(PatientBean.class);
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
 
	public void persist(PatientBean entity) {
		getCurrentSession().save(entity);
		
	}

	public void update(PatientBean entity) {
		getCurrentSession().update(entity);
		
	}

	public void delete(PatientBean entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	public List<PatientBean> listAll() {
		List<PatientBean> patient = (List<PatientBean>) getCurrentSession().createQuery("from PatientBean");
		return patient;
	}

	public PatientBean findById(String id) {
		PatientBean patient = (PatientBean) getCurrentSession().get(PatientBean.class, id);
		return patient;
	}

}
