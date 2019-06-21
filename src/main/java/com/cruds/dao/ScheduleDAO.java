package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cruds.beans.ScheduleBean;

public class ScheduleDAO implements ScheduleDAOInterface<ScheduleBean, String>{

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
        Configuration configuration = new Configuration().configure().addAnnotatedClass(ScheduleBean.class);
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
 
	public void persist(ScheduleBean entity) {
		getCurrentSession().save(entity);
		
	}

	public void update(ScheduleBean entity) {
		getCurrentSession().update(entity);
		
	}

	public void delete(ScheduleBean entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	public List<ScheduleBean> listAll() {
		List<ScheduleBean> schedule = (List<ScheduleBean>) getCurrentSession().createQuery("from Schdule");
		return schedule;
	}

	public ScheduleBean findById(String id) {
		ScheduleBean schedule = (ScheduleBean) getCurrentSession().get(ScheduleBean.class, id);
		return schedule;
	}

}
