package com.cruds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.cruds.beans.UserBean;

public class UserDAO implements UserDAOInterface<UserBean, String> {
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
        Configuration configuration = new Configuration().configure().addAnnotatedClass(UserBean.class);
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
 
	public void persist(UserBean entity) {
		getCurrentSession().save(entity);
		
	}

	public void update(UserBean entity) {
		getCurrentSession().update(entity);
		
	}

	public void delete(UserBean entity) {
		getCurrentSession().delete(entity);
		
	}

	@SuppressWarnings("unchecked")
	public List<UserBean> listAll() {
		List<UserBean> users = (List<UserBean>) getCurrentSession().createQuery("from Users");
		return users;
	}

	public UserBean findById(String id) {
		UserBean user = (UserBean) getCurrentSession().get(UserBean.class, id);
		return user;
	}

	public String authenticate(String id, String pwd) {
		UserBean user = (UserBean) getCurrentSession().get(UserBean.class, id);
		if(pwd.equals(user.getPassword())) {
			return user.getUserType();
		}
		return "Invalid";
	}

}
